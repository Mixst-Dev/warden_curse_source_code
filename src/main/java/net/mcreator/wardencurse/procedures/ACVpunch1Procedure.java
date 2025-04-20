package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ACVpunch1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
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
			final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2 * 1.3), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2 * 1.3));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator) && !(entityiterator instanceof ItemEntity) && entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 23);
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.4), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.4)));
					entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.4), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.4)));
					if (!(entityiterator instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.PARRY.get()))
							&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 15, 1));
					}
					if (entityiterator instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.PARRY.get())) {
						entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + 50));
					}
					entityiterator.invulnerableTime = 0;
				}
			}
		}
	}
}
