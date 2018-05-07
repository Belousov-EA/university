package com.google.android.gms.internal;

public final class zzebk {
    private final String host;
    private final boolean secure;
    private final String zzjrg;

    public zzebk(String str, String str2, boolean z) {
        this.host = str;
        this.zzjrg = str2;
        this.secure = z;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getNamespace() {
        return this.zzjrg;
    }

    public final boolean isSecure() {
        return this.secure;
    }

    public final String toString() {
        String str = this.secure ? "s" : "";
        String str2 = this.host;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
