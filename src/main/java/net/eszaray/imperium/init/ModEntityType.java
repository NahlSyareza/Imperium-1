package net.eszaray.imperium.init;

import net.eszaray.imperium.Imperium;
import net.eszaray.imperium.entity.EliteLegionary;
import net.eszaray.imperium.entity.Legionary;
import net.eszaray.imperium.entity.VeteranLegionary;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Imperium.MODID);

    public static final Supplier<EntityType<Legionary>> LEGIONARY = ENTITY_TYPE.register("legionary", () -> EntityType.Builder.of(Legionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("legionary"));
    public static final Supplier<EntityType<VeteranLegionary>> VETERAN_LEGIONARY = ENTITY_TYPE.register("veteran_legionary", () -> EntityType.Builder.of(VeteranLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("veteran_legionary"));
    public static final Supplier<EntityType<EliteLegionary>> ELITE_LEGIONARY = ENTITY_TYPE.register("elite_legionary", () -> EntityType.Builder.of(EliteLegionary::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build("elite_legionary"));

    public static void register(IEventBus bus) {
        ENTITY_TYPE.register(bus);
    }
}
