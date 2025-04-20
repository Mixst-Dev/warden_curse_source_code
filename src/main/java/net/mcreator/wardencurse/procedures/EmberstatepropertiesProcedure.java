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
public class EmberstatepropertiesProcedure {
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
		if (entity.getPersistentData().getBoolean("emberstate") == true) {
			entity.getPersistentData().putDouble("ember_timer", (entity.getPersistentData().getDouble("ember_timer") + 1));
			if (entity.getPersistentData().getDouble("ember_timer") <= 1) {
				entity.getPersistentData().putDouble("ember_x", (entity.getLookAngle().x));
				entity.getPersistentData().putDouble("ember_y", (entity.getLookAngle().y));
				entity.getPersistentData().putDouble("ember_z", (entity.getLookAngle().z));
			}
			if (entity.getPersistentData().getDouble("ember_timer") > 9) {
				entity.getPersistentData().putDouble("ember_timer", 0);
				entity.getPersistentData().putBoolean("emberstate", false);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.FREEZEMOVE.get(), 10, 1, false, false));
			}
		}
	}
}
