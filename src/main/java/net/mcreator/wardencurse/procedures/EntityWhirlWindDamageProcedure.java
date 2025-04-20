package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
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
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.List;
import java.util.Comparator;

public class EntityWhirlWindDamageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double rotate = 0;
		double rotation = 0;
		double mypitch = 0;
		double vent_power = 0;
		double sugar_power = 0;
		double z2 = 0;
		double x2 = 0;
		double myyaw = 0;
		double sugar_ako = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			pitch = 1 * (Math.PI / 180);
			magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
				sugar_power = 1.125;
			} else if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
				sugar_power = 1.25;
			} else {
				sugar_power = 1;
			}
			if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
				vent_power = 1.15;
			} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
				vent_power = 1.25;
			} else if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
				vent_power = 1.32;
			} else {
				vent_power = 1;
			}
			for (int index0 = 0; index0 < 9; index0++) {
				yaw = (entity.getYRot() + rotate) * (Math.PI / 180);
				{
					final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2.6), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2.6));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator) && !(entityiterator instanceof ItemEntity) && entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), (float) (8 * 1.125 * vent_power * sugar_power));
								entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.5), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.5)));
								if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
									entityiterator.setSecondsOnFire(3);
								}
							}
							if (entityiterator instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(WardenCurseModMobEffects.PARRY.get())
									&& !(entityiterator instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
								entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + 4));
							}
							if (!(entityiterator instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(WardenCurseModMobEffects.PARRY.get()))
									&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 10, 1, false, false));
							}
							WardenCurseMod.queueServerWork(1, () -> {
								entityiterator.invulnerableTime = 0;
							});
						}
					}
				}
				rotate = rotate + 20;
			}
		}
	}
}
