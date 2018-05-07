package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class zzbgn {
    protected static <O, I> I zza(zzbgo<I, O> com_google_android_gms_internal_zzbgo_I__O, Object obj) {
        return com_google_android_gms_internal_zzbgo_I__O.zzgcn != null ? com_google_android_gms_internal_zzbgo_I__O.convertBack(obj) : obj;
    }

    private static void zza(StringBuilder stringBuilder, zzbgo com_google_android_gms_internal_zzbgo, Object obj) {
        if (com_google_android_gms_internal_zzbgo.zzgce == 11) {
            stringBuilder.append(((zzbgn) com_google_android_gms_internal_zzbgo.zzgck.cast(obj)).toString());
        } else if (com_google_android_gms_internal_zzbgo.zzgce == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(zzo.zzgr((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void zza(StringBuilder stringBuilder, zzbgo com_google_android_gms_internal_zzbgo, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(stringBuilder, com_google_android_gms_internal_zzbgo, obj);
            }
        }
        stringBuilder.append("]");
    }

    public String toString() {
        Map zzaav = zzaav();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : zzaav.keySet()) {
            zzbgo com_google_android_gms_internal_zzbgo = (zzbgo) zzaav.get(str);
            if (zza(com_google_android_gms_internal_zzbgo)) {
                Object zza = zza(com_google_android_gms_internal_zzbgo, zzb(com_google_android_gms_internal_zzbgo));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (zza != null) {
                    switch (com_google_android_gms_internal_zzbgo.zzgcg) {
                        case 8:
                            stringBuilder.append("\"").append(zzb.zzk((byte[]) zza)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(zzb.zzl((byte[]) zza)).append("\"");
                            break;
                        case 10:
                            zzp.zza(stringBuilder, (HashMap) zza);
                            break;
                        default:
                            if (!com_google_android_gms_internal_zzbgo.zzgcf) {
                                zza(stringBuilder, com_google_android_gms_internal_zzbgo, zza);
                                break;
                            }
                            zza(stringBuilder, com_google_android_gms_internal_zzbgo, (ArrayList) zza);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    protected boolean zza(zzbgo com_google_android_gms_internal_zzbgo) {
        if (com_google_android_gms_internal_zzbgo.zzgcg != 11) {
            return zzgp(com_google_android_gms_internal_zzbgo.zzgci);
        }
        if (com_google_android_gms_internal_zzbgo.zzgch) {
            String str = com_google_android_gms_internal_zzbgo.zzgci;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        str = com_google_android_gms_internal_zzbgo.zzgci;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract Map<String, zzbgo<?, ?>> zzaav();

    protected Object zzb(zzbgo com_google_android_gms_internal_zzbgo) {
        String str = com_google_android_gms_internal_zzbgo.zzgci;
        if (com_google_android_gms_internal_zzbgo.zzgck == null) {
            return zzgo(com_google_android_gms_internal_zzbgo.zzgci);
        }
        zzgo(com_google_android_gms_internal_zzbgo.zzgci);
        zzbq.zza(true, "Concrete field shouldn't be value object: %s", com_google_android_gms_internal_zzbgo.zzgci);
        boolean z = com_google_android_gms_internal_zzbgo.zzgch;
        try {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            str = str.substring(1);
            return getClass().getMethod(new StringBuilder(String.valueOf(str).length() + 4).append("get").append(toUpperCase).append(str).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzgo(String str);

    protected abstract boolean zzgp(String str);
}
