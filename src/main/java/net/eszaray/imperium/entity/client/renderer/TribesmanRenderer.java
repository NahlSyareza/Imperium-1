package net.eszaray.imperium.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.Tribesman;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;

public class TribesmanRenderer extends LivingEntityRenderer<Tribesman, PlayerRenderState, PlayerModel> {
    public TribesmanRenderer(EntityRendererProvider.Context context, boolean useSlimModel) {
        super(context, new PlayerModel(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), useSlimModel), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel<>(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel<>(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemRenderer()));
    }

    @Override
    protected void scale(PlayerRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerRenderState playerRenderState) {
        return ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "textures/entity/tribesman.png");
    }

    @Override
    public PlayerRenderState createRenderState() {
        return new PlayerRenderState();
    }
}
