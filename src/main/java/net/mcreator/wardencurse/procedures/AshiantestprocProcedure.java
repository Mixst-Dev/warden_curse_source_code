package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
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
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.List;
import java.util.Comparator;

public class AshiantestprocProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		double ycord = 0;
		double size = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double rotation = 0;
		double sugar_ako = 0;
		double vent_power = 0;
		x2 = entity.getX();
		z2 = entity.getZ();
		myyaw = entity.getYRot();
		mypitch = entity.getXRot();
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_ako = 1.125;
		} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_ako = 1.25;
		} else {
			sugar_ako = 1;
		}
		if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			vent_power = 1.15;
		} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			vent_power = 1.25;
		} else if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			vent_power = 1.32;
		} else {
			vent_power = 1;
		}
		for (int index0 = 0; index0 < 9; index0++) {
			yaw = (entity.getYRot() + rotation) * (Math.PI / 180);
			{
				final Vec3 _center = new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.cos(yaw)), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5),
						(zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude + 2 * Math.sin(yaw)));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.3 * vent_power * sugar_ako));
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1.03), 0.2, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1.03)));
							if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
								entityiterator.setSecondsOnFire(5);
							}
						}
						if (entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(WardenCurseModMobEffects.PARRY.get())
								&& !(entityiterator instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt34 && _livEnt34
								.hasEffect(WardenCurseModMobEffects.PARRY.get())) == ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 10, 1, false, false));
						}
					}
				}
			}
			rotation = rotation + 20;
		}
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		WardenCurseMod.queueServerWork(3, () -> {
			Ashinatestproc2Procedure.execute(world, y, entity);
		});
		if (!(entity instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) && !(entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(WardenCurseModMobEffects.FIRESTATE.get()))
				&& !(entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get()))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nashina " + x2 + " ~0.1 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nashinafire " + x2 + " ~0.1 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nashinalazulite " + x2 + " ~0.1 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:nashinacurse " + x2 + " ~0.1 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
				}
			}
		}
	}
}
