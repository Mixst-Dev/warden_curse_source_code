package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.IgrizsiroItem;

public class IgrizsiroModel extends GeoModel<IgrizsiroItem> {
	@Override
	public ResourceLocation getAnimationResource(IgrizsiroItem object) {
		return new ResourceLocation("warden_curse", "animations/igrizsekiro.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IgrizsiroItem object) {
		return new ResourceLocation("warden_curse", "geo/igrizsekiro.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IgrizsiroItem object) {
		return new ResourceLocation("warden_curse", "textures/item/igrizsekiro.png");
	}
}
