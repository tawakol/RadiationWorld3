package group4.radiationgame.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

/**
 * 
 * @author jDuck404
 *
 *
 *	Search class in the utilities package with static methods to search for blocks to make our code cleaner
 *  and more straight forward
 */
public class Search {
	
	
	/**
	 * 
	 * 
	 * @param world
	 * @param player
	 * @param block
	 * @param radius
	 * @return counter
	 * 
	 * 
	 * Searches around the players coordinates for a specified block and returns the count
	 */
	public static int numBlocksInRadius(World world, EntityPlayer player, Block block, int radius){
		int count = 0;
		
		for(int x = (int)player.posX - radius; x < (int)player.posX + radius; x++){
			for(int y = (int)player.posY - radius; y < (int)player.posY + radius; y++){
				for(int z = (int)player.posZ - radius; z < (int)player.posZ + radius; z++){
					if(world.getBlock(x, y, z).equals(block)){
						count++;
					}
						
				}
			}
		}
		
		return count;
		
	}
	
	public static int numBlocksInRadius(World world, EntityPlayer player, String blockName, int radius){
		int count = 0;
		
		for(int x = (int)player.posX - radius; x < (int)player.posX + radius; x++){
			for(int y = (int)player.posY - radius; y < (int)player.posY + radius; y++){
				for(int z = (int)player.posZ - radius; z < (int)player.posZ + radius; z++){
					if(world.getBlock(x, y, z) == GameRegistry.findBlock("RadiationMod", blockName)){
						count++;
					}	
				}
			}
		}
		
		return count;
		
	}
	
	public static int[] firstBlockInRadius(World world, EntityPlayer player, String blockName, int radius){
		int coords[] = new int[3];
		coords[1] = -1;
		
		for(int x = (int)player.posX - radius; x < (int)player.posX + radius; x++){
			for(int y = (int)player.posY - radius; y < (int)player.posY + radius; y++){
				for(int z = (int)player.posZ - radius; z < (int)player.posZ + radius; z++){
					if(world.getBlock(x, y, z) == GameRegistry.findBlock("RadiationMod", blockName)){
						coords[0] = x;
						coords[1] = y;
						coords[2] = z;
						return coords;
					}	
				}
			}
		}
		
		return coords;
		
	}
	
	public static void replaceBlockAt(World world, int[] coords, String blockName){
		
		
		
	}
	
}
