package com.google.android.gms.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger.Level;

public final class zzedf extends zzedc {
    public final synchronized void setLogLevel(Level level) {
        zzbvx();
        switch (zzedg.zzmsk[level.ordinal()]) {
            case 1:
                this.zzmsg = zzeje.DEBUG;
                break;
            case 2:
                this.zzmsg = zzeje.INFO;
                break;
            case 3:
                this.zzmsg = zzeje.WARN;
                break;
            case 4:
                this.zzmsg = zzeje.ERROR;
                break;
            case 5:
                this.zzmsg = zzeje.NONE;
                break;
            default:
                String valueOf = String.valueOf(level);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown log level: ").append(valueOf).toString());
        }
    }

    public final synchronized void setPersistenceCacheSizeBytes(long j) {
        zzbvx();
        if (j < 1048576) {
            throw new DatabaseException("The minimum cache size must be at least 1MB");
        } else if (j > 104857600) {
            throw new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
        } else {
            this.cacheSize = j;
        }
    }

    public final synchronized void setPersistenceEnabled(boolean z) {
        zzbvx();
        this.zzmnr = z;
    }

    public final synchronized void zzd(FirebaseApp firebaseApp) {
        this.zzmlg = firebaseApp;
    }

    public final synchronized void zzpx(String str) {
        zzbvx();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.zzmsf = str;
    }
}
