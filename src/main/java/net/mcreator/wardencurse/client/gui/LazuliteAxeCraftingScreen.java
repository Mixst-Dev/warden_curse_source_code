package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.LazuliteAxeCraftingMenu;
import net.mcreator.wardencurse.network.LazuliteAxeCraftingButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LazuliteAxeCraftingScreen extends AbstractContainerScreen<LazuliteAxeCraftingMenu> {
	private final static HashMap<String, Object> guistate = LazuliteAxeCraftingMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_p_tool;
	ImageButton imagebutton_p_tool1;
	ImageButton imagebutton_p_tool2;
	ImageButton imagebutton_p_tool3;
	ImageButton imagebutton_p_tool4;
	ImageButton imagebutton_p_tool5;
	ImageButton imagebutton_p_tool6;
	ImageButton imagebutton_p_tool7;
	ImageButton imagebutton_p_tool8;
	ImageButton imagebutton_p_tool9;
	ImageButton imagebutton_p_tool10;
	ImageButton imagebutton_p_tool11;
	ImageButton imagebutton_p_tool12;
	ImageButton imagebutton_craft;

	public LazuliteAxeCraftingScreen(LazuliteAxeCraftingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 2;
		this.imageHeight = 2;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/lazulite_axe_crafting.png");

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

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/a_p_t.png"), this.leftPos + -212, this.topPos + -115, 0, 0, 420, 234, 420, 234);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/shinobifirec2.png"), this.leftPos + -192, this.topPos + -81, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/longspark2.png"), this.leftPos + -133, this.topPos + -81, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/purplefume2.png"), this.leftPos + -74, this.topPos + -81, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/sparkingaxe2.png"), this.leftPos + -133, this.topPos + 36, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/lazuliteaxe2.png"), this.leftPos + -74, this.topPos + 36, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/firevent3gui.png"), this.leftPos + -192, this.topPos + -42, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/lazulitevent2.png"), this.leftPos + -133, this.topPos + -42, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/cursedvent2.png"), this.leftPos + -74, this.topPos + -42, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/spear2gui.png"), this.leftPos + -192, this.topPos + -3, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/leapingspear2.png"), this.leftPos + -133, this.topPos + -3, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/shurikensgauge2.png"), this.leftPos + -192, this.topPos + 75, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/lazushuriken.png"), this.leftPos + -133, this.topPos + 75, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/loaded_axe.png"), this.leftPos + -193, this.topPos + 35, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/lazuliteaxe2.png"), this.leftPos + 115, this.topPos + -84, 0, 0, 60, 60, 60, 60);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_prosthetic_table"), -45, -111, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_prosthetic_loaded_axe"), 98, -14, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_x5_iron_scraps"), 97, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_x2_wood_planks"), 97, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_x1_axe_of_monkey"), 97, -2, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_x2_fulimated_merc"), 97, 37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_x2_prosthetic"), 97, 50, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.warden_curse.lazulite_axe_crafting.label_mechanism"), 113, 60, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_p_tool = new ImageButton(this.leftPos + -194, this.topPos + -83, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(0, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool", imagebutton_p_tool);
		this.addRenderableWidget(imagebutton_p_tool);
		imagebutton_p_tool1 = new ImageButton(this.leftPos + -135, this.topPos + -83, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool1.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(1, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool1", imagebutton_p_tool1);
		this.addRenderableWidget(imagebutton_p_tool1);
		imagebutton_p_tool2 = new ImageButton(this.leftPos + -76, this.topPos + -83, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool2.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(2, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool2", imagebutton_p_tool2);
		this.addRenderableWidget(imagebutton_p_tool2);
		imagebutton_p_tool3 = new ImageButton(this.leftPos + -194, this.topPos + -44, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool3.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(3, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool3", imagebutton_p_tool3);
		this.addRenderableWidget(imagebutton_p_tool3);
		imagebutton_p_tool4 = new ImageButton(this.leftPos + -135, this.topPos + -44, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool4.png"), 34, 68, e -> {
		});
		guistate.put("button:imagebutton_p_tool4", imagebutton_p_tool4);
		this.addRenderableWidget(imagebutton_p_tool4);
		imagebutton_p_tool5 = new ImageButton(this.leftPos + -76, this.topPos + -44, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool5.png"), 34, 68, e -> {
		});
		guistate.put("button:imagebutton_p_tool5", imagebutton_p_tool5);
		this.addRenderableWidget(imagebutton_p_tool5);
		imagebutton_p_tool6 = new ImageButton(this.leftPos + -135, this.topPos + 34, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool6.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(6, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool6", imagebutton_p_tool6);
		this.addRenderableWidget(imagebutton_p_tool6);
		imagebutton_p_tool7 = new ImageButton(this.leftPos + -76, this.topPos + 34, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool7.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(7, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool7", imagebutton_p_tool7);
		this.addRenderableWidget(imagebutton_p_tool7);
		imagebutton_p_tool8 = new ImageButton(this.leftPos + -194, this.topPos + 73, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool8.png"), 34, 68, e -> {
		});
		guistate.put("button:imagebutton_p_tool8", imagebutton_p_tool8);
		this.addRenderableWidget(imagebutton_p_tool8);
		imagebutton_p_tool9 = new ImageButton(this.leftPos + -135, this.topPos + 73, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool9.png"), 34, 68, e -> {
		});
		guistate.put("button:imagebutton_p_tool9", imagebutton_p_tool9);
		this.addRenderableWidget(imagebutton_p_tool9);
		imagebutton_p_tool10 = new ImageButton(this.leftPos + -194, this.topPos + -5, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool10.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(10, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool10", imagebutton_p_tool10);
		this.addRenderableWidget(imagebutton_p_tool10);
		imagebutton_p_tool11 = new ImageButton(this.leftPos + -135, this.topPos + -5, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool11.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(11, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool11", imagebutton_p_tool11);
		this.addRenderableWidget(imagebutton_p_tool11);
		imagebutton_p_tool12 = new ImageButton(this.leftPos + -194, this.topPos + 34, 34, 34, 0, 0, 34, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_p_tool12.png"), 34, 68, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(12, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:imagebutton_p_tool12", imagebutton_p_tool12);
		this.addRenderableWidget(imagebutton_p_tool12);
		imagebutton_craft = new ImageButton(this.leftPos + 98, this.topPos + 79, 94, 29, 0, 0, 29, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_craft.png"), 94, 58, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new LazuliteAxeCraftingButtonMessage(13, x, y, z));
				LazuliteAxeCraftingButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:imagebutton_craft", imagebutton_craft);
		this.addRenderableWidget(imagebutton_craft);
	}
}
