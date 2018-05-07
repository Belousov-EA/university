package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class zzejn {
    private final List<zzedk> zzmnb;
    private final List<String> zzmnc;

    private zzejn(List<zzedk> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.zzmnb = list;
        this.zzmnc = list2;
    }

    private static void zza(zzekd com_google_android_gms_internal_zzekd, zzejp com_google_android_gms_internal_zzejp) {
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            com_google_android_gms_internal_zzejp.zzb((zzejy) com_google_android_gms_internal_zzekd);
        } else if (com_google_android_gms_internal_zzekd.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (com_google_android_gms_internal_zzekd instanceof zzeji) {
            ((zzeji) com_google_android_gms_internal_zzekd).zza(new zzejo(com_google_android_gms_internal_zzejp), true);
        } else {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzekd);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        }
    }

    public static zzejn zzh(zzekd com_google_android_gms_internal_zzekd) {
        zzejr com_google_android_gms_internal_zzejq = new zzejq(com_google_android_gms_internal_zzekd);
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return new zzejn(Collections.emptyList(), Collections.singletonList(""));
        }
        zzejp com_google_android_gms_internal_zzejp = new zzejp(com_google_android_gms_internal_zzejq);
        zza(com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzejp);
        com_google_android_gms_internal_zzejp.zzcad();
        return new zzejn(com_google_android_gms_internal_zzejp.zznci, com_google_android_gms_internal_zzejp.zzncj);
    }

    public final List<zzedk> zzbtz() {
        return Collections.unmodifiableList(this.zzmnb);
    }

    public final List<String> zzbua() {
        return Collections.unmodifiableList(this.zzmnc);
    }
}
