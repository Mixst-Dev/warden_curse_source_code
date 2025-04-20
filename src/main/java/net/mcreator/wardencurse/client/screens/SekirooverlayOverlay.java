
package net.mcreator.wardencurse.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.wardencurse.procedures.WhirlwindshowProcedure;
import net.mcreator.wardencurse.procedures.SpiralcloudpassageshowProcedure;
import net.mcreator.wardencurse.procedures.SpeardisplayProcedure;
import net.mcreator.wardencurse.procedures.SparkingaxedisplayProcedure;
import net.mcreator.wardencurse.procedures.ShurikenDisplayProcedure;
import net.mcreator.wardencurse.procedures.ShadowrushshowProcedure;
import net.mcreator.wardencurse.procedures.SekiroshowProcedure;
import net.mcreator.wardencurse.procedures.SakurashowProcedure;
import net.mcreator.wardencurse.procedures.PurpleFumeShowProcedure;
import net.mcreator.wardencurse.procedures.OnemindshowProcedure;
import net.mcreator.wardencurse.procedures.MortaldrawshowProcedure;
import net.mcreator.wardencurse.procedures.MistRavenShowProcedure;
import net.mcreator.wardencurse.procedures.LongSparkShowProcedure;
import net.mcreator.wardencurse.procedures.LoadedAxeShowProcedure;
import net.mcreator.wardencurse.procedures.LazuliteaxedisplayProcedure;
import net.mcreator.wardencurse.procedures.LazuliteVentDisplayProcedure;
import net.mcreator.wardencurse.procedures.LazuliteShurikenDisplayProcedure;
import net.mcreator.wardencurse.procedures.IchimonjiShowProcedure;
import net.mcreator.wardencurse.procedures.FloatingPassageShowProcedure;
import net.mcreator.wardencurse.procedures.FlameVentDisplayProcedure;
import net.mcreator.wardencurse.procedures.FirespeardisplayProcedure;
import net.mcreator.wardencurse.procedures.FirecrackerShowProcedure;
import net.mcreator.wardencurse.procedures.EmblemtestProcedure;
import net.mcreator.wardencurse.procedures.DragonflashProcedure;
import net.mcreator.wardencurse.procedures.CursedVentDisplayProcedure;
import net.mcreator.wardencurse.procedures.CeremonialvariableshowProcedure;
import net.mcreator.wardencurse.procedures.CeremonialToggleProcedure;
import net.mcreator.wardencurse.procedures.AshinacrossshowProcedure;
import net.mcreator.wardencurse.procedures.Artdis7Procedure;
import net.mcreator.wardencurse.procedures.Artdis6Procedure;
import net.mcreator.wardencurse.procedures.Artdis5Procedure;
import net.mcreator.wardencurse.procedures.Artdis4Procedure;
import net.mcreator.wardencurse.procedures.Artdis3Procedure;
import net.mcreator.wardencurse.procedures.Artdis2Procedure;
import net.mcreator.wardencurse.procedures.Artdis1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SekirooverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (SekiroshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/placeholder.png"), w - 44, h - 91, 0, 0, 90, 90, 90, 90);
			}
			if (ShadowrushshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/shadowrush.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (SakurashowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/sakuradance.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (AshinacrossshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/ashinacross.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (DragonflashProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/dragonflash.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (SpiralcloudpassageshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralcloudpassage.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (OnemindshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/onemind.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (MortaldrawshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/mortaldraw.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (Artdis1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon1.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon2.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon3.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon4.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon5.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon6.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (Artdis7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/articon7.png"), w - 47, h - 59, 0, 0, 46, 13, 46, 13);
			}
			if (SekiroshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/placeholder4.png"), w - 82, h - 41, 0, 0, 36, 37, 36, 37);
			}
			if (SparkingaxedisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/sparkingaxe2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (SpeardisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spear2gui.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (FirespeardisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/leapingspear2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (FlameVentDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/firevent3gui.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (LazuliteVentDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/lazulitevent2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (CursedVentDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/cursedvent2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (ShurikenDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/shurikensgauge2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (LazuliteShurikenDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/lazushuriken.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (FirecrackerShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/shinobifirec2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (LongSparkShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/longspark2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (PurpleFumeShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/purplefume2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (LazuliteaxedisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/lazuliteaxe2.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (LoadedAxeShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/loaded_axe.png"), w - 79, h - 37, 0, 0, 30, 30, 30, 30);
			}
			if (MistRavenShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/mistraven2.png"), w - 79, h - 38, 0, 0, 30, 30, 30, 30);
			}
			if (SekiroshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/frame.png"), w - 82, h - 41, 0, 0, 36, 37, 36, 37);
			}
			if (SekiroshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/emblem21.png"), w - 108, h - 25, 0, 0, 29, 29, 29, 29);
			}
			if (WhirlwindshowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/whirlwind.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (FloatingPassageShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/floatingpassagegui.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (IchimonjiShowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/ichimonji.png"), w - 45, h - 45, 0, 0, 44, 44, 44, 44);
			}
			if (SekiroshowProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						EmblemtestProcedure.execute(entity), w - 95, h - 15, -1, false);
			if (CeremonialToggleProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						CeremonialvariableshowProcedure.execute(entity), w - 100, h - 27, -52429, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
