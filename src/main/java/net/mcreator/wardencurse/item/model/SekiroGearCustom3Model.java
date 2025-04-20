package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekiroGearCustom3Item;

public class SekiroGearCustom3Model extends GeoModel<SekiroGearCustom3Item> {
	@Override
	public ResourceLocation getAnimationResource(SekiroGearCustom3Item object) {
		return new ResourceLocation("warden_curse", "animations/c_armor_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekiroGearCustom3Item object) {
		return new ResourceLocation("warden_curse", "geo/c_armor_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekiroGearCustom3Item object) {
		return new ResourceLocation("warden_curse", "textures/item/c_skin_3.png");
	}
}
