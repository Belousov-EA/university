package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfie implements Iterator<Entry<K, V>> {
    private int pos;
    private /* synthetic */ zzfhy zzpkh;
    private boolean zzpki;
    private Iterator<Entry<K, V>> zzpkj;

    private zzfie(zzfhy com_google_android_gms_internal_zzfhy) {
        this.zzpkh = com_google_android_gms_internal_zzfhy;
        this.pos = -1;
    }

    private final Iterator<Entry<K, V>> zzczp() {
        if (this.zzpkj == null) {
            this.zzpkj = this.zzpkh.zzpkb.entrySet().iterator();
        }
        return this.zzpkj;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzpkh.zzpka.size() || (!this.zzpkh.zzpkb.isEmpty() && zzczp().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzpki = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzpkh.zzpka.size() ? (Entry) this.zzpkh.zzpka.get(this.pos) : (Entry) zzczp().next();
    }

    public final void remove() {
        if (this.zzpki) {
            this.zzpki = false;
            this.zzpkh.zzczl();
            if (this.pos < this.zzpkh.zzpka.size()) {
                zzfhy com_google_android_gms_internal_zzfhy = this.zzpkh;
                int i = this.pos;
                this.pos = i - 1;
                com_google_android_gms_internal_zzfhy.zzmc(i);
                return;
            }
            zzczp().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
