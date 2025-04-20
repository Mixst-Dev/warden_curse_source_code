package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.SekiroGearCustom2Item;

public class SekiroGearCustom2Model extends GeoModel<SekiroGearCustom2Item> {
	@Override
	public ResourceLocation getAnimationResource(SekiroGearCustom2Item object) {
		return new ResourceLocation("warden_curse", "animations/c_armor_1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SekiroGearCustom2Item object) {
		return new ResourceLocation("warden_curse", "geo/c_armor_1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SekiroGearCustom2Item object) {
		return new ResourceLocation("warden_curse", "textures/item/c_skin_2.png");
	}
}
