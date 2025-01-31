package net.eszaray.imperium.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.Imperium;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class TribalOrnateShieldModel extends Model {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "tribal_ornate_shield"), "main");
    private final ModelPart plate;
    private final ModelPart handle;
    private final ModelPart root;

    public TribalOrnateShieldModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.root = root;
        this.plate = root.getChild("plate");
        this.handle = root.getChild("handle");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition plate = partdefinition.addOrReplaceChild("plate", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-8.0F, -12.0F, -2.0F, 16.0F, 8.0F, 1.0F)
                .texOffs(0, 18).addBox(-6.0F, -4.0F, -2.0F, 12.0F, 8.0F, 1.0F)
                .texOffs(0, 9).addBox(-8.0F, 4.0F, -2.0F, 16.0F, 8.0F, 1.0F), PartPose.ZERO);

        PartDefinition handle = partdefinition.addOrReplaceChild("handle", CubeListBuilder.create()
                .texOffs(34, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart plate() {
        return plate;
    }

    public ModelPart handle() {
        return handle;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        this.root.render(poseStack, vertexConsumer, i, i1, i2);
    }
}