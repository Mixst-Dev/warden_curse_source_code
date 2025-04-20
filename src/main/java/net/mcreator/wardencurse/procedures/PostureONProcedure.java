package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class PostureONProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).config_posture_toggle = true;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
