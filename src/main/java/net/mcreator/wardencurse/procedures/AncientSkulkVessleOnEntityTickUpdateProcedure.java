package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class AncientSkulkVessleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:skulk1 entity @s 0 1 0");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/skulk1 entity @s 0 1 0");
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Posture Health: 2000/" + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("entity_posture")))), true);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			{
				final Vec3 _center = new Vec3(x, (y + 2), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(11.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						entity.getPersistentData().putBoolean("combat_range", true);
					} else {
						entity.getPersistentData().putBoolean("combat_range", false);
					}
				}
			}
			entity.getPersistentData().putBoolean("entity_on_battle", true);
			if (entity instanceof Mob _mob && _mob.getTarget() != null) {
				LivingEntity target = _mob.getTarget();
				double deltaX = target.getX() - entity.getX();
				double deltaZ = target.getZ() - entity.getZ();
				float targetYaw = (float) (Math.toDegrees(Math.atan2(deltaZ, deltaX))) - 90.0F;
				entity.setYRot(targetYaw);
				entity.yRotO = targetYaw;
				if (entity instanceof LivingEntity _livingEntity) {
					_livingEntity.yBodyRot = targetYaw;
					_livingEntity.yHeadRot = targetYaw;
				}
			}
			if (entity instanceof LivingEntity _livingEntity) {
				float targetYaw = _livingEntity.getYHeadRot();
				_livingEntity.setYRot(targetYaw);
				_livingEntity.yBodyRot = targetYaw;
				_livingEntity.yHeadRot = targetYaw;
				float currentYaw = _livingEntity.getYRot();
				float smoothYaw = currentYaw + (targetYaw - currentYaw) * 0.2F; // Adjust smoothing factor as needed
				_livingEntity.setYRot(smoothYaw);
				_livingEntity.yBodyRot = smoothYaw;
				_livingEntity.yHeadRot = smoothYaw;
			}
		} else {
			entity.getPersistentData().putBoolean("entity_on_battle", false);
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 2000) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 60, 1));
			}
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 100 && !(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
		}
		if (entity.getPersistentData().getDouble("Lock_Yaw") == 1) {
			entity.getPersistentData().putDouble("Yaw", (entity.getYRot()));
			entity.getPersistentData().putDouble("Pitch", (entity.getXRot()));
			entity.getPersistentData().putDouble("Lock_Yaw", 2);
		}
		if (entity.getPersistentData().getDouble("Lock_Yaw") == 2) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) entity.getPersistentData().getDouble("Yaw"));
				_ent.setXRot((float) entity.getPersistentData().getDouble("Pitch"));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getBoolean("MB_1") == true) {
				ASVmb1Procedure.execute(entity);
			} else {
				entity.getPersistentData().putDouble("Mobility_1_Timer", 0);
			}
			if (entity.getPersistentData().getBoolean("Attack_3") == true) {
				ASVatk3Procedure.execute(world, entity);
			} else {
				entity.getPersistentData().putDouble("Attack_3_Timer", 0);
			}
			if (entity.getPersistentData().getBoolean("Attack_2") == true) {
				ASVakt2Procedure.execute(world, entity);
			} else {
				entity.getPersistentData().putDouble("Attack_2_Timer", 0);
			}
			if (entity.getPersistentData().getBoolean("Attack_1") == true) {
				ASVatk1Procedure.execute(world, entity);
			} else {
				entity.getPersistentData().putDouble("Attack_1_Timer", 0);
			}
			if (entity.getPersistentData().getBoolean("Attack_4") == true) {
				ASVatk4Procedure.execute(world, entity);
			} else {
				entity.getPersistentData().putDouble("Attack_4_Timer", 0);
			}
			if (entity.getPersistentData().getBoolean("Attack_5") == true) {
				ASVatk5Procedure.execute(world, x, y, z, entity);
			} else {
				entity.getPersistentData().putDouble("Attack_5_Timer", 0);
			}
		}
	}
}
