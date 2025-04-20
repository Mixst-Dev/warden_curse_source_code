
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.LoadedAxeGUIMenu;
import net.mcreator.wardencurse.procedures.SetLA7Procedure;
import net.mcreator.wardencurse.procedures.SetLA6Procedure;
import net.mcreator.wardencurse.procedures.SetLA5Procedure;
import net.mcreator.wardencurse.procedures.SetLA4Procedure;
import net.mcreator.wardencurse.procedures.SetLA3Procedure;
import net.mcreator.wardencurse.procedures.SetLA2Procedure;
import net.mcreator.wardencurse.procedures.SetLA1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LoadedAxeGUIButtonMessage {
	private final int buttonID, x, y, z;

	public LoadedAxeGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public LoadedAxeGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(LoadedAxeGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(LoadedAxeGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = LoadedAxeGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetLA1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetLA2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SetLA3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetLA4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SetLA5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SetLA6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetLA7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(LoadedAxeGUIButtonMessage.class, LoadedAxeGUIButtonMessage::buffer, LoadedAxeGUIButtonMessage::new, LoadedAxeGUIButtonMessage::handler);
	}
}
