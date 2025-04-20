package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AshinatestEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		double ycord = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double Xoffset = 0;
		double Zoffset = 0;
		double magnitude = 0;
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = 1;
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		x2 = entity.getX();
		z2 = entity.getZ();
		myyaw = entity.getYRot() + 90;
		mypitch = entity.getXRot();
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + 3 * Math.sin(yaw) * (-1)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + 3 * Math.cos(yaw)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.sin(yaw) * (-1) + 2 * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.cos(yaw) + 2 * Math.sin(yaw)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + 1.5 * Math.sin(yaw) * (-1) + 3 * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + 1.5 * Math.cos(yaw) + 3 * Math.sin(yaw)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + (3 * Math.cos(yaw) * (-1) + 1.5 * Math.sin(yaw)) * (-1)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + (3 * Math.sin(yaw) * (-1) + 1.5 * Math.cos(yaw)) * (-1)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + (2 * Math.cos(yaw) * (-1) + 2 * Math.sin(yaw)) * (-1)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + (2 * Math.sin(yaw) * (-1) + 2 * Math.cos(yaw)) * (-1)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + (-3) * Math.sin(yaw) * (-1)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + (-3) * Math.cos(yaw)), 0, 0, 0);
		world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + 3.5 * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
				(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + 3.5 * Math.sin(yaw)), 0, 0, 0);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:ashinacross_2 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
			}
		}
	}
}
