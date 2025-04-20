
package net.mcreator.wardencurse.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.wardencurse.world.inventory.SparkingAxeCraftingMenu;
import net.mcreator.wardencurse.procedures.OpenPurpleFumeProcedure;
import net.mcreator.wardencurse.procedures.OpenLongsparkProcedure;
import net.mcreator.wardencurse.procedures.OpenLoadedSpearCrafterProcedure;
import net.mcreator.wardencurse.procedures.OpenLoadedAxeCrafterProcedure;
import net.mcreator.wardencurse.procedures.OpenLeapingFlameProcedure;
import net.mcreator.wardencurse.procedures.OpenLazuliteCraftingProcedure;
import net.mcreator.wardencurse.procedures.OpenFlameVentProcedure;
import net.mcreator.wardencurse.procedures.OpenFirecrackerProcedure;
import net.mcreator.wardencurse.procedures.CraftSparkingAxeProcedure;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SparkingAxeCraftingButtonMessage {
	private final int buttonID, x, y, z;

	public SparkingAxeCraftingButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SparkingAxeCraftingButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SparkingAxeCraftingButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SparkingAxeCraftingButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = SparkingAxeCraftingMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenFirecrackerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenLongsparkProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenPurpleFumeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenFlameVentProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			OpenLazuliteCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			OpenLoadedSpearCrafterProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			OpenLeapingFlameProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			OpenLoadedAxeCrafterProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			CraftSparkingAxeProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(SparkingAxeCraftingButtonMessage.class, SparkingAxeCraftingButtonMessage::buffer, SparkingAxeCraftingButtonMessage::new, SparkingAxeCraftingButtonMessage::handler);
	}
}
