package io.github.lieonlion.enderite.item;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class EnderiteSmithingTemplateItem extends SmithingTemplateItem {

    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", new ResourceLocation(Enderite.MODID, "smithing_template"));
    private static final ChatFormatting TITLE_FORMATTING = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMATTING = ChatFormatting.BLUE;
    private static final Component ENDERITE_UPGRADE_TEXT = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Enderite.MODID, "enderite_upgrade"))).withStyle(TITLE_FORMATTING);
    private static final Component ENDERITE_UPGRADE_APPLIES_TO_TEXT = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Enderite.MODID, "smithing_template.enderite_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMATTING);
    private static final Component ENDERITE_UPGRADE_INGREDIENTS_TEXT = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Enderite.MODID, "smithing_template.enderite_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMATTING);
    private static final Component ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Enderite.MODID, "smithing_template.enderite_upgrade.base_slot_description")));
    private static final Component ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Enderite.MODID, "smithing_template.enderite_upgrade.additions_slot_description")));

    private static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE_TEXTURE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE_TEXTURE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD_TEXTURE = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL_TEXTURE = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE_TEXTURE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT_TEXTURE = new ResourceLocation("item/empty_slot_ingot");

    public EnderiteSmithingTemplateItem(Component appliesToText, Component ingredientsText, Component titleText, Component baseSlotDescriptionText, Component additionsSlotDescriptionText, List<ResourceLocation> emptyBaseSlotTextures, List<ResourceLocation> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    public static SmithingTemplateItem createEnderiteUpgrade() {
        return new SmithingTemplateItem(ENDERITE_UPGRADE_APPLIES_TO_TEXT, ENDERITE_UPGRADE_INGREDIENTS_TEXT, ENDERITE_UPGRADE_TEXT, ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, EnderiteSmithingTemplateItem.getEnderiteUpgradeEmptyBaseSlotTextures(), EnderiteSmithingTemplateItem.getEnderiteUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<ResourceLocation> getEnderiteUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }
    private static List<ResourceLocation> getEnderiteUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public String getDescriptionId() {
        return DESCRIPTION_ID;
    }
}