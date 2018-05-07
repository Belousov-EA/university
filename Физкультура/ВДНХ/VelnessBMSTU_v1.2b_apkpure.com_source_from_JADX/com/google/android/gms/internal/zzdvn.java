package com.google.android.gms.internal;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzdvn {
    private final ConcurrentHashMap<zzdvo, List<Throwable>> zzmaj = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzmak = new ReferenceQueue();

    zzdvn() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Object poll = this.zzmak.poll();
        while (poll != null) {
            this.zzmaj.remove(poll);
            poll = this.zzmak.poll();
        }
        return (List) this.zzmaj.get(new zzdvo(th, null));
    }
}
