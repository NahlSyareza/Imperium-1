package net.eszaray.imperium.init;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.entity.client.model.LegionRoundShieldModel;
import net.eszaray.imperium.entity.client.model.LegionShieldModel;
import net.eszaray.imperium.util.ModModelBakery;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
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
    private final EntityModelSet entityModelSet;

    public ModBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.entityModelSet = p_172551_;
    }

    public void onResourceManagerReload(ResourceManager resourceManager) {
        this.legionShieldModel = new LegionShieldModel(this.entityModelSet.bakeLayer(LegionShieldModel.LAYER_LOCATION));
        this.legionRoundShieldModel = new LegionRoundShieldModel(this.entityModelSet.bakeLayer(LegionRoundShieldModel.LAYER_LOCATION));
    }

    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if (stack.is(ModItems.LEGION_SHIELD)) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            Material overlay = ModModelBakery.LEGION_SHIELD_BASE;
            Material base = Sheets.SHIELD_BASE;
            VertexConsumer vertexconsumer = overlay.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.legionShieldModel.renderType(overlay.atlasLocation()), true, stack.hasFoil()));
            this.legionShieldModel.handle().render(poseStack, vertexconsumer, packedLight, packedOverlay);

            this.legionShieldModel.plate().render(poseStack, base.buffer(buffer, RenderType::entitySolid, stack.hasFoil()), packedLight, packedOverlay, DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            this.legionShieldModel.plate().render(poseStack, overlay.buffer(buffer, RenderType::entityCutout, stack.hasFoil()), packedLight, packedOverlay);

            poseStack.popPose();
        } else if (stack.is(ModItems.LEGION_ROUND_SHIELD)) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            Material BASE = ModModelBakery.LEGION_ROUND_SHIELD_BASE;
            Material COLOR = ModModelBakery.ROUND_BASE;
            VertexConsumer vertexconsumer = BASE.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.legionRoundShieldModel.renderType(BASE.atlasLocation()), true, stack.hasFoil()));
            this.legionRoundShieldModel.handle().render(poseStack, vertexconsumer, packedLight, packedOverlay);

            this.legionRoundShieldModel.plate().render(poseStack, COLOR.buffer(buffer, RenderType::entitySolid, stack.hasFoil()), packedLight, packedOverlay, DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            this.legionRoundShieldModel.plate().render(poseStack, BASE.buffer(buffer, RenderType::entityCutout, stack.hasFoil()), packedLight, packedOverlay);

            poseStack.popPose();
        }
    }
}