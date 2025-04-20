package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CurseddragonaditionalProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		double rotate = 0;
		double myyaw2 = 0;
		double myyaw3 = 0;
		x2 = entity.getX() + entity.getLookAngle().x * 5.5;
		z2 = entity.getZ() + entity.getLookAngle().z * 5.5;
		mypitch = entity.getXRot();
		myyaw = entity.getYRot() - 45;
		myyaw2 = entity.getYRot();
		myyaw3 = entity.getYRot() + 45;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:dragonaddcursed " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:dragonaddcursed " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw2 + "f," + 0 + "f]}"));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:dragonaddcursed " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw3 + "f," + 0 + "f]}"));
			}
		}
	}
}
