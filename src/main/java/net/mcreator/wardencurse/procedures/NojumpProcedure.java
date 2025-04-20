package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NojumpProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.STUNNED.get())) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), 0));
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(WardenCurseModMobEffects.NO_JUMP_2.get())) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), 0));
		}
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.NO_MOVE.get())) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), 0));
		}
	}
}
