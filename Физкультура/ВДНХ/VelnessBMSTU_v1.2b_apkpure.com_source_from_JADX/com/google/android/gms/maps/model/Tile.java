package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class Tile extends zzbfm {
    public static final Creator<Tile> CREATOR = new zzq();
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i, int i2, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 2, this.width);
        zzbfp.zzc(parcel, 3, this.height);
        zzbfp.zza(parcel, 4, this.data, false);
        zzbfp.zzai(parcel, zze);
    }
}
