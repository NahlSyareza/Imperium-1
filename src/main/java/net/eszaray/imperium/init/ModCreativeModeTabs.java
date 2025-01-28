package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Imperium.MODID);

    public static final Supplier<CreativeModeTab> MOD_TAB = TABS.register("modtab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_LEGION_SWORD.get())).title(Component.translatable("creative_tab.modtab")).displayItems((itemDisplayParameters, output) -> {
        output.accept(ModItems.IRON_LEGION_SWORD);
        output.accept(ModItems.IRON_LEGION_SPEAR);
        output.accept(ModItems.CEREMONIAL_LEGION_SWORD);
        output.accept(ModItems.LEGION_BOW);

        output.accept(ModItems.LEGION_SHIELD);
        output.accept(ModItems.LEGION_ROUND_SHIELD);

        output.accept(ModItems.IRON_LEGION_HELMET);
        output.accept(ModItems.IRON_LEGION_SEGMENTPLATE);
        output.accept(ModItems.IRON_LEGION_CHAINMAIL);
        output.accept(ModItems.IRON_LEGION_GREAVES);
        output.accept(ModItems.IRON_LEGION_BOOTS);

        output.accept(ModItems.CEREMONIAL_LEGION_HELMET);
        output.accept(ModItems.CEREMONIAL_LEGION_CHESTPLATE);
        output.accept(ModItems.CEREMONIAL_LEGION_GREAVES);
        output.accept(ModItems.CEREMONIAL_LEGION_BOOTS);
    }).build());

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
