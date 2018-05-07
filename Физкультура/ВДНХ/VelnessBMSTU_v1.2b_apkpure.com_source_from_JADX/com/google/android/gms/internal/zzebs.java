package com.google.android.gms.internal;

import java.util.Map;

final class zzebs implements zzebx {
    private /* synthetic */ zzebo zzmot;
    private /* synthetic */ boolean zzmox;

    zzebs(zzebo com_google_android_gms_internal_zzebo, boolean z) {
        this.zzmot = com_google_android_gms_internal_zzebo;
        this.zzmox = z;
    }

    public final void zzaj(Map<String, Object> map) {
        this.zzmot.zzmob = zzeby.Connected;
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.zzmot.zzmoo = 0;
            this.zzmot.zzmnv.zzcl(true);
            if (this.zzmox) {
                this.zzmot.zzbuq();
                return;
            }
            return;
        }
        this.zzmot.zzmoi = null;
        this.zzmot.zzmoj = true;
        this.zzmot.zzmnv.zzcl(false);
        String str2 = (String) map.get("d");
        this.zzmot.zzmlr.zzb(new StringBuilder((String.valueOf(str).length() + 26) + String.valueOf(str2).length()).append("Authentication failed: ").append(str).append(" (").append(str2).append(")").toString(), null, new Object[0]);
        this.zzmot.zzmoa.close();
        if (str.equals("invalid_token")) {
            this.zzmot.zzmoo = this.zzmot.zzmoo + 1;
            if (((long) this.zzmot.zzmoo) >= 3) {
                this.zzmot.zzmol.zzbvj();
                this.zzmot.zzmlr.zze("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.", null);
            }
        }
    }
}
