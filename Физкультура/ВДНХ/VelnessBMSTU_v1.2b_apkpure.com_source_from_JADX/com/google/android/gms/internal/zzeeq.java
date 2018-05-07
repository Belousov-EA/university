package com.google.android.gms.internal;

public final class zzeeq {
    public String host;
    public boolean secure;
    public String zzjrg;
    public String zzmuy;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzeeq com_google_android_gms_internal_zzeeq = (zzeeq) obj;
        return (this.secure == com_google_android_gms_internal_zzeeq.secure && this.host.equals(com_google_android_gms_internal_zzeeq.host)) ? this.zzjrg.equals(com_google_android_gms_internal_zzeeq.zzjrg) : false;
    }

    public final int hashCode() {
        return (((this.secure ? 1 : 0) + (this.host.hashCode() * 31)) * 31) + this.zzjrg.hashCode();
    }

    public final String toString() {
        String str = this.secure ? "s" : "";
        String str2 = this.host;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
