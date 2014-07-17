package group4.radiationgame.common;

import java.util.Random;





import group4.radiationgame.block.InstructionBook;
//import group4.radiationgame.block.Instructions;
import group4.radiationgame.block.RadiationCleaner;
import group4.radiationgame.block.SourceRadiationBlock;
import group4.radiationgame.block.SubRadiationBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		//initialize stuff
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
    	Block SourceRadiationBlock = new SourceRadiationBlock();
	
    	// create subRadiation block
    	Block SubRadBlock = new SubRadiationBlock()
    	.setBlockTextureName("radiationgame:SubRadiationBlock");
    	

    	//register the new block to the game.
    	GameRegistry.registerBlock(SourceRadiationBlock, "SourceRadiationBlock");
    	GameRegistry.registerBlock(SubRadBlock, "SubRadiationBlock");
    	
    	GameRegistry.registerWorldGenerator(world, 5);
    	
    	RadiationCleaner radiationCleaner = new RadiationCleaner();
    	radiationCleaner.setTextureName("radiationgame:radiationcleaner");
    	GameRegistry.registerItem(radiationCleaner, radiationCleaner.getUnlocalizedName());
    	
    	InstructionBook book1 = new InstructionBook();
    	
    	GameRegistry.registerItem(book1, "myBook");
    	
    	ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(book1),1,1,100));
    	ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(radiationCleaner),1,1,100));
    	ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(SourceRadiationBlock),1,1,100));
    	ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(SubRadBlock),1,1,100));

    }
}