package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public final class zzu extends zzeu implements zzs {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    public final int getFillColor() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List getHoles() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        List zzb = zzew.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List<LatLng> getPoints() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        List createTypedArrayList = zza.createTypedArrayList(LatLng.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final int getStrokeColor() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int getStrokeJointType() throws RemoteException {
        Parcel zza = zza(24, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List<PatternItem> getStrokePattern() throws RemoteException {
        Parcel zza = zza(26, zzbe());
        List createTypedArrayList = zza.createTypedArrayList(PatternItem.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final float getStrokeWidth() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final IObjectWrapper getTag() throws RemoteException {
        Parcel zza = zza(28, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(14, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(20, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(22, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isGeodesic() throws RemoteException {
        Parcel zza = zza(18, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(16, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zzbe());
    }

    public final void setClickable(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(21, zzbe);
    }

    public final void setFillColor(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(11, zzbe);
    }

    public final void setGeodesic(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(17, zzbe);
    }

    public final void setHoles(List list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeList(list);
        zzb(5, zzbe);
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeTypedList(list);
        zzb(3, zzbe);
    }

    public final void setStrokeColor(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(9, zzbe);
    }

    public final void setStrokeJointType(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(23, zzbe);
    }

    public final void setStrokePattern(List<PatternItem> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeTypedList(list);
        zzb(25, zzbe);
    }

    public final void setStrokeWidth(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(7, zzbe);
    }

    public final void setTag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(27, zzbe);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(15, zzbe);
    }

    public final void setZIndex(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(13, zzbe);
    }

    public final boolean zzb(zzs com_google_android_gms_maps_model_internal_zzs) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzs);
        zzbe = zza(19, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }
}
