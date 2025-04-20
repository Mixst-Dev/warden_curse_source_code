
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

import net.mcreator.wardencurse.procedures.Pbar9Procedure;
import net.mcreator.wardencurse.procedures.Pbar8Procedure;
import net.mcreator.wardencurse.procedures.Pbar7Procedure;
import net.mcreator.wardencurse.procedures.Pbar6Procedure;
import net.mcreator.wardencurse.procedures.Pbar5Procedure;
import net.mcreator.wardencurse.procedures.Pbar4Procedure;
import net.mcreator.wardencurse.procedures.Pbar3Procedure;
import net.mcreator.wardencurse.procedures.Pbar2Procedure;
import net.mcreator.wardencurse.procedures.Pbar20Procedure;
import net.mcreator.wardencurse.procedures.Pbar1Procedure;
import net.mcreator.wardencurse.procedures.Pbar19Procedure;
import net.mcreator.wardencurse.procedures.Pbar18Procedure;
import net.mcreator.wardencurse.procedures.Pbar17Procedure;
import net.mcreator.wardencurse.procedures.Pbar16Procedure;
import net.mcreator.wardencurse.procedures.Pbar15Procedure;
import net.mcreator.wardencurse.procedures.Pbar14Procedure;
import net.mcreator.wardencurse.procedures.Pbar13Procedure;
import net.mcreator.wardencurse.procedures.Pbar12Procedure;
import net.mcreator.wardencurse.procedures.Pbar11Procedure;
import net.mcreator.wardencurse.procedures.Pbar10Procedure;
import net.mcreator.wardencurse.procedures.Fbar9Procedure;
import net.mcreator.wardencurse.procedures.Fbar8Procedure;
import net.mcreator.wardencurse.procedures.Fbar7Procedure;
import net.mcreator.wardencurse.procedures.Fbar6Procedure;
import net.mcreator.wardencurse.procedures.Fbar5Procedure;
import net.mcreator.wardencurse.procedures.Fbar4Procedure;
import net.mcreator.wardencurse.procedures.Fbar3Procedure;
import net.mcreator.wardencurse.procedures.Fbar2Procedure;
import net.mcreator.wardencurse.procedures.Fbar1Procedure;
import net.mcreator.wardencurse.procedures.Fbar19Procedure;
import net.mcreator.wardencurse.procedures.Fbar18Procedure;
import net.mcreator.wardencurse.procedures.Fbar17Procedure;
import net.mcreator.wardencurse.procedures.Fbar16Procedure;
import net.mcreator.wardencurse.procedures.Fbar15Procedure;
import net.mcreator.wardencurse.procedures.Fbar14Procedure;
import net.mcreator.wardencurse.procedures.Fbar13Procedure;
import net.mcreator.wardencurse.procedures.Fbar12Procedure;
import net.mcreator.wardencurse.procedures.Fbar11Procedure;
import net.mcreator.wardencurse.procedures.Fbar10Procedure;
import net.mcreator.wardencurse.procedures.BurnguishowProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PostureOverlay {
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
			if (Pbar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar1.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar2.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar3.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar4.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar5.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar6.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar7.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar8.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar9.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar10.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar11.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar12.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar13.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar14.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar15.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar16.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar17.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar18.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar19.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Pbar20Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/bar20.png"), w / 2 + -75, h - 67, 0, 0, 150, 7, 150, 7);
			}
			if (Fbar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar1.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar2.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar3.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar4.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar5.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar6.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar7.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar8.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar9.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar10.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar11.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar12.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar13.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar14.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar15.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar16.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar17.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar18.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (Fbar19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbar19.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
			if (BurnguishowProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/fbarowies.png"), w / 2 + -60, h - 90, 0, 0, 126, 17, 126, 17);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
