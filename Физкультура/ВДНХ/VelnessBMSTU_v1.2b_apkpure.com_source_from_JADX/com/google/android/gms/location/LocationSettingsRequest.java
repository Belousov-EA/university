package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends zzbfm {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzab();
    private final List<LocationRequest> zzhhm;
    private final boolean zzika;
    private final boolean zzikb;
    private zzz zzikc;

    public static final class Builder {
        private boolean zzika = false;
        private boolean zzikb = false;
        private zzz zzikc = null;
        private final ArrayList<LocationRequest> zzikd = new ArrayList();

        public final Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            for (LocationRequest locationRequest : collection) {
                if (locationRequest != null) {
                    this.zzikd.add(locationRequest);
                }
            }
            return this;
        }

        public final Builder addLocationRequest(@NonNull LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.zzikd.add(locationRequest);
            }
            return this;
        }

        public final LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzikd, this.zzika, this.zzikb, null);
        }

        public final Builder setAlwaysShow(boolean z) {
            this.zzika = z;
            return this;
        }

        public final Builder setNeedBle(boolean z) {
            this.zzikb = z;
            return this;
        }
    }

    LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzz com_google_android_gms_location_zzz) {
        this.zzhhm = list;
        this.zzika = z;
        this.zzikb = z2;
        this.zzikc = com_google_android_gms_location_zzz;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, Collections.unmodifiableList(this.zzhhm), false);
        zzbfp.zza(parcel, 2, this.zzika);
        zzbfp.zza(parcel, 3, this.zzikb);
        zzbfp.zza(parcel, 5, this.zzikc, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
