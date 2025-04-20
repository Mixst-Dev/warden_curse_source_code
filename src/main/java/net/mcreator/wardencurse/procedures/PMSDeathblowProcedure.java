package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.entity.ProgressivesamuraiEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PMSDeathblowProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
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
		if (entity instanceof ProgressivesamuraiEntity) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getDouble("sekiro_deathblow") == 0) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (entity instanceof ProgressivesamuraiEntity) {
					((ProgressivesamuraiEntity) entity).setAnimation("deathblow1");
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(20);
				entity.getPersistentData().putBoolean("phase2", true);
				{
					double _setval = 0;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.entity_posture = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
