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
import net.mcreator.wardencurse.entity.AshinaSoldier2Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Ashinasoldier2attackProcedure {
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
		if (sourceentity instanceof AshinaSoldier2Entity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (sourceentity.getPersistentData().getDouble("attacktimer") <= 0 && (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
					|| !(sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())))) {
				if (Math.random() < 0.5) {
					if (sourceentity instanceof AshinaSoldier2Entity) {
						((AshinaSoldier2Entity) sourceentity).setAnimation("attack1");
					}
					sourceentity.getPersistentData().putBoolean("Attack_1", true);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 22, 10, false, false));
					sourceentity.getPersistentData().putDouble("attacktimer", 25);
				} else {
					if (Math.random() < 0.6) {
						if (sourceentity instanceof AshinaSoldier2Entity) {
							((AshinaSoldier2Entity) sourceentity).setAnimation("attack2");
						}
						sourceentity.getPersistentData().putBoolean("Attack_2", true);
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 10, false, false));
						sourceentity.getPersistentData().putDouble("attacktimer", 65);
					} else {
						if (sourceentity instanceof AshinaSoldier2Entity) {
							((AshinaSoldier2Entity) sourceentity).setAnimation("attack3");
						}
						sourceentity.getPersistentData().putBoolean("Attack_3", true);
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 10, false, false));
						sourceentity.getPersistentData().putDouble("attacktimer", 37);
					}
				}
			}
		}
	}
}
