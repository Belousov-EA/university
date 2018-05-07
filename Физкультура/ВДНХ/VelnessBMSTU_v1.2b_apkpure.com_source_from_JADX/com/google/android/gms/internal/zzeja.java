package com.google.android.gms.internal;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzeja implements zzejd {
    private final Set<String> zznbj;
    private final zzeje zznbk;

    public zzeja(zzeje com_google_android_gms_internal_zzeje, List<String> list) {
        if (list != null) {
            this.zznbj = new HashSet(list);
        } else {
            this.zznbj = null;
        }
        this.zznbk = com_google_android_gms_internal_zzeje;
    }

    protected String zza(zzeje com_google_android_gms_internal_zzeje, String str, String str2, long j) {
        String date = new Date(j).toString();
        String valueOf = String.valueOf(com_google_android_gms_internal_zzeje);
        return new StringBuilder((((String.valueOf(date).length() + 6) + String.valueOf(valueOf).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(date).append(" [").append(valueOf).append("] ").append(str).append(": ").append(str2).toString();
    }

    public final void zzb(zzeje com_google_android_gms_internal_zzeje, String str, String str2, long j) {
        Object obj = (com_google_android_gms_internal_zzeje.ordinal() < this.zznbk.ordinal() || !(this.zznbj == null || com_google_android_gms_internal_zzeje.ordinal() > zzeje.DEBUG.ordinal() || this.zznbj.contains(str))) ? null : 1;
        if (obj != null) {
            String zza = zza(com_google_android_gms_internal_zzeje, str, str2, j);
            switch (zzejb.zzmqn[com_google_android_gms_internal_zzeje.ordinal()]) {
                case 1:
                    zzbg(str, zza);
                    return;
                case 2:
                    zzbh(str, zza);
                    return;
                case 3:
                    zzbi(str, zza);
                    return;
                case 4:
                    zzbj(str, zza);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    protected void zzbg(String str, String str2) {
        System.err.println(str2);
    }

    protected void zzbh(String str, String str2) {
        System.out.println(str2);
    }

    protected void zzbi(String str, String str2) {
        System.out.println(str2);
    }

    protected void zzbj(String str, String str2) {
        System.out.println(str2);
    }

    public final zzeje zzbvy() {
        return this.zznbk;
    }
}
