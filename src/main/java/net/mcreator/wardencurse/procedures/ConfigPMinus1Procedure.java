package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ConfigPMinus1Procedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power = WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power - 1;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
