package org.elias.fastmath.mixin;

import net.minecraft.util.math.MathHelper;
import org.elias.fastmath.MathUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MathHelper.class)
public class MathMixin {

	/**
	 * @author elias
	 * @reason Replaces sine lookup with optimized custom implementation.
	 */
	@Overwrite
	public static float sin(double value) {
		return MathUtil.fastSin((float) value);
	}

	/**
	 * @author elias
	 * @reason Replaces cosine lookup with optimized custom implementation.
	 */
	@Overwrite
	public static float cos(double value) {
		return MathUtil.fastCos((float) value);
	}

	/**
	 * @author elias
	 * @reason Uses Fast Inverse Square Root approximation.
	 */
	@Overwrite
	public static float sqrt(float value) {
		return 1.0f / MathUtil.fastInvSqrt(value);
	}

	/**
	 * @author elias
	 * @reason Branch-reduced floor implementation for float values.
	 */
	@Overwrite
	public static int floor(float value) {
		return MathUtil.fastFloor(value);
	}

	/**
	 * @author elias
	 * @reason Branch-reduced floor implementation for double values.
	 */
	@Overwrite
	public static int floor(double value) {
		return MathUtil.fastFloor(value);
	}

	/**
	 * @author elias
	 * @reason Faster hypotenuse calculation.
	 */
	@Overwrite
	public static double hypot(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}

	/**
	 * @author elias
	 * @reason Optimized atan2 approximation for entity orientation.
	 */
	@Overwrite
	public static double atan2(double y, double x) {
		return MathUtil.fastAtan2((float) y, (float) x);
	}

	/**
	 * @author elias
	 * @reason Optimized float linear interpolation.
	 */
	@Overwrite
	public static float lerp(float delta, float start, float end) {
		return MathUtil.fastLerp(delta, start, end);
	}

	/**
	 * @author elias
	 * @reason Optimized double linear interpolation.
	 */
	@Overwrite
	public static double lerp(double delta, double start, double end) {
		return start + delta * (end - start);
	}

	/**
	 * @author elias
	 * @reason Fast quintic polynomial fade for Perlin noise.
	 */
	@Overwrite
	public static double perlinFade(double value) {
		return value * value * value * (value * (value * 6.0 - 15.0) + 10.0);
	}

	/**
	 * @author elias
	 * @reason Optimized hash for block positions.
	 */
	@Overwrite
	public static long hashCode(int x, int y, int z) {
		return MathUtil.fastPosHash(x, y, z);
	}

	/**
	 * @author elias
	 * @reason Branch-optimized clamp implementation.
	 */
	@Overwrite
	public static int clamp(int value, int min, int max) {
		return value < min ? min : Math.min(value, max);
	}

	/**
	 * @author elias
	 * @reason Faster float degree normalization.
	 */
	@Overwrite
	public static float wrapDegrees(float degrees) {
		float f = degrees % 360.0f;
		if (f >= 180.0f) f -= 360.0f;
		if (f < -180.0f) f += 360.0f;
		return f;
	}
}