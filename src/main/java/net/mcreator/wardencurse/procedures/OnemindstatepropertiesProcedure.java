package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.OnemindstartEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class OnemindstatepropertiesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).onemind == true) {
			entity.getPersistentData().putDouble("onemind_timer", (entity.getPersistentData().getDouble("onemind_timer") + 1));
			if (entity.getPersistentData().getDouble("onemind_timer") == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.MOBILITYCOOLDOWN.get(), 85, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get(), 85, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 85, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 85, 5, false, false));
				x2 = entity.getX() + entity.getLookAngle().x * 4;
				z2 = entity.getZ() + entity.getLookAngle().z * 4;
				myyaw = entity.getPersistentData().getDouble("onemind_yaw");
				mypitch = entity.getXRot();
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:onemindstart " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 2) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof OnemindstartEntity) {
							if (entityiterator.getPersistentData().getDouble("onemine_start_visual") == 0) {
								if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
									entityiterator.getPersistentData().putDouble("onemine_start_visual", 2);
								} else if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
									entityiterator.getPersistentData().putDouble("onemine_start_visual", 3);
								} else if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
									entityiterator.getPersistentData().putDouble("onemine_start_visual", 4);
								} else {
									entityiterator.getPersistentData().putDouble("onemine_start_visual", 1);
								}
							}
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 10) {
				OnemindtestEntitySwingsItemProcedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.5), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.5)));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.NO_JUMP_2.get(), 70, 5, false, false));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:onemind player @a ~ ~ ~ 0.7");
					}
				}
				entity.getPersistentData().putDouble("onemind_x", (entity.getX()));
				entity.getPersistentData().putDouble("onemind_y", (entity.getY()));
				entity.getPersistentData().putDouble("onemind_z", (entity.getZ()));
				entity.getPersistentData().putDouble("onemind_yaw", (entity.getYRot()));
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 35) {
				x2 = entity.getX() + entity.getLookAngle().x * 2.5;
				z2 = entity.getZ() + entity.getLookAngle().z * 2.5;
				myyaw = entity.getPersistentData().getDouble("onemind_yaw");
				mypitch = entity.getXRot();
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:onemind_2 " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
				OneminddmgProcedure.execute(world, entity);
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 40 || entity.getPersistentData().getDouble("onemind_timer") == 45 || entity.getPersistentData().getDouble("onemind_timer") == 50) {
				OneminddmgProcedure.execute(world, entity);
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 56) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 3), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 3)));
			}
			if (entity.getPersistentData().getDouble("onemind_timer") == 58) {
				KusabimaruDamageProcedure.execute(world, entity);
			}
			if (entity.getPersistentData().getDouble("onemind_timer") > 60) {
				entity.getPersistentData().putDouble("onemind_timer", 0);
				{
					boolean _setval = false;
					entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.onemind = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
