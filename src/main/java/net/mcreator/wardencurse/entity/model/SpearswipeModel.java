package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.SpearswipeEntity;

public class SpearswipeModel extends GeoModel<SpearswipeEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpearswipeEntity entity) {
		return new ResourceLocation("warden_curse", "animations/spearswipe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpearswipeEntity entity) {
		return new ResourceLocation("warden_curse", "geo/spearswipe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpearswipeEntity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

}
