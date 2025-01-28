package net.eszaray.imperium.init;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.client.model.LegionShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

/*
BIG THANKS TO Rajhab ON CURSEFORGE
 */

//@EventBusSubscriber(value = Dist.CLIENT, modid = NeoRome.MODID, bus = Bus.MOD)
public class ModBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {
    public static ModBlockEntityWithoutLevelRenderer instance;
    private LegionShieldModel shieldModel;
    private final EntityModelSet entityModelSet;
    public static final Material OVERLAY = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID,"entity/legion_shield_overlay"));

    public ModBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        this.entityModelSet = p_172551_;
    }

    public void onResourceManagerReload(ResourceManager resourceManager) {
        this.shieldModel = new LegionShieldModel(this.entityModelSet.bakeLayer(LegionShieldModel.LAYER_LOCATION));
    }

    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if (stack.is(ModItems.LEGION_SHIELD)) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            Material overlay = OVERLAY;
            Material base = Sheets.SHIELD_BASE;
            VertexConsumer vertexconsumer = overlay.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.shieldModel.renderType(overlay.atlasLocation()), true, stack.hasFoil()));
            this.shieldModel.handle().render(poseStack, vertexconsumer, packedLight, packedOverlay);

            this.shieldModel.plate().render(poseStack, base.buffer(buffer, RenderType::entitySolid, stack.hasFoil()), packedLight, packedOverlay, DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            this.shieldModel.plate().render(poseStack, overlay.buffer(buffer, RenderType::entityCutout, stack.hasFoil()), packedLight, packedOverlay);

            poseStack.popPose();
        }
    }
}