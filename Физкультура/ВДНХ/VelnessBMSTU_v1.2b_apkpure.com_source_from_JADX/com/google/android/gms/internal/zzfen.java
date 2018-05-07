package com.google.android.gms.internal;

public abstract class zzfen<MessageType extends zzfhe> implements zzfhk<MessageType> {
    private static final zzffm zzpfe = zzffm.zzcxb();

    public final /* synthetic */ Object zzc(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        zzfhe com_google_android_gms_internal_zzfhe = (zzfhe) zze(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
        if (com_google_android_gms_internal_zzfhe == null || com_google_android_gms_internal_zzfhe.isInitialized()) {
            return com_google_android_gms_internal_zzfhe;
        }
        zzfim com_google_android_gms_internal_zzfim = com_google_android_gms_internal_zzfhe instanceof zzfek ? new zzfim((zzfek) com_google_android_gms_internal_zzfhe) : com_google_android_gms_internal_zzfhe instanceof zzfem ? new zzfim((zzfem) com_google_android_gms_internal_zzfhe) : new zzfim(com_google_android_gms_internal_zzfhe);
        throw com_google_android_gms_internal_zzfim.zzczt().zzi(com_google_android_gms_internal_zzfhe);
    }
}
