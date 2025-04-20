package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.WardenCurseMod;

public class SecretEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double rotation = 0;
		double mypitch = 0;
		double yaw = 0;
		double vent_power = 0;
		double sugar_power = 0;
		double z2 = 0;
		double x2 = 0;
		double magnitude = 0;
		double myyaw = 0;
		double pitch = 0;
		double zcord = 0;
		double sugar_ako = 0;
		double xcord = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:newmortal entity @s 0 0.4 0");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/newmortal entity @s 0 0.4 0");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:mortal2 player @a ~ ~ ~ 0.8");
			}
		}
		WardenCurseMod.queueServerWork(4, () -> {
			MortalminddmgProcedure.execute(world, x, y, z, entity);
			WardenCurseMod.queueServerWork(5, () -> {
				MortalminddmgProcedure.execute(world, x, y, z, entity);
				WardenCurseMod.queueServerWork(5, () -> {
					MortalminddmgProcedure.execute(world, x, y, z, entity);
					WardenCurseMod.queueServerWork(5, () -> {
						MortalminddmgProcedure.execute(world, x, y, z, entity);
						WardenCurseMod.queueServerWork(5, () -> {
							MortalminddmgProcedure.execute(world, x, y, z, entity);
						});
					});
				});
			});
		});
	}
}
