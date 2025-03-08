package dev.lieonlion.enderite.init;

import dev.lieonlion.enderite.Enderite;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ArmorMaterialsInit {
    public static final ArmorMaterial ENDERITE = registerArmorMaterial("enderite", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> Ingredient.ofItems(ItemsInit.ENDERITE_INGOT));

    public static ArmorMaterial registerArmorMaterial(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Enderite.asId(name)));

        return Registry.register(Registries.ARMOR_MATERIAL, Enderite.asId(name),
                new ArmorMaterial(
                        defense,
                        enchantability,
                        equipSound,
                        repairIngredient,
                        list,
                        toughness,
                        knockbackResistance
                )
        );
    }
}