package com.arisux.avp.dimension.acheron.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.arisux.avp.AliensVsPredator;

import cpw.mods.fml.common.IWorldGenerator;

public class TerrainFormation1 extends WorldGenerator implements IWorldGenerator
{
	Block[] validBlocks = new Block[] {
		AliensVsPredator.blocks().terrainUniDirt
	};

	public boolean locationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block check = world.getBlock(x, y, z);

		while (check != Blocks.air)
		{
			if (distanceToAir > 3)
			{
				return false;
			}

			distanceToAir++;
			check = world.getBlock(x, y + distanceToAir, z);
		}

		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);

		for (Block validBlock : validBlocks)
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == validBlock)
			{
				return true;
			}
			else if (block == Blocks.snow && blockBelow == validBlock)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		;
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		Block b1 = world.getBlock(x, y, z);

		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
		{
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if (!locationIsValidSpawn(world, x, y, z))
		{
			return false;
		}

		Block block = AliensVsPredator.blocks().blockDerelict3;

		this.setBlock(world, x + 0, y + 6, z + 1, block, 0);
		this.setBlock(world, x + 0, y + 7, z + 1, block, 0);
		this.setBlock(world, x + 1, y + 5, z + 1, block, 0);
		this.setBlock(world, x + 1, y + 5, z + 2, block, 0);
		this.setBlock(world, x + 1, y + 6, z + 1, block, 0);
		this.setBlock(world, x + 2, y + 3, z + 1, block, 0);
		this.setBlock(world, x + 2, y + 4, z + 0, block, 0);
		this.setBlock(world, x + 2, y + 4, z + 1, block, 0);
		this.setBlock(world, x + 2, y + 4, z + 2, block, 0);
		this.setBlock(world, x + 2, y + 5, z + 1, block, 0);
		this.setBlock(world, x + 3, y + 2, z + 1, block, 0);
		this.setBlock(world, x + 3, y + 3, z + 0, block, 0);
		this.setBlock(world, x + 3, y + 3, z + 1, block, 0);
		this.setBlock(world, x + 3, y + 3, z + 2, block, 0);
		this.setBlock(world, x + 3, y + 4, z + 1, block, 0);
		this.setBlock(world, x + 4, y + 1, z + 0, block, 0);
		this.setBlock(world, x + 4, y + 1, z + 1, block, 0);
		this.setBlock(world, x + 4, y + 2, z + 0, block, 0);
		this.setBlock(world, x + 4, y + 2, z + 1, block, 0);
		this.setBlock(world, x + 4, y + 2, z + 2, block, 0);
		this.setBlock(world, x + 4, y + 3, z + 1, block, 0);
		this.setBlock(world, x + 5, y + 0, z + 0, block, 0);
		this.setBlock(world, x + 5, y + 0, z + 1, block, 0);
		this.setBlock(world, x + 5, y + 0, z + 2, block, 0);
		this.setBlock(world, x + 5, y + 1, z + 0, block, 0);
		this.setBlock(world, x + 5, y + 1, z + 1, block, 0);
		this.setBlock(world, x + 5, y + 1, z + 2, block, 0);
		this.setBlock(world, x + 5, y + 2, z + 1, block, 0);
		this.setBlock(world, x + 6, y + 0, z + 0, block, 0);
		this.setBlock(world, x + 6, y + 0, z + 1, block, 0);
		this.setBlock(world, x + 6, y + 0, z + 2, block, 0);
		this.setBlock(world, x + 6, y + 1, z + 1, block, 0);
		this.setBlock(world, x + 7, y + 0, z + 1, block, 0);

		return true;
	}
}
