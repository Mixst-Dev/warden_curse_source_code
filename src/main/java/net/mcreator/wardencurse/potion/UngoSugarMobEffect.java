
package net.mcreator.wardencurse.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.wardencurse.procedures.UngoOnEffectTickProcedure;

public class UngoSugarMobEffect extends MobEffect {
	public UngoSugarMobEffect() {
		super(MobEffectCategory.NEUTRAL, -4539664);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		UngoOnEffectTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
