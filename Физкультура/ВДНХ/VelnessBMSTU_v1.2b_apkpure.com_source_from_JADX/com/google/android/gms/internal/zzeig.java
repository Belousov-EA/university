package com.google.android.gms.internal;

import java.util.ArrayList;

final class zzeig implements Runnable {
    private /* synthetic */ ArrayList zznac;
    private /* synthetic */ zzeif zznad;

    zzeig(zzeif com_google_android_gms_internal_zzeif, ArrayList arrayList) {
        this.zznad = com_google_android_gms_internal_zzeif;
        this.zznac = arrayList;
    }

    public final void run() {
        ArrayList arrayList = this.zznac;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            zzeib com_google_android_gms_internal_zzeib = (zzeib) arrayList.get(i);
            if (this.zznad.zzmlr.zzbzl()) {
                zzejc zza = this.zznad.zzmlr;
                String str = "Raising ";
                String valueOf = String.valueOf(com_google_android_gms_internal_zzeib.toString());
                zza.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
            }
            com_google_android_gms_internal_zzeib.zzbyc();
            i = i2;
        }
    }
}
