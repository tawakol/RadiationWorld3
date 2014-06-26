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
	 * 
	 * 
	 */
	
	//WORKING AS INTENDED
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
    {
		
        if (!world.isRemote)
        {    
            
            for (int l = 0; l < 4; ++l)
            {
            	int i1 = x + random.nextInt(3) - 1;
            	int j1 = y + random.nextInt(4) - 2;
            	int k1 = z + random.nextInt(3) - 1;
            	
            	//System.out.print("\n" + (world.getBlock(i1, j1, k1) == Blocks.grass) +" " +(world.getBlock(i1, j1+1, k1) == Blocks.air));
            	
            	if ( (world.getBlock(i1, j1, k1) == Blocks.grass) && (world.getBlock(i1, j1+1, k1) == Blocks.air) )
            	{
            		//System.out.println(" CHANGE");
            		world.setBlock(i1, j1, k1, this);
            	}
            }
        }
    }
}
