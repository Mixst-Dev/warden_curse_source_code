package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekrioGearCustomItem;

public class SekrioGearCustomModel extends GeoModel<SekrioGearCustomItem> {
	@Override
	public ResourceLocation getAnimationResource(SekrioGearCustomItem object) {
		return new ResourceLocation("warden_curse", "animations/c_armor_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekrioGearCustomItem object) {
		return new ResourceLocation("warden_curse", "geo/c_armor_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekrioGearCustomItem object) {
		return new ResourceLocation("warden_curse", "textures/item/c_skin_1.png");
	}
}
