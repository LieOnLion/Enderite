package dev.lieonlion.enderite.item;

import dev.lieonlion.enderite.Enderite;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class EnderiteSmithingTemplateItem extends SmithingTemplateItem {

    private static final String TRANSLATION_KEY = Util.createTranslationKey("item", new Identifier(Enderite.MODID, "smithing_template"));
    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
    private static final Text ENDERITE_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier(Enderite.MODID, "enderite_upgrade"))).formatted(TITLE_FORMATTING);
    private static final Text ENDERITE_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(Enderite.MODID, "smithing_template.enderite_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text ENDERITE_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(Enderite.MODID, "smithing_template.enderite_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(Enderite.MODID, "smithing_template.enderite_upgrade.base_slot_description")));
    private static final Text ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(Enderite.MODID, "smithing_template.enderite_upgrade.additions_slot_description")));

    public EnderiteSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    public static SmithingTemplateItem createEnderiteUpgrade() {
        return new SmithingTemplateItem(ENDERITE_UPGRADE_APPLIES_TO_TEXT, ENDERITE_UPGRADE_INGREDIENTS_TEXT, ENDERITE_UPGRADE_TEXT, ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, EnderiteSmithingTemplateItem.getEnderiteUpgradeEmptyBaseSlotTextures(), EnderiteSmithingTemplateItem.getEnderiteUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getEnderiteUpgradeEmptyBaseSlotTextures() {
        return List.of(new Identifier("item/empty_armor_slot_helmet"), new Identifier("item/empty_slot_sword"), new Identifier("item/empty_armor_slot_chestplate"),
                new Identifier("item/empty_slot_pickaxe"), new Identifier("item/empty_armor_slot_leggings"), new Identifier("item/empty_slot_axe"),
                new Identifier("item/empty_armor_slot_boots"), new Identifier("item/empty_slot_hoe"), new Identifier("item/empty_slot_shovel"));
    }
    private static List<Identifier> getEnderiteUpgradeEmptyAdditionsSlotTextures() {
        return List.of(new Identifier("item/empty_slot_ingot"));
    }

    @Override
    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }
}