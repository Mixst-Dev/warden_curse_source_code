package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModEntities;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class VentfunctionpropertiesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		if (entity.getPersistentData().getDouble("mixstvent") == 1) {
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = entity.getXRot() * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.VENT_F.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ItemEntity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE), entity),
								(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 1.3));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 20, 1, false, false));
						entityiterator.setSecondsOnFire(5);
					}
				}
			}
			entity.getPersistentData().putDouble("mixstvent", 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.FIRESTATE.get(), 300, 1, false, false));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get());
		}
		if (entity.getPersistentData().getDouble("mixstvent") == 2) {
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = entity.getXRot() * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.VENT_L.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ItemEntity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
								(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 1.4));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 20, 1, false, false));
					}
				}
			}
			entity.getPersistentData().putDouble("mixstvent", 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLUEFIRESTATE.get(), 400, 1, false, false));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.FIRESTATE.get());
		}
		if (entity.getPersistentData().getDouble("mixstvent") == 3) {
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = entity.getXRot() * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.VENT_C.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ItemEntity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
								(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 1.5));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 20, 1, false, false));
					}
				}
			}
			entity.getPersistentData().putDouble("mixstvent", 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.CURSEDFIRESTATE.get(), 380, 1, false, false));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.FIRESTATE.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get());
		}
	}
}
