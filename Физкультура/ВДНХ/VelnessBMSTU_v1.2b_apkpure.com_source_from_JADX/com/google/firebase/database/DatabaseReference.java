package com.google.firebase.database;

import com.google.android.gms.internal.zzecy;
import com.google.android.gms.internal.zzedf;
import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzedn;
import com.google.android.gms.internal.zzeer;
import com.google.android.gms.internal.zzege;
import com.google.android.gms.internal.zzejg;
import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzekg;
import com.google.android.gms.internal.zzekj;
import com.google.android.gms.internal.zzelq;
import com.google.android.gms.internal.zzels;
import com.google.android.gms.internal.zzelt;
import com.google.android.gms.internal.zzelv;
import com.google.android.gms.internal.zzelw;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction.Handler;
import java.net.URLEncoder;
import java.util.Map;

public class DatabaseReference extends Query {
    private static zzedf zzmjy;

    public interface CompletionListener {
        void onComplete(DatabaseError databaseError, DatabaseReference databaseReference);
    }

    DatabaseReference(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk) {
        super(com_google_android_gms_internal_zzedn, com_google_android_gms_internal_zzedk);
    }

    public static void goOffline() {
        zzeer.zzd(zzbst());
    }

    public static void goOnline() {
        zzeer.zze(zzbst());
    }

    private final Task<Void> zza(zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        zzelv.zzao(this.zzmks);
        zzelq zzb = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zzd(this, com_google_android_gms_internal_zzekd, zzb));
        return (Task) zzb.getFirst();
    }

    private final Task<Void> zza(Object obj, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        zzelv.zzao(this.zzmks);
        zzege.zza(this.zzmks, obj);
        Object zzbw = zzelw.zzbw(obj);
        zzelv.zzbv(zzbw);
        zzekd zza = zzekg.zza(zzbw, com_google_android_gms_internal_zzekd);
        zzelq zzb = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zzc(this, zza, zzb));
        return (Task) zzb.getFirst();
    }

    private final Task<Void> zza(Map<String, Object> map, CompletionListener completionListener) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        Map zzan = zzelw.zzan(map);
        zzecy zzal = zzecy.zzal(zzelv.zzb(this.zzmks, zzan));
        zzelq zzb = zzelt.zzb(completionListener);
        this.zzmkl.zzo(new zze(this, zzal, zzb, zzan));
        return (Task) zzb.getFirst();
    }

    private static synchronized zzedf zzbst() {
        zzedf com_google_android_gms_internal_zzedf;
        synchronized (DatabaseReference.class) {
            if (zzmjy == null) {
                zzmjy = new zzedf();
            }
            com_google_android_gms_internal_zzedf = zzmjy;
        }
        return com_google_android_gms_internal_zzedf;
    }

    public DatabaseReference child(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (this.zzmks.isEmpty()) {
            zzelv.zzqi(str);
        } else {
            zzelv.zzqh(str);
        }
        return new DatabaseReference(this.zzmkl, this.zzmks.zzh(new zzedk(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    public FirebaseDatabase getDatabase() {
        return this.zzmkl.getDatabase();
    }

    public String getKey() {
        return this.zzmks.isEmpty() ? null : this.zzmks.zzbwk().asString();
    }

    public DatabaseReference getParent() {
        zzedk zzbwj = this.zzmks.zzbwj();
        return zzbwj != null ? new DatabaseReference(this.zzmkl, zzbwj) : null;
    }

    public DatabaseReference getRoot() {
        return new DatabaseReference(this.zzmkl, new zzedk(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public OnDisconnect onDisconnect() {
        zzelv.zzao(this.zzmks);
        return new OnDisconnect(this.zzmkl, this.zzmks);
    }

    public DatabaseReference push() {
        return new DatabaseReference(this.zzmkl, this.zzmks.zza(zzejg.zzpz(zzels.zzbz(this.zzmkl.zzbwn()))));
    }

    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue(null, completionListener);
    }

    public void runTransaction(Handler handler) {
        runTransaction(handler, true);
    }

    public void runTransaction(Handler handler, boolean z) {
        if (handler == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        zzelv.zzao(this.zzmks);
        this.zzmkl.zzo(new zzf(this, handler, z));
    }

    public Task<Void> setPriority(Object obj) {
        return zza(zzekj.zzc(this.zzmks, obj), null);
    }

    public void setPriority(Object obj, CompletionListener completionListener) {
        zza(zzekj.zzc(this.zzmks, obj), completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zza(obj, zzekj.zzc(this.zzmks, null), null);
    }

    public Task<Void> setValue(Object obj, Object obj2) {
        return zza(obj, zzekj.zzc(this.zzmks, obj2), null);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        zza(obj, zzekj.zzc(this.zzmks, null), completionListener);
    }

    public void setValue(Object obj, Object obj2, CompletionListener completionListener) {
        zza(obj, zzekj.zzc(this.zzmks, obj2), completionListener);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.zzmkl.toString();
        }
        String databaseReference;
        try {
            databaseReference = parent.toString();
            String replace = URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20");
            return new StringBuilder((String.valueOf(databaseReference).length() + 1) + String.valueOf(replace).length()).append(databaseReference).append("/").append(replace).toString();
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Failed to URLEncode key: ";
            databaseReference = String.valueOf(getKey());
            throw new DatabaseException(databaseReference.length() != 0 ? str.concat(databaseReference) : new String(str), th);
        }
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza((Map) map, null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        zza((Map) map, completionListener);
    }
}
