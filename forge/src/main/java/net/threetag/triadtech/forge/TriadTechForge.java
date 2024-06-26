package net.threetag.triadtech.forge;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.threetag.triadtech.TriadTech;
import net.threetag.triadtech.data.forge.TTLangProvider;

@Mod(TriadTech.MOD_ID)
@Mod.EventBusSubscriber(modid = TriadTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TriadTechForge {

    public TriadTechForge() {
        TriadTech.init();
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        var output = e.getGenerator().getPackOutput();
        e.getGenerator().addProvider(e.includeClient(), new TTLangProvider.English(output));
        e.getGenerator().addProvider(e.includeClient(), new TTLangProvider.German(output));
        e.getGenerator().addProvider(e.includeClient(), new TTLangProvider.Saxon(output));
    }
}
