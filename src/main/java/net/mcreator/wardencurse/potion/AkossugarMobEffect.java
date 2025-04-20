
package net.mcreator.wardencurse.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.wardencurse.procedures.AkossugarOnEffectActiveTickProcedure;

public class AkossugarMobEffect extends MobEffect {
	public AkossugarMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13693426);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AkossugarOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
