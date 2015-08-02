package com.arisux.avp.entities.tile.render;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

import org.lwjgl.opengl.GL11;

import com.arisux.airi.lib.RenderUtil;
import com.arisux.avp.AliensVsPredator;
import com.arisux.avp.entities.tile.TileEntityTransformer;
import com.arisux.avp.entities.tile.model.ModelTransformer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class RenderTransformer extends TileEntitySpecialRenderer
{
	public static ModelTransformer model = new ModelTransformer();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double posX, double posY, double posZ, float renderPartialTicks)
	{
		if (tileEntity != null && tileEntity instanceof TileEntityTransformer)
		{
			TileEntityTransformer transformer = (TileEntityTransformer) tileEntity;

			glPushMatrix();
			{
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glTranslated(posX, posY, posZ);
				GL11.glScalef(1F, -1F, 1F);
				GL11.glTranslatef(0.5F, -1.5F, 0.5F);
				
				if (transformer.getDirection() == ForgeDirection.EAST || transformer.getDirection() == ForgeDirection.WEST)
				{
					GL11.glRotatef(90F, 0F, 1F, 0F);
				}
				
				RenderUtil.bindTexture(AliensVsPredator.resources().TRANSFORMER);
				model.render();
			}
			glPopMatrix();
		}
	}
}
