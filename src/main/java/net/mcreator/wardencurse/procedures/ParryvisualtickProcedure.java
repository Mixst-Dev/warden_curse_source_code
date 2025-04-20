package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ParryvisualtickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:parry2 entity @s 0 0 0");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/parry2 entity @s 0 0 0");
			}
		}
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		if (entity.getPersistentData().getDouble("time") == 1) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.LIGHT.defaultBlockState(), 3);
			}
		}
		if (entity.getPersistentData().getDouble("time") == 3) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if (entity.getPersistentData().getDouble("time") > 3) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
	}
}
