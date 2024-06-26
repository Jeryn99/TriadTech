package net.threetag.triadtech.data.forge;

import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.threetag.triadtech.TriadTech;
import net.threetag.triadtech.upgrade.TTUpgrades;
import whocraft.tardis_refined.common.capability.upgrades.Upgrade;
import whocraft.tardis_refined.registry.TRUpgrades;

public abstract class TTLangProvider extends LanguageProvider {

    public TTLangProvider(PackOutput output, String locale) {
        super(output, TriadTech.MOD_ID, locale);
    }

    public static class English extends TTLangProvider {

        public English(PackOutput output) {
            super(output, "en_us");
        }

        @Override
        protected void addTranslations() {
            this.addUpgrade(TTUpgrades.EMERGENCY_EXIT.get(), "Emergency Exit", "Allows you to spawn your TARDIS when using the key. However, the key breaks during this.");
        }
    }

    public static class German extends TTLangProvider {

        public German(PackOutput output) {
            super(output, "de_de");
        }

        @Override
        protected void addTranslations() {
            this.addUpgrade(TTUpgrades.EMERGENCY_EXIT.get(), "Notfall-Flucht", "Erlaubt es dir deine TARDIS mit deinem Schlüssel zu rufen. Allerdings geht der Schlüssel dabei kaputt.");
        }
    }

    public static class Saxon extends TTLangProvider {

        public Saxon(PackOutput output) {
            super(output, "sxu");
        }

        @Override
        protected void addTranslations() {
            this.addUpgrade(TTUpgrades.EMERGENCY_EXIT.get(), "Notfall-Flucht", "Erlaubt's dir dehne TARDIS mit dehnem Schlüssel zu rufen. Allerdings jeht der Schlüssel dabeh gapud.");
        }
    }

    @Override
    public String getName() {
        return "TriadTech " + super.getName();
    }

    public void addUpgrade(Upgrade upgrade, String title, String description) {
        this.add(Util.makeDescriptionId("upgrade", TRUpgrades.UPGRADE_DEFERRED_REGISTRY.getKey(upgrade)), title);
        this.add(Util.makeDescriptionId("upgrade", TRUpgrades.UPGRADE_DEFERRED_REGISTRY.getKey(upgrade)) + ".description", description);
    }
}
