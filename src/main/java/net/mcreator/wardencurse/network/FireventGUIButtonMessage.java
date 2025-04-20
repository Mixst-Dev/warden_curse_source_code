
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.FireventGUIMenu;
import net.mcreator.wardencurse.procedures.SetFire7Procedure;
import net.mcreator.wardencurse.procedures.SetFire6Procedure;
import net.mcreator.wardencurse.procedures.SetFire5Procedure;
import net.mcreator.wardencurse.procedures.SetFire4Procedure;
import net.mcreator.wardencurse.procedures.SetFire3Procedure;
import net.mcreator.wardencurse.procedures.SetFire2Procedure;
import net.mcreator.wardencurse.procedures.SetFire1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FireventGUIButtonMessage {
	private final int buttonID, x, y, z;

	public FireventGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FireventGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FireventGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FireventGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FireventGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetFire1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetFire2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SetFire3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetFire4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SetFire5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SetFire6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetFire7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(FireventGUIButtonMessage.class, FireventGUIButtonMessage::buffer, FireventGUIButtonMessage::new, FireventGUIButtonMessage::handler);
	}
}
