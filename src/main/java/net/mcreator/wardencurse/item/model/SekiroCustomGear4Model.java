package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekiroCustomGear4Item;

public class SekiroCustomGear4Model extends GeoModel<SekiroCustomGear4Item> {
	@Override
	public ResourceLocation getAnimationResource(SekiroCustomGear4Item object) {
		return new ResourceLocation("warden_curse", "animations/c_armor_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekiroCustomGear4Item object) {
		return new ResourceLocation("warden_curse", "geo/c_armor_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekiroCustomGear4Item object) {
		return new ResourceLocation("warden_curse", "textures/item/c_skin_4.png");
	}
}
