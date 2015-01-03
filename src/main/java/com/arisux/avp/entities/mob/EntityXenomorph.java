package com.arisux.avp.entities.mob;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.arisux.airi.lib.WorldUtil;
import com.arisux.airi.lib.WorldUtil.Blocks;
import com.arisux.avp.entities.EntityAcidPool;

public abstract class EntityXenomorph extends EntitySpeciesAlien implements IMob
{
	protected EntityQueen targetQueen;

	public EntityXenomorph(World world)
	{
		super(world);
		this.jumpMovementFactor = 0.1F;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	@Override
	protected boolean canDespawn()
	{
		return super.canDespawn();
	}

	@Override
	protected boolean isAIEnabled()
	{
		return super.isAIEnabled();
	}

	@Override
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	public void setBesideClimbableBlock(boolean climbable)
	{
		byte byteClimbing = this.dataWatcher.getWatchableObjectByte(16);

		if (climbable)
		{
			byteClimbing = (byte) (byteClimbing | 1);
		}
		else
		{
			byteClimbing &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(byteClimbing));
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (worldObj.getWorldInfo().getWorldTime() % 70L == 0L)
		{
			double range = this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
			Entity targetEntity = (this.worldObj.findNearestEntityWithinAABB(EntityLiving.class, this.boundingBox.expand(range * 2, 64.0D, range * 2), this));
			Entity targetPlayer = (this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(range * 2, 64.0D, range * 2), this));

			if (targetPlayer != null && !((EntityPlayer) targetPlayer).capabilities.isCreativeMode)
			{
				this.setAttackTarget((EntityLivingBase) targetPlayer);
				this.getNavigator().tryMoveToEntityLiving(targetPlayer, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue() * 2.5D);

				if (this.isCollidedHorizontally)
				{
					this.addVelocity(0, 0.6D, 0);
				}

			}
			else if (targetEntity != null && !(targetEntity instanceof EntityAcidPool) && !(targetEntity.getClass().getSuperclass().getSuperclass() == EntitySpeciesAlien.class) && !(targetEntity.getClass().getSuperclass() == EntitySpeciesAlien.class))
			{
				this.setAttackTarget((EntityLivingBase) targetEntity);
			}
		}

		this.acquireHiveSignature();
	}

	public void acquireHiveSignature()
	{
		if (this.getHiveSignature() == null)
		{
			if (this.targetQueen != null)
			{
				if (!this.targetQueen.isDead)
				{
					if (this.worldObj.getWorldTime() % 20 <= 0)
					{
						this.getNavigator().tryMoveToEntityLiving(this.targetQueen, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue() * 2.5D);
					}
					if (this.getDistanceToEntity(this.targetQueen) <= 15)
					{
						this.setHiveSignature(this.targetQueen.getUniqueID());
					}
				}
				else
				{
					this.targetQueen = null;
				}
			}
			else
			{
				this.targetQueen = (EntityQueen) WorldUtil.Entities.getEntityInCoordsRange(this.worldObj, EntityQueen.class, new Blocks.CoordData(this), 128, 128);
			}
		}
	}

	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
}
