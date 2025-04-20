package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ConfigSpiritEmblemShowProcedure {
	public static String execute(LevelAccessor world) {
		return "Spirit Emblem Limit: " + new java.text.DecimalFormat("###").format(WardenCurseModVariables.MapVariables.get(world).config_emblem_limit);
	}
}
