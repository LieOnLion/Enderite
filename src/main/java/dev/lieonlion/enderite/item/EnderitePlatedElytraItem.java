package dev.lieonlion.enderite.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.lieonlion.enderite.init.ItemsInit;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnderitePlatedElytraItem extends ElytraItem implements FabricElytraItem {
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public EnderitePlatedElytraItem (int defense, Item.Settings settings) {
		super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", defense, EntityAttributeModifier.Operation.ADDITION));

		this.attributeModifiers = builder.build();
	}

	public boolean canRepair(ItemStack toRepair, ItemStack stack) {
		return stack.getItem() == ItemsInit.ENDERITE_INGOT;
	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.CHEST ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
}