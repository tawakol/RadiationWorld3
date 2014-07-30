package group4.radiationgame;

import static org.junit.Assert.*;
import group4.radiationgame.block.SourceRadiationBlock;

import org.easymock.EasyMock;
import org.junit.Test;

public class SourceRadiationBlockTest {

	// create a object for test class
	SourceRadiationBlock sourBlock = EasyMock.createMock(SourceRadiationBlock.class);
	SourceRadiationBlock block = new SourceRadiationBlock();
	
	/**
	 *  getBlockName test for source Radiation block class
	 */
	@Test
	public void testName() {
		
		// record the status for the object
		EasyMock.expect(sourBlock.getBlockName()).andReturn("be called");
		EasyMock.replay(sourBlock);
		
		// call the function in real
		block = sourBlock;
		block.getBlockName();
		
		// verify the status
		EasyMock.verify(sourBlock);
		
	}
	

}
