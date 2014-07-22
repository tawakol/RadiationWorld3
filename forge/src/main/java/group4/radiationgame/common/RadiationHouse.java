package group4.radiationgame.common;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;
import group4.radiationgame.block.SourceRadiationBlock;
import group4.radiationgame.block.SubRadiationBlock;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChatComponentText;
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
 * @param generated used to stop threads from making thousands upon thousands of rooms on the map
 * 
 * 
 */

public class RadiationHouse extends WorldGenDungeons{
	
	private static boolean generated = false;
	
	public RadiationHouse(){
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
		
		int playerX = x;
		int playerZ = z;
		
		if(generated){
			return true;
		}
		String direction =  "Our intelligence has told us that the source of the radiation is  ";
		//math is cool
		//math.pow(-1, n) is an alternating 1, -1 to make more variation in just one line
		x = x + (int) ((Math.pow(-1, random.nextInt(4)) * 105) + (Math.pow(-1, random.nextInt(4)) * random.nextInt(50))); 
		z = z + (int) ((Math.pow(-1, random.nextInt(4)) * 105) + (Math.pow(-1, random.nextInt(4)) * random.nextInt(50)));
		
		if (x - playerX > 0 && z - playerZ > 0){
			direction += "North-east";
		}else if(x - playerX > 0 && z - playerZ < 0){
			direction += "North-west";
		}else if(x - playerX < 0 && z - playerZ < 0){
			direction += "South-west";
		}else{
			direction += "South-east";
		}
		
		direction += " from your current position";
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(direction));
		
		y = 15;
		
		while(!world.canBlockSeeTheSky(x, y, z)){
			y++;
		}
		

		Block sub = new SubRadiationBlock();
		Block source = new SourceRadiationBlock();
	
		
		byte b0 = 3;
		int width = random.nextInt(2) + 2;
		int depth = random.nextInt(2) + 2;
		int j1 = 2;
		int xCurr;
		int yCurr;
    	int zCurr;
        
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
    					//System.out.println("Air at :"+ xCurr + yCurr + zCurr +world.setBlockToAir(xCurr, yCurr, zCurr));
    					world.setBlockToAir(xCurr, yCurr, zCurr);
    				}
    			}
    		}

        
    		//new loop to iterate through the outside surface coords and replace them with SubRadiationBlocks
    		for (xCurr = x - width - 1; xCurr <= x + width + 1; xCurr++)
    		{
    			for (yCurr = y + b0 ; yCurr >= y -1 ; yCurr--)
    			{
    				for (zCurr = z - depth - 1; zCurr <= z + depth + 1; zCurr++)
    				{
    					if(zCurr == z - depth - 1 || zCurr == z + depth + 1  && yCurr == y + b0 || yCurr == y-1  && xCurr == x - width - 1 || xCurr == x + width + 1){
    						//System.out.println("Wall at :"+ xCurr + yCurr + zCurr + world.setBlock(xCurr, yCurr, zCurr, GameRegistry.findBlock("RadiationMod", "SubRadiationBlock")));
    						world.setBlock(xCurr, yCurr, zCurr, GameRegistry.findBlock("RadiationMod", "SubRadiationBlock"));
    					}
    				}
    			}
    		}
    		
    		//aserts that the house has been made correctly and stop furthur attempts
    		generated = true;
    		world.setBlock(x, y-1, z, GameRegistry.findBlock("RadiationMod", "SourceRadiationBlock"));
    		return true;
    	}
    	//flag a bad initialization
    	else
    	{
    		System.out.println("Couldnt generate miss 3");
    		return false;
    	}	
    }
	
}