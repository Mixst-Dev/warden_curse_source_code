
package net.mcreator.wardencurse.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AttackcooldownMobEffect extends MobEffect {
	public AttackcooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65536);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
