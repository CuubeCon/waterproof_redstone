package io.github.cuubecon.waterproofredstone.event;

import io.github.cuubecon.waterproofredstone.block.CustomRedstoneWireBlock;
import io.github.cuubecon.waterproofredstone.block.ModBlocks;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Block event){
        event.getBlockColors().register((p_92616_, p_92617_, p_92618_, p_92619_) -> {
            return CustomRedstoneWireBlock.getColorForPower(p_92616_.getValue(CustomRedstoneWireBlock.POWER));
        }, ModBlocks.CUSTOM_REDSTONE_WIRE.get());

    }
}
