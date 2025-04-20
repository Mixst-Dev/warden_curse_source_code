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
public class Modelonemind1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("warden_curse", "modelonemind_1"), "main");
	public final ModelPart trail1;

	public Modelonemind1(ModelPart root) {
		this.trail1 = root.getChild("trail1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition trail1 = partdefinition.addOrReplaceChild("trail1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.1745F, 0.0F, -0.48F));
		PartDefinition trail1_r1 = trail1.addOrReplaceChild("trail1_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, 0.25F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-32.0F, 0.0F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition trail1_r2 = trail1.addOrReplaceChild("trail1_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -0.5F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.0F, -3.098F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		trail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.trail1.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.trail1.xRot = headPitch / (180F / (float) Math.PI);
	}
}
