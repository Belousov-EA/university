package com.google.firebase.database;

import java.util.Iterator;

final class zzk implements Iterable<MutableData> {
    final /* synthetic */ Iterator zzmjs;
    final /* synthetic */ MutableData zzmkq;

    zzk(MutableData mutableData, Iterator it) {
        this.zzmkq = mutableData;
        this.zzmjs = it;
    }

    public final Iterator<MutableData> iterator() {
        return new zzl(this);
    }
}
