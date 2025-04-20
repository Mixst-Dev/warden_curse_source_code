package net.mcreator.wardencurse.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class Swing1procProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double varient = 0;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		double burnout = 0;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double Xoffset = 0;
		double Zoffset = 0;
		double num = 0;
		double sugar_ako = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.PARRY.get()))) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
				sugar_ako = 1.25;
			}
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get()))) {
				sugar_ako = 1;
			}
			x2 = entity.getX();
			z2 = entity.getZ();
			myyaw = entity.getYRot();
			mypitch = entity.getXRot();
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = 1 * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2.5), (y + 1.2), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(WardenCurseModMobEffects.FIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
							if (!(entityiterator instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (9 * sugar_ako));
								if (Math.random() < 0.4) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (11 * sugar_ako));
								entityiterator.setSecondsOnFire(5);
								if (Math.random() < 0.5) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (14 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (15 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (!(entityiterator instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.05), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.05)));
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude + 1.5 * Math.sin(yaw) * (-1)) * 1.5), (y + 1.2), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude + 1.5 * Math.cos(yaw)) * 1.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(WardenCurseModMobEffects.FIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt56 && _livEnt56.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
							if (!(entityiterator instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (9 * sugar_ako));
								if (Math.random() < 0.4) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt64 && _livEnt64.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (11 * sugar_ako));
								entityiterator.setSecondsOnFire(5);
								if (Math.random() < 0.5) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt70 && _livEnt70.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt71 && _livEnt71.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (14 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (entity instanceof LivingEntity _livEnt76 && _livEnt76.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt77 && _livEnt77.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (15 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (!(entityiterator instanceof LivingEntity _livEnt82 && _livEnt82.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.05), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.05)));
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude + (-1.5) * Math.sin(yaw) * (-1)) * 1.5), (y + 1.2), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude + (-1.5) * Math.cos(yaw)) * 1.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entity instanceof LivingEntity _livEnt95 && _livEnt95.hasEffect(WardenCurseModMobEffects.FIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt96 && _livEnt96.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))
								|| !(entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
							if (!(entityiterator instanceof LivingEntity _livEnt98 && _livEnt98.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (9 * sugar_ako));
								if (Math.random() < 0.4) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt103 && _livEnt103.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt104 && _livEnt104.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (11 * sugar_ako));
								entityiterator.setSecondsOnFire(5);
								if (Math.random() < 0.5) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
								}
							}
						}
						if (entity instanceof LivingEntity _livEnt110 && _livEnt110.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt111 && _livEnt111.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (14 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (entity instanceof LivingEntity _livEnt116 && _livEnt116.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
							if (!(entityiterator instanceof LivingEntity _livEnt117 && _livEnt117.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (15 * sugar_ako));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 60, 1, false, false));
							}
						}
						if (!(entityiterator instanceof LivingEntity _livEnt122 && _livEnt122.hasEffect(WardenCurseModMobEffects.PARRY.get())) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.05), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.05)));
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:injured")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt131 && _livEnt131.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nfireslash_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt133 && _livEnt133.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nlazuliteslash_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt135 && _livEnt135.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:ncursedslash_1 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
		}
	}
}
