package net.mcreator.wardencurse.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.WardenCurseMod;

public class MortalbladeSWINGProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double myyaw = 0;
		double x2 = 0;
		double z2 = 0;
		double mypitch = 0;
		double burnout = 0;
		double varient = 0;
		double atk_num = 0;
		if (WardenCurseModVariables.MapVariables.get(world).Config_Vanilla_Combat == false) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get()))) {
				if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false
						&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).deathblowtoggle == false) {
					DeathblowDetectionProcedure.execute(world, x, y, z, entity);
					if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).shadowfall == false) {
						varient = Mth.nextInt(RandomSource.create(), 1, 3);
						x2 = entity.getX();
						z2 = entity.getZ();
						myyaw = entity.getYRot();
						mypitch = entity.getXRot();
						if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get())) || !(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
							if (!entity.isShiftKeyDown()) {
								if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Sword_Slash_Number == 0) {
									entity.getPersistentData().putBoolean("kusabimaru_attack", true);
								} else if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Sword_Slash_Number == 1) {
									entity.getPersistentData().putBoolean("kusabimaru_attack_2", true);
								} else if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Sword_Slash_Number == 2) {
									entity.getPersistentData().putBoolean("kusabimaru_attack_3", true);
								} else if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Sword_Slash_Number == 3) {
									entity.getPersistentData().putBoolean("kusabimaru_attack_4", true);
								} else if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Sword_Slash_Number == 4) {
									entity.getPersistentData().putBoolean("kusabimaru_attack_5", true);
								}
							} else {
								entity.getPersistentData().putBoolean("kusabimaru_attack_stab", true);
							}
						}
						if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount > 1) {
							{
								double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount - 1;
								entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.spiralcloudcount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount > 1) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, false, false));
							SpiraltestEntitySwingsItemProcedure.execute(world, x, y, z, entity);
						}
						if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount == 1) {
							{
								double _setval = 0;
								entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.spiralcloudcount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get());
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get());
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 15, 1, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get(), 10, 1, false, false));
							SpiraltestEntitySwingsItemProcedure.execute(world, x, y, z, entity);
						}
					}
					if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).shadowfall == true) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						ShadowslashesProcedure.execute(world, x, y, z, entity);
						WardenCurseMod.queueServerWork(13, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:woosh")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:woosh")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							SahdowtestsEntitySwingsItemProcedure.execute(world, entity);
						});
						{
							boolean _setval = false;
							entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shadowfall = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false
				&& !(entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get())) && !(entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
				&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).deathblowtoggle == false) {
			if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount > 1) {
				{
					double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount - 1;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spiralcloudcount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount > 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, false, false));
				SpiraltestEntitySwingsItemProcedure.execute(world, x, y, z, entity);
			}
			if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).spiralcloudcount == 1) {
				{
					double _setval = 0;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spiralcloudcount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get());
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 15, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get(), 10, 1, false, false));
				SpiraltestEntitySwingsItemProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).shadowfall == true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			ShadowslashesProcedure.execute(world, x, y, z, entity);
			WardenCurseMod.queueServerWork(13, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:swordswing")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:woosh")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:woosh")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				SahdowtestsEntitySwingsItemProcedure.execute(world, entity);
			});
			{
				boolean _setval = false;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.shadowfall = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
