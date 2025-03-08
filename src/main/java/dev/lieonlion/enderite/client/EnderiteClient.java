package dev.lieonlion.enderite.client;

import dev.lieonlion.enderite.Enderite;
import dev.lieonlion.enderite.init.ItemsInit;
import dev.lieonlion.enderite.item.EnderitePlatedElytraItem;
import dev.lieonlion.enderite.render.EnderitePlatedElytraRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EnderiteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(ItemsInit.ENDERITE_PLATED_ELYTRA.asItem(),
                new Identifier(Enderite.MODID, "broken"),
                (itemStack, clientWorld, livingEntity, seed) -> EnderitePlatedElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);
        LivingEntityFeatureRendererRegistrationCallback.EVENT
                .register((entityType, entityRenderer, registrationHelper, context) -> {
                    registrationHelper
                            .register(new EnderitePlatedElytraRenderer<>(entityRenderer,
                                    context.getModelLoader()));
                });
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EnderiteClient::allowCapeRender);
    }

    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isOf(ItemsInit.ENDERITE_PLATED_ELYTRA));
    }
}