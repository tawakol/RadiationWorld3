package group4.radiationgame.common;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.WorldProvider;


/**
 * @author JDuck404
 * 
 * 
 * 
 * 
 * 
 */

public class RadiationWorld implements IWorldGenerator{
	
	WorldType RadiationWorld;
	
	
	/**
	 * Constructor
	 * 
	 * Creates new WorldType with the string "RadiationWorld" as a title
	 */
	public RadiationWorld(){
		RadiationWorld = new WorldType("RadiationWorld");
	}
	
	/**
	 * Get the world type
	 * 
	 * @return RadiationWorld
	 */
	public WorldType getWorldType(){
		return RadiationWorld;
	}
	
	
	
	/**
	 * 
	 * 
	 * 
	 */
	//never gets called WTF why
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		System.out.println("gets called by system");
		
		RadiationHouse house = new RadiationHouse();
    	house.generate(world, new Random(), 0, 64, 0);
		
	}

}
