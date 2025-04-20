package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

public class Spiral1OnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
