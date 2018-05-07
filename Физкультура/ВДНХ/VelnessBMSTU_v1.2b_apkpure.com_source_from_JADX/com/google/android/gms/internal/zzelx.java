package com.google.android.gms.internal;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.PropertyName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzelx<T> {
    private final Class<T> zznfk;
    private final Constructor<T> zznfl;
    private final boolean zznfm;
    private final boolean zznfn;
    private final Map<String, String> zznfo;
    private final Map<String, Method> zznfp;
    private final Map<String, Method> zznfq;
    private final Map<String, Field> zznfr;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzelx(java.lang.Class<T> r13) {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        r12.<init>();
        r12.zznfk = r13;
        r0 = com.google.firebase.database.ThrowOnExtraProperties.class;
        r0 = r13.isAnnotationPresent(r0);
        r12.zznfm = r0;
        r0 = com.google.firebase.database.IgnoreExtraProperties.class;
        r0 = r13.isAnnotationPresent(r0);
        if (r0 != 0) goto L_0x0094;
    L_0x0017:
        r0 = r1;
    L_0x0018:
        r12.zznfn = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfo = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfq = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfp = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfr = r0;
        r0 = 0;
        r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0096 }
        r0 = r13.getDeclaredConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x0096 }
        r3 = 1;
        r0.setAccessible(r3);	 Catch:{ NoSuchMethodException -> 0x0096 }
    L_0x0041:
        r12.zznfl = r0;
        r4 = r13.getMethods();
        r5 = r4.length;
        r3 = r2;
    L_0x0049:
        if (r3 >= r5) goto L_0x00f2;
    L_0x004b:
        r6 = r4[r3];
        r0 = r6.getName();
        r7 = "get";
        r0 = r0.startsWith(r7);
        if (r0 != 0) goto L_0x0099;
    L_0x0059:
        r0 = r6.getName();
        r7 = "is";
        r0 = r0.startsWith(r7);
        if (r0 != 0) goto L_0x0099;
    L_0x0065:
        r0 = r2;
    L_0x0066:
        if (r0 == 0) goto L_0x00ed;
    L_0x0068:
        r0 = zza(r6);
        r12.zzqk(r0);
        r6.setAccessible(r1);
        r7 = r12.zznfp;
        r7 = r7.containsKey(r0);
        if (r7 == 0) goto L_0x00e8;
    L_0x007a:
        r1 = new com.google.firebase.database.DatabaseException;
        r2 = "Found conflicting getters for name: ";
        r0 = r6.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00e2;
    L_0x008c:
        r0 = r2.concat(r0);
    L_0x0090:
        r1.<init>(r0);
        throw r1;
    L_0x0094:
        r0 = r2;
        goto L_0x0018;
    L_0x0096:
        r0 = move-exception;
        r0 = 0;
        goto L_0x0041;
    L_0x0099:
        r0 = r6.getDeclaringClass();
        r7 = java.lang.Object.class;
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x00a7;
    L_0x00a5:
        r0 = r2;
        goto L_0x0066;
    L_0x00a7:
        r0 = r6.getModifiers();
        r0 = java.lang.reflect.Modifier.isPublic(r0);
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        r0 = r2;
        goto L_0x0066;
    L_0x00b3:
        r0 = r6.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        if (r0 == 0) goto L_0x00bf;
    L_0x00bd:
        r0 = r2;
        goto L_0x0066;
    L_0x00bf:
        r0 = r6.getReturnType();
        r7 = java.lang.Void.TYPE;
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x00cd;
    L_0x00cb:
        r0 = r2;
        goto L_0x0066;
    L_0x00cd:
        r0 = r6.getParameterTypes();
        r0 = r0.length;
        if (r0 == 0) goto L_0x00d6;
    L_0x00d4:
        r0 = r2;
        goto L_0x0066;
    L_0x00d6:
        r0 = com.google.firebase.database.Exclude.class;
        r0 = r6.isAnnotationPresent(r0);
        if (r0 == 0) goto L_0x00e0;
    L_0x00de:
        r0 = r2;
        goto L_0x0066;
    L_0x00e0:
        r0 = r1;
        goto L_0x0066;
    L_0x00e2:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x0090;
    L_0x00e8:
        r7 = r12.zznfp;
        r7.put(r0, r6);
    L_0x00ed:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0049;
    L_0x00f2:
        r4 = r13.getFields();
        r5 = r4.length;
        r3 = r2;
    L_0x00f8:
        if (r3 >= r5) goto L_0x0146;
    L_0x00fa:
        r6 = r4[r3];
        r0 = r6.getDeclaringClass();
        r7 = java.lang.Object.class;
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0116;
    L_0x0108:
        r0 = r2;
    L_0x0109:
        if (r0 == 0) goto L_0x0112;
    L_0x010b:
        r0 = zza(r6);
        r12.zzqk(r0);
    L_0x0112:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x00f8;
    L_0x0116:
        r0 = r6.getModifiers();
        r0 = java.lang.reflect.Modifier.isPublic(r0);
        if (r0 != 0) goto L_0x0122;
    L_0x0120:
        r0 = r2;
        goto L_0x0109;
    L_0x0122:
        r0 = r6.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        if (r0 == 0) goto L_0x012e;
    L_0x012c:
        r0 = r2;
        goto L_0x0109;
    L_0x012e:
        r0 = r6.getModifiers();
        r0 = java.lang.reflect.Modifier.isTransient(r0);
        if (r0 == 0) goto L_0x013a;
    L_0x0138:
        r0 = r2;
        goto L_0x0109;
    L_0x013a:
        r0 = com.google.firebase.database.Exclude.class;
        r0 = r6.isAnnotationPresent(r0);
        if (r0 == 0) goto L_0x0144;
    L_0x0142:
        r0 = r2;
        goto L_0x0109;
    L_0x0144:
        r0 = r1;
        goto L_0x0109;
    L_0x0146:
        r4 = r13;
    L_0x0147:
        r6 = r4.getDeclaredMethods();
        r7 = r6.length;
        r5 = r2;
    L_0x014d:
        if (r5 >= r7) goto L_0x02b7;
    L_0x014f:
        r8 = r6[r5];
        r0 = r8.getName();
        r3 = "set";
        r0 = r0.startsWith(r3);
        if (r0 != 0) goto L_0x0192;
    L_0x015d:
        r0 = r2;
    L_0x015e:
        if (r0 == 0) goto L_0x01e7;
    L_0x0160:
        r3 = zza(r8);
        r0 = r12.zznfo;
        r9 = r3.toLowerCase();
        r0 = r0.get(r9);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x01e7;
    L_0x0172:
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x01d5;
    L_0x0178:
        r1 = new com.google.firebase.database.DatabaseException;
        r2 = "Found setter with invalid case-sensitive name: ";
        r0 = r8.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x01cf;
    L_0x018a:
        r0 = r2.concat(r0);
    L_0x018e:
        r1.<init>(r0);
        throw r1;
    L_0x0192:
        r0 = r8.getDeclaringClass();
        r3 = java.lang.Object.class;
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x01a0;
    L_0x019e:
        r0 = r2;
        goto L_0x015e;
    L_0x01a0:
        r0 = r8.getModifiers();
        r0 = java.lang.reflect.Modifier.isStatic(r0);
        if (r0 == 0) goto L_0x01ac;
    L_0x01aa:
        r0 = r2;
        goto L_0x015e;
    L_0x01ac:
        r0 = r8.getReturnType();
        r3 = java.lang.Void.TYPE;
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x01ba;
    L_0x01b8:
        r0 = r2;
        goto L_0x015e;
    L_0x01ba:
        r0 = r8.getParameterTypes();
        r0 = r0.length;
        if (r0 == r1) goto L_0x01c3;
    L_0x01c1:
        r0 = r2;
        goto L_0x015e;
    L_0x01c3:
        r0 = com.google.firebase.database.Exclude.class;
        r0 = r8.isAnnotationPresent(r0);
        if (r0 == 0) goto L_0x01cd;
    L_0x01cb:
        r0 = r2;
        goto L_0x015e;
    L_0x01cd:
        r0 = r1;
        goto L_0x015e;
    L_0x01cf:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x018e;
    L_0x01d5:
        r0 = r12.zznfq;
        r0 = r0.get(r3);
        r0 = (java.lang.reflect.Method) r0;
        if (r0 != 0) goto L_0x01ec;
    L_0x01df:
        r8.setAccessible(r1);
        r0 = r12.zznfq;
        r0.put(r3, r8);
    L_0x01e7:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x014d;
    L_0x01ec:
        r3 = r8.getDeclaringClass();
        r9 = r0.getDeclaringClass();
        r3 = r3.isAssignableFrom(r9);
        r9 = "Expected override from a base class";
        com.google.android.gms.internal.zzelt.zzb(r3, r9);
        r3 = r8.getReturnType();
        r9 = java.lang.Void.TYPE;
        r3 = r3.equals(r9);
        r9 = "Expected void return type";
        com.google.android.gms.internal.zzelt.zzb(r3, r9);
        r3 = r0.getReturnType();
        r9 = java.lang.Void.TYPE;
        r3 = r3.equals(r9);
        r9 = "Expected void return type";
        com.google.android.gms.internal.zzelt.zzb(r3, r9);
        r9 = r8.getParameterTypes();
        r10 = r0.getParameterTypes();
        r3 = r9.length;
        if (r3 != r1) goto L_0x02af;
    L_0x0226:
        r3 = r1;
    L_0x0227:
        r11 = "Expected exactly one parameter";
        com.google.android.gms.internal.zzelt.zzb(r3, r11);
        r3 = r10.length;
        if (r3 != r1) goto L_0x02b2;
    L_0x022f:
        r3 = r1;
    L_0x0230:
        r11 = "Expected exactly one parameter";
        com.google.android.gms.internal.zzelt.zzb(r3, r11);
        r3 = r8.getName();
        r11 = r0.getName();
        r3 = r3.equals(r11);
        if (r3 == 0) goto L_0x02b5;
    L_0x0243:
        r3 = r9[r2];
        r9 = r10[r2];
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x02b5;
    L_0x024d:
        r3 = r1;
    L_0x024e:
        if (r3 != 0) goto L_0x01e7;
    L_0x0250:
        r1 = new com.google.firebase.database.DatabaseException;
        r2 = r8.getName();
        r3 = r0.getName();
        r0 = r0.getDeclaringClass();
        r0 = r0.getName();
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r4 = r4 + 69;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = java.lang.String.valueOf(r0);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Found a conflicting setters with name: ";
        r4 = r5.append(r4);
        r2 = r4.append(r2);
        r4 = " (conflicts with ";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r3 = " defined on ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = ")";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x02af:
        r3 = r2;
        goto L_0x0227;
    L_0x02b2:
        r3 = r2;
        goto L_0x0230;
    L_0x02b5:
        r3 = r2;
        goto L_0x024e;
    L_0x02b7:
        r3 = r4.getDeclaredFields();
        r5 = r3.length;
        r0 = r2;
    L_0x02bd:
        if (r0 >= r5) goto L_0x02e4;
    L_0x02bf:
        r6 = r3[r0];
        r7 = zza(r6);
        r8 = r12.zznfo;
        r9 = r7.toLowerCase();
        r8 = r8.containsKey(r9);
        if (r8 == 0) goto L_0x02e1;
    L_0x02d1:
        r8 = r12.zznfr;
        r8 = r8.containsKey(r7);
        if (r8 != 0) goto L_0x02e1;
    L_0x02d9:
        r6.setAccessible(r1);
        r8 = r12.zznfr;
        r8.put(r7, r6);
    L_0x02e1:
        r0 = r0 + 1;
        goto L_0x02bd;
    L_0x02e4:
        r0 = r4.getSuperclass();
        if (r0 == 0) goto L_0x02f2;
    L_0x02ea:
        r3 = java.lang.Object.class;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x031b;
    L_0x02f2:
        r0 = r12.zznfo;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x031a;
    L_0x02fa:
        r1 = new com.google.firebase.database.DatabaseException;
        r2 = "No properties to serialize found on class ";
        r0 = r13.getName();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x0314;
    L_0x030c:
        r0 = r2.concat(r0);
    L_0x0310:
        r1.<init>(r0);
        throw r1;
    L_0x0314:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x0310;
    L_0x031a:
        return;
    L_0x031b:
        r4 = r0;
        goto L_0x0147;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzelx.<init>(java.lang.Class):void");
    }

    private static String zza(AccessibleObject accessibleObject) {
        return accessibleObject.isAnnotationPresent(PropertyName.class) ? ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value() : null;
    }

    private static String zza(Field field) {
        String zza = zza((AccessibleObject) field);
        return zza != null ? zza : field.getName();
    }

    private static String zza(Method method) {
        String zza = zza((AccessibleObject) method);
        if (zza != null) {
            return zza;
        }
        String name = method.getName();
        String[] strArr = new String[]{"get", "set", "is"};
        String str = null;
        int i = 0;
        while (i < 3) {
            zza = strArr[i];
            if (!name.startsWith(zza)) {
                zza = str;
            }
            i++;
            str = zza;
        }
        if (str == null) {
            String str2 = "Unknown Bean prefix for method: ";
            zza = String.valueOf(name);
            throw new IllegalArgumentException(zza.length() != 0 ? str2.concat(zza) : new String(str2));
        }
        char[] toCharArray = name.substring(str.length()).toCharArray();
        int i2 = 0;
        while (i2 < toCharArray.length && Character.isUpperCase(toCharArray[i2])) {
            toCharArray[i2] = Character.toLowerCase(toCharArray[i2]);
            i2++;
        }
        return new String(toCharArray);
    }

    private static Type zza(Type type, Map<TypeVariable<Class<T>>, Type> map) {
        if (!(type instanceof TypeVariable)) {
            return type;
        }
        Type type2 = (Type) map.get(type);
        if (type2 != null) {
            return type2;
        }
        String valueOf = String.valueOf(type);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Could not resolve type ").append(valueOf).toString());
    }

    private final void zzqk(String str) {
        String str2 = (String) this.zznfo.put(str.toLowerCase(), str);
        if (str2 != null && !str.equals(str2)) {
            String str3 = "Found two getters or fields with conflicting case sensitivity for property: ";
            str2 = String.valueOf(str.toLowerCase());
            throw new DatabaseException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
        }
    }

    public final Map<String, Object> zzcb(T t) {
        if (this.zznfk.isAssignableFrom(t.getClass())) {
            Map<String, Object> hashMap = new HashMap();
            for (String str : this.zznfo.values()) {
                String str2;
                Object invoke;
                if (this.zznfp.containsKey(str2)) {
                    try {
                        invoke = ((Method) this.zznfp.get(str2)).invoke(t, new Object[0]);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                }
                Field field = (Field) this.zznfr.get(str2);
                if (field == null) {
                    String str3 = "Bean property without field or getter:";
                    str2 = String.valueOf(str2);
                    throw new IllegalStateException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                }
                try {
                    invoke = field.get(t);
                } catch (Throwable e22) {
                    throw new RuntimeException(e22);
                }
                hashMap.put(str2, zzelw.zzbx(invoke));
            }
            return hashMap;
        }
        String valueOf = String.valueOf(t.getClass());
        str3 = String.valueOf(this.zznfk);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 59) + String.valueOf(str3).length()).append("Can't serialize object of class ").append(valueOf).append(" with BeanMapper for class ").append(str3).toString());
    }

    public final T zze(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
        if (this.zznfl == null) {
            String name = this.zznfk.getName();
            throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 123).append("Class ").append(name).append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.").toString());
        }
        try {
            T newInstance = this.zznfl.newInstance(new Object[0]);
            for (Entry entry : map.entrySet()) {
                name = (String) entry.getKey();
                if (this.zznfq.containsKey(name)) {
                    Method method = (Method) this.zznfq.get(name);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw new IllegalStateException("Setter does not have exactly one parameter");
                    }
                    Object zzb = zzelw.zza(entry.getValue(), zza(genericParameterTypes[0], map2));
                    try {
                        method.invoke(newInstance, new Object[]{zzb});
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (this.zznfr.containsKey(name)) {
                    Field field = (Field) this.zznfr.get(name);
                    try {
                        field.set(newInstance, zzelw.zza(entry.getValue(), zza(field.getGenericType(), map2)));
                    } catch (Throwable e22) {
                        throw new RuntimeException(e22);
                    }
                } else {
                    String name2 = this.zznfk.getName();
                    name2 = new StringBuilder((String.valueOf(name).length() + 36) + String.valueOf(name2).length()).append("No setter/field for ").append(name).append(" found on class ").append(name2).toString();
                    if (this.zznfo.containsKey(name.toLowerCase())) {
                        name2 = String.valueOf(name2).concat(" (fields/setters are case sensitive!)");
                    }
                    if (this.zznfm) {
                        throw new DatabaseException(name2);
                    } else if (this.zznfn) {
                        Log.w("ClassMapper", name2);
                    }
                }
            }
            return newInstance;
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        } catch (Throwable e22222) {
            throw new RuntimeException(e22222);
        }
    }
}
