package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

final class zzekq implements zzekp {
    private static ThreadLocal<CharsetDecoder> zzndn = new zzekr();
    private static ThreadLocal<CharsetEncoder> zzndo = new zzeks();
    private StringBuilder zzndp = new StringBuilder();

    zzekq() {
    }

    private static String zzap(byte[] bArr) {
        try {
            return ((CharsetDecoder) zzndn.get()).decode(ByteBuffer.wrap(bArr)).toString();
        } catch (CharacterCodingException e) {
            return null;
        }
    }

    public final boolean zzao(byte[] bArr) {
        String zzap = zzap(bArr);
        if (zzap == null) {
            return false;
        }
        this.zzndp.append(zzap);
        return true;
    }

    public final zzelc zzcar() {
        return new zzelc(this.zzndp.toString());
    }
}
