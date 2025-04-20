package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.init.WardenCurseModEntities;

public class StartlongsmokeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double rotation = 0;
		pitch = entity.getXRot() * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		for (int index0 = 0; index0 < 3; index0++) {
			yaw = (entity.getYRot() + 45 + rotation) * (Math.PI / 180);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.STARTSMOKEENTITY.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			rotation = rotation + 45;
		}
	}
}
