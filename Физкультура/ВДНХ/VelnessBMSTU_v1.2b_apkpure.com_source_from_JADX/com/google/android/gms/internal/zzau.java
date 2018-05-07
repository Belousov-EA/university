package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzau extends zzr<String> {
    private final zzy<String> zzcj;

    public zzau(int i, String str, zzy<String> com_google_android_gms_internal_zzy_java_lang_String, zzx com_google_android_gms_internal_zzx) {
        super(i, str, com_google_android_gms_internal_zzx);
        this.zzcj = com_google_android_gms_internal_zzy_java_lang_String;
    }

    protected final zzw<String> zza(zzp com_google_android_gms_internal_zzp) {
        Object str;
        try {
            str = new String(com_google_android_gms_internal_zzp.data, zzao.zzb(com_google_android_gms_internal_zzp.zzac));
        } catch (UnsupportedEncodingException e) {
            str = new String(com_google_android_gms_internal_zzp.data);
        }
        return zzw.zza(str, zzao.zzb(com_google_android_gms_internal_zzp));
    }

    protected /* synthetic */ void zza(Object obj) {
        zzh((String) obj);
    }

    protected void zzh(String str) {
        if (this.zzcj != null) {
            this.zzcj.zzb(str);
        }
    }
}
