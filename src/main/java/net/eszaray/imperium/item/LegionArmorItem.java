package net.eszaray.imperium.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class LegionArmorItem extends ArmorItem {
    public LegionArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

//    @Override
//    public boolean isFoil(ItemStack stack) {
//        if (stack.get(DataComponents.DYED_COLOR) == null && (this.getType() == Type.CHESTPLATE || this.getType() == Type.LEGGINGS)) {
//            stack.set(DataComponents.DYED_COLOR, new DyedItemColor(11546150, true));
//        }
//        return super.isFoil(stack);
//    }
}
