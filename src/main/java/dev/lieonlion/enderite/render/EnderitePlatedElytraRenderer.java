package dev.lieonlion.enderite.render;

import dev.lieonlion.enderite.Enderite;
import dev.lieonlion.enderite.init.ItemsInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderitePlatedElytraRenderer <T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier ELYTRA = new Identifier(Enderite.MODID, "textures/entity/enderite_plated_elytra.png");
//    private static final Identifier RECOLOUR = new Identifier(Enderite.MODID, "textures/entity/enderite_plated_elytra_recolour.png");
    private final ElytraEntityModel<T> elytra;

    public EnderitePlatedElytraRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.isOf(ItemsInit.ENDERITE_PLATED_ELYTRA)) {
            AbstractClientPlayerEntity abstractClientPlayerEntity;
            SkinTextures skinTextures;
            Identifier identifier = livingEntity instanceof AbstractClientPlayerEntity ?
                    ((skinTextures = (abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity).getSkinTextures()).elytraTexture() != null ?
                            skinTextures.elytraTexture() : (skinTextures.capeTexture() != null && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE) ?
                            skinTextures.capeTexture() : ELYTRA)) : ELYTRA;

            matrixStack.push();
            matrixStack.translate(0.0, 0.0, 0.125);
            this.getContextModel().copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(identifier), false, itemStack.hasGlint());
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }
}
