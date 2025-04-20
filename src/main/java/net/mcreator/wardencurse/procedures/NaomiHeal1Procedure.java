package net.mcreator.wardencurse.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;

public class NaomiHeal1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("heal_1_timer", (entity.getPersistentData().getDouble("heal_1_timer") + 1));
		if (entity.getPersistentData().getDouble("heal_1_timer") == 1) {
			if (entity instanceof GeneralNaomiKawaradaEntity) {
				((GeneralNaomiKawaradaEntity) entity).setAnimation("heal");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 50, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 6, false, false));
			entity.getPersistentData().putBoolean("Entity_On_Battle", true);
			entity.getPersistentData().putDouble("Lock_Yaw", 1);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 3);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:posturereg entity @s 0 2 0");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/posturereg entity @s 0 2 0");
				}
			}
		}
		if (entity.getPersistentData().getDouble("heal_1_timer") == 35) {
			if (entity.getPersistentData().getBoolean("Entity_On_Battle") == true) {
				entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") - 150));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:posturereg2 entity @s 0 2 0");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/posturereg2 entity @s 0 2 0");
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("heal_1_timer") >= 50) {
			entity.getPersistentData().putDouble("Lock_Yaw", 0);
			entity.getPersistentData().putDouble("entity_flinch_requirement", 6);
			entity.getPersistentData().putBoolean("Heal_1", false);
			entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			entity.getPersistentData().putDouble("heal_1_timer", 0);
		}
	}
}
