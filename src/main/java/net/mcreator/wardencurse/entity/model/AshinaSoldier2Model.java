package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.AshinaSoldier2Entity;

public class AshinaSoldier2Model extends GeoModel<AshinaSoldier2Entity> {
	@Override
	public ResourceLocation getAnimationResource(AshinaSoldier2Entity entity) {
		return new ResourceLocation("warden_curse", "animations/ashina_enemy_2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AshinaSoldier2Entity entity) {
		return new ResourceLocation("warden_curse", "geo/ashina_enemy_2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AshinaSoldier2Entity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(AshinaSoldier2Entity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
