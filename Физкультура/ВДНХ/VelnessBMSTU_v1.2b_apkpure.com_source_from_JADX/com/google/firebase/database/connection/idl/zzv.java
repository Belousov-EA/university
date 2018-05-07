package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import java.util.List;

public final class zzv extends zzeu implements zzt {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IPersistentConnection");
    }

    public final void compareAndPut(List<String> list, IObjectWrapper iObjectWrapper, String str, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(9, zzbe);
    }

    public final void initialize() throws RemoteException {
        zzb(2, zzbe());
    }

    public final void interrupt(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(14, zzbe);
    }

    public final boolean isInterrupted(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe = zza(16, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }

    public final void listen(List<String> list, IObjectWrapper iObjectWrapper, zzq com_google_firebase_database_connection_idl_zzq, long j, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzq);
        zzbe.writeLong(j);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(5, zzbe);
    }

    public final void merge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(10, zzbe);
    }

    public final void onDisconnectCancel(List<String> list, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(13, zzbe);
    }

    public final void onDisconnectMerge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(12, zzbe);
    }

    public final void onDisconnectPut(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(11, zzbe);
    }

    public final void purgeOutstandingWrites() throws RemoteException {
        zzb(7, zzbe());
    }

    public final void put(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzah);
        zzb(8, zzbe);
    }

    public final void refreshAuthToken() throws RemoteException {
        zzb(4, zzbe());
    }

    public final void refreshAuthToken2(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(17, zzbe);
    }

    public final void resume(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(15, zzbe);
    }

    public final void setup(zzc com_google_firebase_database_connection_idl_zzc, zzk com_google_firebase_database_connection_idl_zzk, IObjectWrapper iObjectWrapper, zzw com_google_firebase_database_connection_idl_zzw) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) com_google_firebase_database_connection_idl_zzc);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzk);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzw);
        zzb(1, zzbe);
    }

    public final void shutdown() throws RemoteException {
        zzb(3, zzbe());
    }

    public final void unlisten(List<String> list, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeStringList(list);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(6, zzbe);
    }
}
