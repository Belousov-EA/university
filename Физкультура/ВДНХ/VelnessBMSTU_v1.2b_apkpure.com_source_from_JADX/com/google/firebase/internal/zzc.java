package com.google.firebase.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzc {
    private String zzecl;

    public zzc(@Nullable String str) {
        this.zzecl = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        return zzbg.equal(this.zzecl, ((zzc) obj).zzecl);
    }

    @Nullable
    public final String getToken() {
        return this.zzecl;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzecl});
    }

    public final String toString() {
        return zzbg.zzx(this).zzg("token", this.zzecl).toString();
    }
}
