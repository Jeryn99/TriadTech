package net.threetag.triadtech.mixin;

import net.threetag.triadtech.upgrade.TTUpgrades;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.capability.TardisLevelOperator;
import whocraft.tardis_refined.common.tardis.manager.FlightDanceManager;

@Mixin(FlightDanceManager.class)
public class FlightDanceManagerMixin {

    @Shadow
    private TardisLevelOperator operator;

    @Inject(method = "triggerNextEvent", at = @At("HEAD"), remap = false, cancellable = true)
    private void startFlightDance(CallbackInfo ci) {
        if (this.operator.getUpgradeHandler().isUpgradeUnlocked(TTUpgrades.BLUE_STABILIZERS.get()) && this.operator.getPilotingManager().getThrottleStage() <= 1) {
            ci.cancel();
        }
    }

}
