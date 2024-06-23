package net.threetag.triadtech.forge;

import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.threetag.triadtech.TriadTech;
import net.threetag.triadtech.tweaks.KeyTardisCallTweak;

@Mod.EventBusSubscriber(modid = TriadTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TriadTechEventHandler {

    @SubscribeEvent
    public static void rightClickItem(PlayerInteractEvent.RightClickItem e) {
        var result = KeyTardisCallTweak.rightClick(e.getEntity(), e.getLevel(), e.getHand());

        if (result.getResult() != InteractionResult.PASS) {
            e.setCancellationResult(result.getResult());
            e.setCanceled(true);
        }
    }

}
