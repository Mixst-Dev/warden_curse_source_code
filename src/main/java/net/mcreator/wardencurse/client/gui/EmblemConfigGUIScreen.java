package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.EmblemConfigGUIMenu;
import net.mcreator.wardencurse.procedures.ConfigSpiritEmblemShowProcedure;
import net.mcreator.wardencurse.network.EmblemConfigGUIButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EmblemConfigGUIScreen extends AbstractContainerScreen<EmblemConfigGUIMenu> {
	private final static HashMap<String, Object> guistate = EmblemConfigGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_a_reset;
	ImageButton imagebutton_a_minus_1;
	ImageButton imagebutton_a_plus_1;
	ImageButton imagebutton_a_plus_10;
	ImageButton imagebutton_a_minus_10;
	ImageButton imagebutton_back;

	public EmblemConfigGUIScreen(EmblemConfigGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/emblem_config_gui.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/a_posture.png"), this.leftPos + -172, this.topPos + -52, 0, 0, 168, 23, 168, 23);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/a_spiritemblems.png"), this.leftPos + -172, this.topPos + -52, 0, 0, 168, 23, 168, 23);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.emblem_config_gui.label_sekiro_config"), 15, -37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.emblem_config_gui.label_note_configs_change_globally_f"), -117, 108, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.emblem_config_gui.label_this_changes_how_powerful_combat"), 15, -24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.emblem_config_gui.label_in_this_config"), 15, -13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.emblem_config_gui.label_you_could_also_decrease_posture"), 16, -2, -12829636, false);
		guiGraphics.drawString(this.font,

				ConfigSpiritEmblemShowProcedure.execute(world), 16, 63, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_a_reset = new ImageButton(this.leftPos + -120, this.topPos + -21, 39, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_reset.png"), 39, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(0, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_reset", imagebutton_a_reset);
		this.addRenderableWidget(imagebutton_a_reset);
		imagebutton_a_minus_1 = new ImageButton(this.leftPos + -142, this.topPos + -21, 19, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_minus_1.png"), 19, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(1, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_minus_1", imagebutton_a_minus_1);
		this.addRenderableWidget(imagebutton_a_minus_1);
		imagebutton_a_plus_1 = new ImageButton(this.leftPos + -78, this.topPos + -21, 19, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_plus_1.png"), 19, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(2, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_plus_1", imagebutton_a_plus_1);
		this.addRenderableWidget(imagebutton_a_plus_1);
		imagebutton_a_plus_10 = new ImageButton(this.leftPos + -56, this.topPos + -21, 25, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_plus_10.png"), 25, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(3, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_plus_10", imagebutton_a_plus_10);
		this.addRenderableWidget(imagebutton_a_plus_10);
		imagebutton_a_minus_10 = new ImageButton(this.leftPos + -170, this.topPos + -21, 25, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_minus_10.png"), 25, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(4, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_minus_10", imagebutton_a_minus_10);
		this.addRenderableWidget(imagebutton_a_minus_10);
		imagebutton_back = new ImageButton(this.leftPos + -201, this.topPos + 77, 36, 11, 0, 0, 11, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_back.png"), 36, 22, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new EmblemConfigGUIButtonMessage(5, x, y, z));
				EmblemConfigGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_back", imagebutton_back);
		this.addRenderableWidget(imagebutton_back);
	}
}
