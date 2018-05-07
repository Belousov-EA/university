package com.google.android.gms.internal;

public final class zzeiu implements zzeiw {
    private final zzejv zznaa;

    public zzeiu(zzejv com_google_android_gms_internal_zzejv) {
        this.zznaa = com_google_android_gms_internal_zzejv;
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzedk com_google_android_gms_internal_zzedk, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        zzekd zzbsv = com_google_android_gms_internal_zzejw.zzbsv();
        zzekd zzm = zzbsv.zzm(com_google_android_gms_internal_zzejg);
        if (zzm.zzan(com_google_android_gms_internal_zzedk).equals(com_google_android_gms_internal_zzekd.zzan(com_google_android_gms_internal_zzedk)) && zzm.isEmpty() == com_google_android_gms_internal_zzekd.isEmpty()) {
            return com_google_android_gms_internal_zzejw;
        }
        if (com_google_android_gms_internal_zzeit != null) {
            if (com_google_android_gms_internal_zzekd.isEmpty()) {
                if (zzbsv.zzk(com_google_android_gms_internal_zzejg)) {
                    com_google_android_gms_internal_zzeit.zza(zzehz.zzd(com_google_android_gms_internal_zzejg, zzm));
                }
            } else if (zzm.isEmpty()) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd));
            } else {
                com_google_android_gms_internal_zzeit.zza(zzehz.zza(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd, zzm));
            }
        }
        return (zzbsv.zzbzu() && com_google_android_gms_internal_zzekd.isEmpty()) ? com_google_android_gms_internal_zzejw : com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejw com_google_android_gms_internal_zzejw2, zzeit com_google_android_gms_internal_zzeit) {
        if (com_google_android_gms_internal_zzeit != null) {
            for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzejw.zzbsv()) {
                if (!com_google_android_gms_internal_zzejw2.zzbsv().zzk(com_google_android_gms_internal_zzekc.zzcao())) {
                    com_google_android_gms_internal_zzeit.zza(zzehz.zzd(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv()));
                }
            }
            if (!com_google_android_gms_internal_zzejw2.zzbsv().zzbzu()) {
                for (zzekc com_google_android_gms_internal_zzekc2 : com_google_android_gms_internal_zzejw2.zzbsv()) {
                    if (com_google_android_gms_internal_zzejw.zzbsv().zzk(com_google_android_gms_internal_zzekc2.zzcao())) {
                        zzekd zzm = com_google_android_gms_internal_zzejw.zzbsv().zzm(com_google_android_gms_internal_zzekc2.zzcao());
                        if (!zzm.equals(com_google_android_gms_internal_zzekc2.zzbsv())) {
                            com_google_android_gms_internal_zzeit.zza(zzehz.zza(com_google_android_gms_internal_zzekc2.zzcao(), com_google_android_gms_internal_zzekc2.zzbsv(), zzm));
                        }
                    } else {
                        com_google_android_gms_internal_zzeit.zza(zzehz.zzc(com_google_android_gms_internal_zzekc2.zzcao(), com_google_android_gms_internal_zzekc2.zzbsv()));
                    }
                }
            }
        }
        return com_google_android_gms_internal_zzejw2;
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzejw.zzbsv().isEmpty() ? com_google_android_gms_internal_zzejw : com_google_android_gms_internal_zzejw.zzk(com_google_android_gms_internal_zzekd);
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final zzeiw zzbzh() {
        return this;
    }

    public final boolean zzbzi() {
        return false;
    }
}
