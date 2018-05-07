package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzn implements Continuation<GetTokenResult, Task<Void>> {
    private /* synthetic */ FirebaseUser zzmdo;

    zzn(FirebaseUser firebaseUser) {
        this.zzmdo = firebaseUser;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzmdo.zzbre()).zzov(((GetTokenResult) task.getResult()).getToken());
    }
}
