package net.mcreator.wardencurse.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class DeathblowDetectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double size = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = entity.getXRot() * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		{
			final Vec3 _center = new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity) && entityiterator == ((Entity) world
						.getEntitiesOfClass(LivingEntity.class,
								AABB.ofSize(new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude)), 4, 4, 4), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude))).findFirst().orElse(null))
						&& entityiterator instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:denied")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("warden_curse:denied")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false));
				}
			}
		}
	}
}
