package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class VanillaPvpONProcedure {
	public static void execute(LevelAccessor world) {
		WardenCurseModVariables.MapVariables.get(world).Config_Vanilla_Combat = true;
		WardenCurseModVariables.MapVariables.get(world).syncData(world);
	}
}
