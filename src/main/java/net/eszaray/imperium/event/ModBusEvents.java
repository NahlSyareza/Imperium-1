package net.eszaray.imperium.event;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.EliteLegionary;
import net.eszaray.imperium.entity.Legionary;
import net.eszaray.imperium.entity.client.model.LegionShieldModel;
import net.eszaray.imperium.init.ModEntityType;
import net.eszaray.imperium.entity.VeteranLegionary;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Imperium.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LegionShieldModel.LAYER_LOCATION, LegionShieldModel::createLayer);
    }

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntityType.LEGIONARY.get(), Legionary.createAttributes().build());
        event.put(ModEntityType.VETERAN_LEGIONARY.get(), VeteranLegionary.createAttributes().build());
        event.put(ModEntityType.ELITE_LEGIONARY.get(), EliteLegionary.createAttributes().build());
    }
}
