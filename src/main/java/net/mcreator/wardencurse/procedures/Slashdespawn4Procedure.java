package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

public class Slashdespawn4Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		if (entity.getPersistentData().getDouble("time") == 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
