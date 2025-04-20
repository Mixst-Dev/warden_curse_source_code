package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NaomoriGuardingPropertiesProcedure {
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
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) && entity instanceof GeneralNaomiKawaradaEntity) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker"))) || !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg")))) {
				if (amount > entity.getPersistentData().getDouble("entity_flinch_requirement")) {
					if (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.WITHER_SKULL) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.LIGHTNING_BOLT)
							|| damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO) || damagesource.is(DamageTypes.MOB_PROJECTILE) || damagesource.is(DamageTypes.PLAYER_ATTACK)
							|| damagesource.is(DamageTypes.PLAYER_ATTACK) || damagesource.is(DamageTypes.TRIDENT) || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg")))) {
						if (entity.getPersistentData().getBoolean("Entity_On_Battle") == false && !(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
							if (Math.random() < 0.8) {
								if (Math.random() < 0.38) {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRY.get(), 10, 1, false, false));
									EntityParryProcedureProcedure.execute(world, entity);
									entity.getPersistentData().putBoolean("Parry_State", true);
									if (entity instanceof GeneralNaomiKawaradaEntity) {
										((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
									}
									entity.getPersistentData().putBoolean("Entity_On_Battle", false);
									if (entity.getPersistentData().getBoolean("Combat_Range") == true) {
										if (entity instanceof GeneralNaomiKawaradaEntity) {
											((GeneralNaomiKawaradaEntity) entity).setAnimation("counter_slash");
										}
										entity.getPersistentData().putBoolean("Counter_1", true);
									} else {
										if (entity instanceof GeneralNaomiKawaradaEntity) {
											((GeneralNaomiKawaradaEntity) entity).setAnimation("guard1");
										}
									}
									entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 3));
								} else {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									}
									if (entity instanceof GeneralNaomiKawaradaEntity) {
										((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
									}
									if (entity instanceof GeneralNaomiKawaradaEntity) {
										((GeneralNaomiKawaradaEntity) entity).setAnimation("guard1");
									}
									EntityGuardingProcedureProcedure.execute(world, entity, amount);
									entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 2));
									entity.getPersistentData().putBoolean("Entity_On_Battle", false);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
									if (Math.random() < 0.4) {
										if (Math.random() < 0.5) {
											entity.getPersistentData().putBoolean("Attack_2", true);
											entity.getPersistentData().putDouble("atk_2_timer", (-15));
										} else {
											entity.getPersistentData().putBoolean("Counter_2", true);
										}
									}
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 17, 1, false, false));
								if (entity instanceof GeneralNaomiKawaradaEntity) {
									((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
								}
								HurtVFXProcedure.execute(world, entity);
								entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
								entity.getPersistentData().putBoolean("Entity_On_Battle", false);
							}
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 17, 1, false, false));
							if (entity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
							}
							HurtVFXProcedure.execute(world, entity);
							entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
							entity.getPersistentData().putBoolean("Entity_On_Battle", false);
						}
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
						if (entity instanceof GeneralNaomiKawaradaEntity) {
							((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
						}
						HurtVFXProcedure.execute(world, entity);
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
						entity.getPersistentData().putBoolean("Entity_On_Battle", false);
					}
					entity.getPersistentData().putDouble("entity_flinch_requirement", 6);
				} else {
					entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
				}
			} else if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				if (entity instanceof GeneralNaomiKawaradaEntity) {
					((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 10, 1, false, false));
			} else if (entity.getPersistentData().getBoolean("Entity_IV_Shuriken") == true && damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg")))) {
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				entity.getPersistentData().putBoolean("Entity_IV_Shuriken", false);
				if (entity instanceof GeneralNaomiKawaradaEntity) {
					((GeneralNaomiKawaradaEntity) entity).setAnimation("empty");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 10, 1, false, false));
			}
		}
	}
}
