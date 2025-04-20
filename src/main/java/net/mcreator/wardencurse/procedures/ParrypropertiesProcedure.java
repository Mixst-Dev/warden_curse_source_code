package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
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
import net.mcreator.wardencurse.WardenCurseMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ParrypropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		execute(null, world, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		double ycord = 0;
		double magnitude = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		double proX = 0;
		double proY = 0;
		double proZ = 0;
		double gokan = 0;
		double yashariku = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.PARRY.get()) && (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.FIREBALL)
					|| damagesource.is(DamageTypes.FIREWORKS) || damagesource.is(DamageTypes.LIGHTNING_BOLT) || damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO) || damagesource.is(DamageTypes.MOB_PROJECTILE)
					|| damagesource.is(DamageTypes.PLAYER_ATTACK) || damagesource.is(DamageTypes.PLAYER_EXPLOSION) || damagesource.is(DamageTypes.SONIC_BOOM) || damagesource.is(DamageTypes.TRIDENT) || damagesource.is(DamageTypes.WITHER_SKULL)
					|| damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:perilous_stab"))) || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:powerfullhit")))
					|| damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash"))) || damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:shuriken_dmg"))))) {
				if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:mortalslash")))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
				if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(WardenCurseModMobEffects.GOKAN.get())) {
					gokan = 0.67;
				} else {
					gokan = 1;
				}
				if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
					yashariku = 2;
				} else {
					yashariku = 1;
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get(), 45, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 5, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 8, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get(), 8, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
				WardenCurseMod.queueServerWork(1, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(WardenCurseModMobEffects.PARRY.get());
				});
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:blocking player @a ~ ~ ~ 0.7");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:parrying player @a ~ ~ ~ 0.7");
					}
				}
				if (entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(WardenCurseModMobEffects.PARRY.get())) {
					{
						double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).posturedmg
								+ (amount * 3.2 * gokan + yashariku) * (1 - WardenCurseModVariables.MapVariables.get(world).posture_multipler);
						entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.posturedmg = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				yaw = (entity.getYRot() + 90) * (Math.PI / 180);
				pitch = entity.getXRot() * (Math.PI / 180);
				magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
				xcord = entity.getX();
				ycord = entity.getY();
				zcord = entity.getZ();
				yaw = (entity.getYRot() + 90) * (Math.PI / 180);
				pitch = 1 * (Math.PI / 180);
				magnitude = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
				xcord = entity.getX();
				ycord = entity.getY();
				zcord = entity.getZ();
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = WardenCurseModEntities.PARRYVISUALENTITY.get().spawn(_level,
							BlockPos.containing(xcord + (Math.cos(yaw) * Math.cos(pitch)) / magnitude, ycord + (Math.sin(pitch) / magnitude) * (-1) + 1.5, zcord + (Math.sin(yaw) * Math.cos(pitch)) / magnitude), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
