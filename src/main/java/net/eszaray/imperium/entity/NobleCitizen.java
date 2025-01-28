package net.eszaray.imperium.entity;

import net.eszaray.imperium.util.DialogEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class NobleCitizen extends PathfinderMob {
    private HashMap<Integer, DialogEvent> dialogEvent = new HashMap<>();

    public NobleCitizen(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        dialogEvent.put(0, new DialogEvent("Ah hello there!"));
        dialogEvent.put(1, new DialogEvent("Greetings, my name is Accius"));
        dialogEvent.put(2, new DialogEvent("I need you to bring me an Iron Ingot. I need it for something", true));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes().add(Attributes.MAX_HEALTH, 25.0).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 24.0D);
    }

    public int sequence = 0;

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        Level level = this.level();

        if(!level.isClientSide()) {
            String dialog = dialogEvent.get(sequence) != null ? dialogEvent.get(sequence).getDialog() : "You shouldn't be here....";
            player.sendSystemMessage(Component.literal("<" + getName().getString() + "> " + dialog));

            sequence++;

            if(sequence >= dialogEvent.size()) {
                sequence = 0;
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public Component getName() {
        return Component.translatable("entity.imperium.noble_citizen");
    }
}
