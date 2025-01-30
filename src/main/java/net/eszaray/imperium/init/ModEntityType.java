package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Imperium.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<Legionary>> LEGIONARY = ENTITY_TYPE.register("legionary", () -> EntityType.Builder.of(Legionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("legionary")));
    public static final DeferredHolder<EntityType<?>,EntityType<VeteranLegionary>> VETERAN_LEGIONARY = ENTITY_TYPE.register("veteran_legionary", () -> EntityType.Builder.of(VeteranLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("veteran_legionary")));
    public static final DeferredHolder<EntityType<?>,EntityType<EliteLegionary>> ELITE_LEGIONARY = ENTITY_TYPE.register("elite_legionary", () -> EntityType.Builder.of(EliteLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("elite_legionary")));
    public static final DeferredHolder<EntityType<?>,EntityType<NobleCitizen>> NOBLE_CITIZEN = ENTITY_TYPE.register("noble_citizen", () -> EntityType.Builder.of(NobleCitizen::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("noble_citizen")));
    public static final DeferredHolder<EntityType<?>,EntityType<Auxiliary>> AUXILIARY = ENTITY_TYPE.register("auxiliary", () -> EntityType.Builder.of(Auxiliary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("auxiliary")));
    public static final DeferredHolder<EntityType<?>,EntityType<TribesmanChieftain>> TRIBESMAN_CHIEFTAIN = ENTITY_TYPE.register("tribesman_chieftain", () -> EntityType.Builder.of(TribesmanChieftain::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("tribesman_chieftain")));
    public static final DeferredHolder<EntityType<?>, EntityType<Tribesman>> TRIBESMAN = ENTITY_TYPE.register("tribesman", () -> EntityType.Builder.of(Tribesman::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(createKey("tribesman")));

    private static ResourceKey<EntityType<?>> createKey(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, name));
    }

    public static void register(IEventBus bus) {
        ENTITY_TYPE.register(bus);
    }
}
