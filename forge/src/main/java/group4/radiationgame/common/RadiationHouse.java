package group4.radiationgame.common;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;
import group4.radiationgame.block.SourceRadiationBlock;
import group4.radiationgame.block.SubRadiationBlock;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.ChestGenHooks;

/**
 * 
 * @author JDuck404
 *
 * Variation on the dungeon generator to serve as our Radioactive source area 
 * 
 */

public class RadiationHouse extends WorldGenDungeons{
	
	RadiationHouse(){
		super();
	}
	

	/**
	 * @param world
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * Generates a box with walls made of SubRadiationBlock and puts a SourceRadiationBlock inside
	 * 
	 */
	public boolean generate(World world, Random random, int x, int y, int z)
    {
		
		//for testing
		x = 0;
		y = 64;
		z = 0;
		//change later
		
	byte b0 = 3;
    int width = random.nextInt(2) + 2;
    int depth = random.nextInt(2) + 2;
    int j1 = 0;
    int xCurr;
    int yCurr;
    int zCurr;
    
    /**
     * Check that the area is valid for house generation
     * 
     * 
     */
    for (xCurr = x - width - 1; xCurr <= x + width + 1; ++xCurr)
    {
        for (yCurr = y - 1; yCurr <= y + b0 + 1; ++yCurr)
        {
            for (zCurr = z - depth - 1; zCurr <= z + depth + 1; ++zCurr)
            {
            	Material material = world.getBlock(xCurr, yCurr, zCurr).getMaterial();

                if (yCurr == y - 1 && !material.isSolid())
                {
                	System.out.println("Couldnt generate");
                    return false;
                }

                if (yCurr == y + b0 + 1 && !material.isSolid())
                {	
                	System.out.println("Couldnt generate");
                    return false;
                }
				
                if ((xCurr == x - width - 1 || xCurr == x + width + 1 || zCurr == z - depth - 1 || zCurr == z + depth + 1) && yCurr == y && world.isAirBlock(xCurr, yCurr, zCurr) && world.isAirBlock(xCurr, yCurr + 1, zCurr))
                {
                	++j1;
                }
                
                
            }
        }
    }

    
    /**
     * If checks that requirements are met 
     * 
     * Loops iterate through the volume and change blocks as required
     */
    if (j1 >= 1 && j1 <= 5)
    {
        for (xCurr = x - width - 1; xCurr <= x + width + 1; ++xCurr)
        {
            for (yCurr = y + b0; yCurr >= y - 1; --yCurr)
            {
                for (zCurr = z - depth - 1; zCurr <= z + depth + 1; ++zCurr)
                {
                    if (xCurr != x - width - 1 && yCurr != y - 1 && zCurr != z - depth - 1 && xCurr != x + width + 1 && yCurr != y + b0 + 1 && zCurr != z + depth + 1)
                    {
                        world.setBlockToAir(xCurr, yCurr, zCurr);
                    }
                    else if (yCurr >= 0 && !world.getBlock(xCurr, yCurr - 1, zCurr).getMaterial().isSolid())
                    {
                    	world.setBlockToAir(xCurr, yCurr, zCurr);
                    }
                    else if (world.getBlock(xCurr, yCurr, zCurr).getMaterial().isSolid())
                    {
                        
                        world.setBlock(xCurr, yCurr, zCurr, new SubRadiationBlock(), 0, 2);
                       
                    }
                }
            }
        }

        xCurr = 0;

        while (xCurr < 2)
        {
            yCurr = 0;

            while (true)
            {
                if (yCurr < 3)
                {
                    
                    {
                        zCurr = x + random.nextInt(width * 2 + 1) - width;
                        int j2 = z + random.nextInt(depth * 2 + 1) - depth;

                        if (world.isAirBlock(zCurr, y, j2))
                        {
                            int k2 = 0;

                            if (world.getBlock(zCurr - 1, y, j2).getMaterial().isSolid())
                            {
                                ++k2;
                            }

                            if (world.getBlock(zCurr + 1, y, j2).getMaterial().isSolid())
                            {
                                ++k2;
                            }

                            if (world.getBlock(zCurr, y, j2 - 1).getMaterial().isSolid())
                            {
                                ++k2;
                            }

                            if (world.getBlock(zCurr, y, j2 + 1).getMaterial().isSolid())
                            {
                                ++k2;
                            }

                        }

                        ++yCurr;
                        continue;
                    }
                }

                ++xCurr;
                break;
            }
        }

        world.setBlock(x, y, z, new SourceRadiationBlock(), 0, 2);

        return true;
    }
    else
    {
    	System.out.println("Couldnt generate");
        return false;
    }
}
	
}