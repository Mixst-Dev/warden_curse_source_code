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
import net.mcreator.wardencurse.entity.SculkSoldier1Entity;

public class SculkAttack2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("akt2_timer", (entity.getPersistentData().getDouble("akt2_timer") + 1));
		if (entity.getPersistentData().getDouble("akt2_timer") == 1) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			if (entity instanceof SculkSoldier1Entity) {
				((SculkSoldier1Entity) entity).setAnimation("parry_slash_1");
			}
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:guarding_cloth player @a ~ ~ ~");
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 7, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 45, 7, false, false));
		}
		if (entity.getPersistentData().getDouble("akt2_timer") == 23) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				SculkSoldierdamage1Procedure.execute(world, entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:ashinacross player @a ~ ~ ~");
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1)));
			}
		}
		if (entity.getPersistentData().getDouble("akt2_timer") == 30) {
			entity.getPersistentData().putBoolean("Attack_2", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("akt2_timer", 0);
		}
	}
}
