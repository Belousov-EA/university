package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import java.util.List;

public abstract class zzu extends zzev implements zzt {
    public zzu() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnection");
    }

    public static zzt asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
        return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzv(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzah com_google_firebase_database_connection_idl_zzah = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        IBinder readStrongBinder;
        IBinder readStrongBinder2;
        List createStringArrayList;
        IObjectWrapper zzaq;
        IInterface queryLocalInterface;
        IBinder readStrongBinder3;
        switch (i) {
            case 1:
                zzk com_google_firebase_database_connection_idl_zzk;
                IInterface queryLocalInterface2;
                zzw com_google_firebase_database_connection_idl_zzy;
                zzc com_google_firebase_database_connection_idl_zzc = (zzc) zzew.zza(parcel, zzc.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    com_google_firebase_database_connection_idl_zzk = null;
                } else {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
                    if (queryLocalInterface2 instanceof zzk) {
                        com_google_firebase_database_connection_idl_zzk = (zzk) queryLocalInterface2;
                    } else {
                        Object com_google_firebase_database_connection_idl_zzm = new zzm(readStrongBinder);
                    }
                }
                IObjectWrapper zzaq2 = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
                    com_google_firebase_database_connection_idl_zzy = queryLocalInterface2 instanceof zzw ? (zzw) queryLocalInterface2 : new zzy(readStrongBinder2);
                }
                setup(com_google_firebase_database_connection_idl_zzc, com_google_firebase_database_connection_idl_zzk, zzaq2, com_google_firebase_database_connection_idl_zzy);
                parcel2.writeNoException();
                break;
            case 2:
                initialize();
                parcel2.writeNoException();
                break;
            case 3:
                shutdown();
                parcel2.writeNoException();
                break;
            case 4:
                refreshAuthToken();
                parcel2.writeNoException();
                break;
            case 5:
                zzq com_google_firebase_database_connection_idl_zzq;
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 == null) {
                    com_google_firebase_database_connection_idl_zzq = null;
                } else {
                    queryLocalInterface = readStrongBinder2.queryLocalInterface("com.google.firebase.database.connection.idl.IListenHashProvider");
                    com_google_firebase_database_connection_idl_zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzs(readStrongBinder2);
                }
                long readLong = parcel.readLong();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    queryLocalInterface = readStrongBinder4.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder4);
                }
                listen(createStringArrayList, zzaq, com_google_firebase_database_connection_idl_zzq, readLong, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 6:
                unlisten(parcel.createStringArrayList(), zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                purgeOutstandingWrites();
                parcel2.writeNoException();
                break;
            case 8:
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder3);
                }
                put(createStringArrayList, zzaq, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 9:
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                String readString = parcel.readString();
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface = readStrongBinder2.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder2);
                }
                compareAndPut(createStringArrayList, zzaq, readString, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 10:
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder3);
                }
                merge(createStringArrayList, zzaq, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 11:
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder3);
                }
                onDisconnectPut(createStringArrayList, zzaq, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 12:
                createStringArrayList = parcel.createStringArrayList();
                zzaq = zza.zzaq(parcel.readStrongBinder());
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder3);
                }
                onDisconnectMerge(createStringArrayList, zzaq, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 13:
                createStringArrayList = parcel.createStringArrayList();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IRequestResultCallback");
                    com_google_firebase_database_connection_idl_zzah = queryLocalInterface instanceof zzah ? (zzah) queryLocalInterface : new zzaj(readStrongBinder);
                }
                onDisconnectCancel(createStringArrayList, com_google_firebase_database_connection_idl_zzah);
                parcel2.writeNoException();
                break;
            case 14:
                interrupt(parcel.readString());
                parcel2.writeNoException();
                break;
            case 15:
                resume(parcel.readString());
                parcel2.writeNoException();
                break;
            case 16:
                boolean isInterrupted = isInterrupted(parcel.readString());
                parcel2.writeNoException();
                zzew.zza(parcel2, isInterrupted);
                break;
            case 17:
                refreshAuthToken2(parcel.readString());
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
