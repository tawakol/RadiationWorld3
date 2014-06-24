package group4.radiationgame.block;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
import net.minecraft.world.World;
public class InstructionBook extends ItemWritableBook{
	
	public InstructionBook(){
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("myBook");
    	this.setTextureName("book_normal");
		LanguageRegistry.addName(this, "The Instruction Book");

		this.setTextureName("book_normal");
		
	}
	public NBTTagList putInstructions(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("Hello world!"));

		
		return bookTagList;
	}
	
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	System.out.println(par1ItemStack);
        par3EntityPlayer.displayGUIBook(par1ItemStack);
        return par1ItemStack;
    }
    
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
	{
		NBTTagList bookTagList = new NBTTagList();

		bookTagList = putInstructions(bookTagList);
		
		itemStack.setTagInfo("pages", bookTagList);
		//itemStack.setTagInfo("author", new NBTTagString("Group 6"));
		//itemStack.setTagInfo("title", new NBTTagString("Radiation Cleansing Guide"));
		
	}
	
	
}
