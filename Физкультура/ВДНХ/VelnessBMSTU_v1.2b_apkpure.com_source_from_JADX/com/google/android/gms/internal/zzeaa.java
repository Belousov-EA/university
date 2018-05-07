package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.database.DatabaseException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzeaa implements zzegz {
    private static final Charset zzfhj = Charset.forName("UTF-8");
    private final SQLiteDatabase zzmlq;
    private final zzejc zzmlr;
    private boolean zzmls;
    private long zzmlt = 0;

    public zzeaa(Context context, zzedc com_google_android_gms_internal_zzedc, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("Persistence");
            this.zzmlq = zzal(context, encode);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static int zza(zzedk com_google_android_gms_internal_zzedk, List<String> list, int i) {
        int i2 = i + 1;
        String zzc = zzc(com_google_android_gms_internal_zzedk);
        if (((String) list.get(i)).startsWith(zzc)) {
            while (i2 < list.size() && ((String) list.get(i2)).equals(zza(com_google_android_gms_internal_zzedk, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                String valueOf = String.valueOf(zzc);
                zzc = String.valueOf(".part-");
                if (str.startsWith(zzc.length() != 0 ? valueOf.concat(zzc) : new String(valueOf))) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private final int zza(String str, zzedk com_google_android_gms_internal_zzedk) {
        String zzpi = zzpi(zzc(com_google_android_gms_internal_zzedk));
        return this.zzmlq.delete(str, "path >= ? AND path < ?", new String[]{r1, zzpi});
    }

    private final Cursor zza(zzedk com_google_android_gms_internal_zzedk, String[] strArr) {
        String zzc = zzc(com_google_android_gms_internal_zzedk);
        String zzpi = zzpi(zzc);
        String[] strArr2 = new String[(com_google_android_gms_internal_zzedk.size() + 3)];
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("(");
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        while (!com_google_android_gms_internal_zzedk2.isEmpty()) {
            stringBuilder.append("path");
            stringBuilder.append(" = ? OR ");
            strArr2[i] = zzc(com_google_android_gms_internal_zzedk2);
            com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk2.zzbwj();
            i++;
        }
        stringBuilder.append("path");
        stringBuilder.append(" = ?)");
        strArr2[i] = zzc(zzedk.zzbwe());
        String valueOf = String.valueOf(stringBuilder.toString());
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[com_google_android_gms_internal_zzedk.size() + 1] = zzc;
        strArr2[com_google_android_gms_internal_zzedk.size() + 2] = zzpi;
        return this.zzmlq.query("serverCache", strArr, concat, strArr2, null, null, "path");
    }

    private static String zza(zzedk com_google_android_gms_internal_zzedk, int i) {
        String valueOf = String.valueOf(zzc(com_google_android_gms_internal_zzedk));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, long j, String str, byte[] bArr) {
        zzbtf();
        this.zzmlq.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List zzf = zzf(bArr, 262144);
            for (int i = 0; i < zzf.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", zzc(com_google_android_gms_internal_zzedk));
                contentValues.put("type", str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[]) zzf.get(i));
                this.zzmlq.insertWithOnConflict("writes", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j));
        contentValues2.put("path", zzc(com_google_android_gms_internal_zzedk));
        contentValues2.put("type", str);
        contentValues2.put("part", null);
        contentValues2.put("node", bArr);
        this.zzmlq.insertWithOnConflict("writes", null, contentValues2, 5);
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, zzedk com_google_android_gms_internal_zzedk2, zzehm<Long> com_google_android_gms_internal_zzehm_java_lang_Long, zzehm<Long> com_google_android_gms_internal_zzehm_java_lang_Long2, zzeha com_google_android_gms_internal_zzeha, List<zzelq<zzedk, zzekd>> list) {
        if (com_google_android_gms_internal_zzehm_java_lang_Long.getValue() != null) {
            if (((Integer) com_google_android_gms_internal_zzeha.zza(Integer.valueOf(0), new zzeab(this, com_google_android_gms_internal_zzehm_java_lang_Long2))).intValue() > 0) {
                zzedk zzh = com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2);
                if (this.zzmlr.zzbzl()) {
                    this.zzmlr.zzb(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(r0), zzh}), null, new Object[0]);
                }
                com_google_android_gms_internal_zzeha.zza(null, new zzeac(this, com_google_android_gms_internal_zzehm_java_lang_Long2, list, com_google_android_gms_internal_zzedk2, zzb(zzh)));
                return;
            }
            return;
        }
        Iterator it = com_google_android_gms_internal_zzehm_java_lang_Long.zzbxx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            zzeha zzd = com_google_android_gms_internal_zzeha.zzd((zzejg) entry.getKey());
            zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzedk2.zza(com_google_android_gms_internal_zzejg), (zzehm) entry.getValue(), com_google_android_gms_internal_zzehm_java_lang_Long2.zze(com_google_android_gms_internal_zzejg), zzd, list);
        }
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            i = 0;
            i2 = 0;
            for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
                i2 += zza("serverCache", com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()));
                i = zzc(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()), com_google_android_gms_internal_zzekc.zzbsv()) + i;
            }
        } else {
            i2 = zza("serverCache", com_google_android_gms_internal_zzedk);
            i = zzc(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_google_android_gms_internal_zzedk.toString(), Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    private static SQLiteDatabase zzal(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new zzead(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (Throwable e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private static zzekd zzan(byte[] bArr) {
        try {
            return zzekg.zza(zzelh.zzqc(new String(bArr, zzfhj)), zzeju.zzcaf());
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, zzfhj));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }

    private static byte[] zzar(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        Object obj = new byte[i];
        i = 0;
        for (byte[] length2 : list) {
            System.arraycopy(length2, 0, obj, i, length2.length);
            i = length2.length + i;
        }
        return obj;
    }

    private final zzekd zzb(zzedk com_google_android_gms_internal_zzedk) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor zza = zza(com_google_android_gms_internal_zzedk, new String[]{"path", Param.VALUE});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (zza.moveToNext()) {
            try {
                arrayList.add(zza.getString(0));
                arrayList2.add(zza.getBlob(1));
            } finally {
                zza.close();
            }
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        zzekd zzcaf = zzeju.zzcaf();
        Object obj = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < arrayList2.size()) {
            int zza2;
            zzedk com_google_android_gms_internal_zzedk2;
            zzekd zzan;
            Object obj2;
            zzekd com_google_android_gms_internal_zzekd;
            if (((String) arrayList.get(i)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i);
                zzedk com_google_android_gms_internal_zzedk3 = new zzedk(str.substring(0, str.length() - 10));
                zza2 = zza(com_google_android_gms_internal_zzedk3, arrayList, i);
                if (this.zzmlr.zzbzl()) {
                    this.zzmlr.zzb("Loading split node with " + zza2 + " parts.", null, new Object[0]);
                }
                zza2 = (i + zza2) - 1;
                com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk3;
                zzan = zzan(zzar(arrayList2.subList(i, i + zza2)));
            } else {
                zzekd zzan2 = zzan((byte[]) arrayList2.get(i));
                zzedk com_google_android_gms_internal_zzedk4 = new zzedk((String) arrayList.get(i));
                zzan = zzan2;
                zza2 = i;
                com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk4;
            }
            if (com_google_android_gms_internal_zzedk2.zzbwk() != null && com_google_android_gms_internal_zzedk2.zzbwk().zzbzr()) {
                hashMap.put(com_google_android_gms_internal_zzedk2, zzan);
                obj2 = obj;
                com_google_android_gms_internal_zzekd = zzcaf;
            } else if (com_google_android_gms_internal_zzedk2.zzi(com_google_android_gms_internal_zzedk)) {
                zzelt.zzb(obj == null, "Descendants of path must come after ancestors.");
                Object obj3 = obj;
                com_google_android_gms_internal_zzekd = zzan.zzan(zzedk.zza(com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzedk));
                obj2 = obj3;
            } else if (com_google_android_gms_internal_zzedk.zzi(com_google_android_gms_internal_zzedk2)) {
                obj2 = 1;
                com_google_android_gms_internal_zzekd = zzcaf.zzl(zzedk.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzedk2), zzan);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzedk}));
            }
            i = zza2 + 1;
            zzcaf = com_google_android_gms_internal_zzekd;
            obj = obj2;
        }
        for (Entry entry : hashMap.entrySet()) {
            zzcaf = zzcaf.zzl(zzedk.zza(com_google_android_gms_internal_zzedk, (zzedk) entry.getKey()), (zzekd) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(zzelo.zzo(zzcaf)), com_google_android_gms_internal_zzedk, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), null, new Object[0]);
        }
        return zzcaf;
    }

    private static byte[] zzbe(Object obj) {
        try {
            return zzelh.zzbt(obj).getBytes(zzfhj);
        } catch (Throwable e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private final void zzbtf() {
        zzelt.zzb(this.zzmls, "Transaction expected to already be in progress.");
    }

    private final int zzc(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        long zzn = zzelo.zzn(com_google_android_gms_internal_zzekd);
        if (!(com_google_android_gms_internal_zzekd instanceof zzeji) || zzn <= PlaybackStateCompat.ACTION_PREPARE) {
            zzd(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
            return 1;
        }
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{com_google_android_gms_internal_zzedk, Long.valueOf(zzn), Integer.valueOf(16384)}), null, new Object[0]);
        }
        int i = 0;
        for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
            i = zzc(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()), com_google_android_gms_internal_zzekc.zzbsv()) + i;
        }
        if (!com_google_android_gms_internal_zzekd.zzbzv().isEmpty()) {
            zzd(com_google_android_gms_internal_zzedk.zza(zzejg.zzbzp()), com_google_android_gms_internal_zzekd.zzbzv());
            i++;
        }
        zzd(com_google_android_gms_internal_zzedk, zzeju.zzcaf());
        return i + 1;
    }

    private static String zzc(zzedk com_google_android_gms_internal_zzedk) {
        return com_google_android_gms_internal_zzedk.isEmpty() ? "/" : String.valueOf(com_google_android_gms_internal_zzedk.toString()).concat("/");
    }

    private final void zzd(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        byte[] zzbe = zzbe(com_google_android_gms_internal_zzekd.getValue(true));
        if (zzbe.length >= 262144) {
            List zzf = zzf(zzbe, 262144);
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Saving huge leaf node with " + zzf.size() + " parts.", null, new Object[0]);
            }
            for (int i = 0; i < zzf.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", zza(com_google_android_gms_internal_zzedk, i));
                contentValues.put(Param.VALUE, (byte[]) zzf.get(i));
                this.zzmlq.insertWithOnConflict("serverCache", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", zzc(com_google_android_gms_internal_zzedk));
        contentValues2.put(Param.VALUE, zzbe);
        this.zzmlq.insertWithOnConflict("serverCache", null, contentValues2, 5);
    }

    private static List<byte[]> zzf(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / 262144) + 1;
        List<byte[]> arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(262144, bArr.length - (i2 * 262144));
            Object obj = new byte[min];
            System.arraycopy(bArr, i2 * 262144, obj, 0, min);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private static String zzpi(String str) {
        String substring = str.substring(0, str.length() - 1);
        return new StringBuilder(String.valueOf(substring).length() + 1).append(substring).append('0').toString();
    }

    private static String zzr(Collection<Long> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue2);
            obj = null;
        }
        return stringBuilder.toString();
    }

    public final void beginTransaction() {
        zzelt.zzb(!this.zzmls, "runInTransaction called when an existing transaction is already in progress.");
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Starting transaction.", null, new Object[0]);
        }
        this.zzmlq.beginTransaction();
        this.zzmls = true;
        this.zzmlt = System.currentTimeMillis();
    }

    public final void endTransaction() {
        this.zzmlq.endTransaction();
        this.zzmls = false;
        long currentTimeMillis = System.currentTimeMillis() - this.zzmlt;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    public final void setTransactionSuccessful() {
        this.zzmlq.setTransactionSuccessful();
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk) {
        return zzb(com_google_android_gms_internal_zzedk);
    }

    public final void zza(long j, Set<zzejg> set) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.zzmlq.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (zzejg com_google_android_gms_internal_zzejg : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzejg.asString());
            this.zzmlq.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(long j, Set<zzejg> set, Set<zzejg> set2) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (zzejg com_google_android_gms_internal_zzejg : set2) {
            this.zzmlq.delete("trackedKeys", str, new String[]{valueOf, com_google_android_gms_internal_zzejg.asString()});
        }
        for (zzejg com_google_android_gms_internal_zzejg2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzejg2.asString());
            this.zzmlq.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += zza("serverCache", com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()));
            i2 = zzc(com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()), (zzekd) entry.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), com_google_android_gms_internal_zzedk.toString(), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        long j2 = j;
        zza(com_google_android_gms_internal_zzedk2, j2, "m", zzbe(com_google_android_gms_internal_zzecy.zzcn(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzeha com_google_android_gms_internal_zzeha) {
        if (com_google_android_gms_internal_zzeha.zzbxs()) {
            zzbtf();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor zza = zza(com_google_android_gms_internal_zzedk, new String[]{"rowid", "path"});
            zzehm com_google_android_gms_internal_zzehm = new zzehm(null);
            zzehm com_google_android_gms_internal_zzehm2 = new zzehm(null);
            while (zza.moveToNext()) {
                long j = zza.getLong(0);
                zzedk com_google_android_gms_internal_zzedk2 = new zzedk(zza.getString(1));
                zzejc com_google_android_gms_internal_zzejc;
                String valueOf;
                String valueOf2;
                if (com_google_android_gms_internal_zzedk.zzi(com_google_android_gms_internal_zzedk2)) {
                    zzedk zza2 = zzedk.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzedk2);
                    if (com_google_android_gms_internal_zzeha.zzv(zza2)) {
                        com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zzb(zza2, Long.valueOf(j));
                    } else if (com_google_android_gms_internal_zzeha.zzw(zza2)) {
                        com_google_android_gms_internal_zzehm2 = com_google_android_gms_internal_zzehm2.zzb(zza2, Long.valueOf(j));
                    } else {
                        com_google_android_gms_internal_zzejc = this.zzmlr;
                        valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
                        valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk2);
                        com_google_android_gms_internal_zzejc.zze(new StringBuilder((String.valueOf(valueOf).length() + 88) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" and have data at ").append(valueOf2).append(" that isn't marked for pruning or keeping. Ignoring.").toString(), null);
                    }
                } else {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
                    valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk2);
                    com_google_android_gms_internal_zzejc.zze(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString(), null);
                }
            }
            int i = 0;
            int i2 = 0;
            if (!com_google_android_gms_internal_zzehm.isEmpty()) {
                List arrayList = new ArrayList();
                zza(com_google_android_gms_internal_zzedk, zzedk.zzbwe(), com_google_android_gms_internal_zzehm, com_google_android_gms_internal_zzehm2, com_google_android_gms_internal_zzeha, arrayList);
                Collection values = com_google_android_gms_internal_zzehm.values();
                String zzr = zzr(values);
                this.zzmlq.delete("serverCache", new StringBuilder(String.valueOf(zzr).length() + 11).append("rowid IN (").append(zzr).append(")").toString(), null);
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    int i4 = i3 + 1;
                    zzelq com_google_android_gms_internal_zzelq = (zzelq) arrayList2.get(i3);
                    zzc(com_google_android_gms_internal_zzedk.zzh((zzedk) com_google_android_gms_internal_zzelq.getFirst()), (zzekd) com_google_android_gms_internal_zzelq.zzcbg());
                    i3 = i4;
                }
                i = values.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
            }
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
        zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, false);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        long j2 = j;
        zza(com_google_android_gms_internal_zzedk2, j2, "o", zzbe(com_google_android_gms_internal_zzekd.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzehe com_google_android_gms_internal_zzehe) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(com_google_android_gms_internal_zzehe.id));
        contentValues.put("path", zzc(com_google_android_gms_internal_zzehe.zzmyn.zzbsy()));
        contentValues.put("queryParams", com_google_android_gms_internal_zzehe.zzmyn.zzbyy().zzbyw());
        contentValues.put("lastUse", Long.valueOf(com_google_android_gms_internal_zzehe.zzmyo));
        contentValues.put("complete", Boolean.valueOf(com_google_android_gms_internal_zzehe.complete));
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzehe.zziyi));
        this.zzmlq.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    public final void zzb(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
        zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, true);
    }

    public final void zzbl(long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzmlq.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    public final void zzbm(long j) {
        zzbtf();
        String valueOf = String.valueOf(j);
        this.zzmlq.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.zzmlq.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public final void zzbn(long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.zzmlq.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final Set<zzejg> zzbo(long j) {
        return zze(Collections.singleton(Long.valueOf(j)));
    }

    public final List<zzegd> zzbtb() {
        String[] strArr = new String[]{"id", "path", "type", "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzmlq.query("writes", strArr, null, null, null, null, "id, part");
        List<zzegd> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                byte[] blob;
                Object com_google_android_gms_internal_zzegd;
                long j = query.getLong(0);
                zzedk com_google_android_gms_internal_zzedk = new zzedk(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    blob = query.getBlob(4);
                } else {
                    List arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    blob = zzar(arrayList2);
                }
                Object zzqc = zzelh.zzqc(new String(blob, zzfhj));
                if ("o".equals(string)) {
                    com_google_android_gms_internal_zzegd = new zzegd(j, com_google_android_gms_internal_zzedk, zzekg.zza(zzqc, zzeju.zzcaf()), true);
                } else if ("m".equals(string)) {
                    com_google_android_gms_internal_zzegd = new zzegd(j, com_google_android_gms_internal_zzedk, zzecy.zzak((Map) zzqc));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(com_google_android_gms_internal_zzegd);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final long zzbtc() {
        long j = null;
        Cursor rawQuery = this.zzmlq.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{Param.VALUE, "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                return j;
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public final List<zzehe> zzbtd() {
        String[] strArr = new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzmlq.query("trackedQueries", strArr, null, null, null, null, "id");
        List<zzehe> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzehe(query.getLong(0), new zzeik(new zzedk(query.getString(1)), zzeih.zzam(zzelh.zzqb(query.getString(2)))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final void zzbte() {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzmlq.delete("writes", null, null);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    public final Set<zzejg> zze(Set<Long> set) {
        String[] strArr = new String[]{"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id IN (";
        String zzr = zzr(set);
        Cursor query = this.zzmlq.query(true, "trackedKeys", strArr, new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(zzr).length()).append(str).append(zzr).append(")").toString(), null, null, null, null, null);
        Set<zzejg> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(zzejg.zzpz(query.getString(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return hashSet;
    }
}
