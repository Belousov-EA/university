package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzd implements Creator<GroundOverlayOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                case 3:
                    latLng = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 4:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 5:
                    f2 = zzbfn.zzl(parcel, readInt);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.zza(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = zzbfn.zzl(parcel, readInt);
                    break;
                case 8:
                    f4 = zzbfn.zzl(parcel, readInt);
                    break;
                case 9:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 10:
                    f5 = zzbfn.zzl(parcel, readInt);
                    break;
                case 11:
                    f6 = zzbfn.zzl(parcel, readInt);
                    break;
                case 12:
                    f7 = zzbfn.zzl(parcel, readInt);
                    break;
                case 13:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new GroundOverlayOptions(iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
