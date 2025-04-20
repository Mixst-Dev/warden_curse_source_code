package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Normalslash3Entity;

public class Normalslash3tickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof Normalslash3Entity animatable)
				animatable.setTexture("newswing1");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof Normalslash3Entity animatable)
				animatable.setTexture("newswing2");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof Normalslash3Entity animatable)
				animatable.setTexture("newswing3");
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			if (entity instanceof Normalslash3Entity animatable)
				animatable.setTexture("newswing4");
		}
		if (entity.getPersistentData().getDouble("timer") == 7) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
