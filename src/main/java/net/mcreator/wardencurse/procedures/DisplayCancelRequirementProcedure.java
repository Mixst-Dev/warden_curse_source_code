package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class DisplayCancelRequirementProcedure {
	public static String execute(LevelAccessor world) {
		return "Dmg needed to cancel: " + new java.text.DecimalFormat("##.##").format(WardenCurseModVariables.MapVariables.get(world).Config_Dmg_Cancel_Requirement);
	}
}
