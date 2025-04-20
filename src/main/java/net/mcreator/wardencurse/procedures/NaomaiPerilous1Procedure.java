package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class NaomaiPerilous1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("pr_1_timer", (entity.getPersistentData().getDouble("pr_1_timer") + 1));
		if (entity.getPersistentData().getDouble("pr_1_timer") == 1) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 8);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:perilous player @a ~ ~ ~");
				}
			}
			entity.getPersistentData().putBoolean("Entity_IV_Shuriken", true);
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("pr_1_timer") == 20) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				PerilousswipeProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("pr_1_timer") == 30) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 6);
			entity.getPersistentData().putBoolean("Entity_IV_Shuriken", false);
			entity.getPersistentData().putBoolean("Perilous_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("pr_1_timer", 0);
		}
	}
}
