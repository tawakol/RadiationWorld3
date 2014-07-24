package group4.radiationgame.block;
import java.util.Random;

import group4.radiationgame.common.RadiationHouse;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
public class InstructionBook extends ItemEditableBook{
	boolean first = true;
	
	int[] houseCoords;
	double distance = 100000;
	public InstructionBook(){
		
		super();
		this.setContainerItem(getContainerItem());
		this.setCreativeTab(CreativeTabs.tabTools);
    	this.setUnlocalizedName("myBook");
    	this.setTextureName("book_normal");
		LanguageRegistry.addName(this, "The Instruction Book");

		this.setTextureName("book_normal"); 
		
		houseCoords = new int[2];
	}
	public void putInstructions()
	{
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Welcome Agent.. You have been recruited to complete a time critical mission that could very well save the world. The enemy has planted a new fangled form of radiation that spreads itself and grows indefinitely!"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("In your inventory you will find Decon-90, you will use this to clean the radiation by rightclicking when facing it, follow the radiation to find the source and destroy it! Good luck!"));
	}
	
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	System.out.println("Getting to before instructions");
    	putInstructions();

    	if(first){
    		System.out.println("Getting inside first");
    		RadiationHouse house = new RadiationHouse();
    		System.out.println("radiation house created");
    	 	first = false;
    		int[] a = house.generate(par2World, new Random(), (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
    		System.out.println("house generated");
    		houseCoords[0] = a[0];
    		houseCoords[1] = a[1];
    	}
    	
    	distance = par3EntityPlayer.getDistance(houseCoords[0], 60, houseCoords[1]);
    	par3EntityPlayer.addChatMessage(new ChatComponentText("You are currently " + (int)distance +" metres far from the source"));
        return par1ItemStack;
    }
	
    public String getDirection(int x, int z){
    	String s = "Our intel has shown us that the radiation source is ";
    	double[] a = getUnitVector(x, z);
    	
    	if(a[0] > .85){
    		s += "North of your current position";
    	}else if(a[0] < -.85){
    		s += "South of your current position";
    	}else if(a[1] > .85){
    		s += "East of your current position";
    	}else if(a[1] < -.85){
    		s += "West of your current position";
    	}else{
    		s += "In between";
    	}
    		
    		
    	return s;
    }
    private double[] getUnitVector(int x, int z){
    	double[] a = new double[2];
    	a[0] = x - houseCoords[0];
    	a[1] = z - houseCoords[1];
    	
    	double len = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
    	
    	a[0] = a[0]/len;
    	a[1] = a[1]/len;
    	
    	return a;
    }
}

