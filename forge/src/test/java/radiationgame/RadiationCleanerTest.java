package group4.radiationgame;

import static org.junit.Assert.*;
import group4.radiationgame.block.InstructionBook;
import group4.radiationgame.block.RadiationCleaner;
import net.minecraft.item.ItemStack;

import org.easymock.EasyMock;
import org.junit.Test;

public class RadiationCleanerTest {

	RadiationCleaner rdclean = EasyMock.createMock(RadiationCleaner.class);
	RadiationCleaner clean = new RadiationCleaner(); 
	/**
	 * test for onItemRightClick function for cleaner class
	 */
	@Test
	public void onItemRightClickTest() {
		
		// record the status of the easymock object after calling fucntion
		ItemStack i = null;
		EasyMock.expect(rdclean.onItemRightClick(null, null, null)).andReturn(i);
		EasyMock.replay(rdclean);
		
		// call the function after create a new object of it
		clean = rdclean;
		clean.onItemRightClick(null, null, null);
		
		// verify the status
		EasyMock.verify(rdclean);
		
	}
	
	
	/**
	 * test for onUpdate function for cleaner class
	 */
	@Test
	public void onUpdateTest() {
		
		// record the status of the easymock object 
		rdclean.onUpdate(null, null, null, 0, true);
		EasyMock.replay(rdclean);
		
		// call the specific function real
		clean =rdclean;
		clean.onUpdate(null, null, null, 0, true);
		
		// check the status of object
		EasyMock.verify(rdclean);
	}

}
