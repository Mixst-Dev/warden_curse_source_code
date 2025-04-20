package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;

import java.util.List;
import java.util.Comparator;

public class PerilousswipeProcedure {
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
					final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 2.6), (ycord + (Math.sin(pitch) / magnitude) * (-1) - 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 2.6));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
								&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
							if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:perilous_swipe_dmg")))),
										(float) (18 * vent_power * sugar_power));
								if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
									entityiterator.setSecondsOnFire(5);
								}
								if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 10, 1, false, false));
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"/playsound warden_curse:injured player @a ~ ~ ~ 0.5");
									}
								}
							}
						}
					}
				}
				rotate = rotate + 20;
			}
		}
	}
}
