package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.SculkSoldier1Entity;
import net.mcreator.wardencurse.WardenCurseMod;

public class SculkSoldier1OnTickProcedure {
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
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Posture: " + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("entity_posture")) + "\u00A7a/180")), true);
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 180) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity.getPersistentData().getBoolean("Parry_State") == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 60, 1));
					entity.getPersistentData().putBoolean("Entity_On_Battle", false);
					entity.getPersistentData().putBoolean("Attack_1", false);
					entity.getPersistentData().putBoolean("Counter_1", false);
					if (entity instanceof SculkSoldier1Entity) {
						((SculkSoldier1Entity) entity).setAnimation("empty");
					}
					WardenCurseMod.queueServerWork(1, () -> {
						if (entity instanceof SculkSoldier1Entity) {
							((SculkSoldier1Entity) entity).setAnimation("empty");
						}
						if (entity instanceof SculkSoldier1Entity) {
							((SculkSoldier1Entity) entity).setAnimation("posture_break");
						}
					});
				} else {
					entity.getPersistentData().putDouble("entity_posture", 180);
					entity.getPersistentData().putBoolean("Parry_State", false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 100 && !(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
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
		if (entity.getPersistentData().getBoolean("Attack_1") == true) {
			SculkAttack1Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("akt1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_2") == true) {
			SculkAttack2Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("akt2_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Counter_1") == true) {
			SculkCounter1Procedure.execute(entity);
		} else {
			entity.getPersistentData().putDouble("counter_1", 0);
		}
	}
}
