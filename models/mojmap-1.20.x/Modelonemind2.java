// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelonemind2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "onemind2"), "main");
	private final ModelPart trail1;

	public Modelonemind2(ModelPart root) {
		this.trail1 = root.getChild("trail1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition trail1 = partdefinition
				.addOrReplaceChild("trail1",
						CubeListBuilder.create().texOffs(4, 6).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-2.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r1 = trail1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-32.0F, 0.25F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-32.0F, 0.0F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r2 = trail1
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -0.5F, -32.0F, 64.0F, 0.0F, 64.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, -3.098F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		trail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.trail1.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.trail1.xRot = headPitch / (180F / (float) Math.PI);
	}
}