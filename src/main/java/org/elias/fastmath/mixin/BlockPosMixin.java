package org.elias.fastmath.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockPos.class)
public abstract class BlockPosMixin extends Vec3i {
    public BlockPosMixin(int x, int y, int z) { super(x, y, z); }

    @Shadow private static int X_OFFSET;
    @Shadow private static int Z_OFFSET;
    @Shadow public static int PACKED_HORIZONTAL_LENGTH;
    @Shadow public static int PACKED_Y_LENGTH;
    @Shadow private static long PACKED_X_MASK;
    @Shadow private static long PACKED_Y_MASK;
    @Shadow private static long PACKED_Z_MASK;

    /**
     * @author elias
     * @reason Optimized bit-packing for 1.21 coordinate limits.
     * Layout: [X (26 bits)] [Z (26 bits)] [Y (12 bits)]
     */
    @Overwrite
    public static long asLong(int x, int y, int z) {
        long node = 0L;
        node |= ((long)x & PACKED_X_MASK) << X_OFFSET;
        node |= ((long)y & PACKED_Y_MASK);
        node |= ((long)z & PACKED_Z_MASK) << Z_OFFSET;
        return node;
    }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract X correctly.
     */
    @Overwrite
    public static int getX(long packedPos) { return (int)(packedPos << 64 - X_OFFSET - PACKED_HORIZONTAL_LENGTH >> 64 - PACKED_HORIZONTAL_LENGTH); }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract Y correctly.
     */
    @Overwrite
    public static int getY(long packedPos) { return (int)(packedPos << 64 - PACKED_Y_LENGTH >> 64 - PACKED_Y_LENGTH); }

    /**
     * @author elias
     * @reason Matches the optimized bit-layout to extract Z correctly.
     */
    @Overwrite
    public static int getZ(long packedPos) { return (int)(packedPos << 64 - Z_OFFSET - PACKED_HORIZONTAL_LENGTH >> 64 - PACKED_HORIZONTAL_LENGTH); }
}
