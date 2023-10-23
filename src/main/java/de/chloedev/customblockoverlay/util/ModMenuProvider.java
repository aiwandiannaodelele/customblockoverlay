package de.chloedev.customblockoverlay.util;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import de.chloedev.customblockoverlay.ui.screen.CustomBlockOverlayConfigScreen;

public class ModMenuProvider implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return CustomBlockOverlayConfigScreen::new;
    }
}
