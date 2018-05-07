package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfku extends zzfjm<zzfku> {
    public long zzghq;
    public String zzpri;
    public String zzprj;
    public long zzprk;
    public String zzprl;
    public long zzprm;
    public String zzprn;
    public String zzpro;
    public String zzprp;
    public String zzprq;
    public String zzprr;
    public int zzprs;
    public zzfkt[] zzprt;

    public zzfku() {
        this.zzpri = "";
        this.zzprj = "";
        this.zzprk = 0;
        this.zzprl = "";
        this.zzprm = 0;
        this.zzghq = 0;
        this.zzprn = "";
        this.zzpro = "";
        this.zzprp = "";
        this.zzprq = "";
        this.zzprr = "";
        this.zzprs = 0;
        this.zzprt = zzfkt.zzdbd();
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzfku zzbi(byte[] bArr) throws zzfjr {
        return (zzfku) zzfjs.zza(new zzfku(), bArr);
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            switch (zzcvt) {
                case 0:
                    break;
                case 10:
                    this.zzpri = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 18:
                    this.zzprj = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 24:
                    this.zzprk = com_google_android_gms_internal_zzfjj.zzcvv();
                    continue;
                case 34:
                    this.zzprl = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 40:
                    this.zzprm = com_google_android_gms_internal_zzfjj.zzcvv();
                    continue;
                case 48:
                    this.zzghq = com_google_android_gms_internal_zzfjj.zzcvv();
                    continue;
                case 58:
                    this.zzprn = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 66:
                    this.zzpro = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 74:
                    this.zzprp = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 82:
                    this.zzprq = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 90:
                    this.zzprr = com_google_android_gms_internal_zzfjj.readString();
                    continue;
                case 96:
                    this.zzprs = com_google_android_gms_internal_zzfjj.zzcvw();
                    continue;
                case 106:
                    int zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 106);
                    zzcvt = this.zzprt == null ? 0 : this.zzprt.length;
                    Object obj = new zzfkt[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzprt, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = new zzfkt();
                        com_google_android_gms_internal_zzfjj.zza(obj[zzcvt]);
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = new zzfkt();
                    com_google_android_gms_internal_zzfjj.zza(obj[zzcvt]);
                    this.zzprt = obj;
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (!(this.zzpri == null || this.zzpri.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(1, this.zzpri);
        }
        if (!(this.zzprj == null || this.zzprj.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.zzprj);
        }
        if (this.zzprk != 0) {
            com_google_android_gms_internal_zzfjk.zzf(3, this.zzprk);
        }
        if (!(this.zzprl == null || this.zzprl.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(4, this.zzprl);
        }
        if (this.zzprm != 0) {
            com_google_android_gms_internal_zzfjk.zzf(5, this.zzprm);
        }
        if (this.zzghq != 0) {
            com_google_android_gms_internal_zzfjk.zzf(6, this.zzghq);
        }
        if (!(this.zzprn == null || this.zzprn.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(7, this.zzprn);
        }
        if (!(this.zzpro == null || this.zzpro.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(8, this.zzpro);
        }
        if (!(this.zzprp == null || this.zzprp.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(9, this.zzprp);
        }
        if (!(this.zzprq == null || this.zzprq.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(10, this.zzprq);
        }
        if (!(this.zzprr == null || this.zzprr.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(11, this.zzprr);
        }
        if (this.zzprs != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(12, this.zzprs);
        }
        if (this.zzprt != null && this.zzprt.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzprt) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.zza(13, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!(this.zzpri == null || this.zzpri.equals(""))) {
            zzq += zzfjk.zzo(1, this.zzpri);
        }
        if (!(this.zzprj == null || this.zzprj.equals(""))) {
            zzq += zzfjk.zzo(2, this.zzprj);
        }
        if (this.zzprk != 0) {
            zzq += zzfjk.zzc(3, this.zzprk);
        }
        if (!(this.zzprl == null || this.zzprl.equals(""))) {
            zzq += zzfjk.zzo(4, this.zzprl);
        }
        if (this.zzprm != 0) {
            zzq += zzfjk.zzc(5, this.zzprm);
        }
        if (this.zzghq != 0) {
            zzq += zzfjk.zzc(6, this.zzghq);
        }
        if (!(this.zzprn == null || this.zzprn.equals(""))) {
            zzq += zzfjk.zzo(7, this.zzprn);
        }
        if (!(this.zzpro == null || this.zzpro.equals(""))) {
            zzq += zzfjk.zzo(8, this.zzpro);
        }
        if (!(this.zzprp == null || this.zzprp.equals(""))) {
            zzq += zzfjk.zzo(9, this.zzprp);
        }
        if (!(this.zzprq == null || this.zzprq.equals(""))) {
            zzq += zzfjk.zzo(10, this.zzprq);
        }
        if (!(this.zzprr == null || this.zzprr.equals(""))) {
            zzq += zzfjk.zzo(11, this.zzprr);
        }
        if (this.zzprs != 0) {
            zzq += zzfjk.zzad(12, this.zzprs);
        }
        if (this.zzprt == null || this.zzprt.length <= 0) {
            return zzq;
        }
        int i = zzq;
        for (zzfjs com_google_android_gms_internal_zzfjs : this.zzprt) {
            if (com_google_android_gms_internal_zzfjs != null) {
                i += zzfjk.zzb(13, com_google_android_gms_internal_zzfjs);
            }
        }
        return i;
    }
}
