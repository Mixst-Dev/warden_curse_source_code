
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.SekiroguiMenu;
import net.mcreator.wardencurse.procedures.Select7Procedure;
import net.mcreator.wardencurse.procedures.Select6Procedure;
import net.mcreator.wardencurse.procedures.Select5Procedure;
import net.mcreator.wardencurse.procedures.Select4Procedure;
import net.mcreator.wardencurse.procedures.Select3Procedure;
import net.mcreator.wardencurse.procedures.Select2Procedure;
import net.mcreator.wardencurse.procedures.Select1Procedure;
import net.mcreator.wardencurse.procedures.CloseguiProcedure;
import net.mcreator.wardencurse.procedures.Clear9Procedure;
import net.mcreator.wardencurse.procedures.Clear8Procedure;
import net.mcreator.wardencurse.procedures.Clear7Procedure;
import net.mcreator.wardencurse.procedures.Clear6Procedure;
import net.mcreator.wardencurse.procedures.Clear5Procedure;
import net.mcreator.wardencurse.procedures.Clear4Procedure;
import net.mcreator.wardencurse.procedures.Clear3Procedure;
import net.mcreator.wardencurse.procedures.Clear2Procedure;
import net.mcreator.wardencurse.procedures.Clear1Procedure;
import net.mcreator.wardencurse.procedures.Clear14Procedure;
import net.mcreator.wardencurse.procedures.Clear13Procedure;
import net.mcreator.wardencurse.procedures.Clear12Procedure;
import net.mcreator.wardencurse.procedures.Clear11Procedure;
import net.mcreator.wardencurse.procedures.Clear10Procedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SekiroguiButtonMessage {
	private final int buttonID, x, y, z;

	public SekiroguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SekiroguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SekiroguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SekiroguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = SekiroguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 1) {

			Clear1Procedure.execute(entity);
		}
		if (buttonID == 2) {

			Clear2Procedure.execute(entity);
		}
		if (buttonID == 3) {

			Clear3Procedure.execute(entity);
		}
		if (buttonID == 4) {

			Clear4Procedure.execute(entity);
		}
		if (buttonID == 5) {

			Clear5Procedure.execute(entity);
		}
		if (buttonID == 6) {

			Clear6Procedure.execute(entity);
		}
		if (buttonID == 7) {

			Clear7Procedure.execute(entity);
		}
		if (buttonID == 8) {

			Clear8Procedure.execute(entity);
		}
		if (buttonID == 9) {

			Clear9Procedure.execute(entity);
		}
		if (buttonID == 10) {

			Clear10Procedure.execute(entity);
		}
		if (buttonID == 11) {

			Clear11Procedure.execute(entity);
		}
		if (buttonID == 12) {

			Clear12Procedure.execute(entity);
		}
		if (buttonID == 13) {

			Clear13Procedure.execute(entity);
		}
		if (buttonID == 14) {

			Clear14Procedure.execute(entity);
		}
		if (buttonID == 15) {

			Select1Procedure.execute(entity);
		}
		if (buttonID == 16) {

			Select2Procedure.execute(entity);
		}
		if (buttonID == 17) {

			Select3Procedure.execute(entity);
		}
		if (buttonID == 18) {

			Select4Procedure.execute(entity);
		}
		if (buttonID == 19) {

			Select5Procedure.execute(entity);
		}
		if (buttonID == 20) {

			Select6Procedure.execute(entity);
		}
		if (buttonID == 21) {

			Select7Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(SekiroguiButtonMessage.class, SekiroguiButtonMessage::buffer, SekiroguiButtonMessage::new, SekiroguiButtonMessage::handler);
	}
}
