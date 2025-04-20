package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

public class TestsfRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("sekiro_nightjar", true);
	}
}
