package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.GenericTypeIndicator;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzelw {
    private static final ConcurrentMap<Class<?>, zzelx<?>> zznfj = new ConcurrentHashMap();

    public static <T> T zza(Object obj, GenericTypeIndicator<T> genericTypeIndicator) {
        Type genericSuperclass = genericTypeIndicator.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return zza(obj, parameterizedType.getActualTypeArguments()[0]);
            }
            String valueOf = String.valueOf(genericSuperclass);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf).toString());
        }
        valueOf = String.valueOf(genericSuperclass);
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf).toString());
    }

    public static <T> T zza(Object obj, Class<T> cls) {
        return zzb(obj, (Class) cls);
    }

    private static <T> T zza(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        String valueOf;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            if (List.class.isAssignableFrom(cls)) {
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                if (obj instanceof List) {
                    List<Object> list = (List) obj;
                    T arrayList = new ArrayList(list.size());
                    for (Object zza : list) {
                        arrayList.add(zza(zza, type2));
                    }
                    return arrayList;
                }
                valueOf = String.valueOf(obj.getClass());
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Expected a List while deserializing, but got a ").append(valueOf).toString());
            } else if (Map.class.isAssignableFrom(cls)) {
                Object obj2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (obj2.equals(String.class)) {
                    Map zzby = zzby(obj);
                    T hashMap = new HashMap();
                    for (Entry entry : zzby.entrySet()) {
                        hashMap.put((String) entry.getKey(), zza(entry.getValue(), type3));
                    }
                    return hashMap;
                }
                String valueOf2 = String.valueOf(obj2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 70).append("Only Maps with string keys are supported, but found Map with key type ").append(valueOf2).toString());
            } else if (Collection.class.isAssignableFrom(cls)) {
                throw new DatabaseException("Collections are not supported, please use Lists instead");
            } else {
                Map zzby2 = zzby(obj);
                zzelx zzf = zzf(cls);
                Map hashMap2 = new HashMap();
                TypeVariable[] typeParameters = zzf.zznfk.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments.length != typeParameters.length) {
                    throw new IllegalStateException("Mismatched lengths for type variables and actual types");
                }
                for (int i = 0; i < typeParameters.length; i++) {
                    hashMap2.put(typeParameters[i], actualTypeArguments[i]);
                }
                return zzf.zze(zzby2, hashMap2);
            }
        } else if (type instanceof Class) {
            return zzb(obj, (Class) type);
        } else {
            if (type instanceof WildcardType) {
                throw new DatabaseException("Generic wildcard types are not supported");
            } else if (type instanceof GenericArrayType) {
                throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
            } else {
                valueOf = String.valueOf(type);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unknown type encountered: ").append(valueOf).toString());
            }
        }
    }

    public static Map<String, Object> zzan(Map<String, Object> map) {
        Object zzbx = zzbx(map);
        zzelt.zzcp(zzbx instanceof Map);
        return (Map) zzbx;
    }

    private static <T> T zzb(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        String name;
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
                if (obj instanceof Integer) {
                    return (Integer) obj;
                }
                if ((obj instanceof Long) || (obj instanceof Double)) {
                    double doubleValue = ((Number) obj).doubleValue();
                    if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
                        return Integer.valueOf(((Number) obj).intValue());
                    }
                    throw new DatabaseException("Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
                }
                name = obj.getClass().getName();
                throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 41).append("Failed to convert a value of type ").append(name).append(" to int").toString());
            } else if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                name = obj.getClass().getName();
                throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 43).append("Failed to convert value of type ").append(name).append(" to boolean").toString());
            } else if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
                return zzbz(obj);
            } else {
                if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
                    if (obj instanceof Integer) {
                        return Long.valueOf(((Integer) obj).longValue());
                    }
                    if (obj instanceof Long) {
                        return (Long) obj;
                    }
                    if (obj instanceof Double) {
                        Double d = (Double) obj;
                        if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                            return Long.valueOf(d.longValue());
                        }
                        name = String.valueOf(d);
                        throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 89).append("Numeric value out of 64-bit long range: ").append(name).append(". Did you mean to use a double instead of a long?").toString());
                    }
                    name = obj.getClass().getName();
                    throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 42).append("Failed to convert a value of type ").append(name).append(" to long").toString());
                } else if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
                    return Float.valueOf(zzbz(obj).floatValue());
                } else {
                    if (Short.class.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls)) {
                        throw new DatabaseException("Deserializing to shorts is not supported");
                    } else if (Byte.class.isAssignableFrom(cls) || Byte.TYPE.isAssignableFrom(cls)) {
                        throw new DatabaseException("Deserializing to bytes is not supported");
                    } else if (Character.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls)) {
                        throw new DatabaseException("Deserializing to char is not supported");
                    } else {
                        name = String.valueOf(cls);
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(name).length() + 24).append("Unknown primitive type: ").append(name).toString());
                    }
                }
            }
        } else if (String.class.isAssignableFrom(cls)) {
            if (obj instanceof String) {
                return (String) obj;
            }
            name = obj.getClass().getName();
            throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 42).append("Failed to convert value of type ").append(name).append(" to String").toString());
        } else if (cls.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (cls.getTypeParameters().length > 0) {
            name = cls.getName();
            throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 75).append("Class ").append(name).append(" has generic type parameters, please use GenericTypeIndicator instead").toString());
        } else if (cls.equals(Object.class)) {
            return obj;
        } else {
            if (cls.isEnum()) {
                return zzc(obj, cls);
            }
            zzelx zzf = zzf(cls);
            if (obj instanceof Map) {
                return zzf.zze(zzby(obj), Collections.emptyMap());
            }
            name = obj.getClass().getName();
            String name2 = cls.getName();
            throw new DatabaseException(new StringBuilder((String.valueOf(name).length() + 38) + String.valueOf(name2).length()).append("Can't convert object of type ").append(name).append(" to type ").append(name2).toString());
        }
    }

    public static Object zzbw(Object obj) {
        return zzbx(obj);
    }

    private static <T> Object zzbx(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if ((t instanceof Float) || (t instanceof Double)) {
                double doubleValue = ((Number) t).doubleValue();
                return (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d || Math.floor(doubleValue) != doubleValue) ? Double.valueOf(doubleValue) : Long.valueOf(((Number) t).longValue());
            } else if (t instanceof Short) {
                throw new DatabaseException("Shorts are not supported, please use int or long");
            } else if (!(t instanceof Byte)) {
                return t;
            } else {
                throw new DatabaseException("Bytes are not supported, please use int or long");
            }
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            } else if (t instanceof Map) {
                Map hashMap = new HashMap();
                for (Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, zzbx(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    List<Object> list = (List) t;
                    List arrayList = new ArrayList(list.size());
                    for (Object zzbx : list) {
                        arrayList.add(zzbx(zzbx));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (!t.getClass().isArray()) {
                return t instanceof Enum ? ((Enum) t).name() : zzf(t.getClass()).zzcb(t);
            } else {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            }
        }
    }

    private static Map<String, Object> zzby(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected a Map while deserializing, but got a ").append(valueOf).toString());
    }

    private static Double zzbz(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        String valueOf;
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf2 = Double.valueOf(((Long) obj).doubleValue());
            if (valueOf2.longValue() == l.longValue()) {
                return valueOf2;
            }
            valueOf = String.valueOf(obj);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 97).append("Loss of precision while converting number to double: ").append(valueOf).append(". Did you mean to use a 64-bit long instead?").toString());
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            valueOf = obj.getClass().getName();
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to convert a value of type ").append(valueOf).append(" to double").toString());
        }
    }

    private static <T> T zzc(Object obj, Class<T> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                return Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
                String name = cls.getName();
                throw new DatabaseException(new StringBuilder((String.valueOf(name).length() + 42) + String.valueOf(str).length()).append("Could not find enum value of ").append(name).append(" for value \"").append(str).append("\"").toString());
            }
        }
        name = String.valueOf(cls);
        String valueOf = String.valueOf(obj.getClass());
        throw new DatabaseException(new StringBuilder((String.valueOf(name).length() + 57) + String.valueOf(valueOf).length()).append("Expected a String while deserializing to enum ").append(name).append(" but got a ").append(valueOf).toString());
    }

    private static <T> zzelx<T> zzf(Class<T> cls) {
        zzelx<T> com_google_android_gms_internal_zzelx_T = (zzelx) zznfj.get(cls);
        if (com_google_android_gms_internal_zzelx_T != null) {
            return com_google_android_gms_internal_zzelx_T;
        }
        com_google_android_gms_internal_zzelx_T = new zzelx(cls);
        zznfj.put(cls, com_google_android_gms_internal_zzelx_T);
        return com_google_android_gms_internal_zzelx_T;
    }
}
