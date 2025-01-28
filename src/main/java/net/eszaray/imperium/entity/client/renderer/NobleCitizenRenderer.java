package net.eszaray.imperium.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.NobleCitizen;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

public class NobleCitizenRenderer extends LivingEntityRenderer<NobleCitizen, PlayerModel<NobleCitizen>> {
    public NobleCitizenRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(NobleCitizen nobleCitizen) {
        return ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "textures/entity/noble_citizen.png");
    }

    @Override
    public void render(NobleCitizen entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected boolean shouldShowName(NobleCitizen entity) {
        return false;
    }
}
