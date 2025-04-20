
package net.mcreator.wardencurse.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.wardencurse.procedures.CursedfirestateOnEffectActiveTickProcedure;

public class CursedfirestateMobEffect extends MobEffect {
	public CursedfirestateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6710785);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CursedfirestateOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
