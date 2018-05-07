package com.google.android.gms.internal;

public final class zzelo {
    private static long zzc(zzejy<?> com_google_android_gms_internal_zzejy_) {
        long j = 8;
        if (!((com_google_android_gms_internal_zzejy_ instanceof zzejt) || (com_google_android_gms_internal_zzejy_ instanceof zzekb))) {
            if (com_google_android_gms_internal_zzejy_ instanceof zzejf) {
                j = 4;
            } else if (com_google_android_gms_internal_zzejy_ instanceof zzekl) {
                j = (long) (((String) com_google_android_gms_internal_zzejy_.getValue()).length() + 2);
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzejy_.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (com_google_android_gms_internal_zzejy_.zzbzv().isEmpty()) {
            return j;
        }
        return zzc((zzejy) com_google_android_gms_internal_zzejy_.zzbzv()) + (24 + j);
    }

    public static long zzn(zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return 4;
        }
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            return zzc((zzejy) com_google_android_gms_internal_zzekd);
        }
        long j = 1;
        for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
            j = zzn(com_google_android_gms_internal_zzekc.zzbsv()) + ((j + ((long) com_google_android_gms_internal_zzekc.zzcao().asString().length())) + 4);
        }
        return !com_google_android_gms_internal_zzekd.zzbzv().isEmpty() ? (j + 12) + zzc((zzejy) com_google_android_gms_internal_zzekd.zzbzv()) : j;
    }

    public static int zzo(zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return 0;
        }
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            return 1;
        }
        int i = 0;
        for (zzekc zzbsv : com_google_android_gms_internal_zzekd) {
            i = zzo(zzbsv.zzbsv()) + i;
        }
        return i;
    }
}
