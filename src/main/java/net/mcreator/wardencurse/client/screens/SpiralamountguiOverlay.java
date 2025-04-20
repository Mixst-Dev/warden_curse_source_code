
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

import net.mcreator.wardencurse.procedures.Spiralamount7Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount6Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount5Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount4Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount3Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount2Procedure;
import net.mcreator.wardencurse.procedures.Spiralamount1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SpiralamountguiOverlay {
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
			if (Spiralamount1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui7.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui6.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui5.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui4.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui3.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui2.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
			if (Spiralamount7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("warden_curse:textures/screens/spiralgui1.png"), w / 2 + -20, 13, 0, 0, 40, 53, 40, 53);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
