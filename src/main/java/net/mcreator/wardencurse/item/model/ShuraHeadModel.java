package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.ShuraHeadItem;

public class ShuraHeadModel extends GeoModel<ShuraHeadItem> {
	@Override
	public ResourceLocation getAnimationResource(ShuraHeadItem object) {
		return new ResourceLocation("warden_curse", "animations/headshura.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShuraHeadItem object) {
		return new ResourceLocation("warden_curse", "geo/headshura.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShuraHeadItem object) {
		return new ResourceLocation("warden_curse", "textures/item/shurahead.png");
	}
}
