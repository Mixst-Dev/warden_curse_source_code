package net.mcreator.wardencurse.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeln_onemind<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("warden_curse", "modeln_onemind"), "main");
	public final ModelPart entity;

	public Modeln_onemind(ModelPart root) {
		this.entity = root.getChild("entity");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition entity = partdefinition.addOrReplaceChild("entity", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition head = entity.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(244, 117).addBox(-61.0F, 0.0F, -94.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.1248F, -0.0783F, -0.7741F));
		PartDefinition head2 = entity.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.5672F));
		PartDefinition cube_r2 = head2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(244, 0).addBox(-61.0F, 0.0F, -94.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.1451F, -0.0248F, -0.3845F));
		PartDefinition head3 = entity.addOrReplaceChild("head3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1392F, -0.346F, -1.051F));
		PartDefinition cube_r3 = head3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 234).addBox(-65.0F, 0.0F, -84.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2458F, -0.4224F, 1.4158F));
		PartDefinition cube_r4 = head3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 234).addBox(-61.0F, 0.0F, -94.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.1476F, 0.0934F, -0.1814F));
		PartDefinition head4 = entity.addOrReplaceChild("head4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1558F, -0.4389F, -2.0447F));
		PartDefinition cube_r5 = head4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 117).addBox(-61.0F, 0.0F, -94.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.147F, 0.0071F, -0.1686F));
		PartDefinition head5 = entity.addOrReplaceChild("head5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5871F, -0.2268F, -2.8015F));
		PartDefinition cube_r6 = head5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-61.0F, 0.0F, -94.0F, 122.0F, 0.0F, 117.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.147F, 0.0071F, -0.1686F));
		return LayerDefinition.create(meshdefinition, 736, 736);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		entity.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
