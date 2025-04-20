package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.SpearswipeEntity;

public class SpearswipeOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears1");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears2");
		}
		if (entity.getPersistentData().getDouble("timer") == 4) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears3");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears4");
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears5");
		}
		if (entity.getPersistentData().getDouble("timer") == 10) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears6");
		}
		if (entity.getPersistentData().getDouble("timer") == 12) {
			if (entity instanceof SpearswipeEntity animatable)
				animatable.setTexture("spears7");
		}
		if (entity.getPersistentData().getDouble("timer") == 14) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
