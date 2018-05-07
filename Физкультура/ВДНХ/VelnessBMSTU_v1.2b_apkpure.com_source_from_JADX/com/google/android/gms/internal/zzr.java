package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;
import java.util.Map;

public abstract class zzr<T> implements Comparable<zzr<T>> {
    private final Object mLock;
    private final zza zzaf;
    private final int zzag;
    private final String zzah;
    private final int zzai;
    private final zzx zzaj;
    private Integer zzak;
    private zzv zzal;
    private boolean zzam;
    private boolean zzan;
    private boolean zzao;
    private boolean zzap;
    private zzaa zzaq;
    private zzc zzar;
    private zzt zzas;

    public zzr(int i, String str, zzx com_google_android_gms_internal_zzx) {
        int hashCode;
        this.zzaf = zza.zzbl ? new zza() : null;
        this.zzam = true;
        this.zzan = false;
        this.zzao = false;
        this.zzap = false;
        this.zzar = null;
        this.mLock = new Object();
        this.zzag = i;
        this.zzah = str;
        this.zzaj = com_google_android_gms_internal_zzx;
        this.zzaq = new zzh();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    hashCode = host.hashCode();
                    this.zzai = hashCode;
                }
            }
        }
        hashCode = 0;
        this.zzai = hashCode;
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzr com_google_android_gms_internal_zzr = (zzr) obj;
        zzu com_google_android_gms_internal_zzu = zzu.NORMAL;
        zzu com_google_android_gms_internal_zzu2 = zzu.NORMAL;
        return com_google_android_gms_internal_zzu == com_google_android_gms_internal_zzu2 ? this.zzak.intValue() - com_google_android_gms_internal_zzr.zzak.intValue() : com_google_android_gms_internal_zzu2.ordinal() - com_google_android_gms_internal_zzu.ordinal();
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzag;
    }

    public final String getUrl() {
        return this.zzah;
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(this.zzai));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String str2 = this.zzah;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.zzak);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(str).append(str2).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf3).toString();
    }

    public final zzr<?> zza(int i) {
        this.zzak = Integer.valueOf(i);
        return this;
    }

    public final zzr<?> zza(zzc com_google_android_gms_internal_zzc) {
        this.zzar = com_google_android_gms_internal_zzc;
        return this;
    }

    public final zzr<?> zza(zzv com_google_android_gms_internal_zzv) {
        this.zzal = com_google_android_gms_internal_zzv;
        return this;
    }

    protected abstract zzw<T> zza(zzp com_google_android_gms_internal_zzp);

    final void zza(zzt com_google_android_gms_internal_zzt) {
        synchronized (this.mLock) {
            this.zzas = com_google_android_gms_internal_zzt;
        }
    }

    final void zza(zzw<?> com_google_android_gms_internal_zzw_) {
        synchronized (this.mLock) {
            if (this.zzas != null) {
                this.zzas.zza(this, com_google_android_gms_internal_zzw_);
            }
        }
    }

    protected abstract void zza(T t);

    public final void zzb(zzad com_google_android_gms_internal_zzad) {
        if (this.zzaj != null) {
            this.zzaj.zzd(com_google_android_gms_internal_zzad);
        }
    }

    public final void zzb(String str) {
        if (zza.zzbl) {
            this.zzaf.zza(str, Thread.currentThread().getId());
        }
    }

    final void zzc(String str) {
        if (this.zzal != null) {
            this.zzal.zzf(this);
        }
        if (zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzs(this, str, id));
                return;
            }
            this.zzaf.zza(str, id);
            this.zzaf.zzc(toString());
        }
    }

    public final int zzd() {
        return this.zzai;
    }

    public final zzc zze() {
        return this.zzar;
    }

    public byte[] zzf() throws zza {
        return null;
    }

    public final boolean zzg() {
        return this.zzam;
    }

    public final int zzh() {
        return this.zzaq.zzb();
    }

    public final zzaa zzi() {
        return this.zzaq;
    }

    public final void zzj() {
        this.zzao = true;
    }

    public final boolean zzk() {
        return this.zzao;
    }

    final void zzl() {
        synchronized (this.mLock) {
            if (this.zzas != null) {
                this.zzas.zza(this);
            }
        }
    }
}
