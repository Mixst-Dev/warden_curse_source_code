
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.ShadowrushguiMenu;
import net.mcreator.wardencurse.procedures.Shadowset7Procedure;
import net.mcreator.wardencurse.procedures.Shadowset6Procedure;
import net.mcreator.wardencurse.procedures.Shadowset5Procedure;
import net.mcreator.wardencurse.procedures.Shadowset4Procedure;
import net.mcreator.wardencurse.procedures.Shadowset3Procedure;
import net.mcreator.wardencurse.procedures.Shadowset2Procedure;
import net.mcreator.wardencurse.procedures.Shadowset1Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShadowrushguiButtonMessage {
	private final int buttonID, x, y, z;

	public ShadowrushguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ShadowrushguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ShadowrushguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ShadowrushguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ShadowrushguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Shadowset1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Shadowset2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Shadowset3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Shadowset4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Shadowset5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Shadowset6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Shadowset7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(ShadowrushguiButtonMessage.class, ShadowrushguiButtonMessage::buffer, ShadowrushguiButtonMessage::new, ShadowrushguiButtonMessage::handler);
	}
}
