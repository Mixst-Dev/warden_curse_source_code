package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CurveEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double size = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		for (int index0 = 0; index0 < 7; index0++) {
			if (world.isEmptyBlock(BlockPos.containing(xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + size * Math.cos(yaw), xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + size * Math.cos(yaw),
					zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + size * Math.sin(yaw)))) {
				world.addParticle(ParticleTypes.END_ROD, (xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + size * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
						(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + size * Math.sin(yaw)), 0, 0, 0);
				size = size + 1;
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + size * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + size * Math.sin(yaw)));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + size * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
						(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + size * Math.sin(yaw)), _ent.getYRot(), _ent.getXRot());
		}
	}
}
