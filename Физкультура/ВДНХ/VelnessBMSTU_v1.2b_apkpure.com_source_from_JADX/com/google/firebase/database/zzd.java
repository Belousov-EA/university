package com.google.firebase.database;

import com.google.android.gms.internal.zzejg;
import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzd implements Runnable {
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ DatabaseReference zzmkb;
    private /* synthetic */ zzekd zzmkc;

    zzd(DatabaseReference databaseReference, zzekd com_google_android_gms_internal_zzekd, zzelq com_google_android_gms_internal_zzelq) {
        this.zzmkb = databaseReference;
        this.zzmkc = com_google_android_gms_internal_zzekd;
        this.zzmka = com_google_android_gms_internal_zzelq;
    }

    public final void run() {
        this.zzmkb.zzmkl.zza(this.zzmkb.zzmks.zza(zzejg.zzbzp()), this.zzmkc, (CompletionListener) this.zzmka.zzcbg());
    }
}
