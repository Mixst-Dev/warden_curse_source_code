package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class EntityPosturePercentageProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Entity Posture Percentage: " + (new java.text.DecimalFormat("##.##").format((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).max_entity_posture
				* ((100 / 30) / 100) * (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1))) + "%";
	}
}
