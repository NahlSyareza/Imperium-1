package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Imperium.MODID);

    public static final Supplier<EntityType<Legionary>> LEGIONARY = ENTITY_TYPE.register("legionary", () -> EntityType.Builder.of(Legionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("legionary"));
    public static final Supplier<EntityType<VeteranLegionary>> VETERAN_LEGIONARY = ENTITY_TYPE.register("veteran_legionary", () -> EntityType.Builder.of(VeteranLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("veteran_legionary"));
    public static final Supplier<EntityType<EliteLegionary>> ELITE_LEGIONARY = ENTITY_TYPE.register("elite_legionary", () -> EntityType.Builder.of(EliteLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("elite_legionary"));
    public static final Supplier<EntityType<NobleCitizen>> NOBLE_CITIZEN = ENTITY_TYPE.register("noble_citizen", () -> EntityType.Builder.of(NobleCitizen::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("noble_citizen"));
    public static final Supplier<EntityType<Auxiliary>> AUXILIARY = ENTITY_TYPE.register("auxiliary", () -> EntityType.Builder.of(Auxiliary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("auxiliary"));
    public static final Supplier<EntityType<Chieftain>> CHIEFTAIN = ENTITY_TYPE.register("chieftain", () -> EntityType.Builder.of(Chieftain::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("chieftain"));
    public static final Supplier<EntityType<Tribesman>> TRIBESMAN = ENTITY_TYPE.register("tribesman", () -> EntityType.Builder.of(Tribesman::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("tribesman"));

    public static void register(IEventBus bus) {
        ENTITY_TYPE.register(bus);
    }
}
