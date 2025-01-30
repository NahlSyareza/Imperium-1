package net.eszaray.imperium.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.eszaray.imperium.Imperium;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = Imperium.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModGameEvents {
    public static PoseStack pStack;
    public static MultiBufferSource mbSource;

    @SubscribeEvent
    public static void onRenderLivingEvent(RenderLivingEvent.Post event) {
        pStack = event.getPoseStack();
        mbSource = event.getMultiBufferSource();
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        Level level = event.getEntity().level();

//        if (tickCount % 20 == 0) {
//            if (entity instanceof Player && !level.isClientSide()) {
//                Player player = (Player) entity;
//                player.sendSystemMessage(Component.literal("1 second has passed!"));
//            }
//        }
    }

}
