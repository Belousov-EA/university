package com.google.firebase.auth.internal;

import android.support.annotation.Nullable;
import com.google.firebase.auth.FirebaseUserMetadata;

public final class zzi implements FirebaseUserMetadata {
    private long mCreationTimestamp;
    private long zzmhr;

    public zzi(long j, long j2) {
        this.zzmhr = j;
        this.mCreationTimestamp = j2;
    }

    @Nullable
    public final long getCreationTimestamp() {
        return this.mCreationTimestamp;
    }

    @Nullable
    public final long getLastSignInTimestamp() {
        return this.zzmhr;
    }
}
