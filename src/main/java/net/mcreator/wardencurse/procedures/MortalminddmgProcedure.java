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
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.MortalvisualEntity;

import java.util.List;
import java.util.Comparator;

public class MortalminddmgProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vent_power = 0;
		double sugar_power = 0;
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
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !(entityiterator instanceof MortalvisualEntity) && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if ((entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == true) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.9 * sugar_power * 0.8));
						}
						if (entityiterator instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(WardenCurseModMobEffects.PARRY.get())
								&& !(entityiterator instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get()))) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.9 * sugar_power * 0.2));
						} else if (entityiterator instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(WardenCurseModMobEffects.PARRY.get()) && entityiterator instanceof LivingEntity _livEnt18
								&& _livEnt18.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.9 * sugar_power));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entityiterator.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 3, 1, false, false));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.9 * sugar_power));
						}
						entityiterator.invulnerableTime = 0;
					}
				}
			}
		}
	}
}
