package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.zzcfs;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent {
    private final int mErrorCode;
    private final int zzijg;
    private final List<Geofence> zzijh;
    private final Location zziji;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.mErrorCode = i;
        this.zzijg = i2;
        this.zzijh = list;
        this.zziji = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        List list;
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        int i = (intExtra2 == -1 || !(intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) ? -1 : intExtra2;
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            list = null;
        } else {
            Object obj;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            arrayList = arrayList;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                obj = arrayList.get(i2);
                i2++;
                arrayList2.add(zzcfs.zzp((byte[]) obj));
            }
            obj = arrayList2;
        }
        return new GeofencingEvent(intExtra, i, list, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getGeofenceTransition() {
        return this.zzijg;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.zzijh;
    }

    public Location getTriggeringLocation() {
        return this.zziji;
    }

    public boolean hasError() {
        return this.mErrorCode != -1;
    }
}
