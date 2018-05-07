package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcu;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzb extends AsyncTaskLoader<Void> implements zzcu {
    private Semaphore zzehw = new Semaphore(0);
    private Set<GoogleApiClient> zzehx;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzehx = set;
    }

    private final Void zzabh() {
        int i = 0;
        for (GoogleApiClient zza : this.zzehx) {
            i = zza.zza((zzcu) this) ? i + 1 : i;
        }
        try {
            this.zzehw.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public final /* synthetic */ Object loadInBackground() {
        return zzabh();
    }

    protected final void onStartLoading() {
        this.zzehw.drainPermits();
        forceLoad();
    }

    public final void zzabi() {
        this.zzehw.release();
    }
}
