package org.elias.fastmath;

public class MathUtil {
    private static final int BIT_COUNT = 16;
    private static final int TABLE_SIZE = 1 << BIT_COUNT;
    private static final int MASK = TABLE_SIZE - 1;
    private static final float[] SIN_TABLE = new float[TABLE_SIZE];
    private static final float RAD_TO_INDEX = (float) (TABLE_SIZE / (Math.PI * 2.0));

    static {
        for (int i = 0; i < TABLE_SIZE; i++) {
            SIN_TABLE[i] = (float) Math.sin((i * Math.PI * 2.0) / TABLE_SIZE);
        }
    }

    public static float fastSin(float radians) {
        return SIN_TABLE[(int) (radians * RAD_TO_INDEX) & MASK];
    }

    public static float fastCos(float radians) {
        return SIN_TABLE[(int) (radians * RAD_TO_INDEX + (TABLE_SIZE / 4)) & MASK];
    }

    public static float fastSqrt(float value) {
        return (float) Math.sqrt(value);
    }

    public static int fastFloor(double value) {
        int i = (int) value;
        return value < (double) i ? i - 1 : i;
    }

    public static float fastLerp(float delta, float start, float end) {
        return Math.fma(delta, end - start, start);
    }

    public static double fastLerpDouble(double delta, double start, double end) {
        return Math.fma(delta, end - start, start);
    }
}