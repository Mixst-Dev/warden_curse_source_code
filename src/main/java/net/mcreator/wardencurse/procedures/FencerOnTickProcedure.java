package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.FencerEntity;

public class FencerOnTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("entity_posture") < 0) {
			entity.getPersistentData().putDouble("entity_posture", 0);
		}
		if (entity.getPersistentData().getDouble("ex_posture") > 0) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + entity.getPersistentData().getDouble("ex_posture")));
			entity.getPersistentData().putDouble("ex_posture", 0);
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 190) {
			entity.getPersistentData().putDouble("entity_posture", 0);
			if (!(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.DEATHBLOW.get(), 50, 1));
				if (entity instanceof FencerEntity) {
					((FencerEntity) entity).setAnimation("empty");
				}
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			}
		}
		if (entity.getPersistentData().getDouble("entity_posture") > 0) {
			entity.getPersistentData().putDouble("posturetimer", (entity.getPersistentData().getDouble("posturetimer") + 1));
		}
		if (entity.getPersistentData().getDouble("posturetimer") == 100 && !(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(WardenCurseModMobEffects.POSTUREREGENERATIONDELAY.get()))) {
			entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.5 * 0.6));
			entity.getPersistentData().putDouble("posturetimer", 0);
		}
		if (entity.getPersistentData().getDouble("attacktimer") > 0) {
			entity.getPersistentData().putDouble("attacktimer", (entity.getPersistentData().getDouble("attacktimer") - 1));
		}
		if ((entity instanceof FencerEntity _datEntL25 && _datEntL25.getEntityData().get(FencerEntity.DATA_Attack_3)) == true) {
			FencerAttack3Procedure.execute(world, entity);
		} else {
			entity.getPersistentData().putDouble("atk3_timer", 0);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Attack Timer: " + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("atk3_timer")))), true);
		}
	}
}
