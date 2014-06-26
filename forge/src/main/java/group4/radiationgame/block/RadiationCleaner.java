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
		 
		 		 
		 for (int l = 0; l < 4; ++l)
         {
         	
         	//System.out.print((world.getBlock(X, Y, Z) == Blocks.dirt) +" " +(world.getBlock(X, Y, Z) == Blocks.air));
         	
         	if ( (world.getBlock((int)X, (int)Y, (int)Z) == Blocks.mycelium));
         	{
         		System.out.println(" CHANGE");
         		world.setBlock((int)X, (int)Y, (int)Z, Blocks.anvil);
         	}
         	System.out.println("\n");
         	
         }
		 return itemStack;
	    }
	}