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

import java.util.List;
import java.util.Comparator;

public class LazuliteAxeSlamProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double sugar_power = 0;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double magnitude = 0;
		double myyaw = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		x2 = entity.getX() + entity.getLookAngle().x * 2;
		z2 = entity.getZ() + entity.getLookAngle().z * 2;
		myyaw = entity.getYRot();
		mypitch = entity.getXRot();
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = entity.getXRot() * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_power = 1.125;
		} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_power = 1.25;
		} else {
			sugar_power = 1;
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:lazuliteaxevisual " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:lazulite_explosion player @a ~ ~ ~ 0.7");
			}
		}
		{
			final Vec3 _center = new Vec3((xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
						&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
						&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
					if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
								(float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 2.9 * sugar_power));
						entityiterator.getPersistentData().putDouble("ex_posture", (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 1.45 * sugar_power * 3 * 2));
					}
					if (entityiterator instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(WardenCurseModMobEffects.PARRY.get())
							&& !(entityiterator instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
					}
					if (!(entityiterator instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(WardenCurseModMobEffects.PARRY.get()))
							&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 25, 1, false, false));
					}
				}
			}
		}
	}
}
