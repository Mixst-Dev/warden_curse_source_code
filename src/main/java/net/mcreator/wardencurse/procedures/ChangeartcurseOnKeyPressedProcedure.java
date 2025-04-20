package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class ChangeartcurseOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).sekirotoggle == true
				&& !((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).limit_art == 1)) {
			if (!entity.isShiftKeyDown()) {
				{
					double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).mortalbladearts + 1;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mortalbladearts = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.isShiftKeyDown()) {
				{
					double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).mortalbladearts - 1;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mortalbladearts = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
