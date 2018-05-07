package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.internal.zzam;

final class zzk extends zzam {
    private /* synthetic */ OnMapLoadedCallback zzirk;

    zzk(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
        this.zzirk = onMapLoadedCallback;
    }

    public final void onMapLoaded() throws RemoteException {
        this.zzirk.onMapLoaded();
    }
}
