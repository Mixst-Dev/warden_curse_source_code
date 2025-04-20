package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class SparkingaxerightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).using_elbem
					+ (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).ceremol_emblem >= 2) {
				if (entity.getPersistentData().getBoolean("Prosthetic_Retract _Request") == false) {
					if (!entity.isShiftKeyDown()) {
						entity.getPersistentData().putBoolean("S_Axe_Slam", true);
					} else {
						entity.getPersistentData().putBoolean("S_Axe_SWIPE", true);
					}
				} else {
					entity.getPersistentData().putBoolean("Prosthetic_Retract _Request", false);
					if (entity.getPersistentData().getBoolean("S_Axe_Extension") == false) {
						entity.getPersistentData().putBoolean("S_Axe_Extension", true);
						entity.getPersistentData().putBoolean("S_Axe_SWIPE", false);
					} else {
						entity.getPersistentData().putDouble("S_Axe_Extension_timer", 0);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Insufficient Emblems"), true);
			}
		} else if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (entity.getPersistentData().getBoolean("Prosthetic_Retract _Request") == false) {
				if (!entity.isShiftKeyDown()) {
					entity.getPersistentData().putBoolean("S_Axe_Slam", true);
				} else {
					entity.getPersistentData().putBoolean("S_Axe_SWIPE", true);
				}
			} else {
				entity.getPersistentData().putBoolean("Prosthetic_Retract _Request", false);
				if (entity.getPersistentData().getBoolean("S_Axe_Extension") == false) {
					entity.getPersistentData().putBoolean("S_Axe_Extension", true);
					entity.getPersistentData().putBoolean("S_Axe_SWIPE", false);
				} else {
					entity.getPersistentData().putDouble("S_Axe_Extension_timer", 0);
				}
			}
		}
	}
}
