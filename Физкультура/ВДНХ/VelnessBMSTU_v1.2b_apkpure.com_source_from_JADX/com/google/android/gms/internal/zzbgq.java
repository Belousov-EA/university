package com.google.android.gms.internal;

public abstract class zzbgq extends zzbgn implements zzbfq {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        zzbgn com_google_android_gms_internal_zzbgn = (zzbgn) obj;
        for (zzbgo com_google_android_gms_internal_zzbgo : zzaav().values()) {
            if (zza(com_google_android_gms_internal_zzbgo)) {
                if (!com_google_android_gms_internal_zzbgn.zza(com_google_android_gms_internal_zzbgo)) {
                    return false;
                }
                if (!zzb(com_google_android_gms_internal_zzbgo).equals(com_google_android_gms_internal_zzbgn.zzb(com_google_android_gms_internal_zzbgo))) {
                    return false;
                }
            } else if (com_google_android_gms_internal_zzbgn.zza(com_google_android_gms_internal_zzbgo)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (zzbgo com_google_android_gms_internal_zzbgo : zzaav().values()) {
            int hashCode;
            if (zza(com_google_android_gms_internal_zzbgo)) {
                hashCode = zzb(com_google_android_gms_internal_zzbgo).hashCode() + (i * 31);
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public Object zzgo(String str) {
        return null;
    }

    public boolean zzgp(String str) {
        return false;
    }
}
