
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.GameplayConfigMenu;
import net.mcreator.wardencurse.procedures.VanillaPvpONProcedure;
import net.mcreator.wardencurse.procedures.VanillaPvpOFFProcedure;
import net.mcreator.wardencurse.procedures.VanillaFireONProcedure;
import net.mcreator.wardencurse.procedures.VanillaFireOFFProcedure;
import net.mcreator.wardencurse.procedures.CancelRequirementresetProcedure;
import net.mcreator.wardencurse.procedures.CRDplus1Procedure;
import net.mcreator.wardencurse.procedures.CRDplus01Procedure;
import net.mcreator.wardencurse.procedures.CRDonProcedure;
import net.mcreator.wardencurse.procedures.CRDoffProcedure;
import net.mcreator.wardencurse.procedures.CRDminus1Procedure;
import net.mcreator.wardencurse.procedures.CRDminus01Procedure;
import net.mcreator.wardencurse.procedures.BackpressProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GameplayConfigButtonMessage {
	private final int buttonID, x, y, z;

	public GameplayConfigButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GameplayConfigButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GameplayConfigButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GameplayConfigButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = GameplayConfigMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CancelRequirementresetProcedure.execute(world);
		}
		if (buttonID == 1) {

			CRDonProcedure.execute(world);
		}
		if (buttonID == 2) {

			CRDoffProcedure.execute(world);
		}
		if (buttonID == 3) {

			BackpressProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			CRDplus1Procedure.execute(world);
		}
		if (buttonID == 5) {

			CRDplus01Procedure.execute(world);
		}
		if (buttonID == 6) {

			CRDminus1Procedure.execute(world);
		}
		if (buttonID == 7) {

			CRDminus01Procedure.execute(world);
		}
		if (buttonID == 8) {

			VanillaPvpONProcedure.execute(world);
		}
		if (buttonID == 9) {

			VanillaPvpOFFProcedure.execute(world);
		}
		if (buttonID == 10) {

			VanillaFireONProcedure.execute(world);
		}
		if (buttonID == 11) {

			VanillaFireOFFProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(GameplayConfigButtonMessage.class, GameplayConfigButtonMessage::buffer, GameplayConfigButtonMessage::new, GameplayConfigButtonMessage::handler);
	}
}
