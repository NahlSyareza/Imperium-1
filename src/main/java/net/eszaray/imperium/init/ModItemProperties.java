package net.eszaray.imperium.init;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.LEGION_SHIELD.get(), ResourceLocation.withDefaultNamespace("blocking"), (itemstack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemstack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.LEGION_ROUND_SHIELD.get(), ResourceLocation.withDefaultNamespace("blocking"), (itemstack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemstack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.LEGION_BOW.get(), ResourceLocation.withDefaultNamespace("pull"), (itemstack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemstack ? 0.0F : (float)(itemstack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(ModItems.LEGION_BOW.get(), ResourceLocation.withDefaultNamespace("pulling"), (itemstack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemstack ? 1.0F : 0.0F;
        });
    }
}
