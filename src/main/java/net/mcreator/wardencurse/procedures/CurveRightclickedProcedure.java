package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class CurveRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double rotation = 0;
		rotation = 0;
		yaw = (entity.getYRot() + rotation) * (Math.PI / 180);
		pitch = entity.getXRot() * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		for (int index0 = 0; index0 < 180; index0++) {
			yaw = (entity.getYRot() + rotation) * (Math.PI / 180);
			world.addParticle(ParticleTypes.END_ROD, (xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 4), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 4), 0, 0, 0);
			world.addParticle(ParticleTypes.FLAME, (xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 3.5), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 3.5), 0, 0, 0);
			world.addParticle(ParticleTypes.FLAME, (xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 4.5), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 4.5), 0, 0, 0);
			world.addParticle(ParticleTypes.FLAME, (xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 4.7), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 4.7), 0, 0, 0);
			world.addParticle(ParticleTypes.FLAME, (xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 3.3), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 3.3), 0, 0, 0);
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 4.5), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 4.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof ItemEntity)) {
						entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 3), 0.6, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 3)));
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), Mth.nextInt(RandomSource.create(), 19, 24));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BLEEDING.get(), 150, 1, false, false));
					}
				}
			}
			rotation = rotation + 1;
		}
	}
}
