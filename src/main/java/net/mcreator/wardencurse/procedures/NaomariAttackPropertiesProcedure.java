package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class NaomariAttackPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			{
				final Vec3 _center = new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						sourceentity.getPersistentData().putBoolean("Combat_Range_Mid", true);
					} else {
						sourceentity.getPersistentData().putBoolean("Combat_Range_Mid", false);
					}
				}
			}
			{
				final Vec3 _center = new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						sourceentity.getPersistentData().putBoolean("Combat_Range", true);
						sourceentity.getPersistentData().putBoolean("Combat_Range_Mid", false);
					} else {
						sourceentity.getPersistentData().putBoolean("Combat_Range", false);
					}
				}
			}
			if (!(sourceentity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get()))
					&& !(sourceentity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
				if (sourceentity.getPersistentData().getBoolean("Combat_Range") == true) {
					if (Math.random() < 0.41) {
						if (Math.random() < 0.6) {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("perilous1");
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:aperilous entity @s 0 2.5 0");
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/aperilous entity @s 0 2.5 0");
								}
							}
							sourceentity.getPersistentData().putBoolean("Perilous_1", true);
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 30, false, false));
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), Mth.nextInt(RandomSource.create(), 40, 45), 1, false, false));
						} else {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack6");
							}
							sourceentity.getPersistentData().putBoolean("Attack_6", true);
						}
					} else {
						if (Math.random() < 0.5) {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack3");
							}
							sourceentity.getPersistentData().putBoolean("Attack_3", true);
						} else {
							if (Math.random() < 0.6) {
								if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
									((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack2");
								}
								sourceentity.getPersistentData().putBoolean("Attack_2", true);
							} else {
								if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
									((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack1");
								}
								sourceentity.getPersistentData().putBoolean("Attack_1", true);
							}
						}
					}
				}
				if (sourceentity.getPersistentData().getBoolean("Combat_Range") == false && sourceentity.getPersistentData().getBoolean("Combat_Range_Mid") == false) {
					if (sourceentity.getPersistentData().getBoolean("Posture_Risk") == true) {
						if (Math.random() < 0.65) {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("heal");
							}
							sourceentity.getPersistentData().putBoolean("Heal_1", true);
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
						}
					} else {
						if (Math.random() < 0.5) {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack3");
							}
							sourceentity.getPersistentData().putBoolean("Attack_3", true);
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 15, 1, false, false));
						}
					}
				}
				if (sourceentity.getPersistentData().getBoolean("Combat_Range_Mid") == true) {
					if (sourceentity.getPersistentData().getBoolean("Posture_Risk") == true) {
						if (Math.random() < 0.6) {
							if (sourceentity instanceof GeneralNaomiKawaradaEntity) {
								((GeneralNaomiKawaradaEntity) sourceentity).setAnimation("attack3");
							}
							sourceentity.getPersistentData().putBoolean("Attack_3", true);
						}
					}
				}
			}
		}
	}
}
