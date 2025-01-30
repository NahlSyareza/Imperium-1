package net.eszaray.imperium.entity.client.renderer;

import net.eszaray.imperium.Imperium;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;

public class VeteranLegionaryRenderer extends LegionaryRenderer{
    public VeteranLegionaryRenderer(EntityRendererProvider.Context context, boolean useSlimModel) {
        super(context, useSlimModel);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerRenderState playerRenderState) {
        return ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "textures/entity/veteran_legionary.png");
    }
}
