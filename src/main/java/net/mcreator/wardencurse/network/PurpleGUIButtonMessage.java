
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.PurpleGUIMenu;
import net.mcreator.wardencurse.procedures.Purple7Procedure;
import net.mcreator.wardencurse.procedures.Purple6Procedure;
import net.mcreator.wardencurse.procedures.Purple5Procedure;
import net.mcreator.wardencurse.procedures.Purple4Procedure;
import net.mcreator.wardencurse.procedures.Purple3Procedure;
import net.mcreator.wardencurse.procedures.Purple2Procedure;
import net.mcreator.wardencurse.procedures.Purple1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurpleGUIButtonMessage {
	private final int buttonID, x, y, z;

	public PurpleGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PurpleGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PurpleGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PurpleGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PurpleGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Purple1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Purple2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Purple3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Purple4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Purple5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Purple6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Purple7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(PurpleGUIButtonMessage.class, PurpleGUIButtonMessage::buffer, PurpleGUIButtonMessage::new, PurpleGUIButtonMessage::handler);
	}
}
