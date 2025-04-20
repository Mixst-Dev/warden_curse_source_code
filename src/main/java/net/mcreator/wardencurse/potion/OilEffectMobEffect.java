
package net.mcreator.wardencurse.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class OilEffectMobEffect extends MobEffect {
	public OilEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -14606310);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
