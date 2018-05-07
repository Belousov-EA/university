package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzffw extends zzffu<zzffw, zza> implements zzfhg {
    private static volatile zzfhk<zzffw> zzbbk;
    private static final zzffw zzphr;
    private int zzphq;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzffw, zza> implements zzfhg {
        private zza() {
            super(zzffw.zzphr);
        }

        public final zza zzlt(int i) {
            zzcxr();
            ((zzffw) this.zzpgv).setValue(i);
            return this;
        }
    }

    static {
        zzffu com_google_android_gms_internal_zzffw = new zzffw();
        zzphr = com_google_android_gms_internal_zzffw;
        com_google_android_gms_internal_zzffw.zza(zzg.zzphh, null, null);
        com_google_android_gms_internal_zzffw.zzpgr.zzbiy();
    }

    private zzffw() {
    }

    private final void setValue(int i) {
        this.zzphq = i;
    }

    public static zza zzcxw() {
        zzffu com_google_android_gms_internal_zzffu = zzphr;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.zza(zzg.zzphj, null, null);
        com_google_android_gms_internal_zzffu_zza.zza(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzffw zzcxx() {
        return zzphr;
    }

    public final int getValue() {
        return this.zzphq;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = true;
        boolean z2;
        switch (zzffx.zzbbi[i - 1]) {
            case 1:
                return new zzffw();
            case 2:
                return zzphr;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzffw com_google_android_gms_internal_zzffw = (zzffw) obj2;
                z2 = this.zzphq != 0;
                int i2 = this.zzphq;
                if (com_google_android_gms_internal_zzffw.zzphq == 0) {
                    z = false;
                }
                this.zzphq = com_google_android_gms_internal_zzffu_zzh.zza(z2, i2, z, com_google_android_gms_internal_zzffw.zzphq);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    boolean z3 = false;
                    while (!z3) {
                        try {
                            int zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
                            switch (zzcvt) {
                                case 0:
                                    z3 = true;
                                    break;
                                case 8:
                                    this.zzphq = com_google_android_gms_internal_zzffb.zzcvw();
                                    break;
                                default:
                                    if ((zzcvt & 7) == 4) {
                                        z2 = false;
                                    } else {
                                        if (this.zzpgr == zzfio.zzczu()) {
                                            this.zzpgr = zzfio.zzczv();
                                        }
                                        z2 = this.zzpgr.zzb(zzcvt, com_google_android_gms_internal_zzffb);
                                    }
                                    if (!z2) {
                                        z3 = true;
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
                    synchronized (zzffw.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzb(zzphr);
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
        return zzphr;
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.zzphq != 0) {
            com_google_android_gms_internal_zzffg.zzaa(1, this.zzphq);
        }
        this.zzpgr.zza(com_google_android_gms_internal_zzffg);
    }

    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        i = 0;
        if (this.zzphq != 0) {
            i = zzffg.zzad(1, this.zzphq) + 0;
        }
        i += this.zzpgr.zzho();
        this.zzpgs = i;
        return i;
    }
}
