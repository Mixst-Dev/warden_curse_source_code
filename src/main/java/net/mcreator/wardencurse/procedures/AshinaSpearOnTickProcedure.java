package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.AshinaSpearEntity;

public class AshinaSpearOnTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity instanceof Mob _mob && _mob.getTarget() != null) {
				LivingEntity target = _mob.getTarget();
				double deltaX = target.getX() - entity.getX();
				double deltaZ = target.getZ() - entity.getZ();
				float targetYaw = (float) (Math.toDegrees(Math.atan2(deltaZ, deltaX))) - 90.0F;
				entity.setYRot(targetYaw);
				entity.yRotO = targetYaw;
				if (entity instanceof LivingEntity _livingEntity) {
					_livingEntity.yBodyRot = targetYaw;
					_livingEntity.yHeadRot = targetYaw;
				}
			}
			if (entity instanceof LivingEntity _livingEntity) {
				float targetYaw = _livingEntity.getYHeadRot();
				_livingEntity.setYRot(targetYaw);
				_livingEntity.yBodyRot = targetYaw;
				_livingEntity.yHeadRot = targetYaw;
				float currentYaw = _livingEntity.getYRot();
				float smoothYaw = currentYaw + (targetYaw - currentYaw) * 0.2F; // Adjust smoothing factor as needed
				_livingEntity.setYRot(smoothYaw);
				_livingEntity.yBodyRot = smoothYaw;
				_livingEntity.yHeadRot = smoothYaw;
			}
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 90) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 50, 1));
				if (entity instanceof AshinaSpearEntity) {
					((AshinaSpearEntity) entity).setAnimation("empty");
				}
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
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
			AshinaSpearAttack1Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("akt1_timer", 0);
		}
		if (entity.getPersistentData().getDouble("Lock_Yaw") == 1) {
			entity.getPersistentData().putDouble("Yaw", (entity.getYRot()));
			entity.getPersistentData().putDouble("Pitch", (entity.getXRot()));
			entity.getPersistentData().putDouble("Lock_Yaw", 2);
		}
		if (entity.getPersistentData().getDouble("Lock_Yaw") == 2) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) entity.getPersistentData().getDouble("Yaw"));
				_ent.setXRot((float) entity.getPersistentData().getDouble("Pitch"));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
	}
}
