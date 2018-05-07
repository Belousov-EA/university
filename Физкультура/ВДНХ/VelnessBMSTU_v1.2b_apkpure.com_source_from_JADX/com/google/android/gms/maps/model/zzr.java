package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzz;

final class zzr implements TileProvider {
    private final zzz zziwc = this.zziwd.zzivz;
    private /* synthetic */ TileOverlayOptions zziwd;

    zzr(TileOverlayOptions tileOverlayOptions) {
        this.zziwd = tileOverlayOptions;
    }

    public final Tile getTile(int i, int i2, int i3) {
        try {
            return this.zziwc.getTile(i, i2, i3);
        } catch (RemoteException e) {
            return null;
        }
    }
}
