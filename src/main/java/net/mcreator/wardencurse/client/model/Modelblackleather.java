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
public class Modelblackleather<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("warden_curse", "modelblackleather"), "main");
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;
	public final ModelPart Rightfoot;
	public final ModelPart Leftfoot;
	public final ModelPart mortalblade;

	public Modelblackleather(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Rightfoot = root.getChild("Rightfoot");
		this.Leftfoot = root.getChild("Leftfoot");
		this.mortalblade = root.getChild("mortalblade");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.3F)).texOffs(0, 39).addBox(-2.0F, -1.0F, 1.75F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(26, 34)
						.addBox(-4.0F, 0.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(0, 24).addBox(2.0F, 0.0F, -2.0F, 2.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(0, 0)
						.addBox(-4.75F, 8.5F, -3.0F, 9.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(12, 66).addBox(-0.25F, -0.5F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(4.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(32, 63).addBox(0.25F, -4.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5861F, 1.1659F, -1.8376F, 0.5672F, 0.0F, 0.2618F));
		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(67, 7).addBox(-0.25F, -4.0F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5861F, 1.1659F, -1.8376F, 0.5672F, 0.0F, -0.2618F));
		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(22, 66).addBox(-0.75F, -0.5F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-4.0F, -2.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(13, 8).addBox(-1.0F, -1.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-1.75F, 9.5F, -2.5F, 0.0F, 0.0873F, 0.0F));
		PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(74, 23).addBox(-1.5F, -1.0F, -1.25F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.25F, 9.5F, 0.0F, 0.0F, 0.0F, -0.2182F));
		PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(29, 74).addBox(0.25F, -1.0F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.25F, 9.5F, 0.0F, 0.0F, 0.0F, 0.2182F));
		PartDefinition Body_r8 = Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(65, 0).addBox(-3.5F, -4.5F, 0.75F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.1917F, 12.9498F, 0.8054F, 0.0F, -1.5708F, -0.2182F));
		PartDefinition Body_r9 = Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(65, 73).addBox(-2.0F, -4.25F, -0.5F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 13.0F, -2.75F, -0.1309F, -0.3054F, -0.0873F));
		PartDefinition Body_r10 = Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(65, 65).addBox(-2.5F, -4.5F, 0.5F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.1917F, 12.9498F, 0.8054F, 0.0F, 1.5708F, 0.2182F));
		PartDefinition Body_r11 = Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(71, 54).addBox(0.403F, -3.6826F, 0.7224F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.6395F, 3.5648F, 0.2223F, 0.3118F, -0.0595F));
		PartDefinition Body_r12 = Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(40, 73).addBox(-5.403F, -3.6826F, 0.7224F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.6395F, 3.5648F, 0.2223F, -0.3118F, 0.0595F));
		PartDefinition Body_r13 = Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, 74).addBox(-3.0F, -4.25F, -0.5F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 13.0F, -2.75F, -0.1309F, 0.3054F, 0.0873F));
		PartDefinition Body_r14 = Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, 42).addBox(-1.25F, -4.0F, 0.75F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.25F, 12.5F, 3.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition Body_r15 = Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(7, 38).addBox(-1.5F, -3.0F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 6.0024F, -1.3387F, 0.0873F, 0.0F, 0.0F));
		PartDefinition Body_r16 = Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -3.5F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 4.5F, -1.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(59, 27).addBox(-3.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(16, 49).addBox(-3.0F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(0, 48)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.35F)).texOffs(73, 16).addBox(-4.25F, 4.5F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-2.5F, -0.75F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.6537F, -0.7041F, 2.3034F, -1.1781F, 0.0F, -0.1745F));
		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2",
				CubeListBuilder.create().texOffs(24, 3).addBox(-1.5F, -1.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 26).addBox(-1.5F, -1.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.6537F, -0.7041F, -2.3034F, 1.1781F, 0.0F, -0.1745F));
		PartDefinition RightArm_r3 = RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(27, 54).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0314F, -0.0283F, -2.4297F, 1.3093F, -0.0167F, -0.2148F));
		PartDefinition RightArm_r4 = RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(59, 20).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.6371F, -0.6099F, -2.0725F, 1.1784F, -0.0167F, -0.2148F));
		PartDefinition RightArm_r5 = RightArm.addOrReplaceChild("RightArm_r5",
				CubeListBuilder.create().texOffs(45, 56).addBox(-3.25F, -0.75F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 26).addBox(-3.0F, -0.5F, -2.5F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5207F, -1.2815F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition RightArm_r6 = RightArm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(47, 34).addBox(-3.5F, -0.5F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.671F, -2.4698F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition RightArm_r7 = RightArm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(10, 76).addBox(-1.5F, -1.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.5F, 6.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition RightArm_r8 = RightArm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(75, 10).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.424F, 6.0F, -2.4334F, 0.0F, -1.8762F, 0.0F));
		PartDefinition RightArm_r9 = RightArm.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(75, 69).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-1.424F, 6.0F, 2.4334F, 0.0F, 1.8762F, 0.0F));
		PartDefinition RightArm_r10 = RightArm.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(18, 76).addBox(-1.5F, -1.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.5F, 6.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(34, 45).addBox(-1.0F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(47, 22).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.35F)).texOffs(69, 41)
						.addBox(0.25F, 4.5F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 59).addBox(-1.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.26F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(53, 14).addBox(-2.5F, -0.75F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6537F, -0.7041F, 2.3034F, -1.1781F, 0.0F, 0.1745F));
		PartDefinition LeftArm_r2 = LeftArm.addOrReplaceChild("LeftArm_r2",
				CubeListBuilder.create().texOffs(0, 24).addBox(0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 8).addBox(0.5F, -1.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6537F, -0.7041F, -2.3034F, 1.1781F, 0.0F, 0.1745F));
		PartDefinition LeftArm_r3 = LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(52, 5).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0314F, -0.0283F, -2.4297F, 1.3093F, 0.0167F, 0.2148F));
		PartDefinition LeftArm_r4 = LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(46, 50).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6371F, -0.6099F, -2.0725F, 1.1784F, 0.0167F, 0.2148F));
		PartDefinition LeftArm_r5 = LeftArm.addOrReplaceChild("LeftArm_r5",
				CubeListBuilder.create().texOffs(49, 42).addBox(-2.75F, -0.75F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(29, 18).addBox(-3.0F, -0.5F, -2.5F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5207F, -1.2815F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition LeftArm_r6 = LeftArm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(43, 0).addBox(-2.5F, -0.5F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.671F, -2.4698F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition LeftArm_r7 = LeftArm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(75, 75).addBox(0.5F, -1.0F, -3.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(2.5F, 6.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition LeftArm_r8 = LeftArm.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(74, 47).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.424F, 6.0F, -2.4334F, 0.0F, 1.8762F, 0.0F));
		PartDefinition LeftArm_r9 = LeftArm.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(73, 4).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(1.424F, 6.0F, 2.4334F, 0.0F, -1.8762F, 0.0F));
		PartDefinition LeftArm_r10 = LeftArm.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(34, 12).addBox(0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(2.5F, 6.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(14, 23).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(69, 35).addBox(-0.5F, 7.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(43, 7).addBox(-3.0F, -2.0F, -0.75F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-1.9924F, 2.4132F, 0.0F, 1.5708F, 1.3526F, 1.5708F));
		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -2.0F, -4.25F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-1.9924F, 2.4132F, 0.0F, -1.5708F, -1.3526F, 1.5708F));
		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(53, 65).addBox(-1.5F, -2.5F, -2.5F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(-1.5F, 2.5F, 0.25F, 0.0F, 0.0F, 0.0873F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(18, 8).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(62, 34).addBox(-0.5F, 7.0F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(38, 34).addBox(1.0F, -2.0F, -0.75F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(1.9924F, 2.4132F, 0.0F, 1.5708F, -1.3526F, -1.5708F));
		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(62, 43).addBox(1.0F, -2.0F, -4.25F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(1.9924F, 2.4132F, 0.0F, -1.5708F, 1.3526F, -1.5708F));
		PartDefinition LeftLeg_r3 = LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(41, 62).addBox(0.5F, -2.5F, -2.5F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offsetAndRotation(1.5F, 2.5F, 0.25F, 0.0F, 0.0F, -0.0873F));
		PartDefinition Rightfoot = partdefinition.addOrReplaceChild("Rightfoot", CubeListBuilder.create().texOffs(30, 60).addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition cube_r1 = Rightfoot.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 3).addBox(-0.25F, -0.25F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.5F)).texOffs(8, 24).addBox(-1.25F, 0.5F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(-0.5F, 10.9037F, -4.6147F, 0.1745F, 0.0F, 0.0F));
		PartDefinition Leftfoot = partdefinition.addOrReplaceChild("Leftfoot", CubeListBuilder.create().texOffs(59, 58).addBox(-2.0F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition cube_r2 = Leftfoot.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, -0.25F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.5F)).texOffs(24, 0).addBox(-1.75F, 0.5F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.5F, 10.9037F, -4.6147F, 0.1745F, 0.0F, 0.0F));
		PartDefinition mortalblade = partdefinition.addOrReplaceChild("mortalblade", CubeListBuilder.create(), PartPose.offset(-1.7605F, 7.2372F, 4.0132F));
		PartDefinition cube_r3 = mortalblade.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(82, 23).addBox(-1.25F, -2.25F, -1.75F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 79).addBox(-0.25F, 11.75F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(75, 62)
						.addBox(-0.25F, 8.75F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(84, 27).addBox(-0.25F, -9.25F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1308F, 0.0057F, -0.6105F));
		PartDefinition katana = mortalblade.addOrReplaceChild("katana", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r4 = katana.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(57, 76).addBox(-0.25F, -20.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(85, 63).addBox(-0.25F, -19.25F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(81, 53)
						.addBox(-1.25F, -10.25F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(81, 58).addBox(-0.25F, -12.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1308F, 0.0057F, -0.6105F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rightfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leftfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mortalblade.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
