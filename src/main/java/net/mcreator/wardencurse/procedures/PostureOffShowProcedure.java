package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class PostureOffShowProcedure {
	public static boolean execute(LevelAccessor world) {
		return WardenCurseModVariables.MapVariables.get(world).config_posture_toggle == false;
	}
}
