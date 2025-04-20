
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.EmblemConfigGUIMenu;
import net.mcreator.wardencurse.procedures.EmblemLimitResetProcedure;
import net.mcreator.wardencurse.procedures.ConfigSpiritMinus1Procedure;
import net.mcreator.wardencurse.procedures.ConfigSpiritMinus10Procedure;
import net.mcreator.wardencurse.procedures.ConfigSpiritAdd1Procedure;
import net.mcreator.wardencurse.procedures.ConfigSpiritAdd10Procedure;
import net.mcreator.wardencurse.procedures.BackpressProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EmblemConfigGUIButtonMessage {
	private final int buttonID, x, y, z;

	public EmblemConfigGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EmblemConfigGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EmblemConfigGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EmblemConfigGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EmblemConfigGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EmblemLimitResetProcedure.execute(world);
		}
		if (buttonID == 1) {

			ConfigSpiritMinus1Procedure.execute(world);
		}
		if (buttonID == 2) {

			ConfigSpiritAdd1Procedure.execute(world);
		}
		if (buttonID == 3) {

			ConfigSpiritAdd10Procedure.execute(world);
		}
		if (buttonID == 4) {

			ConfigSpiritMinus10Procedure.execute(world);
		}
		if (buttonID == 5) {

			BackpressProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(EmblemConfigGUIButtonMessage.class, EmblemConfigGUIButtonMessage::buffer, EmblemConfigGUIButtonMessage::new, EmblemConfigGUIButtonMessage::handler);
	}
}
