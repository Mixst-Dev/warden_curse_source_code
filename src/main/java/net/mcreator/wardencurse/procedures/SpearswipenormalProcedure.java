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

import java.util.List;
import java.util.Comparator;

public class SpearswipenormalProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
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
		double vent_power = 0;
		double sugar_power = 0;
		double sugar_ako = 0;
		x2 = entity.getX();
		z2 = entity.getZ();
		myyaw = entity.getYRot();
		mypitch = entity.getXRot();
		pitch = 1 * (Math.PI / 180);
		magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
		xcord = entity.getX();
		ycord = entity.getY();
		zcord = entity.getZ();
		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
			sugar_power = 1.125;
		} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			sugar_power = 1.25;
		} else {
			sugar_power = 1;
		}
		for (int index0 = 0; index0 < 20; index0++) {
			yaw = (entity.getYRot() - (30 + rotation + 135)) * (Math.PI / 180);
			{
				final Vec3 _center = new Vec3((xcord + ((Math.cos(yaw) * Math.cos(pitch)) / magnitude) * 6), (ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5), (zcord + ((Math.sin(yaw) * Math.cos(pitch)) / magnitude) * 6));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
									(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 1.4 * sugar_power));
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:attackimpact player @a ~ ~ ~");
								}
							}
						}
						if (entityiterator instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(WardenCurseModMobEffects.PARRY.get())
								&& !(entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.PARRY.get()))
								&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 10, 1, false, false));
						}
					}
				}
			}
			rotation = rotation + 12;
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:spearswipe " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
			}
		}
	}
}
