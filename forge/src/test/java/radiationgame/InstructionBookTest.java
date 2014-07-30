package group4.radiationgame;

import static org.junit.Assert.*;
import group4.radiationgame.block.InstructionBook;
import group4.radiationgame.common.RadiationHouse;

import org.easymock.EasyMock;
import org.junit.Test;

public class InstructionBookTest {

	// create instruction book object as easymock
	InstructionBook inBook = EasyMock.createMock(InstructionBook.class);
	InstructionBook book = new InstructionBook();
	
	/**
	 * test for putInstructions function in instruction book class
	 */
	@Test
	public void putInstructionsTest() {
		
		// replay the state of inbook putInstructions function when it is called
		inBook.putInstructions();
		EasyMock.replay(inBook);
		
		// call the function within a new object
		book = inBook;
		book.putInstructions();
		
		// verify the state whether is the same as record
		EasyMock.verify(inBook);
	}
	
	/**
	 * test for getDirection function for instruction book class
	 */
	@Test
	public void getDirectionTest() {
		
		// record the state when the inbook.getDirection has been called
		EasyMock.expect(inBook.getDirection(0,0)).andReturn("Get Called");
		EasyMock.replay(inBook);
		
		inBook.getDirection(0,0);
		
		// check the state
		EasyMock.verify(inBook);
		
		
	}
	

}
