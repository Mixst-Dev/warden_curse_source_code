
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.wardencurse.client.model.Modelwhirlwind_2;
import net.mcreator.wardencurse.client.model.Modelwhirlwind_1;
import net.mcreator.wardencurse.client.model.Modelswordtrail1;
import net.mcreator.wardencurse.client.model.Modelshurkien1;
import net.mcreator.wardencurse.client.model.Modelsakura11;
import net.mcreator.wardencurse.client.model.Modelrock1;
import net.mcreator.wardencurse.client.model.Modelpointer;
import net.mcreator.wardencurse.client.model.Modelonemind2;
import net.mcreator.wardencurse.client.model.Modelonemind1;
import net.mcreator.wardencurse.client.model.Modelnsakura3;
import net.mcreator.wardencurse.client.model.Modelnsakura2;
import net.mcreator.wardencurse.client.model.Modelnsakura1;
import net.mcreator.wardencurse.client.model.Modeln_onemind;
import net.mcreator.wardencurse.client.model.Modelleap1;
import net.mcreator.wardencurse.client.model.Modelflames3;
import net.mcreator.wardencurse.client.model.Modelflames2;
import net.mcreator.wardencurse.client.model.Modelflames1;
import net.mcreator.wardencurse.client.model.Modelfireworkshuriken;
import net.mcreator.wardencurse.client.model.Modelemmacross2;
import net.mcreator.wardencurse.client.model.Modelemmacross;
import net.mcreator.wardencurse.client.model.Modeldragonflash1;
import net.mcreator.wardencurse.client.model.Modelcustom_model;
import net.mcreator.wardencurse.client.model.Modelcleave_flame;
import net.mcreator.wardencurse.client.model.Modelblackleather;
import net.mcreator.wardencurse.client.model.Modelaxeswipe;
import net.mcreator.wardencurse.client.model.Modelashina2;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class WardenCurseModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelemmacross2.LAYER_LOCATION, Modelemmacross2::createBodyLayer);
		event.registerLayerDefinition(Modelleap1.LAYER_LOCATION, Modelleap1::createBodyLayer);
		event.registerLayerDefinition(Modelnsakura2.LAYER_LOCATION, Modelnsakura2::createBodyLayer);
		event.registerLayerDefinition(Modelswordtrail1.LAYER_LOCATION, Modelswordtrail1::createBodyLayer);
		event.registerLayerDefinition(Modelflames1.LAYER_LOCATION, Modelflames1::createBodyLayer);
		event.registerLayerDefinition(Modelnsakura3.LAYER_LOCATION, Modelnsakura3::createBodyLayer);
		event.registerLayerDefinition(Modelrock1.LAYER_LOCATION, Modelrock1::createBodyLayer);
		event.registerLayerDefinition(Modeln_onemind.LAYER_LOCATION, Modeln_onemind::createBodyLayer);
		event.registerLayerDefinition(Modelpointer.LAYER_LOCATION, Modelpointer::createBodyLayer);
		event.registerLayerDefinition(Modelashina2.LAYER_LOCATION, Modelashina2::createBodyLayer);
		event.registerLayerDefinition(Modelonemind2.LAYER_LOCATION, Modelonemind2::createBodyLayer);
		event.registerLayerDefinition(Modelflames2.LAYER_LOCATION, Modelflames2::createBodyLayer);
		event.registerLayerDefinition(Modelcleave_flame.LAYER_LOCATION, Modelcleave_flame::createBodyLayer);
		event.registerLayerDefinition(Modelnsakura1.LAYER_LOCATION, Modelnsakura1::createBodyLayer);
		event.registerLayerDefinition(Modelflames3.LAYER_LOCATION, Modelflames3::createBodyLayer);
		event.registerLayerDefinition(Modelsakura11.LAYER_LOCATION, Modelsakura11::createBodyLayer);
		event.registerLayerDefinition(Modelwhirlwind_2.LAYER_LOCATION, Modelwhirlwind_2::createBodyLayer);
		event.registerLayerDefinition(Modelemmacross.LAYER_LOCATION, Modelemmacross::createBodyLayer);
		event.registerLayerDefinition(Modelonemind1.LAYER_LOCATION, Modelonemind1::createBodyLayer);
		event.registerLayerDefinition(Modeldragonflash1.LAYER_LOCATION, Modeldragonflash1::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelshurkien1.LAYER_LOCATION, Modelshurkien1::createBodyLayer);
		event.registerLayerDefinition(Modelaxeswipe.LAYER_LOCATION, Modelaxeswipe::createBodyLayer);
		event.registerLayerDefinition(Modelblackleather.LAYER_LOCATION, Modelblackleather::createBodyLayer);
		event.registerLayerDefinition(Modelwhirlwind_1.LAYER_LOCATION, Modelwhirlwind_1::createBodyLayer);
		event.registerLayerDefinition(Modelfireworkshuriken.LAYER_LOCATION, Modelfireworkshuriken::createBodyLayer);
	}
}
