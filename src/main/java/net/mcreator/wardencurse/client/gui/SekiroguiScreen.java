package net.mcreator.wardencurse.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wardencurse.world.inventory.SekiroguiMenu;
import net.mcreator.wardencurse.procedures.Spirit1Procedure;
import net.mcreator.wardencurse.procedures.PlayershowProcedure;
import net.mcreator.wardencurse.procedures.ConditionSelect7Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect6Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect5Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect4Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect3Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect2Procedure;
import net.mcreator.wardencurse.procedures.ConditionSelect1Procedure;
import net.mcreator.wardencurse.network.SekiroguiButtonMessage;
import net.mcreator.wardencurse.WardenCurseMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SekiroguiScreen extends AbstractContainerScreen<SekiroguiMenu> {
	private final static HashMap<String, Object> guistate = SekiroguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_close;
	ImageButton imagebutton_cross1;
	ImageButton imagebutton_cross11;
	ImageButton imagebutton_cross12;
	ImageButton imagebutton_cross13;
	ImageButton imagebutton_cross14;
	ImageButton imagebutton_cross15;
	ImageButton imagebutton_cross16;
	ImageButton imagebutton_cross17;
	ImageButton imagebutton_cross18;
	ImageButton imagebutton_cross19;
	ImageButton imagebutton_cross110;
	ImageButton imagebutton_cross111;
	ImageButton imagebutton_cross112;
	ImageButton imagebutton_cross113;
	ImageButton imagebutton_select2;
	ImageButton imagebutton_select21;
	ImageButton imagebutton_select22;
	ImageButton imagebutton_select23;
	ImageButton imagebutton_select24;
	ImageButton imagebutton_select25;
	ImageButton imagebutton_select26;

	public SekiroguiScreen(SekiroguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 41;
		this.imageHeight = 18;
	}

	private static final ResourceLocation texture = new ResourceLocation("warden_curse:textures/screens/sekirogui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (PlayershowProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 21, this.topPos + -1, 33, 0f + (float) Math.atan((this.leftPos + 21 - mouseX) / 40.0), (float) Math.atan((this.topPos + -50 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/sekirogui4.png"), this.leftPos + -198, this.topPos + -106, 0, 0, 439, 231, 439, 231);

		if (ConditionSelect1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + -84, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + -65, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + -48, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect4Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + -29, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect5Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + -12, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect6Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + 7, 0, 0, 21, 21, 21, 21);
		}
		if (ConditionSelect7Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("warden_curse:textures/screens/select3.png"), this.leftPos + -165, this.topPos + 25, 0, 0, 21, 21, 21, 21);
		}
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
		guiGraphics.drawString(this.font,

				Spirit1Procedure.execute(entity), -189, 91, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_close = new ImageButton(this.leftPos + -1, this.topPos + -107, 44, 15, 0, 0, 15, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_close.png"), 44, 30, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(0, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_close", imagebutton_close);
		this.addRenderableWidget(imagebutton_close);
		imagebutton_cross1 = new ImageButton(this.leftPos + -176, this.topPos + -77, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross1.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(1, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross1", imagebutton_cross1);
		this.addRenderableWidget(imagebutton_cross1);
		imagebutton_cross11 = new ImageButton(this.leftPos + -176, this.topPos + -59, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross11.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(2, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross11", imagebutton_cross11);
		this.addRenderableWidget(imagebutton_cross11);
		imagebutton_cross12 = new ImageButton(this.leftPos + -176, this.topPos + -41, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross12.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(3, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross12", imagebutton_cross12);
		this.addRenderableWidget(imagebutton_cross12);
		imagebutton_cross13 = new ImageButton(this.leftPos + -176, this.topPos + -23, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross13.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(4, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross13", imagebutton_cross13);
		this.addRenderableWidget(imagebutton_cross13);
		imagebutton_cross14 = new ImageButton(this.leftPos + -176, this.topPos + -5, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross14.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(5, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross14", imagebutton_cross14);
		this.addRenderableWidget(imagebutton_cross14);
		imagebutton_cross15 = new ImageButton(this.leftPos + -176, this.topPos + 13, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross15.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(6, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross15", imagebutton_cross15);
		this.addRenderableWidget(imagebutton_cross15);
		imagebutton_cross16 = new ImageButton(this.leftPos + -176, this.topPos + 31, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross16.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(7, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross16", imagebutton_cross16);
		this.addRenderableWidget(imagebutton_cross16);
		imagebutton_cross17 = new ImageButton(this.leftPos + 210, this.topPos + -77, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross17.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(8, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross17", imagebutton_cross17);
		this.addRenderableWidget(imagebutton_cross17);
		imagebutton_cross18 = new ImageButton(this.leftPos + 210, this.topPos + -59, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross18.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(9, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross18", imagebutton_cross18);
		this.addRenderableWidget(imagebutton_cross18);
		imagebutton_cross19 = new ImageButton(this.leftPos + 210, this.topPos + -41, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross19.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(10, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross19", imagebutton_cross19);
		this.addRenderableWidget(imagebutton_cross19);
		imagebutton_cross110 = new ImageButton(this.leftPos + 210, this.topPos + -23, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross110.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(11, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross110", imagebutton_cross110);
		this.addRenderableWidget(imagebutton_cross110);
		imagebutton_cross111 = new ImageButton(this.leftPos + 210, this.topPos + -5, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross111.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(12, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross111", imagebutton_cross111);
		this.addRenderableWidget(imagebutton_cross111);
		imagebutton_cross112 = new ImageButton(this.leftPos + 210, this.topPos + 13, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross112.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(13, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross112", imagebutton_cross112);
		this.addRenderableWidget(imagebutton_cross112);
		imagebutton_cross113 = new ImageButton(this.leftPos + 210, this.topPos + 31, 8, 8, 0, 0, 8, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_cross113.png"), 8, 16, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(14, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross113", imagebutton_cross113);
		this.addRenderableWidget(imagebutton_cross113);
		imagebutton_select2 = new ImageButton(this.leftPos + -164, this.topPos + -83, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select2.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(15, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select2", imagebutton_select2);
		this.addRenderableWidget(imagebutton_select2);
		imagebutton_select21 = new ImageButton(this.leftPos + -164, this.topPos + -65, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select21.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(16, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select21", imagebutton_select21);
		this.addRenderableWidget(imagebutton_select21);
		imagebutton_select22 = new ImageButton(this.leftPos + -164, this.topPos + -47, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select22.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(17, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select22", imagebutton_select22);
		this.addRenderableWidget(imagebutton_select22);
		imagebutton_select23 = new ImageButton(this.leftPos + -164, this.topPos + -29, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select23.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(18, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select23", imagebutton_select23);
		this.addRenderableWidget(imagebutton_select23);
		imagebutton_select24 = new ImageButton(this.leftPos + -164, this.topPos + -11, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select24.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(19, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select24", imagebutton_select24);
		this.addRenderableWidget(imagebutton_select24);
		imagebutton_select25 = new ImageButton(this.leftPos + -164, this.topPos + 7, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select25.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(20, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select25", imagebutton_select25);
		this.addRenderableWidget(imagebutton_select25);
		imagebutton_select26 = new ImageButton(this.leftPos + -164, this.topPos + 25, 72, 20, 0, 0, 20, new ResourceLocation("warden_curse:textures/screens/atlas/imagebutton_select26.png"), 72, 40, e -> {
			if (true) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekiroguiButtonMessage(21, x, y, z));
				SekiroguiButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		});
		guistate.put("button:imagebutton_select26", imagebutton_select26);
		this.addRenderableWidget(imagebutton_select26);
	}
}
