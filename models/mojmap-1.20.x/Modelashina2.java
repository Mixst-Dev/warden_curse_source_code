// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelashina2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ashina2"), "main");
	private final ModelPart head;

	public Modelashina2(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition slash1 = head.addOrReplaceChild("slash1", CubeListBuilder.create(),
				PartPose.offset(14.0F, 1.0F, 0.0F));

		PartDefinition cube_r1 = slash1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 108)
						.addBox(-36.0F, 0.75F, -54.0F, 72.0F, 0.0F, 108.0F, new CubeDeformation(0.0F)).texOffs(0, 108)
						.addBox(-36.0F, 0.0F, -54.0F, 72.0F, 0.0F, 108.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -1.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition slash2 = head.addOrReplaceChild("slash2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(37.0F, -6.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r2 = slash2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-41.0F, 0.0F, -54.0F, 84.0F, 0.0F, 108.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-41.0F, -1.0F, -54.0F, 84.0F, 0.0F, 108.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}