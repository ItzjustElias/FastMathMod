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

    public static float fastAtan2(float y, float x) {
        if (x == 0.0f) {
            if (y > 0.0f) return 1.5707964f;
            if (y == 0.0f) return 0.0f;
            return -1.5707964f;
        }
        float z = y / x;
        float atan;
        if (Math.abs(z) < 1.0f) {
            atan = z / (1.0f + 0.280872f * z * z);
            if (x < 0.0f) return (y < 0.0f) ? atan - 3.1415927f : atan + 3.1415927f;
        } else {
            atan = 1.5707964f - z / (z * z + 0.280872f);
            if (y < 0.0f) return atan - 3.1415927f;
        }
        return atan;
    }

    public static float fastInvSqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        return x * (1.5f - xhalf * x * x);
    }

    public static int fastFloor(double value) {
        int i = (int) value;
        return value < (double) i ? i - 1 : i;
    }

    public static long fastPosHash(int x, int y, int z) {
        long l = (x * 3129871L) ^ (long)z * 116129781L ^ (long)y;
        l = l * l * 42317861L + l * 11L;
        return l >> 16;
    }

    public static float fastLerp(float delta, float start, float end) {
        return start + delta * (end - start);
    }
}