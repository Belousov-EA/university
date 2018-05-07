package com.google.firebase.database;

import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzedn;
import com.google.android.gms.internal.zzege;
import com.google.android.gms.internal.zzeju;
import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzekg;
import com.google.android.gms.internal.zzekj;
import com.google.android.gms.internal.zzelq;
import com.google.android.gms.internal.zzelt;
import com.google.android.gms.internal.zzelv;
import com.google.android.gms.internal.zzelw;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.util.Map;

public class OnDisconnect {
    private zzedn zzmkl;
    private zzedk zzmks;

    OnDisconnect(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmkl = com_google_android_gms_internal_zzedn;
        this.zzmks = com_google_android_gms_internal_zzedk;
    }

    private final Task<Void> zza(CompletionListener completionListener) {
        zzelq zzb = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zzo(this, zzb));
        return (Task) zzb.getFirst();
    }

    private final Task<Void> zza(Map<String, Object> map, CompletionListener completionListener) {
        Map zzb = zzelv.zzb(this.zzmks, map);
        zzelq zzb2 = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zzn(this, zzb, zzb2, map));
        return (Task) zzb2.getFirst();
    }

    private final Task<Void> zzb(Object obj, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        zzelv.zzao(this.zzmks);
        zzege.zza(this.zzmks, obj);
        Object zzbw = zzelw.zzbw(obj);
        zzelv.zzbv(zzbw);
        zzekd zza = zzekg.zza(zzbw, com_google_android_gms_internal_zzekd);
        zzelq zzb = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zzm(this, zza, zzb));
        return (Task) zzb.getFirst();
    }

    public Task<Void> cancel() {
        return zza(null);
    }

    public void cancel(CompletionListener completionListener) {
        zza(completionListener);
    }

    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue(null, completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zzb(obj, zzeju.zzcaf(), null);
    }

    public Task<Void> setValue(Object obj, double d) {
        return zzb(obj, zzekj.zzc(this.zzmks, Double.valueOf(d)), null);
    }

    public Task<Void> setValue(Object obj, String str) {
        return zzb(obj, zzekj.zzc(this.zzmks, str), null);
    }

    public void setValue(Object obj, double d, CompletionListener completionListener) {
        zzb(obj, zzekj.zzc(this.zzmks, Double.valueOf(d)), completionListener);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        zzb(obj, zzeju.zzcaf(), completionListener);
    }

    public void setValue(Object obj, String str, CompletionListener completionListener) {
        zzb(obj, zzekj.zzc(this.zzmks, str), completionListener);
    }

    public void setValue(Object obj, Map map, CompletionListener completionListener) {
        zzb(obj, zzekj.zzc(this.zzmks, map), completionListener);
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza(map, null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        zza(map, completionListener);
    }
}
