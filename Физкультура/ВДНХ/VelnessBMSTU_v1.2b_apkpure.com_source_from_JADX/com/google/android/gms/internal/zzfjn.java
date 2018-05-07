package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzfjn<M extends zzfjm<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zznfk;
    private zzffu<?, ?> zzpgu;
    protected final boolean zzpnd;

    private zzfjn(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, i2, false);
    }

    private zzfjn(int i, Class<T> cls, zzffu<?, ?> com_google_android_gms_internal_zzffu___, int i2, boolean z) {
        this.type = i;
        this.zznfk = cls;
        this.tag = i2;
        this.zzpnd = false;
        this.zzpgu = null;
    }

    public static <M extends zzfjm<M>, T extends zzfjs> zzfjn<M, T> zza(int i, Class<T> cls, long j) {
        return new zzfjn(11, cls, (int) j, false);
    }

    private final Object zzan(zzfjj com_google_android_gms_internal_zzfjj) {
        String valueOf;
        Class componentType = this.zzpnd ? this.zznfk.getComponentType() : this.zznfk;
        try {
            zzfjs com_google_android_gms_internal_zzfjs;
            switch (this.type) {
                case 10:
                    com_google_android_gms_internal_zzfjs = (zzfjs) componentType.newInstance();
                    com_google_android_gms_internal_zzfjj.zza(com_google_android_gms_internal_zzfjs, this.tag >>> 3);
                    return com_google_android_gms_internal_zzfjs;
                case 11:
                    com_google_android_gms_internal_zzfjs = (zzfjs) componentType.newInstance();
                    com_google_android_gms_internal_zzfjj.zza(com_google_android_gms_internal_zzfjs);
                    return com_google_android_gms_internal_zzfjs;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfjn)) {
            return false;
        }
        zzfjn com_google_android_gms_internal_zzfjn = (zzfjn) obj;
        return this.type == com_google_android_gms_internal_zzfjn.type && this.zznfk == com_google_android_gms_internal_zzfjn.zznfk && this.tag == com_google_android_gms_internal_zzfjn.tag && this.zzpnd == com_google_android_gms_internal_zzfjn.zzpnd;
    }

    public final int hashCode() {
        return (this.zzpnd ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zznfk.hashCode()) * 31) + this.tag) * 31);
    }

    protected final void zza(Object obj, zzfjk com_google_android_gms_internal_zzfjk) {
        try {
            com_google_android_gms_internal_zzfjk.zzmi(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzfjs) obj).zza(com_google_android_gms_internal_zzfjk);
                    com_google_android_gms_internal_zzfjk.zzz(i, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zzfjk.zzb((zzfjs) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    final T zzbq(List<zzfju> list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        if (this.zzpnd) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                zzfju com_google_android_gms_internal_zzfju = (zzfju) list.get(i2);
                if (com_google_android_gms_internal_zzfju.zzjng.length != 0) {
                    arrayList.add(zzan(zzfjj.zzbe(com_google_android_gms_internal_zzfju.zzjng)));
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            T cast = this.zznfk.cast(Array.newInstance(this.zznfk.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zznfk.cast(zzan(zzfjj.zzbe(((zzfju) list.get(list.size() - 1)).zzjng)));
        }
    }

    protected final int zzcs(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzfjk.zzlg(i) << 1) + ((zzfjs) obj).zzho();
            case 11:
                return zzfjk.zzb(i, (zzfjs) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }
}
