
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
import net.mcreator.wardencurse.entity.SparkingAxeSwipeEntity;
import net.mcreator.wardencurse.client.model.Modelcleave_flame;
import net.mcreator.wardencurse.client.model.Modelaxeswipe;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SparkingAxeSwipeRenderer extends MobRenderer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>> {
	public SparkingAxeSwipeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcleave_flame(context.bakeLayer(Modelcleave_flame.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/axe_spark_1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkingAxeSwipeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelaxeswipe(Minecraft.getInstance().getEntityModels().bakeLayer(Modelaxeswipe.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/axe_spark_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkingAxeSwipeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelaxeswipe(Minecraft.getInstance().getEntityModels().bakeLayer(Modelaxeswipe.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/axe_spark_3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkingAxeSwipeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelaxeswipe(Minecraft.getInstance().getEntityModels().bakeLayer(Modelaxeswipe.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/axe_spark_4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkingAxeSwipeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelaxeswipe(Minecraft.getInstance().getEntityModels().bakeLayer(Modelaxeswipe.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<SparkingAxeSwipeEntity, Modelcleave_flame<SparkingAxeSwipeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/axe_spark_5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SparkingAxeSwipeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelaxeswipe(Minecraft.getInstance().getEntityModels().bakeLayer(Modelaxeswipe.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SparkingAxeSwipeEntity entity) {
		return new ResourceLocation("warden_curse:textures/entities/blank.png");
	}
}
