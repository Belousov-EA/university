package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzb implements Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        long j2 = 0;
        List list = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    list = zzbfn.zzc(parcel, readInt, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new ActivityRecognitionResult(list, j2, j, i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
