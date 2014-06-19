package group4.radiationgame.block;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
public class InstructionBook extends ItemEditableBook{
	
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
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
	{
		NBTTagList bookTagList = new NBTTagList();

		bookTagList = putInstructions(bookTagList);
		
		itemStack.setTagInfo("pages", bookTagList);
		itemStack.setTagInfo("author", new NBTTagString("author"));
		itemStack.setTagInfo("title", new NBTTagString("title"));
		
	}
	
	
}
