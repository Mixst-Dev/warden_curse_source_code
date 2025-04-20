package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Normalslash3Entity;
import net.mcreator.wardencurse.entity.Normalslash2Entity;
import net.mcreator.wardencurse.entity.Normalslash1Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NormalimmunityProcedure {
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
		if (entity instanceof Normalslash1Entity || entity instanceof Normalslash2Entity || entity instanceof Normalslash3Entity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
