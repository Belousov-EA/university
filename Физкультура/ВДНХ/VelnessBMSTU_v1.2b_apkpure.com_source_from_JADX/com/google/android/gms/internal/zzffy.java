package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzffy extends zzfeo<Integer> implements zzfgc, zzfhl, RandomAccess {
    private static final zzffy zzphs;
    private int size;
    private int[] zzpht;

    static {
        zzfeo com_google_android_gms_internal_zzffy = new zzffy();
        zzphs = com_google_android_gms_internal_zzffy;
        com_google_android_gms_internal_zzffy.zzbiy();
    }

    zzffy() {
        this(new int[10], 0);
    }

    private zzffy(int[] iArr, int i) {
        this.zzpht = iArr;
        this.size = i;
    }

    private final void zzai(int i, int i2) {
        zzcvj();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzlx(i));
        }
        if (this.size < this.zzpht.length) {
            System.arraycopy(this.zzpht, i, this.zzpht, i + 1, this.size - i);
        } else {
            Object obj = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzpht, 0, obj, 0, i);
            System.arraycopy(this.zzpht, i, obj, i + 1, this.size - i);
            this.zzpht = obj;
        }
        this.zzpht[i] = i2;
        this.size++;
        this.modCount++;
    }

    public static zzffy zzcxz() {
        return zzphs;
    }

    private final void zzlw(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzlx(i));
        }
    }

    private final String zzlx(int i) {
        return "Index:" + i + ", Size:" + this.size;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzai(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzcvj();
        zzffz.checkNotNull(collection);
        if (!(collection instanceof zzffy)) {
            return super.addAll(collection);
        }
        zzffy com_google_android_gms_internal_zzffy = (zzffy) collection;
        if (com_google_android_gms_internal_zzffy.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < com_google_android_gms_internal_zzffy.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + com_google_android_gms_internal_zzffy.size;
        if (i > this.zzpht.length) {
            this.zzpht = Arrays.copyOf(this.zzpht, i);
        }
        System.arraycopy(com_google_android_gms_internal_zzffy.zzpht, 0, this.zzpht, this.size, com_google_android_gms_internal_zzffy.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzffy)) {
            return super.equals(obj);
        }
        zzffy com_google_android_gms_internal_zzffy = (zzffy) obj;
        if (this.size != com_google_android_gms_internal_zzffy.size) {
            return false;
        }
        int[] iArr = com_google_android_gms_internal_zzffy.zzpht;
        for (int i = 0; i < this.size; i++) {
            if (this.zzpht[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzlw(i);
        return this.zzpht[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzpht[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzcvj();
        zzlw(i);
        int i2 = this.zzpht[i];
        System.arraycopy(this.zzpht, i + 1, this.zzpht, i, this.size - i);
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzcvj();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzpht[i]))) {
                System.arraycopy(this.zzpht, i + 1, this.zzpht, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzcvj();
        zzlw(i);
        int i2 = this.zzpht[i];
        this.zzpht[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    public final zzfgc zzlu(int i) {
        if (i >= this.size) {
            return new zzffy(Arrays.copyOf(this.zzpht, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzlv(int i) {
        zzai(this.size, i);
    }

    public final /* synthetic */ zzfgd zzly(int i) {
        return zzlu(i);
    }
}
