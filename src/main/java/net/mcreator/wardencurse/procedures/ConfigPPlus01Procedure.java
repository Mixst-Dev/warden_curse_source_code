package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ConfigPPlus01Procedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power = WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power + 0.1;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
