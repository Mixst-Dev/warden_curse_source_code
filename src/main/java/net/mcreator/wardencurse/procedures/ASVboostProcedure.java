package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class ASVboostProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity Target_Entity = null;
		double MotionZ = 0;
		double NormalizedX = 0;
		double NormalizedY = 0;
		double NormalizedZ = 0;
		double Magnitude = 0;
		double MotionY = 0;
		double MotionX = 0;
		MotionX = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX();
		MotionY = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY();
		MotionZ = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ();
		Magnitude = Math.sqrt(Math.pow(MotionX, 2) + Math.pow(MotionY, 2) + Math.pow(MotionZ, 2));
		NormalizedX = MotionX / Magnitude;
		NormalizedY = MotionY / Magnitude;
		NormalizedZ = MotionZ / Magnitude;
		entity.setDeltaMovement(new Vec3((NormalizedX * 1.5), 1.5, (NormalizedZ * 1.5)));
	}
}
