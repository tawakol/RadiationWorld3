package group4.radiationgame;


import net.minecraft.world.chunk.IChunkProvider ;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.Random;

import net.minecraft.world.World;

import org.easymock.EasyMock;
import org.junit.Test;

import com.mojang.realmsclient.dto.McoServer.WorldType;

import cpw.mods.fml.common.registry.GameRegistry;
import group4.radiationgame.common.RadiationWorld;

public class RadiationWorldTest {

	
	RadiationWorld radWorld = new RadiationWorld();

	
	@Test
	public void testGetter() {
		
		net.minecraft.world.WorldType RadiationWorld = radWorld.getWorldType();
		assertEquals(RadiationWorld, radWorld.getWorldType());
	}

}
