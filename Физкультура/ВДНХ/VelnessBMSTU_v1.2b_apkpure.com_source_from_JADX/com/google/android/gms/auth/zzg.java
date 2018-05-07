package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzey;
import java.io.IOException;
import java.util.List;

final class zzg implements zzj<List<AccountChangeEvent>> {
    private /* synthetic */ String zzecg;
    private /* synthetic */ int zzech;

    zzg(String str, int i) {
        this.zzecg = str;
        this.zzech = i;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        return ((AccountChangeEventsResponse) zzd.zzp(zzey.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(this.zzecg).setEventIndex(this.zzech)))).getEvents();
    }
}
