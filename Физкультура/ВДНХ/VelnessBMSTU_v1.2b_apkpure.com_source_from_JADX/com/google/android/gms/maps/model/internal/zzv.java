package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;

public final class zzv extends zzeu implements IPolylineDelegate {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    public final boolean equalsRemote(IPolylineDelegate iPolylineDelegate) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iPolylineDelegate);
        zzbe = zza(15, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }

    public final int getColor() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final Cap getEndCap() throws RemoteException {
        Parcel zza = zza(22, zzbe());
        Cap cap = (Cap) zzew.zza(zza, Cap.CREATOR);
        zza.recycle();
        return cap;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final int getJointType() throws RemoteException {
        Parcel zza = zza(24, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List<PatternItem> getPattern() throws RemoteException {
        Parcel zza = zza(26, zzbe());
        List createTypedArrayList = zza.createTypedArrayList(PatternItem.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<LatLng> getPoints() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        List createTypedArrayList = zza.createTypedArrayList(LatLng.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final Cap getStartCap() throws RemoteException {
        Parcel zza = zza(20, zzbe());
        Cap cap = (Cap) zzew.zza(zza, Cap.CREATOR);
        zza.recycle();
        return cap;
    }

    public final IObjectWrapper getTag() throws RemoteException {
        Parcel zza = zza(28, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final float getWidth() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(16, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(18, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isGeodesic() throws RemoteException {
        Parcel zza = zza(14, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(12, zzbe());
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
        zzb(17, zzbe);
    }

    public final void setColor(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(7, zzbe);
    }

    public final void setEndCap(Cap cap) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) cap);
        zzb(21, zzbe);
    }

    public final void setGeodesic(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(13, zzbe);
    }

    public final void setJointType(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(23, zzbe);
    }

    public final void setPattern(List<PatternItem> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeTypedList(list);
        zzb(25, zzbe);
    }

    public final void setPoints(List<LatLng> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeTypedList(list);
        zzb(3, zzbe);
    }

    public final void setStartCap(Cap cap) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) cap);
        zzb(19, zzbe);
    }

    public final void setTag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(27, zzbe);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(11, zzbe);
    }

    public final void setWidth(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(5, zzbe);
    }

    public final void setZIndex(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(9, zzbe);
    }
}
