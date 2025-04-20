package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.FloatingPassageGUIMenu;
import net.mcreator.wardencurse.procedures.Lock7Procedure;
import net.mcreator.wardencurse.procedures.Lock6Procedure;
import net.mcreator.wardencurse.procedures.Lock5Procedure;
import net.mcreator.wardencurse.procedures.Lock4Procedure;
import net.mcreator.wardencurse.procedures.Lock3Procedure;
import net.mcreator.wardencurse.procedures.Lock2Procedure;
import net.mcreator.wardencurse.procedures.Lock1Procedure;
import net.mcreator.wardencurse.network.FloatingPassageGUIButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FloatingPassageGUIScreen extends AbstractContainerScreen<FloatingPassageGUIMenu> {
	private final static HashMap<String, Object> guistate = FloatingPassageGUIMenu.guistate;
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

	public FloatingPassageGUIScreen(FloatingPassageGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 2;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/floating_passage_gui.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/cagui.png"), this.leftPos + -189, this.topPos + -112, 0, 0, 439, 231, 439, 231);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but1u.png"), this.leftPos + -87, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but3u.png"), this.leftPos + -15, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but2u.png"), this.leftPos + -51, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but4u.png"), this.leftPos + 21, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but5u.png"), this.leftPos + 57, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but6u.png"), this.leftPos + 93, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/but7u.png"), this.leftPos + 129, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/floatingpassagegui.png"), this.leftPos + -173, this.topPos + -72, 0, 0, 44, 44, 44, 44);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/floatingpassage.png"), this.leftPos + -105, this.topPos + -82, 0, 0, 270, 63, 270, 63);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_type_combat_art_shadow_rush"), -108, -103, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_se_cost"), -178, -22, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_dmg_multipler"), -178, -11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_unleashes_a_powerfull_thrust"), -96, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_impale_your_opponent"), -96, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_description"), -96, -9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_notes"), -178, 18, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_bestowal"), -178, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.floating_passage_gui.label_x075"), -178, 41, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_but1 = new ImageButton(this.leftPos + -87, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but1.png"), 18, 36, e -> {
			if (Lock1Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(0, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock1Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but1", imagebutton_but1);
		this.addRenderableWidget(imagebutton_but1);
		imagebutton_but2 = new ImageButton(this.leftPos + -51, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but2.png"), 18, 36, e -> {
			if (Lock2Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(1, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock2Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but2", imagebutton_but2);
		this.addRenderableWidget(imagebutton_but2);
		imagebutton_but3 = new ImageButton(this.leftPos + -15, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but3.png"), 18, 36, e -> {
			if (Lock3Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(2, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock3Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but3", imagebutton_but3);
		this.addRenderableWidget(imagebutton_but3);
		imagebutton_but4 = new ImageButton(this.leftPos + 21, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but4.png"), 18, 36, e -> {
			if (Lock4Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(3, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock4Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but4", imagebutton_but4);
		this.addRenderableWidget(imagebutton_but4);
		imagebutton_but5 = new ImageButton(this.leftPos + 57, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but5.png"), 18, 36, e -> {
			if (Lock5Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(4, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock5Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but5", imagebutton_but5);
		this.addRenderableWidget(imagebutton_but5);
		imagebutton_but6 = new ImageButton(this.leftPos + 93, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but6.png"), 18, 36, e -> {
			if (Lock6Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(5, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock6Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but6", imagebutton_but6);
		this.addRenderableWidget(imagebutton_but6);
		imagebutton_but7 = new ImageButton(this.leftPos + 129, this.topPos + 93, 18, 18, 0, 0, 18, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_but7.png"), 18, 36, e -> {
			if (Lock7Procedure.execute(entity)) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new FloatingPassageGUIButtonMessage(6, x, y, z));
				FloatingPassageGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Lock7Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_but7", imagebutton_but7);
		this.addRenderableWidget(imagebutton_but7);
	}
}
