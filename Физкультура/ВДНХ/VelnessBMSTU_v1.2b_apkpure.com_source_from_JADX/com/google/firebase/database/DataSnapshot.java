package com.google.firebase.database;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzejw;
import com.google.android.gms.internal.zzelv;
import com.google.android.gms.internal.zzelw;

public class DataSnapshot {
    private final zzejw zzmjq;
    private final DatabaseReference zzmjr;

    DataSnapshot(DatabaseReference databaseReference, zzejw com_google_android_gms_internal_zzejw) {
        this.zzmjq = com_google_android_gms_internal_zzejw;
        this.zzmjr = databaseReference;
    }

    public DataSnapshot child(String str) {
        return new DataSnapshot(this.zzmjr.child(str), zzejw.zzj(this.zzmjq.zzbsv().zzan(new zzedk(str))));
    }

    public boolean exists() {
        return !this.zzmjq.zzbsv().isEmpty();
    }

    public Iterable<DataSnapshot> getChildren() {
        return new zza(this, this.zzmjq.iterator());
    }

    public long getChildrenCount() {
        return (long) this.zzmjq.zzbsv().getChildCount();
    }

    public String getKey() {
        return this.zzmjr.getKey();
    }

    public Object getPriority() {
        Object value = this.zzmjq.zzbsv().zzbzv().getValue();
        return value instanceof Long ? Double.valueOf((double) ((Long) value).longValue()) : value;
    }

    public DatabaseReference getRef() {
        return this.zzmjr;
    }

    @Nullable
    public Object getValue() {
        return this.zzmjq.zzbsv().getValue();
    }

    @Nullable
    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzelw.zza(this.zzmjq.zzbsv().getValue(), (GenericTypeIndicator) genericTypeIndicator);
    }

    @Nullable
    public <T> T getValue(Class<T> cls) {
        return zzelw.zza(this.zzmjq.zzbsv().getValue(), (Class) cls);
    }

    @Nullable
    public Object getValue(boolean z) {
        return this.zzmjq.zzbsv().getValue(z);
    }

    public boolean hasChild(String str) {
        if (this.zzmjr.getParent() == null) {
            zzelv.zzqi(str);
        } else {
            zzelv.zzqh(str);
        }
        return !this.zzmjq.zzbsv().zzan(new zzedk(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.zzmjq.zzbsv().getChildCount() > 0;
    }

    public String toString() {
        String key = this.zzmjr.getKey();
        String valueOf = String.valueOf(this.zzmjq.zzbsv().getValue(true));
        return new StringBuilder((String.valueOf(key).length() + 33) + String.valueOf(valueOf).length()).append("DataSnapshot { key = ").append(key).append(", value = ").append(valueOf).append(" }").toString();
    }
}
