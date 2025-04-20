package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.SculkSoldier1Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SculkEnemy1GuardingPropertiesProcedure {
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
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) && entity instanceof SculkSoldier1Entity) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
				if (amount > 6) {
					if (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.WITHER_SKULL) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.LIGHTNING_BOLT)
							|| damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO) || damagesource.is(DamageTypes.MOB_PROJECTILE) || damagesource.is(DamageTypes.PLAYER_ATTACK)
							|| damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))) || damagesource.is(DamageTypes.TRIDENT)) {
						if (Math.random() < 0.2) {
							if (entity.getPersistentData().getBoolean("Entity_On_Battle") == false && !(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
								if (event != null && event.isCancelable()) {
									event.setCanceled(true);
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRY.get(), 10, 1, false, false));
								EntityParryProcedureProcedure.execute(world, entity);
								entity.getPersistentData().putBoolean("Parry_State", true);
								entity.getPersistentData().putBoolean("Entity_On_Battle", false);
								if (entity instanceof SculkSoldier1Entity) {
									((SculkSoldier1Entity) entity).setAnimation("empty");
								}
								if (entity instanceof SculkSoldier1Entity) {
									((SculkSoldier1Entity) entity).setAnimation("guard1");
								}
								entity.getPersistentData().putBoolean("Attack_2", true);
								entity.getPersistentData().putBoolean("Attack_1", false);
								entity.getPersistentData().putBoolean("Counter_1", false);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 25, 1, false, false));
								entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 3));
								if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
									if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Counter Slash (Parry)"), false);
								}
							}
						} else {
							if (Math.random() < 0.8) {
								if (entity.getPersistentData().getBoolean("Entity_On_Battle") == false && !(entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
									if (entity instanceof SculkSoldier1Entity) {
										((SculkSoldier1Entity) entity).setAnimation("empty");
									}
									if (entity instanceof SculkSoldier1Entity) {
										((SculkSoldier1Entity) entity).setAnimation("guard1");
									}
									EntityGuardingProcedureProcedure.execute(world, entity, amount);
									entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 2));
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									}
									entity.getPersistentData().putBoolean("Entity_On_Battle", false);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
									if (Math.random() < 0.3) {
										entity.getPersistentData().putBoolean("Counter_1", true);
									}
									entity.getPersistentData().putBoolean("Attack_2", false);
									entity.getPersistentData().putBoolean("Attack_1", false);
								} else {
									entity.getPersistentData().putBoolean("Attack_2", false);
									entity.getPersistentData().putBoolean("Attack_1", false);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
									if (entity instanceof SculkSoldier1Entity) {
										((SculkSoldier1Entity) entity).setAnimation("empty");
									}
									HurtVFXProcedure.execute(world, entity);
									entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
									entity.getPersistentData().putBoolean("Entity_On_Battle", false);
								}
							} else {
								entity.getPersistentData().putBoolean("Attack_2", false);
								entity.getPersistentData().putBoolean("Attack_1", false);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
								if (entity instanceof SculkSoldier1Entity) {
									((SculkSoldier1Entity) entity).setAnimation("empty");
								}
								HurtVFXProcedure.execute(world, entity);
								entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
								entity.getPersistentData().putBoolean("Entity_On_Battle", false);
							}
						}
					} else {
						entity.getPersistentData().putBoolean("Attack_2", false);
						entity.getPersistentData().putBoolean("Attack_1", false);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
						if (entity instanceof SculkSoldier1Entity) {
							((SculkSoldier1Entity) entity).setAnimation("empty");
						}
						HurtVFXProcedure.execute(world, entity);
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
						entity.getPersistentData().putBoolean("Entity_On_Battle", false);
					}
				}
			} else if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
				entity.getPersistentData().putBoolean("Attack_2", false);
				entity.getPersistentData().putBoolean("Attack_1", false);
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				if (entity instanceof SculkSoldier1Entity) {
					((SculkSoldier1Entity) entity).setAnimation("empty");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 10, 1, false, false));
			}
		}
	}
}
