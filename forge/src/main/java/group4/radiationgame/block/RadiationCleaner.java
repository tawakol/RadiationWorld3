package group4.radiationgame.block;
import java.util.Random;

import group4.radiationgame.common.RadiationMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * 
 * @author Group4
 *
 * Item given to the player to clean up the sub radiation blocks
 */
public class RadiationCleaner extends Item{
	
	static int count = 0;
	//Name it Decon-90 in game because thats the name of a real radiation glassware cleaner
	
	public RadiationCleaner(){
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("radiationCleaner");
    	this.setTextureName("sword_normal");
		LanguageRegistry.addName(this, "Decon-90");

	}
	/**
	 * @param itemStack
	 * @param world
	 * @param EntityPlayer
	 * 
	 * 
	 * On use search the immediate vicinity of the player for SubRadiationBlock's and replaces them with mellons
	 */
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer EntityPlayer)
	 {
		 double X = EntityPlayer.posX;
		 double Y = EntityPlayer.posY;
		 double Z = EntityPlayer.posZ;	
		 int counter = 0;
		 		 
		 
		 for (int i = (int)X - 2; i < (int)X + 2; i++) {
			for (int j = (int)Y - 2; j < (int)Y + 2; j++){
				 for(int k = (int)Z - 2; k < (int)Z + 2; k++){
					 if ( (world.getBlock(i, j, k).equals(GameRegistry.findBlock("RadiationMod", "SubRadiationBlock"))))
					 {
						 world.setBlock(i, j, k, Blocks.melon_block);
						 EntityPlayer.addChatMessage(new ChatComponentText("Block changed!"));
					 } //else 
						 //EntityPlayer.addChatMessage(new ChatComponentText("No radiation blocks in range"));
				 }
			 }
		 }
		
		 
		return itemStack;
		
	 }
	 
	 /**
		 * @param itemStack
		 * @param world
		 * @param EntityPlayer
		 * 
		 * 
		 * onUpdate the item will check within the area for SubRadiationBlocks blocks and display that information
		 * to the player as a chat message
		 * 
		 *  Depending on this value the player will be given a potion effect,one to heal when few blocks are near and 
		 *  one to harm when more are near 
		 */
	 public void onUpdate(ItemStack item, World world, Entity entity, int x, boolean any){
	 	if(count == 150){
	 		double X = entity.posX;
	 		double Y = entity.posY;
	 		double Z = entity.posZ;
			 
		 	int radiationCounter = 0;
			 	 
		 	for (int i = (int)X - 3; i < (int)X + 3; i++) {
				for (int j = (int)Y - 3; j < (int)Y + 3; j++){
				 	for(int k = (int)Z - 3; k < (int)Z + 3; k++){
	         	
				 		if ((world.getBlock(i, j, k).equals(GameRegistry.findBlock("RadiationMod", "SubRadiationBlock"))))
					 	{
						 	radiationCounter++;
					 	}
				 	}
			 	}
		 	}
		 	
		 	//Adds poison effect to the player when they are near the radiation blocks a number of radiation blocks
		 	
		 	//Don't have correct ID's needs fix 
		 	if(radiationCounter < 3){
		 		Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(20, 50000, 100));
		 	}else if(radiationCounter < 6){
		 		Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(19, 5, 1));
		 	}else if(radiationCounter < 11){
		 		Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(19, 5, 2));
		 	}else
		 		Minecraft.getMinecraft().thePlayer.addPotionEffect(new PotionEffect(19, 5, 4));
		 	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Number of radiation blocks: " + radiationCounter));
		 	count = 0;
	 	}
	 	count++;
	 }
	 	
}