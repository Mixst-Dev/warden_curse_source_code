package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class AutoParryOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("auto_parry") == true) {
			entity.getPersistentData().putBoolean("auto_parry", false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Auto Parry: OFF"), false);
		} else {
			entity.getPersistentData().putBoolean("auto_parry", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Auto Parry: ON"), false);
		}
	}
}
