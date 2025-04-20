package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.Passage2Entity;

public class Passage2TickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof Passage2Entity animatable)
				animatable.setTexture("passage1");
		}
		if (entity.getPersistentData().getDouble("timer") == 2) {
			if (entity instanceof Passage2Entity animatable)
				animatable.setTexture("passage2");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof Passage2Entity animatable)
				animatable.setTexture("passage3");
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			if (entity instanceof Passage2Entity animatable)
				animatable.setTexture("passage4");
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			if (entity instanceof Passage2Entity animatable)
				animatable.setTexture("passage5");
		}
		if (entity.getPersistentData().getDouble("timer") > 8) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.FREEZEMOVE.get(), 60, 1, false, false));
	}
}
