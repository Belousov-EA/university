package com.google.firebase.database.connection.idl;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzt extends IInterface {
    void compareAndPut(List<String> list, IObjectWrapper iObjectWrapper, String str, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void initialize() throws RemoteException;

    void interrupt(String str) throws RemoteException;

    boolean isInterrupted(String str) throws RemoteException;

    void listen(List<String> list, IObjectWrapper iObjectWrapper, zzq com_google_firebase_database_connection_idl_zzq, long j, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void merge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void onDisconnectCancel(List<String> list, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void onDisconnectMerge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void onDisconnectPut(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void purgeOutstandingWrites() throws RemoteException;

    void put(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) throws RemoteException;

    void refreshAuthToken() throws RemoteException;

    void refreshAuthToken2(String str) throws RemoteException;

    void resume(String str) throws RemoteException;

    void setup(zzc com_google_firebase_database_connection_idl_zzc, zzk com_google_firebase_database_connection_idl_zzk, IObjectWrapper iObjectWrapper, zzw com_google_firebase_database_connection_idl_zzw) throws RemoteException;

    void shutdown() throws RemoteException;

    void unlisten(List<String> list, IObjectWrapper iObjectWrapper) throws RemoteException;
}
