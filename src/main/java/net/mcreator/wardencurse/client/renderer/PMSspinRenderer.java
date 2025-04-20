
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.PMSspinModel;
import net.mcreator.wardencurse.entity.layer.PMSspinLayer;
import net.mcreator.wardencurse.entity.PMSspinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PMSspinRenderer extends GeoEntityRenderer<PMSspinEntity> {
	public PMSspinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PMSspinModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new PMSspinLayer(this));
	}

	@Override
	public RenderType getRenderType(PMSspinEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, PMSspinEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(PMSspinEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
