package com.google.android.gms.internal;

final class zzebq implements zzebh {
    private /* synthetic */ long zzmou;
    private /* synthetic */ zzebp zzmov;

    zzebq(zzebp com_google_android_gms_internal_zzebp, long j) {
        this.zzmov = com_google_android_gms_internal_zzebp;
        this.zzmou = j;
    }

    public final void onError(String str) {
        if (this.zzmou == this.zzmov.zzmot.zzmon) {
            this.zzmov.zzmot.zzmob = zzeby.Disconnected;
            zzejc zza = this.zzmov.zzmot.zzmlr;
            String str2 = "Error fetching token: ";
            String valueOf = String.valueOf(str);
            zza.zzb(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), null, new Object[0]);
            this.zzmov.zzmot.zzbuo();
            return;
        }
        this.zzmov.zzmot.zzmlr.zzb("Ignoring getToken error, because this was not the latest attempt.", null, new Object[0]);
    }

    public final void zzpl(String str) {
        if (this.zzmou != this.zzmov.zzmot.zzmon) {
            this.zzmov.zzmot.zzmlr.zzb("Ignoring getToken result, because this was not the latest attempt.", null, new Object[0]);
        } else if (this.zzmov.zzmot.zzmob == zzeby.GettingToken) {
            this.zzmov.zzmot.zzmlr.zzb("Successfully fetched token, opening connection", null, new Object[0]);
            this.zzmov.zzmot.zzpo(str);
        } else {
            zzebj.zzc(this.zzmov.zzmot.zzmob == zzeby.Disconnected, "Expected connection state disconnected, but was %s", this.zzmov.zzmot.zzmob);
            this.zzmov.zzmot.zzmlr.zzb("Not opening connection after token refresh, because connection was set to disconnected", null, new Object[0]);
        }
    }
}
