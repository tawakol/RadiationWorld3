package group4.radiationgame.block;
import group4.radiationgame.common.RadiationMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * 
 * @author JDuck404
 *
 * Item given to the player to clean up the sub radiation blocks
 */
public class RadiationCleaner extends Item{
	
	//Name it Decon-90 in game because thats the name of a real radiation glassware cleaner
	
	public RadiationCleaner(){
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("radiationCleaner");
    	this.setTextureName("sword_normal");
		LanguageRegistry.addName(this, "The Radiation Eradicator");

	}
	/**
	 * @param itemStack
	 * @param world
	 * @param EntityPlayer
	 * 
	 * 
	 * On use search the immediate vicinity of the player for SubRadiationBlock's and replaces them with grass
	 */
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer EntityPlayer)
	    {
		 double X = EntityPlayer.posX;
		 double Y = EntityPlayer.posY;
		 double Z = EntityPlayer.posZ;
		 
		 int radiationCounter = 0;
		 int cleanedBlocks = 0;
		 
		 
		 for (int j = -2; j < 3; j++) {
			 for (int i = 0; i < 4; i++){
				 for(int k = -1; k < 2; k++){
         	
					 if ( (world.getBlock((int)X+i, (int)Y-k, (int)Z+j) == GameRegistry.findBlock("RadiationMod", "SubRadiationBlock")))
					 {
					 
						 world.setBlock((int)X+i, (int)Y-k, (int)Z+j, Blocks.waterlily);
 
						 cleanedBlocks++;
						 radiationCounter++;
					 }
				 }
			 }
		 }
		 
		 //In game chat output of number of blocks in the area
		 Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Number of radiation blocks: " + radiationCounter));
		 return itemStack;
	    }
	}