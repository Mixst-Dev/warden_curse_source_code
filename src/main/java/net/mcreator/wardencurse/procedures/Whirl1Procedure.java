package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

public class Whirl1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:whirlwind_slash player @a ~ ~ ~ 0.8");
			}
		}
		x2 = entity.getX();
		z2 = entity.getZ();
		myyaw = entity.getYRot();
		mypitch = entity.getXRot();
		entity.hurtMarked = true;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1)));
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:whirlwindfire_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:whirlwindlazulite_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		} else if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:whirlwindcursed_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:whirlwind_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		WhirlwindtestEntitySwingsItemProcedure.execute(world, entity);
	}
}
