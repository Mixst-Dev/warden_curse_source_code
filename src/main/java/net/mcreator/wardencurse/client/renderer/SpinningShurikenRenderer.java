package net.mcreator.wardencurse.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.wardencurse.entity.SpinningShurikenEntity;
import net.mcreator.wardencurse.client.model.Modelfireworkshuriken;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpinningShurikenRenderer extends EntityRenderer<SpinningShurikenEntity> {
	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/entities/texture2.png");
	private final Modelfireworkshuriken model;

	public SpinningShurikenRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelfireworkshuriken(context.bakeLayer(Modelfireworkshuriken.LAYER_LOCATION));
	}

	@Override
	public void render(SpinningShurikenEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SpinningShurikenEntity entity) {
		return texture;
	}
}
