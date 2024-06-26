package net.threetag.triadtech.upgrade;

import net.threetag.triadtech.TriadTech;
import whocraft.tardis_refined.common.capability.upgrades.Upgrade;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;
import whocraft.tardis_refined.registry.TRItemRegistry;
import whocraft.tardis_refined.registry.TRUpgrades;

public class TTUpgrades {

    public static final DeferredRegistry<Upgrade> UPGRADES = DeferredRegistry.create(TriadTech.MOD_ID, TRUpgrades.UPGRADE_REGISTRY_KEY);

    public static final RegistrySupplier<Upgrade> EMERGENCY_EXIT = UPGRADES.register("emergency_exit", () -> new Upgrade(
            () -> TRItemRegistry.KEY.get().getDefaultInstance(),
            TRUpgrades.MATERIALIZE_AROUND,
            TriadTech.id("emergency_exit"),
            Upgrade.UpgradeType.MAIN_UPGRADE)
            .setPosition(1, 3)
            .setSkillPointsRequired(15));

}
