package com.arisux.avp.items.render.parts;

import com.arisux.airi.lib.GlStateManager;
import com.arisux.avp.items.render.RenderItemFirearmPart;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderItem88Mod4Barrel extends RenderItemFirearmPart
{
	public RenderItem88Mod4Barrel(ResourceLocation resourceLocation, ModelRenderer... modelRenderers)
	{
		super(resourceLocation, modelRenderers);
	}

	@Override
	public void renderInInventory(ItemStack item, Object... data)
	{
		super.renderInInventory(item, data);

		GlStateManager.pushMatrix();
		{
			float glScale = 24F;
			GlStateManager.translate(8F, 8F, 0F);
			GlStateManager.rotate(this.getRotation(), 0F, 1F, 0F);
			GlStateManager.scale(glScale, glScale, glScale);
			GlStateManager.translate(0.0F, 0.0F, -0.2F);
			this.renderPart();
		}
		GlStateManager.popMatrix();
	}
}
