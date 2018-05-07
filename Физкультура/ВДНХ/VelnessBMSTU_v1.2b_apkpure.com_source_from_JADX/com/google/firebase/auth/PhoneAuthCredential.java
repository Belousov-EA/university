package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;

public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Creator<PhoneAuthCredential> CREATOR = new zzr();
    private String zzimi;
    private String zzmdq;
    private String zzmdr;
    private boolean zzmds;
    private boolean zzmdt;
    private String zzmdu;

    PhoneAuthCredential(@Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, boolean z2, @Nullable String str4) {
        boolean z3 = (z && !TextUtils.isEmpty(str3)) || !((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)));
        zzbq.checkArgument(z3, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, ortemprary proof.");
        this.zzmdq = str;
        this.zzmdr = str2;
        this.zzmds = z;
        this.zzimi = str3;
        this.zzmdt = z2;
        this.zzmdu = str4;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new PhoneAuthCredential(this.zzmdq, getSmsCode(), this.zzmds, this.zzimi, this.zzmdt, this.zzmdu);
    }

    @NonNull
    public String getProvider() {
        return "phone";
    }

    @Nullable
    public String getSmsCode() {
        return this.zzmdr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzmdq, false);
        zzbfp.zza(parcel, 2, getSmsCode(), false);
        zzbfp.zza(parcel, 3, this.zzmds);
        zzbfp.zza(parcel, 4, this.zzimi, false);
        zzbfp.zza(parcel, 5, this.zzmdt);
        zzbfp.zza(parcel, 6, this.zzmdu, false);
        zzbfp.zzai(parcel, zze);
    }

    public final PhoneAuthCredential zzcg(boolean z) {
        this.zzmdt = false;
        return this;
    }
}
