package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.init.WardenCurseModItems;

public class Callart6Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double pitch = 0;
		double zcord = 0;
		double yaw = 0;
		double xcord = 0;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).sekirotoggle == true) {
			yaw = (entity.getYRot() + 90) * (Math.PI / 180);
			pitch = entity.getXRot() * (Math.PI / 180);
			ycord = Math.sqrt(Math.pow(Math.cos(yaw) * Math.cos(pitch), 2) + Math.pow(Math.sin(pitch), 2) + Math.pow(Math.sin(yaw) * Math.cos(pitch), 2));
			xcord = entity.getX();
			ycord = entity.getY();
			zcord = entity.getZ();
			if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get()))
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).mortalbladearts == 6
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).guardtrigger == false
						&& (entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).dashtrigger == false) {
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.SHADOWRUSHSKILL.get()) {
						ShadowrushstoreProcedure.execute(world, x, y, z, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.SAKURADANCESKILL.get()) {
						SakuradancestoreProcedure.execute(world, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.ASHINACROSSKSILL.get()) {
						AshinacrosstoreProcedure.execute(world, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.SPIRALCLOUDPASSAGESKILL.get()) {
						SpiralstoreProcedure.execute(entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.DRAGONFLASHSKILL.get()) {
						DragonflashstoreProcedure.execute(world, y, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.MORTALDRAWSKILL.get()) {
						MortaldrawstoreProcedure.execute(world, x, y, z, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.WHIRLWINDSLASHSKILL.get()) {
						WhirlwindSlashStoreProcedure.execute(world, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.ONEMINDSKILL.get()) {
						OnemindtestRightclickedProcedure.execute(world, entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.FLOATING_PASSAGE.get()) {
						FloatingPassageStoreProcedure.execute(entity);
					}
					if (((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).artslot6).getItem() == WardenCurseModItems.ICHIMONJI.get()) {
						IchimojiStoreProcedure.execute(entity);
					}
				}
			}
		}
	}
}
