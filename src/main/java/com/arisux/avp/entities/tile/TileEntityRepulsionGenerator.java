package com.arisux.avp.entities.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityRepulsionGenerator extends PoweredTileEntity
{
	public int rotation;

	public void setDirection(byte direction)
	{
		this.rotation = direction;
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("Rotation", this.rotation);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.rotation = nbt.getInteger("Rotation");
	}

	@Override
	public void outputPower()
	{
		super.outputPower();
	}

	@Override
	public void outputPowerToTile(PoweredTileEntity tile, double voltage)
	{
		if (tile != null && tile.getPowerSourceTile() == this)
		{
			tile.setVoltage(voltage);
		}
	}

	@Override
	public boolean canOutputPower()
	{
		return true;
	}

	@Override
	public double getVoltage()
	{
		double addedVoltage = 120;
		
		if (getTop() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		if (getBottom() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		if (getLeft() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		if (getRight() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		if (getFront() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		if (getBack() instanceof TileEntityRepulsionGenerator)
		{
			addedVoltage += 120;
		}
		
		return addedVoltage;
	}

	@Override
	public void onVoltageTick()
	{
		;
	}

	@Override
	public void onOverloadTick()
	{
		;
	}

	@Override
	public void onUnderloadTick()
	{
		;
	}

	@Override
	public double getMaxOperatingVoltage()
	{
		return 24000;
	}
}