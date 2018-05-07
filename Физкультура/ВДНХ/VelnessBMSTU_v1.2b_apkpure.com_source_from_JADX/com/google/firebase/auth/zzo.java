package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzo implements Continuation<GetTokenResult, Task<Void>> {
    private /* synthetic */ FirebaseUser zzmdo;
    private /* synthetic */ ActionCodeSettings zzmdp;

    zzo(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzmdo = firebaseUser;
        this.zzmdp = actionCodeSettings;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzmdo.zzbre()).zza(this.zzmdp, ((GetTokenResult) task.getResult()).getToken());
    }
}
