package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.Sakura1Entity;

public class Sakura1Model extends GeoModel<Sakura1Entity> {
	@Override
	public ResourceLocation getAnimationResource(Sakura1Entity entity) {
		return new ResourceLocation("warden_curse", "animations/sakurad1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Sakura1Entity entity) {
		return new ResourceLocation("warden_curse", "geo/sakurad1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Sakura1Entity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(Sakura1Entity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
