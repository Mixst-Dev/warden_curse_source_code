
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.FirecrackerGUIMenu;
import net.mcreator.wardencurse.procedures.SetFC7Procedure;
import net.mcreator.wardencurse.procedures.SetFC6Procedure;
import net.mcreator.wardencurse.procedures.SetFC5Procedure;
import net.mcreator.wardencurse.procedures.SetFC4Procedure;
import net.mcreator.wardencurse.procedures.SetFC3Procedure;
import net.mcreator.wardencurse.procedures.SetFC2Procedure;
import net.mcreator.wardencurse.procedures.SetFC1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirecrackerGUIButtonMessage {
	private final int buttonID, x, y, z;

	public FirecrackerGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FirecrackerGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FirecrackerGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FirecrackerGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FirecrackerGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetFC1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetFC2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SetFC3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetFC4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SetFC5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SetFC6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetFC7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(FirecrackerGUIButtonMessage.class, FirecrackerGUIButtonMessage::buffer, FirecrackerGUIButtonMessage::new, FirecrackerGUIButtonMessage::handler);
	}
}
