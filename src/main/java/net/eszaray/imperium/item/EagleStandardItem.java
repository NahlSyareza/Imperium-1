package net.eszaray.imperium.item;

import net.eszaray.imperium.Imperium;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class EagleStandardItem extends Item {
    AttributeModifier modifier = new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "eagle_standard_buff"), 5.0D, AttributeModifier.Operation.ADD_VALUE);

    public EagleStandardItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("When in Inventory:").withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.literal(" +5 Attack Damage").withStyle(ChatFormatting.DARK_GREEN));
        if (stack.hasFoil()) {
            tooltipComponents.add(Component.literal(""));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);

        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5 * 20, 2));
        stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(usedHand));

        return InteractionResult.SUCCESS;
    }
}
