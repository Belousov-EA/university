package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import java.util.List;

public final class zzy extends zzeu implements zzw {
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
    }

    public final void onDisconnect() throws RemoteException {
        zzb(4, zzbe());
    }

    public final void zza(List<String> list, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, z);
        zzbe.writeLong(j);
        zzb(1, zzbe);
    }

    public final void zza(List<String> list, List<zzak> list2, IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzbe.writeTypedList(list2);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzbe.writeLong(j);
        zzb(2, zzbe);
    }

    public final void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(6, zzbe);
    }

    public final void zzbuk() throws RemoteException {
        zzb(3, zzbe());
    }

    public final void zzcl(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(5, zzbe);
    }
}
