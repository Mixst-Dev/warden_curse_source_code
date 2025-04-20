package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.entity.SpiralslashesEntity;

public class SpiralslashesOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:cloud entity @s 0 0 0");
				}
			}
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext1");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext2");
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext3");
		}
		if (entity.getPersistentData().getDouble("timer") == 7) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext4");
		}
		if (entity.getPersistentData().getDouble("timer") == 9) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext5");
		}
		if (entity.getPersistentData().getDouble("timer") == 11) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext6");
		}
		if (entity.getPersistentData().getDouble("timer") == 13) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext7");
		}
		if (entity.getPersistentData().getDouble("timer") == 15) {
			if (entity instanceof SpiralslashesEntity animatable)
				animatable.setTexture("spiraltext8");
		}
		if (entity.getPersistentData().getDouble("timer") == 17) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
