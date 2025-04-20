package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

public class TriggerCloudProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get()))) {
			if (entity.getPersistentData().getDouble("spiral_number") == 0) {
				entity.getPersistentData().putBoolean("sekiro_cloud_1", true);
			}
			if (entity.getPersistentData().getDouble("spiral_number") == 1) {
				entity.getPersistentData().putBoolean("sekiro_cloud_2", true);
			}
		}
	}
}
