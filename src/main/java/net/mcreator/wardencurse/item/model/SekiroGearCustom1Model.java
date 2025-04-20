package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekiroGearCustom1Item;

public class SekiroGearCustom1Model extends GeoModel<SekiroGearCustom1Item> {
	@Override
	public ResourceLocation getAnimationResource(SekiroGearCustom1Item object) {
		return new ResourceLocation("warden_curse", "animations/c_armor_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekiroGearCustom1Item object) {
		return new ResourceLocation("warden_curse", "geo/c_armor_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekiroGearCustom1Item object) {
		return new ResourceLocation("warden_curse", "textures/item/c_skin_1.png");
	}
}
