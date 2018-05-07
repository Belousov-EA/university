package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

final class zzeko implements zzekp {
    private List<byte[]> zzndl = new ArrayList();
    private int zzndm = 0;

    zzeko() {
    }

    public final boolean zzao(byte[] bArr) {
        this.zzndl.add(bArr);
        this.zzndm += bArr.length;
        return true;
    }

    public final zzelc zzcar() {
        byte[] bArr = new byte[this.zzndm];
        int i = 0;
        for (int i2 = 0; i2 < this.zzndl.size(); i2++) {
            byte[] bArr2 = (byte[]) this.zzndl.get(i2);
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            i += bArr2.length;
        }
        return new zzelc(bArr);
    }
}
