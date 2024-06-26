package net.threetag.triadtech;

import net.minecraft.resources.ResourceLocation;
import net.threetag.triadtech.upgrade.TTUpgrades;

public final class TriadTech {

    public static final String MOD_ID = "triadtech";

    public static void init() {
        TTUpgrades.UPGRADES.registerToModBus();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
