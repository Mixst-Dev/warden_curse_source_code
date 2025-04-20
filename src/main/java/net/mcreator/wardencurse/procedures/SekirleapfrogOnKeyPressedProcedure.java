package net.mcreator.wardencurse.procedures;

import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.wardencurse.network.WardenCurseModVariables;
import net.mcreator.wardencurse.init.WardenCurseModMobEffects;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class SekirleapfrogOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ycord = 0;
		double rotation = 0;
		double mypitch = 0;
		double yaw = 0;
		double vent_power = 0;
		double sugar_power = 0;
		double z2 = 0;
		double x2 = 0;
		double magnitude = 0;
		double myyaw = 0;
		double pitch = 0;
		double zcord = 0;
		double sugar_ako = 0;
		double xcord = 0;
		if (!entity.onGround()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(WardenCurseModMobEffects.ATTACKCOOLDOWN.get())) && (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, (y - 2), z), 2, 2, 2), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(AbstractGolem.class, AABB.ofSize(new Vec3(x, (y - 2), z), 2, 2, 2), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(SpellcasterIllager.class, AABB.ofSize(new Vec3(x, (y - 2), z), 2, 2, 2), e -> true).isEmpty() || !world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(x, (y - 2), z), 2, 2, 2), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, (y - 2), z), 2, 2, 2), e -> true).isEmpty())) {
				if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(WardenCurseModMobEffects.AKOSSUGAR.get())) {
					sugar_power = 1.125;
				} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(WardenCurseModMobEffects.YASHARIKU.get())) {
					sugar_power = 1.25;
				} else {
					sugar_power = 1;
				}
				if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(WardenCurseModMobEffects.FIRESTATE.get())) {
					vent_power = 1.15;
				} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(WardenCurseModMobEffects.BLUEFIRESTATE.get())) {
					vent_power = 1.25;
				} else if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(WardenCurseModMobEffects.CURSEDFIRESTATE.get())) {
					vent_power = 1.32;
				} else {
					vent_power = 1;
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PROSTHETICCOOLDOWN.get(), 2, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.ATTACKCOOLDOWN.get(), 10, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.TECHNIQUECOOLDOWN.get(), 2, 1, false, false));
				{
					final Vec3 _center = new Vec3(x, (y - 2), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator instanceof ItemEntity)
								&& !(entityiterator instanceof NashinaEntity) && !(entityiterator instanceof NashinacurseEntity) && !(entityiterator instanceof NashinafireEntity) && !(entityiterator instanceof NashinalazuliteEntity)
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("warden:visual")))
								&& (entityiterator == ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(AbstractGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(SpellcasterIllager.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) || entityiterator == ((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)))) {
							if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
										(float) (WardenCurseModVariables.MapVariables.get(world).config_combat_power * 0.125 * vent_power * sugar_power));
							}
							if (!(entityiterator instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(
									WardenCurseModMobEffects.PARRY.get())) == ((entity.getCapability(WardenCurseModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WardenCurseModVariables.PlayerVariables())).activeguarded == false)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.STUNNED.get(), 5, 1, false, false));
							}
							if (entityiterator instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(WardenCurseModMobEffects.PARRY.get())
									&& !(entityiterator instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(WardenCurseModMobEffects.STUNNED.get()))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(WardenCurseModMobEffects.PARRYVISUAL.get(), 10, 1, false, false));
							}
							entity.hurtMarked = true;
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * (-1)), 0.5, (entity.getDeltaMovement().z() + entity.getLookAngle().z * (-1))));
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound warden_curse:blocking player @a ~ ~ ~ 0.7");
								}
							}
							if (world.isClientSide()) {
								if (entity instanceof AbstractClientPlayer player) {
									var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("warden_curse", "player_animation"));
									if (animation != null) {
										animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("warden_curse", "leapfrog"))));
									}
								}
							}
							if (!world.isClientSide()) {
								if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
									List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
									synchronized (connections) {
										Iterator<Connection> iterator = connections.iterator();
										while (iterator.hasNext()) {
											Connection connection = iterator.next();
											if (!connection.isConnecting() && connection.isConnected())
												WardenCurseMod.PACKET_HANDLER.sendTo(new StateanimationProcedure.WardenCurseModAnimationMessage(Component.literal("leapfrog"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
										}
									}
								}
							}
							WardenCurseMod.queueServerWork(10, () -> {
								if (world.isClientSide()) {
									if (entity instanceof AbstractClientPlayer player) {
										var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("warden_curse", "player_animation"));
										if (animation != null) {
											animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("warden_curse", "leapfrogend"))));
										}
									}
								}
								if (!world.isClientSide()) {
									if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
										List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
										synchronized (connections) {
											Iterator<Connection> iterator = connections.iterator();
											while (iterator.hasNext()) {
												Connection connection = iterator.next();
												if (!connection.isConnecting() && connection.isConnected())
													WardenCurseMod.PACKET_HANDLER.sendTo(new StateanimationProcedure.WardenCurseModAnimationMessage(Component.literal("leapfrogend"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
											}
										}
									}
								}
							});
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:leapfrog entity @s 0 1.5 0");
								}
							}
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "photon fx photon:assets/photon/fx/leapfrog entity @s 0 1.5 0");
								}
							}
						}
					}
				}
			}
		}
	}
}
