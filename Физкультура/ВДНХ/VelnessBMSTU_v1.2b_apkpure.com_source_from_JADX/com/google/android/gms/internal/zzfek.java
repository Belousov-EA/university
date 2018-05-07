package com.google.android.gms.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class zzfek<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhe {
    private static boolean zzpfb = false;
    protected int zzpfa = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfel.zza((Iterable) iterable, (List) list);
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzho()];
            zzffg zzbc = zzffg.zzbc(bArr);
            zza(zzbc);
            zzbc.zzcwt();
            return bArr;
        } catch (Throwable e) {
            String str = "byte array";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final zzfes toByteString() {
        try {
            zzfex zzko = zzfes.zzko(zzho());
            zza(zzko.zzcvs());
            return zzko.zzcvr();
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        zzffg zzb = zzffg.zzb(outputStream, zzffg.zzlb(zzho()));
        zza(zzb);
        zzb.flush();
    }
}
