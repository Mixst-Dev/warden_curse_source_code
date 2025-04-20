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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModEntities;
import net.mcreator.wardencurse.entity.MortalvisualEntity;

import java.util.List;
import java.util.Comparator;

public class MortaltestsEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
		double Xoffset = 0;
		double Zoffset = 0;
		double height = 0;
		double sugar_ako = 0;
		double sugar_power = 0;
		x2 = entity.getX();
		z2 = entity.getZ();
		myyaw = entity.getYRot();
		mypitch = entity.getXRot();
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		Xoffset = 2 * Math.sin(yaw) * (-1);
		Zoffset = 3 * Math.cos(yaw);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:mortaldraw_1 " + x2 + " ~0.2 " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
			}
		}
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_power = 1.125;
		} else if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_power = 1.25;
		} else {
			sugar_power = 1;
		}
		for (int index0 = 0; index0 < 5; index0++) {
			yaw = (entity.getYRot() - 40 + rotation) * (Math.PI / 180);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.MORTALVISUAL.get().spawn(_level,
						BlockPos.containing(xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 6.5, y - 1 + height, zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 6.5), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 6.5), (y - (1 + height)), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 6.5));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
								&& !(entityiterator instanceof MortalvisualEntity) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if ((entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == true) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 3.8 * sugar_power * 0.8));
							}
							if (entityiterator instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(WardenCurseModMobEffects.PARRY.get())
									&& !(entityiterator instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))
									|| entityiterator.getPersistentData().getBoolean("auto_parry") && !(entityiterator instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 3.8 * sugar_power * 0.2));
							} else if (entityiterator instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(WardenCurseModMobEffects.PARRY.get()) && entityiterator instanceof LivingEntity _livEnt27
									&& _livEnt27.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())
									|| entityiterator.getPersistentData().getBoolean("auto_parry") && entityiterator instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 3.8 * sugar_power));
							}
							if (!entityiterator.getPersistentData().getBoolean("auto_parry")
									&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false
									|| !(entityiterator instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(WardenCurseModMobEffects.PARRY.get()))
											&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 15, 1, false, false));
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 3.8 * sugar_power));
							}
						}
					}
				}
			}
			rotation = rotation + 27.2;
			height = height + 0.3;
		}
		for (int index1 = 0; index1 < 5; index1++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = WardenCurseModEntities.MORTALEXTRA.get().spawn(_level,
						BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -2, 2), y + Mth.nextInt(RandomSource.create(), 0, 3), z + Mth.nextInt(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}
