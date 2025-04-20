package net.mcreator.wardencurse.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

public class NaomiCounter2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("counter_2_timer", (entity.getPersistentData().getDouble("counter_2_timer") + 1));
		if (entity.getPersistentData().getDouble("counter_2_timer") == 1) {
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 7, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 25, 1, false, false));
		}
		if (entity.getPersistentData().getDouble("counter_2_timer") == 5) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:woosh5 player @a ~ ~ ~ 0.9");
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * (-1.3)), 0.25, (entity.getDeltaMovement().z() + entity.getLookAngle().z * (-1.3))));
			}
		}
		if (entity.getPersistentData().getDouble("counter_2_timer") >= 15) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.getPersistentData().putBoolean("Counter_2", false);
				if (entity.getPersistentData().getBoolean("Posture_Risk") == true) {
					if (Math.random() < 0.4) {
						if (entity instanceof GeneralNaomiKawaradaEntity) {
							((GeneralNaomiKawaradaEntity) entity).setAnimation("heal");
						}
						entity.getPersistentData().putBoolean("Heal_1", true);
					}
				}
			}
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("counter_2_timer", 0);
		}
	}
}
