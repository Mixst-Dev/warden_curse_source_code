package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.entity.SculkSoldier1Entity;

public class SculkAttack1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("akt1_timer", (entity.getPersistentData().getDouble("akt1_timer") + 1));
		if (entity.getPersistentData().getDouble("akt1_timer") == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:guarding_cloth player @a ~ ~ ~");
				}
			}
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			if (entity instanceof SculkSoldier1Entity) {
				((SculkSoldier1Entity) entity).setAnimation("attack1");
			}
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 12) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				Whirl1Procedure.execute(world, entity);
				EntityWhirlWindDamageProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 22) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				Whirl2Procedure.execute(world, entity);
				EntityWhirlWindDamageProcedure.execute(world, entity);
			}
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 30) {
			entity.getPersistentData().putBoolean("Attack_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("atk1_timer", 0);
		}
	}
}
