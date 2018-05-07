package com.google.firebase.database;

import com.google.android.gms.internal.zzejw;
import com.google.android.gms.internal.zzekc;
import java.util.Iterator;

final class zzb implements Iterator<DataSnapshot> {
    private /* synthetic */ zza zzmju;

    zzb(zza com_google_firebase_database_zza) {
        this.zzmju = com_google_firebase_database_zza;
    }

    public final boolean hasNext() {
        return this.zzmju.zzmjs.hasNext();
    }

    public final /* synthetic */ Object next() {
        zzekc com_google_android_gms_internal_zzekc = (zzekc) this.zzmju.zzmjs.next();
        return new DataSnapshot(this.zzmju.zzmjt.zzmjr.child(com_google_android_gms_internal_zzekc.zzcao().asString()), zzejw.zzj(com_google_android_gms_internal_zzekc.zzbsv()));
    }

    public final void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
