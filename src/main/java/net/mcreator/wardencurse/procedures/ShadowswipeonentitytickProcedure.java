package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.ShadowswipeEntity;

public class ShadowswipeonentitytickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 0) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash1");
		}
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash2");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash3");
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash4");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash5");
		}
		if (entity.getPersistentData().getDouble("timer") == 9) {
			if (entity instanceof ShadowswipeEntity animatable)
				animatable.setTexture("shadowslash6");
		}
		if (entity.getPersistentData().getDouble("timer") == 11) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
