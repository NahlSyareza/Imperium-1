package net.eszaray.imperium;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.eszaray.imperium.entity.client.model.SimpleArmorModel;
import net.eszaray.imperium.entity.client.renderer.TribesmanChieftainRenderer;
import net.eszaray.imperium.entity.client.renderer.LegionaryRenderer;
import net.eszaray.imperium.entity.client.renderer.NobleCitizenRenderer;
import net.eszaray.imperium.entity.client.renderer.TribesmanRenderer;
import net.eszaray.imperium.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

import java.util.Collections;
import java.util.Map;

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
            EntityRenderers.register(ModEntityType.VETERAN_LEGIONARY.get(), context -> new LegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.ELITE_LEGIONARY.get(), context -> new LegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.NOBLE_CITIZEN.get(), context -> new NobleCitizenRenderer(context, false));
            EntityRenderers.register(ModEntityType.AUXILIARY.get(), context -> new LegionaryRenderer(context, false));
            EntityRenderers.register(ModEntityType.TRIBESMAN_CHIEFTAIN.get(), context -> new TribesmanChieftainRenderer(context, false));
            EntityRenderers.register(ModEntityType.TRIBESMAN.get(), context -> new TribesmanRenderer(context, false));
        }

        @SubscribeEvent
        public static void onRegisterReloadListener(RegisterClientReloadListenersEvent event) {
            customRenderer = new ModBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
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
                    return customRenderer;
                }
            }, ModItems.TRIBAL_ORNATE_SHIELD.get(), ModItems.TRIBAL_SHIELD.get(), ModItems.LEGION_SHIELD.get(), ModItems.LEGION_ROUND_SHIELD.get());

            event.registerItem(new IClientItemExtensions() {
                @Override
                public int getDefaultDyeColor(ItemStack stack) {
                    return FastColor.ARGB32.opaque(DyedItemColor.LEATHER_COLOR);
                }
            }, ModItems.CEREMONIAL_LEGION_GREAVES.get());
        }
    }
}
