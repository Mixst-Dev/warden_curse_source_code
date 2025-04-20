package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
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

public class NaomoriAttack6Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double z2 = 0;
		double mypitch = 0;
		double x2 = 0;
		double myyaw = 0;
		entity.getPersistentData().putDouble("atk_6_timer", (entity.getPersistentData().getDouble("atk_6_timer") + 1));
		if (entity.getPersistentData().getDouble("atk_6_timer") == 1) {
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("attack6");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 110, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 6, false, false));
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 13);
		}
		if (entity.getPersistentData().getDouble("atk_6_timer") == 10) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.getPersistentData().putDouble("Lock_Yaw", 1);
			}
		}
		if (entity.getPersistentData().getDouble("atk_6_timer") == 17 || entity.getPersistentData().getDouble("atk_6_timer") == 27 || entity.getPersistentData().getDouble("atk_6_timer") == 37
				|| entity.getPersistentData().getDouble("atk_6_timer") == 47 || entity.getPersistentData().getDouble("atk_6_timer") == 57 || entity.getPersistentData().getDouble("atk_6_timer") == 67) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				NaomiSlamDmgProcedure.execute(world, entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:kusabimaru hostile @a ~ ~ ~ 1 0.8");
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("atk_6_timer") == 85) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				NaomiSlamDmgProcedure.execute(world, entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:kusabimaru hostile @a ~ ~ ~ 1 0.8");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:axe_slam_2 player @a ~ ~ ~ 0.7");
					}
				}
				x2 = entity.getX() + entity.getLookAngle().x * 2;
				z2 = entity.getZ() + entity.getLookAngle().z * 2;
				myyaw = entity.getYRot();
				mypitch = entity.getXRot();
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("summon warden_curse:axe_slam_visual " + x2 + " ~ " + z2 + " {Rotation:[" + myyaw + "f," + 0 + "f]}"));
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("atk_6_timer") >= 100) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 6);
			entity.getPersistentData().putDouble("atk_6_timer", 0);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putBoolean("Attack_6", false);
		}
		if (entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())) {
			entity.getPersistentData().putBoolean("Attack_6", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_1") == true) {
			entity.getPersistentData().putBoolean("Attack_6", false);
		}
		if (entity.getPersistentData().getBoolean("Counter_2") == true) {
			entity.getPersistentData().putBoolean("Attack_6", false);
		}
	}
}
