package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzcfs;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends zzbfm {
    public static final Creator<GeofencingRequest> CREATOR = new zzl();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final String mTag;
    private final List<zzcfs> zzijj;
    private final int zzijk;

    public static final class Builder {
        private String mTag = "";
        private final List<zzcfs> zzijj = new ArrayList();
        private int zzijk = 5;

        public final Builder addGeofence(Geofence geofence) {
            zzbq.checkNotNull(geofence, "geofence can't be null.");
            zzbq.checkArgument(geofence instanceof zzcfs, "Geofence must be created using Geofence.Builder.");
            this.zzijj.add((zzcfs) geofence);
            return this;
        }

        public final Builder addGeofences(List<Geofence> list) {
            if (!(list == null || list.isEmpty())) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest build() {
            zzbq.checkArgument(!this.zzijj.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzijj, this.zzijk, this.mTag);
        }

        public final Builder setInitialTrigger(int i) {
            this.zzijk = i & 7;
            return this;
        }
    }

    GeofencingRequest(List<zzcfs> list, int i, String str) {
        this.zzijj = list;
        this.zzijk = i;
        this.mTag = str;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.zzijj);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzijk;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeofencingRequest[");
        stringBuilder.append("geofences=");
        stringBuilder.append(this.zzijj);
        stringBuilder.append(", initialTrigger=" + this.zzijk + ", ");
        String str = "tag=";
        String valueOf = String.valueOf(this.mTag);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzijj, false);
        zzbfp.zzc(parcel, 2, getInitialTrigger());
        zzbfp.zza(parcel, 3, this.mTag, false);
        zzbfp.zzai(parcel, zze);
    }
}
