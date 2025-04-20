package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class EmblemLimitResetProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_emblem_limit = 20;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
