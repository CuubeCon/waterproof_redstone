package io.github.cuubecon.waterproofredstone;

import io.github.cuubecon.waterproofredstone.block.ModBlocks;
import io.github.cuubecon.waterproofredstone.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WaterproofRedstone.MOD_ID)
public class WaterproofRedstone
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "waterproofredstone";

    public WaterproofRedstone() {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::setupClient);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    private void setupClient(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_REDSTONE_WIRE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_REPEATER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_REDSTONE_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_REDSTONE_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_LEVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_STONE_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_COMPARATOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_POLISHED_BLACKSTONE_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_OAK_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_SPRUCE_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_BIRCH_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_JUNGLE_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_ACACIA_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_DARK_OAK_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_CRIMSON_BUTTON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUSTOM_WARPED_BUTTON.get(), RenderType.cutout());
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegistryEvents {


    }
}
