package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModItems;

public class Callprostheteic5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LOADED_AXE_ITEM.get()) {
			LoadedAxeTriggerProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.PURPLEFUME.get()) {
			PurpleFumeProcCallProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LONGSPARK.get()) {
			LongSparkTriggerProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.SHINOBIFIRECRACKER.get()) {
			ShinobifirecrackerRightclickedProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LAZULITEAXEICON.get()) {
			LazuliteaxeRightclickedProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.SPARKINGAHHAXZE.get()) {
			SparkingaxerightclickedProcedure.execute(entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LOADEDSPEARICON.get()) {
			SpearRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LEAPINGFLAME.get()) {
			FirespearrightclickedProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.FIREVENT_1.get()) {
			FireVentUSEProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LAZULITEVENT.get()) {
			LazuliteVentUSEProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.CURSEDVENT_1.get()) {
			CursedVentUSEProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.SHURIKENSKILL.get()) {
			ThrowshruikenProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.LAZULITESHURIKENSKILL.get()) {
			ThrowlauzliteshurikenProcedure.execute(world, entity);
		}
		if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).proslot5).getItem() == WardenCurseModItems.AGEDMISTRAVENITEM.get()) {
			MistRavenUseProcedure.execute(world, entity);
		}
	}
}
