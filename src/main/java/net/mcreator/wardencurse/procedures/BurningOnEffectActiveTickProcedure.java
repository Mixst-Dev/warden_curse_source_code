package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

public class BurningOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWater()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.BURNING.get());
		}
	}
}
