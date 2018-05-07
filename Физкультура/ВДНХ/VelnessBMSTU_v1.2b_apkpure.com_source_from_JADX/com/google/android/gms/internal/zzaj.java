package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class zzaj {
    private static Comparator<byte[]> zzbw = new zzak();
    private final List<byte[]> zzbs = new LinkedList();
    private final List<byte[]> zzbt = new ArrayList(64);
    private int zzbu = 0;
    private final int zzbv = 4096;

    public zzaj(int i) {
    }

    private final synchronized void zzm() {
        while (this.zzbu > this.zzbv) {
            byte[] bArr = (byte[]) this.zzbs.remove(0);
            this.zzbt.remove(bArr);
            this.zzbu -= bArr.length;
        }
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzbv) {
                this.zzbs.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzbt, bArr, zzbw);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzbt.add(binarySearch, bArr);
                this.zzbu += bArr.length;
                zzm();
            }
        }
    }

    public final synchronized byte[] zzb(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.zzbt.size(); i2++) {
            bArr = (byte[]) this.zzbt.get(i2);
            if (bArr.length >= i) {
                this.zzbu -= bArr.length;
                this.zzbt.remove(i2);
                this.zzbs.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
