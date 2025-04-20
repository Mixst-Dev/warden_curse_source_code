package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class AshinaSoldierAkt3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("atk3_timer", (entity.getPersistentData().getDouble("atk3_timer") + 1));
		if (entity.getPersistentData().getDouble("atk3_timer") == 20) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				Ashinasolderdamage2Procedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
			entity.getPersistentData().putDouble("atk3_timer", 0);
			entity.getPersistentData().putBoolean("Attack_3", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
		}
	}
}
