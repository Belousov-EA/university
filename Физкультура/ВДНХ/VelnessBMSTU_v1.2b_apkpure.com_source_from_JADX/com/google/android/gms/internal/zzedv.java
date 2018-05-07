package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.zzh;
import java.util.ArrayList;
import java.util.List;

final class zzedv implements zzece {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ List zzmtp;
    private /* synthetic */ zzedn zzmtq;

    zzedv(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, List list, zzedn com_google_android_gms_internal_zzedn2) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmtp = list;
        this.zzmtq = com_google_android_gms_internal_zzedn2;
    }

    public final void zzbd(String str, String str2) {
        int i = 0;
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        this.zzmti.zza("Transaction", this.zzmrv, zzbf);
        List arrayList = new ArrayList();
        if (zzbf == null) {
            List arrayList2 = new ArrayList();
            for (zzeeo com_google_android_gms_internal_zzeeo : this.zzmtp) {
                com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                arrayList.addAll(this.zzmti.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, false, false, this.zzmti.zzmsr));
                arrayList2.add(new zzedw(this, com_google_android_gms_internal_zzeeo, zzh.zza(zzh.zza(this.zzmtq, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuq))));
                this.zzmti.zze(new zzegf(this.zzmti, com_google_android_gms_internal_zzeeo.zzmui, zzeik.zzam(com_google_android_gms_internal_zzeeo.zzmks)));
            }
            this.zzmti.zzb(this.zzmti.zzmsu.zzak(this.zzmrv));
            this.zzmti.zzbwq();
            this.zzmtq.zzau(arrayList);
            while (i < arrayList2.size()) {
                this.zzmti.zzm((Runnable) arrayList2.get(i));
                i++;
            }
            return;
        }
        if (zzbf.getCode() == -1) {
            for (zzeeo com_google_android_gms_internal_zzeeo2 : this.zzmtp) {
                if (com_google_android_gms_internal_zzeeo2.zzmuj == zzeep.zzmuv) {
                    com_google_android_gms_internal_zzeeo2.zzmuj = zzeep.zzmuw;
                } else {
                    com_google_android_gms_internal_zzeeo2.zzmuj = zzeep.zzmus;
                }
            }
        } else {
            for (zzeeo com_google_android_gms_internal_zzeeo22 : this.zzmtp) {
                com_google_android_gms_internal_zzeeo22.zzmuj = zzeep.zzmuw;
                com_google_android_gms_internal_zzeeo22.zzmum = zzbf;
            }
        }
        this.zzmti.zzn(this.zzmrv);
    }
}
