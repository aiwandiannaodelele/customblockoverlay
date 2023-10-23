package de.chloedev.customblockoverlay.ui.screen;

import de.chloedev.chloelibfabric.ui.widget.OptionListWidget;
import de.chloedev.chloelibfabric.util.Color;
import de.chloedev.customblockoverlay.CustomBlockOverlayMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class CustomBlockOverlayConfigScreen extends Screen {

    private final Screen parent;

    public CustomBlockOverlayConfigScreen(Screen parent) {
        super(Text.empty());
        this.parent = parent;
    }

    @Override
    protected void init() {
        // height - 86
        OptionListWidget list = new OptionListWidget(this.width - 158, 8, 150, this.height - 102, 24);
        list.addSingleOptionEntry(CustomBlockOverlayMod.getInstance().getOptionManager().getRedColorOption());
        list.addSingleOptionEntry(CustomBlockOverlayMod.getInstance().getOptionManager().getGreenColorOption());
        list.addSingleOptionEntry(CustomBlockOverlayMod.getInstance().getOptionManager().getBlueColorOption());
        list.addSingleOptionEntry(CustomBlockOverlayMod.getInstance().getOptionManager().getAlphaColorOption());
        this.addDrawableChild(list);
        this.addDrawableChild(ButtonWidget.builder(ScreenTexts.DONE, button -> {
            System.out.println(System.getenv("MODRINTH_TOKEN"));
            this.close();
        }).dimensions(8, this.height - 28, 50, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Save to Configuration"), button -> {
            CustomBlockOverlayMod.getInstance().getConfig().write("color-red", CustomBlockOverlayMod.getInstance().getOptionManager().getRedColorOption().getValue());
            CustomBlockOverlayMod.getInstance().getConfig().write("color-green", CustomBlockOverlayMod.getInstance().getOptionManager().getGreenColorOption().getValue());
            CustomBlockOverlayMod.getInstance().getConfig().write("color-blue", CustomBlockOverlayMod.getInstance().getOptionManager().getBlueColorOption().getValue());
            CustomBlockOverlayMod.getInstance().getConfig().write("color-alpha", CustomBlockOverlayMod.getInstance().getOptionManager().getAlphaColorOption().getValue());
        }).dimensions(62, this.height - 28, 100, 20).build());
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        int r = CustomBlockOverlayMod.getInstance().getOptionManager().getRedColorOption().getValue();
        int g = CustomBlockOverlayMod.getInstance().getOptionManager().getGreenColorOption().getValue();
        int b = CustomBlockOverlayMod.getInstance().getOptionManager().getBlueColorOption().getValue();
        int a = CustomBlockOverlayMod.getInstance().getOptionManager().getAlphaColorOption().getValue();
        context.drawCenteredTextWithShadow(this.textRenderer, "Preview", this.width - 40, this.height - 86, Color.WHITE.toInt());
        context.drawBorder(this.width - 73, this.height - 73, 66, 66, Color.BLACK.toInt());
        context.fill(this.width - 72, this.height - 72, this.width - 8, this.height - 8, new Color(r, g, b, a).toInt());
    }
}
