package group4.radiationgame.block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
public class InstructionBook extends ItemEditableBook{
	
	public InstructionBook(){
		super();
		
	}
	public NBTTagList putInstructions(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("Hello world!"));

		
		return bookTagList;
	}
	
	
}
