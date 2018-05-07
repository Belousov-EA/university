package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbgg;
import com.google.firebase.FirebaseApp;

public final class zzk {
    private static zzbgg zzecc = new zzbgg("TokenRefresher", "FirebaseAuth:");
    private Handler mHandler;
    private HandlerThread zzdcv = new HandlerThread("TokenRefresher", 10);
    private final FirebaseApp zzmcx;
    volatile long zzmhs;
    volatile long zzmht;
    private long zzmhu;
    private Runnable zzz;

    public zzk(@NonNull FirebaseApp firebaseApp) {
        zzecc.zza("Initializing TokenRefresher", new Object[0]);
        this.zzmcx = (FirebaseApp) zzbq.checkNotNull(firebaseApp);
        this.zzdcv.start();
        this.mHandler = new Handler(this.zzdcv.getLooper());
        this.zzz = new zzl(this, this.zzmcx.getName());
        this.zzmhu = 300000;
    }

    public final void cancel() {
        this.mHandler.removeCallbacks(this.zzz);
    }

    public final void zzbsd() {
        zzecc.zza("Scheduling refresh for " + (this.zzmhs - this.zzmhu), new Object[0]);
        cancel();
        this.zzmht = Math.max((this.zzmhs - zzh.zzamg().currentTimeMillis()) - this.zzmhu, 0) / 1000;
        this.mHandler.postDelayed(this.zzz, this.zzmht * 1000);
    }

    final void zzbse() {
        long j;
        switch ((int) this.zzmht) {
            case 30:
            case 60:
            case 120:
            case 240:
            case 480:
                j = 2 * this.zzmht;
                break;
            case 960:
                j = 960;
                break;
            default:
                j = 30;
                break;
        }
        this.zzmht = j;
        this.zzmhs = zzh.zzamg().currentTimeMillis() + (this.zzmht * 1000);
        zzecc.zza("Scheduling refresh for " + this.zzmhs, new Object[0]);
        this.mHandler.postDelayed(this.zzz, this.zzmht * 1000);
    }
}
