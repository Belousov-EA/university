package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzv {
    private final zzm zzab;
    private final AtomicInteger zzbb;
    private final Set<zzr<?>> zzbc;
    private final PriorityBlockingQueue<zzr<?>> zzbd;
    private final PriorityBlockingQueue<zzr<?>> zzbe;
    private final zzn[] zzbf;
    private final List<Object> zzbg;
    private final zzb zzj;
    private final zzz zzk;
    private zzd zzq;

    public zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzm, 4);
    }

    private zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm, int i) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzm, 4, new zzi(new Handler(Looper.getMainLooper())));
    }

    private zzv(zzb com_google_android_gms_internal_zzb, zzm com_google_android_gms_internal_zzm, int i, zzz com_google_android_gms_internal_zzz) {
        this.zzbb = new AtomicInteger();
        this.zzbc = new HashSet();
        this.zzbd = new PriorityBlockingQueue();
        this.zzbe = new PriorityBlockingQueue();
        this.zzbg = new ArrayList();
        this.zzj = com_google_android_gms_internal_zzb;
        this.zzab = com_google_android_gms_internal_zzm;
        this.zzbf = new zzn[4];
        this.zzk = com_google_android_gms_internal_zzz;
    }

    public final void start() {
        int i = 0;
        if (this.zzq != null) {
            this.zzq.quit();
        }
        for (zzn com_google_android_gms_internal_zzn : this.zzbf) {
            if (com_google_android_gms_internal_zzn != null) {
                com_google_android_gms_internal_zzn.quit();
            }
        }
        this.zzq = new zzd(this.zzbd, this.zzbe, this.zzj, this.zzk);
        this.zzq.start();
        while (i < this.zzbf.length) {
            zzn com_google_android_gms_internal_zzn2 = new zzn(this.zzbe, this.zzab, this.zzj, this.zzk);
            this.zzbf[i] = com_google_android_gms_internal_zzn2;
            com_google_android_gms_internal_zzn2.start();
            i++;
        }
    }

    public final <T> zzr<T> zze(zzr<T> com_google_android_gms_internal_zzr_T) {
        com_google_android_gms_internal_zzr_T.zza(this);
        synchronized (this.zzbc) {
            this.zzbc.add(com_google_android_gms_internal_zzr_T);
        }
        com_google_android_gms_internal_zzr_T.zza(this.zzbb.incrementAndGet());
        com_google_android_gms_internal_zzr_T.zzb("add-to-queue");
        if (com_google_android_gms_internal_zzr_T.zzg()) {
            this.zzbd.add(com_google_android_gms_internal_zzr_T);
        } else {
            this.zzbe.add(com_google_android_gms_internal_zzr_T);
        }
        return com_google_android_gms_internal_zzr_T;
    }

    final <T> void zzf(zzr<T> com_google_android_gms_internal_zzr_T) {
        synchronized (this.zzbc) {
            this.zzbc.remove(com_google_android_gms_internal_zzr_T);
        }
        synchronized (this.zzbg) {
            Iterator it = this.zzbg.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
