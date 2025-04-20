package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BurningPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
		execute(null, world, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (WardenCurseModVariables.MapVariables.get(world).Config_Burn_Status == true) {
			if (!entity.fireImmune() && (entity instanceof Player || entity instanceof ServerPlayer)) {
				if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(WardenCurseModMobEffects.BURNING.get()))) {
					if (damagesource.is(DamageTypes.ON_FIRE)) {
						entity.clearFire();
						{
							double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Fire_HP + 15;
							entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Fire_HP = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BURNHEALCOOLDOWN.get(), 20, 1, false, false));
					} else if (damagesource.is(DamageTypes.IN_FIRE)) {
						entity.clearFire();
						{
							double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Fire_HP + 15;
							entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Fire_HP = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BURNHEALCOOLDOWN.get(), 20, 1, false, false));
					} else if (damagesource.is(DamageTypes.FIREBALL)) {
						entity.clearFire();
						{
							double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Fire_HP + 75;
							entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Fire_HP = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BURNHEALCOOLDOWN.get(), 40, 1, false, false));
					} else if (damagesource.is(DamageTypes.LAVA)) {
						entity.clearFire();
						{
							double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).Fire_HP + 95;
							entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Fire_HP = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.BURNHEALCOOLDOWN.get(), 50, 1, false, false));
					}
				} else if ((damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.LAVA)) && entity instanceof LivingEntity _livEnt20
						&& _livEnt20.hasEffect(WardenCurseModMobEffects.BURNING.get())) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:burn entity @s 0 0.5 0");
						}
					}
				}
			}
		}
	}
}
