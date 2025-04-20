package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class FloatingPassageStoreProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("sekiro_floating", true);
		{
			boolean _setval = true;
			entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Cancel_Art_Toggle = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
