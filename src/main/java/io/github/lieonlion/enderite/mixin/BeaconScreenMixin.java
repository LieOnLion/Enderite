package io.github.lieonlion.enderite.mixin;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BeaconMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin extends AbstractContainerScreen<BeaconMenu> {

    public BeaconScreenMixin(BeaconMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Inject(at = @At(value = "HEAD"), method = "renderBg", cancellable = true)
    public void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        ci.cancel();
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        graphics.blit(Enderite.BG_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
        graphics.pose().pushPose();
        graphics.pose().translate(0.0F, 0.0F, 100.0F);
        graphics.renderItem(new ItemStack(ItemsInit.ENDERITE_INGOT.get()), i + 24, j + 102);
        graphics.renderItem(new ItemStack(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_INGOT.get()), i + 56, j + 102);
        graphics.renderItem(new ItemStack(Items.NETHERITE_INGOT), i + 88, j + 102);
        graphics.renderItem(new ItemStack(Items.DIAMOND), i + 22, j + 117);
        graphics.renderItem(new ItemStack(Items.GOLD_INGOT), i + 44, j + 117);
        graphics.renderItem(new ItemStack(Items.IRON_INGOT), i + 68, j + 117);
        graphics.renderItem(new ItemStack(Items.EMERALD), i + 90, j + 117);
        graphics.pose().popPose();
    }
}