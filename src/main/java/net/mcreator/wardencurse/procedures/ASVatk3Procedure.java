package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

public class ASVatk3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Attack_3_Timer", (entity.getPersistentData().getDouble("Attack_3_Timer") + 1));
		if (entity.getPersistentData().getDouble("Attack_3_Timer") == 1) {
			if (entity instanceof AncientSkulkVessleEntity) {
				((AncientSkulkVessleEntity) entity).setAnimation("1hit");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 120, false, false));
			entity.getPersistentData().putDouble("attacktimer", 75);
		}
		if (entity.getPersistentData().getDouble("Attack_3_Timer") == 12) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
		}
		if (entity.getPersistentData().getDouble("Attack_3_Timer") == 20) {
			ACVHardPunch1Procedure.execute(world, entity);
		}
		if (entity.getPersistentData().getDouble("Attack_3_Timer") == 60) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putBoolean("Mobility_1", true);
			entity.getPersistentData().putBoolean("Attack_3", false);
		}
	}
}
