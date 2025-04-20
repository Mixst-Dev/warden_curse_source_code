package net.mcreator.wardencurse.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.entity.AshinaSpearEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AshinaSpearGuardingPropertiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		execute(null, world, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		if (entity instanceof AshinaSpearEntity) {
			if (amount > 4 && !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
				HurtVFXProcedure.execute(world, entity);
				entity.getPersistentData().putDouble("entity_posture", (entity.getPersistentData().getDouble("entity_posture") + amount * 4));
				entity.getPersistentData().putDouble("Lock_Yaw", 0);
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			} else if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("warden_curse:firecracker")))) {
				entity.getPersistentData().putBoolean("Entity_On_Battle", false);
			}
		}
	}
}
