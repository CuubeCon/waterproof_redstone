package io.github.cuubecon.waterproofredstone.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WATERPROOFREDSTONE_TAB = new CreativeModeTab("waterproofredstone_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CUSTOM_REDSTONE.get());
        }
    };
}
