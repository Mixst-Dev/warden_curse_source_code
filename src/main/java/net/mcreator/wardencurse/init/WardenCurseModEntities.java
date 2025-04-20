
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.entity.Whirlwindlazulite2Entity;
import net.mcreator.wardencurse.entity.Whirlwindlazulite1Entity;
import net.mcreator.wardencurse.entity.Whirlwindfire2Entity;
import net.mcreator.wardencurse.entity.Whirlwindfire1Entity;
import net.mcreator.wardencurse.entity.Whirlwindcursed2Entity;
import net.mcreator.wardencurse.entity.Whirlwindcursed1Entity;
import net.mcreator.wardencurse.entity.Whirlwind2Entity;
import net.mcreator.wardencurse.entity.Whirlwind1Entity;
import net.mcreator.wardencurse.entity.VentLEntity;
import net.mcreator.wardencurse.entity.VentFEntity;
import net.mcreator.wardencurse.entity.VentCEntity;
import net.mcreator.wardencurse.entity.StartsmokeentityEntity;
import net.mcreator.wardencurse.entity.StartPsmokeEntity;
import net.mcreator.wardencurse.entity.SpiritvisualEntity;
import net.mcreator.wardencurse.entity.SpiritelblemEntity;
import net.mcreator.wardencurse.entity.SpiralslashesEntity;
import net.mcreator.wardencurse.entity.SpiralcloudEntity;
import net.mcreator.wardencurse.entity.Spiral1Entity;
import net.mcreator.wardencurse.entity.SpinningShurikenEntity;
import net.mcreator.wardencurse.entity.SpinningLazuliteShurikenEntity;
import net.mcreator.wardencurse.entity.SpearswipeEntity;
import net.mcreator.wardencurse.entity.SparkingaxevisualEntity;
import net.mcreator.wardencurse.entity.SparkingAxeSwipeEntity;
import net.mcreator.wardencurse.entity.ShurikenvisualEntity;
import net.mcreator.wardencurse.entity.Shuriken1Entity;
import net.mcreator.wardencurse.entity.ShadowswipeEntity;
import net.mcreator.wardencurse.entity.ShadowspinEntity;
import net.mcreator.wardencurse.entity.ShadowslashEntity;
import net.mcreator.wardencurse.entity.SculkSoldier1Entity;
import net.mcreator.wardencurse.entity.SakuravisualEntity;
import net.mcreator.wardencurse.entity.Sakura3Entity;
import net.mcreator.wardencurse.entity.Sakura2Entity;
import net.mcreator.wardencurse.entity.Sakura1Entity;
import net.mcreator.wardencurse.entity.ProstheticreadyEntity;
import net.mcreator.wardencurse.entity.ProgressivesamuraiEntity;
import net.mcreator.wardencurse.entity.PnfcEntity;
import net.mcreator.wardencurse.entity.Passage2Entity;
import net.mcreator.wardencurse.entity.Passage1Entity;
import net.mcreator.wardencurse.entity.ParryvisualentityEntity;
import net.mcreator.wardencurse.entity.PMSspinEntity;
import net.mcreator.wardencurse.entity.OnemindstartEntity;
import net.mcreator.wardencurse.entity.Onemind2Entity;
import net.mcreator.wardencurse.entity.Nsakuralazulite3Entity;
import net.mcreator.wardencurse.entity.Nsakuralazulite2Entity;
import net.mcreator.wardencurse.entity.Nsakuralazulite1Entity;
import net.mcreator.wardencurse.entity.Nsakurafire3Entity;
import net.mcreator.wardencurse.entity.Nsakurafire2Entity;
import net.mcreator.wardencurse.entity.Nsakurafire1Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse3Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse2Entity;
import net.mcreator.wardencurse.entity.Nsakuracurse1Entity;
import net.mcreator.wardencurse.entity.Normalslash3Entity;
import net.mcreator.wardencurse.entity.Normalslash2Entity;
import net.mcreator.wardencurse.entity.Normalslash1Entity;
import net.mcreator.wardencurse.entity.NfcEntity;
import net.mcreator.wardencurse.entity.NdragonflashlazuliteEntity;
import net.mcreator.wardencurse.entity.NdragonflashfireEntity;
import net.mcreator.wardencurse.entity.NdragonflashcursedEntity;
import net.mcreator.wardencurse.entity.NdragonflashEntity;
import net.mcreator.wardencurse.entity.NashinalazuliteEntity;
import net.mcreator.wardencurse.entity.NashinafireEntity;
import net.mcreator.wardencurse.entity.NashinacurseEntity;
import net.mcreator.wardencurse.entity.NashinaEntity;
import net.mcreator.wardencurse.entity.MortalvisualEntity;
import net.mcreator.wardencurse.entity.MortalextraEntity;
import net.mcreator.wardencurse.entity.Mortaldraw2Entity;
import net.mcreator.wardencurse.entity.Mortaldraw1Entity;
import net.mcreator.wardencurse.entity.LazuliteshurikenvisualEntity;
import net.mcreator.wardencurse.entity.LazuliteaxevisualEntity;
import net.mcreator.wardencurse.entity.LazuliteShurikenEntity;
import net.mcreator.wardencurse.entity.LazuliteAxeSwipeEntity;
import net.mcreator.wardencurse.entity.IchimonjivisualEntity;
import net.mcreator.wardencurse.entity.HurtslashEntity;
import net.mcreator.wardencurse.entity.GuardvisualEntity;
import net.mcreator.wardencurse.entity.GeneralNaomiKawaradaEntity;
import net.mcreator.wardencurse.entity.FirespearswipeEntity;
import net.mcreator.wardencurse.entity.FireshadowslashEntity;
import net.mcreator.wardencurse.entity.FencerEntity;
import net.mcreator.wardencurse.entity.DragonaddcursedEntity;
import net.mcreator.wardencurse.entity.DragonaddEntity;
import net.mcreator.wardencurse.entity.DpstesterEntity;
import net.mcreator.wardencurse.entity.DownSlashEntity;
import net.mcreator.wardencurse.entity.DeathblowentityEntity;
import net.mcreator.wardencurse.entity.CursedfireshadowslashEntity;
import net.mcreator.wardencurse.entity.BulletEntity;
import net.mcreator.wardencurse.entity.BluefireshadowslashEntity;
import net.mcreator.wardencurse.entity.BlackflashpunchEntity;
import net.mcreator.wardencurse.entity.BeamEntity;
import net.mcreator.wardencurse.entity.AzEntity;
import net.mcreator.wardencurse.entity.AxeSlamVisualEntity;
import net.mcreator.wardencurse.entity.AshinasoldierEntity;
import net.mcreator.wardencurse.entity.Ashinacross2Entity;
import net.mcreator.wardencurse.entity.AshinaSpearEntity;
import net.mcreator.wardencurse.entity.AshinaSoldier2Entity;
import net.mcreator.wardencurse.entity.ArtlazuliteEntity;
import net.mcreator.wardencurse.entity.ArtfireEntity;
import net.mcreator.wardencurse.entity.ArtcurseEntity;
import net.mcreator.wardencurse.entity.AncientSkulkVessleEntity;
import net.mcreator.wardencurse.WardenCurseMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WardenCurseModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WardenCurseMod.MODID);
	public static final RegistryObject<EntityType<BlackflashpunchEntity>> BLACKFLASHPUNCH = register("blackflashpunch", EntityType.Builder.<BlackflashpunchEntity>of(BlackflashpunchEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BlackflashpunchEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShadowslashEntity>> SHADOWSLASH = register("shadowslash", EntityType.Builder.<ShadowslashEntity>of(ShadowslashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowslashEntity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<DpstesterEntity>> DPSTESTER = register("dpstester",
			EntityType.Builder.<DpstesterEntity>of(DpstesterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DpstesterEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FireshadowslashEntity>> FIRESHADOWSLASH = register("fireshadowslash", EntityType.Builder.<FireshadowslashEntity>of(FireshadowslashEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireshadowslashEntity::new).fireImmune().sized(0.6f, 0.3f));
	public static final RegistryObject<EntityType<BluefireshadowslashEntity>> BLUEFIRESHADOWSLASH = register("bluefireshadowslash", EntityType.Builder.<BluefireshadowslashEntity>of(BluefireshadowslashEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BluefireshadowslashEntity::new).fireImmune().sized(0.6f, 0.3f));
	public static final RegistryObject<EntityType<CursedfireshadowslashEntity>> CURSEDFIRESHADOWSLASH = register("cursedfireshadowslash", EntityType.Builder.<CursedfireshadowslashEntity>of(CursedfireshadowslashEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CursedfireshadowslashEntity::new).fireImmune().sized(0.6f, 0.3f));
	public static final RegistryObject<EntityType<Spiral1Entity>> SPIRAL_1 = register("spiral_1",
			EntityType.Builder.<Spiral1Entity>of(Spiral1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Spiral1Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Normalslash1Entity>> NORMALSLASH_1 = register("normalslash_1", EntityType.Builder.<Normalslash1Entity>of(Normalslash1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Normalslash1Entity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<Normalslash2Entity>> NORMALSLASH_2 = register("normalslash_2", EntityType.Builder.<Normalslash2Entity>of(Normalslash2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Normalslash2Entity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<Normalslash3Entity>> NORMALSLASH_3 = register("normalslash_3", EntityType.Builder.<Normalslash3Entity>of(Normalslash3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Normalslash3Entity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<Ashinacross2Entity>> ASHINACROSS_2 = register("ashinacross_2", EntityType.Builder.<Ashinacross2Entity>of(Ashinacross2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Ashinacross2Entity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<DragonaddEntity>> DRAGONADD = register("dragonadd", EntityType.Builder.<DragonaddEntity>of(DragonaddEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(DragonaddEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<DragonaddcursedEntity>> DRAGONADDCURSED = register("dragonaddcursed", EntityType.Builder.<DragonaddcursedEntity>of(DragonaddcursedEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DragonaddcursedEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<Sakura1Entity>> SAKURA_1 = register("sakura_1",
			EntityType.Builder.<Sakura1Entity>of(Sakura1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Sakura1Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Sakura2Entity>> SAKURA_2 = register("sakura_2",
			EntityType.Builder.<Sakura2Entity>of(Sakura2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Sakura2Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Sakura3Entity>> SAKURA_3 = register("sakura_3",
			EntityType.Builder.<Sakura3Entity>of(Sakura3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Sakura3Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SakuravisualEntity>> SAKURAVISUAL = register("sakuravisual",
			EntityType.Builder.<SakuravisualEntity>of(SakuravisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SakuravisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SpiralslashesEntity>> SPIRALSLASHES = register("spiralslashes", EntityType.Builder.<SpiralslashesEntity>of(SpiralslashesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiralslashesEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<SpiralcloudEntity>> SPIRALCLOUD = register("spiralcloud", EntityType.Builder.<SpiralcloudEntity>of(SpiralcloudEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiralcloudEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<Mortaldraw1Entity>> MORTALDRAW_1 = register("mortaldraw_1",
			EntityType.Builder.<Mortaldraw1Entity>of(Mortaldraw1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Mortaldraw1Entity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<OnemindstartEntity>> ONEMINDSTART = register("onemindstart",
			EntityType.Builder.<OnemindstartEntity>of(OnemindstartEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OnemindstartEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<LazuliteaxevisualEntity>> LAZULITEAXEVISUAL = register("lazuliteaxevisual",
			EntityType.Builder.<LazuliteaxevisualEntity>of(LazuliteaxevisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LazuliteaxevisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<GuardvisualEntity>> GUARDVISUAL = register("guardvisual",
			EntityType.Builder.<GuardvisualEntity>of(GuardvisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GuardvisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<ParryvisualentityEntity>> PARRYVISUALENTITY = register("parryvisualentity",
			EntityType.Builder.<ParryvisualentityEntity>of(ParryvisualentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ParryvisualentityEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<MortalvisualEntity>> MORTALVISUAL = register("mortalvisual", EntityType.Builder.<MortalvisualEntity>of(MortalvisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MortalvisualEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<Mortaldraw2Entity>> MORTALDRAW_2 = register("mortaldraw_2",
			EntityType.Builder.<Mortaldraw2Entity>of(Mortaldraw2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Mortaldraw2Entity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<MortalextraEntity>> MORTALEXTRA = register("mortalextra", EntityType.Builder.<MortalextraEntity>of(MortalextraEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MortalextraEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<SpiritelblemEntity>> SPIRITELBLEM = register("spiritelblem", EntityType.Builder.<SpiritelblemEntity>of(SpiritelblemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiritelblemEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SpiritvisualEntity>> SPIRITVISUAL = register("spiritvisual", EntityType.Builder.<SpiritvisualEntity>of(SpiritvisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiritvisualEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SparkingaxevisualEntity>> SPARKINGAXEVISUAL = register("sparkingaxevisual",
			EntityType.Builder.<SparkingaxevisualEntity>of(SparkingaxevisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SparkingaxevisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SpearswipeEntity>> SPEARSWIPE = register("spearswipe",
			EntityType.Builder.<SpearswipeEntity>of(SpearswipeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpearswipeEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ProstheticreadyEntity>> PROSTHETICREADY = register("prostheticready",
			EntityType.Builder.<ProstheticreadyEntity>of(ProstheticreadyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ProstheticreadyEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<ShadowswipeEntity>> SHADOWSWIPE = register("shadowswipe", EntityType.Builder.<ShadowswipeEntity>of(ShadowswipeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowswipeEntity::new).fireImmune().sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<ShadowspinEntity>> SHADOWSPIN = register("shadowspin",
			EntityType.Builder.<ShadowspinEntity>of(ShadowspinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowspinEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<DeathblowentityEntity>> DEATHBLOWENTITY = register("deathblowentity", EntityType.Builder.<DeathblowentityEntity>of(DeathblowentityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathblowentityEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<AshinasoldierEntity>> ASHINASOLDIER = register("ashinasoldier",
			EntityType.Builder.<AshinasoldierEntity>of(AshinasoldierEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AshinasoldierEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<NdragonflashEntity>> NDRAGONFLASH = register("ndragonflash", EntityType.Builder.<NdragonflashEntity>of(NdragonflashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NdragonflashEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NdragonflashfireEntity>> NDRAGONFLASHFIRE = register("ndragonflashfire", EntityType.Builder.<NdragonflashfireEntity>of(NdragonflashfireEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NdragonflashfireEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NdragonflashlazuliteEntity>> NDRAGONFLASHLAZULITE = register("ndragonflashlazulite", EntityType.Builder.<NdragonflashlazuliteEntity>of(NdragonflashlazuliteEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NdragonflashlazuliteEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NdragonflashcursedEntity>> NDRAGONFLASHCURSED = register("ndragonflashcursed", EntityType.Builder.<NdragonflashcursedEntity>of(NdragonflashcursedEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NdragonflashcursedEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NashinaEntity>> NASHINA = register("nashina",
			EntityType.Builder.<NashinaEntity>of(NashinaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NashinaEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NashinafireEntity>> NASHINAFIRE = register("nashinafire", EntityType.Builder.<NashinafireEntity>of(NashinafireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NashinafireEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NashinalazuliteEntity>> NASHINALAZULITE = register("nashinalazulite", EntityType.Builder.<NashinalazuliteEntity>of(NashinalazuliteEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NashinalazuliteEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<NashinacurseEntity>> NASHINACURSE = register("nashinacurse", EntityType.Builder.<NashinacurseEntity>of(NashinacurseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NashinacurseEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<Nsakurafire1Entity>> NSAKURAFIRE_1 = register("nsakurafire_1", EntityType.Builder.<Nsakurafire1Entity>of(Nsakurafire1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakurafire1Entity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<Nsakuralazulite1Entity>> NSAKURALAZULITE_1 = register("nsakuralazulite_1", EntityType.Builder.<Nsakuralazulite1Entity>of(Nsakuralazulite1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuralazulite1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakuracurse1Entity>> NSAKURACURSE_1 = register("nsakuracurse_1", EntityType.Builder.<Nsakuracurse1Entity>of(Nsakuracurse1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuracurse1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakurafire2Entity>> NSAKURAFIRE_2 = register("nsakurafire_2", EntityType.Builder.<Nsakurafire2Entity>of(Nsakurafire2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakurafire2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakuralazulite2Entity>> NSAKURALAZULITE_2 = register("nsakuralazulite_2", EntityType.Builder.<Nsakuralazulite2Entity>of(Nsakuralazulite2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuralazulite2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakuracurse2Entity>> NSAKURACURSE_2 = register("nsakuracurse_2", EntityType.Builder.<Nsakuracurse2Entity>of(Nsakuracurse2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuracurse2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakurafire3Entity>> NSAKURAFIRE_3 = register("nsakurafire_3", EntityType.Builder.<Nsakurafire3Entity>of(Nsakurafire3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakurafire3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakuralazulite3Entity>> NSAKURALAZULITE_3 = register("nsakuralazulite_3", EntityType.Builder.<Nsakuralazulite3Entity>of(Nsakuralazulite3Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuralazulite3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Nsakuracurse3Entity>> NSAKURACURSE_3 = register("nsakuracurse_3", EntityType.Builder.<Nsakuracurse3Entity>of(Nsakuracurse3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Nsakuracurse3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArtfireEntity>> ARTFIRE = register("artfire",
			EntityType.Builder.<ArtfireEntity>of(ArtfireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArtfireEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<ArtlazuliteEntity>> ARTLAZULITE = register("artlazulite", EntityType.Builder.<ArtlazuliteEntity>of(ArtlazuliteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArtlazuliteEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<ArtcurseEntity>> ARTCURSE = register("artcurse",
			EntityType.Builder.<ArtcurseEntity>of(ArtcurseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArtcurseEntity::new).fireImmune().sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<ProgressivesamuraiEntity>> PROGRESSIVESAMURAI = register("progressivesamurai",
			EntityType.Builder.<ProgressivesamuraiEntity>of(ProgressivesamuraiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ProgressivesamuraiEntity::new)

					.sized(0.8f, 2.4f));
	public static final RegistryObject<EntityType<VentFEntity>> VENT_F = register("vent_f",
			EntityType.Builder.<VentFEntity>of(VentFEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VentFEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<VentLEntity>> VENT_L = register("vent_l",
			EntityType.Builder.<VentLEntity>of(VentLEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VentLEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<VentCEntity>> VENT_C = register("vent_c",
			EntityType.Builder.<VentCEntity>of(VentCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VentCEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<Shuriken1Entity>> SHURIKEN_1 = register("shuriken_1",
			EntityType.Builder.<Shuriken1Entity>of(Shuriken1Entity::new, MobCategory.MISC).setCustomClientFactory(Shuriken1Entity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HurtslashEntity>> HURTSLASH = register("hurtslash", EntityType.Builder.<HurtslashEntity>of(HurtslashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(HurtslashEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<Whirlwind1Entity>> WHIRLWIND_1 = register("whirlwind_1", EntityType.Builder.<Whirlwind1Entity>of(Whirlwind1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(Whirlwind1Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Whirlwind2Entity>> WHIRLWIND_2 = register("whirlwind_2", EntityType.Builder.<Whirlwind2Entity>of(Whirlwind2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(Whirlwind2Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Whirlwindfire1Entity>> WHIRLWINDFIRE_1 = register("whirlwindfire_1", EntityType.Builder.<Whirlwindfire1Entity>of(Whirlwindfire1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindfire1Entity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Whirlwindfire2Entity>> WHIRLWINDFIRE_2 = register("whirlwindfire_2", EntityType.Builder.<Whirlwindfire2Entity>of(Whirlwindfire2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindfire2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Whirlwindlazulite1Entity>> WHIRLWINDLAZULITE_1 = register("whirlwindlazulite_1", EntityType.Builder.<Whirlwindlazulite1Entity>of(Whirlwindlazulite1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindlazulite1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Whirlwindlazulite2Entity>> WHIRLWINDLAZULITE_2 = register("whirlwindlazulite_2", EntityType.Builder.<Whirlwindlazulite2Entity>of(Whirlwindlazulite2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindlazulite2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Whirlwindcursed1Entity>> WHIRLWINDCURSED_1 = register("whirlwindcursed_1", EntityType.Builder.<Whirlwindcursed1Entity>of(Whirlwindcursed1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindcursed1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Whirlwindcursed2Entity>> WHIRLWINDCURSED_2 = register("whirlwindcursed_2", EntityType.Builder.<Whirlwindcursed2Entity>of(Whirlwindcursed2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Whirlwindcursed2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LazuliteShurikenEntity>> LAZULITE_SHURIKEN = register("lazulite_shuriken", EntityType.Builder.<LazuliteShurikenEntity>of(LazuliteShurikenEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LazuliteShurikenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpinningShurikenEntity>> SPINNING_SHURIKEN = register("spinning_shuriken", EntityType.Builder.<SpinningShurikenEntity>of(SpinningShurikenEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SpinningShurikenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpinningLazuliteShurikenEntity>> SPINNING_LAZULITE_SHURIKEN = register("spinning_lazulite_shuriken",
			EntityType.Builder.<SpinningLazuliteShurikenEntity>of(SpinningLazuliteShurikenEntity::new, MobCategory.MISC).setCustomClientFactory(SpinningLazuliteShurikenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AshinaSoldier2Entity>> ASHINA_SOLDIER_2 = register("ashina_soldier_2",
			EntityType.Builder.<AshinaSoldier2Entity>of(AshinaSoldier2Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AshinaSoldier2Entity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<Onemind2Entity>> ONEMIND_2 = register("onemind_2",
			EntityType.Builder.<Onemind2Entity>of(Onemind2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Onemind2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShurikenvisualEntity>> SHURIKENVISUAL = register("shurikenvisual", EntityType.Builder.<ShurikenvisualEntity>of(ShurikenvisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShurikenvisualEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LazuliteshurikenvisualEntity>> LAZULITESHURIKENVISUAL = register("lazuliteshurikenvisual", EntityType.Builder.<LazuliteshurikenvisualEntity>of(LazuliteshurikenvisualEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LazuliteshurikenvisualEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<AshinaSpearEntity>> ASHINA_SPEAR = register("ashina_spear",
			EntityType.Builder.<AshinaSpearEntity>of(AshinaSpearEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AshinaSpearEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<PMSspinEntity>> PM_SSPIN = register("pm_sspin",
			EntityType.Builder.<PMSspinEntity>of(PMSspinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PMSspinEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<NfcEntity>> NFC = register("nfc",
			EntityType.Builder.<NfcEntity>of(NfcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NfcEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<StartsmokeentityEntity>> STARTSMOKEENTITY = register("startsmokeentity", EntityType.Builder.<StartsmokeentityEntity>of(StartsmokeentityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StartsmokeentityEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<PnfcEntity>> PNFC = register("pnfc",
			EntityType.Builder.<PnfcEntity>of(PnfcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PnfcEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<StartPsmokeEntity>> START_PSMOKE = register("start_psmoke", EntityType.Builder.<StartPsmokeEntity>of(StartPsmokeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StartPsmokeEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<AncientSkulkVessleEntity>> ANCIENT_SKULK_VESSLE = register("ancient_skulk_vessle", EntityType.Builder.<AncientSkulkVessleEntity>of(AncientSkulkVessleEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AncientSkulkVessleEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<FirespearswipeEntity>> FIRESPEARSWIPE = register("firespearswipe", EntityType.Builder.<FirespearswipeEntity>of(FirespearswipeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FirespearswipeEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<SparkingAxeSwipeEntity>> SPARKING_AXE_SWIPE = register("sparking_axe_swipe", EntityType.Builder.<SparkingAxeSwipeEntity>of(SparkingAxeSwipeEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SparkingAxeSwipeEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<LazuliteAxeSwipeEntity>> LAZULITE_AXE_SWIPE = register("lazulite_axe_swipe", EntityType.Builder.<LazuliteAxeSwipeEntity>of(LazuliteAxeSwipeEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LazuliteAxeSwipeEntity::new).fireImmune().sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<FencerEntity>> FENCER = register("fencer",
			EntityType.Builder.<FencerEntity>of(FencerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FencerEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<AxeSlamVisualEntity>> AXE_SLAM_VISUAL = register("axe_slam_visual",
			EntityType.Builder.<AxeSlamVisualEntity>of(AxeSlamVisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AxeSlamVisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<BeamEntity>> BEAM = register("beam",
			EntityType.Builder.<BeamEntity>of(BeamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BeamEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<Passage1Entity>> PASSAGE_1 = register("passage_1",
			EntityType.Builder.<Passage1Entity>of(Passage1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Passage1Entity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<Passage2Entity>> PASSAGE_2 = register("passage_2",
			EntityType.Builder.<Passage2Entity>of(Passage2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Passage2Entity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<SculkSoldier1Entity>> SCULK_SOLDIER_1 = register("sculk_soldier_1", EntityType.Builder.<SculkSoldier1Entity>of(SculkSoldier1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SculkSoldier1Entity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<GeneralNaomiKawaradaEntity>> GENERAL_NAOMI_KAWARADA = register("general_naomi_kawarada",
			EntityType.Builder.<GeneralNaomiKawaradaEntity>of(GeneralNaomiKawaradaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(GeneralNaomiKawaradaEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<BulletEntity>> BULLET = register("bullet",
			EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC).setCustomClientFactory(BulletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IchimonjivisualEntity>> ICHIMONJIVISUAL = register("ichimonjivisual",
			EntityType.Builder.<IchimonjivisualEntity>of(IchimonjivisualEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IchimonjivisualEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<DownSlashEntity>> DOWN_SLASH = register("down_slash", EntityType.Builder.<DownSlashEntity>of(DownSlashEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(DownSlashEntity::new).fireImmune().sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<AzEntity>> AZ = register("az",
			EntityType.Builder.<AzEntity>of(AzEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AzEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ShadowslashEntity.init();
			DpstesterEntity.init();
			FireshadowslashEntity.init();
			BluefireshadowslashEntity.init();
			CursedfireshadowslashEntity.init();
			Spiral1Entity.init();
			Normalslash1Entity.init();
			Normalslash2Entity.init();
			Normalslash3Entity.init();
			Ashinacross2Entity.init();
			DragonaddEntity.init();
			DragonaddcursedEntity.init();
			Sakura1Entity.init();
			Sakura2Entity.init();
			Sakura3Entity.init();
			SakuravisualEntity.init();
			SpiralslashesEntity.init();
			SpiralcloudEntity.init();
			Mortaldraw1Entity.init();
			OnemindstartEntity.init();
			LazuliteaxevisualEntity.init();
			GuardvisualEntity.init();
			ParryvisualentityEntity.init();
			MortalvisualEntity.init();
			Mortaldraw2Entity.init();
			MortalextraEntity.init();
			SpiritelblemEntity.init();
			SpiritvisualEntity.init();
			SparkingaxevisualEntity.init();
			SpearswipeEntity.init();
			ProstheticreadyEntity.init();
			ShadowswipeEntity.init();
			ShadowspinEntity.init();
			DeathblowentityEntity.init();
			AshinasoldierEntity.init();
			NdragonflashEntity.init();
			NdragonflashfireEntity.init();
			NdragonflashlazuliteEntity.init();
			NdragonflashcursedEntity.init();
			NashinaEntity.init();
			NashinafireEntity.init();
			NashinalazuliteEntity.init();
			NashinacurseEntity.init();
			Nsakurafire1Entity.init();
			Nsakuralazulite1Entity.init();
			Nsakuracurse1Entity.init();
			Nsakurafire2Entity.init();
			Nsakuralazulite2Entity.init();
			Nsakuracurse2Entity.init();
			Nsakurafire3Entity.init();
			Nsakuralazulite3Entity.init();
			Nsakuracurse3Entity.init();
			ArtfireEntity.init();
			ArtlazuliteEntity.init();
			ArtcurseEntity.init();
			ProgressivesamuraiEntity.init();
			VentFEntity.init();
			VentLEntity.init();
			VentCEntity.init();
			HurtslashEntity.init();
			Whirlwind1Entity.init();
			Whirlwind2Entity.init();
			Whirlwindfire1Entity.init();
			Whirlwindfire2Entity.init();
			Whirlwindlazulite1Entity.init();
			Whirlwindlazulite2Entity.init();
			Whirlwindcursed1Entity.init();
			Whirlwindcursed2Entity.init();
			AshinaSoldier2Entity.init();
			Onemind2Entity.init();
			ShurikenvisualEntity.init();
			LazuliteshurikenvisualEntity.init();
			AshinaSpearEntity.init();
			PMSspinEntity.init();
			NfcEntity.init();
			StartsmokeentityEntity.init();
			PnfcEntity.init();
			StartPsmokeEntity.init();
			AncientSkulkVessleEntity.init();
			FirespearswipeEntity.init();
			SparkingAxeSwipeEntity.init();
			LazuliteAxeSwipeEntity.init();
			FencerEntity.init();
			AxeSlamVisualEntity.init();
			BeamEntity.init();
			Passage1Entity.init();
			Passage2Entity.init();
			SculkSoldier1Entity.init();
			GeneralNaomiKawaradaEntity.init();
			IchimonjivisualEntity.init();
			DownSlashEntity.init();
			AzEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SHADOWSLASH.get(), ShadowslashEntity.createAttributes().build());
		event.put(DPSTESTER.get(), DpstesterEntity.createAttributes().build());
		event.put(FIRESHADOWSLASH.get(), FireshadowslashEntity.createAttributes().build());
		event.put(BLUEFIRESHADOWSLASH.get(), BluefireshadowslashEntity.createAttributes().build());
		event.put(CURSEDFIRESHADOWSLASH.get(), CursedfireshadowslashEntity.createAttributes().build());
		event.put(SPIRAL_1.get(), Spiral1Entity.createAttributes().build());
		event.put(NORMALSLASH_1.get(), Normalslash1Entity.createAttributes().build());
		event.put(NORMALSLASH_2.get(), Normalslash2Entity.createAttributes().build());
		event.put(NORMALSLASH_3.get(), Normalslash3Entity.createAttributes().build());
		event.put(ASHINACROSS_2.get(), Ashinacross2Entity.createAttributes().build());
		event.put(DRAGONADD.get(), DragonaddEntity.createAttributes().build());
		event.put(DRAGONADDCURSED.get(), DragonaddcursedEntity.createAttributes().build());
		event.put(SAKURA_1.get(), Sakura1Entity.createAttributes().build());
		event.put(SAKURA_2.get(), Sakura2Entity.createAttributes().build());
		event.put(SAKURA_3.get(), Sakura3Entity.createAttributes().build());
		event.put(SAKURAVISUAL.get(), SakuravisualEntity.createAttributes().build());
		event.put(SPIRALSLASHES.get(), SpiralslashesEntity.createAttributes().build());
		event.put(SPIRALCLOUD.get(), SpiralcloudEntity.createAttributes().build());
		event.put(MORTALDRAW_1.get(), Mortaldraw1Entity.createAttributes().build());
		event.put(ONEMINDSTART.get(), OnemindstartEntity.createAttributes().build());
		event.put(LAZULITEAXEVISUAL.get(), LazuliteaxevisualEntity.createAttributes().build());
		event.put(GUARDVISUAL.get(), GuardvisualEntity.createAttributes().build());
		event.put(PARRYVISUALENTITY.get(), ParryvisualentityEntity.createAttributes().build());
		event.put(MORTALVISUAL.get(), MortalvisualEntity.createAttributes().build());
		event.put(MORTALDRAW_2.get(), Mortaldraw2Entity.createAttributes().build());
		event.put(MORTALEXTRA.get(), MortalextraEntity.createAttributes().build());
		event.put(SPIRITELBLEM.get(), SpiritelblemEntity.createAttributes().build());
		event.put(SPIRITVISUAL.get(), SpiritvisualEntity.createAttributes().build());
		event.put(SPARKINGAXEVISUAL.get(), SparkingaxevisualEntity.createAttributes().build());
		event.put(SPEARSWIPE.get(), SpearswipeEntity.createAttributes().build());
		event.put(PROSTHETICREADY.get(), ProstheticreadyEntity.createAttributes().build());
		event.put(SHADOWSWIPE.get(), ShadowswipeEntity.createAttributes().build());
		event.put(SHADOWSPIN.get(), ShadowspinEntity.createAttributes().build());
		event.put(DEATHBLOWENTITY.get(), DeathblowentityEntity.createAttributes().build());
		event.put(ASHINASOLDIER.get(), AshinasoldierEntity.createAttributes().build());
		event.put(NDRAGONFLASH.get(), NdragonflashEntity.createAttributes().build());
		event.put(NDRAGONFLASHFIRE.get(), NdragonflashfireEntity.createAttributes().build());
		event.put(NDRAGONFLASHLAZULITE.get(), NdragonflashlazuliteEntity.createAttributes().build());
		event.put(NDRAGONFLASHCURSED.get(), NdragonflashcursedEntity.createAttributes().build());
		event.put(NASHINA.get(), NashinaEntity.createAttributes().build());
		event.put(NASHINAFIRE.get(), NashinafireEntity.createAttributes().build());
		event.put(NASHINALAZULITE.get(), NashinalazuliteEntity.createAttributes().build());
		event.put(NASHINACURSE.get(), NashinacurseEntity.createAttributes().build());
		event.put(NSAKURAFIRE_1.get(), Nsakurafire1Entity.createAttributes().build());
		event.put(NSAKURALAZULITE_1.get(), Nsakuralazulite1Entity.createAttributes().build());
		event.put(NSAKURACURSE_1.get(), Nsakuracurse1Entity.createAttributes().build());
		event.put(NSAKURAFIRE_2.get(), Nsakurafire2Entity.createAttributes().build());
		event.put(NSAKURALAZULITE_2.get(), Nsakuralazulite2Entity.createAttributes().build());
		event.put(NSAKURACURSE_2.get(), Nsakuracurse2Entity.createAttributes().build());
		event.put(NSAKURAFIRE_3.get(), Nsakurafire3Entity.createAttributes().build());
		event.put(NSAKURALAZULITE_3.get(), Nsakuralazulite3Entity.createAttributes().build());
		event.put(NSAKURACURSE_3.get(), Nsakuracurse3Entity.createAttributes().build());
		event.put(ARTFIRE.get(), ArtfireEntity.createAttributes().build());
		event.put(ARTLAZULITE.get(), ArtlazuliteEntity.createAttributes().build());
		event.put(ARTCURSE.get(), ArtcurseEntity.createAttributes().build());
		event.put(PROGRESSIVESAMURAI.get(), ProgressivesamuraiEntity.createAttributes().build());
		event.put(VENT_F.get(), VentFEntity.createAttributes().build());
		event.put(VENT_L.get(), VentLEntity.createAttributes().build());
		event.put(VENT_C.get(), VentCEntity.createAttributes().build());
		event.put(HURTSLASH.get(), HurtslashEntity.createAttributes().build());
		event.put(WHIRLWIND_1.get(), Whirlwind1Entity.createAttributes().build());
		event.put(WHIRLWIND_2.get(), Whirlwind2Entity.createAttributes().build());
		event.put(WHIRLWINDFIRE_1.get(), Whirlwindfire1Entity.createAttributes().build());
		event.put(WHIRLWINDFIRE_2.get(), Whirlwindfire2Entity.createAttributes().build());
		event.put(WHIRLWINDLAZULITE_1.get(), Whirlwindlazulite1Entity.createAttributes().build());
		event.put(WHIRLWINDLAZULITE_2.get(), Whirlwindlazulite2Entity.createAttributes().build());
		event.put(WHIRLWINDCURSED_1.get(), Whirlwindcursed1Entity.createAttributes().build());
		event.put(WHIRLWINDCURSED_2.get(), Whirlwindcursed2Entity.createAttributes().build());
		event.put(ASHINA_SOLDIER_2.get(), AshinaSoldier2Entity.createAttributes().build());
		event.put(ONEMIND_2.get(), Onemind2Entity.createAttributes().build());
		event.put(SHURIKENVISUAL.get(), ShurikenvisualEntity.createAttributes().build());
		event.put(LAZULITESHURIKENVISUAL.get(), LazuliteshurikenvisualEntity.createAttributes().build());
		event.put(ASHINA_SPEAR.get(), AshinaSpearEntity.createAttributes().build());
		event.put(PM_SSPIN.get(), PMSspinEntity.createAttributes().build());
		event.put(NFC.get(), NfcEntity.createAttributes().build());
		event.put(STARTSMOKEENTITY.get(), StartsmokeentityEntity.createAttributes().build());
		event.put(PNFC.get(), PnfcEntity.createAttributes().build());
		event.put(START_PSMOKE.get(), StartPsmokeEntity.createAttributes().build());
		event.put(ANCIENT_SKULK_VESSLE.get(), AncientSkulkVessleEntity.createAttributes().build());
		event.put(FIRESPEARSWIPE.get(), FirespearswipeEntity.createAttributes().build());
		event.put(SPARKING_AXE_SWIPE.get(), SparkingAxeSwipeEntity.createAttributes().build());
		event.put(LAZULITE_AXE_SWIPE.get(), LazuliteAxeSwipeEntity.createAttributes().build());
		event.put(FENCER.get(), FencerEntity.createAttributes().build());
		event.put(AXE_SLAM_VISUAL.get(), AxeSlamVisualEntity.createAttributes().build());
		event.put(BEAM.get(), BeamEntity.createAttributes().build());
		event.put(PASSAGE_1.get(), Passage1Entity.createAttributes().build());
		event.put(PASSAGE_2.get(), Passage2Entity.createAttributes().build());
		event.put(SCULK_SOLDIER_1.get(), SculkSoldier1Entity.createAttributes().build());
		event.put(GENERAL_NAOMI_KAWARADA.get(), GeneralNaomiKawaradaEntity.createAttributes().build());
		event.put(ICHIMONJIVISUAL.get(), IchimonjivisualEntity.createAttributes().build());
		event.put(DOWN_SLASH.get(), DownSlashEntity.createAttributes().build());
		event.put(AZ.get(), AzEntity.createAttributes().build());
	}
}
