package com.voids.voidcore.init;

import com.voids.voidcore.VoidCore;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(VoidCore.MOD_ID )
@Mod.EventBusSubscriber(modid = VoidCore.MOD_ID, bus = Bus.MOD)

public class BlockInit 
{
	//this creates this deferred registry
	public static DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS , VoidCore.MOD_ID);
	
	//full blocks
	public static RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> 
		new Block(Block.Properties.create(Material.IRON).
				hardnessAndResistance(5.0F, 6.0F).
				sound(SoundType.METAL).
				harvestTool(ToolType.PICKAXE)));
	public static RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> 
		new Block(Block.Properties.create(Material.IRON).
				hardnessAndResistance(5.0F, 6.0F).
				sound(SoundType.METAL).
				harvestTool(ToolType.PICKAXE)));
	
	//ores
	public static RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> 
	new Block(Block.Properties.create(Material.ROCK).
			hardnessAndResistance(5.0F, 6.0F).
			sound(SoundType.STONE).
			harvestTool(ToolType.PICKAXE).
			harvestLevel(2)));
	public static RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> 
	new Block(Block.Properties.create(Material.ROCK).
			hardnessAndResistance(5.0F, 6.0F).
			sound(SoundType.STONE).
			harvestTool(ToolType.PICKAXE).
			harvestLevel(2)));
	
	
	
	
}
