package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class PosturemultiplyerdisplayProcedure {
	public static String execute(LevelAccessor world) {
		return "Posture Damage decreased by: " + new java.text.DecimalFormat("###").format(WardenCurseModVariables.MapVariables.get(world).posture_multipler * 100) + "%";
	}
}
