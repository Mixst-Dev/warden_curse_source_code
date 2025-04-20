
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.ShadowslashModel;
import net.mcreator.wardencurse.entity.layer.ShadowslashLayer;
import net.mcreator.wardencurse.entity.ShadowslashEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ShadowslashRenderer extends GeoEntityRenderer<ShadowslashEntity> {
	public ShadowslashRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ShadowslashModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new ShadowslashLayer(this));
	}

	@Override
	public RenderType getRenderType(ShadowslashEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ShadowslashEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1.3f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ShadowslashEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
