package de.chloedev.customblockoverlay.option;

import de.chloedev.chloelibfabric.io.FileConfig;
import de.chloedev.chloelibfabric.util.ActionUtil;
import de.chloedev.customblockoverlay.CustomBlockOverlayMod;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class OptionManager {

    private final SimpleOption<Integer> redColorOption;
    private final SimpleOption<Integer> greenColorOption;
    private final SimpleOption<Integer> blueColorOption;
    private final SimpleOption<Integer> alphaColorOption;

    public OptionManager() {
        FileConfig config = CustomBlockOverlayMod.getInstance().getConfig();
        this.redColorOption = new SimpleOption<>("Red", SimpleOption.emptyTooltip(), (text, value) -> Text.literal("Red: " + value), new SimpleOption.ValidatingIntSliderCallbacks(0, 255), config.readInt("color-red", 0), ActionUtil::doNothing);
        this.greenColorOption = new SimpleOption<>("Green", SimpleOption.emptyTooltip(), (text, value) -> Text.literal("Green: " + value), new SimpleOption.ValidatingIntSliderCallbacks(0, 255), config.readInt("color-green", 0), ActionUtil::doNothing);
        this.blueColorOption = new SimpleOption<>("Blue", SimpleOption.emptyTooltip(), (text, value) -> Text.literal("Blue: " + value), new SimpleOption.ValidatingIntSliderCallbacks(0, 255), config.readInt("color-blue", 0), ActionUtil::doNothing);
        this.alphaColorOption = new SimpleOption<>("Alpha", SimpleOption.emptyTooltip(), (text, value) -> Text.literal("Alpha: " + value), new SimpleOption.ValidatingIntSliderCallbacks(0, 255), config.readInt("color-alpha", 102), ActionUtil::doNothing);
    }

    public SimpleOption<Integer> getRedColorOption() {
        return redColorOption;
    }

    public SimpleOption<Integer> getGreenColorOption() {
        return greenColorOption;
    }

    public SimpleOption<Integer> getBlueColorOption() {
        return blueColorOption;
    }

    public SimpleOption<Integer> getAlphaColorOption() {
        return alphaColorOption;
    }
}
