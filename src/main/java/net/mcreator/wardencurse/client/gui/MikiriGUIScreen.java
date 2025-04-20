package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.MikiriGUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MikiriGUIScreen extends AbstractContainerScreen<MikiriGUIMenu> {
	private final static HashMap<String, Object> guistate = MikiriGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_learn_skill;

	public MikiriGUIScreen(MikiriGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 2;
		this.imageHeight = 2;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/mikiri_gui.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/mikiri.png"), this.leftPos + -154, this.topPos + -116, 0, 0, 316, 209, 316, 209);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_skill_mikiri_counter"), -48, -105, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_skill_mikiri_counter1"), -127, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_allows_you_to_counter_a_thrust_a"), -127, 1, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_on_your_enemies_weapon"), -127, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_posture_to_be_destroyed"), -127, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.mikiri_gui.label_only_applies_to_perilous_thrust"), -127, 36, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_learn_skill = Button.builder(Component.translatable("gui.warden_curse.mikiri_gui.button_learn_skill"), e -> {
		}).bounds(this.leftPos + -44, this.topPos + 89, 82, 20).build();
		guistate.put("button:button_learn_skill", button_learn_skill);
		this.addRenderableWidget(button_learn_skill);
	}
}
