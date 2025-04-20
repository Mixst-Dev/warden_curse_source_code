package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.DownSlashEntity;

public class DownSlashModel extends GeoModel<DownSlashEntity> {
	@Override
	public ResourceLocation getAnimationResource(DownSlashEntity entity) {
		return new ResourceLocation("warden_curse", "animations/downslash.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DownSlashEntity entity) {
		return new ResourceLocation("warden_curse", "geo/downslash.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DownSlashEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

}
