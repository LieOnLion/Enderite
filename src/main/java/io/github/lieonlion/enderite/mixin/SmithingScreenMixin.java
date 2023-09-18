package io.github.lieonlion.enderite.mixin;

import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.client.gui.screens.inventory.SmithingScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingScreen.class)
public abstract class SmithingScreenMixin extends ItemCombinerScreen<SmithingMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/smithing.png");
    @Shadow
    @Nullable
    private ArmorStand armorStandPreview;

    public SmithingScreenMixin(SmithingMenu menu, Inventory inventory, Component container) {
        super(menu, inventory, container, TEXTURE);
    }

    @Inject(at = @At(value = "HEAD", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"), method = "updateArmorStandPreview", cancellable = true)
    private void updateArmorStandPreview(ItemStack stack, CallbackInfo ci) {
        if (stack.getItem() instanceof ElytraItem elytraItem) {
            this.armorStandPreview.setItemSlot(elytraItem.getEquipmentSlot(), stack.copy());
            ci.cancel();
        }
    }
}