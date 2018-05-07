package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

final class zzam {
    final String key;
    final String zza;
    final long zzb;
    final long zzc;
    long zzcb;
    final long zzd;
    final long zze;
    final List<zzl> zzg;

    zzam(String str, zzc com_google_android_gms_internal_zzc) {
        this(str, com_google_android_gms_internal_zzc.zza, com_google_android_gms_internal_zzc.zzb, com_google_android_gms_internal_zzc.zzc, com_google_android_gms_internal_zzc.zzd, com_google_android_gms_internal_zzc.zze, com_google_android_gms_internal_zzc.zzg != null ? com_google_android_gms_internal_zzc.zzg : zzao.zza(com_google_android_gms_internal_zzc.zzf));
        this.zzcb = (long) com_google_android_gms_internal_zzc.data.length;
    }

    private zzam(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.key = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.zza = str2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzg = list;
    }

    static zzam zzc(zzan com_google_android_gms_internal_zzan) throws IOException {
        if (zzal.zzb((InputStream) com_google_android_gms_internal_zzan) == 538247942) {
            return new zzam(zzal.zza(com_google_android_gms_internal_zzan), zzal.zza(com_google_android_gms_internal_zzan), zzal.zzc(com_google_android_gms_internal_zzan), zzal.zzc(com_google_android_gms_internal_zzan), zzal.zzc(com_google_android_gms_internal_zzan), zzal.zzc(com_google_android_gms_internal_zzan), zzal.zzb(com_google_android_gms_internal_zzan));
        }
        throw new IOException();
    }

    final boolean zza(OutputStream outputStream) {
        try {
            zzal.zza(outputStream, 538247942);
            zzal.zza(outputStream, this.key);
            zzal.zza(outputStream, this.zza == null ? "" : this.zza);
            zzal.zza(outputStream, this.zzb);
            zzal.zza(outputStream, this.zzc);
            zzal.zza(outputStream, this.zzd);
            zzal.zza(outputStream, this.zze);
            List<zzl> list = this.zzg;
            if (list != null) {
                zzal.zza(outputStream, list.size());
                for (zzl com_google_android_gms_internal_zzl : list) {
                    zzal.zza(outputStream, com_google_android_gms_internal_zzl.getName());
                    zzal.zza(outputStream, com_google_android_gms_internal_zzl.getValue());
                }
            } else {
                zzal.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzae.zzb("%s", e.toString());
            return false;
        }
    }
}
