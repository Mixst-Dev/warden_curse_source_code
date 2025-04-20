
package net.mcreator.wardencurse.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.wardencurse.procedures.Aframe5Procedure;
import net.mcreator.wardencurse.procedures.Aframe4Procedure;
import net.mcreator.wardencurse.procedures.Aframe3Procedure;
import net.mcreator.wardencurse.procedures.Aframe2Procedure;
import net.mcreator.wardencurse.procedures.Aframe1Procedure;
import net.mcreator.wardencurse.entity.Whirlwindfire1Entity;
import net.mcreator.wardencurse.client.model.Modelwhirlwind_1;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Whirlwindfire1Renderer extends MobRenderer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>> {
	public Whirlwindfire1Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelwhirlwind_1(context.bakeLayer(Modelwhirlwind_1.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/whirl_fire_1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Whirlwindfire1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelwhirlwind_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelwhirlwind_1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/whirl_fire_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Whirlwindfire1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelwhirlwind_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelwhirlwind_1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/whirl_fire_3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Whirlwindfire1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelwhirlwind_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelwhirlwind_1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/whirl_fire_4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Whirlwindfire1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelwhirlwind_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelwhirlwind_1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Whirlwindfire1Entity, Modelwhirlwind_1<Whirlwindfire1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/whirl_fire_5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Whirlwindfire1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelwhirlwind_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelwhirlwind_1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	protected void scale(Whirlwindfire1Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.02f, 1.02f, 1.02f);
	}

	@Override
	public ResourceLocation getTextureLocation(Whirlwindfire1Entity entity) {
		return new ResourceLocation("warden_curse:textures/entities/blank.png");
	}
}
