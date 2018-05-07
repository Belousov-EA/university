package com.google.firebase.database;

import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzm implements Runnable {
    private /* synthetic */ zzekd zzmjz;
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ OnDisconnect zzmkt;

    zzm(OnDisconnect onDisconnect, zzekd com_google_android_gms_internal_zzekd, zzelq com_google_android_gms_internal_zzelq) {
        this.zzmkt = onDisconnect;
        this.zzmjz = com_google_android_gms_internal_zzekd;
        this.zzmka = com_google_android_gms_internal_zzelq;
    }

    public final void run() {
        this.zzmkt.zzmkl.zzb(this.zzmkt.zzmks, this.zzmjz, (CompletionListener) this.zzmka.zzcbg());
    }
}
