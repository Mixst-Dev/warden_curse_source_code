package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.init.WardenCurseModEntities;

public class ProstheticreadyprocedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double Xoffset = 0;
		double Zoffset = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = entity.getXRot() * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		Xoffset = (-1.5) * Math.sin(yaw) * (-1);
		Zoffset = (-1.5) * Math.cos(yaw);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = WardenCurseModEntities.PROSTHETICREADY.get().spawn(_level,
					BlockPos.containing(xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + Xoffset, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + Zoffset), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
	}
}
