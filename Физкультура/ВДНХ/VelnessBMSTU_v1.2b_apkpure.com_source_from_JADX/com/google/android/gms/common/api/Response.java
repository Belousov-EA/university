package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class Response<T extends Result> {
    private T zzfne;

    protected Response(@NonNull T t) {
        this.zzfne = t;
    }

    @NonNull
    protected T getResult() {
        return this.zzfne;
    }

    public void setResult(@NonNull T t) {
        this.zzfne = t;
    }
}
