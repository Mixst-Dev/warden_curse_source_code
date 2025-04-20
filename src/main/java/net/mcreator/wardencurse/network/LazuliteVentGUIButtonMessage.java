
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.LazuliteVentGUIMenu;
import net.mcreator.wardencurse.procedures.SetLaz7Procedure;
import net.mcreator.wardencurse.procedures.SetLaz6Procedure;
import net.mcreator.wardencurse.procedures.SetLaz5Procedure;
import net.mcreator.wardencurse.procedures.SetLaz4Procedure;
import net.mcreator.wardencurse.procedures.SetLaz3Procedure;
import net.mcreator.wardencurse.procedures.SetLaz2Procedure;
import net.mcreator.wardencurse.procedures.SetLaz1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LazuliteVentGUIButtonMessage {
	private final int buttonID, x, y, z;

	public LazuliteVentGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public LazuliteVentGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(LazuliteVentGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(LazuliteVentGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = LazuliteVentGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetLaz1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetLaz2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SetLaz3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetLaz4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SetLaz5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SetLaz6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetLaz7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(LazuliteVentGUIButtonMessage.class, LazuliteVentGUIButtonMessage::buffer, LazuliteVentGUIButtonMessage::new, LazuliteVentGUIButtonMessage::handler);
	}
}
