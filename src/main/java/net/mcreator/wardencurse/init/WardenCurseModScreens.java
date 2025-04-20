
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.wardencurse.client.gui.WhirlwindguiScreen;
import net.mcreator.wardencurse.client.gui.Spiralcoudpassagegui2Screen;
import net.mcreator.wardencurse.client.gui.Sparkingaxegui2Screen;
import net.mcreator.wardencurse.client.gui.SparkingAxeCraftingScreen;
import net.mcreator.wardencurse.client.gui.ShurikenGuiScreen;
import net.mcreator.wardencurse.client.gui.ShadowrushguiScreen;
import net.mcreator.wardencurse.client.gui.SekiroguiScreen;
import net.mcreator.wardencurse.client.gui.Sakuradancegui2Screen;
import net.mcreator.wardencurse.client.gui.RessurectionOverlayScreen;
import net.mcreator.wardencurse.client.gui.PurpleGUIScreen;
import net.mcreator.wardencurse.client.gui.PurpleFumeCraftingGUIScreen;
import net.mcreator.wardencurse.client.gui.ProstheticTableScreen;
import net.mcreator.wardencurse.client.gui.ProstheticConfigScreen;
import net.mcreator.wardencurse.client.gui.PostureConfigGUIScreen;
import net.mcreator.wardencurse.client.gui.Page5Screen;
import net.mcreator.wardencurse.client.gui.Page4Screen;
import net.mcreator.wardencurse.client.gui.Page3Screen;
import net.mcreator.wardencurse.client.gui.OneMindGUIScreen;
import net.mcreator.wardencurse.client.gui.NightJarGUIScreen;
import net.mcreator.wardencurse.client.gui.Mortaldrawgui2Screen;
import net.mcreator.wardencurse.client.gui.MistRavenGUIScreen;
import net.mcreator.wardencurse.client.gui.MikiriGUIScreen;
import net.mcreator.wardencurse.client.gui.LongsparkCraftingGUIScreen;
import net.mcreator.wardencurse.client.gui.LongSparkGUIScreen;
import net.mcreator.wardencurse.client.gui.LoadedspearguiScreen;
import net.mcreator.wardencurse.client.gui.LoadedSpearCraftingScreen;
import net.mcreator.wardencurse.client.gui.LoadedAxeGUIScreen;
import net.mcreator.wardencurse.client.gui.LoadedAxeCraftingScreen;
import net.mcreator.wardencurse.client.gui.LeapingfireguiScreen;
import net.mcreator.wardencurse.client.gui.LeapingFireCraftingScreen;
import net.mcreator.wardencurse.client.gui.LazuliteshurikenguiScreen;
import net.mcreator.wardencurse.client.gui.Lazuliteaxegui2Screen;
import net.mcreator.wardencurse.client.gui.LazuliteVentGUIScreen;
import net.mcreator.wardencurse.client.gui.LazuliteAxeCraftingScreen;
import net.mcreator.wardencurse.client.gui.IchimonjiGUIScreen;
import net.mcreator.wardencurse.client.gui.Guardpage2Screen;
import net.mcreator.wardencurse.client.gui.GlockGUIScreen;
import net.mcreator.wardencurse.client.gui.GameplayConfigScreen;
import net.mcreator.wardencurse.client.gui.FloatingPassageGUIScreen;
import net.mcreator.wardencurse.client.gui.FlameVentCraftGUIScreen;
import net.mcreator.wardencurse.client.gui.FireventGUIScreen;
import net.mcreator.wardencurse.client.gui.FirecrackerGUIScreen;
import net.mcreator.wardencurse.client.gui.FirecrackerCraftingGUIScreen;
import net.mcreator.wardencurse.client.gui.EmblemConfigGUIScreen;
import net.mcreator.wardencurse.client.gui.Dragonflashgui2Screen;
import net.mcreator.wardencurse.client.gui.CursedVentGUIScreen;
import net.mcreator.wardencurse.client.gui.ConfigScreen;
import net.mcreator.wardencurse.client.gui.CombatArtConfigScreen;
import net.mcreator.wardencurse.client.gui.BookfrontpageScreen;
import net.mcreator.wardencurse.client.gui.Ashinacrossgui2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WardenCurseModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(WardenCurseModMenus.SEKIROGUI.get(), SekiroguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.SHADOWRUSHGUI.get(), ShadowrushguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.ASHINACROSSGUI_2.get(), Ashinacrossgui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.SAKURADANCEGUI_2.get(), Sakuradancegui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.SPIRALCOUDPASSAGEGUI_2.get(), Spiralcoudpassagegui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.DRAGONFLASHGUI_2.get(), Dragonflashgui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.MORTALDRAWGUI_2.get(), Mortaldrawgui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.LAZULITEAXEGUI_2.get(), Lazuliteaxegui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.SPARKINGAXEGUI_2.get(), Sparkingaxegui2Screen::new);
			MenuScreens.register(WardenCurseModMenus.LOADEDSPEARGUI.get(), LoadedspearguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.LEAPINGFIREGUI.get(), LeapingfireguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.BOOKFRONTPAGE.get(), BookfrontpageScreen::new);
			MenuScreens.register(WardenCurseModMenus.GUARDPAGE_2.get(), Guardpage2Screen::new);
			MenuScreens.register(WardenCurseModMenus.PAGE_3.get(), Page3Screen::new);
			MenuScreens.register(WardenCurseModMenus.PAGE_4.get(), Page4Screen::new);
			MenuScreens.register(WardenCurseModMenus.PAGE_5.get(), Page5Screen::new);
			MenuScreens.register(WardenCurseModMenus.FIREVENT_GUI.get(), FireventGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.LAZULITE_VENT_GUI.get(), LazuliteVentGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.CURSED_VENT_GUI.get(), CursedVentGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.WHIRLWINDGUI.get(), WhirlwindguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.CONFIG.get(), ConfigScreen::new);
			MenuScreens.register(WardenCurseModMenus.COMBAT_ART_CONFIG.get(), CombatArtConfigScreen::new);
			MenuScreens.register(WardenCurseModMenus.PROSTHETIC_CONFIG.get(), ProstheticConfigScreen::new);
			MenuScreens.register(WardenCurseModMenus.POSTURE_CONFIG_GUI.get(), PostureConfigGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.EMBLEM_CONFIG_GUI.get(), EmblemConfigGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.SHURIKEN_GUI.get(), ShurikenGuiScreen::new);
			MenuScreens.register(WardenCurseModMenus.LAZULITESHURIKENGUI.get(), LazuliteshurikenguiScreen::new);
			MenuScreens.register(WardenCurseModMenus.ONE_MIND_GUI.get(), OneMindGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.GAMEPLAY_CONFIG.get(), GameplayConfigScreen::new);
			MenuScreens.register(WardenCurseModMenus.FIRECRACKER_GUI.get(), FirecrackerGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.LONG_SPARK_GUI.get(), LongSparkGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.PURPLE_GUI.get(), PurpleGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.MIKIRI_GUI.get(), MikiriGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.PROSTHETIC_TABLE.get(), ProstheticTableScreen::new);
			MenuScreens.register(WardenCurseModMenus.LOADED_AXE_GUI.get(), LoadedAxeGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.GLOCK_GUI.get(), GlockGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.LOADED_AXE_CRAFTING.get(), LoadedAxeCraftingScreen::new);
			MenuScreens.register(WardenCurseModMenus.SPARKING_AXE_CRAFTING.get(), SparkingAxeCraftingScreen::new);
			MenuScreens.register(WardenCurseModMenus.LAZULITE_AXE_CRAFTING.get(), LazuliteAxeCraftingScreen::new);
			MenuScreens.register(WardenCurseModMenus.LOADED_SPEAR_CRAFTING.get(), LoadedSpearCraftingScreen::new);
			MenuScreens.register(WardenCurseModMenus.LEAPING_FIRE_CRAFTING.get(), LeapingFireCraftingScreen::new);
			MenuScreens.register(WardenCurseModMenus.RESSURECTION_OVERLAY.get(), RessurectionOverlayScreen::new);
			MenuScreens.register(WardenCurseModMenus.FLOATING_PASSAGE_GUI.get(), FloatingPassageGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.FIRECRACKER_CRAFTING_GUI.get(), FirecrackerCraftingGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.LONGSPARK_CRAFTING_GUI.get(), LongsparkCraftingGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.PURPLE_FUME_CRAFTING_GUI.get(), PurpleFumeCraftingGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.FLAME_VENT_CRAFT_GUI.get(), FlameVentCraftGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.ICHIMONJI_GUI.get(), IchimonjiGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.MIST_RAVEN_GUI.get(), MistRavenGUIScreen::new);
			MenuScreens.register(WardenCurseModMenus.NIGHT_JAR_GUI.get(), NightJarGUIScreen::new);
		});
	}
}
