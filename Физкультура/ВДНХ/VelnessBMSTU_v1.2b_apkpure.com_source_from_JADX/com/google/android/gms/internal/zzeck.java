package com.google.android.gms.internal;

final class zzeck implements zzecj, zzekz {
    final /* synthetic */ zzecf zzmqe;
    private zzeku zzmqf;

    private zzeck(zzecf com_google_android_gms_internal_zzecf, zzeku com_google_android_gms_internal_zzeku) {
        this.zzmqe = com_google_android_gms_internal_zzecf;
        this.zzmqf = com_google_android_gms_internal_zzeku;
        this.zzmqf.zza((zzekz) this);
    }

    public final void close() {
        this.zzmqf.close();
    }

    public final void connect() {
        try {
            this.zzmqf.connect();
        } catch (Throwable e) {
            if (this.zzmqe.zzmlr.zzbzl()) {
                this.zzmqe.zzmlr.zzb("Error connecting", e, new Object[0]);
            }
            this.zzmqf.close();
            try {
                this.zzmqf.zzcaw();
            } catch (Throwable e2) {
                this.zzmqe.zzmlr.zzd("Interrupted while shutting down websocket threads", e2);
            }
        }
    }

    public final void onClose() {
        this.zzmqe.zzmlf.execute(new zzecn(this));
    }

    public final void zza(zzela com_google_android_gms_internal_zzela) {
        this.zzmqe.zzmlf.execute(new zzeco(this, com_google_android_gms_internal_zzela));
    }

    public final void zza(zzelc com_google_android_gms_internal_zzelc) {
        String text = com_google_android_gms_internal_zzelc.getText();
        if (this.zzmqe.zzmlr.zzbzl()) {
            zzejc zzb = this.zzmqe.zzmlr;
            String str = "ws message: ";
            String valueOf = String.valueOf(text);
            zzb.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
        }
        this.zzmqe.zzmlf.execute(new zzecm(this, text));
    }

    public final void zzbvg() {
        this.zzmqe.zzmlf.execute(new zzecl(this));
    }

    public final void zzps(String str) {
        this.zzmqf.zzps(str);
    }
}
