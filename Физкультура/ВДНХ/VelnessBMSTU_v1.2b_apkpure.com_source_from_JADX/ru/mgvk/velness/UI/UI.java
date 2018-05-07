package ru.mgvk.velness.UI;

import android.content.Context;

public class UI {
    static int realDPI = 0;

    public static void init(Context context) {
        realDPI = context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int toDP(int pixels) {
        return (int) (((double) pixels) * (((double) realDPI) / 160.0d));
    }
}
