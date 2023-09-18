package io.github.lieonlion.enderite;

import io.github.lieonlion.enderite.init.ItemsInit;
import io.github.lieonlion.enderite.item.EnderitePlatedElytraItem;
import io.github.lieonlion.enderite.render.EnderitePlatedElytraLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = Enderite.MODID)
public class EnderiteClient {
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        ItemProperties.register(ItemsInit.ENDERITE_PLATED_ELYTRA.get(), new ResourceLocation(Enderite.MODID, "broken"),
                (itemStack, clientWorld, livingEntity, seed) -> EnderitePlatedElytraItem.isFlyEnabled(itemStack) ? 0 : 1);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void renderPlayer(final EntityRenderersEvent.AddLayers event) {
        LivingEntityRenderer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> renderer = event.getSkin("default");
        EnderitePlatedElytraLayer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> layer = new EnderitePlatedElytraLayer<>(
                renderer, event.getEntityModels());
        if (renderer != null) {
            renderer.addLayer(layer);
        }

        renderer = event.getSkin("slim");
        layer = new EnderitePlatedElytraLayer<>(renderer, event.getEntityModels());
        if (renderer != null) {
            renderer.addLayer(layer);
        }

        addEntityLayer(event, EntityType.ARMOR_STAND);
        addEntityLayer(event, EntityType.ZOMBIE);
        addEntityLayer(event, EntityType.ZOMBIE_VILLAGER);
        addEntityLayer(event, EntityType.SKELETON);
        addEntityLayer(event, EntityType.HUSK);
        addEntityLayer(event, EntityType.STRAY);
        addEntityLayer(event, EntityType.WITHER_SKELETON);
        addEntityLayer(event, EntityType.DROWNED);
        addEntityLayer(event, EntityType.PIGLIN);
        addEntityLayer(event, EntityType.PIGLIN_BRUTE);
        addEntityLayer(event, EntityType.ZOMBIFIED_PIGLIN);
    }

    private static <T extends LivingEntity, M extends EntityModel<T>, R extends LivingEntityRenderer<T, M>> void addEntityLayer(
            EntityRenderersEvent.AddLayers evt, EntityType<? extends T> entityType) {
        R renderer = evt.getRenderer(entityType);

        if (renderer != null) {
            renderer.addLayer(new EnderitePlatedElytraLayer<>(renderer, evt.getEntityModels()));
        }
    }
}
