package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzp implements Continuation<Void, List<TResult>> {
    private /* synthetic */ Collection zzkus;

    zzp(Collection collection) {
        this.zzkus = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        if (this.zzkus.size() == 0) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        for (Task result : this.zzkus) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
