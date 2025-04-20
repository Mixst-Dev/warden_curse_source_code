
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

import net.mcreator.wardencurse.procedures.Abar9Procedure;
import net.mcreator.wardencurse.procedures.Abar8Procedure;
import net.mcreator.wardencurse.procedures.Abar7Procedure;
import net.mcreator.wardencurse.procedures.Abar6Procedure;
import net.mcreator.wardencurse.procedures.Abar5Procedure;
import net.mcreator.wardencurse.procedures.Abar4Procedure;
import net.mcreator.wardencurse.procedures.Abar3Procedure;
import net.mcreator.wardencurse.procedures.Abar30Procedure;
import net.mcreator.wardencurse.procedures.Abar2Procedure;
import net.mcreator.wardencurse.procedures.Abar29Procedure;
import net.mcreator.wardencurse.procedures.Abar28Procedure;
import net.mcreator.wardencurse.procedures.Abar27Procedure;
import net.mcreator.wardencurse.procedures.Abar26Procedure;
import net.mcreator.wardencurse.procedures.Abar25Procedure;
import net.mcreator.wardencurse.procedures.Abar24Procedure;
import net.mcreator.wardencurse.procedures.Abar23Procedure;
import net.mcreator.wardencurse.procedures.Abar22Procedure;
import net.mcreator.wardencurse.procedures.Abar21Procedure;
import net.mcreator.wardencurse.procedures.Abar20Procedure;
import net.mcreator.wardencurse.procedures.Abar1Procedure;
import net.mcreator.wardencurse.procedures.Abar19Procedure;
import net.mcreator.wardencurse.procedures.Abar18Procedure;
import net.mcreator.wardencurse.procedures.Abar17Procedure;
import net.mcreator.wardencurse.procedures.Abar16Procedure;
import net.mcreator.wardencurse.procedures.Abar15Procedure;
import net.mcreator.wardencurse.procedures.Abar14Procedure;
import net.mcreator.wardencurse.procedures.Abar13Procedure;
import net.mcreator.wardencurse.procedures.Abar12Procedure;
import net.mcreator.wardencurse.procedures.Abar11Procedure;
import net.mcreator.wardencurse.procedures.Abar10Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class EntityPostureShowOverlay {
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
			if (Abar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar1.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar2.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar3.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar4.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar5.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar6.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar7.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar8.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar9.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar10.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar11.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar12.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar13.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar14.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar15.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar16.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar17.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar18.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar19.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar20Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar20.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar21Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar21.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar22Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar22.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar23Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar23.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar24Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar24.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar25Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar25.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar26Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar26.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar27Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar27.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar28Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar28.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar29Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar29.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
			if (Abar30Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/abar30.png"), w / 2 + -106, 21, 0, 0, 212, 7, 212, 7);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
