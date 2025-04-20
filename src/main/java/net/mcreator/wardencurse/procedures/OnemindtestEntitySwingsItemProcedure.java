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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;

import java.util.List;
import java.util.Comparator;

public class OnemindtestEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double height = 0;
		double rotation = 0;
		double mypitch = 0;
		double vent_power = 0;
		double sugar_power = 0;
		double z2 = 0;
		double x2 = 0;
		double myyaw = 0;
		double sugar_ako = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_power = 1.125;
		} else if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_power = 1.25;
		} else {
			sugar_power = 1;
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
			vent_power = 1.15;
		} else if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
			vent_power = 1.25;
		} else if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
			vent_power = 1.32;
		} else {
			vent_power = 1;
		}
		yaw = (entity.getYRot() + 90) * (Math.PI / 180);
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		for (int index0 = 0; index0 < 5; index0++) {
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 3), (ycord + (Math.sin(pitch) / magnitude) * (-1) + height), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 3));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.25 * vent_power * sugar_power));
							if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
								entityiterator.setSecondsOnFire(3);
							}
						}
						if (entityiterator instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(WardenCurseModMobEffects.PARRY.get())
								&& !(entityiterator instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 20, 1, false, false));
						}
					}
				}
			}
			height = height + 1;
		}
	}
}
