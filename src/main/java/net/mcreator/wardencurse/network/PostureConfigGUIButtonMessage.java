
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.PostureConfigGUIMenu;
import net.mcreator.wardencurse.procedures.PostureResetProcedure;
import net.mcreator.wardencurse.procedures.PostureOffProcedure;
import net.mcreator.wardencurse.procedures.PostureONProcedure;
import net.mcreator.wardencurse.procedures.ConfigPosturePlus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigPosturePlus10Procedure;
import net.mcreator.wardencurse.procedures.ConfigPostureMinus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigPostureMinus10Procedure;
import net.mcreator.wardencurse.procedures.BackpressProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PostureConfigGUIButtonMessage {
	private final int buttonID, x, y, z;

	public PostureConfigGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PostureConfigGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PostureConfigGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PostureConfigGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PostureConfigGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PostureResetProcedure.execute(world);
		}
		if (buttonID == 1) {

			ConfigPostureMinus1Procedure.execute(world);
		}
		if (buttonID == 2) {

			ConfigPosturePlus1Procedure.execute(world);
		}
		if (buttonID == 3) {

			ConfigPosturePlus10Procedure.execute(world);
		}
		if (buttonID == 4) {

			ConfigPostureMinus10Procedure.execute(world);
		}
		if (buttonID == 5) {

			PostureONProcedure.execute(world);
		}
		if (buttonID == 6) {

			PostureOffProcedure.execute(world);
		}
		if (buttonID == 7) {

			BackpressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(PostureConfigGUIButtonMessage.class, PostureConfigGUIButtonMessage::buffer, PostureConfigGUIButtonMessage::new, PostureConfigGUIButtonMessage::handler);
	}
}
