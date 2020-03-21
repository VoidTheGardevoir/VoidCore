package com.voids.voidcore.init;

import com.voids.voidcore.VoidCore;
import com.voids.voidcore.VoidCore.vcoreItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = VoidCore.MOD_ID, bus = Bus.MOD)

public class ItemInit 
{
	//this creates this deferred registry
	public static DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS , VoidCore.MOD_ID);
	
	//gems
	public static RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	public static RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	
	//dust
	public static RegistryObject<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust", () -> 
		new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	public static RegistryObject<Item> RUBY_DUST = ITEMS.register("ruby_dust", () -> 
		new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	public static RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> 
		new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	public static RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () -> 
		new Item(new Item.Properties().group(vcoreItemGroup.instance)));
	public static RegistryObject<Item> QUARTZ_DUST = ITEMS.register("quartz_dust", () -> 
		new Item(new Item.Properties().group(vcoreItemGroup.instance)));
			
}
