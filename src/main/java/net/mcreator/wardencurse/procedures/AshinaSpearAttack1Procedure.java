package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AshinaSpearAttack1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("akt1_timer", (entity.getPersistentData().getDouble("akt1_timer") + 1));
		if (entity.getPersistentData().getDouble("akt1_timer") == 1) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 5) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:metal_shing player @a ~ ~ ~ 0.8");
				}
			}
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 17) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				DmgtestEntitySwingsItemProcedure.execute(world, entity);
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 0.2), 0, (entity.getDeltaMovement().z() + entity.getLookAngle().z * 0.2)));
			}
		}
		if (entity.getPersistentData().getDouble("akt1_timer") == 30) {
			entity.getPersistentData().putBoolean("Attack_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
		}
	}
}
