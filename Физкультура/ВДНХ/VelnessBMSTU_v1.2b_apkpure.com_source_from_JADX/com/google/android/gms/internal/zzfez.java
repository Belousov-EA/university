package com.google.android.gms.internal;

import java.io.IOException;

class zzfez extends zzfey {
    protected final byte[] zzjng;

    zzfez(byte[] bArr) {
        this.zzjng = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfes)) {
            return false;
        }
        if (size() != ((zzfes) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfez)) {
            return obj.equals(this);
        }
        zzfez com_google_android_gms_internal_zzfez = (zzfez) obj;
        int zzcvp = zzcvp();
        int zzcvp2 = com_google_android_gms_internal_zzfez.zzcvp();
        return (zzcvp == 0 || zzcvp2 == 0 || zzcvp == zzcvp2) ? zza((zzfez) obj, 0, size()) : false;
    }

    public int size() {
        return this.zzjng.length;
    }

    final void zza(zzfer com_google_android_gms_internal_zzfer) throws IOException {
        com_google_android_gms_internal_zzfer.zzd(this.zzjng, zzcvq(), size());
    }

    final boolean zza(zzfes com_google_android_gms_internal_zzfes, int i, int i2) {
        if (i2 > com_google_android_gms_internal_zzfes.size()) {
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        } else if (i + i2 > com_google_android_gms_internal_zzfes.size()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + com_google_android_gms_internal_zzfes.size());
        } else if (!(com_google_android_gms_internal_zzfes instanceof zzfez)) {
            return com_google_android_gms_internal_zzfes.zzx(i, i + i2).equals(zzx(0, i2));
        } else {
            zzfez com_google_android_gms_internal_zzfez = (zzfez) com_google_android_gms_internal_zzfes;
            byte[] bArr = this.zzjng;
            byte[] bArr2 = com_google_android_gms_internal_zzfez.zzjng;
            int zzcvq = zzcvq() + i2;
            int zzcvq2 = zzcvq();
            int zzcvq3 = com_google_android_gms_internal_zzfez.zzcvq() + i;
            while (zzcvq2 < zzcvq) {
                if (bArr[zzcvq2] != bArr2[zzcvq3]) {
                    return false;
                }
                zzcvq2++;
                zzcvq3++;
            }
            return true;
        }
    }

    protected void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjng, i, bArr, i2, i3);
    }

    public final zzffb zzcvm() {
        return zzffb.zzb(this.zzjng, zzcvq(), size(), true);
    }

    protected int zzcvq() {
        return 0;
    }

    protected final int zzg(int i, int i2, int i3) {
        return zzffz.zza(i, this.zzjng, zzcvq() + i2, i3);
    }

    public byte zzkn(int i) {
        return this.zzjng[i];
    }

    public final zzfes zzx(int i, int i2) {
        int zzh = zzfes.zzh(i, i2, size());
        return zzh == 0 ? zzfes.zzpfg : new zzfev(this.zzjng, zzcvq() + i, zzh);
    }
}
