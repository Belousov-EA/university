package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzn;

public final class zzcdz extends zzbfm {
    public static final Creator<zzcdz> CREATOR = new zzcea();
    private int zzikz;
    private zzcdx zzila;
    private zzm zzilb;
    private zzceu zzilc;

    zzcdz(int i, zzcdx com_google_android_gms_internal_zzcdx, IBinder iBinder, IBinder iBinder2) {
        zzceu com_google_android_gms_internal_zzceu = null;
        this.zzikz = i;
        this.zzila = com_google_android_gms_internal_zzcdx;
        this.zzilb = iBinder == null ? null : zzn.zzbc(iBinder);
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            com_google_android_gms_internal_zzceu = queryLocalInterface instanceof zzceu ? (zzceu) queryLocalInterface : new zzcew(iBinder2);
        }
        this.zzilc = com_google_android_gms_internal_zzceu;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder = null;
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzikz);
        zzbfp.zza(parcel, 2, this.zzila, i, false);
        zzbfp.zza(parcel, 3, this.zzilb == null ? null : this.zzilb.asBinder(), false);
        if (this.zzilc != null) {
            iBinder = this.zzilc.asBinder();
        }
        zzbfp.zza(parcel, 4, iBinder, false);
        zzbfp.zzai(parcel, zze);
    }
}
