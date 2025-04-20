package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekiroarmorItem;

public class SekiroarmorModel extends GeoModel<SekiroarmorItem> {
	@Override
	public ResourceLocation getAnimationResource(SekiroarmorItem object) {
		return new ResourceLocation("warden_curse", "animations/geosekiro.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekiroarmorItem object) {
		return new ResourceLocation("warden_curse", "geo/geosekiro.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekiroarmorItem object) {
		return new ResourceLocation("warden_curse", "textures/item/sekiro1.png");
	}
}
