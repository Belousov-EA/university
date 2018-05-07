package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzeit {
    private final Map<zzejg, zzehz> zznbd = new HashMap();

    public final void zza(zzehz com_google_android_gms_internal_zzehz) {
        zzeic zzbye = com_google_android_gms_internal_zzehz.zzbye();
        zzejg zzbyd = com_google_android_gms_internal_zzehz.zzbyd();
        if (this.zznbd.containsKey(zzbyd)) {
            zzehz com_google_android_gms_internal_zzehz2 = (zzehz) this.zznbd.get(zzbyd);
            zzeic zzbye2 = com_google_android_gms_internal_zzehz2.zzbye();
            if (zzbye == zzeic.CHILD_ADDED && zzbye2 == zzeic.CHILD_REMOVED) {
                this.zznbd.put(com_google_android_gms_internal_zzehz.zzbyd(), zzehz.zza(zzbyd, com_google_android_gms_internal_zzehz.zzbyb(), com_google_android_gms_internal_zzehz2.zzbyb()));
                return;
            } else if (zzbye == zzeic.CHILD_REMOVED && zzbye2 == zzeic.CHILD_ADDED) {
                this.zznbd.remove(zzbyd);
                return;
            } else if (zzbye == zzeic.CHILD_REMOVED && zzbye2 == zzeic.CHILD_CHANGED) {
                this.zznbd.put(zzbyd, zzehz.zzb(zzbyd, com_google_android_gms_internal_zzehz2.zzbyg()));
                return;
            } else if (zzbye == zzeic.CHILD_CHANGED && zzbye2 == zzeic.CHILD_ADDED) {
                this.zznbd.put(zzbyd, zzehz.zza(zzbyd, com_google_android_gms_internal_zzehz.zzbyb()));
                return;
            } else if (zzbye == zzeic.CHILD_CHANGED && zzbye2 == zzeic.CHILD_CHANGED) {
                this.zznbd.put(zzbyd, zzehz.zza(zzbyd, com_google_android_gms_internal_zzehz.zzbyb(), com_google_android_gms_internal_zzehz2.zzbyg()));
                return;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzehz);
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzehz2);
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 48) + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        }
        this.zznbd.put(com_google_android_gms_internal_zzehz.zzbyd(), com_google_android_gms_internal_zzehz);
    }

    public final List<zzehz> zzbzg() {
        return new ArrayList(this.zznbd.values());
    }
}
