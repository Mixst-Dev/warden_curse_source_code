package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ResetprostheticProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power = 8;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
