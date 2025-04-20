
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import org.lwjgl.glfw.GLFW;

import org.checkerframework.checker.units.qual.A;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.wardencurse.network.WMessage;
import net.mcreator.wardencurse.network.UseprostheticMessage;
import net.mcreator.wardencurse.network.SwitchprostheticMessage;
import net.mcreator.wardencurse.network.SekirleapfrogMessage;
import net.mcreator.wardencurse.network.SMessage;
import net.mcreator.wardencurse.network.RegeneemblemsMessage;
import net.mcreator.wardencurse.network.KusabimaruguiopenMessage;
import net.mcreator.wardencurse.network.GuardMessage;
import net.mcreator.wardencurse.network.DashMessage;
import net.mcreator.wardencurse.network.DMessage;
import net.mcreator.wardencurse.network.ChangeartcurseMessage;
import net.mcreator.wardencurse.network.CallartMessage;
import net.mcreator.wardencurse.network.AutoParryMessage;
import net.mcreator.wardencurse.network.AMessage;
import net.mcreator.wardencurse.WardenCurseMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class WardenCurseModKeyMappings {
	public static final KeyMapping GUARD = new KeyMapping("key.warden_curse.guard", GLFW.GLFW_KEY_B, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GuardMessage(0, 0));
				GuardMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GUARD_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GUARD_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new GuardMessage(1, dt));
				GuardMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGEARTCURSE = new KeyMapping("key.warden_curse.changeartcurse", GLFW.GLFW_KEY_R, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new ChangeartcurseMessage(0, 0));
				ChangeartcurseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CALLART = new KeyMapping("key.warden_curse.callart", GLFW.GLFW_KEY_Z, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new CallartMessage(0, 0));
				CallartMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KUSABIMARUGUIOPEN = new KeyMapping("key.warden_curse.kusabimaruguiopen", GLFW.GLFW_KEY_P, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new KusabimaruguiopenMessage(0, 0));
				KusabimaruguiopenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping A = new KeyMapping("key.warden_curse.a", GLFW.GLFW_KEY_A, "key.categories.donttouch") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new AMessage(0, 0));
				AMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				A_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - A_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new AMessage(1, dt));
				AMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping S = new KeyMapping("key.warden_curse.s", GLFW.GLFW_KEY_S, "key.categories.donttouch") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SMessage(0, 0));
				SMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				S_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - S_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SMessage(1, dt));
				SMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping D = new KeyMapping("key.warden_curse.d", GLFW.GLFW_KEY_D, "key.categories.donttouch") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new DMessage(0, 0));
				DMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				D_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - D_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new DMessage(1, dt));
				DMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping W = new KeyMapping("key.warden_curse.w", GLFW.GLFW_KEY_W, "key.categories.donttouch") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new WMessage(0, 0));
				WMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				W_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - W_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new WMessage(1, dt));
				WMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DASH = new KeyMapping("key.warden_curse.dash", GLFW.GLFW_KEY_I, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new DashMessage(0, 0));
				DashMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCHPROSTHETIC = new KeyMapping("key.warden_curse.switchprosthetic", GLFW.GLFW_KEY_M, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SwitchprostheticMessage(0, 0));
				SwitchprostheticMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USEPROSTHETIC = new KeyMapping("key.warden_curse.useprosthetic", GLFW.GLFW_KEY_X, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new UseprostheticMessage(0, 0));
				UseprostheticMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping REGENEEMBLEMS = new KeyMapping("key.warden_curse.regeneemblems", GLFW.GLFW_KEY_UNKNOWN, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new RegeneemblemsMessage(0, 0));
				RegeneemblemsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				REGENEEMBLEMS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - REGENEEMBLEMS_LASTPRESS);
				WardenCurseMod.PACKET_HANDLER.sendToServer(new RegeneemblemsMessage(1, dt));
				RegeneemblemsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SEKIRLEAPFROG = new KeyMapping("key.warden_curse.sekirleapfrog", GLFW.GLFW_KEY_SPACE, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new SekirleapfrogMessage(0, 0));
				SekirleapfrogMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping AUTO_PARRY = new KeyMapping("key.warden_curse.auto_parry", GLFW.GLFW_KEY_UNKNOWN, "key.categories.sekiro") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardenCurseMod.PACKET_HANDLER.sendToServer(new AutoParryMessage(0, 0));
				AutoParryMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long GUARD_LASTPRESS = 0;
	private static long A_LASTPRESS = 0;
	private static long S_LASTPRESS = 0;
	private static long D_LASTPRESS = 0;
	private static long W_LASTPRESS = 0;
	private static long REGENEEMBLEMS_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(GUARD);
		event.register(CHANGEARTCURSE);
		event.register(CALLART);
		event.register(KUSABIMARUGUIOPEN);
		event.register(A);
		event.register(S);
		event.register(D);
		event.register(W);
		event.register(DASH);
		event.register(SWITCHPROSTHETIC);
		event.register(USEPROSTHETIC);
		event.register(REGENEEMBLEMS);
		event.register(SEKIRLEAPFROG);
		event.register(AUTO_PARRY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				GUARD.consumeClick();
				CHANGEARTCURSE.consumeClick();
				CALLART.consumeClick();
				KUSABIMARUGUIOPEN.consumeClick();
				A.consumeClick();
				S.consumeClick();
				D.consumeClick();
				W.consumeClick();
				DASH.consumeClick();
				SWITCHPROSTHETIC.consumeClick();
				USEPROSTHETIC.consumeClick();
				REGENEEMBLEMS.consumeClick();
				SEKIRLEAPFROG.consumeClick();
				AUTO_PARRY.consumeClick();
			}
		}
	}
}
