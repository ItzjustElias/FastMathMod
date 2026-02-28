package org.elias.fastmath.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockPos.class)
public abstract class BlockPosMixin extends Vec3i {
    public BlockPosMixin(int x, int y, int z) { super(x, y, z); }

    /**
     * @author elias
     * @reason Optimized bit-packing for 1.21 coordinate limits.
     * Layout: [X (26 bits)] [Z (26 bits)] [Y (12 bits)]
     */
    @Overwrite
    public static long asLong(int x, int y, int z) {
        return (((long)x & 0x3FFFFFFL) << 38) |
                (((long)z & 0x3FFFFFFL) << 12) |
                ((long)y & 0xFFFL);
    }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract X correctly.
     */
    @Overwrite
    public static int unpackLongX(long packedPos) {
        return (int)(packedPos >> 38);
    }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract Y correctly.
     */
    @Overwrite
    public static int unpackLongY(long packedPos) {
        return (int)(packedPos << 52 >> 52);
    }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract Z correctly.
     */
    @Overwrite
    public static int unpackLongZ(long packedPos) {
        return (int)(packedPos << 26 >> 38);
    }
}