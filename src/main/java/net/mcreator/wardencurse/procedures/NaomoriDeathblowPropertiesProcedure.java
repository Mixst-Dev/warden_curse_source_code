package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NaomoriDeathblowPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity) {
		execute(null, damagesource, entity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof GeneralNaomiKawaradaEntity) {
			if (!damagesource.is(DamageTypes.DROWN) || !damagesource.is(DamageTypes.GENERIC) || !damagesource.is(DamageTypes.GENERIC_KILL) || !damagesource.is(DamageTypes.STARVE)) {
				if (entity.getPersistentData().getDouble("entity_deathblow_limit") == 0) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 20, 1, false, false));
					entity.getPersistentData().putDouble("entity_deathblow_limit", 1);
					entity.getPersistentData().putDouble("entity_posture", 0);
				}
			}
		}
	}
}
