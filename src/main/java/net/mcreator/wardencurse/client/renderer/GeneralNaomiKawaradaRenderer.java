
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.GeneralNaomiKawaradaModel;
import net.mcreator.wardencurse.entity.layer.GeneralNaomiKawaradaLayer;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GeneralNaomiKawaradaRenderer extends GeoEntityRenderer<GeneralNaomiKawaradaEntity> {
	public GeneralNaomiKawaradaRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GeneralNaomiKawaradaModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new GeneralNaomiKawaradaLayer(this));
	}

	@Override
	public RenderType getRenderType(GeneralNaomiKawaradaEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GeneralNaomiKawaradaEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1.12f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(GeneralNaomiKawaradaEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
