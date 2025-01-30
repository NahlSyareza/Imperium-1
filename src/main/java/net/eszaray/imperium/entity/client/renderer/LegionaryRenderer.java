package net.eszaray.imperium.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.Legionary;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class LegionaryRenderer extends LivingEntityRenderer<Legionary, PlayerRenderState, PlayerModel> {
    public LegionaryRenderer(EntityRendererProvider.Context context, boolean useSlimModel) {
        super(context, new PlayerModel(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), useSlimModel), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel<>(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel<>(context.bakeLayer(useSlimModel ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
        this.addLayer(new PlayerItemInHandLayer<>(this, context.getItemRenderer()));
    }

    @Override
    protected boolean shouldShowName(Legionary entity, double distanceToCameraSq) {
        return entity.isCustomNameVisible();
    }

    @Override
    public void render(PlayerRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    private void extractHandState(Legionary entity, PlayerRenderState.HandState reusedState, InteractionHand hand) {
        ItemStack itemstack = entity.getItemInHand(hand);
        reusedState.isEmpty = itemstack.isEmpty();
        reusedState.useAnimation = !itemstack.isEmpty() ? itemstack.getUseAnimation() : null;
        reusedState.holdsChargedCrossbow = itemstack.getItem() instanceof CrossbowItem && CrossbowItem.isCharged(itemstack);
        reusedState.customArmPose = IClientItemExtensions.of(itemstack).getArmPose(entity, hand, itemstack);
    }

    @Override
    public void extractRenderState(Legionary entity, PlayerRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        HumanoidMobRenderer.extractHumanoidRenderState(entity, reusedState, partialTick);
        this.extractHandState(entity, reusedState.mainHandState, InteractionHand.MAIN_HAND);
        this.extractHandState(entity, reusedState.offhandState, InteractionHand.OFF_HAND);
    }

    @Override
    protected void scale(PlayerRenderState renderState, PoseStack poseStack) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerRenderState playerRenderState) {
        return ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "textures/entity/legionary.png");
    }

    @Override
    public PlayerRenderState createRenderState() {
        return new PlayerRenderState();
    }
}
