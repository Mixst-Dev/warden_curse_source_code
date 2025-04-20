package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.BookfrontpageMenu;
import net.mcreator.wardencurse.network.BookfrontpageButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BookfrontpageScreen extends AbstractContainerScreen<BookfrontpageMenu> {
	private final static HashMap<String, Object> guistate = BookfrontpageMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_rightarrow;

	public BookfrontpageScreen(BookfrontpageMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/bookfrontpage.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/maincover.png"), this.leftPos + -178, this.topPos + -117, 0, 0, 356, 232, 356, 232);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_this_book_will_tell_you_how_to_d"), -153, -28, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_how_to_do_a_range_of_skills"), -152, -19, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_mechanics"), -152, -10, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_tools"), -153, -1, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_1"), -86, 76, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_2"), 82, 76, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_context"), 66, -92, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_however_this_book_wont"), -152, 8, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_cover_descriptions_of"), -152, 17, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_combart_arts_and_prosthetics"), -152, 26, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_prosthetics"), -152, 35, -15001056, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_1_guarding"), 11, -79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_23_posture"), 11, -67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_67_prosthetic_tools"), 11, -54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_8_combat_arts"), 11, -41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_9_sekiro_gui"), 11, -27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_pg_10_spirit_emblems"), 11, -14, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_additional_tips"), 11, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_check_your_keybinds_to_ensure"), 11, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_you_know_how_to_change"), 11, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.bookfrontpage.label_art_and_prosthetics"), 11, 38, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_rightarrow = new ImageButton(this.leftPos + 178, this.topPos + -28, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_rightarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new BookfrontpageButtonMessage(0, x, y, z));
				BookfrontpageButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_rightarrow", imagebutton_rightarrow);
		this.addRenderableWidget(imagebutton_rightarrow);
	}
}
