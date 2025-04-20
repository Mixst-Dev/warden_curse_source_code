package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DisableemblemsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).regen_emblem == true
				&& amount >= WardenCurseModVariables.MapVariables.get(world).Config_Dmg_Cancel_Requirement) {
			{
				boolean _setval = false;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.regen_emblem = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = false;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.emblem_increase = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.regen_emblem_process = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cDenied!"), false);
		}
	}
}
