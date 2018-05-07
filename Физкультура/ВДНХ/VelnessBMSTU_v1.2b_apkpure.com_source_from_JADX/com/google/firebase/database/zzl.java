package com.google.firebase.database;

import com.google.android.gms.internal.zzekc;
import java.util.Iterator;

final class zzl implements Iterator<MutableData> {
    private /* synthetic */ zzk zzmkr;

    zzl(zzk com_google_firebase_database_zzk) {
        this.zzmkr = com_google_firebase_database_zzk;
    }

    public final boolean hasNext() {
        return this.zzmkr.zzmjs.hasNext();
    }

    public final /* synthetic */ Object next() {
        return new MutableData(this.zzmkr.zzmkq.zzmko, this.zzmkr.zzmkq.zzmkp.zza(((zzekc) this.zzmkr.zzmjs.next()).zzcao()));
    }

    public final void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
