
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.NightJarGUIMenu;
import net.mcreator.wardencurse.procedures.Ichiset7Procedure;
import net.mcreator.wardencurse.procedures.Ichiset6Procedure;
import net.mcreator.wardencurse.procedures.Ichiset5Procedure;
import net.mcreator.wardencurse.procedures.Ichiset4Procedure;
import net.mcreator.wardencurse.procedures.Ichiset3Procedure;
import net.mcreator.wardencurse.procedures.Ichiset2Procedure;
import net.mcreator.wardencurse.procedures.Ichiset1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NightJarGUIButtonMessage {
	private final int buttonID, x, y, z;

	public NightJarGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public NightJarGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(NightJarGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(NightJarGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = NightJarGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Ichiset1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Ichiset2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Ichiset3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Ichiset4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Ichiset5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Ichiset6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Ichiset7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(NightJarGUIButtonMessage.class, NightJarGUIButtonMessage::buffer, NightJarGUIButtonMessage::new, NightJarGUIButtonMessage::handler);
	}
}
