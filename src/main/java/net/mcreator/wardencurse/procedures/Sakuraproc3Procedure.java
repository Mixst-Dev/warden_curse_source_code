package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModEntities;
import net.mcreator.wardencurse.entity.SakuravisualEntity;
import net.mcreator.wardencurse.entity.Sakura3Entity;
import net.mcreator.wardencurse.entity.Sakura2Entity;
import net.mcreator.wardencurse.entity.Sakura1Entity;

import java.util.List;
import java.util.Comparator;

public class Sakuraproc3Procedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
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
		double rotation = 0;
		double height = 0;
		double sugar_ako = 0;
		double vent_power = 0;
		double sugar_power = 0;
		x2 = entity.getX() + entity.getLookAngle().x * 2;
		z2 = entity.getZ() + entity.getLookAngle().z * 2;
		mypitch = entity.getXRot();
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		myyaw = entity.getYRot();
		if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_power = 1.125;
		} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_power = 1.25;
		} else {
			sugar_power = 1;
		}
		if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			vent_power = 1.15;
		} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			vent_power = 1.25;
		} else if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			vent_power = 1.32;
		} else {
			vent_power = 1;
		}
		entity.setDeltaMovement(new Vec3(0, 0.6, 0));
		for (int index0 = 0; index0 < 13; index0++) {
			yaw = ((entity.getYRot() + rotation) - 48) * (Math.PI / 180);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.SAKURAVISUAL.get().spawn(_level, BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.sin(yaw) * (-1) + 5 * Math.cos(yaw)) * 1, y + height + 2,
						zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.cos(yaw) + 5 * Math.sin(yaw)) * 1), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.sin(yaw) * (-1) + 4.5 * Math.cos(yaw)) * 1), (y + height + 1.4),
						(zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.cos(yaw) + 4.5 * Math.sin(yaw)) * 1));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !(entityiterator instanceof SakuravisualEntity) && !(entityiterator instanceof Sakura3Entity) && !(entityiterator instanceof Sakura2Entity) && !(entityiterator instanceof Sakura1Entity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.2 * vent_power * sugar_power));
							entity.hurtMarked = true;
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.03), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.03)));
							if (entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
								entityiterator.setSecondsOnFire(2);
							}
						}
						if (entityiterator instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(WardenCurseModMobEffects.PARRY.get())) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 10, 1, false, false));
						}
						entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.02), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.02)));
					}
				}
			}
			rotation = rotation + 18;
			height = height + 0;
		}
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (!(entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) && !(entity instanceof LivingEntity _livEnt47 && _livEnt47.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))
				&& !(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:sakura_3 " + x2 + " ~0.5 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nsakurafire_3 " + x2 + " ~0.5 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nsakuralazulite_3 " + x2 + " ~0.5 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nsakuracurse_3 " + x2 + " ~0.5 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		{
			boolean _setval = false;
			entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Cancel_Art_Toggle = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
