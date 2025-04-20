package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ShowProstheticPowerProcedure {
	public static String execute(LevelAccessor world) {
		return "Current Prosthetic Power: " + new java.text.DecimalFormat("##.#").format(WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power);
	}
}
