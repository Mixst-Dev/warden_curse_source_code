package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.Guardpage2Menu;
import net.mcreator.wardencurse.network.Guardpage2ButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Guardpage2Screen extends AbstractContainerScreen<Guardpage2Menu> {
	private final static HashMap<String, Object> guistate = Guardpage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_rightarrow;
	ImageButton imagebutton_leftarrow;

	public Guardpage2Screen(Guardpage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/guardpage_2.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/guardpage.png"), this.leftPos + -178, this.topPos + -117, 0, 0, 356, 232, 356, 232);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_guarding"), -105, 0, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_when_the_guard_keybind_is_pres"), -153, 13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_pressed_you_can_guard_attacks"), -153, 22, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_attacks"), -153, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_the_guarding_properly"), -154, 41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_you_deflect_instead"), -153, 51, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_posture_mechanics"), 43, -94, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_posture_is_the_souls_of"), 11, -79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_have_if_you_take_damage"), 11, -70, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_when_your_posture_is_at_max"), 11, -61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_your_posture_breaks"), 11, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_prevents_the_player_from"), 11, -43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_guarding_the_stats_are"), 11, -33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_generic_damage_x4_posture_dmg"), 10, -19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_deflect_x3_posturedmg"), 10, -10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_guarding_x2_posturedmg"), 10, -2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_3"), -86, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_4"), 81, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_extra_notes"), 10, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_parrying_never_breaks_posture"), 10, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_breaking_enemies_posture"), 10, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_can_allow_you_to_deathblow"), 10, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_you_cannot_parry"), 10, 65, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_attacks1"), 11, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.guardpage_2.label_note_parrying_and_deflecting_ar"), -130, 109, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_rightarrow = new ImageButton(this.leftPos + 178, this.topPos + -26, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_rightarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Guardpage2ButtonMessage(0, x, y, z));
				Guardpage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_rightarrow", imagebutton_rightarrow);
		this.addRenderableWidget(imagebutton_rightarrow);
		imagebutton_leftarrow = new ImageButton(this.leftPos + -194, this.topPos + -25, 16, 54, 0, 0, 54, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_leftarrow.png"), 16, 108, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new Guardpage2ButtonMessage(1, x, y, z));
				Guardpage2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_leftarrow", imagebutton_leftarrow);
		this.addRenderableWidget(imagebutton_leftarrow);
	}
}
