package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class Test1EntitySwingsItemProcedure {
	public static void execute(double y, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
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
		{
			Entity _ent = entity;
			_ent.teleportTo((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), y, (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), y, (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude), _ent.getYRot(), _ent.getXRot());
		}
	}
}
