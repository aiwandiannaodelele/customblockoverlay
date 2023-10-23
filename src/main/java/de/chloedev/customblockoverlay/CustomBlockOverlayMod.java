package de.chloedev.customblockoverlay;

import de.chloedev.chloelibfabric.io.FileConfig;
import de.chloedev.customblockoverlay.option.OptionManager;
import net.fabricmc.api.ClientModInitializer;

import java.io.File;

public class CustomBlockOverlayMod implements ClientModInitializer {

    private static CustomBlockOverlayMod INSTANCE;
    private FileConfig config;
    private OptionManager optionManager;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        this.config = new FileConfig(new File("./config/customblockoverlay.conf"), false);
        this.optionManager = new OptionManager();
    }

    public FileConfig getConfig() {
        return config;
    }

    public OptionManager getOptionManager() {
        return optionManager;
    }

    public static CustomBlockOverlayMod getInstance() {
        return INSTANCE;
    }
}
