package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.item.LegionShieldItem;
import net.eszaray.imperium.item.LegionSpearItem;
import net.eszaray.imperium.item.LegionSwordItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Imperium.MODID);

    public static final DeferredItem<Item> IRON_LEGION_SWORD = ITEMS.register("iron_legion_sword", () -> new LegionSwordItem(ModTiers.IRON_LEGION, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.IRON_LEGION, 4, -1.0F))));
    public static final DeferredItem<Item> IRON_LEGION_SPEAR = ITEMS.register("iron_legion_spear", () -> new LegionSpearItem(ModTiers.IRON_LEGION, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.IRON_LEGION, 3, -3.0F))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_SWORD = ITEMS.register("ceremonial_legion_sword", () -> new LegionSwordItem(ModTiers.IRON_LEGION, new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.IRON_LEGION, 3, -1.2F))));

    public static final DeferredItem<Item> COLORABLE_BAG = ITEMS.register("colorable_bag", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEGION_SHIELD = ITEMS.register("legion_shield", () -> new LegionShieldItem(new Item.Properties().durability(504)));
    public static final DeferredItem<Item> LEGION_ROUND_SHIELD = ITEMS.register("legion_round_shield", () -> new LegionShieldItem(new Item.Properties().durability(504)));
    public static final DeferredItem<Item> LEGION_BOW = ITEMS.register("legion_bow", () -> new BowItem(new Item.Properties()));

    public static final DeferredItem<Item> IRON_LEGION_HELMET = ITEMS.register("iron_legion_helmet", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_SEGMENTPLATE = ITEMS.register("iron_legion_segmentplate", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_CHAINMAIL = ITEMS.register("iron_legion_chainmail", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_B, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_GREAVES = ITEMS.register("iron_legion_greaves",  () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> IRON_LEGION_BOOTS = ITEMS.register("iron_legion_boots", () -> new ArmorItem(ModArmorMaterials.IRON_LEGION_A, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(5))));

    public static final DeferredItem<Item> CEREMONIAL_LEGION_HELMET = ITEMS.register("ceremonial_legion_helmet", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_CHESTPLATE = ITEMS.register("ceremonial_legion_chestplate", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_GREAVES = ITEMS.register("ceremonial_legion_greaves", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5))));
    public static final DeferredItem<Item> CEREMONIAL_LEGION_BOOTS = ITEMS.register("ceremonial_legion_boots", () -> new ArmorItem(ModArmorMaterials.CEREMONIAL_LEGION, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(5))));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
