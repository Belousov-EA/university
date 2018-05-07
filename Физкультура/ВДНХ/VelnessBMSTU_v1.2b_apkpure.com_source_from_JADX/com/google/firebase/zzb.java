package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzcz;

public final class zzb implements zzcz {
    public final Exception zzt(Status status) {
        return status.getStatusCode() == 8 ? new FirebaseException(status.zzagx()) : new FirebaseApiNotAvailableException(status.zzagx());
    }
}
