package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.GameplayConfigMenu;
import net.mcreator.wardencurse.procedures.DisplayCancelRequirementProcedure;
import net.mcreator.wardencurse.network.GameplayConfigButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GameplayConfigScreen extends AbstractContainerScreen<GameplayConfigMenu> {
	private final static HashMap<String, Object> guistate = GameplayConfigMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_a_reset;
	ImageButton imagebutton_a_on;
	ImageButton imagebutton_a_off;
	ImageButton imagebutton_back;
	ImageButton imagebutton_a_plus_1;
	ImageButton imagebutton_a_plus_01;
	ImageButton imagebutton_a_minus_1;
	ImageButton imagebutton_a_minus_01;
	ImageButton imagebutton_a_on1;
	ImageButton imagebutton_a_off1;
	ImageButton imagebutton_a_on2;
	ImageButton imagebutton_a_off2;

	public GameplayConfigScreen(GameplayConfigMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/gameplay_config.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/config4.png"), this.leftPos + -215, this.topPos + -118, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/a_gameplay.png"), this.leftPos + -172, this.topPos + -52, 0, 0, 168, 23, 168, 23);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_sekiro_config"), 15, -37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_note_configs_change_globally_f"), -117, 108, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_toggle_posture_damage"), -155, 2, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_cancel_damage_requirement"), -168, -28, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_cancel_damage_requirement1"), 15, -24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_amount_of_damage_needed_to_cance"), 15, -14, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_an_attack"), 15, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_you_could_also_toggle_attack_can"), 15, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_cancelation"), 15, 38, -12829636, false);
		guiGraphics.drawString(this.font,

				DisplayCancelRequirementProcedure.execute(world), 15, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_kusabimaru_vanilla_combat"), -166, 32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.gameplay_config.label_vanilla_fire_mechanics"), -160, 62, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_a_reset = new ImageButton(this.leftPos + -120, this.topPos + -16, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_reset.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(0, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_reset", imagebutton_a_reset);
		this.addRenderableWidget(imagebutton_a_reset);
		imagebutton_a_on = new ImageButton(this.leftPos + -144, this.topPos + 14, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_on.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(1, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_on", imagebutton_a_on);
		this.addRenderableWidget(imagebutton_a_on);
		imagebutton_a_off = new ImageButton(this.leftPos + -99, this.topPos + 14, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_off.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(2, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_off", imagebutton_a_off);
		this.addRenderableWidget(imagebutton_a_off);
		imagebutton_back = new ImageButton(this.leftPos + -201, this.topPos + 101, 36, 11, 0, 0, 11, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_back.png"), 36, 22, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(3, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_back", imagebutton_back);
		this.addRenderableWidget(imagebutton_back);
		imagebutton_a_plus_1 = new ImageButton(this.leftPos + -78, this.topPos + -16, 19, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_plus_1.png"), 19, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(4, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_plus_1", imagebutton_a_plus_1);
		this.addRenderableWidget(imagebutton_a_plus_1);
		imagebutton_a_plus_01 = new ImageButton(this.leftPos + -56, this.topPos + -16, 25, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_plus_01.png"), 25, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(5, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_plus_01", imagebutton_a_plus_01);
		this.addRenderableWidget(imagebutton_a_plus_01);
		imagebutton_a_minus_1 = new ImageButton(this.leftPos + -142, this.topPos + -16, 19, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_minus_1.png"), 19, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(6, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_minus_1", imagebutton_a_minus_1);
		this.addRenderableWidget(imagebutton_a_minus_1);
		imagebutton_a_minus_01 = new ImageButton(this.leftPos + -170, this.topPos + -16, 25, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_minus_01.png"), 25, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(7, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_minus_01", imagebutton_a_minus_01);
		this.addRenderableWidget(imagebutton_a_minus_01);
		imagebutton_a_on1 = new ImageButton(this.leftPos + -144, this.topPos + 44, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_on1.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(8, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_on1", imagebutton_a_on1);
		this.addRenderableWidget(imagebutton_a_on1);
		imagebutton_a_off1 = new ImageButton(this.leftPos + -99, this.topPos + 44, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_off1.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(9, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_off1", imagebutton_a_off1);
		this.addRenderableWidget(imagebutton_a_off1);
		imagebutton_a_on2 = new ImageButton(this.leftPos + -144, this.topPos + 74, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_on2.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(10, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_on2", imagebutton_a_on2);
		this.addRenderableWidget(imagebutton_a_on2);
		imagebutton_a_off2 = new ImageButton(this.leftPos + -99, this.topPos + 74, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_off2.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GameplayConfigButtonMessage(11, x, y, z));
				GameplayConfigButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_off2", imagebutton_a_off2);
		this.addRenderableWidget(imagebutton_a_off2);
	}
}
