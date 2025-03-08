package dev.lieonlion.enderite.init;

import dev.lieonlion.enderite.Enderite;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterialsInit implements ArmorMaterial {
   ENDERITE(Enderite.MODID + ":enderite", 49, Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
   }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.1f, () -> Ingredient.ofItems(ItemsInit.ENDERITE_INGOT));

   public static final StringIdentifiable.BasicCodec<ArmorMaterials> CODEC;
   private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY;
   private final String name;
   private final int durabilityMultiplier;
   private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
   private final int enchantability;
   private final SoundEvent equipSound;
   private final float toughness;
   private final float knockbackResistance;
   private final Lazy<Ingredient> repairIngredientSupplier;

   ArmorMaterialsInit(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
       this.name = name;
       this.durabilityMultiplier = durabilityMultiplier;
       this.protectionAmounts = protectionAmounts;
       this.enchantability = enchantability;
       this.equipSound = equipSound;
       this.toughness = toughness;
       this.knockbackResistance = knockbackResistance;
       this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
   }

   @Override
   public int getDurability(ArmorItem.Type type) {
       return BASE_DURABILITY.get((Object)type) * this.durabilityMultiplier;
   }

   @Override
   public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts.get((Object)type);
    }

   @Override
   public int getEnchantability() {
        return this.enchantability;
    }

   @Override
   public SoundEvent getEquipSound() {
        return this.equipSound;
    }

   @Override
   public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

   @Override
   public String getName() {
        return this.name;
    }

   @Override
   public float getToughness() {
        return this.toughness;
    }

   @Override
   public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

   static {
       CODEC = StringIdentifiable.createCodec(ArmorMaterials::values);
       BASE_DURABILITY = Util.make(new EnumMap(ArmorItem.Type.class), map -> {
           map.put(ArmorItem.Type.BOOTS, 13);
           map.put(ArmorItem.Type.LEGGINGS, 15);
           map.put(ArmorItem.Type.CHESTPLATE, 16);
           map.put(ArmorItem.Type.HELMET, 11);
       });
   }
}