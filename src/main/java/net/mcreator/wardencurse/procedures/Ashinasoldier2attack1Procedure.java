package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class Ashinasoldier2attack1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("akt1_timer", (entity.getPersistentData().getDouble("akt1_timer") + 1));
		if (entity.getPersistentData().getDouble("akt1_timer") == 1) {
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 14) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				Ashinasoldier2dmgProcedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 14) {
			entity.getPersistentData().putBoolean("Attack_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
		}
	}
}
