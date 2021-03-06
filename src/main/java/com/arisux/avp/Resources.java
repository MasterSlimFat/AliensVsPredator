package com.arisux.avp;

import com.arisux.airi.AIRI;
import com.arisux.airi.api.wavefrontapi.WavefrontModel;
import com.arisux.airi.lib.interfaces.IInitializablePre;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class Resources implements IInitializablePre
{
	public static final Resources instance = new Resources();

	public final ResourceLocation _88MOD4 = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/88mod4.png");
	public final ResourceLocation FLAMETHROWER_NOSTROMO = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/flamethrower.nostromo.png");
	public final ResourceLocation ENGINEER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/engineer_bio.png");
	public final ResourceLocation YAUTJA_BERSERKER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/yautja_berserker.png");
	public final ResourceLocation LOCKER = new ResourceLocation(AliensVsPredator.ID, "textures/tile/locker.png");
	public final ResourceLocation GUN_LOCKER = new ResourceLocation(AliensVsPredator.ID, "textures/tile/gunlocker.png");
	public final ResourceLocation SPACE_JOCKEY = new ResourceLocation(AliensVsPredator.ID, "textures/mob/engineer.png");
	public final ResourceLocation AMPULE = new ResourceLocation(AliensVsPredator.ID, "textures/tile/ampule.png");
	public final ResourceLocation TRANSFORMER = new ResourceLocation(AliensVsPredator.ID, "textures/tile/transformer.png");
	public final ResourceLocation SOLAR_PANEL = new ResourceLocation(AliensVsPredator.ID, "textures/tile/solarpanel.png");
	public final ResourceLocation POWERCELL = new ResourceLocation(AliensVsPredator.ID, "textures/tile/powercell.png");
	public final ResourceLocation POWERCELL_LIQUID = new ResourceLocation(AliensVsPredator.ID, "textures/tile/powercellliquid.png");
	public final ResourceLocation SKY_RAIN = new ResourceLocation("textures/environment/rain.png");
	public final ResourceLocation SKY_CLOUDS = new ResourceLocation("textures/environment/clouds.png");
	public final ResourceLocation SKY_VARDA_CLOUDS = new ResourceLocation(AliensVsPredator.ID, "textures/misc/varda-clouds.png");
	public final ResourceLocation SKY_SILICA = new ResourceLocation(AliensVsPredator.ID, "textures/misc/silica.png");
	public final ResourceLocation SKY_SUN = new ResourceLocation("textures/environment/sun.png");
	public final ResourceLocation SKY_CALPAMOS = new ResourceLocation(AliensVsPredator.ID, "textures/misc/calpamos.png");
	public final ResourceLocation DRONE_BASIC = new ResourceLocation(AliensVsPredator.ID, "textures/mob/drone_basic.png");
	public final ResourceLocation DRONE_ADVANCED = new ResourceLocation(AliensVsPredator.ID, "textures/mob/drone_advanced.png");
	public final ResourceLocation TITANIUM1 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/titanium_1.png");
	public final ResourceLocation TITANIUM2 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/titanium_2.png");
	public final ResourceLocation PRESSURESUIT1 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/suit_1.png");
	public final ResourceLocation PRESSURESUIT2 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/suit_2.png");
	public final ResourceLocation XENO1 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/xeno_1.png");
	public final ResourceLocation XENO2 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/xeno_2.png");
	public final ResourceLocation MARINE1 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/marine_1.png");
	public final ResourceLocation MARINE2 = new ResourceLocation(AliensVsPredator.ID, "textures/armor/marine_2.png");
	public final ResourceLocation BULLET = new ResourceLocation(AliensVsPredator.ID, "textures/misc/renderbullet.png");
	public final ResourceLocation SPEAR = new ResourceLocation(AliensVsPredator.ID, "textures/misc/renderspear.png");
	public final ResourceLocation ACID_POOL = new ResourceLocation(AliensVsPredator.ID, "textures/misc/renderacid.png");
	public final ResourceLocation DISC = new ResourceLocation(AliensVsPredator.ID, "textures/misc/disc.png");
	public final ResourceLocation SHURIKEN = new ResourceLocation(AliensVsPredator.ID, "textures/misc/shuriken.png");
	public final ResourceLocation BLUR_CELTIC_HUD = new ResourceLocation(AliensVsPredator.ID, "textures/misc/celtic-helm-overlay.png");
	public final ResourceLocation BLUR_TACTICAL_HUD = new ResourceLocation(AliensVsPredator.ID, "textures/misc/marine-helm-overlay.png");
	public final ResourceLocation BLUR_FACEHUGGER = new ResourceLocation(AliensVsPredator.ID, "textures/misc/facehugger.png");
	public final ResourceLocation BLUR_CHESTBURSTER_EMERGE = new ResourceLocation(AliensVsPredator.ID, "textures/misc/chestburster-emerge-overlay.png");
	public final ResourceLocation BATTERY_INDICATOR = new ResourceLocation(AliensVsPredator.ID, "textures/misc/battery-indicator.png");
	public final ResourceLocation INFECTION_INDICATOR = new ResourceLocation(AliensVsPredator.ID, "textures/misc/infection-indicator.png");
	public final ResourceLocation BLUR_GUNSCOPE = new ResourceLocation(AliensVsPredator.ID, "textures/misc/scope.png");
	public final ResourceLocation PROXIMITY_MINE = new ResourceLocation(AliensVsPredator.ID, "textures/misc/proximity-mine.png");
	public final ResourceLocation WRISTBLADES = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/wristblade.png");
	public final ResourceLocation M240ICU = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/m240icu.png");
	public final ResourceLocation M41A = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/pulserifle.png");
	public final ResourceLocation M56SG = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/m56sg.png");
	public final ResourceLocation AK47 = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/ak-47.png");
	public final ResourceLocation M4 = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/m4.png");
	public final ResourceLocation SNIPER = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/sniper.png");
	public final ResourceLocation M40GRENADE = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/m40.png");
	public final ResourceLocation M40GRENADE_INCENDIARY = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/m40incendiary.png");
	public final ResourceLocation MOTIONTRACKER = new ResourceLocation(AliensVsPredator.ID, "textures/items/models/motiontracker.png");
	public final ResourceLocation TURRET = new ResourceLocation(AliensVsPredator.ID, "textures/tile/turret.png");
	public final ResourceLocation WORKSTATION = new ResourceLocation(AliensVsPredator.ID, "textures/tile/workstation.png");
	public final ResourceLocation WORKSTATION_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/tile/workstation-on.png");
	public final ResourceLocation LIGHT_PANEL = new ResourceLocation(AliensVsPredator.ID, "textures/tile/lightpanel.png");
	public final ResourceLocation CRYOSTASIS_TUBE = new ResourceLocation(AliensVsPredator.ID, "textures/tile/cryostasistube.png");
	public final ResourceLocation CRYOSTASIS_TUBE_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/tile/cryostasistube-mask.png");
	public final ResourceLocation CRYOSTASIS_TUBE_MASK_CRACKED = new ResourceLocation(AliensVsPredator.ID, "textures/tile/cryostasistube-cracked-mask.png");
	public final ResourceLocation CRYOSTASIS_TUBE_MASK_SHATTERED = new ResourceLocation(AliensVsPredator.ID, "textures/tile/cryostasistube-shattered-mask.png");
	public final ResourceLocation STASIS_MECHANISM = new ResourceLocation(AliensVsPredator.ID, "textures/tile/stasis-mechanism.png");
	public final ResourceLocation STASIS_MECHANISM_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/tile/stasis-mechanism-mask.png");
	public final ResourceLocation REPULSION_GENERATOR = new ResourceLocation(AliensVsPredator.ID, "textures/tile/generator.png");
	public final ResourceLocation CABLE = new ResourceLocation(AliensVsPredator.ID, "textures/tile/cable.png");
	public final ResourceLocation NETWORKLIGHT = new ResourceLocation(AliensVsPredator.ID, "textures/tile/networklight.png");
	public final ResourceLocation SERVER = new ResourceLocation(AliensVsPredator.ID, "textures/tile/server.png");
	public final ResourceLocation BLASTDOOR = new ResourceLocation(AliensVsPredator.ID, "textures/tile/blastdoor.png");
	public final ResourceLocation WORKLIGHT = new ResourceLocation(AliensVsPredator.ID, "textures/tile/worklight.png");
	public final ResourceLocation CHESTBUSTER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/chestbuster.png");
	public final ResourceLocation FACEHUGGER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/facehugger.png");
	public final ResourceLocation ROYALFACEHUGGER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/royalfacehugger.png");
	public final ResourceLocation MARINE = new ResourceLocation(AliensVsPredator.ID, "textures/mob/marine.png");
	public final ResourceLocation OVAMORPH = new ResourceLocation(AliensVsPredator.ID, "textures/mob/alienegg.png");
	public final ResourceLocation PREDALIEN = new ResourceLocation(AliensVsPredator.ID, "textures/mob/predalien.png");
	public final ResourceLocation PRAETORIAN = new ResourceLocation(AliensVsPredator.ID, "textures/mob/praetorian.png");
	public final ResourceLocation WARRIOR = new ResourceLocation(AliensVsPredator.ID, "textures/mob/warrior.png");
	public final ResourceLocation WARRIOR_BLOOD = new ResourceLocation(AliensVsPredator.ID, "textures/mob/warrior_blood.png");
	public final ResourceLocation DRONE_BASIC_BLOOD = new ResourceLocation(AliensVsPredator.ID, "textures/mob/drone_basic_blood.png");
	public final ResourceLocation DRONE_ADVANCED_BLOOD = new ResourceLocation(AliensVsPredator.ID, "textures/mob/drone_advanced_blood.png");
	public final ResourceLocation HAMMERPEDE = new ResourceLocation(AliensVsPredator.ID, "textures/mob/hammerpede.png");
	public final ResourceLocation TRILOBITE = new ResourceLocation(AliensVsPredator.ID, "textures/mob/trilobite.png");
	public final ResourceLocation PROTOMORPH = new ResourceLocation(AliensVsPredator.ID, "textures/mob/deacon.png");
	public final ResourceLocation AQUA_XENOMORPH = new ResourceLocation(AliensVsPredator.ID, "textures/mob/aqua.png");
	public final ResourceLocation AQUA_XENOMORPH_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/mob/aqua_glow.png");
	public final ResourceLocation XENOQUEEN = new ResourceLocation(AliensVsPredator.ID, "textures/mob/queen.png");
	public final ResourceLocation XENOQUEEN_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/mob/queen_mask.png");
	public final ResourceLocation YAUTJA = new ResourceLocation(AliensVsPredator.ID, "textures/mob/yautja.png");
	public final ResourceLocation SPITTER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/spitter.png");
	public final ResourceLocation SPITTER_MASK = new ResourceLocation(AliensVsPredator.ID, "textures/mob/spitter_glow.png");
	public final ResourceLocation CRUSHER = new ResourceLocation(AliensVsPredator.ID, "textures/mob/crusher.png");
	public final ResourceLocation COMBAT_SYNTHETIC = new ResourceLocation(AliensVsPredator.ID, "textures/mob/combat_synthetic.png");
	public final ResourceLocation HIVE_NODE = new ResourceLocation(AliensVsPredator.ID, "textures/tile/node.png");
	public final ResourceLocation GUI_BASIC = new ResourceLocation(AliensVsPredator.ID, "textures/gui/background.png");
	public final ResourceLocation GUI_TURRET = new ResourceLocation(AliensVsPredator.ID, "textures/gui/turret.png");
	public final ResourceLocation GUI_WRISTBRACER = new ResourceLocation(AliensVsPredator.ID, "textures/gui/wristbracer.png");
	public final ResourceLocation GUI_LOCKER = new ResourceLocation(AliensVsPredator.ID, "textures/gui/locker.png");
	public final ResourceLocation ICON_AMMO = new ResourceLocation(AliensVsPredator.ID, "textures/misc/icon-ammo.png");
	public final ResourceLocation MOTIONTRACKER_BG = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/background.png");
	public final ResourceLocation MOTIONTRACKER_FG = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/foreground.png");
	public final ResourceLocation MOTIONTRACKER_PING = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/ping.png");
	public final ResourceLocation MOTIONTRACKER_S1 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep1.png");
	public final ResourceLocation MOTIONTRACKER_S2 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep2.png");
	public final ResourceLocation MOTIONTRACKER_S3 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep3.png");
	public final ResourceLocation MOTIONTRACKER_S4 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep4.png");
	public final ResourceLocation MOTIONTRACKER_S5 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep5.png");
	public final ResourceLocation MOTIONTRACKER_S6 = new ResourceLocation(AliensVsPredator.ID, "textures/misc/motiontracker/sweep6.png");
	public final ResourceLocation QUEEN_BOSS_BAR = new ResourceLocation(AliensVsPredator.ID, "textures/misc/queenbossbar.png");

	public WavefrontModel M577_APC;
	
	@Override
	public void preInitialize(FMLPreInitializationEvent event) 
	{
		M577_APC = AIRI.wavefrontAPI().loadModel(AliensVsPredator.class, AliensVsPredator.ID, "m577apc", "/assets/avp/models/m577apc");
	}
}
