package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModEntities;
import net.mcreator.wardencurse.WardenCurseMod;

public class SpinningLazuliteShurikenDmgProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity.onGround()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			entity.hurt(
					new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity, sourceentity),
					(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875));
			if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(WardenCurseModMobEffects.PARRY.get()))
					&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
					}
				}
			}
			entity.invulnerableTime = 0;
			WardenCurseMod.queueServerWork(5, () -> {
				if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.PARRY.get()))
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
						}
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				entity.invulnerableTime = 0;
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity,
						sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875));
				WardenCurseMod.queueServerWork(5, () -> {
					if (!(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(WardenCurseModMobEffects.PARRY.get()))
							&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
							}
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					entity.invulnerableTime = 0;
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity,
							sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875));
					WardenCurseMod.queueServerWork(5, () -> {
						if (!(entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
								}
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
						entity.invulnerableTime = 0;
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))),
								immediatesourceentity, sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875));
					});
				});
			});
		} else {
			if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(WardenCurseModMobEffects.PARRY.get()))
					&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			entity.hurt(
					new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity, sourceentity),
					(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875 * 1.4));
			entity.invulnerableTime = 0;
			WardenCurseMod.queueServerWork(5, () -> {
				if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(WardenCurseModMobEffects.PARRY.get()))
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
						}
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				entity.invulnerableTime = 0;
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity,
						sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875 * 1.4));
				WardenCurseMod.queueServerWork(5, () -> {
					if (!(entity instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(WardenCurseModMobEffects.PARRY.get()))
							&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
							}
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					entity.invulnerableTime = 0;
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))), immediatesourceentity,
							sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875 * 1.4));
					WardenCurseMod.queueServerWork(5, () -> {
						if (!(entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:shuriken_impact player @a ~ ~ ~ 0.7");
								}
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = WardenCurseModEntities.LAZULITESHURIKENVISUAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
						entity.invulnerableTime = 0;
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))),
								immediatesourceentity, sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.296875 * 1.4));
					});
				});
			});
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
