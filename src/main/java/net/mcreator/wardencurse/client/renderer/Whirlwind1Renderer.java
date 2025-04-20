
package net.mcreator.wardencurse.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.model.Whirlwind1Model;
import net.mcreator.wardencurse.entity.layer.Whirlwind1Layer;
import net.mcreator.wardencurse.entity.Whirlwind1Entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Whirlwind1Renderer extends GeoEntityRenderer<Whirlwind1Entity> {
	public Whirlwind1Renderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new Whirlwind1Model());
		this.shadowRadius = 0f;
		this.addRenderLayer(new Whirlwind1Layer(this));
	}

	@Override
	public RenderType getRenderType(Whirlwind1Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, Whirlwind1Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1.2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(Whirlwind1Entity entityLivingBaseIn) {
		return 0.0F;
	}
}
