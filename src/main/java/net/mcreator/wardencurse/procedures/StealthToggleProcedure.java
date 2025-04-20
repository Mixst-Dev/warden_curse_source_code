package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

public class StealthToggleProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("On_Battle") == true) {
			return true;
		}
		return false;
	}
}
