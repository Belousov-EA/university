package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzfel<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhf {
    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzffz.checkNotNull(iterable);
        if (iterable instanceof zzfgl) {
            List zzcyl = ((zzfgl) iterable).zzcyl();
            zzfgl com_google_android_gms_internal_zzfgl = (zzfgl) list;
            int size = list.size();
            for (Object next : zzcyl) {
                if (next == null) {
                    String str = "Element at index " + (com_google_android_gms_internal_zzfgl.size() - size) + " is null.";
                    for (int size2 = com_google_android_gms_internal_zzfgl.size() - 1; size2 >= size; size2--) {
                        com_google_android_gms_internal_zzfgl.remove(size2);
                    }
                    throw new NullPointerException(str);
                } else if (!(next instanceof zzfes)) {
                    com_google_android_gms_internal_zzfgl.add((String) next);
                }
            }
        } else if (iterable instanceof zzfhl) {
            list.addAll((Collection) iterable);
        } else {
            zzb((Iterable) iterable, (List) list);
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size = list.size();
        for (Object next : iterable) {
            if (next == null) {
                String str = "Element at index " + (list.size() - size) + " is null.";
                for (int size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
                throw new NullPointerException(str);
            }
            list.add(next);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzcvh();
    }

    protected abstract BuilderType zza(MessageType messageType);

    public abstract BuilderType zza(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException;

    public /* synthetic */ zzfhf zzb(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        return zza(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
    }

    public abstract BuilderType zzcvh();

    public final /* synthetic */ zzfhf zzd(zzfhe com_google_android_gms_internal_zzfhe) {
        if (zzcxq().getClass().isInstance(com_google_android_gms_internal_zzfhe)) {
            return zza((zzfek) com_google_android_gms_internal_zzfhe);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
