package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AutoParryPropertiesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yashariku = 0;
		double yaw = 0;
		double gokan = 0;
		double xcord = 0;
		if (entity.getPersistentData().getBoolean("auto_parry")) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.STUNNED.get())) || !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.GUARDCOOLDOWN.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRY.get(), 2, 1, false, false));
			}
		}
	}
}
