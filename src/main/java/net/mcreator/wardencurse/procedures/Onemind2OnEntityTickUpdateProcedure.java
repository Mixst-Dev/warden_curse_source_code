package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Onemind2OnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			entity.getPersistentData().putDouble("aframe", 1);
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			entity.getPersistentData().putDouble("aframe", 2);
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			entity.getPersistentData().putDouble("aframe", 3);
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			entity.getPersistentData().putDouble("aframe", 4);
		}
		if (entity.getPersistentData().getDouble("timer") == 8) {
			entity.getPersistentData().putDouble("aframe", 5);
		}
		if (entity.getPersistentData().getDouble("timer") == 10) {
			entity.getPersistentData().putDouble("aframe", 6);
		}
		if (entity.getPersistentData().getDouble("timer") == 12) {
			entity.getPersistentData().putDouble("aframe", 7);
		}
		if (entity.getPersistentData().getDouble("timer") == 14) {
			entity.getPersistentData().putDouble("aframe", 8);
		}
		if (entity.getPersistentData().getDouble("timer") == 16) {
			entity.getPersistentData().putDouble("aframe", 9);
		}
		if (entity.getPersistentData().getDouble("timer") == 18) {
			entity.getPersistentData().putDouble("aframe", 10);
		}
		if (entity.getPersistentData().getDouble("timer") == 20) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:onemindfx entity @s 0 0 0");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/onemindfx entity @s 0 0 0");
			}
		}
	}
}
