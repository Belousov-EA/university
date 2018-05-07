package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;

public abstract class zzffb {
    private static volatile boolean zzpfq = true;
    int zzpfm;
    int zzpfn;
    int zzpfo;
    private boolean zzpfp;

    private zzffb() {
        this.zzpfn = 100;
        this.zzpfo = Integer.MAX_VALUE;
        this.zzpfp = false;
    }

    static zzffb zzb(byte[] bArr, int i, int i2, boolean z) {
        zzffb com_google_android_gms_internal_zzffd = new zzffd(bArr, i, i2, z, null);
        try {
            com_google_android_gms_internal_zzffd.zzks(i2);
            return com_google_android_gms_internal_zzffd;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zzffb zzbb(byte[] bArr) {
        return zzb(bArr, 0, bArr.length, false);
    }

    public static long zzcs(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzffb zzg(byte[] bArr, int i, int i2) {
        return zzb(bArr, i, i2, false);
    }

    public static zzffb zzi(InputStream inputStream) {
        if (inputStream != null) {
            return new zzffe(inputStream, 4096, null);
        }
        byte[] bArr = zzffz.EMPTY_BYTE_ARRAY;
        return zzb(bArr, 0, bArr.length, false);
    }

    public static int zzkv(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzffu<T, ?>> T zza(T t, zzffm com_google_android_gms_internal_zzffm) throws IOException;

    public abstract void zza(zzfhf com_google_android_gms_internal_zzfhf, zzffm com_google_android_gms_internal_zzffm) throws IOException;

    public abstract int zzcvt() throws IOException;

    public abstract long zzcvu() throws IOException;

    public abstract long zzcvv() throws IOException;

    public abstract int zzcvw() throws IOException;

    public abstract long zzcvx() throws IOException;

    public abstract int zzcvy() throws IOException;

    public abstract boolean zzcvz() throws IOException;

    public abstract String zzcwa() throws IOException;

    public abstract zzfes zzcwb() throws IOException;

    public abstract int zzcwc() throws IOException;

    public abstract int zzcwd() throws IOException;

    public abstract int zzcwe() throws IOException;

    public abstract long zzcwf() throws IOException;

    public abstract int zzcwg() throws IOException;

    public abstract long zzcwh() throws IOException;

    public abstract int zzcwi() throws IOException;

    abstract long zzcwj() throws IOException;

    public abstract int zzcwk();

    public abstract boolean zzcwl() throws IOException;

    public abstract int zzcwm();

    public abstract void zzkp(int i) throws zzfge;

    public abstract boolean zzkq(int i) throws IOException;

    public final int zzkr(int i) {
        int i2 = this.zzpfo;
        this.zzpfo = Integer.MAX_VALUE;
        return i2;
    }

    public abstract int zzks(int i) throws zzfge;

    public abstract void zzkt(int i);

    public abstract void zzku(int i) throws IOException;
}
