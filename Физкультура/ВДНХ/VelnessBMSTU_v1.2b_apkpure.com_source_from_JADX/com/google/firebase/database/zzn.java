package com.google.firebase.database;

import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.util.Map;

final class zzn implements Runnable {
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ OnDisconnect zzmkt;
    private /* synthetic */ Map zzmku;
    private /* synthetic */ Map zzmkv;

    zzn(OnDisconnect onDisconnect, Map map, zzelq com_google_android_gms_internal_zzelq, Map map2) {
        this.zzmkt = onDisconnect;
        this.zzmku = map;
        this.zzmka = com_google_android_gms_internal_zzelq;
        this.zzmkv = map2;
    }

    public final void run() {
        this.zzmkt.zzmkl.zza(this.zzmkt.zzmks, this.zzmku, (CompletionListener) this.zzmka.zzcbg(), this.zzmkv);
    }
}
