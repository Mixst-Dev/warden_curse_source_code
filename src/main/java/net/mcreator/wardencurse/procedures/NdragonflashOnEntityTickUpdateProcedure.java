package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class NdragonflashOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			entity.getPersistentData().putDouble("aframe", 1);
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			entity.getPersistentData().putDouble("aframe", 2);
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			entity.getPersistentData().putDouble("aframe", 3);
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			entity.getPersistentData().putDouble("aframe", 4);
		}
		if (entity.getPersistentData().getDouble("timer") == 7) {
			entity.getPersistentData().putDouble("aframe", 5);
		}
		if (entity.getPersistentData().getDouble("timer") == 9) {
			entity.getPersistentData().putDouble("aframe", 6);
		}
		if (entity.getPersistentData().getDouble("timer") == 11) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
