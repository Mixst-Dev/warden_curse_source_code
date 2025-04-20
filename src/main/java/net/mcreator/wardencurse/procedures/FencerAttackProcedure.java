package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.FencerEntity;
import net.mcreator.wardencurse.entity.AshinaSpearEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FencerAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof FencerEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (sourceentity.getPersistentData().getDouble("attacktimer") <= 0 && (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(WardenCurseModMobEffects.STUNNED.get()))
					|| !(sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(WardenCurseModMobEffects.DEATHBLOW.get())))) {
				if (sourceentity instanceof AshinaSpearEntity) {
					((AshinaSpearEntity) sourceentity).setAnimation("attack3");
				}
				if (sourceentity instanceof FencerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FencerEntity.DATA_Attack_3, true);
				sourceentity.getPersistentData().putBoolean("Entity_On_Battle", true);
			}
		}
	}
}
