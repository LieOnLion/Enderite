package dev.lieonlion.enderite.init;

import dev.lieonlion.enderite.Enderite;
import dev.lieonlion.enderite.item.EnderitePlatedElytraItem;
import dev.lieonlion.enderite.item.EnderiteSmithingTemplateItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Rarity;

public class ItemsInit {
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item ENDERITE_FRAGMENT = registerItem("enderite_fragment", new Item(new Item.Settings().fireproof()));
    public static final BlockItem ENDERITE_BLOCK_ITEM = (BlockItem) registerItem("enderite_block",
            new BlockItem(BlocksInit.ENDERITE_BLOCK, new Item.Settings().fireproof()));
    public static final BlockItem PRIMORDIAL_REMNANTS_ITEM = (BlockItem) registerItem("primordial_remnants",
            new BlockItem(BlocksInit.PRIMORDIAL_REMNANTS, new Item.Settings().fireproof()));
    public static final BlockItem OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM = (BlockItem) registerItem("obsidian_infused_enderite_block",
            new BlockItem(BlocksInit.OBSIDIAN_INFUSED_ENDERITE_BLOCK, new Item.Settings().fireproof()));

    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template",
            EnderiteSmithingTemplateItem.createEnderiteUpgrade());

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword",
            new SwordItem(ToolMaterialsInit.ENDERITE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
            new ShovelItem(ToolMaterialsInit.ENDERITE, new Item.Settings().fireproof()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 0.5f, -2.5f))));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
            new PickaxeItem(ToolMaterialsInit.ENDERITE, new Item.Settings().fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 0, -2.3f))));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
            new AxeItem(ToolMaterialsInit.ENDERITE, new Item.Settings().fireproof()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 4, -2.5f))));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
            new HoeItem(ToolMaterialsInit.ENDERITE, new Item.Settings().fireproof()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, -6, .5f))));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(49))));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(49))));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(49))));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(49))));

    public static final Item OBSIDIAN_INFUSED_ENDERITE_INGOT = registerItem("obsidian_infused_enderite_ingot", new Item(new Item.Settings().fireproof()));

    public static final Item OBSIDIAN_INFUSED_ENDERITE_SWORD = registerItem("obsidian_infused_enderite_sword",
            new SwordItem(ToolMaterialsInit.OBSIDIAN_INFUSED_ENDERITE, 3, -1.4f, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_SHOVEL = registerItem("obsidian_infused_enderite_shovel",
            new ShovelItem(ToolMaterialsInit.OBSIDIAN_INFUSED_ENDERITE, 1.5f, -2f, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_PICKAXE = registerItem("obsidian_infused_enderite_pickaxe",
            new PickaxeItem(ToolMaterialsInit.OBSIDIAN_INFUSED_ENDERITE, 1, -1.8f, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_AXE = registerItem("obsidian_infused_enderite_axe",
            new AxeItem(ToolMaterialsInit.OBSIDIAN_INFUSED_ENDERITE, 5, -2f, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_HOE = registerItem("obsidian_infused_enderite_hoe",
            new HoeItem(ToolMaterialsInit.OBSIDIAN_INFUSED_ENDERITE, -6, 1f, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterialsInit.ENDERITE, 2, -1.9f))));

    public static final Item ENDERITE_PLATED_ELYTRA = registerItem("enderite_plated_elytra",
            new EnderitePlatedElytraItem(3, new Item.Settings().fireproof().maxDamage(972).rarity(Rarity.RARE)));

    public static void registerItems() {
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERITE_FRAGMENT, Items.NETHERITE_INGOT);
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERITE_INGOT, ENDERITE_FRAGMENT);
        addToItemGroup(ItemGroups.INGREDIENTS, OBSIDIAN_INFUSED_ENDERITE_INGOT, ENDERITE_INGOT);
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        addToItemGroup(ItemGroups.NATURAL, PRIMORDIAL_REMNANTS_ITEM, Items.ANCIENT_DEBRIS);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ENDERITE_BLOCK_ITEM, Items.NETHERITE_BLOCK);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM, ENDERITE_BLOCK_ITEM);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_SHOVEL, Items.NETHERITE_HOE);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_PICKAXE, ENDERITE_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_AXE, ENDERITE_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_HOE, ENDERITE_AXE);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_SWORD, Items.NETHERITE_SWORD);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_AXE, Items.NETHERITE_AXE);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_HELMET, Items.NETHERITE_BOOTS);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_CHESTPLATE, ENDERITE_HELMET);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_LEGGINGS, ENDERITE_CHESTPLATE);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_BOOTS, ENDERITE_LEGGINGS);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_SHOVEL, ENDERITE_HOE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_PICKAXE, OBSIDIAN_INFUSED_ENDERITE_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_AXE, OBSIDIAN_INFUSED_ENDERITE_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_HOE, OBSIDIAN_INFUSED_ENDERITE_AXE);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_INFUSED_ENDERITE_SWORD, ENDERITE_SWORD);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_INFUSED_ENDERITE_AXE, ENDERITE_AXE);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_PLATED_ELYTRA, Items.ELYTRA);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Enderite.asId(name), item);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item, Item after) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(after, item));
    }
}