package io.github.lieonlion.enderite.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.config.ClientConfigs;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class EnderitePlatedElytraLayer <T extends LivingEntity, M extends EntityModel<T>>
		extends RenderLayer<T, M> {
	private static final ResourceLocation ELYTRA = new ResourceLocation(Enderite.MODID, "textures/entity/enderite_plated_elytra.png");
	private static final ResourceLocation RECOLOUR = new ResourceLocation(Enderite.MODID, "textures/entity/enderite_plated_elytra_recolour.png");
	private final ElytraModel<T> elytraModel;

	public EnderitePlatedElytraLayer(RenderLayerParent<T, M> p_174493_, EntityModelSet p_174494_) {
			super(p_174493_);
			this.elytraModel = new ElytraModel<T>(p_174494_.bakeLayer(ModelLayers.ELYTRA));
	}

	public void render(@NotNull PoseStack poseStack, MultiBufferSource bufferSource, int p_116953_, T entity, float p_116955_, float p_116956_, float p_116957_, float p_116958_, float p_116959_, float p_116960_) {
		ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.CHEST);
		if (shouldRender(itemstack, entity)) {
			ResourceLocation resourcelocation;
			if (entity instanceof AbstractClientPlayer ACP) {
				if (ACP.isElytraLoaded() && ACP.getElytraTextureLocation() != null) {
					resourcelocation = ACP.getElytraTextureLocation();
				} else if (ACP.isCapeLoaded() && ACP.getCloakTextureLocation() != null && ACP.isModelPartShown(PlayerModelPart.CAPE) && ClientConfigs.ALLOW_CAPE_TEXTURE.get()) {
					resourcelocation = ACP.getCloakTextureLocation();
				} else if (ClientConfigs.RECOLOUR_ELYTRA.get()) {
					resourcelocation = RECOLOUR;
				} else {
					resourcelocation = ELYTRA;
				}
			} else if (ClientConfigs.RECOLOUR_ELYTRA.get()) {
				resourcelocation = RECOLOUR;
			} else {
				resourcelocation = ELYTRA;
			}

			poseStack.pushPose();
			poseStack.translate(0.0F, 0.0F, 0.125F);
			this.getParentModel().copyPropertiesTo(this.elytraModel);
			this.elytraModel.setupAnim(entity, p_116955_, p_116956_, p_116958_, p_116959_, p_116960_);
			VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(bufferSource, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil());
			this.elytraModel.renderToBuffer(poseStack, vertexconsumer, p_116953_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			poseStack.popPose();
		}
	}

	public boolean shouldRender(ItemStack stack, T entity) {
		return stack.getItem() == ItemsInit.ENDERITE_PLATED_ELYTRA.get();
	}
}