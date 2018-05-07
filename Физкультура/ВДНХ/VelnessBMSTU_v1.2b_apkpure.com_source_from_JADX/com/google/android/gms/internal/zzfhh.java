package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzd;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzfhh {
    static String zza(zzfhe com_google_android_gms_internal_zzfhe, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ").append(str);
        zza(com_google_android_gms_internal_zzfhe, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private static void zza(zzfhe com_google_android_gms_internal_zzfhe, StringBuilder stringBuilder, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Set<String> treeSet = new TreeSet();
        for (Method method : com_google_android_gms_internal_zzfhe.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2;
            String valueOf;
            Method method2;
            String replaceFirst3 = replaceFirst2.replaceFirst("get", "");
            if (replaceFirst3.endsWith("List") && !replaceFirst3.endsWith("OrBuilderList")) {
                valueOf = String.valueOf(replaceFirst3.substring(0, 1).toLowerCase());
                replaceFirst2 = String.valueOf(replaceFirst3.substring(1, replaceFirst3.length() - 4));
                valueOf = replaceFirst2.length() != 0 ? valueOf.concat(replaceFirst2) : new String(valueOf);
                String str = "get";
                replaceFirst2 = String.valueOf(replaceFirst3);
                method2 = (Method) hashMap.get(replaceFirst2.length() != 0 ? str.concat(replaceFirst2) : new String(str));
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(stringBuilder, i, zztv(valueOf), zzffu.zza(method2, (Object) com_google_android_gms_internal_zzfhe, new Object[0]));
                }
            }
            valueOf = "set";
            replaceFirst2 = String.valueOf(replaceFirst3);
            if (((Method) hashMap2.get(replaceFirst2.length() != 0 ? valueOf.concat(replaceFirst2) : new String(valueOf))) != null) {
                if (replaceFirst3.endsWith("Bytes")) {
                    valueOf = "get";
                    replaceFirst2 = String.valueOf(replaceFirst3.substring(0, replaceFirst3.length() - 5));
                    if (hashMap.containsKey(replaceFirst2.length() != 0 ? valueOf.concat(replaceFirst2) : new String(valueOf))) {
                    }
                }
                valueOf = String.valueOf(replaceFirst3.substring(0, 1).toLowerCase());
                replaceFirst2 = String.valueOf(replaceFirst3.substring(1));
                str = replaceFirst2.length() != 0 ? valueOf.concat(replaceFirst2) : new String(valueOf);
                valueOf = "get";
                replaceFirst2 = String.valueOf(replaceFirst3);
                method2 = (Method) hashMap.get(replaceFirst2.length() != 0 ? valueOf.concat(replaceFirst2) : new String(valueOf));
                String str2 = "has";
                valueOf = String.valueOf(replaceFirst3);
                Method method3 = (Method) hashMap.get(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                if (method2 != null) {
                    boolean equals;
                    zzfhe zza = zzffu.zza(method2, (Object) com_google_android_gms_internal_zzfhe, new Object[0]);
                    if (method3 == null) {
                        equals = zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? ((Float) zza).floatValue() == 0.0f : zza instanceof Double ? ((Double) zza).doubleValue() == 0.0d : zza instanceof String ? zza.equals("") : zza instanceof zzfes ? zza.equals(zzfes.zzpfg) : zza instanceof zzfhe ? zza == ((zzfhe) zza).zzcxq() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false;
                        equals = !equals;
                    } else {
                        equals = ((Boolean) zzffu.zza(method3, (Object) com_google_android_gms_internal_zzfhe, new Object[0])).booleanValue();
                    }
                    if (equals) {
                        zzb(stringBuilder, i, zztv(str), zza);
                    }
                }
            }
        }
        if (com_google_android_gms_internal_zzfhe instanceof zzd) {
            Iterator it = ((zzd) com_google_android_gms_internal_zzfhe).zzpgz.iterator();
            if (it.hasNext()) {
                ((Entry) it.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        if (((zzffu) com_google_android_gms_internal_zzfhe).zzpgr != null) {
            ((zzffu) com_google_android_gms_internal_zzfhe).zzpgr.zzd(stringBuilder, i);
        }
    }

    static final void zzb(StringBuilder stringBuilder, int i, String str, Object obj) {
        int i2 = 0;
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(stringBuilder, i, str, zzb);
            }
            return;
        }
        stringBuilder.append('\n');
        for (int i3 = 0; i3 < i; i3++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(str);
        if (obj instanceof String) {
            stringBuilder.append(": \"").append(zzfih.zzbc(zzfes.zztr((String) obj))).append('\"');
        } else if (obj instanceof zzfes) {
            stringBuilder.append(": \"").append(zzfih.zzbc((zzfes) obj)).append('\"');
        } else if (obj instanceof zzffu) {
            stringBuilder.append(" {");
            zza((zzffu) obj, stringBuilder, i + 2);
            stringBuilder.append("\n");
            while (i2 < i) {
                stringBuilder.append(' ');
                i2++;
            }
            stringBuilder.append("}");
        } else {
            stringBuilder.append(": ").append(obj.toString());
        }
    }

    private static final String zztv(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(charAt));
        }
        return stringBuilder.toString();
    }
}
