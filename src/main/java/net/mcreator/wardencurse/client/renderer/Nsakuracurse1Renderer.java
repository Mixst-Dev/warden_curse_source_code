
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

import net.mcreator.wardencurse.procedures.Aframe6Procedure;
import net.mcreator.wardencurse.procedures.Aframe5Procedure;
import net.mcreator.wardencurse.procedures.Aframe4Procedure;
import net.mcreator.wardencurse.procedures.Aframe3Procedure;
import net.mcreator.wardencurse.procedures.Aframe2Procedure;
import net.mcreator.wardencurse.procedures.Aframe1Procedure;
import net.mcreator.wardencurse.entity.Nsakuracurse1Entity;
import net.mcreator.wardencurse.client.model.Modelnsakura1;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Nsakuracurse1Renderer extends MobRenderer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>> {
	public Nsakuracurse1Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnsakura1(context.bakeLayer(Modelnsakura1.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<Nsakuracurse1Entity, Modelnsakura1<Nsakuracurse1Entity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/asakcurse6.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Nsakuracurse1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe6Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelnsakura1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelnsakura1.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(Nsakuracurse1Entity entity) {
		return new ResourceLocation("warden_curse:textures/entities/blank.png");
	}
}
