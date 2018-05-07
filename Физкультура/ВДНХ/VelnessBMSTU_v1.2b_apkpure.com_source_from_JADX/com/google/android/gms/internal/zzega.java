package com.google.android.gms.internal;

public final class zzega {
    private final long zzmwo;

    public zzega(long j) {
        this.zzmwo = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzmwo == ((zzega) obj).zzmwo;
    }

    public final int hashCode() {
        return (int) (this.zzmwo ^ (this.zzmwo >>> 32));
    }

    public final String toString() {
        return "Tag{tagNumber=" + this.zzmwo + "}";
    }

    public final long zzbwx() {
        return this.zzmwo;
    }
}
