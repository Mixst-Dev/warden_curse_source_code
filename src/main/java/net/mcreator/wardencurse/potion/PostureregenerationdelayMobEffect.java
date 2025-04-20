
package net.mcreator.wardencurse.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PostureregenerationdelayMobEffect extends MobEffect {
	public PostureregenerationdelayMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777165);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
