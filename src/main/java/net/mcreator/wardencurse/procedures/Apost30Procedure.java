package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class Apost30Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new WardenCurseModVariables.PlayerVariables())).entity_posture >= (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).max_entity_posture
						* (1 / 30) * 30) {
			return true;
		}
		return false;
	}
}
