package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

final class zzdzr implements OnFailureListener {
    private /* synthetic */ zzecu zzmlh;

    zzdzr(zzdzq com_google_android_gms_internal_zzdzq, zzecu com_google_android_gms_internal_zzecu) {
        this.zzmlh = com_google_android_gms_internal_zzecu;
    }

    public final void onFailure(@NonNull Exception exception) {
        Object obj = ((exception instanceof FirebaseApiNotAvailableException) || (exception instanceof FirebaseNoSignedInUserException)) ? 1 : null;
        if (obj != null) {
            this.zzmlh.zzpl(null);
        } else {
            this.zzmlh.onError(exception.getMessage());
        }
    }
}
