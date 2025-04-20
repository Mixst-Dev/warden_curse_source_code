package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.WardenCurseMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class ShadowstateProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double sugar_ako = 0;
		double rotation = 0;
		double vent_power = 0;
		double sugar_power = 0;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).shadowstate == true) {
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = entity.getXRot() * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			x2 = entity.getX() + 1.5 * entity.getLookAngle().x;
			z2 = entity.getZ() + 1.5 * entity.getLookAngle().z;
			myyaw = entity.getYRot();
			mypitch = entity.getXRot();
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
				sugar_power = 1.125;
			} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
				sugar_power = 1.25;
			} else {
				sugar_power = 1;
			}
			if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
				vent_power = 1.15;
			} else if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
				vent_power = 1.25;
			} else if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
				vent_power = 1.32;
			} else {
				vent_power = 1;
			}
			{
				final Vec3 _center = new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (y + 1), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity instanceof LivingEntity && !(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						entity.getPersistentData().putBoolean("toggle", true);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							{
								double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).ceremol_emblem - 2;
								entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ceremol_emblem = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("toggle") == true) {
			{
				final Vec3 _center = new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (y + 1), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity instanceof LivingEntity && !(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
						if ((entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
							if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:perilous_stab"))), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.5 * vent_power * sugar_power));
								if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
									entityiterator.setSecondsOnFire(5);
								}
							}
							if (entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(WardenCurseModMobEffects.PARRY.get())
									&& !(entityiterator instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
							}
							if (!(entityiterator instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(
									WardenCurseModMobEffects.PARRY.get())) == ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 15, 1, false, false));
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.FREEZEMOVE.get(), 3, 1, false, false));
						WardenCurseMod.queueServerWork(7, () -> {
							entity.hurtMarked = true;
							entity.setDeltaMovement(new Vec3(0, 0.7, 0));
							WardenCurseMod.queueServerWork(3, () -> {
								{
									boolean _setval = true;
									entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.shadowfall = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							});
							WardenCurseMod.queueServerWork(15, () -> {
								{
									boolean _setval = false;
									entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.shadowfall = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							});
						});
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 40, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 4, 1, false, false));
			entity.getPersistentData().putBoolean("toggle", false);
			{
				boolean _setval = false;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.shadowstate = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) && !(entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(WardenCurseModMobEffects.FIRESTATE.get()))
					&& !(entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:shadowslash " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:fireshadowslash " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:bluefireshadowslash " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt56 && _livEnt56.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:cursedfireshadowslash " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
		}
	}
}
