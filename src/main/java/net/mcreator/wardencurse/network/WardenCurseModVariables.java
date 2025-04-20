package net.mcreator.wardencurse.network;

import org.checkerframework.checker.units.qual.A;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.wardencurse.WardenCurseMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WardenCurseModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		WardenCurseMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		WardenCurseMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.guardtrigger = original.guardtrigger;
			clone.dashtrigger = original.dashtrigger;
			clone.mortalbladearts = original.mortalbladearts;
			clone.sekirotoggle = original.sekirotoggle;
			clone.shadowstate = original.shadowstate;
			clone.posturedmg = original.posturedmg;
			clone.activeguarded = original.activeguarded;
			clone.posturelimit = original.posturelimit;
			clone.sakuracount = original.sakuracount;
			clone.spiralcloudcount = original.spiralcloudcount;
			clone.ashinastate = original.ashinastate;
			clone.onemindstate = original.onemindstate;
			clone.using_elbem = original.using_elbem;
			clone.stored_elbem = original.stored_elbem;
			clone.proc_lazuliteaxe = original.proc_lazuliteaxe;
			clone.artslot1 = original.artslot1;
			clone.artslot2 = original.artslot2;
			clone.artslot3 = original.artslot3;
			clone.artslot4 = original.artslot4;
			clone.artslot5 = original.artslot5;
			clone.artslot6 = original.artslot6;
			clone.artslot7 = original.artslot7;
			clone.proslot1 = original.proslot1;
			clone.proslot2 = original.proslot2;
			clone.proslot3 = original.proslot3;
			clone.proslot4 = original.proslot4;
			clone.proslot5 = original.proslot5;
			clone.proslot6 = original.proslot6;
			clone.proslot7 = original.proslot7;
			clone.callart = original.callart;
			clone.prostheticart_num = original.prostheticart_num;
			clone.callprothetic = original.callprothetic;
			clone.mortalstate = original.mortalstate;
			clone.A = original.A;
			clone.S = original.S;
			clone.D = original.D;
			clone.W = original.W;
			clone.visual_prosthetic = original.visual_prosthetic;
			clone.regen_emblem = original.regen_emblem;
			clone.regen_emblem_process = original.regen_emblem_process;
			clone.emblem_increase = original.emblem_increase;
			clone.shadowfall = original.shadowfall;
			clone.limit_art = original.limit_art;
			clone.limit_prosthetics = original.limit_prosthetics;
			clone.overlays = original.overlays;
			clone.deathblowtoggle = original.deathblowtoggle;
			clone.max_entity_posture = original.max_entity_posture;
			clone.entity_posture = original.entity_posture;
			clone.On_Battle_State = original.On_Battle_State;
			clone.Cancel_Attack_Toggle = original.Cancel_Attack_Toggle;
			clone.Sword_Slash_Number = original.Sword_Slash_Number;
			clone.onemind = original.onemind;
			clone.Cancel_Art_Toggle = original.Cancel_Art_Toggle;
			clone.Cancel_Prosthetic_Toggle = original.Cancel_Prosthetic_Toggle;
			clone.Fire_HP = original.Fire_HP;
			clone.Skill_Mikiri = original.Skill_Mikiri;
			clone.Prevent_Cycle = original.Prevent_Cycle;
			clone.ceremol_emblem = original.ceremol_emblem;
			clone.ressurection_state = original.ressurection_state;
			clone.visual1_toggle = original.visual1_toggle;
			clone.Selected_GUI_Number = original.Selected_GUI_Number;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "warden_curse_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "warden_curse_mapvars";
		public double config_combat_power = 8.0;
		public double config_prosthetic_power = 8.0;
		public boolean config_posture_toggle = true;
		public double posture_multipler = 0.0;
		public double config_emblem_limit = 20.0;
		public double Config_Dmg_Cancel_Requirement = 4.5;
		public boolean Config_Attack_Cancel = true;
		public boolean Config_Vanilla_Combat = false;
		public boolean Config_Burn_Status = true;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			config_combat_power = nbt.getDouble("config_combat_power");
			config_prosthetic_power = nbt.getDouble("config_prosthetic_power");
			config_posture_toggle = nbt.getBoolean("config_posture_toggle");
			posture_multipler = nbt.getDouble("posture_multipler");
			config_emblem_limit = nbt.getDouble("config_emblem_limit");
			Config_Dmg_Cancel_Requirement = nbt.getDouble("Config_Dmg_Cancel_Requirement");
			Config_Attack_Cancel = nbt.getBoolean("Config_Attack_Cancel");
			Config_Vanilla_Combat = nbt.getBoolean("Config_Vanilla_Combat");
			Config_Burn_Status = nbt.getBoolean("Config_Burn_Status");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("config_combat_power", config_combat_power);
			nbt.putDouble("config_prosthetic_power", config_prosthetic_power);
			nbt.putBoolean("config_posture_toggle", config_posture_toggle);
			nbt.putDouble("posture_multipler", posture_multipler);
			nbt.putDouble("config_emblem_limit", config_emblem_limit);
			nbt.putDouble("Config_Dmg_Cancel_Requirement", Config_Dmg_Cancel_Requirement);
			nbt.putBoolean("Config_Attack_Cancel", Config_Attack_Cancel);
			nbt.putBoolean("Config_Vanilla_Combat", Config_Vanilla_Combat);
			nbt.putBoolean("Config_Burn_Status", Config_Burn_Status);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("warden_curse", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean guardtrigger = false;
		public boolean dashtrigger = false;
		public double mortalbladearts = 1.0;
		public boolean sekirotoggle = false;
		public boolean shadowstate = false;
		public double posturedmg = 0;
		public boolean activeguarded = false;
		public boolean posturelimit = false;
		public double sakuracount = 0;
		public double spiralcloudcount = 0;
		public double ashinastate = 0;
		public double onemindstate = 0;
		public double using_elbem = 0;
		public double stored_elbem = 0;
		public double proc_lazuliteaxe = 0;
		public ItemStack artslot1 = ItemStack.EMPTY;
		public ItemStack artslot2 = ItemStack.EMPTY;
		public ItemStack artslot3 = ItemStack.EMPTY;
		public ItemStack artslot4 = ItemStack.EMPTY;
		public ItemStack artslot5 = ItemStack.EMPTY;
		public ItemStack artslot6 = ItemStack.EMPTY;
		public ItemStack artslot7 = ItemStack.EMPTY;
		public ItemStack proslot1 = ItemStack.EMPTY;
		public ItemStack proslot2 = ItemStack.EMPTY;
		public ItemStack proslot3 = ItemStack.EMPTY;
		public ItemStack proslot4 = ItemStack.EMPTY;
		public ItemStack proslot5 = ItemStack.EMPTY;
		public ItemStack proslot6 = ItemStack.EMPTY;
		public ItemStack proslot7 = ItemStack.EMPTY;
		public double callart = 0;
		public double prostheticart_num = 0;
		public double callprothetic = 0;
		public boolean mortalstate = false;
		public boolean A = false;
		public boolean S = false;
		public boolean D = false;
		public boolean W = false;
		public double visual_prosthetic = 0;
		public boolean regen_emblem = false;
		public double regen_emblem_process = 0;
		public boolean emblem_increase = false;
		public boolean shadowfall = false;
		public double limit_art = 1.0;
		public double limit_prosthetics = 1.0;
		public double overlays = 0;
		public boolean deathblowtoggle = false;
		public double max_entity_posture = 0;
		public double entity_posture = 0;
		public boolean On_Battle_State = false;
		public boolean Cancel_Attack_Toggle = false;
		public double Sword_Slash_Number = 0;
		public boolean onemind = false;
		public boolean Cancel_Art_Toggle = false;
		public boolean Cancel_Prosthetic_Toggle = false;
		public double Fire_HP = 0;
		public boolean Skill_Mikiri = false;
		public boolean Prevent_Cycle = false;
		public double ceremol_emblem = 0;
		public boolean ressurection_state = false;
		public boolean visual1_toggle = false;
		public double Selected_GUI_Number = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				WardenCurseMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("guardtrigger", guardtrigger);
			nbt.putBoolean("dashtrigger", dashtrigger);
			nbt.putDouble("mortalbladearts", mortalbladearts);
			nbt.putBoolean("sekirotoggle", sekirotoggle);
			nbt.putBoolean("shadowstate", shadowstate);
			nbt.putDouble("posturedmg", posturedmg);
			nbt.putBoolean("activeguarded", activeguarded);
			nbt.putBoolean("posturelimit", posturelimit);
			nbt.putDouble("sakuracount", sakuracount);
			nbt.putDouble("spiralcloudcount", spiralcloudcount);
			nbt.putDouble("ashinastate", ashinastate);
			nbt.putDouble("onemindstate", onemindstate);
			nbt.putDouble("using_elbem", using_elbem);
			nbt.putDouble("stored_elbem", stored_elbem);
			nbt.putDouble("proc_lazuliteaxe", proc_lazuliteaxe);
			nbt.put("artslot1", artslot1.save(new CompoundTag()));
			nbt.put("artslot2", artslot2.save(new CompoundTag()));
			nbt.put("artslot3", artslot3.save(new CompoundTag()));
			nbt.put("artslot4", artslot4.save(new CompoundTag()));
			nbt.put("artslot5", artslot5.save(new CompoundTag()));
			nbt.put("artslot6", artslot6.save(new CompoundTag()));
			nbt.put("artslot7", artslot7.save(new CompoundTag()));
			nbt.put("proslot1", proslot1.save(new CompoundTag()));
			nbt.put("proslot2", proslot2.save(new CompoundTag()));
			nbt.put("proslot3", proslot3.save(new CompoundTag()));
			nbt.put("proslot4", proslot4.save(new CompoundTag()));
			nbt.put("proslot5", proslot5.save(new CompoundTag()));
			nbt.put("proslot6", proslot6.save(new CompoundTag()));
			nbt.put("proslot7", proslot7.save(new CompoundTag()));
			nbt.putDouble("callart", callart);
			nbt.putDouble("prostheticart_num", prostheticart_num);
			nbt.putDouble("callprothetic", callprothetic);
			nbt.putBoolean("mortalstate", mortalstate);
			nbt.putBoolean("A", A);
			nbt.putBoolean("S", S);
			nbt.putBoolean("D", D);
			nbt.putBoolean("W", W);
			nbt.putDouble("visual_prosthetic", visual_prosthetic);
			nbt.putBoolean("regen_emblem", regen_emblem);
			nbt.putDouble("regen_emblem_process", regen_emblem_process);
			nbt.putBoolean("emblem_increase", emblem_increase);
			nbt.putBoolean("shadowfall", shadowfall);
			nbt.putDouble("limit_art", limit_art);
			nbt.putDouble("limit_prosthetics", limit_prosthetics);
			nbt.putDouble("overlays", overlays);
			nbt.putBoolean("deathblowtoggle", deathblowtoggle);
			nbt.putDouble("max_entity_posture", max_entity_posture);
			nbt.putDouble("entity_posture", entity_posture);
			nbt.putBoolean("On_Battle_State", On_Battle_State);
			nbt.putBoolean("Cancel_Attack_Toggle", Cancel_Attack_Toggle);
			nbt.putDouble("Sword_Slash_Number", Sword_Slash_Number);
			nbt.putBoolean("onemind", onemind);
			nbt.putBoolean("Cancel_Art_Toggle", Cancel_Art_Toggle);
			nbt.putBoolean("Cancel_Prosthetic_Toggle", Cancel_Prosthetic_Toggle);
			nbt.putDouble("Fire_HP", Fire_HP);
			nbt.putBoolean("Skill_Mikiri", Skill_Mikiri);
			nbt.putBoolean("Prevent_Cycle", Prevent_Cycle);
			nbt.putDouble("ceremol_emblem", ceremol_emblem);
			nbt.putBoolean("ressurection_state", ressurection_state);
			nbt.putBoolean("visual1_toggle", visual1_toggle);
			nbt.putDouble("Selected_GUI_Number", Selected_GUI_Number);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			guardtrigger = nbt.getBoolean("guardtrigger");
			dashtrigger = nbt.getBoolean("dashtrigger");
			mortalbladearts = nbt.getDouble("mortalbladearts");
			sekirotoggle = nbt.getBoolean("sekirotoggle");
			shadowstate = nbt.getBoolean("shadowstate");
			posturedmg = nbt.getDouble("posturedmg");
			activeguarded = nbt.getBoolean("activeguarded");
			posturelimit = nbt.getBoolean("posturelimit");
			sakuracount = nbt.getDouble("sakuracount");
			spiralcloudcount = nbt.getDouble("spiralcloudcount");
			ashinastate = nbt.getDouble("ashinastate");
			onemindstate = nbt.getDouble("onemindstate");
			using_elbem = nbt.getDouble("using_elbem");
			stored_elbem = nbt.getDouble("stored_elbem");
			proc_lazuliteaxe = nbt.getDouble("proc_lazuliteaxe");
			artslot1 = ItemStack.of(nbt.getCompound("artslot1"));
			artslot2 = ItemStack.of(nbt.getCompound("artslot2"));
			artslot3 = ItemStack.of(nbt.getCompound("artslot3"));
			artslot4 = ItemStack.of(nbt.getCompound("artslot4"));
			artslot5 = ItemStack.of(nbt.getCompound("artslot5"));
			artslot6 = ItemStack.of(nbt.getCompound("artslot6"));
			artslot7 = ItemStack.of(nbt.getCompound("artslot7"));
			proslot1 = ItemStack.of(nbt.getCompound("proslot1"));
			proslot2 = ItemStack.of(nbt.getCompound("proslot2"));
			proslot3 = ItemStack.of(nbt.getCompound("proslot3"));
			proslot4 = ItemStack.of(nbt.getCompound("proslot4"));
			proslot5 = ItemStack.of(nbt.getCompound("proslot5"));
			proslot6 = ItemStack.of(nbt.getCompound("proslot6"));
			proslot7 = ItemStack.of(nbt.getCompound("proslot7"));
			callart = nbt.getDouble("callart");
			prostheticart_num = nbt.getDouble("prostheticart_num");
			callprothetic = nbt.getDouble("callprothetic");
			mortalstate = nbt.getBoolean("mortalstate");
			A = nbt.getBoolean("A");
			S = nbt.getBoolean("S");
			D = nbt.getBoolean("D");
			W = nbt.getBoolean("W");
			visual_prosthetic = nbt.getDouble("visual_prosthetic");
			regen_emblem = nbt.getBoolean("regen_emblem");
			regen_emblem_process = nbt.getDouble("regen_emblem_process");
			emblem_increase = nbt.getBoolean("emblem_increase");
			shadowfall = nbt.getBoolean("shadowfall");
			limit_art = nbt.getDouble("limit_art");
			limit_prosthetics = nbt.getDouble("limit_prosthetics");
			overlays = nbt.getDouble("overlays");
			deathblowtoggle = nbt.getBoolean("deathblowtoggle");
			max_entity_posture = nbt.getDouble("max_entity_posture");
			entity_posture = nbt.getDouble("entity_posture");
			On_Battle_State = nbt.getBoolean("On_Battle_State");
			Cancel_Attack_Toggle = nbt.getBoolean("Cancel_Attack_Toggle");
			Sword_Slash_Number = nbt.getDouble("Sword_Slash_Number");
			onemind = nbt.getBoolean("onemind");
			Cancel_Art_Toggle = nbt.getBoolean("Cancel_Art_Toggle");
			Cancel_Prosthetic_Toggle = nbt.getBoolean("Cancel_Prosthetic_Toggle");
			Fire_HP = nbt.getDouble("Fire_HP");
			Skill_Mikiri = nbt.getBoolean("Skill_Mikiri");
			Prevent_Cycle = nbt.getBoolean("Prevent_Cycle");
			ceremol_emblem = nbt.getDouble("ceremol_emblem");
			ressurection_state = nbt.getBoolean("ressurection_state");
			visual1_toggle = nbt.getBoolean("visual1_toggle");
			Selected_GUI_Number = nbt.getDouble("Selected_GUI_Number");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.guardtrigger = message.data.guardtrigger;
					variables.dashtrigger = message.data.dashtrigger;
					variables.mortalbladearts = message.data.mortalbladearts;
					variables.sekirotoggle = message.data.sekirotoggle;
					variables.shadowstate = message.data.shadowstate;
					variables.posturedmg = message.data.posturedmg;
					variables.activeguarded = message.data.activeguarded;
					variables.posturelimit = message.data.posturelimit;
					variables.sakuracount = message.data.sakuracount;
					variables.spiralcloudcount = message.data.spiralcloudcount;
					variables.ashinastate = message.data.ashinastate;
					variables.onemindstate = message.data.onemindstate;
					variables.using_elbem = message.data.using_elbem;
					variables.stored_elbem = message.data.stored_elbem;
					variables.proc_lazuliteaxe = message.data.proc_lazuliteaxe;
					variables.artslot1 = message.data.artslot1;
					variables.artslot2 = message.data.artslot2;
					variables.artslot3 = message.data.artslot3;
					variables.artslot4 = message.data.artslot4;
					variables.artslot5 = message.data.artslot5;
					variables.artslot6 = message.data.artslot6;
					variables.artslot7 = message.data.artslot7;
					variables.proslot1 = message.data.proslot1;
					variables.proslot2 = message.data.proslot2;
					variables.proslot3 = message.data.proslot3;
					variables.proslot4 = message.data.proslot4;
					variables.proslot5 = message.data.proslot5;
					variables.proslot6 = message.data.proslot6;
					variables.proslot7 = message.data.proslot7;
					variables.callart = message.data.callart;
					variables.prostheticart_num = message.data.prostheticart_num;
					variables.callprothetic = message.data.callprothetic;
					variables.mortalstate = message.data.mortalstate;
					variables.A = message.data.A;
					variables.S = message.data.S;
					variables.D = message.data.D;
					variables.W = message.data.W;
					variables.visual_prosthetic = message.data.visual_prosthetic;
					variables.regen_emblem = message.data.regen_emblem;
					variables.regen_emblem_process = message.data.regen_emblem_process;
					variables.emblem_increase = message.data.emblem_increase;
					variables.shadowfall = message.data.shadowfall;
					variables.limit_art = message.data.limit_art;
					variables.limit_prosthetics = message.data.limit_prosthetics;
					variables.overlays = message.data.overlays;
					variables.deathblowtoggle = message.data.deathblowtoggle;
					variables.max_entity_posture = message.data.max_entity_posture;
					variables.entity_posture = message.data.entity_posture;
					variables.On_Battle_State = message.data.On_Battle_State;
					variables.Cancel_Attack_Toggle = message.data.Cancel_Attack_Toggle;
					variables.Sword_Slash_Number = message.data.Sword_Slash_Number;
					variables.onemind = message.data.onemind;
					variables.Cancel_Art_Toggle = message.data.Cancel_Art_Toggle;
					variables.Cancel_Prosthetic_Toggle = message.data.Cancel_Prosthetic_Toggle;
					variables.Fire_HP = message.data.Fire_HP;
					variables.Skill_Mikiri = message.data.Skill_Mikiri;
					variables.Prevent_Cycle = message.data.Prevent_Cycle;
					variables.ceremol_emblem = message.data.ceremol_emblem;
					variables.ressurection_state = message.data.ressurection_state;
					variables.visual1_toggle = message.data.visual1_toggle;
					variables.Selected_GUI_Number = message.data.Selected_GUI_Number;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
