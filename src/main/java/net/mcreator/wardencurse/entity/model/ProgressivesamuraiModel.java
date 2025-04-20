package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.ProgressivesamuraiEntity;

public class ProgressivesamuraiModel extends GeoModel<ProgressivesamuraiEntity> {
	@Override
	public ResourceLocation getAnimationResource(ProgressivesamuraiEntity entity) {
		return new ResourceLocation("warden_curse", "animations/newsamuraiboss.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ProgressivesamuraiEntity entity) {
		return new ResourceLocation("warden_curse", "geo/newsamuraiboss.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ProgressivesamuraiEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ProgressivesamuraiEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
