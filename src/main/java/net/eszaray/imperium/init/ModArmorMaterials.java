package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final ArmorMaterial IRON_LEGION_A = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), armorTypeIntegerEnumMap -> {
                armorTypeIntegerEnumMap.put(ArmorType.BOOTS, 5);
                armorTypeIntegerEnumMap.put(ArmorType.LEGGINGS, 7);
                armorTypeIntegerEnumMap.put(ArmorType.CHESTPLATE, 9);
                armorTypeIntegerEnumMap.put(ArmorType.HELMET, 5);
                armorTypeIntegerEnumMap.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, ItemTags.REPAIRS_IRON_ARMOR, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_a"));

    public static final ArmorMaterial IRON_LEGION_B = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), armorTypeIntegerEnumMap -> {
                armorTypeIntegerEnumMap.put(ArmorType.BOOTS, 5);
                armorTypeIntegerEnumMap.put(ArmorType.LEGGINGS, 7);
                armorTypeIntegerEnumMap.put(ArmorType.CHESTPLATE, 9);
                armorTypeIntegerEnumMap.put(ArmorType.HELMET, 5);
                armorTypeIntegerEnumMap.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, ItemTags.REPAIRS_IRON_ARMOR, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_b"));

    public static final ArmorMaterial CEREMONIAL_LEGION = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), armorTypeIntegerEnumMap -> {
                armorTypeIntegerEnumMap.put(ArmorType.BOOTS, 5);
                armorTypeIntegerEnumMap.put(ArmorType.LEGGINGS, 7);
                armorTypeIntegerEnumMap.put(ArmorType.CHESTPLATE, 9);
                armorTypeIntegerEnumMap.put(ArmorType.HELMET, 5);
                armorTypeIntegerEnumMap.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, ItemTags.REPAIRS_IRON_ARMOR, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "ceremonial_legion"));

    public static final ArmorMaterial SONNE = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), armorTypeIntegerEnumMap -> {
                armorTypeIntegerEnumMap.put(ArmorType.BOOTS, 5);
                armorTypeIntegerEnumMap.put(ArmorType.LEGGINGS, 7);
                armorTypeIntegerEnumMap.put(ArmorType.CHESTPLATE, 9);
                armorTypeIntegerEnumMap.put(ArmorType.HELMET, 5);
                armorTypeIntegerEnumMap.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, ItemTags.REPAIRS_IRON_ARMOR, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "sonne"));
}
