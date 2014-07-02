package group4.radiationgame.block;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RadiationCleaner extends Item{
	
	public RadiationCleaner(){
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("radiationCleaner");
    	this.setTextureName("sword_normal");
		LanguageRegistry.addName(this, "The Radiation Eradicator");

	}
	
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer EntityPlayer)
	    {
		 double X = EntityPlayer.posX;
		 double Y = EntityPlayer.posY;
		 double Z = EntityPlayer.posZ;
		 
		 int radiationCounter = 0;
		 int cleanedBlocks = 0;
		 
		 System.out.println("X" + X + "Y" + Y + "Z" + Z);
		 System.out.println("INT VALUES OF X, Y, Z: " + (int)X + ", " + (int)Y + ", " + (int)Z);
		 for (int i = 0; i < 4; i++)
         {
         	
         	//System.out.print((world.getBlock(X, Y, Z) == Blocks.dirt) +" " +(world.getBlock(X, Y, Z) == Blocks.air));
         	
         	if ( (world.getBlock((int)X+i, (int)Y+i, (int)Z+i) == Blocks.grass))
         	{
         		radiationCounter++;
         		System.out.println("Number of radiation blocks: " + radiationCounter);
         		world.setBlock((int)X+i, (int)Y+i, (int)Z+i, Blocks.dragon_egg);
         		cleanedBlocks++;
         	}
         	System.out.println("\n");
         	
       
         	
         }
		 return itemStack;
	    }
	}