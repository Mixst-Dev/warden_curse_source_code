package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class CRDplus01Procedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).Config_Dmg_Cancel_Requirement = WardenCurseModVariables.MapVariables.get(world).Config_Dmg_Cancel_Requirement + 0.1;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
