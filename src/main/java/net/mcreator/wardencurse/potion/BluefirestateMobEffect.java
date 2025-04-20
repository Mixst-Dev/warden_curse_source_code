
package net.mcreator.wardencurse.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.wardencurse.procedures.BluefirestateOnEffectActiveTickProcedure;

public class BluefirestateMobEffect extends MobEffect {
	public BluefirestateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13421569);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BluefirestateOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
