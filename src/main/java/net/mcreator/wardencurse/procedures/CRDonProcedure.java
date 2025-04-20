package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class CRDonProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).Config_Attack_Cancel = true;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
