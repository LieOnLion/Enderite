package dev.lieonlion.enderite.mixin;

import dev.lieonlion.enderite.Enderite;
import dev.lieonlion.enderite.init.ItemsInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.BeaconScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(value= EnvType.CLIENT)
@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin extends HandledScreen<BeaconScreenHandler> {
    @Unique
    private static final Identifier BEACON_CONTAINER_ENDERITE_TEXTURE = Enderite.asId("textures/gui/container/beacon.png");

    public BeaconScreenMixin(BeaconScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Inject(at = @At("HEAD"), method = "drawBackground", cancellable = true)
    public void addIngots(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        ci.cancel();
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(BEACON_CONTAINER_ENDERITE_TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        context.getMatrices().push();
        context.getMatrices().translate(0.0f, 0.0f, 100.0f);
        context.drawItem(new ItemStack(ItemsInit.ENDERITE_INGOT), i + 24, j + 102);
        context.drawItem(new ItemStack(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_INGOT), i + 56, j + 102);
        context.drawItem(new ItemStack(Items.NETHERITE_INGOT), i + 88, j + 102);
        context.drawItem(new ItemStack(Items.DIAMOND), i + 22, j + 117);
        context.drawItem(new ItemStack(Items.GOLD_INGOT), i + 44, j + 117);
        context.drawItem(new ItemStack(Items.IRON_INGOT), i + 68, j + 117);
        context.drawItem(new ItemStack(Items.EMERALD), i + 90, j + 117);
        context.getMatrices().pop();
    }
}