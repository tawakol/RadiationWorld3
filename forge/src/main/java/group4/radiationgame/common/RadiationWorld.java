package group4.radiationgame.common;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
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


public class RadiationWorld implements IWorldGenerator{
	public RadiationWorld(){
		WorldType RadiationWorld = new WorldType("RadiationWorld");
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
	}

}
