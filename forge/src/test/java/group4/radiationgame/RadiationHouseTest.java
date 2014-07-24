package group4.radiationgame;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import group4.radiationgame.block.SubRadiationBlock;
import group4.radiationgame.common.RadiationHouse;
import net.minecraft.world.World;

import org.junit.Test;

public class RadiationHouseTest {

	World world = null;
	RadiationHouse radhous = createNiceMock(RadiationHouse.class);
	Random ran;
	
	@Test
	public void testGenerate() {
		
		// test whether the function has been called
		expect(radhous.generate(world, ran, 0, 0, 0)).andReturn(true);
		replay(radhous);
		assertTrue(radhous.generate(world, ran, 0, 0, 0));
		verify(radhous);
	}
	
	

}
