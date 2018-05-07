package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzfik extends zzffu<zzfik, zza> implements zzfhg {
    private static volatile zzfhk<zzfik> zzbbk;
    private static final zzfik zzpkn;
    private long zzpkl;
    private int zzpkm;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzfik, zza> implements zzfhg {
        private zza() {
            super(zzfik.zzpkn);
        }

        public final zza zzdg(long j) {
            zzcxr();
            ((zzfik) this.zzpgv).zzdf(j);
            return this;
        }

        public final zza zzmd(int i) {
            zzcxr();
            ((zzfik) this.zzpgv).setNanos(i);
            return this;
        }
    }

    static {
        zzffu com_google_android_gms_internal_zzfik = new zzfik();
        zzpkn = com_google_android_gms_internal_zzfik;
        com_google_android_gms_internal_zzfik.zza(zzg.zzphh, null, null);
        com_google_android_gms_internal_zzfik.zzpgr.zzbiy();
    }

    private zzfik() {
    }

    private final void setNanos(int i) {
        this.zzpkm = i;
    }

    public static zza zzczq() {
        zzffu com_google_android_gms_internal_zzffu = zzpkn;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.zza(zzg.zzphj, null, null);
        com_google_android_gms_internal_zzffu_zza.zza(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzfik zzczr() {
        return zzpkn;
    }

    private final void zzdf(long j) {
        this.zzpkl = j;
    }

    public final int getNanos() {
        return this.zzpkm;
    }

    public final long getSeconds() {
        return this.zzpkl;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = true;
        boolean z2;
        switch (zzfil.zzbbi[i - 1]) {
            case 1:
                return new zzfik();
            case 2:
                return zzpkn;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzfik com_google_android_gms_internal_zzfik = (zzfik) obj2;
                this.zzpkl = com_google_android_gms_internal_zzffu_zzh.zza(this.zzpkl != 0, this.zzpkl, com_google_android_gms_internal_zzfik.zzpkl != 0, com_google_android_gms_internal_zzfik.zzpkl);
                z2 = this.zzpkm != 0;
                int i2 = this.zzpkm;
                if (com_google_android_gms_internal_zzfik.zzpkm == 0) {
                    z = false;
                }
                this.zzpkm = com_google_android_gms_internal_zzffu_zzh.zza(z2, i2, z, com_google_android_gms_internal_zzfik.zzpkm);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    z2 = false;
                    while (!z2) {
                        try {
                            int zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
                            switch (zzcvt) {
                                case 0:
                                    z2 = true;
                                    break;
                                case 8:
                                    this.zzpkl = com_google_android_gms_internal_zzffb.zzcvv();
                                    break;
                                case 16:
                                    this.zzpkm = com_google_android_gms_internal_zzffb.zzcvw();
                                    break;
                                default:
                                    boolean z3;
                                    if ((zzcvt & 7) == 4) {
                                        z3 = false;
                                    } else {
                                        if (this.zzpgr == zzfio.zzczu()) {
                                            this.zzpgr = zzfio.zzczv();
                                        }
                                        z3 = this.zzpgr.zzb(zzcvt, com_google_android_gms_internal_zzffb);
                                    }
                                    if (!z3) {
                                        z2 = true;
                                        break;
                                    }
                                    break;
                            }
                        } catch (zzfge e) {
                            throw new RuntimeException(e.zzi(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzfge(e2.getMessage()).zzi(this));
                        }
                    }
                    break;
                }
                throw new NullPointerException();
            case 7:
                break;
            case 8:
                if (zzbbk == null) {
                    synchronized (zzfik.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzb(zzpkn);
                        }
                    }
                }
                return zzbbk;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpkn;
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.zzpkl != 0) {
            com_google_android_gms_internal_zzffg.zza(1, this.zzpkl);
        }
        if (this.zzpkm != 0) {
            com_google_android_gms_internal_zzffg.zzaa(2, this.zzpkm);
        }
        this.zzpgr.zza(com_google_android_gms_internal_zzffg);
    }

    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        i = 0;
        if (this.zzpkl != 0) {
            i = zzffg.zzc(1, this.zzpkl) + 0;
        }
        if (this.zzpkm != 0) {
            i += zzffg.zzad(2, this.zzpkm);
        }
        i += this.zzpgr.zzho();
        this.zzpgs = i;
        return i;
    }
}
