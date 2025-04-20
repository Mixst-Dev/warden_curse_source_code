
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.CursedfireshadowslashModel;
import net.mcreator.wardencurse.entity.layer.CursedfireshadowslashLayer;
import net.mcreator.wardencurse.entity.CursedfireshadowslashEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CursedfireshadowslashRenderer extends GeoEntityRenderer<CursedfireshadowslashEntity> {
	public CursedfireshadowslashRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CursedfireshadowslashModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new CursedfireshadowslashLayer(this));
	}

	@Override
	public RenderType getRenderType(CursedfireshadowslashEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CursedfireshadowslashEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(CursedfireshadowslashEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
