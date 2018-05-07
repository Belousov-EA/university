package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    static final int MAX_EXPONENT = 1023;
    static final int MIN_EXPONENT = -1022;
    private static final long ONE_BITS = Double.doubleToRawLongBits(1.0d);
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    static double nextDown(double d) {
        return -nextUp(-d);
    }

    static double nextUp(double d) {
        if (Double.isNaN(d)) {
            return d;
        }
        if (d == 0.0d) {
            return Double.MIN_VALUE;
        }
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        long bits = Double.doubleToRawLongBits(d);
        return Double.longBitsToDouble(bits + ((bits >> 63) | 1));
    }

    static int getExponent(double d) {
        return ((int) ((Double.doubleToRawLongBits(d) & EXPONENT_MASK) >>> 52)) - 1023;
    }

    static long getSignificand(double d) {
        Preconditions.checkArgument(isFinite(d), "not a normal value");
        long bits = Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK;
        return getExponent(d) == -1023 ? bits << 1 : IMPLICIT_BIT | bits;
    }

    static double copySign(double mag, double sgn) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(mag) & Long.MAX_VALUE) | (Double.doubleToRawLongBits(sgn) & SIGN_MASK));
    }

    static boolean isFinite(double d) {
        return getExponent(d) <= 1023;
    }

    static boolean isNormal(double d) {
        return getExponent(d) >= MIN_EXPONENT;
    }

    static double scaleNormalize(double x) {
        return Double.longBitsToDouble(ONE_BITS | (Double.doubleToRawLongBits(x) & SIGNIFICAND_MASK));
    }

    static double bigToDouble(BigInteger x) {
        BigInteger absX = x.abs();
        int exponent = absX.bitLength() - 1;
        if (exponent < 63) {
            return (double) x.longValue();
        }
        if (exponent > 1023) {
            return ((double) x.signum()) * Double.POSITIVE_INFINITY;
        }
        long signifRounded;
        int shift = (exponent - 52) - 1;
        long twiceSignifFloor = absX.shiftRight(shift).longValue();
        long signifFloor = (twiceSignifFloor >> 1) & SIGNIFICAND_MASK;
        boolean increment = (1 & twiceSignifFloor) != 0 && ((1 & signifFloor) != 0 || absX.getLowestSetBit() < shift);
        if (increment) {
            signifRounded = signifFloor + 1;
        } else {
            signifRounded = signifFloor;
        }
        return Double.longBitsToDouble(((((long) (exponent + 1023)) << 52) + signifRounded) | (((long) x.signum()) & SIGN_MASK));
    }

    static double ensureNonNegative(double value) {
        Preconditions.checkArgument(!Double.isNaN(value));
        if (value > 0.0d) {
            return value;
        }
        return 0.0d;
    }
}
