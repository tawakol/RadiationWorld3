package group4.radiationgame;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import org.easymock.EasyMock;
import org.junit.Test;

import cpw.mods.fml.common.registry.GameRegistry;
import group4.radiationgame.common.*;
import group4.radiationgame.block.*;

public class SubRadiationBlockTest {

	// create objects for the test
	SubRadiationBlock subBlock = EasyMock.createMock(SubRadiationBlock.class);
	Block SubRadBlock = new SubRadiationBlock();
	
	
	@Test
	public void testUpdateTick() {	
		
		// create the variable for calling function
		Random ran = new Random();
		World world = null;
		subBlock.updateTick(world, 0, 0,0, ran);
		
		// record the status of the object
		EasyMock.replay(subBlock);	
		
		// call the function in the real
		SubRadBlock = subBlock;
		
		try {
			GameRegistry.registerBlock(SubRadBlock, "SubRadiationBlock");
		     
		} catch (RuntimeException e) {

		}
		SubRadBlock.updateTick(world, 0,0,0,ran);
		
		//verify the object
		verify(subBlock);
	}

}
