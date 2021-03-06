package com.arisux.avp.items;

import com.arisux.airi.lib.RenderUtil;
import com.arisux.avp.AliensVsPredator;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorPressureSuit extends ItemArmor
{
	public ItemArmorPressureSuit(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		switch (slot)
		{
			case 0:
				return RenderUtil.getResourcePath(AliensVsPredator.resources().PRESSURESUIT1);
			case 1:
				return RenderUtil.getResourcePath(AliensVsPredator.resources().PRESSURESUIT1);
			case 2:
				return RenderUtil.getResourcePath(AliensVsPredator.resources().PRESSURESUIT2);
			case 3:
				return RenderUtil.getResourcePath(AliensVsPredator.resources().PRESSURESUIT2);
			default:
				return RenderUtil.getResourcePath(AliensVsPredator.resources().PRESSURESUIT2);
		}
	}
}