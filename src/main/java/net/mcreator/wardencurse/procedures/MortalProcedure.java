package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MortalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:mortaldraw player @a ~ ~ ~ 0.7");
				}
			}
		}
		if (entity.getPersistentData().getDouble("timer") == 17) {
			MortaltestsEntitySwingsItemProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("timer") == 36) {
			Mortalswing2Procedure.execute(world, y, entity);
		}
		if (entity.getPersistentData().getDouble("timer") == 56) {
			SecretEntitySwingsItemProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getPersistentData().getDouble("timer") > 90) {
			entity.getPersistentData().putDouble("timer", 0);
		}
	}
}
