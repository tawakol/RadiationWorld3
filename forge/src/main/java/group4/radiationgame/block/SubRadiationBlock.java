package group4.radiationgame.block;

import java.util.Random;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class SubRadiationBlock extends BlockMycelium{

	public SubRadiationBlock(){
		
		super();
		
		this.setBlockName("SubRadiationBlock")
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockUnbreakable()
		.setLightLevel((float)0.7);
		
	}
	
	/**
	 * Gets called at random by the world and changes adjacent blocks to a copy of itself
	 * 
	 */
	
	//WORKING AS INTENDED
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
    {
	 
		//attempts seven times to pick a coord set that is valid for changing
		for (int l = 0; l < 7; ++l)
		{
			//generates a random coord within a radius of 2 units
			int i1 = x + random.nextInt(5) - 3;
           	int j1 = y + random.nextInt(5) - 3;
           	int k1 = z + random.nextInt(5) - 3;
            	
            //changes grass to SubRadiationBlock if there is air above it (air clause may be unnessasary)
            if ( (world.getBlock(i1, j1, k1) == Blocks.grass) && (world.getBlock(i1, j1+1, k1) == Blocks.air) )
            {
            	world.setBlock(i1, j1, k1, this);
           	}
            //changes adjcent logs to SubRadiationBlocks
           	else if( (world.getBlock(i1, j1, k1) == Blocks.log) || (world.getBlock(i1, j1, k1) == Blocks.log2) ){
            	world.setBlock(i1, j1, k1, this);
           	}
            	
       }
    }
}
