package net.mcreator.wardencurse;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.player.Input;

import net.mcreator.wardencurse.init.WardenCurseModMobEffects;

@Mod.EventBusSubscriber(modid = "warden_curse", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Nmp {
	@SubscribeEvent
	public static void onMovementInputUpdate(MovementInputUpdateEvent event) {
		Player player = event.getEntity();
		Input input = event.getInput();
		if (player.hasEffect(WardenCurseModMobEffects.NO_MOVE.get())) {
			input.leftImpulse = 0.0F;
			input.forwardImpulse = 0.0F;
			input.up = false;
			input.down = false;
		}
	}
}
