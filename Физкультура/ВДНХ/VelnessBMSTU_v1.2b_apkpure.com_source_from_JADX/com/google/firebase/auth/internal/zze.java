package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

public final class zze implements AuthResult {
    private zzh zzmhf;
    private zzd zzmhg = null;

    public zze(@NonNull zzh com_google_firebase_auth_internal_zzh) {
        this.zzmhf = (zzh) zzbq.checkNotNull(com_google_firebase_auth_internal_zzh);
        List zzbsc = this.zzmhf.zzbsc();
        for (int i = 0; i < zzbsc.size(); i++) {
            if (!TextUtils.isEmpty(((zzf) zzbsc.get(i)).getRawUserInfo())) {
                this.zzmhg = new zzd(((zzf) zzbsc.get(i)).getProviderId(), ((zzf) zzbsc.get(i)).getRawUserInfo(), com_google_firebase_auth_internal_zzh.isNewUser());
            }
        }
        if (this.zzmhg == null) {
            this.zzmhg = new zzd(com_google_firebase_auth_internal_zzh.isNewUser());
        }
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzmhg;
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zzmhf;
    }
}
