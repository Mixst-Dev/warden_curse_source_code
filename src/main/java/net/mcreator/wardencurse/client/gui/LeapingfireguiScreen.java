package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.LeapingfireguiMenu;
import net.mcreator.wardencurse.procedures.Plock7Procedure;
import net.mcreator.wardencurse.procedures.Plock6Procedure;
import net.mcreator.wardencurse.procedures.Plock5Procedure;
import net.mcreator.wardencurse.procedures.Plock4Procedure;
import net.mcreator.wardencurse.procedures.Plock3Procedure;
import net.mcreator.wardencurse.procedures.Plock2Procedure;
import net.mcreator.wardencurse.procedures.Plock1Procedure;
import net.mcreator.wardencurse.network.LeapingfireguiButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LeapingfireguiScreen extends AbstractContainerScreen<LeapingfireguiMenu> {
	private final static HashMap<String, Object> guistate = LeapingfireguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_but1;
	ImageButton imagebutton_but2;
	ImageButton imagebutton_but3;
	ImageButton imagebutton_but4;
	ImageButton imagebutton_but5;
	ImageButton imagebutton_but6;
	ImageButton imagebutton_but7;

	public LeapingfireguiScreen(LeapingfireguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 2;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/leapingfiregui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/prostheticgui2.png"), this.leftPos + -153, this.topPos + -104, 0, 0, 301, 219, 301, 219);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but1u.png"), this.leftPos + -120, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but2u.png"), this.leftPos + -84, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but3u.png"), this.leftPos + -48, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but4u.png"), this.leftPos + -12, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but5u.png"), this.leftPos + 24, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but6u.png"), this.leftPos + 60, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but7u.png"), this.leftPos + 96, this.topPos + 45, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/leapingspear2.png"), this.leftPos + -141, this.topPos + -68, 0, 0, 60, 60, 60, 60);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_type_combat_art_shadow_rush"), -142, -94, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_se_cost"), -140, -3, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_unleashes_a_powerfull_thrust"), -60, -54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_impale_your_opponent"), -60, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_description"), -60, -66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_shift_attack_slam_down_attac"), -60, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_chaning_the_dmg_to_x315"), -60, 2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_them_on_fire_dmg_x25"), -60, -34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_pkey_prosthetic_keybind"), -69, -113, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_pkey_again_pulls_enemies"), -59, -24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.leapingfiregui.label_x17_damage"), -60, 12, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_but1 = new ImageButton(this.leftPos + -120, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but1.png"), 18, 36, e -> {
			if (Plock1Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(0, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock1Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but1", imagebutton_but1);
		this.addRenderableWidget(imagebutton_but1);
		imagebutton_but2 = new ImageButton(this.leftPos + -84, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but2.png"), 18, 36, e -> {
			if (Plock2Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(1, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock2Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but2", imagebutton_but2);
		this.addRenderableWidget(imagebutton_but2);
		imagebutton_but3 = new ImageButton(this.leftPos + -48, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but3.png"), 18, 36, e -> {
			if (Plock3Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(2, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock3Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but3", imagebutton_but3);
		this.addRenderableWidget(imagebutton_but3);
		imagebutton_but4 = new ImageButton(this.leftPos + -12, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but4.png"), 18, 36, e -> {
			if (Plock4Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(3, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock4Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but4", imagebutton_but4);
		this.addRenderableWidget(imagebutton_but4);
		imagebutton_but5 = new ImageButton(this.leftPos + 24, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but5.png"), 18, 36, e -> {
			if (Plock5Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(4, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock5Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but5", imagebutton_but5);
		this.addRenderableWidget(imagebutton_but5);
		imagebutton_but6 = new ImageButton(this.leftPos + 60, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but6.png"), 18, 36, e -> {
			if (Plock6Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(5, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock6Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but6", imagebutton_but6);
		this.addRenderableWidget(imagebutton_but6);
		imagebutton_but7 = new ImageButton(this.leftPos + 96, this.topPos + 45, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but7.png"), 18, 36, e -> {
			if (Plock7Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LeapingfireguiButtonMessage(6, x, y, z));
				LeapingfireguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Plock7Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but7", imagebutton_but7);
		this.addRenderableWidget(imagebutton_but7);
	}
}
