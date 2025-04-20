package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class MaxpostureProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Max Posture: " + (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).max_entity_posture;
	}
}
