package group4.radiationgame;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import net.minecraft.world.World;

import org.junit.Test;

import cpw.mods.fml.common.registry.GameRegistry;
import group4.radiationgame.common.*;
import group4.radiationgame.block.*;

public class SubRadiationBlockTest {

	// create a mock for null return class
	SubRadiationBlock subBlock = createNiceMock(SubRadiationBlock.class);
	Random ran;
	World world = null;
	
	
	@Test
	public void testUpdateTick() {	
		
		// test the void return method whether called successfully
		subBlock.updateTick(world, 0, 0,0, ran);
		replay(subBlock);
		try {
			GameRegistry.registerBlock(subBlock, "SubRadiationBlock");
		     
		} catch (RuntimeException e) {

		}
		
		verify(subBlock);
	}

}
