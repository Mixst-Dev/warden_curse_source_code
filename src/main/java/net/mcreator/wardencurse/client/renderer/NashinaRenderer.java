
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

import net.mcreator.wardencurse.procedures.Aframe7Procedure;
import net.mcreator.wardencurse.procedures.Aframe6Procedure;
import net.mcreator.wardencurse.procedures.Aframe5Procedure;
import net.mcreator.wardencurse.procedures.Aframe4Procedure;
import net.mcreator.wardencurse.procedures.Aframe3Procedure;
import net.mcreator.wardencurse.procedures.Aframe2Procedure;
import net.mcreator.wardencurse.procedures.Aframe1Procedure;
import net.mcreator.wardencurse.entity.NashinaEntity;
import net.mcreator.wardencurse.client.model.Modelashina2;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class NashinaRenderer extends MobRenderer<NashinaEntity, Modelashina2<NashinaEntity>> {
	public NashinaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelashina2(context.bakeLayer(Modelashina2.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow6.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe6Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinaglow7.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe7Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe5Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp6.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe6Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<NashinaEntity, Modelashina2<NashinaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("warden_curse:textures/entities/ashinatransp7.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, NashinaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (Aframe7Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelashina2(Minecraft.getInstance().getEntityModels().bakeLayer(Modelashina2.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(NashinaEntity entity) {
		return new ResourceLocation("warden_curse:textures/entities/blank.png");
	}
}
