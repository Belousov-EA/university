package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.TimeZone;

public final class zzbea {
    private String zzfjb;
    private int zzfjc;
    private String zzfjd;
    private String zzfje;
    private int zzfjg;
    private final zzbec zzfjk;
    private ArrayList<Integer> zzfjl;
    private ArrayList<String> zzfjm;
    private ArrayList<Integer> zzfjn;
    private ArrayList<zzctx> zzfjo;
    private ArrayList<byte[]> zzfjp;
    private boolean zzfjq;
    private final zzfkq zzfjr;
    private boolean zzfjs;
    private /* synthetic */ zzbdy zzfjt;

    private zzbea(zzbdy com_google_android_gms_internal_zzbdy, byte[] bArr) {
        this(com_google_android_gms_internal_zzbdy, bArr, null);
    }

    private zzbea(zzbdy com_google_android_gms_internal_zzbdy, byte[] bArr, zzbec com_google_android_gms_internal_zzbec) {
        this.zzfjt = com_google_android_gms_internal_zzbdy;
        this.zzfjc = this.zzfjt.zzfjc;
        this.zzfjb = this.zzfjt.zzfjb;
        zzbdy com_google_android_gms_internal_zzbdy2 = this.zzfjt;
        this.zzfjd = null;
        com_google_android_gms_internal_zzbdy2 = this.zzfjt;
        this.zzfje = null;
        this.zzfjg = 0;
        this.zzfjl = null;
        this.zzfjm = null;
        this.zzfjn = null;
        this.zzfjo = null;
        this.zzfjp = null;
        this.zzfjq = true;
        this.zzfjr = new zzfkq();
        this.zzfjs = false;
        this.zzfjd = null;
        this.zzfje = null;
        this.zzfjr.zzpql = com_google_android_gms_internal_zzbdy.zzddz.currentTimeMillis();
        this.zzfjr.zzpqm = com_google_android_gms_internal_zzbdy.zzddz.elapsedRealtime();
        zzfkq com_google_android_gms_internal_zzfkq = this.zzfjr;
        com_google_android_gms_internal_zzbdy.zzfji;
        com_google_android_gms_internal_zzfkq.zzpqx = (long) (TimeZone.getDefault().getOffset(this.zzfjr.zzpql) / 1000);
        if (bArr != null) {
            this.zzfjr.zzpqs = bArr;
        }
        this.zzfjk = null;
    }

    public final void zzbk() {
        if (this.zzfjs) {
            throw new IllegalStateException("do not reuse LogEventBuilder");
        }
        this.zzfjs = true;
        zzbeh com_google_android_gms_internal_zzbeh = new zzbeh(new zzbew(this.zzfjt.packageName, this.zzfjt.zzfja, this.zzfjc, this.zzfjb, this.zzfjd, this.zzfje, this.zzfjt.zzfjf, 0), this.zzfjr, null, null, zzbdy.zzb(null), null, zzbdy.zzb(null), null, null, this.zzfjq);
        zzbew com_google_android_gms_internal_zzbew = com_google_android_gms_internal_zzbeh.zzfjx;
        if (this.zzfjt.zzfjj.zzg(com_google_android_gms_internal_zzbew.zzfjb, com_google_android_gms_internal_zzbew.zzfjc)) {
            this.zzfjt.zzfjh.zza(com_google_android_gms_internal_zzbeh);
        } else {
            PendingResults.immediatePendingResult(Status.zzfni);
        }
    }
}
