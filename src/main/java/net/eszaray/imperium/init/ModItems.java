package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.item.EagleStandardItem;
import net.eszaray.imperium.item.LegionShieldItem;
import net.eszaray.imperium.item.LegionSpearItem;
import net.eszaray.imperium.item.LegionSwordItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Imperium.MODID);

    public static final DeferredItem<Item> IRON_LEGION_SWORD = ITEMS.register("iron_legion_sword", () -> new LegionSwordItem(ModTiers.IRON_LEGION, 4.0F, -1.8F, new Item.Properties().setId(createKey("iron_legion_sword"))));
    public static final DeferredItem<Item> IRON_TRIBAL_SWORD = ITEMS.register("iron_tribal_sword", () -> new SwordItem(ToolMaterial.IRON, 3.0F, -2.4F, new Item.Properties().setId(createKey("iron_tribal_sword"))));
    public static final DeferredItem<Item> IRON_LEGION_SPEAR = ITEMS.register("iron_legion_spear", () -> new LegionSpearItem(ModTiers.IRON_LEGION, 3.0F, -3.0F, new Item.Properties().setId(createKey("iron_legion_spear"))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_SWORD = ITEMS.register("ceremonial_legion_sword", () -> new LegionSwordItem(ModTiers.IRON_LEGION, 4.0F, -1.8F, new Item.Properties().setId(createKey("ceremonial_legion_sword"))));

    public static final DeferredItem<Item> COLORABLE_BAG = ITEMS.register("colorable_bag", () -> new Item(new Item.Properties().setId(createKey("colorable_bag"))));
    public static final DeferredItem<Item> EAGLE_STANDARD = ITEMS.register("eagle_standard", () -> new EagleStandardItem(new Item.Properties().durability(150).setId(createKey("eagle_standard"))));

    public static final DeferredItem<Item> LEGION_SHIELD = ITEMS.register("legion_shield", () -> new LegionShieldItem(new Item.Properties().durability(504).setId(createKey("legion_shield")).equippableUnswappable(EquipmentSlot.OFFHAND)));
    public static final DeferredItem<Item> LEGION_ROUND_SHIELD = ITEMS.register("legion_round_shield", () -> new LegionShieldItem(new Item.Properties().durability(504).setId(createKey("legion_round_shield")).equippableUnswappable(EquipmentSlot.OFFHAND)));
    public static final DeferredItem<Item> TRIBAL_SHIELD = ITEMS.register("tribal_shield", () -> new LegionShieldItem(new Item.Properties().durability(504).setId(createKey("tribal_shield")).equippableUnswappable(EquipmentSlot.OFFHAND)));

    public static final DeferredItem<Item> LEGION_BOW = ITEMS.register("legion_bow", () -> new BowItem(new Item.Properties().setId(createKey("legion_bow"))));

    public static final DeferredItem<Item> IRON_LEGION_HELMET = ITEMS.register("iron_legion_helmet", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorType.HELMET, new Item.Properties().setId(createKey("iron_legion_helmet")).durability(ArmorType.HELMET.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_SEGMENTPLATE = ITEMS.register("iron_legion_segmentplate", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorType.CHESTPLATE, new Item.Properties().setId(createKey("iron_legion_segmentplate")).durability(ArmorType.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_CHAINMAIL = ITEMS.register("iron_legion_chainmail", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_B, ArmorType.CHESTPLATE, new Item.Properties().setId(createKey("iron_legion_chainmail")).durability(ArmorType.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_GREAVES = ITEMS.register("iron_legion_greaves",  () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorType.LEGGINGS, new Item.Properties().setId(createKey("iron_legion_greaves")).durability(ArmorType.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_BOOTS = ITEMS.register("iron_legion_boots", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorType.BOOTS, new Item.Properties().setId(createKey("iron_legion_boots")).durability(ArmorType.BOOTS.getDurability(5))));

    public static final DeferredItem<Item> CEREMONIAL_LEGION_HELMET = ITEMS.register("ceremonial_legion_helmet", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorType.HELMET, new Item.Properties().setId(createKey("ceremonial_legion_helmet")).durability(ArmorType.HELMET.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_CHESTPLATE = ITEMS.register("ceremonial_legion_chestplate", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorType.CHESTPLATE, new Item.Properties().setId(createKey("ceremonial_legion_chestplate")).durability(ArmorType.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_GREAVES = ITEMS.register("ceremonial_legion_greaves", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorType.LEGGINGS, new Item.Properties().setId(createKey("ceremonial_legion_greaves")).durability(ArmorType.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_BOOTS = ITEMS.register("ceremonial_legion_boots", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorType.BOOTS, new Item.Properties().setId(createKey("ceremonial_legion_boots")).durability(ArmorType.BOOTS.getDurability(5))));

    public static final DeferredItem<Item> SONNE_HELMET = ITEMS.register("sonne_helmet", () -> new ArmorItem(ModArmorMaterials.SONNE, ArmorType.HELMET, new Item.Properties().setId(createKey("sonne_helmet")).durability(ArmorType.HELMET.getDurability(5))));
    public static final DeferredItem<Item> SONNE_CHESTPLATE = ITEMS.register("sonne_chestplate", () -> new ArmorItem(ModArmorMaterials.SONNE, ArmorType.CHESTPLATE, new Item.Properties().setId(createKey("sonne_chestplate")).durability(ArmorType.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> SONNE_LEGGINGS = ITEMS.register("sonne_leggings", () -> new ArmorItem(ModArmorMaterials.SONNE, ArmorType.LEGGINGS, new Item.Properties().setId(createKey("sonne_leggings")).durability(ArmorType.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> SONNE_BOOTS = ITEMS.register("sonne_boots", () -> new ArmorItem(ModArmorMaterials.SONNE, ArmorType.BOOTS, new Item.Properties().setId(createKey("sonne_boots")).durability(ArmorType.BOOTS.getDurability(5))));

    private static ResourceKey<Item> createKey(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, name));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
