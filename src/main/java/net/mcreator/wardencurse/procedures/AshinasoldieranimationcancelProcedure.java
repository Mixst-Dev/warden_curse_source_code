package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.AshinasoldierEntity;
import net.mcreator.wardencurse.entity.AshinaSpearEntity;
import net.mcreator.wardencurse.entity.AshinaSoldier2Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AshinasoldieranimationcancelProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof AshinasoldierEntity || entity instanceof AshinaSoldier2Entity || entity instanceof AshinaSpearEntity) {
			if (amount > 4) {
				if (entity instanceof AshinasoldierEntity) {
					((AshinasoldierEntity) entity).setAnimation("empty");
				}
				if (entity instanceof AshinaSoldier2Entity) {
					((AshinaSoldier2Entity) entity).setAnimation("empty");
				}
				if (entity instanceof AshinaSpearEntity) {
					((AshinaSpearEntity) entity).setAnimation("empty");
				}
			}
		}
	}
}
