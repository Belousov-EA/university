package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.List;
import java.util.Map;

public class zzp extends zzaxc {
    public static final Creator<zzp> CREATOR = new zzq();
    private static final ArrayMap<String, zzbgo<?, ?>> zzeef;
    private int zzeck;
    private List<String> zzeeg;
    private List<String> zzeeh;
    private List<String> zzeei;
    private List<String> zzeej;
    private List<String> zzeek;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzeef = arrayMap;
        arrayMap.put("registered", zzbgo.zzm("registered", 2));
        zzeef.put("in_progress", zzbgo.zzm("in_progress", 3));
        zzeef.put("success", zzbgo.zzm("success", 4));
        zzeef.put("failed", zzbgo.zzm("failed", 5));
        zzeef.put("escrowed", zzbgo.zzm("escrowed", 6));
    }

    public zzp() {
        this.zzeck = 1;
    }

    zzp(int i, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable List<String> list5) {
        this.zzeck = i;
        this.zzeeg = list;
        this.zzeeh = list2;
        this.zzeei = list3;
        this.zzeej = list4;
        this.zzeek = list5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zzb(parcel, 2, this.zzeeg, false);
        zzbfp.zzb(parcel, 3, this.zzeeh, false);
        zzbfp.zzb(parcel, 4, this.zzeei, false);
        zzbfp.zzb(parcel, 5, this.zzeej, false);
        zzbfp.zzb(parcel, 6, this.zzeek, false);
        zzbfp.zzai(parcel, zze);
    }

    protected final boolean zza(zzbgo com_google_android_gms_internal_zzbgo) {
        return true;
    }

    public final Map<String, zzbgo<?, ?>> zzaav() {
        return zzeef;
    }

    protected final Object zzb(zzbgo com_google_android_gms_internal_zzbgo) {
        switch (com_google_android_gms_internal_zzbgo.zzalu()) {
            case 1:
                return Integer.valueOf(this.zzeck);
            case 2:
                return this.zzeeg;
            case 3:
                return this.zzeeh;
            case 4:
                return this.zzeei;
            case 5:
                return this.zzeej;
            case 6:
                return this.zzeek;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + com_google_android_gms_internal_zzbgo.zzalu());
        }
    }
}
