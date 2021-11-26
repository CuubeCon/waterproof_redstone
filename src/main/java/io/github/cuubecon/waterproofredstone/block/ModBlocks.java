package io.github.cuubecon.waterproofredstone.block;

import io.github.cuubecon.waterproofredstone.WaterproofRedstone;
import io.github.cuubecon.waterproofredstone.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WaterproofRedstone.MOD_ID);


    public static final RegistryObject<Block> CUSTOM_REDSTONE_WIRE =
            registerBlock("custom_redstone_wire", () -> new CustomRedstoneWireBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak()));
 public static final RegistryObject<Block> CUSTOM_REPEATER =
            registerBlock("custom_repeater", () -> new CustomRepeaterBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_REDSTONE_TORCH =
            registerBlock("custom_redstone_torch", () -> new CustomRedstoneTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_REDSTONE_WALL_TORCH =
            registerBlock("custom_redstone_wall_torch", () -> new CustomRedstoneWallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.WOOD).dropsLike(CUSTOM_REDSTONE_TORCH.get())));
public static final RegistryObject<Block> CUSTOM_LEVER =
            registerBlock("custom_lever", () -> new CustomLeverBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_STONE_BUTTON =
            registerBlock("custom_stone_button", () -> new CustomStoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F)));
    public static final RegistryObject<Block> CUSTOM_POLISHED_BLACKSTONE_BUTTON =
            registerBlock("custom_polished_blackstone_button", () -> new CustomStoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F)));

public static final RegistryObject<Block> CUSTOM_COMPARATOR =
            registerBlock("custom_comparator", () -> new CustomComparatorBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().sound(SoundType.WOOD)));


    public static final RegistryObject<Block> CUSTOM_OAK_BUTTON =
            registerBlock("custom_oak_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CUSTOM_SPRUCE_BUTTON =
            registerBlock("custom_spruce_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_BIRCH_BUTTON =
            registerBlock("custom_birch_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_JUNGLE_BUTTON =
            registerBlock("custom_jungle_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_ACACIA_BUTTON =
            registerBlock("custom_acacia_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CUSTOM_DARK_OAK_BUTTON =
            registerBlock("custom_dark_oak_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_CRIMSON_BUTTON =
            registerBlock("custom_crimson_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
public static final RegistryObject<Block> CUSTOM_WARPED_BUTTON =
            registerBlock("custom_warped_button", () -> new CustomWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
       // registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
