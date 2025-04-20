package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Nsakuralazulite3Entity;
import net.mcreator.wardencurse.entity.Nsakuralazulite2Entity;
import net.mcreator.wardencurse.entity.Nsakuralazulite1Entity;
import net.mcreator.wardencurse.entity.Nsakurafire3Entity;
import net.mcreator.wardencurse.entity.Nsakurafire2Entity;
import net.mcreator.wardencurse.entity.Nsakurafire1Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse3Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse2Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse1Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NsakuraimmortalityProcedure {
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
		if (entity instanceof Nsakuracurse1Entity || entity instanceof Nsakuracurse2Entity || entity instanceof Nsakuracurse3Entity || entity instanceof Nsakurafire1Entity || entity instanceof Nsakurafire2Entity
				|| entity instanceof Nsakurafire3Entity || entity instanceof Nsakuralazulite1Entity || entity instanceof Nsakuralazulite2Entity || entity instanceof Nsakuralazulite3Entity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
