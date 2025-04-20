package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

public class NaomiOnTickProcedure {
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
				_player.displayClientMessage(Component.literal(("Posture: " + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("entity_posture")) + "\u00A7a/800")), true);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 420) {
			entity.getPersistentData().putBoolean("Posture_Risk", true);
		} else {
			entity.getPersistentData().putBoolean("Posture_Risk", false);
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 800) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
			}
			if (!(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity.getPersistentData().getBoolean("Parry_State") == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 60, 1));
				} else {
					entity.getPersistentData().putDouble("entity_posture", 800);
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
		if (entity.getPersistentData().getDouble("posturetimer") >= 5) {
			if (!(entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
				entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.05));
			}
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
		if (entity.getPersistentData().getBoolean("Heal_1") == true) {
			NaomiHeal1Procedure.execute(entity);
		} else {
			entity.getPersistentData().putDouble("heal_1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Perilous_1") == true) {
			NaomaiPerilous1Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("pr_1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_1") == true) {
			NaomaiAttack1Procedure.execute(world, entity);
			entity.getPersistentData().putDouble("entity_power", 14);
		} else {
			entity.getPersistentData().putDouble("atk_1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_2") == true) {
			NaomariAttack2Procedure.execute(world, entity);
			entity.getPersistentData().putDouble("entity_power", 16);
		} else {
			entity.getPersistentData().putDouble("atk_2_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_3") == true) {
			NaomaiAttack3Procedure.execute(world, entity);
			entity.getPersistentData().putDouble("entity_power", 12);
		} else {
			entity.getPersistentData().putDouble("atk_3_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_4") == true) {
			NaomiAttack4Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("entity_power", 12);
		}
		if (entity.getPersistentData().getBoolean("Attack_5") == true) {
			NaomiAttack5Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("atk_5_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Attack_6") == true) {
			NaomoriAttack6Procedure.execute(world, entity);
			entity.getPersistentData().putDouble("entity_power", 10);
		} else {
			entity.getPersistentData().putDouble("atk_6_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Counter_1") == true) {
			NoamiCounterSlashProcedure.execute(world, entity);
			entity.getPersistentData().putDouble("entity_power", 12);
		} else {
			entity.getPersistentData().putDouble("counter_1_timer", 0);
		}
		if (entity.getPersistentData().getBoolean("Counter_2") == true) {
			NaomiCounter2Procedure.execute(entity);
		} else {
			entity.getPersistentData().putDouble("counter_2_timer", 0);
		}
	}
}
