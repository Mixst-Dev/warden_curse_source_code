
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.GlockGUIMenu;
import net.mcreator.wardencurse.procedures.SetGlock7Procedure;
import net.mcreator.wardencurse.procedures.SetGlock6Procedure;
import net.mcreator.wardencurse.procedures.SetGlock5Procedure;
import net.mcreator.wardencurse.procedures.SetGlock4Procedure;
import net.mcreator.wardencurse.procedures.SetGlock3Procedure;
import net.mcreator.wardencurse.procedures.SetGlock2Procedure;
import net.mcreator.wardencurse.procedures.SetGlock1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public GlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = GlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetGlock1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetGlock2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SetGlock3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetGlock4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SetGlock5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SetGlock6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetGlock7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(GlockGUIButtonMessage.class, GlockGUIButtonMessage::buffer, GlockGUIButtonMessage::new, GlockGUIButtonMessage::handler);
	}
}
