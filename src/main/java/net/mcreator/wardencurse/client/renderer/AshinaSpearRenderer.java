
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.AshinaSpearModel;
import net.mcreator.wardencurse.entity.layer.AshinaSpearLayer;
import net.mcreator.wardencurse.entity.AshinaSpearEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AshinaSpearRenderer extends GeoEntityRenderer<AshinaSpearEntity> {
	public AshinaSpearRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AshinaSpearModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new AshinaSpearLayer(this));
	}

	@Override
	public RenderType getRenderType(AshinaSpearEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AshinaSpearEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1.12f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(AshinaSpearEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
