package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzdmg extends ContentObserver {
    zzdmg(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzdmf.zzlne.set(true);
    }
}
