package net.eszaray.imperium.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    public static final Tier IRON_LEGION = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 9.0F, 3.5F, 15, () -> Ingredient.of(Items.IRON_INGOT));
}
