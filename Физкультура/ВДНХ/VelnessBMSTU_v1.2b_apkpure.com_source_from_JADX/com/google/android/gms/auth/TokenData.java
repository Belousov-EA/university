package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

public class TokenData extends zzbfm implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR = new zzk();
    private int zzeck;
    private final String zzecl;
    private final Long zzecm;
    private final boolean zzecn;
    private final boolean zzeco;
    private final List<String> zzecp;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.zzeck = i;
        this.zzecl = zzbq.zzgm(str);
        this.zzecm = l;
        this.zzecn = z;
        this.zzeco = z2;
        this.zzecp = list;
    }

    @Nullable
    public static TokenData zzd(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzecl, tokenData.zzecl) && zzbg.equal(this.zzecm, tokenData.zzecm) && this.zzecn == tokenData.zzecn && this.zzeco == tokenData.zzeco && zzbg.equal(this.zzecp, tokenData.zzecp);
    }

    public final String getToken() {
        return this.zzecl;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzecl, this.zzecm, Boolean.valueOf(this.zzecn), Boolean.valueOf(this.zzeco), this.zzecp});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.zzecl, false);
        zzbfp.zza(parcel, 3, this.zzecm, false);
        zzbfp.zza(parcel, 4, this.zzecn);
        zzbfp.zza(parcel, 5, this.zzeco);
        zzbfp.zzb(parcel, 6, this.zzecp, false);
        zzbfp.zzai(parcel, zze);
    }
}
