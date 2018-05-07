package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.ValueEventListener;

final class zzeeo implements Comparable<zzeeo> {
    private int retryCount;
    private zzedk zzmks;
    private Handler zzmuh;
    private ValueEventListener zzmui;
    private int zzmuj;
    private long zzmuk;
    private boolean zzmul;
    private DatabaseError zzmum;
    private long zzmun;
    private zzekd zzmuo;
    private zzekd zzmup;
    private zzekd zzmuq;

    private zzeeo(zzedk com_google_android_gms_internal_zzedk, Handler handler, ValueEventListener valueEventListener, int i, boolean z, long j) {
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmuh = handler;
        this.zzmui = valueEventListener;
        this.zzmuj = i;
        this.retryCount = 0;
        this.zzmul = z;
        this.zzmuk = j;
        this.zzmum = null;
        this.zzmuo = null;
        this.zzmup = null;
        this.zzmuq = null;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzeeo com_google_android_gms_internal_zzeeo = (zzeeo) obj;
        return this.zzmuk < com_google_android_gms_internal_zzeeo.zzmuk ? -1 : this.zzmuk == com_google_android_gms_internal_zzeeo.zzmuk ? 0 : 1;
    }
}
