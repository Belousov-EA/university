package com.google.firebase.iid;

import android.os.Bundle;

final class zzq extends zzr<Void> {
    zzq(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    final void zzac(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            finish(null);
        } else {
            zzb(new zzs(4, "Invalid response to one way request"));
        }
    }

    final boolean zzcje() {
        return true;
    }
}
