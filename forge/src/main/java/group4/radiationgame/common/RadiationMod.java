package group4.radiationgame.common;

import java.util.Random;

import group4.radiationgame.block.InstructionBook;
import group4.radiationgame.block.RadiationCleaner;
import group4.radiationgame.block.SourceRadiationBlock;
import group4.radiationgame.block.SubRadiationBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagList;

@Mod(modid = RadiationMod.MODID, version = RadiationMod.VERSION)

/**
 * 
 * @author JDuck404
 * 
 * Radiation Mod that gets called on launch
 *
 */
public class RadiationMod
{
    public static final String MODID = "RadiationMod";
    public static final String VERSION = "1.0";
    
    
    /**
     * Init method
     * 
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
    
    
    /**
     * Load Method
     * adds all the new code to the game registery
     * 
     * @param event
     */
    @EventHandler
    public void load(FMLInitializationEvent event){
    	
    	//WorldType RadiationWorld = new WorldType("Radiation World");
    	
    	RadiationWorld world = new RadiationWorld();
    	//create a new SourceRadiationBlock instance, then set its properties
    	Block SourceRadiationBlock = new SourceRadiationBlock()
		.setBlockName("SourceRadiationBlock")
		.setHardness(0.5F)
		.setStepSound(Block.soundTypeMetal)
		.setCreativeTab(CreativeTabs.tabBlock)
		.setBlockTextureName("radiationgame:SourceRadiationBlock");
	
    	// create subRadiation block
    	Block SubRadBlock = new SubRadiationBlock()
    	.setBlockTextureName("radiationgame:SubRadiationBlock");
    	

    	//register the new block to the game.
    	GameRegistry.registerBlock(SourceRadiationBlock, "SourceRadiationBlock");
    	GameRegistry.registerBlock(SubRadBlock, "SubRadiationBlock");
    	//create a new instruction book and register it
    	InstructionBook myBook = new InstructionBook();


    	GameRegistry.registerItem(myBook, myBook.getUnlocalizedName());
    	
    	RadiationCleaner radiationCleaner = new RadiationCleaner();
    	GameRegistry.registerItem(radiationCleaner, radiationCleaner.getUnlocalizedName());

    }
}