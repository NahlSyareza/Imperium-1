package net.eszaray.imperium;

import com.mojang.logging.LogUtils;
import net.eszaray.imperium.entity.client.renderer.*;
import net.eszaray.imperium.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.util.ARGB;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Imperium.MODID)
public class Imperium {
    public static final String MODID = "imperium";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Imperium(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModEntityType.register(modEventBus);

        ModItems.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        private static ModBlockEntityWithoutLevelRenderer customRenderer;

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntityType.LEGIONARY.get(), context -> new LegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.VETERAN_LEGIONARY.get(), context -> new VeteranLegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.ELITE_LEGIONARY.get(), context -> new EliteLegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.NOBLE_CITIZEN.get(), context -> new NobleCitizenRenderer(context, false));
            EntityRenderers.register(ModEntityType.AUXILIARY.get(), context -> new AuxiliaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.TRIBESMAN_CHIEFTAIN.get(), context -> new TribesmanChieftainRenderer(context, false));
            EntityRenderers.register(ModEntityType.TRIBESMAN.get(), context -> new TribesmanRenderer(context, false));
        }

        @SubscribeEvent
        public static void onRegisterReloadListener(RegisterClientReloadListenersEvent event) {
            customRenderer = new ModBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
//            ModBlockEntityWithoutLevelRenderer.instance = new ModBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
            event.registerReloadListener(customRenderer);
        }

        @SubscribeEvent
        public static void registerColorHandler(RegisterColorHandlersEvent.Item event) {
            event.register((itemStack, i) -> {
                return i > 0 ? -1 : DyedItemColor.getOrDefault(itemStack, DyedItemColor.LEATHER_COLOR);
            }, ModItems.LEGION_ROUND_SHIELD.get(), ModItems.IRON_LEGION_CHAINMAIL.get(), ModItems.IRON_LEGION_SEGMENTPLATE.get(), ModItems.IRON_LEGION_GREAVES.get(), ModItems.LEGION_SHIELD, ModItems.CEREMONIAL_LEGION_GREAVES);
        }

        @SubscribeEvent
        static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerItem(new IClientItemExtensions() {
                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
//                    return ModBlockEntityWithoutLevelRenderer.instance;
                    return customRenderer;
                }
            }, ModItems.TRIBAL_SHIELD.get(), ModItems.LEGION_SHIELD.get(), ModItems.LEGION_ROUND_SHIELD.get());

            event.registerItem(new IClientItemExtensions() {
                @Override
                public int getDefaultDyeColor(ItemStack stack) {
                    return ARGB.opaque(DyedItemColor.LEATHER_COLOR);
                }
            }, Items.LEATHER_CHESTPLATE, ModItems.IRON_LEGION_CHAINMAIL.get(), ModItems.CEREMONIAL_LEGION_GREAVES.get());
        }
    }
}
