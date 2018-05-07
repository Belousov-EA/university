package com.google.firebase.database;

import com.google.android.gms.internal.zzecy;
import com.google.android.gms.internal.zzelq;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.util.Map;

final class zze implements Runnable {
    private /* synthetic */ zzelq zzmka;
    private /* synthetic */ DatabaseReference zzmkb;
    private /* synthetic */ zzecy zzmkd;
    private /* synthetic */ Map zzmke;

    zze(DatabaseReference databaseReference, zzecy com_google_android_gms_internal_zzecy, zzelq com_google_android_gms_internal_zzelq, Map map) {
        this.zzmkb = databaseReference;
        this.zzmkd = com_google_android_gms_internal_zzecy;
        this.zzmka = com_google_android_gms_internal_zzelq;
        this.zzmke = map;
    }

    public final void run() {
        this.zzmkb.zzmkl.zza(this.zzmkb.zzmks, this.zzmkd, (CompletionListener) this.zzmka.zzcbg(), this.zzmke);
    }
}
