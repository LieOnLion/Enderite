package io.github.lieonlion.enderite.init;

import java.util.EnumMap;
import java.util.function.Supplier;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

public enum ArmorMaterialsInit implements ArmorMaterial {
	ENDERITE(Enderite.MODID + ":enderite", 49, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorType) -> {
        armorType.put(ArmorItem.Type.BOOTS, 4);
        armorType.put(ArmorItem.Type.LEGGINGS, 7);
        armorType.put(ArmorItem.Type.CHESTPLATE, 9);
        armorType.put(ArmorItem.Type.HELMET, 4);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> {
        return Ingredient.of(ItemsInit.ENDERITE_INGOT.get());
    });

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (armorType) -> {
        armorType.put(ArmorItem.Type.BOOTS, 13);
        armorType.put(ArmorItem.Type.LEGGINGS, 15);
        armorType.put(ArmorItem.Type.CHESTPLATE, 16);
        armorType.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ArmorMaterialsInit(String name, int multiplier, EnumMap<ArmorItem.Type, Integer> type, int enchantmentValue, SoundEvent sound, float toughness, float kbResistance, Supplier<Ingredient> ingredient) {
        this.name = name;
        this.durabilityMultiplier = multiplier;
        this.protectionFunctionForType = type;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = kbResistance;
        this.repairIngredient = new LazyLoadedValue<>(ingredient);
    }

    public int getDurabilityForType(ArmorItem.Type p_266745_) {
        return HEALTH_FUNCTION_FOR_TYPE.get(p_266745_) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type p_266752_) {
        return this.protectionFunctionForType.get(p_266752_);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}