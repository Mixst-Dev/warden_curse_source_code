
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.AncientSkulkVessleModel;
import net.mcreator.wardencurse.entity.layer.AncientSkulkVessleLayer;
import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AncientSkulkVessleRenderer extends GeoEntityRenderer<AncientSkulkVessleEntity> {
	public AncientSkulkVessleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AncientSkulkVessleModel());
		this.shadowRadius = 1f;
		this.addRenderLayer(new AncientSkulkVessleLayer(this));
	}

	@Override
	public RenderType getRenderType(AncientSkulkVessleEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AncientSkulkVessleEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1.2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(AncientSkulkVessleEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
