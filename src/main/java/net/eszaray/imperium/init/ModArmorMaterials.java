package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> IRON_LEGION_A = register("iron_legion_a", Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 5);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F,
            () -> Ingredient.of(Items.IRON_INGOT),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_a"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_a"), "_overlay", false)));

    public static final Holder<ArmorMaterial> IRON_LEGION_B = register("iron_legion_b", Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 5);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F,
            () -> Ingredient.of(Items.IRON_INGOT),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_b"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "iron_legion_b"), "_overlay", false)));


    public static final Holder<ArmorMaterial> CEREMONIAL_LEGION = register("ceremonial_legion", Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 5);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> Ingredient.of(Items.DIAMOND)
            , List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "ceremonial_legion"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "ceremonial_legion"), "_overlay", false)));

    public static final Holder<ArmorMaterial> SONNE = register("sonne", Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 5);
            }), 16, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F,
            () -> Ingredient.of(Items.IRON_INGOT));


    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantability, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Imperium.MODID, name);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantability, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient, List<ArmorMaterial.Layer> layers) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Imperium.MODID, name);

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
