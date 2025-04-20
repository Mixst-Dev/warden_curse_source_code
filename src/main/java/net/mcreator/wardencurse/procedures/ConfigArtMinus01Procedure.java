package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ConfigArtMinus01Procedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_combat_power = WardenCurseModVariables.MapVariables.get(world).config_combat_power - 0.1;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
