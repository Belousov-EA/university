package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzfhz extends zzfhy<FieldDescriptorType, Object> {
    zzfhz(int i) {
        super(i);
    }

    public final void zzbiy() {
        if (!isImmutable()) {
            for (int i = 0; i < zzczj(); i++) {
                Entry zzmb = zzmb(i);
                if (((zzffs) zzmb.getKey()).zzcxj()) {
                    zzmb.setValue(Collections.unmodifiableList((List) zzmb.getValue()));
                }
            }
            for (Entry entry : zzczk()) {
                if (((zzffs) entry.getKey()).zzcxj()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbiy();
    }
}
