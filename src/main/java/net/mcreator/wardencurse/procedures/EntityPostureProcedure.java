package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class EntityPostureProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Entity Posture: " + (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).entity_posture;
	}
}
