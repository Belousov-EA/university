package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.zzcfs;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzcrt = null;
        private int zziiy = 0;
        private long zziiz = Long.MIN_VALUE;
        private short zzija = (short) -1;
        private double zzijb;
        private double zzijc;
        private float zzijd;
        private int zzije = 0;
        private int zzijf = -1;

        public final Geofence build() {
            if (this.zzcrt == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zziiy == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zziiy & 4) != 0 && this.zzijf < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zziiz == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzija == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzije >= 0) {
                return new zzcfs(this.zzcrt, this.zziiy, (short) 1, this.zzijb, this.zzijc, this.zzijd, this.zziiz, this.zzije, this.zzijf);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public final Builder setCircularRegion(double d, double d2, float f) {
            this.zzija = (short) 1;
            this.zzijb = d;
            this.zzijc = d2;
            this.zzijd = f;
            return this;
        }

        public final Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.zziiz = -1;
            } else {
                this.zziiz = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public final Builder setLoiteringDelay(int i) {
            this.zzijf = i;
            return this;
        }

        public final Builder setNotificationResponsiveness(int i) {
            this.zzije = i;
            return this;
        }

        public final Builder setRequestId(String str) {
            this.zzcrt = str;
            return this;
        }

        public final Builder setTransitionTypes(int i) {
            this.zziiy = i;
            return this;
        }
    }

    String getRequestId();
}
