package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.ShadowslashEntity;
import net.mcreator.wardencurse.entity.FireshadowslashEntity;
import net.mcreator.wardencurse.entity.CursedfireshadowslashEntity;
import net.mcreator.wardencurse.entity.BluefireshadowslashEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShadowrushimmunityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BluefireshadowslashEntity || entity instanceof CursedfireshadowslashEntity || entity instanceof FireshadowslashEntity || entity instanceof ShadowslashEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
