package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzbe extends zzeu implements zzbd {
    zzbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, zzbv com_google_android_gms_common_internal_zzbv) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_common_internal_zzbv);
        zzbe = zza(2, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }
}
