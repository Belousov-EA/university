package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class zzfht implements Iterator<zzfey> {
    private final Stack<zzfhq> zzpjn;
    private zzfey zzpjo;

    private zzfht(zzfes com_google_android_gms_internal_zzfes) {
        this.zzpjn = new Stack();
        this.zzpjo = zzbb(com_google_android_gms_internal_zzfes);
    }

    private final zzfey zzbb(zzfes com_google_android_gms_internal_zzfes) {
        zzfes com_google_android_gms_internal_zzfes2 = com_google_android_gms_internal_zzfes;
        while (com_google_android_gms_internal_zzfes2 instanceof zzfhq) {
            zzfhq com_google_android_gms_internal_zzfhq = (zzfhq) com_google_android_gms_internal_zzfes2;
            this.zzpjn.push(com_google_android_gms_internal_zzfhq);
            com_google_android_gms_internal_zzfes2 = com_google_android_gms_internal_zzfhq.zzpji;
        }
        return (zzfey) com_google_android_gms_internal_zzfes2;
    }

    private final zzfey zzczc() {
        while (!this.zzpjn.isEmpty()) {
            zzfes zzbb = zzbb(((zzfhq) this.zzpjn.pop()).zzpjj);
            if (!zzbb.isEmpty()) {
                return zzbb;
            }
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzpjo != null;
    }

    public final /* synthetic */ Object next() {
        if (this.zzpjo == null) {
            throw new NoSuchElementException();
        }
        zzfey com_google_android_gms_internal_zzfey = this.zzpjo;
        this.zzpjo = zzczc();
        return com_google_android_gms_internal_zzfey;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
