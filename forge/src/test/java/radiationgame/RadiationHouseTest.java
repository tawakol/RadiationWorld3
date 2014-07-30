package group4.radiationgame;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import group4.radiationgame.block.InstructionBook;
import group4.radiationgame.block.SubRadiationBlock;
import group4.radiationgame.common.RadiationHouse;
import group4.radiationgame.common.RadiationWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import org.easymock.EasyMock;
import org.junit.Test;

import cpw.mods.fml.common.registry.GameRegistry;

public class RadiationHouseTest {

	// create object for the test
	World world; 	
	RadiationHouse radhous = EasyMock.createMock(RadiationHouse.class);
	Random ran = new Random();
	
	/**
	 * generate() function test in radiationhouse class
	 */
	@Test
	public void testGenerate() {
		
		// create a return value for generate function
		int[] a = new int [2];
		
		// record the state when generate has been called
		EasyMock.expect(radhous.generate(world, ran, 0,0,0)).andReturn(a);
		EasyMock.replay(radhous);
		
		// create a new radiation house object to redo the process 
		RadiationHouse house = new RadiationHouse();
		house = radhous;
		house.generate(world, ran, 0,0,0);
		
		// verify the state
		EasyMock.verify(radhous);
	
	}
	
	

}
