
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.Sakuradancegui2Menu;
import net.mcreator.wardencurse.procedures.Sakuraset7Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset6Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset5Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset4Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset3Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset2Procedure;
import net.mcreator.wardencurse.procedures.Sakuraset1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Sakuradancegui2ButtonMessage {
	private final int buttonID, x, y, z;

	public Sakuradancegui2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Sakuradancegui2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Sakuradancegui2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Sakuradancegui2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = Sakuradancegui2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Sakuraset1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Sakuraset2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Sakuraset3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Sakuraset4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Sakuraset5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Sakuraset6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Sakuraset7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(Sakuradancegui2ButtonMessage.class, Sakuradancegui2ButtonMessage::buffer, Sakuradancegui2ButtonMessage::new, Sakuradancegui2ButtonMessage::handler);
	}
}
