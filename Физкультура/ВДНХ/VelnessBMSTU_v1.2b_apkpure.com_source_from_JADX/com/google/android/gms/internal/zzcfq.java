package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzq;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

public final class zzcfq extends zzbfm {
    public static final Creator<zzcfq> CREATOR = new zzcfr();
    private PendingIntent zzeeo;
    private int zzikz;
    private zzceu zzilc;
    private zzcfo zzima;
    private zzs zzimb;
    private zzp zzimc;

    zzcfq(int i, zzcfo com_google_android_gms_internal_zzcfo, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzceu com_google_android_gms_internal_zzceu = null;
        this.zzikz = i;
        this.zzima = com_google_android_gms_internal_zzcfo;
        this.zzimb = iBinder == null ? null : zzt.zzbe(iBinder);
        this.zzeeo = pendingIntent;
        this.zzimc = iBinder2 == null ? null : zzq.zzbd(iBinder2);
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            com_google_android_gms_internal_zzceu = queryLocalInterface instanceof zzceu ? (zzceu) queryLocalInterface : new zzcew(iBinder3);
        }
        this.zzilc = com_google_android_gms_internal_zzceu;
    }

    public static zzcfq zza(zzp com_google_android_gms_location_zzp, @Nullable zzceu com_google_android_gms_internal_zzceu) {
        return new zzcfq(2, null, null, null, com_google_android_gms_location_zzp.asBinder(), com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null);
    }

    public static zzcfq zza(zzs com_google_android_gms_location_zzs, @Nullable zzceu com_google_android_gms_internal_zzceu) {
        return new zzcfq(2, null, com_google_android_gms_location_zzs.asBinder(), null, null, com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder = null;
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzikz);
        zzbfp.zza(parcel, 2, this.zzima, i, false);
        zzbfp.zza(parcel, 3, this.zzimb == null ? null : this.zzimb.asBinder(), false);
        zzbfp.zza(parcel, 4, this.zzeeo, i, false);
        zzbfp.zza(parcel, 5, this.zzimc == null ? null : this.zzimc.asBinder(), false);
        if (this.zzilc != null) {
            iBinder = this.zzilc.asBinder();
        }
        zzbfp.zza(parcel, 6, iBinder, false);
        zzbfp.zzai(parcel, zze);
    }
}
