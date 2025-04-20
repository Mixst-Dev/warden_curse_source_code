package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.Page5Menu;
import net.mcreator.wardencurse.network.Page5ButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Page5Screen extends AbstractContainerScreen<Page5Menu> {
	private final static HashMap<String, Object> guistate = Page5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_leftarrow;

	public Page5Screen(Page5Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/page_5.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/page5.png"), this.leftPos + -178, this.topPos + -117, 0, 0, 356, 232, 356, 232);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_this_gui_shows_your"), -156, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_of_artsprosthetics"), -156, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_your_stored_spirit_emblems"), -156, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_you_dont_put_items_there"), -157, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_the_right_side_are_the"), -156, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_combat_arts"), -156, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_the_left_side_are_the"), -156, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_prosthetic_tools"), -156, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_spirit_emblems"), 49, -94, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_spirit_emblems_are_important"), 10, -78, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_as_they_are_used_to_execute"), 10, -70, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_combat_arts_or_prosthetics"), 10, -62, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_monster_entities_have_a"), 10, -50, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_50_of_dropping_one_upon_death"), 10, -42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_regenerating_spirit_emblems"), 10, -26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_is_done_by_holding_the"), 10, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_regenerate_emblems"), 10, -7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_holding_it_for_5_seconds_will"), 10, 2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_without_taking_damage_will"), 11, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_regenerate_your_30_emblems_back"), 10, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_back"), 11, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_9"), -87, 77, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_5.label_10"), 78, 76, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_leftarrow = new ImageButton(this.leftPos + -194, this.topPos + -25, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_leftarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Page5ButtonMessage(0, x, y, z));
				Page5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_leftarrow", imagebutton_leftarrow);
		this.addRenderableWidget(imagebutton_leftarrow);
	}
}
