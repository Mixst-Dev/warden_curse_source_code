package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

import java.util.List;
import java.util.Comparator;

public class PMSonTICKProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get())) {
			entity.getPersistentData().putDouble("posturetimer", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 800) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 50, 1));
			}
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 50) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				{
					double _setval = 800;
					(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.max_entity_posture = _setval;
						capability.syncPlayerVariables((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null));
					});
				}
				{
					double _setval = entity.getPersistentData().getDouble("entity_posture");
					(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.entity_posture = _setval;
						capability.syncPlayerVariables((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null));
					});
				}
			}
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putBoolean("Sekiro_Entity_On_Battle", true);
		} else {
			entity.getPersistentData().putBoolean("Sekiro_Entity_On_Battle", false);
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if (entity.getPersistentData().getDouble("attacktimer") < 0) {
			entity.getPersistentData().putDouble("attacktimer", 0);
		}
		if (entity.getPersistentData().getBoolean("phase2") == true) {
			PMSdeathblow1Procedure.execute(world, x, y, z, entity);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Posture: 800/" + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("entity_posture")))), true);
				}
			}
		}
	}
}
