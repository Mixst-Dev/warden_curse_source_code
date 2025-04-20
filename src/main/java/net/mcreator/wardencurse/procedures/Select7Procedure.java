package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class Select7Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 7;
			entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Selected_GUI_Number = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
