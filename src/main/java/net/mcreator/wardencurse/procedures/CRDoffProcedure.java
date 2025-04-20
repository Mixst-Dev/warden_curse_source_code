package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class CRDoffProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).Config_Attack_Cancel = false;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
