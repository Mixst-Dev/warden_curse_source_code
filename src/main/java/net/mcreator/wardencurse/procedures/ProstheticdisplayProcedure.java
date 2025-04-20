package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ProstheticdisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Current Prosthetic Slot: " + new java.text.DecimalFormat("#").format((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).prostheticart_num);
	}
}
