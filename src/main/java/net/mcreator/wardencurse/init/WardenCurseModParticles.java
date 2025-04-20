
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.wardencurse.client.particle.SparkParticle;
import net.mcreator.wardencurse.client.particle.SmokecircleParticle;
import net.mcreator.wardencurse.client.particle.DarksmokeParticle;
import net.mcreator.wardencurse.client.particle.Blood1Particle;
import net.mcreator.wardencurse.client.particle.AshinaMountainParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WardenCurseModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(WardenCurseModParticleTypes.SPARK.get(), SparkParticle::provider);
		event.registerSpriteSet(WardenCurseModParticleTypes.BLOOD_1.get(), Blood1Particle::provider);
		event.registerSpriteSet(WardenCurseModParticleTypes.DARKSMOKE.get(), DarksmokeParticle::provider);
		event.registerSpriteSet(WardenCurseModParticleTypes.SMOKECIRCLE.get(), SmokecircleParticle::provider);
		event.registerSpriteSet(WardenCurseModParticleTypes.ASHINA_MOUNTAIN.get(), AshinaMountainParticle::provider);
	}
}
