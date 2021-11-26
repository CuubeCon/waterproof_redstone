package io.github.cuubecon.waterproofredstone.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CustomStoneButtonBlock extends CustomButtonBlock{
    public CustomStoneButtonBlock(BlockBehaviour.Properties p_57060_) {
        super(false, p_57060_);
    }

    protected SoundEvent getSound(boolean p_57062_) {
        return p_57062_ ? SoundEvents.STONE_BUTTON_CLICK_ON : SoundEvents.STONE_BUTTON_CLICK_OFF;
    }
}
