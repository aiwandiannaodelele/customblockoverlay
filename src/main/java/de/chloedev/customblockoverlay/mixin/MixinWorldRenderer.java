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
        int red = CustomBlockOverlayMod.getInstance().getOptionManager().getRedColorOption().getValue();
        int green = CustomBlockOverlayMod.getInstance().getOptionManager().getGreenColorOption().getValue();
        int blue = CustomBlockOverlayMod.getInstance().getOptionManager().getBlueColorOption().getValue();
        int alpha = CustomBlockOverlayMod.getInstance().getOptionManager().getAlphaColorOption().getValue();

        args.set(6, (red / 255.0f));
        args.set(7, (green / 255.0f));
        args.set(8, (blue / 255.0f));
        args.set(9, (alpha / 255.0f));
    }
}
