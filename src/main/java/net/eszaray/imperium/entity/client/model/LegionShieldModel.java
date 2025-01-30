package net.eszaray.imperium.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.Imperium;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class LegionShieldModel extends Model {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "legion_shield"), "main");
    private static final String PLATE = "plate";
    private static final String HANDLE = "handle";
    private static final int SHIELD_WIDTH = 10;
    private static final int SHIELD_HEIGHT = 20;
    private final ModelPart root;
    private final ModelPart plate;
    private final ModelPart handle;

    public LegionShieldModel(ModelPart root) {
        super(root, RenderType::entitySolid);
        this.root = root;
        this.plate = root.getChild("plate");
        this.handle = root.getChild("handle");
    }

    public ModelPart plate() {
        return this.plate;
    }

    public ModelPart handle() {
        return this.handle;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -12.0F, -2.0F, 14.0F, 24.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}