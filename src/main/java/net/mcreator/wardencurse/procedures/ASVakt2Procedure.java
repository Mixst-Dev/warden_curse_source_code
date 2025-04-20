package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

public class ASVakt2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Attack_2_Timer", (entity.getPersistentData().getDouble("Attack_2_Timer") + 1));
		if (entity.getPersistentData().getDouble("Attack_2_Timer") == 1) {
			if (entity instanceof AncientSkulkVessleEntity) {
				((AncientSkulkVessleEntity) entity).setAnimation("4hit");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 120, false, false));
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putDouble("attacktimer", 110);
		}
		if (entity.getPersistentData().getDouble("Attack_2_Timer") == 10 || entity.getPersistentData().getDouble("Attack_2_Timer") == 23 || entity.getPersistentData().getDouble("Attack_2_Timer") == 30
				|| entity.getPersistentData().getDouble("Attack_2_Timer") == 43) {
			ACVpunch1Procedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("Attack_2_Timer") >= 102) {
			entity.getPersistentData().putBoolean("Attack_2", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			if (Math.random() < 0.5) {
				entity.getPersistentData().putBoolean("MB_1", true);
			}
		}
	}
}
