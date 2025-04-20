package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

public class NaomariAttack2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("atk_2_timer", (entity.getPersistentData().getDouble("atk_2_timer") + 1));
		if (entity.getPersistentData().getDouble("atk_2_timer") == 1) {
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("attack2");
			}
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 13);
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 5, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 30, 1, false, false));
		}
		if (entity.getPersistentData().getDouble("atk_2_timer") == 15) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:kusabimaru hostile @a ~ ~ ~ 1 0.8");
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("atk_2_timer") == 17) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				NaomiSlamDmgProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("atk_2_timer") == 25) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 6);
			entity.getPersistentData().putBoolean("Attack_2", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("atk_2_timer", 0);
		}
		if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) {
			entity.getPersistentData().putBoolean("Attack_2", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_1") == true) {
			entity.getPersistentData().putBoolean("Attack_2", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_2") == true) {
			entity.getPersistentData().putBoolean("Attack_2", false);
		}
	}
}
