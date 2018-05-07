package com.google.android.gms.common.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzcb extends zzev implements zzca {
    public zzcb() {
        attachInterface(this, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzn((Status) zzew.zza(parcel, Status.CREATOR));
        return true;
    }
}
