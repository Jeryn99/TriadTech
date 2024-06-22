package net.threetag.triadtech.fabric;

import net.fabricmc.api.ModInitializer;

import net.threetag.triadtech.TriadTech;

public final class TriadTechFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        TriadTech.init();
    }
}
