package com.google.android.gms.internal;

import com.google.firebase.database.DataSnapshot;

public final class zzeia implements zzeib {
    private final zzedh zzmzl;
    private final zzeic zzmzn;
    private final DataSnapshot zzmzr;
    private final String zzmzs;

    public zzeia(zzeic com_google_android_gms_internal_zzeic, zzedh com_google_android_gms_internal_zzedh, DataSnapshot dataSnapshot, String str) {
        this.zzmzn = com_google_android_gms_internal_zzeic;
        this.zzmzl = com_google_android_gms_internal_zzedh;
        this.zzmzr = dataSnapshot;
        this.zzmzs = str;
    }

    private final zzedk zzbsy() {
        zzedk zzbsy = this.zzmzr.getRef().zzbsy();
        return this.zzmzn == zzeic.VALUE ? zzbsy : zzbsy.zzbwj();
    }

    public final String toString() {
        if (this.zzmzn == zzeic.VALUE) {
            String valueOf = String.valueOf(zzbsy());
            String valueOf2 = String.valueOf(this.zzmzn);
            String valueOf3 = String.valueOf(this.zzmzr.getValue(true));
            return new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        valueOf = String.valueOf(zzbsy());
        valueOf2 = String.valueOf(this.zzmzn);
        valueOf3 = this.zzmzr.getKey();
        String valueOf4 = String.valueOf(this.zzmzr.getValue(true));
        return new StringBuilder((((String.valueOf(valueOf).length() + 10) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(valueOf).append(": ").append(valueOf2).append(": { ").append(valueOf3).append(": ").append(valueOf4).append(" }").toString();
    }

    public final void zzbyc() {
        this.zzmzl.zza(this);
    }

    public final zzeic zzbye() {
        return this.zzmzn;
    }

    public final DataSnapshot zzbyh() {
        return this.zzmzr;
    }

    public final String zzbyi() {
        return this.zzmzs;
    }
}
