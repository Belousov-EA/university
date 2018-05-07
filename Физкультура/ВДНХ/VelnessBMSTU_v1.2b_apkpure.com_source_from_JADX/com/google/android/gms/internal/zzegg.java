package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzegg {
    private static final zzehq<zzegd> zzmxa = new zzegi();
    private zzecy zzmwx = zzecy.zzbvq();
    private List<zzegd> zzmwy = new ArrayList();
    private Long zzmwz = Long.valueOf(-1);

    private static zzecy zza(List<zzegd> list, zzehq<zzegd> com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzegd, zzedk com_google_android_gms_internal_zzedk) {
        zzecy zzbvq = zzecy.zzbvq();
        zzecy com_google_android_gms_internal_zzecy = zzbvq;
        for (zzegd com_google_android_gms_internal_zzegd : list) {
            if (com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzegd.zzbs(com_google_android_gms_internal_zzegd)) {
                zzedk zzbsy = com_google_android_gms_internal_zzegd.zzbsy();
                if (com_google_android_gms_internal_zzegd.zzbxb()) {
                    if (com_google_android_gms_internal_zzedk.zzi(zzbsy)) {
                        com_google_android_gms_internal_zzecy = com_google_android_gms_internal_zzecy.zze(zzedk.zza(com_google_android_gms_internal_zzedk, zzbsy), com_google_android_gms_internal_zzegd.zzbwz());
                    } else if (zzbsy.zzi(com_google_android_gms_internal_zzedk)) {
                        com_google_android_gms_internal_zzecy = com_google_android_gms_internal_zzecy.zze(zzedk.zzbwe(), com_google_android_gms_internal_zzegd.zzbwz().zzan(zzedk.zza(zzbsy, com_google_android_gms_internal_zzedk)));
                    }
                } else if (com_google_android_gms_internal_zzedk.zzi(zzbsy)) {
                    com_google_android_gms_internal_zzecy = com_google_android_gms_internal_zzecy.zzb(zzedk.zza(com_google_android_gms_internal_zzedk, zzbsy), com_google_android_gms_internal_zzegd.zzbxa());
                } else if (zzbsy.zzi(com_google_android_gms_internal_zzedk)) {
                    zzbsy = zzedk.zza(zzbsy, com_google_android_gms_internal_zzedk);
                    if (zzbsy.isEmpty()) {
                        com_google_android_gms_internal_zzecy = com_google_android_gms_internal_zzecy.zzb(zzedk.zzbwe(), com_google_android_gms_internal_zzegd.zzbxa());
                    } else {
                        zzekd zzf = com_google_android_gms_internal_zzegd.zzbxa().zzf(zzbsy);
                        if (zzf != null) {
                            zzbvq = com_google_android_gms_internal_zzecy.zze(zzedk.zzbwe(), zzf);
                            com_google_android_gms_internal_zzecy = zzbvq;
                        }
                    }
                }
            }
            zzbvq = com_google_android_gms_internal_zzecy;
            com_google_android_gms_internal_zzecy = zzbvq;
        }
        return com_google_android_gms_internal_zzecy;
    }

    public final zzekc zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzekc com_google_android_gms_internal_zzekc, boolean z, zzejv com_google_android_gms_internal_zzejv) {
        zzekc com_google_android_gms_internal_zzekc2 = null;
        zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        zzekd zzf = zzg.zzf(zzedk.zzbwe());
        if (zzf == null) {
            if (com_google_android_gms_internal_zzekd != null) {
                zzf = zzg.zzb(com_google_android_gms_internal_zzekd);
            }
            return com_google_android_gms_internal_zzekc2;
        }
        for (zzekc com_google_android_gms_internal_zzekc3 : r0) {
            zzekc com_google_android_gms_internal_zzekc32;
            if (com_google_android_gms_internal_zzejv.zza(com_google_android_gms_internal_zzekc32, com_google_android_gms_internal_zzekc, z) <= 0 || (com_google_android_gms_internal_zzekc2 != null && com_google_android_gms_internal_zzejv.zza(com_google_android_gms_internal_zzekc32, com_google_android_gms_internal_zzekc2, z) >= 0)) {
                com_google_android_gms_internal_zzekc32 = com_google_android_gms_internal_zzekc2;
            }
            com_google_android_gms_internal_zzekc2 = com_google_android_gms_internal_zzekc32;
        }
        return com_google_android_gms_internal_zzekc2;
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzedk com_google_android_gms_internal_zzedk2, zzekd com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd2) {
        zzedk zzh = com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2);
        if (this.zzmwx.zze(zzh)) {
            return null;
        }
        zzecy zzg = this.zzmwx.zzg(zzh);
        return zzg.isEmpty() ? com_google_android_gms_internal_zzekd2.zzan(com_google_android_gms_internal_zzedk2) : zzg.zzb(com_google_android_gms_internal_zzekd2.zzan(com_google_android_gms_internal_zzedk2));
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzejg com_google_android_gms_internal_zzejg, zzehx com_google_android_gms_internal_zzehx) {
        zzedk zza = com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzejg);
        zzekd zzf = this.zzmwx.zzf(zza);
        return zzf != null ? zzf : com_google_android_gms_internal_zzehx.zzf(com_google_android_gms_internal_zzejg) ? this.zzmwx.zzg(zza).zzb(com_google_android_gms_internal_zzehx.zzbsv().zzm(com_google_android_gms_internal_zzejg)) : null;
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, List<Long> list, boolean z) {
        zzecy zzg;
        if (!list.isEmpty() || z) {
            zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
            if (!z && zzg.isEmpty()) {
                return com_google_android_gms_internal_zzekd;
            }
            if (!z && com_google_android_gms_internal_zzekd == null && !zzg.zze(zzedk.zzbwe())) {
                return null;
            }
            zzg = zza(this.zzmwy, new zzegh(this, z, list, com_google_android_gms_internal_zzedk), com_google_android_gms_internal_zzedk);
            if (com_google_android_gms_internal_zzekd == null) {
                com_google_android_gms_internal_zzekd = zzeju.zzcaf();
            }
            return zzg.zzb(com_google_android_gms_internal_zzekd);
        }
        zzekd zzf = this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
        if (zzf != null) {
            return zzf;
        }
        zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        if (zzg.isEmpty()) {
            return com_google_android_gms_internal_zzekd;
        }
        if (com_google_android_gms_internal_zzekd == null && !zzg.zze(zzedk.zzbwe())) {
            return null;
        }
        if (com_google_android_gms_internal_zzekd == null) {
            com_google_android_gms_internal_zzekd = zzeju.zzcaf();
        }
        return zzg.zzb(com_google_android_gms_internal_zzekd);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, Long l) {
        this.zzmwy.add(new zzegd(l.longValue(), com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy));
        this.zzmwx = this.zzmwx.zzb(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        this.zzmwz = l;
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, Long l, boolean z) {
        this.zzmwy.add(new zzegd(l.longValue(), com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, z));
        if (z) {
            this.zzmwx = this.zzmwx.zze(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
        }
        this.zzmwz = l;
    }

    public final zzegd zzbv(long j) {
        for (zzegd com_google_android_gms_internal_zzegd : this.zzmwy) {
            if (com_google_android_gms_internal_zzegd.zzbwy() == j) {
                return com_google_android_gms_internal_zzegd;
            }
        }
        return null;
    }

    public final boolean zzbw(long j) {
        zzegd com_google_android_gms_internal_zzegd;
        zzegd com_google_android_gms_internal_zzegd2;
        int i = 0;
        for (zzegd com_google_android_gms_internal_zzegd3 : this.zzmwy) {
            if (com_google_android_gms_internal_zzegd3.zzbwy() == j) {
                com_google_android_gms_internal_zzegd2 = com_google_android_gms_internal_zzegd3;
                break;
            }
            i++;
        }
        com_google_android_gms_internal_zzegd2 = null;
        this.zzmwy.remove(com_google_android_gms_internal_zzegd2);
        boolean isVisible = com_google_android_gms_internal_zzegd2.isVisible();
        int size = this.zzmwy.size() - 1;
        boolean z = false;
        while (isVisible && size >= 0) {
            boolean zzi;
            boolean z2;
            com_google_android_gms_internal_zzegd3 = (zzegd) this.zzmwy.get(size);
            if (com_google_android_gms_internal_zzegd3.isVisible()) {
                if (size >= i) {
                    zzedk zzbsy = com_google_android_gms_internal_zzegd2.zzbsy();
                    if (com_google_android_gms_internal_zzegd3.zzbxb()) {
                        zzi = com_google_android_gms_internal_zzegd3.zzbsy().zzi(zzbsy);
                    } else {
                        Iterator it = com_google_android_gms_internal_zzegd3.zzbxa().iterator();
                        while (it.hasNext()) {
                            if (com_google_android_gms_internal_zzegd3.zzbsy().zzh((zzedk) ((Entry) it.next()).getKey()).zzi(zzbsy)) {
                                zzi = true;
                                break;
                            }
                        }
                        zzi = false;
                    }
                    if (zzi) {
                        z2 = z;
                        zzi = false;
                        size--;
                        isVisible = zzi;
                        z = z2;
                    }
                }
                if (com_google_android_gms_internal_zzegd2.zzbsy().zzi(com_google_android_gms_internal_zzegd3.zzbsy())) {
                    z2 = true;
                    zzi = isVisible;
                    size--;
                    isVisible = zzi;
                    z = z2;
                }
            }
            z2 = z;
            zzi = isVisible;
            size--;
            isVisible = zzi;
            z = z2;
        }
        if (!isVisible) {
            return false;
        }
        if (z) {
            this.zzmwx = zza(this.zzmwy, zzmxa, zzedk.zzbwe());
            if (this.zzmwy.size() > 0) {
                this.zzmwz = Long.valueOf(((zzegd) this.zzmwy.get(this.zzmwy.size() - 1)).zzbwy());
                return true;
            }
            this.zzmwz = Long.valueOf(-1);
            return true;
        } else if (com_google_android_gms_internal_zzegd2.zzbxb()) {
            this.zzmwx = this.zzmwx.zzd(com_google_android_gms_internal_zzegd2.zzbsy());
            return true;
        } else {
            Iterator it2 = com_google_android_gms_internal_zzegd2.zzbxa().iterator();
            while (it2.hasNext()) {
                this.zzmwx = this.zzmwx.zzd(com_google_android_gms_internal_zzegd2.zzbsy().zzh((zzedk) ((Entry) it2.next()).getKey()));
            }
            return true;
        }
    }

    public final List<zzegd> zzbxe() {
        List arrayList = new ArrayList(this.zzmwy);
        this.zzmwx = zzecy.zzbvq();
        this.zzmwy = new ArrayList();
        return arrayList;
    }

    public final zzekd zzj(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzeju zzcaf = zzeju.zzcaf();
        zzekd<zzekc> zzf = this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
        zzekd com_google_android_gms_internal_zzekd2;
        if (zzf == null) {
            zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzekd2 = zzcaf;
            for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
                com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzekd2.zze(com_google_android_gms_internal_zzekc.zzcao(), zzg.zzg(new zzedk(com_google_android_gms_internal_zzekc.zzcao())).zzb(com_google_android_gms_internal_zzekc.zzbsv()));
            }
            for (zzekc com_google_android_gms_internal_zzekc2 : zzg.zzbvs()) {
                com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzekd2.zze(com_google_android_gms_internal_zzekc2.zzcao(), com_google_android_gms_internal_zzekc2.zzbsv());
            }
            return com_google_android_gms_internal_zzekd2;
        } else if (zzf.zzbzu()) {
            return zzcaf;
        } else {
            com_google_android_gms_internal_zzekd2 = zzcaf;
            for (zzekc com_google_android_gms_internal_zzekc22 : zzf) {
                com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzekd2.zze(com_google_android_gms_internal_zzekc22.zzcao(), com_google_android_gms_internal_zzekc22.zzbsv());
            }
            return com_google_android_gms_internal_zzekd2;
        }
    }

    public final zzegj zzt(zzedk com_google_android_gms_internal_zzedk) {
        return new zzegj(com_google_android_gms_internal_zzedk, this);
    }

    public final zzekd zzu(zzedk com_google_android_gms_internal_zzedk) {
        return this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
    }
}
