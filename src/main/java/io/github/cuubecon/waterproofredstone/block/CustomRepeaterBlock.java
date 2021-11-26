package io.github.cuubecon.waterproofredstone.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class CustomRepeaterBlock extends DiodeBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final BooleanProperty LOCKED = BlockStateProperties.LOCKED;
    public static final IntegerProperty DELAY = BlockStateProperties.DELAY;

    public CustomRepeaterBlock(BlockBehaviour.Properties p_55801_) {
        super(p_55801_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(DELAY, Integer.valueOf(1)).setValue(LOCKED, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)).setValue(WATERLOGGED, false));
    }

    public InteractionResult use(BlockState p_55809_, Level p_55810_, BlockPos p_55811_, Player p_55812_, InteractionHand p_55813_, BlockHitResult p_55814_) {
        if (!p_55812_.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        } else {
            p_55810_.setBlock(p_55811_, p_55809_.cycle(DELAY), 3);
            return InteractionResult.sidedSuccess(p_55810_.isClientSide);
        }
    }
    public FluidState getFluidState(BlockState p_152158_) {
        return p_152158_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_152158_);
    }

    protected int getDelay(BlockState p_55830_) {
        return p_55830_.getValue(DELAY) * 2;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_55803_) {
        BlockState blockstate = super.getStateForPlacement(p_55803_);
        FluidState fluidstate = p_55803_.getLevel().getFluidState(p_55803_.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return blockstate.setValue(LOCKED, Boolean.valueOf(this.isLocked(p_55803_.getLevel(), p_55803_.getClickedPos(), blockstate))).setValue(WATERLOGGED, flag);
    }

    public BlockState updateShape(BlockState p_55821_, Direction p_55822_, BlockState p_55823_, LevelAccessor p_55824_, BlockPos p_55825_, BlockPos p_55826_) {
        if (p_55821_.getValue(WATERLOGGED)) {
            p_55824_.getLiquidTicks().scheduleTick(p_55825_, Fluids.WATER, Fluids.WATER.getTickDelay(p_55824_));
        }
        return !p_55824_.isClientSide() && p_55822_.getAxis() != p_55821_.getValue(FACING).getAxis() ? p_55821_.setValue(LOCKED, Boolean.valueOf(this.isLocked(p_55824_, p_55825_, p_55821_))) : super.updateShape(p_55821_, p_55822_, p_55823_, p_55824_, p_55825_, p_55826_);
    }

    public boolean isLocked(LevelReader p_55805_, BlockPos p_55806_, BlockState p_55807_) {
        return this.getAlternateSignal(p_55805_, p_55806_, p_55807_) > 0;
    }

    protected boolean isAlternateInput(BlockState p_55832_) {
        return isDiode(p_55832_);
    }

    public void animateTick(BlockState p_55816_, Level p_55817_, BlockPos p_55818_, Random p_55819_) {
        if (p_55816_.getValue(POWERED)) {
            Direction direction = p_55816_.getValue(FACING);
            double d0 = (double)p_55818_.getX() + 0.5D + (p_55819_.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double)p_55818_.getY() + 0.4D + (p_55819_.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double)p_55818_.getZ() + 0.5D + (p_55819_.nextDouble() - 0.5D) * 0.2D;
            float f = -5.0F;
            if (p_55819_.nextBoolean()) {
                f = (float)(p_55816_.getValue(DELAY) * 2 - 1);
            }

            f = f / 16.0F;
            double d3 = (double)(f * (float)direction.getStepX());
            double d4 = (double)(f * (float)direction.getStepZ());
            p_55817_.addParticle(DustParticleOptions.REDSTONE, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55828_) {
        p_55828_.add(FACING, DELAY, LOCKED, POWERED, WATERLOGGED);
    }
}
