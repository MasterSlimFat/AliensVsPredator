package com.arisux.avp;

import static cpw.mods.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;
import static cpw.mods.fml.client.registry.RenderingRegistry.registerBlockHandler;
import static cpw.mods.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;
import static net.minecraftforge.client.MinecraftForgeClient.registerItemRenderer;

import com.arisux.airi.lib.client.ModelBipedExtension;
import com.arisux.airi.lib.client.ModelTexMap;
import com.arisux.airi.lib.interfaces.IInitializablePost;
import com.arisux.airi.lib.interfaces.IInitializablePre;
import com.arisux.avp.block.render.RenderShape;
import com.arisux.avp.entities.EntityAPC;
import com.arisux.avp.entities.EntityAcidPool;
import com.arisux.avp.entities.EntityAcidProjectile;
import com.arisux.avp.entities.EntityBullet;
import com.arisux.avp.entities.EntityFlame;
import com.arisux.avp.entities.EntityGrenade;
import com.arisux.avp.entities.EntityLaserMine;
import com.arisux.avp.entities.EntityMechanism;
import com.arisux.avp.entities.EntityNuke;
import com.arisux.avp.entities.EntityPlasma;
import com.arisux.avp.entities.EntityShuriken;
import com.arisux.avp.entities.EntitySmartDisc;
import com.arisux.avp.entities.EntitySpear;
import com.arisux.avp.entities.mob.EntityAqua;
import com.arisux.avp.entities.mob.EntityChestburster;
import com.arisux.avp.entities.mob.EntityCombatSynthetic;
import com.arisux.avp.entities.mob.EntityCrusher;
import com.arisux.avp.entities.mob.EntityDrone;
import com.arisux.avp.entities.mob.EntityEngineer;
import com.arisux.avp.entities.mob.EntityFacehugger;
import com.arisux.avp.entities.mob.EntityHammerpede;
import com.arisux.avp.entities.mob.EntityMarine;
import com.arisux.avp.entities.mob.EntityOvamorph;
import com.arisux.avp.entities.mob.EntityPraetorian;
import com.arisux.avp.entities.mob.EntityPredalien;
import com.arisux.avp.entities.mob.EntityProtomorph;
import com.arisux.avp.entities.mob.EntityQueen;
import com.arisux.avp.entities.mob.EntityRoyalFacehugger;
import com.arisux.avp.entities.mob.EntitySpaceJockey;
import com.arisux.avp.entities.mob.EntitySpitter;
import com.arisux.avp.entities.mob.EntityTrilobite;
import com.arisux.avp.entities.mob.EntityWarrior;
import com.arisux.avp.entities.mob.EntityYautja;
import com.arisux.avp.entities.mob.EntityYautjaBerserker;
import com.arisux.avp.entities.mob.model.ModelAqua;
import com.arisux.avp.entities.mob.model.ModelChestburster;
import com.arisux.avp.entities.mob.model.ModelCrusher;
import com.arisux.avp.entities.mob.model.ModelDrone;
import com.arisux.avp.entities.mob.model.ModelEngineer;
import com.arisux.avp.entities.mob.model.ModelFacehugger;
import com.arisux.avp.entities.mob.model.ModelHammerpede;
import com.arisux.avp.entities.mob.model.ModelOvamorph;
import com.arisux.avp.entities.mob.model.ModelPraetorian;
import com.arisux.avp.entities.mob.model.ModelPredalien;
import com.arisux.avp.entities.mob.model.ModelProtomorph;
import com.arisux.avp.entities.mob.model.ModelQueen;
import com.arisux.avp.entities.mob.model.ModelSpitter;
import com.arisux.avp.entities.mob.model.ModelTrilobite;
import com.arisux.avp.entities.mob.model.ModelWarrior;
import com.arisux.avp.entities.mob.model.ModelYautja;
import com.arisux.avp.entities.mob.model.ModelYautjaBerserker;
import com.arisux.avp.entities.mob.render.RenderAqua;
import com.arisux.avp.entities.mob.render.RenderChestburster;
import com.arisux.avp.entities.mob.render.RenderCombatSynthetic;
import com.arisux.avp.entities.mob.render.RenderEngineer;
import com.arisux.avp.entities.mob.render.RenderFacehugger;
import com.arisux.avp.entities.mob.render.RenderHammerpede;
import com.arisux.avp.entities.mob.render.RenderMarine;
import com.arisux.avp.entities.mob.render.RenderOvamorph;
import com.arisux.avp.entities.mob.render.RenderPredalien;
import com.arisux.avp.entities.mob.render.RenderQueen;
import com.arisux.avp.entities.mob.render.RenderRoyalFacehugger;
import com.arisux.avp.entities.mob.render.RenderSpitter;
import com.arisux.avp.entities.mob.render.RenderTrilobite;
import com.arisux.avp.entities.mob.render.RenderXenomorph;
import com.arisux.avp.entities.mob.render.RenderYautja;
import com.arisux.avp.entities.mob.render.RenderYautjaBerserker;
import com.arisux.avp.entities.render.RenderAPC;
import com.arisux.avp.entities.render.RenderAcidPool;
import com.arisux.avp.entities.render.RenderAcidSpit;
import com.arisux.avp.entities.render.RenderBullet;
import com.arisux.avp.entities.render.RenderDisc;
import com.arisux.avp.entities.render.RenderFlame;
import com.arisux.avp.entities.render.RenderLaserMine;
import com.arisux.avp.entities.render.RenderM40;
import com.arisux.avp.entities.render.RenderMechanism;
import com.arisux.avp.entities.render.RenderNuke;
import com.arisux.avp.entities.render.RenderPlasmaBlast;
import com.arisux.avp.entities.render.RenderShuriken;
import com.arisux.avp.entities.render.RenderSpear;
import com.arisux.avp.entities.tile.TileEntityAmpule;
import com.arisux.avp.entities.tile.TileEntityAssembler;
import com.arisux.avp.entities.tile.TileEntityBlastdoor;
import com.arisux.avp.entities.tile.TileEntityCryostasisTube;
import com.arisux.avp.entities.tile.TileEntityGunLocker;
import com.arisux.avp.entities.tile.TileEntityHiveNode;
import com.arisux.avp.entities.tile.TileEntityLightPanel;
import com.arisux.avp.entities.tile.TileEntityLocker;
import com.arisux.avp.entities.tile.TileEntityNegativeTransformer;
import com.arisux.avp.entities.tile.TileEntityP2RConverter;
import com.arisux.avp.entities.tile.TileEntityPowercell;
import com.arisux.avp.entities.tile.TileEntityPowerline;
import com.arisux.avp.entities.tile.TileEntityR2PConverter;
import com.arisux.avp.entities.tile.TileEntityRepulsionGenerator;
import com.arisux.avp.entities.tile.TileEntitySatelliteModem;
import com.arisux.avp.entities.tile.TileEntitySolarPanel;
import com.arisux.avp.entities.tile.TileEntityStasisMechanism;
import com.arisux.avp.entities.tile.TileEntityTransformer;
import com.arisux.avp.entities.tile.TileEntityTurret;
import com.arisux.avp.entities.tile.TileEntityWorkstation;
import com.arisux.avp.entities.tile.render.RenderAmpule;
import com.arisux.avp.entities.tile.render.RenderAssembler;
import com.arisux.avp.entities.tile.render.RenderBlastdoor;
import com.arisux.avp.entities.tile.render.RenderCryostasisTube;
import com.arisux.avp.entities.tile.render.RenderGunLocker;
import com.arisux.avp.entities.tile.render.RenderHiveNode;
import com.arisux.avp.entities.tile.render.RenderLightPanel;
import com.arisux.avp.entities.tile.render.RenderLocker;
import com.arisux.avp.entities.tile.render.RenderP2RConverter;
import com.arisux.avp.entities.tile.render.RenderPowercell;
import com.arisux.avp.entities.tile.render.RenderPowerline;
import com.arisux.avp.entities.tile.render.RenderR2PConverter;
import com.arisux.avp.entities.tile.render.RenderRepulsionGenerator;
import com.arisux.avp.entities.tile.render.RenderSatelliteModem;
import com.arisux.avp.entities.tile.render.RenderSolarPanel;
import com.arisux.avp.entities.tile.render.RenderStasisMechanism;
import com.arisux.avp.entities.tile.render.RenderTransformer;
import com.arisux.avp.entities.tile.render.RenderTurret;
import com.arisux.avp.entities.tile.render.RenderWorkstation;
import com.arisux.avp.items.model.Model88MOD4;
import com.arisux.avp.items.model.ModelAK47;
import com.arisux.avp.items.model.ModelM4;
import com.arisux.avp.items.model.ModelM41A;
import com.arisux.avp.items.model.ModelM56SG;
import com.arisux.avp.items.model.ModelSniper;
import com.arisux.avp.items.render.RenderItem88MOD4;
import com.arisux.avp.items.render.RenderItemAK47;
import com.arisux.avp.items.render.RenderItemAPC;
import com.arisux.avp.items.render.RenderItemAmpule;
import com.arisux.avp.items.render.RenderItemBlastDoor;
import com.arisux.avp.items.render.RenderItemCryostasisTube;
import com.arisux.avp.items.render.RenderItemGunLocker;
import com.arisux.avp.items.render.RenderItemLightPanel;
import com.arisux.avp.items.render.RenderItemLocker;
import com.arisux.avp.items.render.RenderItemM240ICU;
import com.arisux.avp.items.render.RenderItemM4;
import com.arisux.avp.items.render.RenderItemM40;
import com.arisux.avp.items.render.RenderItemM41A;
import com.arisux.avp.items.render.RenderItemM56SG;
import com.arisux.avp.items.render.RenderItemMotionTracker;
import com.arisux.avp.items.render.RenderItemNostromoFlamethrower;
import com.arisux.avp.items.render.RenderItemPowercell;
import com.arisux.avp.items.render.RenderItemPowerline;
import com.arisux.avp.items.render.RenderItemRepulsionGenerator;
import com.arisux.avp.items.render.RenderItemSniper;
import com.arisux.avp.items.render.RenderItemSolarPanel;
import com.arisux.avp.items.render.RenderItemSpear;
import com.arisux.avp.items.render.RenderItemStasisMechanism;
import com.arisux.avp.items.render.RenderItemSummoner;
import com.arisux.avp.items.render.RenderItemTransformer;
import com.arisux.avp.items.render.RenderItemTurret;
import com.arisux.avp.items.render.RenderItemWorkstation;
import com.arisux.avp.items.render.RenderItemWristbracer;
import com.arisux.avp.items.render.RenderItemWristbracerBlades;
import com.arisux.avp.items.render.parts.RenderItem88Mod4Action;
import com.arisux.avp.items.render.parts.RenderItem88Mod4Barrel;
import com.arisux.avp.items.render.parts.RenderItem88Mod4Stock;
import com.arisux.avp.items.render.parts.RenderItemAK47Action;
import com.arisux.avp.items.render.parts.RenderItemAK47Barrel;
import com.arisux.avp.items.render.parts.RenderItemAK47Stock;
import com.arisux.avp.items.render.parts.RenderItemM41AAction;
import com.arisux.avp.items.render.parts.RenderItemM41ABarrel;
import com.arisux.avp.items.render.parts.RenderItemM41APeripherals;
import com.arisux.avp.items.render.parts.RenderItemM41AStock;
import com.arisux.avp.items.render.parts.RenderItemM4Action;
import com.arisux.avp.items.render.parts.RenderItemM4Barrel;
import com.arisux.avp.items.render.parts.RenderItemM4Stock;
import com.arisux.avp.items.render.parts.RenderItemM56SGAction;
import com.arisux.avp.items.render.parts.RenderItemM56SGAimingModule;
import com.arisux.avp.items.render.parts.RenderItemM56SGBarrel;
import com.arisux.avp.items.render.parts.RenderItemM56SGStock;
import com.arisux.avp.items.render.parts.RenderItemM56SGSupportFrame;
import com.arisux.avp.items.render.parts.RenderItemSniperAction;
import com.arisux.avp.items.render.parts.RenderItemSniperBarrel;
import com.arisux.avp.items.render.parts.RenderItemSniperPeripherals;
import com.arisux.avp.items.render.parts.RenderItemSniperScope;
import com.arisux.avp.items.render.parts.RenderItemSniperStock;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

public class RenderingHandler implements IInitializablePre, IInitializablePost
{
	public static final RenderingHandler instance = new RenderingHandler();
	public ISimpleBlockRenderingHandler renderTypeAngled;

	@Override
	public void preInitialize(FMLPreInitializationEvent event)
	{
		registerSimpleBlockRenderingHandlers();
	}

	@Override
	public void postInitialize(FMLPostInitializationEvent event)
	{
		registerTileEntitySpecialRenderers();
		registerItemRenderers(AliensVsPredator.items());
		registerEntityRenderers();
	}

	public void registerEntityRenderers()
	{
		registerEntityRenderingHandler(EntityEngineer.class, new RenderEngineer(new ModelEngineer(), AliensVsPredator.resources().ENGINEER));
		registerEntityRenderingHandler(EntityYautjaBerserker.class, new RenderYautjaBerserker(new ModelYautjaBerserker(), 0.5F));
		registerEntityRenderingHandler(EntitySpaceJockey.class, new RenderEngineer(new ModelEngineer(), AliensVsPredator.resources().SPACE_JOCKEY));
		registerEntityRenderingHandler(EntityTrilobite.class, new RenderTrilobite(new ModelTrilobite(), 0.5F));
		registerEntityRenderingHandler(EntityHammerpede.class, new RenderHammerpede(new ModelHammerpede(), 0.5F));
		registerEntityRenderingHandler(EntityProtomorph.class, new RenderXenomorph(new ModelTexMap(new ModelProtomorph(), AliensVsPredator.resources().PROTOMORPH), 0.5F).setScale(1.4F));
		registerEntityRenderingHandler(EntityDrone.class, new RenderXenomorph(new ModelTexMap(new ModelDrone(), AliensVsPredator.resources().DRONE_BASIC), 0.5F));
		registerEntityRenderingHandler(EntityWarrior.class, new RenderXenomorph(new ModelTexMap(new ModelWarrior(), AliensVsPredator.resources().WARRIOR), 0.5F));
		registerEntityRenderingHandler(EntityPraetorian.class, new RenderXenomorph(new ModelTexMap(new ModelPraetorian(), AliensVsPredator.resources().PRAETORIAN), 0.85F, 1.4F));
		registerEntityRenderingHandler(EntityCrusher.class, new RenderXenomorph(new ModelTexMap(new ModelCrusher(), AliensVsPredator.resources().CRUSHER), 0.5F));
		registerEntityRenderingHandler(EntityAqua.class, new RenderAqua(new ModelAqua(), 0.5F));
		registerEntityRenderingHandler(EntityPredalien.class, new RenderPredalien(new ModelPredalien(), 0.35F));
		registerEntityRenderingHandler(EntitySpitter.class, new RenderSpitter(new ModelSpitter(), 0.5F));
		registerEntityRenderingHandler(EntityMarine.class, new RenderMarine(new ModelBiped(), 0.5F));
		registerEntityRenderingHandler(EntityCombatSynthetic.class, new RenderCombatSynthetic(new ModelBiped(), 0.5F));
		registerEntityRenderingHandler(EntityYautja.class, new RenderYautja(new ModelYautja(), 0.5F));
		registerEntityRenderingHandler(EntityQueen.class, new RenderQueen(new ModelQueen(), 0.5F));
		registerEntityRenderingHandler(EntityFacehugger.class, new RenderFacehugger(new ModelFacehugger(), 0.5F));
		registerEntityRenderingHandler(EntityRoyalFacehugger.class, new RenderRoyalFacehugger(new ModelFacehugger(), 0.5F));
		registerEntityRenderingHandler(EntityChestburster.class, new RenderChestburster(new ModelChestburster(), 0.5F));
		registerEntityRenderingHandler(EntityOvamorph.class, new RenderOvamorph(new ModelOvamorph(), 0.5F));
		registerEntityRenderingHandler(EntitySpear.class, new RenderSpear());
		registerEntityRenderingHandler(EntityLaserMine.class, new RenderLaserMine());
		registerEntityRenderingHandler(EntityGrenade.class, new RenderM40());
		registerEntityRenderingHandler(EntityFlame.class, new RenderFlame());
		registerEntityRenderingHandler(EntityAcidPool.class, new RenderAcidPool());
		registerEntityRenderingHandler(EntityPlasma.class, new RenderPlasmaBlast());
		registerEntityRenderingHandler(EntityAcidProjectile.class, new RenderAcidSpit());
		registerEntityRenderingHandler(EntitySmartDisc.class, new RenderDisc());
		registerEntityRenderingHandler(EntityShuriken.class, new RenderShuriken());
		registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		registerEntityRenderingHandler(EntityNuke.class, new RenderNuke());
		registerEntityRenderingHandler(EntityAPC.class, new RenderAPC());
		registerEntityRenderingHandler(EntityMechanism.class, new RenderMechanism());
	}

	public void registerItemRenderers(ItemHandler items)
	{
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockTurret), new RenderItemTurret());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockWorkstation), new RenderItemWorkstation());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockStasisMechanism), new RenderItemStasisMechanism());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockCryostasisTube), new RenderItemCryostasisTube());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockRepulsionGenerator), new RenderItemRepulsionGenerator());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockBlastdoor), new RenderItemBlastDoor());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockLightPanel), new RenderItemLightPanel());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockPowerline), new RenderItemPowerline());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockSolarPanel), new RenderItemSolarPanel());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockPowercell), new RenderItemPowercell());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockTransformer), new RenderItemTransformer());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockNegativeTransformer), new RenderItemTransformer());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockAmpule), new RenderItemAmpule());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockLocker), new RenderItemLocker());
		registerItemRenderer(Item.getItemFromBlock(AliensVsPredator.blocks().blockGunLocker), new RenderItemGunLocker());
		registerItemRenderer(items.itemWristBlade, new RenderItemWristbracer());
		registerItemRenderer(items.itemWristbracerBlades, new RenderItemWristbracerBlades());
		registerItemRenderer(items.itemSpear, new RenderItemSpear());
		registerItemRenderer(items.itemM240ICU, new RenderItemM240ICU());
		registerItemRenderer(items.itemNostromoFlamethrower, new RenderItemNostromoFlamethrower());
		registerItemRenderer(items.itemM41A, new RenderItemM41A());
		registerItemRenderer(items.itemM56SG, new RenderItemM56SG());
		registerItemRenderer(items.itemAK47, new RenderItemAK47());
		registerItemRenderer(items.itemM4, new RenderItemM4());
		registerItemRenderer(items.itemPistol, new RenderItem88MOD4());
		registerItemRenderer(items.itemSniper, new RenderItemSniper());
		registerItemRenderer(items.itemMotionTracker, new RenderItemMotionTracker());
		registerItemRenderer(items.itemAPC, new RenderItemAPC());
		registerItemRenderer(items.itemGrenade, new RenderItemM40(AliensVsPredator.resources().M40GRENADE));
		registerItemRenderer(items.itemIncendiaryGrenade, new RenderItemM40(AliensVsPredator.resources().M40GRENADE_INCENDIARY));
		registerItemRenderer(items.itemSummonerDrone, (new RenderItemSummoner(EntityDrone.class, ModelDrone.class, AliensVsPredator.resources().DRONE_ADVANCED)).setScale(7.5F).setY(6F));
		registerItemRenderer(items.itemSummonerProtomorph, (new RenderItemSummoner(EntityProtomorph.class, ModelProtomorph.class, AliensVsPredator.resources().PROTOMORPH)).setScale(7.5F).setY(6F));
		registerItemRenderer(items.itemSummonerWarrior, (new RenderItemSummoner(EntityWarrior.class, ModelWarrior.class, AliensVsPredator.resources().WARRIOR)).setScale(7.5F).setY(9F));
		registerItemRenderer(items.itemSummonerPraetorian, (new RenderItemSummoner(EntityPraetorian.class, ModelPraetorian.class, AliensVsPredator.resources().PRAETORIAN)).setScale(7.5F).setY(7.5F));
		registerItemRenderer(items.itemSummonerSpitter, (new RenderItemSummoner(EntitySpitter.class, ModelSpitter.class, AliensVsPredator.resources().SPITTER)).setScale(2.5F).setY(9F));
		registerItemRenderer(items.itemSummonerCrusher, (new RenderItemSummoner(EntityCrusher.class, ModelCrusher.class, AliensVsPredator.resources().CRUSHER)).setScale(7.5F).setY(9.5F));
		registerItemRenderer(items.itemSummonerQueen, (new RenderItemSummoner(EntityQueen.class, ModelQueen.class, AliensVsPredator.resources().XENOQUEEN)).setScale(7.5F).setY(8F));
		registerItemRenderer(items.itemSummonerOvamorph, (new RenderItemSummoner(EntityOvamorph.class, ModelOvamorph.class, AliensVsPredator.resources().OVAMORPH)).setScale(20F).setY(1F));
		registerItemRenderer(items.itemSummonerChestburster, (new RenderItemSummoner(EntityChestburster.class, ModelChestburster.class, AliensVsPredator.resources().CHESTBUSTER)).setScale(20F).setY(1F));
		registerItemRenderer(items.itemSummonerFacehugger, (new RenderItemSummoner(EntityFacehugger.class, ModelFacehugger.class, AliensVsPredator.resources().FACEHUGGER)).setScale(15F).setY(1F));
		registerItemRenderer(items.itemSummonerRoyalFacehugger, (new RenderItemSummoner(EntityRoyalFacehugger.class, ModelFacehugger.class, AliensVsPredator.resources().ROYALFACEHUGGER)).setScale(15F).setY(1F));
		registerItemRenderer(items.itemSummonerMarine, (new RenderItemSummoner(EntityMarine.class, ModelBipedExtension.class, AliensVsPredator.resources().MARINE)).setScale(12F).setY(6F));
		registerItemRenderer(items.itemSummonerYautja, (new RenderItemSummoner(EntityYautja.class, ModelYautja.class, AliensVsPredator.resources().YAUTJA)).setScale(7.5F).setY(8F));
		registerItemRenderer(items.itemSummonerPredalien, (new RenderItemSummoner(EntityPredalien.class, ModelPredalien.class, AliensVsPredator.resources().PREDALIEN)).setScale(12F).setY(6F));
		registerItemRenderer(items.itemSummonerAqua, (new RenderItemSummoner(EntityAqua.class, ModelAqua.class, AliensVsPredator.resources().AQUA_XENOMORPH)).setScale(7.5F).setY(8F));
		registerItemRenderer(items.itemSummonerCombatSynthetic, (new RenderItemSummoner(EntityCombatSynthetic.class, ModelBipedExtension.class, AliensVsPredator.resources().COMBAT_SYNTHETIC)).setScale(7.5F).setY(8F));
		registerItemRenderer(items.itemSummonerHammerpede, (new RenderItemSummoner(EntityHammerpede.class, ModelHammerpede.class, AliensVsPredator.resources().HAMMERPEDE)).setScale(25.5F).setY(8F));
		registerItemRenderer(items.itemSummonerTrilobite, (new RenderItemSummoner(EntityTrilobite.class, ModelTrilobite.class, AliensVsPredator.resources().TRILOBITE)).setScale(25.5F).setY(8F));
		registerItemRenderer(items.itemSummonerSpaceJockey, (new RenderItemSummoner(EntitySpaceJockey.class, ModelEngineer.class, AliensVsPredator.resources().SPACE_JOCKEY)).setScale(27.5F).setY(8F));
		registerItemRenderer(items.itemSummonerEngineer, (new RenderItemSummoner(EntityEngineer.class, ModelEngineer.class, AliensVsPredator.resources().ENGINEER)).setScale(27.5F).setY(8F));
		registerItemRenderer(items.itemSummonerYautjaBerserker, (new RenderItemSummoner(EntityYautjaBerserker.class, ModelYautjaBerserker.class, AliensVsPredator.resources().YAUTJA_BERSERKER)).setScale(7.5F).setY(8F));
		
		Model88MOD4 _88mod4 = new Model88MOD4();
		registerItemRenderer(items.itemPistolBarrel, new RenderItem88Mod4Barrel(AliensVsPredator.resources()._88MOD4, _88mod4.barrelLeft, _88mod4.barrelRight, _88mod4.barrelNose, _88mod4.barrelSupport));
		registerItemRenderer(items.itemPistolAction, new RenderItem88Mod4Action(AliensVsPredator.resources()._88MOD4, _88mod4.rack, _88mod4.underGrip, _88mod4.trigger, _88mod4.gripSupport, _88mod4.trigger));
		registerItemRenderer(items.itemPistolStock, new RenderItem88Mod4Stock(AliensVsPredator.resources()._88MOD4, _88mod4.handleGrip, _88mod4.butt1, _88mod4.gripSupport));
		
		ModelAK47 ak47 = new ModelAK47();
		registerItemRenderer(items.itemAK47Barrel, new RenderItemAK47Barrel(AliensVsPredator.resources().AK47, ak47.barrel, ak47.barrelBase, ak47.lBarrelGrip, ak47.rBarrelGrip));
		registerItemRenderer(items.itemAK47Action, new RenderItemAK47Action(AliensVsPredator.resources().AK47, ak47.lbody1, ak47.rbody1, ak47.sightBase, ak47.sightBase1, ak47.trigger, ak47.triggerGuard));
		registerItemRenderer(items.itemAK47Stock, new RenderItemAK47Stock(AliensVsPredator.resources().AK47, ak47.handle, ak47.stockBase, ak47.stockAngle, ak47.stockEnd));
		
		ModelM4 m4 = new ModelM4();
		registerItemRenderer(items.itemM4Barrel, new RenderItemM4Barrel(AliensVsPredator.resources().M4, m4.barrel, m4.barrelGuard));
		registerItemRenderer(items.itemM4Action, new RenderItemM4Action(AliensVsPredator.resources().M4, m4.mainBody1, m4.mainBody2, m4.mainBody3, m4.sightBase1, m4.sightBase2, m4.sightBase3, m4.triggerGuard));
		registerItemRenderer(items.itemM4Stock, new RenderItemM4Stock(AliensVsPredator.resources().M4, m4.handle, m4.stock1, m4.stock2, m4.stock3));
		
		ModelM56SG m56sg = new ModelM56SG();
		registerItemRenderer(items.itemM56SGAction, new RenderItemM56SGAction(AliensVsPredator.resources().M56SG, m56sg.base, m56sg.base2, m56sg.base3, m56sg.baseUnder, m56sg.baseUnder2, m56sg.ammoHolder, m56sg.topHandle, m56sg.topHandleBase, m56sg.topHandleBase2));
		registerItemRenderer(items.itemM56SGAimingModule, new RenderItemM56SGAimingModule(AliensVsPredator.resources().M56SG, m56sg.autoTargetControl, m56sg.autoTargetEye));
		registerItemRenderer(items.itemM56SGBarrel, new RenderItemM56SGBarrel(AliensVsPredator.resources().M56SG, m56sg.barrel, m56sg.barrelHolderBase));
		registerItemRenderer(items.itemM56SGStock, new RenderItemM56SGStock(AliensVsPredator.resources().M56SG, m56sg.handle, m56sg.handleBase, m56sg.handleTop, m56sg.handleWire));
		registerItemRenderer(items.itemM56SGSupportFrame, new RenderItemM56SGSupportFrame(AliensVsPredator.resources().M56SG, m56sg.barrelSupportLeft, m56sg.barrelSupportRight));
		
		ModelM41A m41a = new ModelM41A();
		registerItemRenderer(items.itemM41AAction, new RenderItemM41AAction(AliensVsPredator.resources().M41A, m41a.gunBase1, m41a.gunBase2, m41a.gunBase3, m41a.gunFrame, m41a.underrail, m41a.underrail2));
		registerItemRenderer(items.itemM41ABarrel, new RenderItemM41ABarrel(AliensVsPredator.resources().M41A, m41a.barrel, m41a.mechanism));
		registerItemRenderer(items.itemM41AStock, new RenderItemM41AStock(AliensVsPredator.resources().M41A, m41a.handle, m41a.stock1, m41a.stockEnd));
		registerItemRenderer(items.itemM41APeripherals, new RenderItemM41APeripherals(AliensVsPredator.resources().M41A, m41a.sight1, m41a.sight2, m41a.sight3, m41a.grip, m41a.grip2));
		
		ModelSniper sniper = new ModelSniper();
		registerItemRenderer(items.itemSniperBarrel, new RenderItemSniperBarrel(AliensVsPredator.resources().SNIPER, sniper.barrel));
		registerItemRenderer(items.itemSniperAction, new RenderItemSniperAction(AliensVsPredator.resources().SNIPER, sniper.base1, sniper.base2, sniper.clipHolder1, sniper.clipHolder2, sniper.trigger, sniper.triggerGuard, sniper.scopeBase));
		registerItemRenderer(items.itemSniperScope, new RenderItemSniperScope(AliensVsPredator.resources().SNIPER, sniper.scope, sniper.scopeSupport));
		registerItemRenderer(items.itemSniperStock, new RenderItemSniperStock(AliensVsPredator.resources().SNIPER, sniper.stock1, sniper.stock2, sniper.stockEnd));
		registerItemRenderer(items.itemSniperPeripherals, new RenderItemSniperPeripherals(AliensVsPredator.resources().SNIPER, sniper.barrelSupport));
		
		// registerItemRenderer(items.itemAK47Barrel, new RenderItemMotionTracker());
		// registerItemRenderer(items.itemAK47Stock, new RenderItemMotionTracker());
	}

	public void registerTileEntitySpecialRenderers()
	{
		bindTileEntitySpecialRenderer(TileEntityHiveNode.class, new RenderHiveNode());
		bindTileEntitySpecialRenderer(TileEntityTurret.class, new RenderTurret());
		bindTileEntitySpecialRenderer(TileEntityWorkstation.class, new RenderWorkstation());
		bindTileEntitySpecialRenderer(TileEntityStasisMechanism.class, new RenderStasisMechanism());
		bindTileEntitySpecialRenderer(TileEntityPowerline.class, new RenderPowerline());
		bindTileEntitySpecialRenderer(TileEntityBlastdoor.class, new RenderBlastdoor());
		bindTileEntitySpecialRenderer(TileEntityCryostasisTube.class, new RenderCryostasisTube());
		bindTileEntitySpecialRenderer(TileEntityRepulsionGenerator.class, new RenderRepulsionGenerator());
		bindTileEntitySpecialRenderer(TileEntityAssembler.class, new RenderAssembler());
		bindTileEntitySpecialRenderer(TileEntityLightPanel.class, new RenderLightPanel());
		bindTileEntitySpecialRenderer(TileEntitySolarPanel.class, new RenderSolarPanel());
		bindTileEntitySpecialRenderer(TileEntitySatelliteModem.class, new RenderSatelliteModem());
		bindTileEntitySpecialRenderer(TileEntityTransformer.class, new RenderTransformer());
		bindTileEntitySpecialRenderer(TileEntityNegativeTransformer.class, new RenderTransformer());
		bindTileEntitySpecialRenderer(TileEntityR2PConverter.class, new RenderR2PConverter());
		bindTileEntitySpecialRenderer(TileEntityP2RConverter.class, new RenderP2RConverter());
		bindTileEntitySpecialRenderer(TileEntityPowercell.class, new RenderPowercell());
		bindTileEntitySpecialRenderer(TileEntityAmpule.class, new RenderAmpule());
		bindTileEntitySpecialRenderer(TileEntityLocker.class, new RenderLocker());
		bindTileEntitySpecialRenderer(TileEntityGunLocker.class, new RenderGunLocker());
	}

	public void registerSimpleBlockRenderingHandlers()
	{
		registerBlockHandler(this.renderTypeAngled = new RenderShape());
	}
}
