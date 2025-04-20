package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.NdragonflashlazuliteEntity;
import net.mcreator.wardencurse.entity.NdragonflashfireEntity;
import net.mcreator.wardencurse.entity.NdragonflashcursedEntity;
import net.mcreator.wardencurse.entity.NdragonflashEntity;
import net.mcreator.wardencurse.entity.DragonaddcursedEntity;
import net.mcreator.wardencurse.entity.DragonaddEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DragonflashimmunityProcedure {
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
		if (entity instanceof NdragonflashEntity || entity instanceof NdragonflashcursedEntity || entity instanceof NdragonflashfireEntity || entity instanceof NdragonflashlazuliteEntity || entity instanceof DragonaddcursedEntity
				|| entity instanceof DragonaddEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
