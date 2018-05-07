package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzf;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzfkg extends zzffu<zzfkg, zza> implements zzfhg {
    private static volatile zzfhk<zzfkg> zzbbk;
    private static final zzfkg zzppn;
    private int zzlwy;
    private int zzppk;
    private String zzppl = "";
    private zzfgd<zzfep> zzppm = zzffu.zzcxo();

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzfkg, zza> implements zzfhg {
        private zza() {
            super(zzfkg.zzppn);
        }
    }

    static {
        zzffu com_google_android_gms_internal_zzfkg = new zzfkg();
        zzppn = com_google_android_gms_internal_zzfkg;
        com_google_android_gms_internal_zzfkg.zza(zzg.zzphh, null, null);
        com_google_android_gms_internal_zzfkg.zzpgr.zzbiy();
    }

    private zzfkg() {
    }

    public static zzfkg zzdap() {
        return zzppn;
    }

    public final int getCode() {
        return this.zzppk;
    }

    public final String getMessage() {
        return this.zzppl;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        boolean z2 = true;
        switch (zzfkh.zzbbi[i - 1]) {
            case 1:
                return new zzfkg();
            case 2:
                return zzppn;
            case 3:
                this.zzppm.zzbiy();
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzfkg com_google_android_gms_internal_zzfkg = (zzfkg) obj2;
                this.zzppk = com_google_android_gms_internal_zzffu_zzh.zza(this.zzppk != 0, this.zzppk, com_google_android_gms_internal_zzfkg.zzppk != 0, com_google_android_gms_internal_zzfkg.zzppk);
                boolean z3 = !this.zzppl.isEmpty();
                String str = this.zzppl;
                if (com_google_android_gms_internal_zzfkg.zzppl.isEmpty()) {
                    z2 = false;
                }
                this.zzppl = com_google_android_gms_internal_zzffu_zzh.zza(z3, str, z2, com_google_android_gms_internal_zzfkg.zzppl);
                this.zzppm = com_google_android_gms_internal_zzffu_zzh.zza(this.zzppm, com_google_android_gms_internal_zzfkg.zzppm);
                if (com_google_android_gms_internal_zzffu_zzh != zzf.zzphb) {
                    return this;
                }
                this.zzlwy |= com_google_android_gms_internal_zzfkg.zzlwy;
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (!z) {
                        try {
                            int zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
                            switch (zzcvt) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.zzppk = com_google_android_gms_internal_zzffb.zzcvw();
                                    break;
                                case 18:
                                    this.zzppl = com_google_android_gms_internal_zzffb.zzcwa();
                                    break;
                                case 26:
                                    if (!this.zzppm.zzcvi()) {
                                        zzfgd com_google_android_gms_internal_zzfgd = this.zzppm;
                                        zzcvt = com_google_android_gms_internal_zzfgd.size();
                                        this.zzppm = com_google_android_gms_internal_zzfgd.zzly(zzcvt == 0 ? 10 : zzcvt << 1);
                                    }
                                    this.zzppm.add((zzfep) com_google_android_gms_internal_zzffb.zza(zzfep.zzcvk(), com_google_android_gms_internal_zzffm));
                                    break;
                                default:
                                    if (!zza(zzcvt, com_google_android_gms_internal_zzffb)) {
                                        z = true;
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
                    synchronized (zzfkg.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzb(zzppn);
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
        return zzppn;
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.zzppk != 0) {
            com_google_android_gms_internal_zzffg.zzaa(1, this.zzppk);
        }
        if (!this.zzppl.isEmpty()) {
            com_google_android_gms_internal_zzffg.zzn(2, this.zzppl);
        }
        for (int i = 0; i < this.zzppm.size(); i++) {
            com_google_android_gms_internal_zzffg.zza(3, (zzfhe) this.zzppm.get(i));
        }
        this.zzpgr.zza(com_google_android_gms_internal_zzffg);
    }

    public final int zzho() {
        int i = 0;
        int i2 = this.zzpgs;
        if (i2 != -1) {
            return i2;
        }
        i2 = this.zzppk != 0 ? zzffg.zzad(1, this.zzppk) + 0 : 0;
        if (!this.zzppl.isEmpty()) {
            i2 += zzffg.zzo(2, this.zzppl);
        }
        int i3 = i2;
        while (i < this.zzppm.size()) {
            i++;
            i3 = zzffg.zzc(3, (zzfhe) this.zzppm.get(i)) + i3;
        }
        i2 = this.zzpgr.zzho() + i3;
        this.zzpgs = i2;
        return i2;
    }
}
