
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.CombatArtConfigMenu;
import net.mcreator.wardencurse.procedures.ResetartProcedure;
import net.mcreator.wardencurse.procedures.ConfigArtPlus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigArtPlus01Procedure;
import net.mcreator.wardencurse.procedures.ConfigArtMinus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigArtMinus01Procedure;
import net.mcreator.wardencurse.procedures.BackpressProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CombatArtConfigButtonMessage {
	private final int buttonID, x, y, z;

	public CombatArtConfigButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CombatArtConfigButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CombatArtConfigButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CombatArtConfigButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CombatArtConfigMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ResetartProcedure.execute(world);
		}
		if (buttonID == 1) {

			ConfigArtMinus1Procedure.execute(world);
		}
		if (buttonID == 2) {

			ConfigArtMinus01Procedure.execute(world);
		}
		if (buttonID == 3) {

			ConfigArtPlus1Procedure.execute(world);
		}
		if (buttonID == 4) {

			ConfigArtPlus01Procedure.execute(world);
		}
		if (buttonID == 5) {

			BackpressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(CombatArtConfigButtonMessage.class, CombatArtConfigButtonMessage::buffer, CombatArtConfigButtonMessage::new, CombatArtConfigButtonMessage::handler);
	}
}
