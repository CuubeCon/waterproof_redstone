package io.github.cuubecon.waterproofredstone.item;

import io.github.cuubecon.waterproofredstone.WaterproofRedstone;
import io.github.cuubecon.waterproofredstone.block.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, WaterproofRedstone.MOD_ID);
    public static final RegistryObject<Item> CUSTOM_REDSTONE = ITEMS.register("custom_redstone_wire",
            () -> new ItemNameBlockItem(ModBlocks.CUSTOM_REDSTONE_WIRE.get(), new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));

    public static final RegistryObject<Item> CUSTOM_REDSTONE_TORCH = ITEMS.register("custom_redstone_torch",
            () -> new StandingAndWallBlockItem(ModBlocks.CUSTOM_REDSTONE_TORCH.get(), ModBlocks.CUSTOM_REDSTONE_WALL_TORCH.get(), new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_REPEATER = ITEMS.register("custom_repeater",
            () -> new BlockItem(ModBlocks.CUSTOM_REPEATER.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_LEVER = ITEMS.register("custom_lever",
            () -> new BlockItem(ModBlocks.CUSTOM_LEVER.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_STONE_BUTTON = ITEMS.register("custom_stone_button",
            () -> new BlockItem(ModBlocks.CUSTOM_STONE_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_COMPARATOR = ITEMS.register("custom_comparator",
            () -> new BlockItem(ModBlocks.CUSTOM_COMPARATOR.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_OAK_BUTTON = ITEMS.register("custom_oak_button",
            () -> new BlockItem(ModBlocks.CUSTOM_OAK_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_SPRUCE_BUTTON = ITEMS.register("custom_spruce_button",
            () -> new BlockItem(ModBlocks.CUSTOM_SPRUCE_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_BIRCH_BUTTON = ITEMS.register("custom_birch_button",
            () -> new BlockItem(ModBlocks.CUSTOM_BIRCH_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_JUNGLE_BUTTON = ITEMS.register("custom_jungle_button",
            () -> new BlockItem(ModBlocks.CUSTOM_JUNGLE_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_ACACIA_BUTTON = ITEMS.register("custom_acacia_button",
            () -> new BlockItem(ModBlocks.CUSTOM_ACACIA_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_DARK_OAK_BUTTON = ITEMS.register("custom_dark_oak_button",
            () -> new BlockItem(ModBlocks.CUSTOM_DARK_OAK_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_CRIMSON_BUTTON = ITEMS.register("custom_crimson_button",
            () -> new BlockItem(ModBlocks.CUSTOM_CRIMSON_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_WARPED_BUTTON = ITEMS.register("custom_warped_button",
            () -> new BlockItem(ModBlocks.CUSTOM_WARPED_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));
public static final RegistryObject<Item> CUSTOM_POLISHED_BLACKSTONE_BUTTON = ITEMS.register("custom_polished_blackstone_button",
            () -> new BlockItem(ModBlocks.CUSTOM_POLISHED_BLACKSTONE_BUTTON.get(),  new Item.Properties().tab(ModCreativeModeTab.WATERPROOFREDSTONE_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
