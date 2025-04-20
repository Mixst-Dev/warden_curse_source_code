package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

public class SculkCounter1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("counter_1", (entity.getPersistentData().getDouble("counter_1") + 1));
		if (entity.getPersistentData().getDouble("counter_1") == 1) {
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 5, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 25, 5, false, false));
		}
		if (entity.getPersistentData().getDouble("counter_1") == 10) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * (-1.5)), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * (-1.5))));
			}
		}
		if (entity.getPersistentData().getDouble("counter_1") == 20) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				if (Math.random() < 0.65) {
					entity.getPersistentData().putBoolean("Attack_1", true);
				}
			}
			entity.getPersistentData().putBoolean("Counter_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("counter_1", 0);
		}
	}
}
