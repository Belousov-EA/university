package com.google.android.gms.internal;

final class zzffp {
    private static final zzffn<?> zzpgi = new zzffo();
    private static final zzffn<?> zzpgj = zzcxc();

    private static zzffn<?> zzcxc() {
        try {
            return (zzffn) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzffn<?> zzcxd() {
        return zzpgi;
    }

    static zzffn<?> zzcxe() {
        if (zzpgj != null) {
            return zzpgj;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
