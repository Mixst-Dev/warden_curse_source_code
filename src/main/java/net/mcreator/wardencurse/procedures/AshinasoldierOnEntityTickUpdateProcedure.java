package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.AshinasoldierEntity;

public class AshinasoldierOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putBoolean("On_Battle", false);
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 120) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 50, 1));
				if (entity instanceof AshinasoldierEntity) {
					((AshinasoldierEntity) entity).setAnimation("empty");
				}
			}
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 100 && !(entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if (entity.getPersistentData().getBoolean("Attack_1") == true) {
			AshinaSoldierAtk1Procedure.execute(world, entity);
		}
		if (entity.getPersistentData().getBoolean("Attack_2") == true) {
			AshinaSoldierAtk2Procedure.execute(world, entity);
		}
		if (entity.getPersistentData().getBoolean("Attack_3") == true) {
			AshinaSoldierAkt3Procedure.execute(world, entity);
		}
	}
}
