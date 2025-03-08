package dev.lieonlion.enderite.mixin;

import net.minecraft.client.gui.screen.ingame.SmithingScreen;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingScreen.class)
public abstract class SmithingScreenMixin{
    @Shadow
    @Nullable
    private ArmorStandEntity armorStand;

    @Inject(method = "equipArmorStand", at = @At(value = "HEAD"), cancellable = true)
    private void equipArmorStand(ItemStack stack, CallbackInfo ci) {
        if (stack.getItem() instanceof ElytraItem elytraItem) {
            this.armorStand.equipStack(elytraItem.getSlotType(), stack.copy());
            ci.cancel();
        }
    }
}