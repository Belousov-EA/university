package com.google.android.gms.internal;

import java.util.Map;

final class zzeev implements Runnable {
    private /* synthetic */ zzedc zzmvb;
    private /* synthetic */ zzeer zzmvc;

    zzeev(zzeer com_google_android_gms_internal_zzeer, zzedc com_google_android_gms_internal_zzedc) {
        this.zzmvc = com_google_android_gms_internal_zzeer;
        this.zzmvb = com_google_android_gms_internal_zzedc;
    }

    public final void run() {
        synchronized (this.zzmvc.zzmva) {
            if (this.zzmvc.zzmva.containsKey(this.zzmvb)) {
                for (zzedn resume : ((Map) this.zzmvc.zzmva.get(this.zzmvb)).values()) {
                    resume.resume();
                }
            }
        }
    }
}
