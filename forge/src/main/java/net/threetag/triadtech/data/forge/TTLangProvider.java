package net.threetag.triadtech.data.forge;

import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.threetag.triadtech.TriadTech;
import net.threetag.triadtech.upgrade.TTUpgrades;
import whocraft.tardis_refined.common.capability.tardis.upgrades.Upgrade;
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
            this.addUpgrade(TTUpgrades.BLUE_STABILIZERS.get(), "Blue Stabilizers", "With this upgrade, flight dances will no longer happen when you travel with the throttle at its lowest stage.");
        }
    }

    public static class German extends TTLangProvider {

        public German(PackOutput output) {
            super(output, "de_de");
        }

        @Override
        protected void addTranslations() {
            this.addUpgrade(TTUpgrades.EMERGENCY_EXIT.get(), "Notfall-Flucht", "Erlaubt es dir deine TARDIS mit deinem Schlüssel zu rufen. Allerdings geht der Schlüssel dabei kaputt.");
            this.addUpgrade(TTUpgrades.BLUE_STABILIZERS.get(), "Blaue Stabilisatoren", "Mit diesem Upgrade kannst du ohne Probleme reisen während der Schubregler auf der niedrigsten Stufe ist.");
        }
    }

    public static class Saxon extends TTLangProvider {

        public Saxon(PackOutput output) {
            super(output, "sxu");
        }

        @Override
        protected void addTranslations() {
            this.addUpgrade(TTUpgrades.EMERGENCY_EXIT.get(), "Notfall-Flucht", "Erlaubt's dir dehne TARDIS mit dehnem Schlüssel zu rufen. Allerdings jeht der Schlüssel dabeh gapud.");
            this.addUpgrade(TTUpgrades.BLUE_STABILIZERS.get(), "Bloe Stabilisatoren", "Mit diesem Upgrade gannste ohne Probleme reisen während dor Schubrechler auf dor niedrischsten Stufe is.");
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
