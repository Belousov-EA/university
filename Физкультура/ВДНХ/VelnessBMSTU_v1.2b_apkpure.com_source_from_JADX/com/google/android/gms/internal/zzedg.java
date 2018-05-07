package com.google.android.gms.internal;

import com.google.firebase.database.Logger.Level;

final /* synthetic */ class zzedg {
    static final /* synthetic */ int[] zzmsk = new int[Level.values().length];

    static {
        try {
            zzmsk[Level.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzmsk[Level.INFO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzmsk[Level.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzmsk[Level.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzmsk[Level.NONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
