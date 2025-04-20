package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class EmberboostprocProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getPersistentData().getDouble("ember_x") * 1), (entity.getDeltaMovement().y() + entity.getPersistentData().getDouble("ember_y") * 1),
				(entity.getDeltaMovement().z() + entity.getPersistentData().getDouble("ember_z") * 1)));
	}
}
