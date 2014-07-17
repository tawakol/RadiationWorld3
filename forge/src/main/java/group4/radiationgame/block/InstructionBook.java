package group4.radiationgame.block;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
public class InstructionBook extends ItemEditableBook{
	
	public InstructionBook(){
		super();
		this.setContainerItem(getContainerItem());
	
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("myBook");
    	this.setTextureName("book_normal");
		LanguageRegistry.addName(this, "The Instruction Book");

		this.setTextureName("book_normal");
		
	}
	public void putInstructions()
	{
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("WELCOME USER"));
	}
	
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	putInstructions();
    	
    	double X = par3EntityPlayer.posX;
		double Y = par3EntityPlayer.posY;
		double Z = par3EntityPlayer.posZ;	
		 
    	
    	
    	
    	
        return par1ItemStack;
    }
	
}
