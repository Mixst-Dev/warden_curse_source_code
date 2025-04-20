package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Ashinacross2Entity;

public class Ashinacross2OnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - entity.getDeltaMovement().z())));
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 0) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina1");
		}
		if (entity.getPersistentData().getDouble("timer") == 1) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina2");
		}
		if (entity.getPersistentData().getDouble("timer") == 3) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina3");
		}
		if (entity.getPersistentData().getDouble("timer") == 5) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina4");
		}
		if (entity.getPersistentData().getDouble("timer") == 6) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina5");
		}
		if (entity.getPersistentData().getDouble("timer") == 9) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina6");
		}
		if (entity.getPersistentData().getDouble("timer") == 11) {
			if (entity instanceof Ashinacross2Entity animatable)
				animatable.setTexture("newshina7");
		}
		if (entity.getPersistentData().getDouble("timer") == 13) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
