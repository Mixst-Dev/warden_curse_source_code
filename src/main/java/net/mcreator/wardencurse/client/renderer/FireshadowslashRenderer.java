
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.FireshadowslashModel;
import net.mcreator.wardencurse.entity.layer.FireshadowslashLayer;
import net.mcreator.wardencurse.entity.FireshadowslashEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FireshadowslashRenderer extends GeoEntityRenderer<FireshadowslashEntity> {
	public FireshadowslashRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FireshadowslashModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new FireshadowslashLayer(this));
	}

	@Override
	public RenderType getRenderType(FireshadowslashEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FireshadowslashEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(FireshadowslashEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
