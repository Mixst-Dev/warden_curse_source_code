package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;

public class ASVmb1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Mobility_1_Timer", (entity.getPersistentData().getDouble("Mobility_1_Timer") + 1));
		if (entity.getPersistentData().getDouble("Mobility_1_Timer") == 1) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			if (entity instanceof AncientSkulkVessleEntity) {
				((AncientSkulkVessleEntity) entity).setAnimation("disengage");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 120, false, false));
			entity.getPersistentData().putDouble("attacktimer", 20);
		}
		if (entity.getPersistentData().getDouble("Mobility_1_Timer") == 18) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * (-2)), 0.4, (entity.getDeltaMovement().z() + entity.getLookAngle().z * (-2))));
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:ashinaboost entity @s 0 0 0");
				}
			}
		}
		if (entity.getPersistentData().getDouble("Mobility_1_Timer") == 20) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putBoolean("MB_1", false);
		}
	}
}
