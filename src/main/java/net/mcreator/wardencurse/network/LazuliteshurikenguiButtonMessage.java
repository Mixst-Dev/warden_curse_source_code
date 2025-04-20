
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.LazuliteshurikenguiMenu;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset7Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset6Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset5Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset4Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset3Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset2Procedure;
import net.mcreator.wardencurse.procedures.Lazuliteshurikenset1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LazuliteshurikenguiButtonMessage {
	private final int buttonID, x, y, z;

	public LazuliteshurikenguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public LazuliteshurikenguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(LazuliteshurikenguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(LazuliteshurikenguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = LazuliteshurikenguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Lazuliteshurikenset1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			Lazuliteshurikenset2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			Lazuliteshurikenset3Procedure.execute(entity);
		}
		if (buttonID == 3) {

			Lazuliteshurikenset4Procedure.execute(entity);
		}
		if (buttonID == 4) {

			Lazuliteshurikenset5Procedure.execute(entity);
		}
		if (buttonID == 5) {

			Lazuliteshurikenset6Procedure.execute(entity);
		}
		if (buttonID == 6) {

			Lazuliteshurikenset7Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(LazuliteshurikenguiButtonMessage.class, LazuliteshurikenguiButtonMessage::buffer, LazuliteshurikenguiButtonMessage::new, LazuliteshurikenguiButtonMessage::handler);
	}
}
