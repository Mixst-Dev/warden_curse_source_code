package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class RessurectionStateProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).ressurection_state == true) {
				return true;
			}
		}
		return false;
	}
}
