
package net.mcreator.wardencurse.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FirestateMobEffect extends MobEffect {
	public FirestateMobEffect() {
		super(MobEffectCategory.NEUTRAL, -39424);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
