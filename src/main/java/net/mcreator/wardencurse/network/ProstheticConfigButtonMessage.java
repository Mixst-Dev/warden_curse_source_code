
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.ProstheticConfigMenu;
import net.mcreator.wardencurse.procedures.ResetprostheticProcedure;
import net.mcreator.wardencurse.procedures.ConfigPPlus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigPPlus01Procedure;
import net.mcreator.wardencurse.procedures.ConfigPMinus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigPMinus01Procedure;
import net.mcreator.wardencurse.procedures.BackpressProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProstheticConfigButtonMessage {
	private final int buttonID, x, y, z;

	public ProstheticConfigButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ProstheticConfigButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ProstheticConfigButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ProstheticConfigButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ProstheticConfigMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ResetprostheticProcedure.execute(world);
		}
		if (buttonID == 1) {

			ConfigPMinus1Procedure.execute(world);
		}
		if (buttonID == 2) {

			ConfigPMinus01Procedure.execute(world);
		}
		if (buttonID == 3) {

			ConfigPPlus1Procedure.execute(world);
		}
		if (buttonID == 4) {

			ConfigPPlus01Procedure.execute(world);
		}
		if (buttonID == 5) {

			BackpressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(ProstheticConfigButtonMessage.class, ProstheticConfigButtonMessage::buffer, ProstheticConfigButtonMessage::new, ProstheticConfigButtonMessage::handler);
	}
}
