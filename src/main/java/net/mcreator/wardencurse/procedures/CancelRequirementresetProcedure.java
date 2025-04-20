package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class CancelRequirementresetProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).Config_Dmg_Cancel_Requirement = 4.5;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
