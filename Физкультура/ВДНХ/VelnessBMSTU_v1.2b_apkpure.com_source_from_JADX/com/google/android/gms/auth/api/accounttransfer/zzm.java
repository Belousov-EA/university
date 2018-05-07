package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzm extends zzaxc {
    public static final Creator<zzm> CREATOR = new zzn();
    private static final HashMap<String, zzbgo<?, ?>> zzeea;
    private int zzeck;
    private Set<Integer> zzeeb;
    private ArrayList<zzs> zzeec;
    private int zzeed;
    private zzp zzeee;

    static {
        HashMap hashMap = new HashMap();
        zzeea = hashMap;
        hashMap.put("authenticatorData", zzbgo.zzb("authenticatorData", 2, zzs.class));
        zzeea.put("progress", zzbgo.zza("progress", 4, zzp.class));
    }

    public zzm() {
        this.zzeeb = new HashSet(1);
        this.zzeck = 1;
    }

    zzm(Set<Integer> set, int i, ArrayList<zzs> arrayList, int i2, zzp com_google_android_gms_auth_api_accounttransfer_zzp) {
        this.zzeeb = set;
        this.zzeck = i;
        this.zzeec = arrayList;
        this.zzeed = i2;
        this.zzeee = com_google_android_gms_auth_api_accounttransfer_zzp;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        Set set = this.zzeeb;
        if (set.contains(Integer.valueOf(1))) {
            zzbfp.zzc(parcel, 1, this.zzeck);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbfp.zzc(parcel, 2, this.zzeec, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbfp.zzc(parcel, 3, this.zzeed);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbfp.zza(parcel, 4, this.zzeee, i, true);
        }
        zzbfp.zzai(parcel, zze);
    }

    protected final boolean zza(zzbgo com_google_android_gms_internal_zzbgo) {
        return this.zzeeb.contains(Integer.valueOf(com_google_android_gms_internal_zzbgo.zzalu()));
    }

    public final /* synthetic */ Map zzaav() {
        return zzeea;
    }

    protected final Object zzb(zzbgo com_google_android_gms_internal_zzbgo) {
        switch (com_google_android_gms_internal_zzbgo.zzalu()) {
            case 1:
                return Integer.valueOf(this.zzeck);
            case 2:
                return this.zzeec;
            case 4:
                return this.zzeee;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + com_google_android_gms_internal_zzbgo.zzalu());
        }
    }
}
