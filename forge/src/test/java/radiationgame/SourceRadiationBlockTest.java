package group4.radiationgame;

import static org.junit.Assert.*;
import group4.radiationgame.block.SourceRadiationBlock;

import org.junit.Test;

public class SourceRadiationBlockTest {

	// create a object for test class
	SourceRadiationBlock sourBlock = new SourceRadiationBlock();

	@Test
	public void testName() {
		
		
		assertEquals("SourceRadiation", sourBlock.getBlockName());
	}
	

}
