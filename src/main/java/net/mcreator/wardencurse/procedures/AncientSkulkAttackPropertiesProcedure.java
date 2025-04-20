package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AncientSkulkAttackPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof AncientSkulkVessleEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (sourceentity.getPersistentData().getDouble("attacktimer") <= 0 && (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
					|| !(sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())))) {
				if (sourceentity.getPersistentData().getBoolean("combat_range") == true) {
					if (Math.random() < 0.5) {
						if (sourceentity instanceof AncientSkulkVessleEntity) {
							((AncientSkulkVessleEntity) sourceentity).setAnimation("2hit");
						}
						sourceentity.getPersistentData().putBoolean("Attack_1", true);
					} else {
						if (Math.random() < 0.6) {
							if (sourceentity instanceof AncientSkulkVessleEntity) {
								((AncientSkulkVessleEntity) sourceentity).setAnimation("1hit");
							}
							sourceentity.getPersistentData().putBoolean("Attack_3", true);
						} else {
							if (sourceentity instanceof AncientSkulkVessleEntity) {
								((AncientSkulkVessleEntity) sourceentity).setAnimation("4hit");
							}
							sourceentity.getPersistentData().putBoolean("Attack_2", true);
						}
					}
				} else {
					if (Math.random() < 0.7) {
						if (Math.random() < 0.5) {
							if (sourceentity instanceof AncientSkulkVessleEntity) {
								((AncientSkulkVessleEntity) sourceentity).setAnimation("perilous2");
							}
							sourceentity.getPersistentData().putBoolean("Attack_4", true);
						} else {
							if (sourceentity instanceof AncientSkulkVessleEntity) {
								((AncientSkulkVessleEntity) sourceentity).setAnimation("perilous3");
							}
							sourceentity.getPersistentData().putBoolean("Attack_5", true);
						}
					} else {
						sourceentity.getPersistentData().putDouble("attacktimer", 40);
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, false));
					}
				}
			}
		}
	}
}
