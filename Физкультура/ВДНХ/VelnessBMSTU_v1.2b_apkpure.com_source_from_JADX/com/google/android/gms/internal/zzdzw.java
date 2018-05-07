package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.idl.zzc;
import com.google.firebase.database.connection.idl.zzf;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdzw implements zzedm {
    private final Context zzajx;
    private final FirebaseApp zzmlg;
    private final Set<String> zzmll = new HashSet();

    public zzdzw(FirebaseApp firebaseApp) {
        this.zzmlg = firebaseApp;
        if (this.zzmlg == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.zzajx = this.zzmlg.getApplicationContext();
    }

    public final zzebm zza(zzedc com_google_android_gms_internal_zzedc, zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, zzebn com_google_android_gms_internal_zzebn) {
        zzebm zza = zzf.zza(this.zzajx, new zzc(com_google_android_gms_internal_zzebk, com_google_android_gms_internal_zzedc.zzbvy(), null, com_google_android_gms_internal_zzedc.isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), com_google_android_gms_internal_zzedc.zzbuf(), zzbta()), com_google_android_gms_internal_zzebi, com_google_android_gms_internal_zzebn);
        this.zzmlg.zza(new zzdzz(this, zza));
        return zza;
    }

    public final zzect zza(ScheduledExecutorService scheduledExecutorService) {
        return new zzdzq(this.zzmlg, scheduledExecutorService);
    }

    public final zzedj zza(zzedc com_google_android_gms_internal_zzedc) {
        return new zzdzv();
    }

    public final zzegy zza(zzedc com_google_android_gms_internal_zzedc, String str) {
        String zzbwb = com_google_android_gms_internal_zzedc.zzbwb();
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(zzbwb).length()).append(str).append("_").append(zzbwb).toString();
        if (this.zzmll.contains(stringBuilder)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(zzbwb).length() + 47).append("SessionPersistenceKey '").append(zzbwb).append("' has already been used.").toString());
        }
        this.zzmll.add(stringBuilder);
        return new zzegv(com_google_android_gms_internal_zzedc, new zzeaa(this.zzajx, com_google_android_gms_internal_zzedc, stringBuilder), new zzegw(com_google_android_gms_internal_zzedc.zzbvz()));
    }

    public final zzejd zza(zzedc com_google_android_gms_internal_zzedc, zzeje com_google_android_gms_internal_zzeje, List<String> list) {
        return new zzeiz(com_google_android_gms_internal_zzeje, null);
    }

    public final zzeew zzb(zzedc com_google_android_gms_internal_zzedc) {
        return new zzdzx(this, com_google_android_gms_internal_zzedc.zzpv("RunLoop"));
    }

    public final File zzbta() {
        return this.zzajx.getApplicationContext().getDir("sslcache", 0);
    }

    public final String zzc(zzedc com_google_android_gms_internal_zzedc) {
        return VERSION.SDK_INT + "/Android";
    }
}
