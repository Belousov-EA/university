package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzs;
import java.util.HashMap;
import java.util.Map;

public final class zzcfd {
    private final Context mContext;
    private final zzcfu<zzcez> zzikt;
    private ContentProviderClient zzilm = null;
    private boolean zziln = false;
    private final Map<zzck<LocationListener>, zzcfi> zzilo = new HashMap();
    private final Map<zzck<Object>, zzcfh> zzilp = new HashMap();
    private final Map<zzck<LocationCallback>, zzcfe> zzilq = new HashMap();

    public zzcfd(Context context, zzcfu<zzcez> com_google_android_gms_internal_zzcfu_com_google_android_gms_internal_zzcez) {
        this.mContext = context;
        this.zzikt = com_google_android_gms_internal_zzcfu_com_google_android_gms_internal_zzcez;
    }

    private final zzcfi zzm(zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener) {
        zzcfi com_google_android_gms_internal_zzcfi;
        synchronized (this.zzilo) {
            com_google_android_gms_internal_zzcfi = (zzcfi) this.zzilo.get(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener.zzajo());
            if (com_google_android_gms_internal_zzcfi == null) {
                com_google_android_gms_internal_zzcfi = new zzcfi(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener);
            }
            this.zzilo.put(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener.zzajo(), com_google_android_gms_internal_zzcfi);
        }
        return com_google_android_gms_internal_zzcfi;
    }

    private final zzcfe zzn(zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback) {
        zzcfe com_google_android_gms_internal_zzcfe;
        synchronized (this.zzilq) {
            com_google_android_gms_internal_zzcfe = (zzcfe) this.zzilq.get(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback.zzajo());
            if (com_google_android_gms_internal_zzcfe == null) {
                com_google_android_gms_internal_zzcfe = new zzcfe(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback);
            }
            this.zzilq.put(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback.zzajo(), com_google_android_gms_internal_zzcfe);
        }
        return com_google_android_gms_internal_zzcfe;
    }

    public final Location getLastLocation() throws RemoteException {
        this.zzikt.zzakm();
        return ((zzcez) this.zzikt.zzakn()).zzif(this.mContext.getPackageName());
    }

    public final void removeAllListeners() throws RemoteException {
        synchronized (this.zzilo) {
            for (zzs com_google_android_gms_location_zzs : this.zzilo.values()) {
                if (com_google_android_gms_location_zzs != null) {
                    ((zzcez) this.zzikt.zzakn()).zza(zzcfq.zza(com_google_android_gms_location_zzs, null));
                }
            }
            this.zzilo.clear();
        }
        synchronized (this.zzilq) {
            for (zzp com_google_android_gms_location_zzp : this.zzilq.values()) {
                if (com_google_android_gms_location_zzp != null) {
                    ((zzcez) this.zzikt.zzakn()).zza(zzcfq.zza(com_google_android_gms_location_zzp, null));
                }
            }
            this.zzilq.clear();
        }
        synchronized (this.zzilp) {
            for (zzcfh com_google_android_gms_internal_zzcfh : this.zzilp.values()) {
                if (com_google_android_gms_internal_zzcfh != null) {
                    ((zzcez) this.zzikt.zzakn()).zza(new zzcdz(2, null, com_google_android_gms_internal_zzcfh.asBinder(), null));
                }
            }
            this.zzilp.clear();
        }
    }

    public final void zza(PendingIntent pendingIntent, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zza(new zzcfq(2, null, null, pendingIntent, null, com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null));
    }

    public final void zza(zzck<LocationListener> com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationListener, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationListener, "Invalid null listener key");
        synchronized (this.zzilo) {
            zzs com_google_android_gms_location_zzs = (zzcfi) this.zzilo.remove(com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationListener);
            if (com_google_android_gms_location_zzs != null) {
                com_google_android_gms_location_zzs.release();
                ((zzcez) this.zzikt.zzakn()).zza(zzcfq.zza(com_google_android_gms_location_zzs, com_google_android_gms_internal_zzceu));
            }
        }
    }

    public final void zza(zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zza(com_google_android_gms_internal_zzceu);
    }

    public final void zza(zzcfo com_google_android_gms_internal_zzcfo, zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zza(new zzcfq(1, com_google_android_gms_internal_zzcfo, null, null, zzn(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback).asBinder(), com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zza(new zzcfq(1, zzcfo.zza(locationRequest), null, pendingIntent, null, com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null));
    }

    public final void zza(LocationRequest locationRequest, zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zza(new zzcfq(1, zzcfo.zza(locationRequest), zzm(com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener).asBinder(), null, null, com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null));
    }

    public final LocationAvailability zzavk() throws RemoteException {
        this.zzikt.zzakm();
        return ((zzcez) this.zzikt.zzakn()).zzig(this.mContext.getPackageName());
    }

    public final void zzavl() throws RemoteException {
        if (this.zziln) {
            zzbj(false);
        }
    }

    public final void zzb(zzck<LocationCallback> com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationCallback, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzikt.zzakm();
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationCallback, "Invalid null listener key");
        synchronized (this.zzilq) {
            zzp com_google_android_gms_location_zzp = (zzcfe) this.zzilq.remove(com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationCallback);
            if (com_google_android_gms_location_zzp != null) {
                com_google_android_gms_location_zzp.release();
                ((zzcez) this.zzikt.zzakn()).zza(zzcfq.zza(com_google_android_gms_location_zzp, com_google_android_gms_internal_zzceu));
            }
        }
    }

    public final void zzbj(boolean z) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zzbj(z);
        this.zziln = z;
    }

    public final void zzc(Location location) throws RemoteException {
        this.zzikt.zzakm();
        ((zzcez) this.zzikt.zzakn()).zzc(location);
    }
}
