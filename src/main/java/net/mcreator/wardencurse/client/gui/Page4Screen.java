package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.Page4Menu;
import net.mcreator.wardencurse.network.Page4ButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Page4Screen extends AbstractContainerScreen<Page4Menu> {
	private final static HashMap<String, Object> guistate = Page4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_rightarrow;
	ImageButton imagebutton_leftarrow;

	public Page4Screen(Page4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/page_4.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/page4.png"), this.leftPos + -178, this.topPos + -117, 0, 0, 356, 232, 356, 232);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/extras.png"), this.leftPos + 13, this.topPos + -91, 0, 0, 143, 76, 143, 76);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_to_apply_any_prosthetic_tools"), -159, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_you_need_to_press_any_of_the"), -158, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_numbers"), -158, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_the_numbers_are_the_order_you"), -159, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_youve_set_them_in"), -158, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_to_view_the_order"), -158, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_the_same_applies_to_combat_arts"), 10, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_arts"), 10, -3, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_combat_artsprosthetics"), 10, 9, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_require_spirit_emblems"), 10, 17, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_execute"), 10, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_the_items_also_provide_info"), 10, 37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_and_stats_of_the_ar"), 10, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_some_may_show"), 10, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_attacks"), 10, 65, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_7"), -87, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.page_4.label_8"), 82, 76, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_rightarrow = new ImageButton(this.leftPos + 178, this.topPos + -26, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_rightarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Page4ButtonMessage(0, x, y, z));
				Page4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_rightarrow", imagebutton_rightarrow);
		this.addRenderableWidget(imagebutton_rightarrow);
		imagebutton_leftarrow = new ImageButton(this.leftPos + -194, this.topPos + -25, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_leftarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Page4ButtonMessage(1, x, y, z));
				Page4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_leftarrow", imagebutton_leftarrow);
		this.addRenderableWidget(imagebutton_leftarrow);
	}
}
