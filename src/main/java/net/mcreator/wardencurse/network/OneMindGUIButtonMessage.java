
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.OneMindGUIMenu;
import net.mcreator.wardencurse.procedures.OneMindi2Procedure;
import net.mcreator.wardencurse.procedures.OneMind7Procedure;
import net.mcreator.wardencurse.procedures.OneMind6Procedure;
import net.mcreator.wardencurse.procedures.OneMind5Procedure;
import net.mcreator.wardencurse.procedures.OneMind4Procedure;
import net.mcreator.wardencurse.procedures.OneMind3Procedure;
import net.mcreator.wardencurse.procedures.OneMind1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OneMindGUIButtonMessage {
	private final int buttonID, x, y, z;

	public OneMindGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public OneMindGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(OneMindGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(OneMindGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = OneMindGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OneMind1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OneMindi2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OneMind3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OneMind4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OneMind5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OneMind6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OneMind7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(OneMindGUIButtonMessage.class, OneMindGUIButtonMessage::buffer, OneMindGUIButtonMessage::new, OneMindGUIButtonMessage::handler);
	}
}
