package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public final class zzecs extends Reader {
    private boolean closed;
    private List<String> zzmrk;
    private int zzmrl;
    private int zzmrm;
    private int zzmrn;
    private int zzmro;
    private boolean zzmrp;

    public zzecs() {
        this.zzmrk = null;
        this.closed = false;
        this.zzmrn = this.zzmrl;
        this.zzmro = this.zzmrm;
        this.zzmrp = false;
        this.zzmrk = new ArrayList();
    }

    private final long zzbu(long j) {
        long j2 = 0;
        while (this.zzmrm < this.zzmrk.size() && j2 < j) {
            int zzbvn = zzbvn();
            long j3 = j - j2;
            if (j3 < ((long) zzbvn)) {
                this.zzmrl = (int) (((long) this.zzmrl) + j3);
                j2 += j3;
            } else {
                j2 += (long) zzbvn;
                this.zzmrl = 0;
                this.zzmrm++;
            }
        }
        return j2;
    }

    private final String zzbvm() {
        return this.zzmrm < this.zzmrk.size() ? (String) this.zzmrk.get(this.zzmrm) : null;
    }

    private final int zzbvn() {
        String zzbvm = zzbvm();
        return zzbvm == null ? 0 : zzbvm.length() - this.zzmrl;
    }

    private final void zzbvo() throws IOException {
        if (this.closed) {
            throw new IOException("Stream already closed");
        } else if (!this.zzmrp) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    public final void close() throws IOException {
        zzbvo();
        this.closed = true;
    }

    public final void mark(int i) throws IOException {
        zzbvo();
        this.zzmrn = this.zzmrl;
        this.zzmro = this.zzmrm;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzbvo();
        String zzbvm = zzbvm();
        if (zzbvm == null) {
            return -1;
        }
        char charAt = zzbvm.charAt(this.zzmrl);
        zzbu(1);
        return charAt;
    }

    public final int read(CharBuffer charBuffer) throws IOException {
        zzbvo();
        int remaining = charBuffer.remaining();
        int i = 0;
        String zzbvm = zzbvm();
        while (remaining > 0 && zzbvm != null) {
            int min = Math.min(zzbvm.length() - this.zzmrl, remaining);
            charBuffer.put((String) this.zzmrk.get(this.zzmrm), this.zzmrl, this.zzmrl + min);
            remaining -= min;
            i += min;
            zzbu((long) min);
            zzbvm = zzbvm();
        }
        return (i > 0 || zzbvm != null) ? i : -1;
    }

    public final int read(char[] cArr, int i, int i2) throws IOException {
        zzbvo();
        int i3 = 0;
        String zzbvm = zzbvm();
        while (zzbvm != null && i3 < i2) {
            int min = Math.min(zzbvn(), i2 - i3);
            zzbvm.getChars(this.zzmrl, this.zzmrl + min, cArr, i + i3);
            int i4 = i3 + min;
            zzbu((long) min);
            i3 = i4;
            zzbvm = zzbvm();
        }
        return (i3 > 0 || zzbvm != null) ? i3 : -1;
    }

    public final boolean ready() throws IOException {
        zzbvo();
        return true;
    }

    public final void reset() throws IOException {
        this.zzmrl = this.zzmrn;
        this.zzmrm = this.zzmro;
    }

    public final long skip(long j) throws IOException {
        zzbvo();
        return zzbu(j);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : this.zzmrk) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }

    public final void zzbvl() {
        if (this.zzmrp) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.zzmrp = true;
    }

    public final void zzpt(String str) {
        if (this.zzmrp) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.zzmrk.add(str);
        }
    }
}
