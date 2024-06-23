package net.threetag.triadtech.fabric;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.impl.event.interaction.InteractionEventsRouter;
import net.threetag.triadtech.TriadTech;
import net.threetag.triadtech.tweaks.KeyTardisCallTweak;

public final class TriadTechFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        TriadTech.init();

        UseItemCallback.EVENT.register(KeyTardisCallTweak::rightClick);
    }
}
