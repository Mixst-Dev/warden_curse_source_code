package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.WardenCurseMod;

public class SakuradanceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			{
				double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).ceremol_emblem - 1;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ceremol_emblem = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		WardenCurseMod.queueServerWork(5, () -> {
			{
				double _setval = 1;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sakuracount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			WardenCurseMod.queueServerWork(7, () -> {
				{
					double _setval = 3;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sakuracount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
			WardenCurseMod.queueServerWork(22, () -> {
				{
					double _setval = 5;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sakuracount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		});
	}
}
