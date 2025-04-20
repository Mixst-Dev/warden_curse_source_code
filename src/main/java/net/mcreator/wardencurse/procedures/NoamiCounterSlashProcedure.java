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

public class NoamiCounterSlashProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("counter_1_timer", (entity.getPersistentData().getDouble("counter_1_timer") + 1));
		if (entity.getPersistentData().getDouble("counter_1_timer") == 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 38, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 7, false, false));
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("counter_slash");
			}
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("counter_1_timer") == 15) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				NaomiSlamDmgProcedure.execute(world, entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:ashinacross player @a ~ ~ ~");
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("counter_1_timer") >= 36) {
			entity.getPersistentData().putBoolean("Counter_1", false);
			if (entity.getPersistentData().getBoolean("Combat_Range") == true) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.6) {
						if (entity instanceof GeneralNaomiKawaradaEntity) {
							((GeneralNaomiKawaradaEntity) entity).setAnimation("attack2");
						}
						entity.getPersistentData().putBoolean("Attack_2", true);
					} else {
						if (entity instanceof GeneralNaomiKawaradaEntity) {
							((GeneralNaomiKawaradaEntity) entity).setAnimation("attack6");
						}
						entity.getPersistentData().putBoolean("Attack_6", true);
					}
				}
			}
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("counter_1_timer", 0);
		}
	}
}
