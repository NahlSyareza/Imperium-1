package net.eszaray.imperium.entity;

import net.eszaray.imperium.init.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;

public class EliteLegionary extends Legionary{
    public EliteLegionary(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 24.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);

        ItemStack sword = new ItemStack(ModItems.IRON_LEGION_SWORD.get());
        ItemStack shield = new ItemStack(ModItems.LEGION_SHIELD.get());

        int color = 0x3C44AA;
//        int color = 0x640000;

        shield.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));

        ItemStack head = new ItemStack(ModItems.IRON_LEGION_HELMET.get());
        ItemStack chest = random.nextInt(0, 2) < 1 ? new ItemStack(ModItems.IRON_LEGION_SEGMENTPLATE.get()) : new ItemStack(ModItems.IRON_LEGION_CHAINMAIL.get());
        ItemStack legs = new ItemStack(ModItems.IRON_LEGION_GREAVES.get());
        ItemStack feet = new ItemStack(ModItems.IRON_LEGION_BOOTS.get());

        chest.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
        legs.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));

        this.setItemSlot(EquipmentSlot.MAINHAND, sword);
        this.setItemSlot(EquipmentSlot.OFFHAND, shield);

        this.setItemSlot(EquipmentSlot.CHEST, chest);
        this.setItemSlot(EquipmentSlot.HEAD, head);
        this.setItemSlot(EquipmentSlot.LEGS, legs);
        this.setItemSlot(EquipmentSlot.FEET, feet);
    }

    @Override
    public Component getName() {
        return Component.translatable("entity.imperium.elite_legionary");
    }
}
