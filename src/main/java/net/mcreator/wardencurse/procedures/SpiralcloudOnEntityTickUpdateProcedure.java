package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class SpiralcloudOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		if (entity.getPersistentData().getDouble("time") == 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
