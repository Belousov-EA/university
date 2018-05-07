package com.google.android.gms.internal;

final class zzfhb {
    private static final zzfgz zzpis = zzcyu();
    private static final zzfgz zzpit = new zzfha();

    static zzfgz zzcys() {
        return zzpis;
    }

    static zzfgz zzcyt() {
        return zzpit;
    }

    private static zzfgz zzcyu() {
        try {
            return (zzfgz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
