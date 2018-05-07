package com.google.firebase.database;

import com.google.android.gms.internal.zzecw;
import com.google.android.gms.internal.zzedh;
import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzedn;
import com.google.android.gms.internal.zzegf;
import com.google.android.gms.internal.zzegk;
import com.google.android.gms.internal.zzeih;
import com.google.android.gms.internal.zzeik;
import com.google.android.gms.internal.zzejf;
import com.google.android.gms.internal.zzejg;
import com.google.android.gms.internal.zzejt;
import com.google.android.gms.internal.zzeju;
import com.google.android.gms.internal.zzejx;
import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzekh;
import com.google.android.gms.internal.zzeki;
import com.google.android.gms.internal.zzekj;
import com.google.android.gms.internal.zzekl;
import com.google.android.gms.internal.zzekn;
import com.google.android.gms.internal.zzelt;
import com.google.android.gms.internal.zzelv;

public class Query {
    protected final zzedn zzmkl;
    protected final zzedk zzmks;
    private zzeih zzmkw;
    private final boolean zzmkx;

    Query(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmkl = com_google_android_gms_internal_zzedn;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmkw = zzeih.zznae;
        this.zzmkx = false;
    }

    private Query(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, zzeih com_google_android_gms_internal_zzeih, boolean z) throws DatabaseException {
        this.zzmkl = com_google_android_gms_internal_zzedn;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmkw = com_google_android_gms_internal_zzeih;
        this.zzmkx = z;
        boolean z2 = (com_google_android_gms_internal_zzeih.zzbyj() && com_google_android_gms_internal_zzeih.zzbym() && com_google_android_gms_internal_zzeih.zzbyp() && !com_google_android_gms_internal_zzeih.zzbyq()) ? false : true;
        zzelt.zzb(z2, "Validation of queries failed.");
    }

    private final Query zza(zzekd com_google_android_gms_internal_zzekd, String str) {
        zzelv.zzqj(str);
        if (!com_google_android_gms_internal_zzekd.zzbzu() && !com_google_android_gms_internal_zzekd.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (this.zzmkw.zzbyj()) {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        } else {
            zzeih zza = this.zzmkw.zza(com_google_android_gms_internal_zzekd, str != null ? zzejg.zzpz(str) : null);
            zzb(zza);
            zza(zza);
            return new Query(this.zzmkl, this.zzmks, zza, this.zzmkx);
        }
    }

    private final void zza(zzedh com_google_android_gms_internal_zzedh) {
        zzegk.zzbxf().zzj(com_google_android_gms_internal_zzedh);
        this.zzmkl.zzo(new zzq(this, com_google_android_gms_internal_zzedh));
    }

    private static void zza(zzeih com_google_android_gms_internal_zzeih) {
        if (com_google_android_gms_internal_zzeih.zzbyr().equals(zzejx.zzcal())) {
            zzekd zzbyk;
            String str = "You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported";
            if (com_google_android_gms_internal_zzeih.zzbyj()) {
                zzbyk = com_google_android_gms_internal_zzeih.zzbyk();
                if (!(com_google_android_gms_internal_zzeih.zzbyl() == zzejg.zzbzn() && (zzbyk instanceof zzekl))) {
                    throw new IllegalArgumentException(str);
                }
            }
            if (com_google_android_gms_internal_zzeih.zzbym()) {
                zzbyk = com_google_android_gms_internal_zzeih.zzbyn();
                if (com_google_android_gms_internal_zzeih.zzbyo() != zzejg.zzbzo() || !(zzbyk instanceof zzekl)) {
                    throw new IllegalArgumentException(str);
                }
            }
        } else if (!com_google_android_gms_internal_zzeih.zzbyr().equals(zzeki.zzcap())) {
        } else {
            if ((com_google_android_gms_internal_zzeih.zzbyj() && !zzekj.zzl(com_google_android_gms_internal_zzeih.zzbyk())) || (com_google_android_gms_internal_zzeih.zzbym() && !zzekj.zzl(com_google_android_gms_internal_zzeih.zzbyn()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    private final Query zzb(zzekd com_google_android_gms_internal_zzekd, String str) {
        zzelv.zzqj(str);
        if (com_google_android_gms_internal_zzekd.zzbzu() || com_google_android_gms_internal_zzekd.isEmpty()) {
            zzejg zzpz = str != null ? zzejg.zzpz(str) : null;
            if (this.zzmkw.zzbym()) {
                throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
            }
            zzeih zzb = this.zzmkw.zzb(com_google_android_gms_internal_zzekd, zzpz);
            zzb(zzb);
            zza(zzb);
            return new Query(this.zzmkl, this.zzmks, zzb, this.zzmkx);
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    private final void zzb(zzedh com_google_android_gms_internal_zzedh) {
        zzegk.zzbxf().zzi(com_google_android_gms_internal_zzedh);
        this.zzmkl.zzo(new zzr(this, com_google_android_gms_internal_zzedh));
    }

    private static void zzb(zzeih com_google_android_gms_internal_zzeih) {
        if (com_google_android_gms_internal_zzeih.zzbyj() && com_google_android_gms_internal_zzeih.zzbym() && com_google_android_gms_internal_zzeih.zzbyp() && !com_google_android_gms_internal_zzeih.zzbyq()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private final void zzbsw() {
        if (this.zzmkw.zzbyj()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        } else if (this.zzmkw.zzbym()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private final void zzbsx() {
        if (this.zzmkx) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    public ChildEventListener addChildEventListener(ChildEventListener childEventListener) {
        zzb(new zzecw(this.zzmkl, childEventListener, zzbsz()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(ValueEventListener valueEventListener) {
        zzb(new zzegf(this.zzmkl, new zzp(this, valueEventListener), zzbsz()));
    }

    public ValueEventListener addValueEventListener(ValueEventListener valueEventListener) {
        zzb(new zzegf(this.zzmkl, valueEventListener, zzbsz()));
        return valueEventListener;
    }

    public Query endAt(double d) {
        return endAt(d, null);
    }

    public Query endAt(double d, String str) {
        return zzb(new zzejt(Double.valueOf(d), zzeju.zzcaf()), str);
    }

    public Query endAt(String str) {
        return endAt(str, null);
    }

    public Query endAt(String str, String str2) {
        return zzb(str != null ? new zzekl(str, zzeju.zzcaf()) : zzeju.zzcaf(), str2);
    }

    public Query endAt(boolean z) {
        return endAt(z, null);
    }

    public Query endAt(boolean z, String str) {
        return zzb(new zzejf(Boolean.valueOf(z), zzeju.zzcaf()), str);
    }

    public Query equalTo(double d) {
        zzbsw();
        return startAt(d).endAt(d);
    }

    public Query equalTo(double d, String str) {
        zzbsw();
        return startAt(d, str).endAt(d, str);
    }

    public Query equalTo(String str) {
        zzbsw();
        return startAt(str).endAt(str);
    }

    public Query equalTo(String str, String str2) {
        zzbsw();
        return startAt(str, str2).endAt(str, str2);
    }

    public Query equalTo(boolean z) {
        zzbsw();
        return startAt(z).endAt(z);
    }

    public Query equalTo(boolean z, String str) {
        zzbsw();
        return startAt(z, str).endAt(z, str);
    }

    public DatabaseReference getRef() {
        return new DatabaseReference(this.zzmkl, this.zzmks);
    }

    public void keepSynced(boolean z) {
        if (this.zzmks.isEmpty() || !this.zzmks.zzbwh().equals(zzejg.zzbzq())) {
            this.zzmkl.zzo(new zzs(this, z));
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.zzmkw.zzbyp()) {
            return new Query(this.zzmkl, this.zzmks, this.zzmkw.zzgr(i), this.zzmkx);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.zzmkw.zzbyp()) {
            return new Query(this.zzmkl, this.zzmks, this.zzmkw.zzgs(i), this.zzmkx);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query orderByChild(String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        } else if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 54).append("Can't use '").append(str).append("' as path, please use orderByKey() instead!").toString());
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("Can't use '").append(str).append("' as path, please use orderByPriority() instead!").toString());
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 56).append("Can't use '").append(str).append("' as path, please use orderByValue() instead!").toString());
        } else {
            zzelv.zzqh(str);
            zzbsx();
            zzedk com_google_android_gms_internal_zzedk = new zzedk(str);
            if (com_google_android_gms_internal_zzedk.size() == 0) {
                throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
            }
            return new Query(this.zzmkl, this.zzmks, this.zzmkw.zza(new zzekh(com_google_android_gms_internal_zzedk)), true);
        }
    }

    public Query orderByKey() {
        zzbsx();
        zzeih zza = this.zzmkw.zza(zzejx.zzcal());
        zza(zza);
        return new Query(this.zzmkl, this.zzmks, zza, true);
    }

    public Query orderByPriority() {
        zzbsx();
        zzeih zza = this.zzmkw.zza(zzeki.zzcap());
        zza(zza);
        return new Query(this.zzmkl, this.zzmks, zza, true);
    }

    public Query orderByValue() {
        zzbsx();
        return new Query(this.zzmkl, this.zzmks, this.zzmkw.zza(zzekn.zzcaq()), true);
    }

    public void removeEventListener(ChildEventListener childEventListener) {
        if (childEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza(new zzecw(this.zzmkl, childEventListener, zzbsz()));
    }

    public void removeEventListener(ValueEventListener valueEventListener) {
        if (valueEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza(new zzegf(this.zzmkl, valueEventListener, zzbsz()));
    }

    public Query startAt(double d) {
        return startAt(d, null);
    }

    public Query startAt(double d, String str) {
        return zza(new zzejt(Double.valueOf(d), zzeju.zzcaf()), str);
    }

    public Query startAt(String str) {
        return startAt(str, null);
    }

    public Query startAt(String str, String str2) {
        return zza(str != null ? new zzekl(str, zzeju.zzcaf()) : zzeju.zzcaf(), str2);
    }

    public Query startAt(boolean z) {
        return startAt(z, null);
    }

    public Query startAt(boolean z, String str) {
        return zza(new zzejf(Boolean.valueOf(z), zzeju.zzcaf()), str);
    }

    public final zzedk zzbsy() {
        return this.zzmks;
    }

    public final zzeik zzbsz() {
        return new zzeik(this.zzmks, this.zzmkw);
    }
}
