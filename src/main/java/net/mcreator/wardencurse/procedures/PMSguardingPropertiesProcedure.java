package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.ProgressivesamuraiEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PMSguardingPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		execute(null, world, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof ProgressivesamuraiEntity) {
			if (amount > 4) {
				if (Math.random() < 0 && (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.LIGHTNING_BOLT)
						|| damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO) || damagesource.is(DamageTypes.MOB_PROJECTILE) || damagesource.is(DamageTypes.PLAYER_ATTACK)
						|| damagesource.is(DamageTypes.PLAYER_EXPLOSION) || damagesource.is(DamageTypes.SONIC_BOOM) || damagesource.is(DamageTypes.TRIDENT) || damagesource.is(DamageTypes.WITHER_SKULL))) {
					if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) && !(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
							&& entity.getPersistentData().getBoolean("Entity_On_Battle") == false) {
						EntityGuardingProcedureProcedure.execute(world, entity, amount);
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 2));
					} else {
						HurtVFXProcedure.execute(world, entity);
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
					}
				} else {
					HurtVFXProcedure.execute(world, entity);
					entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
				}
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					{
						double _setval = entity.getPersistentData().getDouble("entity_posture");
						(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.entity_posture = _setval;
							capability.syncPlayerVariables((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null));
						});
					}
					{
						double _setval = 800;
						(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.max_entity_posture = _setval;
							capability.syncPlayerVariables((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null));
						});
					}
				}
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get(), 40, 1, false, false));
			}
		}
	}
}
