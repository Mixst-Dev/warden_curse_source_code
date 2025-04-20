package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Mortaldraw2Entity;

public class Mortaldraw2onentitytickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f1");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f2");
		}
		if (entity.getPersistentData().getDouble("timer") == 4) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f3");
		}
		if (entity.getPersistentData().getDouble("timer") == 10) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f4");
		}
		if (entity.getPersistentData().getDouble("timer") == 15) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f5");
		}
		if (entity.getPersistentData().getDouble("timer") == 30) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f6");
		}
		if (entity.getPersistentData().getDouble("timer") == 35) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f7");
		}
		if (entity.getPersistentData().getDouble("timer") == 40) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f8");
		}
		if (entity.getPersistentData().getDouble("timer") == 45) {
			if (entity instanceof Mortaldraw2Entity animatable)
				animatable.setTexture("mortaldraw1f9");
		}
		if (entity.getPersistentData().getDouble("timer") == 50) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
