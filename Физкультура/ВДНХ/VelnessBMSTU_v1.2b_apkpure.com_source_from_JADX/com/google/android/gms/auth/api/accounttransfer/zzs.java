package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class zzs extends zzaxc {
    public static final Creator<zzs> CREATOR = new zzt();
    private static final HashMap<String, zzbgo<?, ?>> zzeea;
    private String mPackageName;
    private String zzaym;
    private int zzeck;
    private Set<Integer> zzeeb;
    private zzu zzeel;

    static {
        HashMap hashMap = new HashMap();
        zzeea = hashMap;
        hashMap.put("authenticatorInfo", zzbgo.zza("authenticatorInfo", 2, zzu.class));
        zzeea.put("signature", zzbgo.zzl("signature", 3));
        zzeea.put("package", zzbgo.zzl("package", 4));
    }

    public zzs() {
        this.zzeeb = new HashSet(3);
        this.zzeck = 1;
    }

    zzs(Set<Integer> set, int i, zzu com_google_android_gms_auth_api_accounttransfer_zzu, String str, String str2) {
        this.zzeeb = set;
        this.zzeck = i;
        this.zzeel = com_google_android_gms_auth_api_accounttransfer_zzu;
        this.zzaym = str;
        this.mPackageName = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        Set set = this.zzeeb;
        if (set.contains(Integer.valueOf(1))) {
            zzbfp.zzc(parcel, 1, this.zzeck);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbfp.zza(parcel, 2, this.zzeel, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbfp.zza(parcel, 3, this.zzaym, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbfp.zza(parcel, 4, this.mPackageName, true);
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
                return this.zzeel;
            case 3:
                return this.zzaym;
            case 4:
                return this.mPackageName;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + com_google_android_gms_internal_zzbgo.zzalu());
        }
    }
}
