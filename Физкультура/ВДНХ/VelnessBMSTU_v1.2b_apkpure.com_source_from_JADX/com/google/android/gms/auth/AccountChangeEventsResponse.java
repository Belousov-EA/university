package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

public class AccountChangeEventsResponse extends zzbfm {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
    private int mVersion;
    private List<AccountChangeEvent> zzapa;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.mVersion = i;
        this.zzapa = (List) zzbq.checkNotNull(list);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> list) {
        this.mVersion = 1;
        this.zzapa = (List) zzbq.checkNotNull(list);
    }

    public List<AccountChangeEvent> getEvents() {
        return this.zzapa;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.mVersion);
        zzbfp.zzc(parcel, 2, this.zzapa, false);
        zzbfp.zzai(parcel, zze);
    }
}
