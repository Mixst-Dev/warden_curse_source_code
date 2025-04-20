package net.mcreator.wardencurse.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.entity.SculkSoldier1Entity;

public class SculkSoldier1Model extends GeoModel<SculkSoldier1Entity> {
	@Override
	public ResourceLocation getAnimationResource(SculkSoldier1Entity entity) {
		return new ResourceLocation("warden_curse", "animations/sculk_enemy_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SculkSoldier1Entity entity) {
		return new ResourceLocation("warden_curse", "geo/sculk_enemy_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SculkSoldier1Entity entity) {
		return new ResourceLocation("warden_curse", "textures/entities/" + entity.getTexture() + ".png");
	}

}
