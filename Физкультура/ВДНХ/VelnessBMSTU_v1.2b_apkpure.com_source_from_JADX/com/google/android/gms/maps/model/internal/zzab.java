package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.Tile;

public final class zzab extends zzeu implements zzz {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public final Tile getTile(int i, int i2, int i3) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzbe.writeInt(i2);
        zzbe.writeInt(i3);
        Parcel zza = zza(1, zzbe);
        Tile tile = (Tile) zzew.zza(zza, Tile.CREATOR);
        zza.recycle();
        return tile;
    }
}
