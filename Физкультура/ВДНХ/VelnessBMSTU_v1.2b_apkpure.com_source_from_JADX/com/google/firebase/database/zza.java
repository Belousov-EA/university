package com.google.firebase.database;

import java.util.Iterator;

final class zza implements Iterable<DataSnapshot> {
    final /* synthetic */ Iterator zzmjs;
    final /* synthetic */ DataSnapshot zzmjt;

    zza(DataSnapshot dataSnapshot, Iterator it) {
        this.zzmjt = dataSnapshot;
        this.zzmjs = it;
    }

    public final Iterator<DataSnapshot> iterator() {
        return new zzb(this);
    }
}
