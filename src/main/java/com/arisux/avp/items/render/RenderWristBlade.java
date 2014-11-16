package com.arisux.avp.items.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.arisux.airi.engine.RenderEngine;
import com.arisux.avp.AliensVsPredator;
import com.arisux.avp.items.model.ModelWristBlade;

public class RenderWristBlade implements IItemRenderer
{
	protected ModelWristBlade model = new ModelWristBlade();
	protected static final ResourceLocation resourceLocation = new ResourceLocation(AliensVsPredator.properties().TEXTURE_PATH_WRISTBLADES);
	private float rotation;
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
			case EQUIPPED:
				return true;

			case EQUIPPED_FIRST_PERSON:
				return true;
				
			case INVENTORY:
				return true;

			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		this.rotation = rotation > 360F ? rotation = 0F : (rotation = rotation + 0.6F);

		switch (type)
		{
			case EQUIPPED:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
				GL11.glRotatef(186.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(3.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);
			if (data[1] != null && data[1] instanceof EntityPlayer)
				{
					if ((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && (!(Minecraft.getMinecraft().currentScreen instanceof GuiInventory) && !(Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) || RenderManager.instance.playerViewY != 180.0F))
					{
						GL11.glTranslatef(0.4F, 0.1F, -0.1F);
						GL11.glRotatef(340.0F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-70.0F, 0.0F, 0.0F, 1.0F);
						GL11.glDisable(GL11.GL_CULL_FACE);
					} else
					{
						GL11.glTranslatef(0.45F, 0.0F, 0.0F);
					}
				} else
				{
					GL11.glTranslatef(0.3F, 0.3F, 0.0F);
				}

				float glScale1 = 1.6F;
				GL11.glScalef(glScale1, glScale1, glScale1);
				this.model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;

			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
				GL11.glRotatef(186.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(3.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-35.0F, 0.0F, 0.0F, 1.0F);

				if ((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && (!(Minecraft.getMinecraft().currentScreen instanceof GuiInventory) && !(Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) || RenderManager.instance.playerViewY != 180.0F))
				{
					GL11.glTranslatef(0.4F, 0.1F, -0.1F);
					GL11.glRotatef(340.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-70.0F, 0.0F, 0.0F, 1.0F);
					GL11.glDisable(GL11.GL_CULL_FACE);
				} else
				{
					GL11.glTranslatef(0.45F, 0.0F, 0.0F);
				}

				float glScale2 = 1.6F;
				GL11.glScalef(glScale2, glScale2, glScale2);
				this.model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
				
			case INVENTORY:
				GL11.glPushMatrix();
				{
					RenderEngine.bindTexture(resourceLocation);
					GL11.glDisable(GL11.GL_CULL_FACE);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glTranslatef(8.5F, 0F, 0F);
					GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(-10F, 6F, 0F);
					glScale2 = 33F;
					GL11.glScalef(glScale2, glScale2, glScale2);
					this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
					this.model.b6.render(0.0625F);
					this.model.bladeLeft.render(0.0625F);
				}
				GL11.glPopMatrix();
				break;

			default:
		}
	}
}
