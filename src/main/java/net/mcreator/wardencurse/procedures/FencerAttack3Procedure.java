package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.entity.FencerEntity;

public class FencerAttack3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("akt3_timer", (entity.getPersistentData().getDouble("akt3_timer") + 1));
		if (entity.getPersistentData().getDouble("akt3_timer") == 1) {
			if (entity instanceof FencerEntity) {
				((FencerEntity) entity).setAnimation("attack3");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 38, 3, false, false));
			entity.getPersistentData().putDouble("attacktimer", 40);
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("akt3_timer") == 15) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				FencerDmg1Procedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("akt3_timer") == 25) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				FencerElbowProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("akt3_timer") == 35) {
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			if (entity instanceof FencerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FencerEntity.DATA_Attack_3, false);
		}
	}
}
