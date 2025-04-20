package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.Page3Menu;
import net.mcreator.wardencurse.network.Page3ButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Page3Screen extends AbstractContainerScreen<Page3Menu> {
	private final static HashMap<String, Object> guistate = Page3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_rightarrow;
	ImageButton imagebutton_leftarrow;

	public Page3Screen(Page3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/page_3.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/page3.png"), this.leftPos + -178, this.topPos + -117, 0, 0, 356, 232, 356, 232);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_posture_regeneration"), -133, -94, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_your_posture_heals_every_2_secon"), -157, -80, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_seconds"), -157, -72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_regenerated_depends"), -157, -63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_current_health"), -157, -54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_additional_tips_holding_guard"), -157, -41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_guard_increases"), -157, -33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_of_regeneration_by_40"), -157, -22, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_guarding_or_parrying_delays"), -158, -9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_posture_regeneration1"), -158, 0, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_being_on_fire_affects_posture"), -158, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_regeneration"), -157, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_prosthetic_tools"), 47, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_these_are_additional_tools"), 9, 1, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_to_create_a_range_of"), 9, 9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_to_deal_damage_or_break"), 9, 17, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_your_opponents_posture"), 10, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_you_can_view_your_order_by"), 10, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_prosthetics_by_opening_the"), 10, 50, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_prosthetic_items"), 10, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_next_page_for_more_info"), 28, 69, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_5"), -87, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_3.label_6"), 81, 77, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_rightarrow = new ImageButton(this.leftPos + 178, this.topPos + -26, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_rightarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Page3ButtonMessage(0, x, y, z));
				Page3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_rightarrow", imagebutton_rightarrow);
		this.addRenderableWidget(imagebutton_rightarrow);
		imagebutton_leftarrow = new ImageButton(this.leftPos + -194, this.topPos + -25, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_leftarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Page3ButtonMessage(1, x, y, z));
				Page3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_leftarrow", imagebutton_leftarrow);
		this.addRenderableWidget(imagebutton_leftarrow);
	}
}
