package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Whirlwind1Entity;

public class Whirlwind1OnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof Whirlwind1Entity animatable)
				animatable.setTexture("whirl_1");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof Whirlwind1Entity animatable)
				animatable.setTexture("whirl_2");
		}
		if (entity.getPersistentData().getDouble("timer") == 4) {
			if (entity instanceof Whirlwind1Entity animatable)
				animatable.setTexture("whirl_3");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof Whirlwind1Entity animatable)
				animatable.setTexture("whirl_4");
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			if (entity instanceof Whirlwind1Entity animatable)
				animatable.setTexture("whirl_5");
		}
		if (entity.getPersistentData().getDouble("timer") == 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setNoGravity(true);
	}
}
