package org.elias.fastmath.mixin;

import net.minecraft.util.Mth;
import org.elias.fastmath.MathUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Mth.class)
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
	 * @reason Uses Fast Square Root approximation.
	 */
	@Overwrite
	public static float sqrt(float value) {
		return MathUtil.fastSqrt(value);
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
	public static double length(double a, double b) {
		return Math.sqrt(a * a + b * b);
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
	 * @reason same as above for doubles
	 */
	@Overwrite
	public static double lerp(double delta, double start, double end) {
		return MathUtil.fastLerpDouble(delta, start, end);
	}

	/**
	 * @author elias
	 * @reason Fast quintic polynomial fade for Perlin noise. This is same formula as the one on vanilla
	 */
//	@Overwrite
//	public static double smoothstep(double value) {
//		return value * value * value * (value * (value * 6.0 - 15.0) + 10.0);
//	}

	/**
	 * @author elias
	 * @reason Branch-optimized clamp implementation.
	 */
	@Overwrite
	public static int clamp(int value, int min, int max) {
		if (value < min) return min;
        return Math.min(value, max);
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
