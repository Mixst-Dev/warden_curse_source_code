// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftFoot;

	public Modelcustom_model(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.RightFoot = root.getChild("RightFoot");
		this.LeftFoot = root.getChild("LeftFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 28).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(70, 48)
						.addBox(-1.25F, -10.25F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 57)
						.addBox(-0.25F, -20.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 59)
						.addBox(-0.25F, -12.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 26)
						.addBox(-0.25F, 8.75F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(18, 52)
						.addBox(-0.25F, 11.75F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(68, 87)
						.addBox(-0.25F, -19.25F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(90, 0)
						.addBox(-1.25F, -2.25F, -1.75F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 28)
						.addBox(-0.25F, -9.25F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.7605F, 7.2372F, 4.0132F, 0.1308F, 0.0057F, -0.6105F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(68, 60).addBox(-2.5F, -10.0F, -0.25F, 5.0F, 20.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.6608F, 10.8038F, 3.6229F, 3.0977F, -0.1737F, 3.0795F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(32, 85).addBox(-0.4456F, -9.0F, -0.3967F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7513F, 9.5323F, -2.2296F, 0.0151F, -1.3951F, -0.0788F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(26, 85).addBox(-1.25F, -9.0F, 0.0F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.735F, 9.6006F, -3.4288F, -0.0195F, -0.3474F, -0.1109F));

		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(84, 81).addBox(-0.5728F, -9.2914F, -1.6107F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0178F, 9.8717F, 0.1397F, -3.1409F, -1.3536F, 3.0769F));

		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -0.5F, 5.0F, 10.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.2496F, 5.5198F, 3.5772F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(16, 73).addBox(-4.637F, -9.1824F, -3.3509F, 5.0F, 20.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8082F, 9.8465F, 0.1583F, 3.0426F, 0.2198F, -3.0981F));

		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(76, 81).addBox(-3.4169F, -9.275F, -1.5627F, 4.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8082F, 9.8465F, 0.1583F, 2.7482F, 1.3423F, 2.8653F));

		PartDefinition cube_r9 = Body.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(56, 87).addBox(-0.132F, -9.275F, -1.6627F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8082F, 9.8465F, 0.1583F, 0.3727F, 1.3301F, 0.4708F));

		PartDefinition cube_r10 = Body.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(62, 87).addBox(-0.4895F, -9.2707F, -3.6738F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8082F, 9.8465F, 0.1583F, 0.0479F, 0.1665F, 0.134F));

		PartDefinition cube_r11 = Body.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(10, 91).addBox(-1.5F, -6.0F, 0.0F, 2.0F, 9.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 6.0F, -3.0F, 0.0822F, 0.1341F, -0.0324F));

		PartDefinition cube_r12 = Body.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(26, 75).addBox(-2.851F, -1.8704F, -2.0806F, 4.0F, 5.0F, 5.0F,
						new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(-3.0122F, 8.6704F, -1.7019F, 0.0794F, 0.1944F, -0.5364F));

		PartDefinition cube_r13 = Body.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(82, 48).addBox(0.3354F, -3.2585F, -2.1031F, 2.0F, 6.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0122F, 8.6704F, -1.4519F, -0.0614F, 0.0001F, -0.6945F));

		PartDefinition cube_r14 = Body.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(74, 36).addBox(-3.25F, -4.0F, -3.0F, 4.0F, 7.0F, 5.0F,
						new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(3.0125F, 9.8438F, -0.2852F, -0.0071F, -0.2711F, 0.2408F));

		PartDefinition cube_r15 = Body.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(68, 8).addBox(-2.0F, -2.5F, -3.25F, 4.0F, 4.0F, 6.0F,
						new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(-1.5795F, 13.3316F, 0.8988F, -0.075F, -0.1049F, 0.4089F));

		PartDefinition cube_r16 = Body.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(22, 0).addBox(-5.0F, -1.0F, -3.25F, 10.0F, 2.0F, 6.0F,
						new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(1.0996F, 11.1048F, 1.5513F, -0.0399F, -0.1226F, 0.102F));

		PartDefinition cube_r17 = Body.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(48, 0).addBox(-2.25F, -0.5F, -0.25F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.4873F, 9.9339F, -3.528F, -0.0486F, 0.6185F, 0.2435F));

		PartDefinition cube_r18 = Body.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(82, 6).addBox(-4.5F, -2.75F, 0.25F, 9.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3493F, 12.8418F, -3.5009F, -0.0396F, 0.0082F, 0.0968F));

		PartDefinition cube_r19 = Body.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(72, 0).addBox(-2.9522F, -1.0F, -3.5851F, 7.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7497F, 11.0872F, -0.4833F, -0.0397F, -0.079F, 0.1002F));

		PartDefinition cube_r20 = Body.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(84, 26).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F,
						new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(-1.7106F, 10.5032F, -1.7137F, -0.088F, -0.0943F, 0.7146F));

		PartDefinition cube_r21 = Body.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(0, 75).addBox(-2.3995F, -5.0F, -2.1116F, 2.0F, 8.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.9369F, 9.3347F, -1.3688F, -0.0703F, -0.1081F, 0.5397F));

		PartDefinition cube_r22 = Body.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(0, 88).addBox(-1.5F, -6.0F, 0.0F, 3.0F, 9.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 6.0F, -3.0F, 0.0822F, -0.1341F, 0.0324F));

		PartDefinition cube_r23 = Body.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(61, 8).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0376F, 3.0687F, -4.3864F, -0.0324F, -0.0319F, 0.7875F));

		PartDefinition cube_r24 = Body.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(90, 91).addBox(-2.25F, -3.0F, 1.0F, 4.0F, 11.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.7009F, 3.1844F, 3.7899F, 0.1729F, -0.0455F, 0.0421F));

		PartDefinition cube_r25 = Body.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(18, 93).addBox(-1.75F, -3.0F, -0.25F, 4.0F, 9.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7009F, 3.1844F, -3.7899F, -0.042F, -0.0455F, -0.0421F));

		PartDefinition cube_r26 = Body.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 4.0F, 10.0F,
						new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(2.3151F, 1.0202F, -0.0478F, -0.0811F, -0.0275F, -0.3483F));

		PartDefinition cube_r27 = Body.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 4.0F, 10.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.0436F, 0.0F, 0.1745F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(20, 57)
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r28 = RightArm.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(56, 81).addBox(-4.0F, 0.25F, -2.0F, 6.0F, 2.0F, 4.0F,
						new CubeDeformation(0.7F)),
				PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r29 = RightArm.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(88, 34).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(-1.3147F, -0.2415F, 1.0F, -0.0873F, 0.0F, -0.2618F));

		PartDefinition cube_r30 = RightArm.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(88, 70).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(-1.3147F, -0.2415F, -1.0F, 0.0873F, 0.0F, -0.2618F));

		PartDefinition cube_r31 = RightArm.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(44, 51)
						.addBox(-5.25F, -6.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.4F)).texOffs(0, 52)
						.addBox(-3.25F, -1.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(-0.8105F, 8.7703F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r32 = RightArm.addOrReplaceChild("cube_r32",
				CubeListBuilder.create().texOffs(54, 0).addBox(-3.5F, 2.25F, -3.0F, 6.0F, 2.0F, 6.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-1.0F, 3.5F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r33 = RightArm
				.addOrReplaceChild("cube_r33",
						CubeListBuilder.create().texOffs(64, 53).addBox(-3.0F, 0.75F, -3.0F, 6.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.0F, 3.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r34 = RightArm
				.addOrReplaceChild("cube_r34",
						CubeListBuilder.create().texOffs(84, 19).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F,
								new CubeDeformation(0.5F)),
						PartPose.offsetAndRotation(-1.0F, 9.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(36, 59)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(84, 14)
						.addBox(-1.0F, 4.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.7F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r35 = LeftArm.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -2.25F, -0.5F, 2.0F, 7.0F, 2.0F,
						new CubeDeformation(0.6F)),
				PartPose.offsetAndRotation(1.3147F, -0.2415F, 1.0F, 0.0433F, -0.0057F, 0.3926F));

		PartDefinition cube_r36 = LeftArm.addOrReplaceChild("cube_r36",
				CubeListBuilder.create().texOffs(92, 40).addBox(-2.5F, -2.25F, -1.5F, 2.0F, 7.0F, 2.0F,
						new CubeDeformation(0.6F)),
				PartPose.offsetAndRotation(1.3147F, -0.2415F, -1.0F, -0.0433F, 0.0057F, 0.3926F));

		PartDefinition cube_r37 = LeftArm.addOrReplaceChild("cube_r37",
				CubeListBuilder.create().texOffs(46, 74)
						.addBox(-2.5F, -2.75F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)).texOffs(72, 74)
						.addBox(-2.5F, 0.25F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(1.5F, 1.5F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition cube_r38 = LeftArm.addOrReplaceChild("cube_r38",
				CubeListBuilder.create().texOffs(62, 51).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 9.0F, -1.0F, 0.1719F, 0.7703F, 0.2444F));

		PartDefinition cube_r39 = LeftArm
				.addOrReplaceChild("cube_r39",
						CubeListBuilder.create().texOffs(32, 8).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F,
								new CubeDeformation(0.7F)),
						PartPose.offsetAndRotation(1.0F, 9.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(52, 59)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1",
				CubeListBuilder.create().texOffs(22, 14).addBox(-3.5F, -1.25F, -3.5F, 7.0F, 2.0F, 7.0F,
						new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2",
				CubeListBuilder.create().texOffs(50, 16)
						.addBox(-2.75F, 1.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)).texOffs(26, 49)
						.addBox(-2.75F, 0.25F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition LeftLeg_r3 = LeftLeg.addOrReplaceChild("LeftLeg_r3",
				CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -0.75F, -3.0F, 6.0F, 2.0F, 6.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftLeg_r4 = LeftLeg.addOrReplaceChild("LeftLeg_r4",
				CubeListBuilder.create().texOffs(32, 23).addBox(-3.0F, -1.25F, -3.0F, 6.0F, 3.0F, 6.0F,
						new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition LeftLeg_r5 = LeftLeg.addOrReplaceChild("LeftLeg_r5",
				CubeListBuilder.create().texOffs(40, 81).mirror()
						.addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.9F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(52, 59).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1",
				CubeListBuilder.create().texOffs(50, 16).mirror()
						.addBox(-3.25F, 1.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)).mirror(false)
						.texOffs(26, 49).mirror()
						.addBox(-3.25F, 0.25F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2",
				CubeListBuilder.create().texOffs(0, 44).mirror()
						.addBox(-3.0F, -0.75F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.3F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3",
				CubeListBuilder.create().texOffs(32, 23).mirror()
						.addBox(-3.0F, -1.25F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(-0.4F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition RightLeg_r4 = RightLeg
				.addOrReplaceChild("RightLeg_r4",
						CubeListBuilder.create().texOffs(40, 81).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F,
								new CubeDeformation(0.9F)),
						PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition RightFoot = partdefinition.addOrReplaceChild("RightFoot", CubeListBuilder.create(),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition cube_r40 = RightFoot.addOrReplaceChild("cube_r40",
				CubeListBuilder.create().texOffs(90, 84)
						.addBox(-0.75F, -1.75F, -5.75F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).texOffs(38, 91)
						.addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r41 = RightFoot
				.addOrReplaceChild("cube_r41",
						CubeListBuilder.create().texOffs(68, 28).addBox(-3.25F, -1.0F, -3.0F, 5.0F, 2.0F, 6.0F,
								new CubeDeformation(-0.1F)),
						PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r42 = RightFoot
				.addOrReplaceChild("cube_r42",
						CubeListBuilder.create().texOffs(43, 8).addBox(-3.25F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftFoot = partdefinition.addOrReplaceChild("LeftFoot", CubeListBuilder.create(),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r43 = LeftFoot.addOrReplaceChild("cube_r43",
				CubeListBuilder.create().texOffs(90, 77)
						.addBox(-1.25F, -1.75F, -5.75F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)).texOffs(90, 59)
						.addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r44 = LeftFoot
				.addOrReplaceChild("cube_r44",
						CubeListBuilder.create().texOffs(68, 18).addBox(-1.75F, -1.0F, -3.0F, 5.0F, 2.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r45 = LeftFoot
				.addOrReplaceChild("cube_r45",
						CubeListBuilder.create().texOffs(32, 41).addBox(-2.75F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}