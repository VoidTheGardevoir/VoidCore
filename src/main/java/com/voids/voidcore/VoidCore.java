package com.voids.voidcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.voids.voidcore.init.BlockInit;
import com.voids.voidcore.init.ItemInit;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("vcore")
@Mod.EventBusSubscriber(modid = VoidCore.MOD_ID, bus = Bus.MOD)
public class VoidCore {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "vcore";
    public static VoidCore instance;

    public VoidCore()  {
    	final IEventBus modEventbus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventbus.addListener(this::setup);
    	modEventbus.addListener(this::doClientStuff);
        
        
        instance = this;
        
        ItemInit.ITEMS.register(modEventbus);
        BlockInit.BLOCKS.register(modEventbus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(vcoreItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		LOGGER.debug("Registered BlockItems!");
	}

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }
    
    
    //this creates the creative tab
    public static class vcoreItemGroup extends ItemGroup 
    {
    	public static final vcoreItemGroup instance = new vcoreItemGroup(ItemGroup.GROUPS.length , "vcore");
    	
    	private vcoreItemGroup(int index, String label) 
    	{
    		super(index,label);
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.SAPPHIRE.get());
    		
    	}
    }
}

