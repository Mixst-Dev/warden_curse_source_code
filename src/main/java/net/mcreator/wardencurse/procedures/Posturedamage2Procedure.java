package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Posturedamage2Procedure {
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
		double gokan = 0;
		double yashariku = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.GOKAN.get())) {
			gokan = 0.67;
		} else {
			gokan = 1;
		}
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
			yashariku = 2;
		} else {
			yashariku = 1;
		}
		if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.PARRY.get()))
				&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false) {
			if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).sekirotoggle == true) {
				HurtVFXProcedure.execute(world, entity);
			}
		}
		if (WardenCurseModVariables.MapVariables.get(world).config_posture_toggle == true) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:deathblowed"))) && !damagesource.is(DamageTypes.IN_FIRE) && !damagesource.is(DamageTypes.ON_FIRE)) {
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(WardenCurseModMobEffects.PARRY.get()))
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false) {
					{
						double _setval = (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).posturedmg
								+ (amount * 4 * gokan + yashariku) * (1 - WardenCurseModVariables.MapVariables.get(world).posture_multipler);
						entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.posturedmg = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get(), 30, 1, false, false));
		}
	}
}
