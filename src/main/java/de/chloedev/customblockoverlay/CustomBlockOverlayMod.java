package de.chloedev.customblockoverlay;

import de.chloedev.customblockoverlay.option.OptionManager;
import de.chloedev.kianalibfabric.io.FileConfiguration;
import net.fabricmc.api.ClientModInitializer;

import java.io.File;

public class CustomBlockOverlayMod implements ClientModInitializer {

    private static CustomBlockOverlayMod INSTANCE;
    private FileConfiguration config;
    private OptionManager optionManager;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        this.config = new FileConfiguration(new File("./config/customblockoverlay.conf"));
        this.optionManager = new OptionManager();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public OptionManager getOptionManager() {
        return optionManager;
    }

    public static CustomBlockOverlayMod getInstance() {
        return INSTANCE;
    }
}
