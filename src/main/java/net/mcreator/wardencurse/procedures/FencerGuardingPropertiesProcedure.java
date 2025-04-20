package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.FencerEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FencerGuardingPropertiesProcedure {
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
		if (entity instanceof FencerEntity) {
			if (amount > 6) {
				if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
					if (Math.random() < 0.7
							&& (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.LIGHTNING_BOLT)
									|| damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO) || damagesource.is(DamageTypes.MOB_PROJECTILE) || damagesource.is(DamageTypes.PLAYER_ATTACK)
									|| damagesource.is(DamageTypes.PLAYER_EXPLOSION) || damagesource.is(DamageTypes.SONIC_BOOM) || damagesource.is(DamageTypes.TRIDENT) || damagesource.is(DamageTypes.WITHER_SKULL))) {
						if (!(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) && !(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
								&& entity.getPersistentData().getBoolean("Entity_On_Battle") == false) {
							EntityGuardingProcedureProcedure.execute(world, entity, amount);
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
							if (entity instanceof FencerEntity) {
								((FencerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof FencerEntity) {
								((FencerEntity) entity).setAnimation("guard");
							}
							entity.getPersistentData().putDouble("Lock_Yaw", 0);
						} else {
							HurtVFXProcedure.execute(world, entity);
							entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
							if (entity instanceof FencerEntity) {
								((FencerEntity) entity).setAnimation("empty");
							}
							entity.getPersistentData().putDouble("Lock_Yaw", 0);
						}
					} else {
						HurtVFXProcedure.execute(world, entity);
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
						if (entity instanceof FencerEntity) {
							((FencerEntity) entity).setAnimation("empty");
						}
						entity.getPersistentData().putDouble("Lock_Yaw", 0);
					}
					entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				} else {
					entity.getPersistentData().putBoolean("Entity_On_Battle", false);
				}
			}
		}
	}
}
