package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkt extends zzfjm<zzfkt> {
    private static volatile zzfkt[] zzprh;
    public String zzpri;

    public zzfkt() {
        this.zzpri = "";
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzfkt[] zzdbd() {
        if (zzprh == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzprh == null) {
                    zzprh = new zzfkt[0];
                }
            }
        }
        return zzprh;
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
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        return (this.zzpri == null || this.zzpri.equals("")) ? zzq : zzq + zzfjk.zzo(1, this.zzpri);
    }
}
