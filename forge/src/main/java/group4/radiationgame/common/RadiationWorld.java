package group4.radiationgame.common;

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


public class RadiationWorld {
	public RadiationWorld(){
		WorldType RadiationWorld = new WorldType("RadiationWorld");
		
		
		//didnt work
		//GenLayerBiome radWorld = new GenLayerBiome((long)1234123412, RadiationWorld.getBiomeLayer((long)12341234, new GenLayer((long)1234123412)), this);
		
		//to restrict mobs set time to always day
	
	}

}
