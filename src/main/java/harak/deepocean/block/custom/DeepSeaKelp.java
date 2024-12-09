package harak.deepocean.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SeagrassBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DeepSeaKelp extends SeagrassBlock
{
    public DeepSeaKelp(Settings settings) {
        super(settings);
    }
    protected static final float field_31242 = 6.0F;

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return true;
    }
}
