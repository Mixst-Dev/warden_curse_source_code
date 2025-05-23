package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PosturelimitProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).posturedmg >= 300) {
			{
				double _setval = 300;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.posturedmg = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.posturelimit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.posturelimit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
