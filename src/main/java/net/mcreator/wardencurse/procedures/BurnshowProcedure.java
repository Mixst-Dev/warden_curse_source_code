package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class BurnshowProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Burn Hp: 100/" + new java.text.DecimalFormat("##.##").format((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Fire_HP);
	}
}
