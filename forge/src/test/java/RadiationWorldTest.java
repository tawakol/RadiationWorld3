package group4.radiationgame.common;


import net.minecraft.world.chunk.IChunkProvider ;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import net.minecraft.world.World;

import org.junit.Test;

import cpw.mods.fml.common.registry.GameRegistry;

public class RadiationWorldTest {

	RadiationWorld radWorld = createNiceMock(RadiationWorld.class);

	World world = null;
	Random ran;
	
	@Test
	public void testGenerate() {
		
		// test the void return method whether called successfully
		
		IChunkProvider chunkGenerator = null, chunkProvider = null;
		radWorld.generate(ran, 0, 0, world, chunkGenerator, chunkProvider);
		replay(radWorld);
		
		try {
			GameRegistry.registerWorldGenerator(radWorld, 5);
		     
		} catch (RuntimeException e) {

		}		
		verify(radWorld);	
		
	}
	
	@Test
	public void testGetter() {
		World RadiationWorld = null;
		assertEquals(RadiationWorld, radWorld.getWorldType());
	}

}
