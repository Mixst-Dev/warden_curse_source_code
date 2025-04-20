package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.ConfigMenu;
import net.mcreator.wardencurse.network.ConfigButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ConfigScreen extends AbstractContainerScreen<ConfigMenu> {
	private final static HashMap<String, Object> guistate = ConfigMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_a_combat_power;
	ImageButton imagebutton_a_posture;
	ImageButton imagebutton_a_prosthetic_power;
	ImageButton imagebutton_a_spiritemblems;
	ImageButton imagebutton_a_gameplay;

	public ConfigScreen(ConfigMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/config.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_sekiro_config"), 15, -38, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_later_updates_will_allow_you_to"), 14, -24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_peform_combat_arts_with"), 14, -14, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_toggle_guis_and_more"), 14, -3, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_suggest_config_ideas"), 14, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_try_my_best_to_add_any"), 14, 18, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.config.label_note_configs_change_globally_f"), -117, 108, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_a_combat_power = new ImageButton(this.leftPos + -203, this.topPos + -52, 168, 23, 0, 0, 23, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_combat_power.png"), 168, 46, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ConfigButtonMessage(0, x, y, z));
				ConfigButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_combat_power", imagebutton_a_combat_power);
		this.addRenderableWidget(imagebutton_a_combat_power);
		imagebutton_a_posture = new ImageButton(this.leftPos + -203, this.topPos + 2, 168, 23, 0, 0, 23, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_posture.png"), 168, 46, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ConfigButtonMessage(1, x, y, z));
				ConfigButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_posture", imagebutton_a_posture);
		this.addRenderableWidget(imagebutton_a_posture);
		imagebutton_a_prosthetic_power = new ImageButton(this.leftPos + -203, this.topPos + -25, 168, 23, 0, 0, 23, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_prosthetic_power.png"), 168, 46, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ConfigButtonMessage(2, x, y, z));
				ConfigButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_prosthetic_power", imagebutton_a_prosthetic_power);
		this.addRenderableWidget(imagebutton_a_prosthetic_power);
		imagebutton_a_spiritemblems = new ImageButton(this.leftPos + -203, this.topPos + 29, 168, 23, 0, 0, 23, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_spiritemblems.png"), 168, 46, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ConfigButtonMessage(3, x, y, z));
				ConfigButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_spiritemblems", imagebutton_a_spiritemblems);
		this.addRenderableWidget(imagebutton_a_spiritemblems);
		imagebutton_a_gameplay = new ImageButton(this.leftPos + -203, this.topPos + 56, 168, 23, 0, 0, 23, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_a_gameplay.png"), 168, 46, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ConfigButtonMessage(4, x, y, z));
				ConfigButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_a_gameplay", imagebutton_a_gameplay);
		this.addRenderableWidget(imagebutton_a_gameplay);
	}
}
