package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.AshinaSoldier2Entity;

public class AshinaSoldier2OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 125) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 50, 1));
				if (entity instanceof AshinaSoldier2Entity) {
					((AshinaSoldier2Entity) entity).setAnimation("empty");
				}
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			}
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 100 && !(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if (entity.getPersistentData().getBoolean("Attack_1") == true) {
			Ashinasoldier2attack1Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("akt1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_2") == true) {
			AshinaSoldier2Attack2Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("akt2_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_3") == true) {
			AshinaSoldier2Attack3Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("atk3_timer", 0);
		}
	}
}
