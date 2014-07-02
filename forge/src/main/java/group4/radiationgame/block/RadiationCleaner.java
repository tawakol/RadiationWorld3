package group4.radiationgame.block;
import group4.radiationgame.common.RadiationMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 
 * @author JDuck404
 *
 * Item given to the player to clean up the sub radiation blocks
 */
public class RadiationCleaner extends Item{
	
	
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
		 
		 SubRadiationBlock rblock = new SubRadiationBlock();
		 
		 //System.out.println("X" + X + "Y" + Y + "Z" + Z);
		// System.out.println("INT VALUES OF X, Y, Z: " + (int)X + ", " + (int)Y + ", " + (int)Z);
		 for (int j = -2; j<3; j++) {
		 for (int i = 0; i < 4; i++)
         {
         	
         	//System.out.print((world.getBlock(X, Y, Z) == Blocks.dirt) +" " +(world.getBlock(X, Y, Z) == Blocks.air));
         	
         	if ( (world.getBlock((int)X+i, (int)Y-1, (int)Z+j) == GameRegistry.findBlock("RadiationMod", "SubRadiationBlock")))
         	{
         		radiationCounter++;
         		System.out.println("Number of radiation blocks: " + radiationCounter);
         		world.setBlock((int)X+i, (int)Y-1, (int)Z+j, Blocks.gold_ore);
         		cleanedBlocks++;
         	}
         	//System.out.println("\n");
         	
       
         	
         }
		 }
		 return itemStack;
	    }
	}