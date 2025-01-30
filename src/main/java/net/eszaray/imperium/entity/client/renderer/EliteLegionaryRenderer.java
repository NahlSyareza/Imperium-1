package net.eszaray.imperium.entity.client.renderer;

import net.eszaray.imperium.Imperium;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;

public class EliteLegionaryRenderer extends LegionaryRenderer{
    public EliteLegionaryRenderer(EntityRendererProvider.Context context, boolean useSlimModel) {
        super(context, useSlimModel);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerRenderState playerRenderState) {
        return ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "textures/entity/elite_legionary.png");
    }
}
