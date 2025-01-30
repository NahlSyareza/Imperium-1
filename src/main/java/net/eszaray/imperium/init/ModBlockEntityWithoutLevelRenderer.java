package net.eszaray.imperium.init;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.entity.client.model.LegionRoundShieldModel;
import net.eszaray.imperium.entity.client.model.LegionShieldModel;
import net.eszaray.imperium.entity.client.model.TribalShieldModel;
import net.eszaray.imperium.util.ModModelBakery;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

/*
BIG THANKS TO Rajhab ON CURSEFORGE
 */

public class ModBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {
    public static ModBlockEntityWithoutLevelRenderer instance;
    private LegionShieldModel legionShieldModel;
    private LegionRoundShieldModel legionRoundShieldModel;
    private TribalShieldModel tribalShieldModel;
    private final EntityModelSet entityModelSet;

    public ModBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.entityModelSet = p_172551_;
    }

    public void onResourceManagerReload(ResourceManager resourceManager) {
        this.legionShieldModel = new LegionShieldModel(this.entityModelSet.bakeLayer(LegionShieldModel.LAYER_LOCATION));
        this.legionRoundShieldModel = new LegionRoundShieldModel(this.entityModelSet.bakeLayer(LegionRoundShieldModel.LAYER_LOCATION));
        this.tribalShieldModel = new TribalShieldModel(this.entityModelSet.bakeLayer(TribalShieldModel.LAYER_LOCATION));
    }

    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack posestack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if (stack.is(ModItems.LEGION_SHIELD)) {
            posestack.pushPose();
            posestack.scale(1.0F, -1.0F, -1.0F);
            Material base = ModModelBakery.LEGION_SHIELD_BASE;
            Material overlay = ModModelBakery.BASE;
            VertexConsumer vertexconsumer = base.sprite().wrap(ItemRenderer.getFoilBuffer(buffer, this.legionShieldModel.renderType(base.atlasLocation()), true, stack.hasFoil()));
            this.legionShieldModel.handle().render(posestack, vertexconsumer, packedLight, packedOverlay);

            this.legionShieldModel.plate().render(posestack, overlay.buffer(buffer, RenderType::entitySolid, false, stack.hasFoil()), packedLight, packedOverlay, DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            this.legionShieldModel.plate().render(posestack, base.buffer(buffer, RenderType::entityCutout, false, stack.hasFoil()), packedLight, packedOverlay);

            posestack.popPose();
        } else if (stack.is(ModItems.LEGION_ROUND_SHIELD)) {
            posestack.pushPose();
            posestack.scale(1.0F, -1.0F, -1.0F);
            Material base = ModModelBakery.LEGION_ROUND_SHIELD_BASE;
            Material overlay = ModModelBakery.ROUND_BASE;
            VertexConsumer vertexconsumer = base.sprite().wrap(ItemRenderer.getFoilBuffer(buffer, this.legionRoundShieldModel.renderType(base.atlasLocation()), true, stack.hasFoil()));
            this.legionRoundShieldModel.handle().render(posestack, vertexconsumer, packedLight, packedOverlay);

            this.legionRoundShieldModel.plate().render(posestack, overlay.buffer(buffer, RenderType::entitySolid, false, stack.hasFoil()), packedLight, packedOverlay, DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            this.legionRoundShieldModel.plate().render(posestack, base.buffer(buffer, RenderType::entityCutout, false, stack.hasFoil()), packedLight, packedOverlay);

            posestack.popPose();
        } else if (stack.is(ModItems.TRIBAL_SHIELD)) {
            RenderBuffers renderBuffers = Minecraft.getInstance().renderBuffers();

            posestack.pushPose();
            posestack.scale(1.0F, -1.0F, -1.0F);
            Material base = ModModelBakery.TRIBAL_SHIELD_BASE;
            VertexConsumer vertexconsumer = base.sprite().wrap(ItemRenderer.getFoilBuffer(renderBuffers.bufferSource(), this.tribalShieldModel.renderType(base.atlasLocation()), true, stack.hasFoil()));
            this.tribalShieldModel.handle().render(posestack, vertexconsumer, packedLight, packedOverlay);
            this.tribalShieldModel.plate().render(posestack, vertexconsumer, packedLight, packedOverlay);

            posestack.popPose();
        }
    }
}