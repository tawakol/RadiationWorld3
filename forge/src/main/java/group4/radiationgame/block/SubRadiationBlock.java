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
		this.setBlockName("Sub Radiation Block")
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockUnbreakable()
		.setLightLevel((float)5);
		
		
	}
	
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
    {
		System.out.println("Ticking sub rad block");
        if (!world.isRemote)
        {
            
            if (world.getBlockLightValue(x, y + 1, z) >= 0)
            {
            	System.out.println("Begin spread chance");
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);
                    
                    System.out.println(i1 + " " + j1 + " " + k1 +" "+ (world.getBlock(i1, j1, k1) == Blocks.dirt));
                    
                    if (world.getBlock(i1, j1, k1) == Blocks.dirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                    	System.out.println("changing blocks");
                        world.setBlock(i1, j1, k1, this);
                    }
                }
            }
        }
    }
}
