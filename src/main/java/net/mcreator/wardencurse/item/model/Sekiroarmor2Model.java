package net.mcreator.wardencurse.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wardencurse.item.Sekiroarmor2Item;

public class Sekiroarmor2Model extends GeoModel<Sekiroarmor2Item> {
	@Override
	public ResourceLocation getAnimationResource(Sekiroarmor2Item object) {
		return new ResourceLocation("warden_curse", "animations/geosekiro.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Sekiroarmor2Item object) {
		return new ResourceLocation("warden_curse", "geo/geosekiro.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Sekiroarmor2Item object) {
		return new ResourceLocation("warden_curse", "textures/item/sekiro1.png");
	}
}
