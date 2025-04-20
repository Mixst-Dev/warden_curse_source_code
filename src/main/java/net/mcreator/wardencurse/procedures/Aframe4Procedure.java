package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

public class Aframe4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("aframe") == 4) {
			return true;
		}
		return false;
	}
}
