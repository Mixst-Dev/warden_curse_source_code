package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

public class NaomiAttack4Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("atk_4_timer", (entity.getPersistentData().getDouble("atk_4_timer") + 1));
		if (entity.getPersistentData().getDouble("atk_4_timer") == 1) {
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("attack4");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 22, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 17, 6, false, false));
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("atk_4_timer") == 1) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.getPersistentData().putDouble("Lock_Yaw", 1);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("atk_4_timer") == 11) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
				NaomiBargeDmgProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("atk_4_timer") >= 17) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putBoolean("Attack_4", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("atk_4_timer", 0);
		}
		if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) {
			entity.getPersistentData().putBoolean("Attack_4", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_1") == true) {
			entity.getPersistentData().putBoolean("Attack_4", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_2") == true) {
			entity.getPersistentData().putBoolean("Attack_4", false);
		}
	}
}
