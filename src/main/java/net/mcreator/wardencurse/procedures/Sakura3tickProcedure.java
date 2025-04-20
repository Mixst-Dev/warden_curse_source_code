package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Sakura3Entity;

public class Sakura3tickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 0) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr1");
		}
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr2");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr3");
		}
		if (entity.getPersistentData().getDouble("timer") == 4) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr4");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr5");
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr6");
		}
		if (entity.getPersistentData().getDouble("timer") == 10) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr7");
		}
		if (entity.getPersistentData().getDouble("timer") == 12) {
			if (entity instanceof Sakura3Entity animatable)
				animatable.setTexture("sakurafr8");
		}
		if (entity.getPersistentData().getDouble("timer") == 15) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
