package com.arisux.avp.entities.tile;

import com.arisux.avp.interfaces.energy.IEnergyProvider;

import net.minecraftforge.common.util.ForgeDirection;

public class TileEntitySolarPanel extends TileEntityElectrical implements IEnergyProvider
{
	public TileEntitySolarPanel()
	{
		super(true);
	}

	@Override
	public void updateEntity()
	{
		if (this.worldObj.getWorldTime() < 12300 || this.worldObj.getWorldTime() > 23850)
		{
			if (this.getWorldObj().getWorldTime() % (1000 / this.getSourceHertz()) == 0)
			{
				this.setVoltage(120);
			}
		}
		else
		{
			this.setVoltage(0);
		}
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		return true;
	}
	
	@Override
	public double extractEnergy(ForgeDirection from, double maxExtract, boolean simulate)
	{
		return super.extractEnergy(from, maxExtract, simulate);
	}

	@Override
	public double getEnergyStored(ForgeDirection from)
	{
		return this.voltage;
	}

	@Override
	public double getMaxEnergyStored(ForgeDirection from)
	{
		return 10000;
	}
}
