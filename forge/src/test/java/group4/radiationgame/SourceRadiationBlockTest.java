package group4.radiationgame;

import static org.junit.Assert.*;
import group4.radiationgame.block.SourceRadiationBlock;

import org.junit.Test;

public class SourceRadiationBlockTest {

	// create a mock for null return class
	SourceRadiationBlock sourBlock = new SourceRadiationBlock();

	@Test
	public void testHardness() {
	
		
		assertEquals(0.5f, sourBlock.getHardness());
	}
	
	@Test
	public void testName() {
		
		
		assertEquals("SourceRadiation", sourBlock.getBlockName());
	}
	

}
