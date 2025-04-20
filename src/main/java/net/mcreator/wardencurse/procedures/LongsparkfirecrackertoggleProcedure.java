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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModEntities;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.List;
import java.util.Comparator;

public class LongsparkfirecrackertoggleProcedure {
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
		double mypitch = 0;
		double z2 = 0;
		double x2 = 0;
		double myyaw = 0;
		double myyaw2 = 0;
		double myyaw3 = 0;
		double rotation2 = 0;
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getPersistentData().getDouble("fire_cracker_x");
		ycord = entity.getPersistentData().getDouble("fire_cracker_y");
		zcord = entity.getPersistentData().getDouble("fire_cracker_z");
		for (int index0 = 0; index0 < 12; index0++) {
			yaw = (entity.getPersistentData().getDouble("fire_cracker_yaw") + rotation) * (Math.PI / 180);
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 5), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 30, 1, false, false));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker"))), entity),
									(float) 0.1);
							WardenCurseMod.queueServerWork(1, () -> {
								entityiterator.invulnerableTime = 0;
							});
						}
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:sekiro_beast")))) {
							entityiterator.getPersistentData().putDouble("entity_posture", (entityiterator.getPersistentData().getDouble("entity_posture") + 20));
						}
					}
				}
			}
			rotation = rotation + 15;
		}
		for (int index1 = 0; index1 < 6; index1++) {
			yaw = (entity.getPersistentData().getDouble("fire_cracker_yaw") + 20 + rotation2) * (Math.PI / 180);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.NFC.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 5, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			rotation2 = rotation2 + 28;
		}
	}
}
