package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.ShuraItem;

public class ShuraModel extends GeoModel<ShuraItem> {
	@Override
	public ResourceLocation getAnimationResource(ShuraItem object) {
		return new ResourceLocation("warden_curse", "animations/shura.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShuraItem object) {
		return new ResourceLocation("warden_curse", "geo/shura.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShuraItem object) {
		return new ResourceLocation("warden_curse", "textures/item/shura.png");
	}
}
