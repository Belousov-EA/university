package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzehw<T> {
    public T value;
    public Map<zzejg, zzehw<T>> zzmvi = new HashMap();

    final String toString(String str) {
        String valueOf = String.valueOf(this.value);
        valueOf = new StringBuilder((String.valueOf(str).length() + 10) + String.valueOf(valueOf).length()).append(str).append("<value>: ").append(valueOf).append("\n").toString();
        if (this.zzmvi.isEmpty()) {
            return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append(str).append("<empty>").toString();
        }
        String str2 = valueOf;
        for (Entry entry : this.zzmvi.entrySet()) {
            str2 = String.valueOf(str2);
            String valueOf2 = String.valueOf(entry.getKey());
            valueOf = ((zzehw) entry.getValue()).toString(String.valueOf(str).concat("\t"));
            str2 = new StringBuilder((((String.valueOf(str2).length() + 3) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()).append(str2).append(str).append(valueOf2).append(":\n").append(valueOf).append("\n").toString();
        }
        return str2;
    }
}
