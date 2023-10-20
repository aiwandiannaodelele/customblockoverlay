package de.chloedev.customblockoverlay.mixin;

import de.chloedev.customblockoverlay.CustomBlockOverlayMod;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {

    @ModifyArgs(method = "drawBlockOutline", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;drawCuboidShapeOutline(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/util/shape/VoxelShape;DDDFFFF)V"))
    public void setOutlineColor(Args args) {
        String color = CustomBlockOverlayMod.getInstance().getConfig() == null ? "0.0:0.0:0.0:102.0" : CustomBlockOverlayMod.getInstance().getConfig().getString("color", "0.0:0.0:0.0:102.0");
        String[] s = color.split(":");
        float red = Float.parseFloat(s[0]);
        float green = Float.parseFloat(s[1]);
        float blue = Float.parseFloat(s[2]);
        float alpha = Float.parseFloat(s[3]);

        args.set(6, (red / 255.0f));
        args.set(7, (green / 255.0f));
        args.set(8, (blue / 255.0f));
        args.set(9, (alpha / 255.0f));
    }
}
