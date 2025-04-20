
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.wardencurse.WardenCurseMod;

public class WardenCurseModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WardenCurseMod.MODID);
	public static final RegistryObject<SimpleParticleType> SPARK = REGISTRY.register("spark", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BLOOD_1 = REGISTRY.register("blood_1", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DARKSMOKE = REGISTRY.register("darksmoke", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SMOKECIRCLE = REGISTRY.register("smokecircle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ASHINA_MOUNTAIN = REGISTRY.register("ashina_mountain", () -> new SimpleParticleType(false));
}
