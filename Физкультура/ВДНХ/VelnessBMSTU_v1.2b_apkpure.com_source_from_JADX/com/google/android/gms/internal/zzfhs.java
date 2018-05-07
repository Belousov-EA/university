package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Stack;

final class zzfhs {
    private final Stack<zzfes> zzpjm;

    private zzfhs() {
        this.zzpjm = new Stack();
    }

    private final void zzba(zzfes com_google_android_gms_internal_zzfes) {
        zzfes com_google_android_gms_internal_zzfes2 = com_google_android_gms_internal_zzfes;
        while (!com_google_android_gms_internal_zzfes2.zzcvo()) {
            if (com_google_android_gms_internal_zzfes2 instanceof zzfhq) {
                zzfhq com_google_android_gms_internal_zzfhq = (zzfhq) com_google_android_gms_internal_zzfes2;
                zzba(com_google_android_gms_internal_zzfhq.zzpji);
                com_google_android_gms_internal_zzfes2 = com_google_android_gms_internal_zzfhq.zzpjj;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzfes2.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            }
        }
        int zzlz = zzlz(com_google_android_gms_internal_zzfes2.size());
        int i = zzfhq.zzpjg[zzlz + 1];
        if (this.zzpjm.isEmpty() || ((zzfes) this.zzpjm.peek()).size() >= i) {
            this.zzpjm.push(com_google_android_gms_internal_zzfes2);
            return;
        }
        int i2 = zzfhq.zzpjg[zzlz];
        zzfes com_google_android_gms_internal_zzfes3 = (zzfes) this.zzpjm.pop();
        while (!this.zzpjm.isEmpty() && ((zzfes) this.zzpjm.peek()).size() < i2) {
            com_google_android_gms_internal_zzfes3 = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfes3);
        }
        com_google_android_gms_internal_zzfes2 = new zzfhq(com_google_android_gms_internal_zzfes3, com_google_android_gms_internal_zzfes2);
        while (!this.zzpjm.isEmpty()) {
            if (((zzfes) this.zzpjm.peek()).size() >= zzfhq.zzpjg[zzlz(com_google_android_gms_internal_zzfes2.size()) + 1]) {
                break;
            }
            com_google_android_gms_internal_zzfes2 = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfes2);
        }
        this.zzpjm.push(com_google_android_gms_internal_zzfes2);
    }

    private final zzfes zzc(zzfes com_google_android_gms_internal_zzfes, zzfes com_google_android_gms_internal_zzfes2) {
        zzba(com_google_android_gms_internal_zzfes);
        zzba(com_google_android_gms_internal_zzfes2);
        zzfes com_google_android_gms_internal_zzfes3 = (zzfes) this.zzpjm.pop();
        while (!this.zzpjm.isEmpty()) {
            com_google_android_gms_internal_zzfes3 = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfes3);
        }
        return com_google_android_gms_internal_zzfes3;
    }

    private static int zzlz(int i) {
        int binarySearch = Arrays.binarySearch(zzfhq.zzpjg, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
