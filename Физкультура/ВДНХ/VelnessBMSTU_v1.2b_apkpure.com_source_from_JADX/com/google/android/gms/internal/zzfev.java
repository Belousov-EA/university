package com.google.android.gms.internal;

final class zzfev extends zzfez {
    private final int zzpfj;
    private final int zzpfk;

    zzfev(byte[] bArr, int i, int i2) {
        super(bArr);
        zzfes.zzh(i, i + i2, bArr.length);
        this.zzpfj = i;
        this.zzpfk = i2;
    }

    public final int size() {
        return this.zzpfk;
    }

    protected final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjng, zzcvq() + i, bArr, i2, i3);
    }

    protected final int zzcvq() {
        return this.zzpfj;
    }

    public final byte zzkn(int i) {
        zzfes.zzy(i, size());
        return this.zzjng[this.zzpfj + i];
    }
}
