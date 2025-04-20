package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.SpiralcloudEntity;

public class SpiralcloudModel extends GeoModel<SpiralcloudEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpiralcloudEntity entity) {
		return new ResourceLocation("warden_curse", "animations/spiralcloud.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpiralcloudEntity entity) {
		return new ResourceLocation("warden_curse", "geo/spiralcloud.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpiralcloudEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(SpiralcloudEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
