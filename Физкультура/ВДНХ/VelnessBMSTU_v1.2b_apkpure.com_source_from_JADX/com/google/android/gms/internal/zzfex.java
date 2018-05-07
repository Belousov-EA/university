package com.google.android.gms.internal;

final class zzfex {
    private final byte[] buffer;
    private final zzffg zzpfl;

    private zzfex(int i) {
        this.buffer = new byte[i];
        this.zzpfl = zzffg.zzbc(this.buffer);
    }

    public final zzfes zzcvr() {
        this.zzpfl.zzcwt();
        return new zzfez(this.buffer);
    }

    public final zzffg zzcvs() {
        return this.zzpfl;
    }
}
