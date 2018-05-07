package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzejw implements Iterable<zzekc> {
    private static final zzeal<zzekc> zzncp = new zzeal(Collections.emptyList(), null);
    private final zzejv zznaa;
    private final zzekd zzncq;
    private zzeal<zzekc> zzncr;

    private zzejw(zzekd com_google_android_gms_internal_zzekd, zzejv com_google_android_gms_internal_zzejv) {
        this.zznaa = com_google_android_gms_internal_zzejv;
        this.zzncq = com_google_android_gms_internal_zzekd;
        this.zzncr = null;
    }

    private zzejw(zzekd com_google_android_gms_internal_zzekd, zzejv com_google_android_gms_internal_zzejv, zzeal<zzekc> com_google_android_gms_internal_zzeal_com_google_android_gms_internal_zzekc) {
        this.zznaa = com_google_android_gms_internal_zzejv;
        this.zzncq = com_google_android_gms_internal_zzekd;
        this.zzncr = com_google_android_gms_internal_zzeal_com_google_android_gms_internal_zzekc;
    }

    public static zzejw zza(zzekd com_google_android_gms_internal_zzekd, zzejv com_google_android_gms_internal_zzejv) {
        return new zzejw(com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzejv);
    }

    private final void zzcai() {
        if (this.zzncr == null) {
            if (!this.zznaa.equals(zzejx.zzcal())) {
                List arrayList = new ArrayList();
                Object obj = null;
                for (zzekc com_google_android_gms_internal_zzekc : this.zzncq) {
                    obj = (obj != null || this.zznaa.zzi(com_google_android_gms_internal_zzekc.zzbsv())) ? 1 : null;
                    arrayList.add(new zzekc(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv()));
                }
                if (obj != null) {
                    this.zzncr = new zzeal(arrayList, this.zznaa);
                    return;
                }
            }
            this.zzncr = zzncp;
        }
    }

    public static zzejw zzj(zzekd com_google_android_gms_internal_zzekd) {
        return new zzejw(com_google_android_gms_internal_zzekd, zzeki.zzcap());
    }

    public final Iterator<zzekc> iterator() {
        zzcai();
        return this.zzncr == zzncp ? this.zzncq.iterator() : this.zzncr.iterator();
    }

    public final zzejg zza(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzejv com_google_android_gms_internal_zzejv) {
        if (this.zznaa.equals(zzejx.zzcal()) || this.zznaa.equals(com_google_android_gms_internal_zzejv)) {
            zzcai();
            if (this.zzncr == zzncp) {
                return this.zzncq.zzl(com_google_android_gms_internal_zzejg);
            }
            zzekc com_google_android_gms_internal_zzekc = (zzekc) this.zzncr.zzbn(new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd));
            return com_google_android_gms_internal_zzekc != null ? com_google_android_gms_internal_zzekc.zzcao() : null;
        } else {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
    }

    public final zzekd zzbsv() {
        return this.zzncq;
    }

    public final Iterator<zzekc> zzbti() {
        zzcai();
        return this.zzncr == zzncp ? this.zzncq.zzbti() : this.zzncr.zzbti();
    }

    public final zzekc zzcaj() {
        if (!(this.zzncq instanceof zzeji)) {
            return null;
        }
        zzcai();
        if (this.zzncr != zzncp) {
            return (zzekc) this.zzncr.zzbtk();
        }
        zzejg zzbzw = ((zzeji) this.zzncq).zzbzw();
        return new zzekc(zzbzw, this.zzncq.zzm(zzbzw));
    }

    public final zzekc zzcak() {
        if (!(this.zzncq instanceof zzeji)) {
            return null;
        }
        zzcai();
        if (this.zzncr != zzncp) {
            return (zzekc) this.zzncr.zzbtl();
        }
        zzejg zzbzx = ((zzeji) this.zzncq).zzbzx();
        return new zzekc(zzbzx, this.zzncq.zzm(zzbzx));
    }

    public final zzejw zzg(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        zzekd zze = this.zzncq.zze(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
        if (this.zzncr == zzncp && !this.zznaa.zzi(com_google_android_gms_internal_zzekd)) {
            return new zzejw(zze, this.zznaa, zzncp);
        }
        if (this.zzncr == null || this.zzncr == zzncp) {
            return new zzejw(zze, this.zznaa, null);
        }
        zzeal zzbl = this.zzncr.zzbl(new zzekc(com_google_android_gms_internal_zzejg, this.zzncq.zzm(com_google_android_gms_internal_zzejg)));
        if (!com_google_android_gms_internal_zzekd.isEmpty()) {
            zzbl = zzbl.zzbm(new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd));
        }
        return new zzejw(zze, this.zznaa, zzbl);
    }

    public final zzejw zzk(zzekd com_google_android_gms_internal_zzekd) {
        return new zzejw(this.zzncq.zzf(com_google_android_gms_internal_zzekd), this.zznaa, this.zzncr);
    }
}
