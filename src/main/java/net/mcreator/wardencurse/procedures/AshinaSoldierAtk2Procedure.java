package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class AshinaSoldierAtk2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("atk2_timer", (entity.getPersistentData().getDouble("atk2_timer") + 1));
		if (entity.getPersistentData().getDouble("atk2_timer") == 14) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				AshinasoldierdamageProcedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("atk2_timer") == 29) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				AshinasoldierdamageProcedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
			entity.getPersistentData().putDouble("atk2_timer", 0);
			entity.getPersistentData().putBoolean("Attack_2", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
		}
	}
}
