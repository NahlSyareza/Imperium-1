package net.eszaray.imperium.entity;

import net.eszaray.imperium.init.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;

public class Praetorian extends VeteranLegionary implements Roman {
    public Praetorian(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);

        ItemStack sword = new ItemStack(ModItems.IRON_LEGION_SWORD.get());
        ItemStack shield = new ItemStack(ModItems.LEGION_SHIELD.get());

        int color = 0x8932B8;

        shield.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));

        ItemStack head = new ItemStack(ModItems.IRON_LEGION_HELMET.get());
        ItemStack chest = new ItemStack(ModItems.IRON_LEGION_SEGMENTPLATE.get());
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
}
