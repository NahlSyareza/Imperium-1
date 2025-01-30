package net.eszaray.imperium.entity.client.model;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eszaray.imperium.Imperium;
import net.minecraft.ResourceLocationException;
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

public class TribalShieldModel extends Model {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "tribal_shield"), "main");
    private final ModelPart plate;
    private final ModelPart handle;
    private final ModelPart root;

    public TribalShieldModel(ModelPart root) {
        super(root, RenderType::entitySolid);
        this.root = root;
        this.plate = root.getChild("plate");
        this.handle = root.getChild("handle");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 5).addBox(-6.0F, -7.0F, -2.0F, 12.0F, 14.0F, 1.0F).texOffs(1, 0).addBox(-5.0F, -11.0F, -2.0F, 10.0F, 4.0F, 1.0F).texOffs(1, 20).addBox(-5.0F, 7.0F, -2.0F, 10.0F, 4.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart handle() {
        return handle;
    }

    public ModelPart plate() {
        return plate;
    }
}