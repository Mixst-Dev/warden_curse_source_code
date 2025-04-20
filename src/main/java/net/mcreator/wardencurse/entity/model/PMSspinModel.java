package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.PMSspinEntity;

public class PMSspinModel extends GeoModel<PMSspinEntity> {
	@Override
	public ResourceLocation getAnimationResource(PMSspinEntity entity) {
		return new ResourceLocation("warden_curse", "animations/pms_spin_slash.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PMSspinEntity entity) {
		return new ResourceLocation("warden_curse", "geo/pms_spin_slash.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PMSspinEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

}
