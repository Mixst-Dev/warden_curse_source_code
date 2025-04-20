
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.wardencurse.potion.YasharikuMobEffect;
import net.mcreator.wardencurse.potion.UngoSugarMobEffect;
import net.mcreator.wardencurse.potion.TechniquecooldownMobEffect;
import net.mcreator.wardencurse.potion.StunnedMobEffect;
import net.mcreator.wardencurse.potion.ProstheticcooldownMobEffect;
import net.mcreator.wardencurse.potion.PostureregenerationdelayMobEffect;
import net.mcreator.wardencurse.potion.ParryvisualMobEffect;
import net.mcreator.wardencurse.potion.ParryMobEffect;
import net.mcreator.wardencurse.potion.OilEffectMobEffect;
import net.mcreator.wardencurse.potion.NoMoveMobEffect;
import net.mcreator.wardencurse.potion.NoJump2MobEffect;
import net.mcreator.wardencurse.potion.MobilitycooldownMobEffect;
import net.mcreator.wardencurse.potion.MistRavenMobEffect;
import net.mcreator.wardencurse.potion.MikriCounterMobEffect;
import net.mcreator.wardencurse.potion.ItemcooldowneffectMobEffect;
import net.mcreator.wardencurse.potion.ItemcooldownMobEffect;
import net.mcreator.wardencurse.potion.InvincibleMobEffect;
import net.mcreator.wardencurse.potion.GuardentityMobEffect;
import net.mcreator.wardencurse.potion.GuardcooldownMobEffect;
import net.mcreator.wardencurse.potion.GokanMobEffect;
import net.mcreator.wardencurse.potion.FreezemoveMobEffect;
import net.mcreator.wardencurse.potion.FirestateMobEffect;
import net.mcreator.wardencurse.potion.DeathblowMobEffect;
import net.mcreator.wardencurse.potion.CursedfirestateMobEffect;
import net.mcreator.wardencurse.potion.BurningMobEffect;
import net.mcreator.wardencurse.potion.BurnhealcooldownMobEffect;
import net.mcreator.wardencurse.potion.BluefirestateMobEffect;
import net.mcreator.wardencurse.potion.BleedingMobEffect;
import net.mcreator.wardencurse.potion.AttackcooldownMobEffect;
import net.mcreator.wardencurse.potion.AkossugarMobEffect;
import net.mcreator.wardencurse.WardenCurseMod;

public class WardenCurseModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WardenCurseMod.MODID);
	public static final RegistryObject<MobEffect> PARRY = REGISTRY.register("parry", () -> new ParryMobEffect());
	public static final RegistryObject<MobEffect> FIRESTATE = REGISTRY.register("firestate", () -> new FirestateMobEffect());
	public static final RegistryObject<MobEffect> BLUEFIRESTATE = REGISTRY.register("bluefirestate", () -> new BluefirestateMobEffect());
	public static final RegistryObject<MobEffect> CURSEDFIRESTATE = REGISTRY.register("cursedfirestate", () -> new CursedfirestateMobEffect());
	public static final RegistryObject<MobEffect> GUARDCOOLDOWN = REGISTRY.register("guardcooldown", () -> new GuardcooldownMobEffect());
	public static final RegistryObject<MobEffect> ATTACKCOOLDOWN = REGISTRY.register("attackcooldown", () -> new AttackcooldownMobEffect());
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> STUNNED = REGISTRY.register("stunned", () -> new StunnedMobEffect());
	public static final RegistryObject<MobEffect> MOBILITYCOOLDOWN = REGISTRY.register("mobilitycooldown", () -> new MobilitycooldownMobEffect());
	public static final RegistryObject<MobEffect> FREEZEMOVE = REGISTRY.register("freezemove", () -> new FreezemoveMobEffect());
	public static final RegistryObject<MobEffect> PARRYVISUAL = REGISTRY.register("parryvisual", () -> new ParryvisualMobEffect());
	public static final RegistryObject<MobEffect> TECHNIQUECOOLDOWN = REGISTRY.register("techniquecooldown", () -> new TechniquecooldownMobEffect());
	public static final RegistryObject<MobEffect> POSTUREREGENERATIONDELAY = REGISTRY.register("postureregenerationdelay", () -> new PostureregenerationdelayMobEffect());
	public static final RegistryObject<MobEffect> PROSTHETICCOOLDOWN = REGISTRY.register("prostheticcooldown", () -> new ProstheticcooldownMobEffect());
	public static final RegistryObject<MobEffect> AKOSSUGAR = REGISTRY.register("akossugar", () -> new AkossugarMobEffect());
	public static final RegistryObject<MobEffect> ITEMCOOLDOWN = REGISTRY.register("itemcooldown", () -> new ItemcooldownMobEffect());
	public static final RegistryObject<MobEffect> DEATHBLOW = REGISTRY.register("deathblow", () -> new DeathblowMobEffect());
	public static final RegistryObject<MobEffect> GUARDENTITY = REGISTRY.register("guardentity", () -> new GuardentityMobEffect());
	public static final RegistryObject<MobEffect> ITEMCOOLDOWNEFFECT = REGISTRY.register("itemcooldowneffect", () -> new ItemcooldowneffectMobEffect());
	public static final RegistryObject<MobEffect> GOKAN = REGISTRY.register("gokan", () -> new GokanMobEffect());
	public static final RegistryObject<MobEffect> YASHARIKU = REGISTRY.register("yashariku", () -> new YasharikuMobEffect());
	public static final RegistryObject<MobEffect> NO_JUMP_2 = REGISTRY.register("no_jump_2", () -> new NoJump2MobEffect());
	public static final RegistryObject<MobEffect> OIL_EFFECT = REGISTRY.register("oil_effect", () -> new OilEffectMobEffect());
	public static final RegistryObject<MobEffect> BURNING = REGISTRY.register("burning", () -> new BurningMobEffect());
	public static final RegistryObject<MobEffect> BURNHEALCOOLDOWN = REGISTRY.register("burnhealcooldown", () -> new BurnhealcooldownMobEffect());
	public static final RegistryObject<MobEffect> MIKRI_COUNTER = REGISTRY.register("mikri_counter", () -> new MikriCounterMobEffect());
	public static final RegistryObject<MobEffect> UNGO_SUGAR = REGISTRY.register("ungo_sugar", () -> new UngoSugarMobEffect());
	public static final RegistryObject<MobEffect> NO_MOVE = REGISTRY.register("no_move", () -> new NoMoveMobEffect());
	public static final RegistryObject<MobEffect> MIST_RAVEN = REGISTRY.register("mist_raven", () -> new MistRavenMobEffect());
	public static final RegistryObject<MobEffect> INVINCIBLE = REGISTRY.register("invincible", () -> new InvincibleMobEffect());
}
