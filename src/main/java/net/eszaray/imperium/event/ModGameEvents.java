package net.eszaray.imperium.event;

import net.eszaray.imperium.Imperium;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = Imperium.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModGameEvents {
    private static int tickCount = 0;

    @SubscribeEvent
    public static void onRenderLivingEvent(RenderPlayerEvent.Pre event) {
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        Level level = event.getEntity().level();

        tickCount++;

//        if (tickCount % 20 == 0) {
//            if (entity instanceof Player && !level.isClientSide()) {
//                Player player = (Player) entity;
//                player.sendSystemMessage(Component.literal("1 second has passed!"));
//            }
//        }
    }

}
