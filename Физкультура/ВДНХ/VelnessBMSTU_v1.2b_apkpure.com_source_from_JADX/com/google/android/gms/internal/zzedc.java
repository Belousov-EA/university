package com.google.android.gms.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.concurrent.ScheduledExecutorService;

public class zzedc {
    protected long cacheSize = 10485760;
    protected FirebaseApp zzmlg;
    private zzejd zzmnq;
    protected boolean zzmnr;
    private String zzmnt;
    private boolean zzmrp = false;
    protected zzedj zzmsc;
    protected zzect zzmsd;
    protected zzeew zzmse;
    protected String zzmsf;
    protected zzeje zzmsg = zzeje.INFO;
    private boolean zzmsh = false;
    private zzedm zzmsi;

    private final ScheduledExecutorService zzbud() {
        zzeew com_google_android_gms_internal_zzeew = this.zzmse;
        if (com_google_android_gms_internal_zzeew instanceof zzelk) {
            return ((zzelk) com_google_android_gms_internal_zzeew).zzbud();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private final zzedm zzbvu() {
        if (this.zzmsi == null) {
            zzbvv();
        }
        return this.zzmsi;
    }

    private final synchronized void zzbvv() {
        this.zzmsi = new zzdzw(this.zzmlg);
    }

    public final boolean isPersistenceEnabled() {
        return this.zzmnr;
    }

    final void stop() {
        this.zzmsh = true;
        this.zzmse.shutdown();
    }

    public final zzebm zza(zzebk com_google_android_gms_internal_zzebk, zzebn com_google_android_gms_internal_zzebn) {
        return zzbvu().zza(this, new zzebi(this.zzmnq, new zzedd(this.zzmsd), zzbud(), this.zzmnr, FirebaseDatabase.getSdkVersion(), this.zzmnt, zzbvu().zzbta().getAbsolutePath()), com_google_android_gms_internal_zzebk, com_google_android_gms_internal_zzebn);
    }

    public final String zzbuf() {
        return this.zzmnt;
    }

    final synchronized void zzbvl() {
        if (!this.zzmrp) {
            this.zzmrp = true;
            if (this.zzmnq == null) {
                this.zzmnq = zzbvu().zza(this, this.zzmsg, null);
            }
            zzbvu();
            if (this.zzmnt == null) {
                this.zzmnt = "Firebase/" + "5/" + FirebaseDatabase.getSdkVersion() + "/" + zzbvu().zzc(this);
            }
            if (this.zzmsc == null) {
                this.zzmsc = zzbvu().zza(this);
            }
            if (this.zzmse == null) {
                this.zzmse = this.zzmsi.zzb(this);
            }
            if (this.zzmsf == null) {
                this.zzmsf = "default";
            }
            if (this.zzmsd == null) {
                this.zzmsd = zzbvu().zza(zzbud());
            }
        }
    }

    public final void zzbvw() {
        if (this.zzmsh) {
            this.zzmse.restart();
            this.zzmsh = false;
        }
    }

    protected final void zzbvx() {
        if (this.zzmrp) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public final zzeje zzbvy() {
        return this.zzmsg;
    }

    public final long zzbvz() {
        return this.cacheSize;
    }

    public final zzedj zzbwa() {
        return this.zzmsc;
    }

    public final String zzbwb() {
        return this.zzmsf;
    }

    public final zzejc zzpv(String str) {
        return new zzejc(this.zzmnq, str);
    }

    final zzegy zzpw(String str) {
        return this.zzmnr ? this.zzmsi.zza(this, str) : new zzegx();
    }
}
