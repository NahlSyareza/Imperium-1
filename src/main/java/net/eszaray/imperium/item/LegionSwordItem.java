package net.eszaray.imperium.item;

import net.eszaray.imperium.Imperium;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class LegionSwordItem extends SwordItem {
    public static final AttributeModifier REACH = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "sword_range"), -1.0D, AttributeModifier.Operation.ADD_VALUE);

    public LegionSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public LegionSwordItem(Tier p_tier, Properties p_properties, Tool toolComponentData) {
        super(p_tier, p_properties, toolComponentData);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (entity instanceof Player) {
            Player player = (Player) entity;

            AttributeInstance instance = player.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);
            if (instance != null) {
                if (player.getMainHandItem().getItem() instanceof LegionSwordItem) {
                    instance.addOrUpdateTransientModifier(REACH);
                } else {
                    instance.removeModifier(REACH);
                }
            }
        }
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        if(enchantment.is(Enchantments.SWEEPING_EDGE)) {
            return false;
        }

        return super.supportsEnchantment(stack, enchantment);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        if(itemAbility == ItemAbilities.SWORD_SWEEP) {
            return false;
        }

        return super.canPerformAction(stack, itemAbility);
    }
}
