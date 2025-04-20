package net.mcreator.wardencurse.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.network.WardenCurseModVariables;

public class BulletProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), sourceentity), (float) (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.55));
		entity.getPersistentData().putDouble("ex_posture", (WardenCurseModVariables.MapVariables.get(world).config_prosthetic_power * 0.55 * 4));
		entity.invulnerableTime = 0;
	}
}
