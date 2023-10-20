package de.chloedev.customblockoverlay;

import net.fabricmc.api.ClientModInitializer;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;

public class CustomBlockOverlayMod implements ClientModInitializer {

    private static CustomBlockOverlayMod INSTANCE;
    private YamlFile config;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        try {
            this.config = new YamlFile(new File("./config/customblockoverlay.yml"));
            this.config.createOrLoadWithComments();
            this.config.addDefault("color", "0.0:0.0:0.0:102.0");
            this.config.save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public YamlFile getConfig() {
        return config;
    }

    public static CustomBlockOverlayMod getInstance() {
        return INSTANCE;
    }
}
