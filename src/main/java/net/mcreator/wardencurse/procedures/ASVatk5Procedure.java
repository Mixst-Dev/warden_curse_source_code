package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

public class ASVatk5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Attack_5_Timer", (entity.getPersistentData().getDouble("Attack_5_Timer") + 1));
		if (entity.getPersistentData().getDouble("Attack_5_Timer") == 1) {
			if (entity instanceof AncientSkulkVessleEntity) {
				((AncientSkulkVessleEntity) entity).setAnimation("perilous3");
			}
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				{
					Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:aperilous entity @s 0 2.5 0");
					}
				}
				{
					Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:perilous player @a ~ ~ ~");
					}
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 120, false, false));
			entity.getPersistentData().putDouble("attacktimer", 70);
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
		}
		if (entity.getPersistentData().getDouble("Attack_5_Timer") == 14) {
			ASVboostProcedure.execute(entity);
		}
		if (entity.getPersistentData().getDouble("Attack_5_Timer") == 27) {
			entity.setDeltaMovement(new Vec3(0, (-5), 0));
		}
		if (entity.getPersistentData().getDouble("Attack_5_Timer") == 31) {
			ASVSlam1Procedure.execute(world, x, y, z, entity);
			{
				Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:skulk2 entity @s 0 2.5 0");
				}
			}
		}
		if (entity.getPersistentData().getDouble("Attack_5_Timer") == 50) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putBoolean("Attack_5", false);
		}
	}
}
