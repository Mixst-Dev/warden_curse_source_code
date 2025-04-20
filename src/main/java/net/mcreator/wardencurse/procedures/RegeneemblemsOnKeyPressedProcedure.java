package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class RegeneemblemsOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double amount = 0;
		double amount2 = 0;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).stored_elbem == 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Your Emblem Invetory is empty!"), true);
		}
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).stored_elbem > 0) {
			{
				boolean _setval = true;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.emblem_increase = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
