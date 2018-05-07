package com.google.firebase.database;

import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzo implements Runnable {
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ OnDisconnect zzmkt;

    zzo(OnDisconnect onDisconnect, zzelq com_google_android_gms_internal_zzelq) {
        this.zzmkt = onDisconnect;
        this.zzmka = com_google_android_gms_internal_zzelq;
    }

    public final void run() {
        this.zzmkt.zzmkl.zza(this.zzmkt.zzmks, (CompletionListener) this.zzmka.zzcbg());
    }
}
