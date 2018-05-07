package com.google.firebase.database;

import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzc implements Runnable {
    private /* synthetic */ zzekd zzmjz;
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ DatabaseReference zzmkb;

    zzc(DatabaseReference databaseReference, zzekd com_google_android_gms_internal_zzekd, zzelq com_google_android_gms_internal_zzelq) {
        this.zzmkb = databaseReference;
        this.zzmjz = com_google_android_gms_internal_zzekd;
        this.zzmka = com_google_android_gms_internal_zzelq;
    }

    public final void run() {
        this.zzmkb.zzmkl.zza(this.zzmkb.zzmks, this.zzmjz, (CompletionListener) this.zzmka.zzcbg());
    }
}
