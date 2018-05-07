package com.google.android.gms.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzelu implements CompletionListener {
    private /* synthetic */ TaskCompletionSource zzgbh;

    zzelu(TaskCompletionSource taskCompletionSource) {
        this.zzgbh = taskCompletionSource;
    }

    public final void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
        if (databaseError != null) {
            this.zzgbh.setException(databaseError.toException());
        } else {
            this.zzgbh.setResult(null);
        }
    }
}
