package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.DownSlashEntity;

public class DownSlashTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof DownSlashEntity animatable)
				animatable.setTexture("anj1");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof DownSlashEntity animatable)
				animatable.setTexture("anj2");
		}
		if (entity.getPersistentData().getDouble("timer") == 4) {
			if (entity instanceof DownSlashEntity animatable)
				animatable.setTexture("anj3");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof DownSlashEntity animatable)
				animatable.setTexture("anj4");
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			if (entity instanceof DownSlashEntity animatable)
				animatable.setTexture("anj5");
		}
		if (entity.getPersistentData().getDouble("timer") > 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
