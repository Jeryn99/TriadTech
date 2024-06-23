package net.threetag.triadtech.tweaks;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import whocraft.tardis_refined.common.capability.TardisLevelOperator;
import whocraft.tardis_refined.common.items.KeyItem;
import whocraft.tardis_refined.common.tardis.TardisNavLocation;
import whocraft.tardis_refined.common.tardis.manager.TardisPilotingManager;
import whocraft.tardis_refined.common.util.DimensionUtil;
import whocraft.tardis_refined.common.util.Platform;
import whocraft.tardis_refined.common.util.PlayerUtil;
import whocraft.tardis_refined.constants.ModMessages;

import java.util.ArrayList;
import java.util.Optional;

public class KeyTardisCallTweak {

    public static InteractionResultHolder<ItemStack> rightClick(Player player, Level level, InteractionHand hand) {
        var stack = player.getItemInHand(hand);

        if (!stack.isEmpty() && stack.getItem() instanceof KeyItem && level instanceof ServerLevel serverLevel) {
            ArrayList<ResourceKey<Level>> keyChain = KeyItem.getKeychain(stack);
            var pos = player.blockPosition();

            if (!keyChain.isEmpty()) {
                ResourceKey<Level> dimension = keyChain.get(0);
                if (level.isEmptyBlock(pos.above()) && DimensionUtil.isAllowedDimension(level.dimension())) {
                    ServerLevel tardisLevel = Platform.getServer().getLevel(dimension);
                    Optional<TardisLevelOperator> operatorOptional = TardisLevelOperator.get(tardisLevel);

                    if (operatorOptional.isEmpty()) {
                        return InteractionResultHolder.pass(stack);
                    }

                    TardisLevelOperator operator = operatorOptional.get();
                    TardisPilotingManager pilotManager = operator.getPilotingManager();

                    if (pilotManager.beginFlight(true, null) && !pilotManager.isOnCooldown()) {
                        pilotManager.setTargetLocation(new TardisNavLocation(pos.above(), player.getDirection().getOpposite(), serverLevel));
                        level.playSound(null, pos, SoundEvents.PLAYER_LEVELUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                        PlayerUtil.sendMessage(player, Component.translatable(ModMessages.TARDIS_IS_ON_THE_WAY), true);
                        stack.shrink(1);
                        return InteractionResultHolder.success(stack);
                    }
                }
            }
        }

        return InteractionResultHolder.pass(stack);
    }

}
