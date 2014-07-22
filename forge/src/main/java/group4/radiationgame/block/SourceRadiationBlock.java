package group4.radiationgame.block;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
/**
 * 
 * @author JDuck404
 *
 * Source radiation block that the player has to destroy to win the game
 *	
 */
//Create a new block child class
public class SourceRadiationBlock extends Block{
    

	public SourceRadiationBlock () 
    {
           super(new Material(null));
            
           this.setHardness(0.5f);
           this.setStepSound(Block.soundTypeMetal);
           this.setBlockName("SourceRadiation");
           this.setCreativeTab(CreativeTabs.tabBlock);
           this.setBlockTextureName("radiationgame:SourceRadiationBlockRed");
            
    }

	public float getHardness()
	{
		return this.getHardness();
	}
	public String getBlockName()
	{
		return this.getBlockName();
	}
	
	
}
