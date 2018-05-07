package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

final class zzejp {
    private StringBuilder zzncd = null;
    private Stack<zzejg> zznce = new Stack();
    private int zzncf = -1;
    private int zzncg;
    private boolean zznch = true;
    private final List<zzedk> zznci = new ArrayList();
    private final List<String> zzncj = new ArrayList();
    private final zzejr zznck;

    public zzejp(zzejr com_google_android_gms_internal_zzejr) {
        this.zznck = com_google_android_gms_internal_zzejr;
    }

    private static void zza(StringBuilder stringBuilder, zzejg com_google_android_gms_internal_zzejg) {
        stringBuilder.append(zzelt.zzqf(com_google_android_gms_internal_zzejg.asString()));
    }

    private final void zzb(zzejy<?> com_google_android_gms_internal_zzejy_) {
        zzcab();
        this.zzncf = this.zzncg;
        this.zzncd.append(com_google_android_gms_internal_zzejy_.zza(zzekf.V2));
        this.zznch = true;
        if (this.zznck.zze(this)) {
            zzcae();
        }
    }

    private final boolean zzbzy() {
        return this.zzncd != null;
    }

    private final void zzcab() {
        if (!zzbzy()) {
            this.zzncd = new StringBuilder();
            this.zzncd.append("(");
            Iterator it = zzgt(this.zzncg).iterator();
            while (it.hasNext()) {
                zza(this.zzncd, (zzejg) it.next());
                this.zzncd.append(":(");
            }
            this.zznch = false;
        }
    }

    private final void zzcac() {
        this.zzncg--;
        if (zzbzy()) {
            this.zzncd.append(")");
        }
        this.zznch = true;
    }

    private final void zzcad() {
        zzelt.zzb(this.zzncg == 0, "Can't finish hashing in the middle processing a child");
        if (zzbzy()) {
            zzcae();
        }
        this.zzncj.add("");
    }

    private final void zzcae() {
        zzelt.zzb(zzbzy(), "Can't end range without starting a range!");
        for (int i = 0; i < this.zzncg; i++) {
            this.zzncd.append(")");
        }
        this.zzncd.append(")");
        zzedk zzgt = zzgt(this.zzncf);
        this.zzncj.add(zzelt.zzqe(this.zzncd.toString()));
        this.zznci.add(zzgt);
        this.zzncd = null;
    }

    private final zzedk zzgt(int i) {
        zzejg[] com_google_android_gms_internal_zzejgArr = new zzejg[i];
        for (int i2 = 0; i2 < i; i2++) {
            com_google_android_gms_internal_zzejgArr[i2] = (zzejg) this.zznce.get(i2);
        }
        return new zzedk(com_google_android_gms_internal_zzejgArr);
    }

    private final void zzn(zzejg com_google_android_gms_internal_zzejg) {
        zzcab();
        if (this.zznch) {
            this.zzncd.append(",");
        }
        zza(this.zzncd, com_google_android_gms_internal_zzejg);
        this.zzncd.append(":(");
        if (this.zzncg == this.zznce.size()) {
            this.zznce.add(com_google_android_gms_internal_zzejg);
        } else {
            this.zznce.set(this.zzncg, com_google_android_gms_internal_zzejg);
        }
        this.zzncg++;
        this.zznch = false;
    }

    public final int zzbzz() {
        return this.zzncd.length();
    }

    public final zzedk zzcaa() {
        return zzgt(this.zzncg);
    }
}
