package net.eszaray.imperium.util;

import net.eszaray.imperium.Imperium;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class ModModelBakery {
    public static final Material LEGION_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID,"entity/legion_shield_base"));
    public static final Material LEGION_ROUND_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "entity/legion_round_shield_base"));
    public static final Material TRIBAL_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "entity/tribal_shield_base"));
    public static final Material TRIBAL_ORNATE_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "entity/tribal_ornate_shield_base"));

    public static final Material BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "entity/legion_shield/base"));
    public static final Material ROUND_BASE = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(Imperium.MODID, "entity/legion_shield/round_base"));
}
