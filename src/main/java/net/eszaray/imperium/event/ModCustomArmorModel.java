package net.eszaray.imperium.event;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.client.model.SimpleArmorModel;
import net.eszaray.imperium.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.equipment.EquipmentModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import java.util.Collections;
import java.util.Map;

@EventBusSubscriber(modid = Imperium.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModCustomArmorModel {
    @SubscribeEvent
    public static void onRegisterClientExtension(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
                EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();

                Map<String, ModelPart> map = Map.ofEntries(
                        Map.entry("head", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).head()),
//                        Map.entry("hat",  new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).hat()),
                        Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))
                );

                SimpleArmorModel model = new SimpleArmorModel(new ModelPart(Collections.emptyList(), map));

                return model;
            }
        }, ModItems.SONNE_HELMET.get());

        event.registerItem(new IClientItemExtensions() {
            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
                EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
                Map<String, ModelPart> map = Map.ofEntries(
                        Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
//                        Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("body", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).body()),
                        Map.entry("right_arm", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).rightArm()),
                        Map.entry("left_arm", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).leftArm()),
                        Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))
                );

                SimpleArmorModel armorModel = new SimpleArmorModel(new ModelPart(Collections.emptyList(), map));

                return armorModel;
            }
        }, ModItems.SONNE_CHESTPLATE.get());

        event.registerItem(new IClientItemExtensions() {
            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
                EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
                Map<String, ModelPart> map = Map.ofEntries(
                        Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
//                        Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("body", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).body()),
                        Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("right_leg", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).rightLeg()),
                        Map.entry("left_leg", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).leftLeg())
                );

                SimpleArmorModel armorModel = new SimpleArmorModel(new ModelPart(Collections.emptyList(), map));

                return armorModel;
            }
        }, ModItems.SONNE_LEGGINGS.get());

        event.registerItem(new IClientItemExtensions() {
            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
                EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
                Map<String, ModelPart> map = Map.ofEntries(
                        Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
//                        Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
                        Map.entry("right_leg", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).rightLeg()),
                        Map.entry("left_leg", new SimpleArmorModel<>(modelSet.bakeLayer(SimpleArmorModel.LAYER_LOCATION)).leftLeg())
                );

                SimpleArmorModel armorModel = new SimpleArmorModel(new ModelPart(Collections.emptyList(), map));

                return armorModel;
            }
        }, ModItems.SONNE_BOOTS.get());
    }
}
