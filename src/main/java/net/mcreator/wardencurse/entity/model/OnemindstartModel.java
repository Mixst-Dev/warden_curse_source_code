package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.OnemindstartEntity;

public class OnemindstartModel extends GeoModel<OnemindstartEntity> {
	@Override
	public ResourceLocation getAnimationResource(OnemindstartEntity entity) {
		return new ResourceLocation("warden_curse", "animations/onemindstart.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OnemindstartEntity entity) {
		return new ResourceLocation("warden_curse", "geo/onemindstart.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OnemindstartEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(OnemindstartEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
