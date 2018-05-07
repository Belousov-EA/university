package com.google.android.gms.internal;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.zzh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzedn implements zzebn {
    private final zzeeq zzmkj;
    private zzebm zzmqr;
    private final zzelp zzmsr = new zzelp(new zzelj(), 0);
    private zzefa zzmss;
    private zzefb zzmst;
    private zzehs<List<zzeeo>> zzmsu;
    private boolean zzmsv = false;
    private final zzeif zzmsw;
    private final zzedc zzmsx;
    private final zzejc zzmsy;
    private final zzejc zzmsz;
    private final zzejc zzmta;
    private long zzmtb = 0;
    private long zzmtc = 1;
    private zzefh zzmtd;
    private zzefh zzmte;
    private FirebaseDatabase zzmtf;
    private boolean zzmtg = false;
    private long zzmth = 0;

    zzedn(zzeeq com_google_android_gms_internal_zzeeq, zzedc com_google_android_gms_internal_zzedc, FirebaseDatabase firebaseDatabase) {
        this.zzmkj = com_google_android_gms_internal_zzeeq;
        this.zzmsx = com_google_android_gms_internal_zzedc;
        this.zzmtf = firebaseDatabase;
        this.zzmsy = this.zzmsx.zzpv("RepoOperation");
        this.zzmsz = this.zzmsx.zzpv("Transaction");
        this.zzmta = this.zzmsx.zzpv("DataOperation");
        this.zzmsw = new zzeif(this.zzmsx);
        zzo(new zzedo(this));
    }

    private final zzekd zza(zzedk com_google_android_gms_internal_zzedk, List<Long> list) {
        zzekd zzc = this.zzmte.zzc(com_google_android_gms_internal_zzedk, list);
        return zzc == null ? zzeju.zzcaf() : zzc;
    }

    private final void zza(long j, zzedk com_google_android_gms_internal_zzedk, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List zza = this.zzmte.zza(j, !(databaseError == null), true, this.zzmsr);
            if (zza.size() > 0) {
                zzn(com_google_android_gms_internal_zzedk);
            }
            zzau(zza);
        }
    }

    private final void zza(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        if (((List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue()) != null) {
            Boolean valueOf;
            List<zzeeo> zzc = zzc((zzehs) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo);
            Boolean valueOf2 = Boolean.valueOf(true);
            for (zzeeo zzc2 : zzc) {
                if (zzc2.zzmuj != zzeep.zzmus) {
                    valueOf = Boolean.valueOf(false);
                    break;
                }
            }
            valueOf = valueOf2;
            if (valueOf.booleanValue()) {
                zzedk zzbsy = com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zzbsy();
                List arrayList = new ArrayList();
                for (zzeeo zzc22 : zzc) {
                    arrayList.add(Long.valueOf(zzc22.zzmun));
                }
                zzekd zza = zza(zzbsy, arrayList);
                String zzbzt = zza.zzbzt();
                zzekd com_google_android_gms_internal_zzekd = zza;
                for (zzeeo zzc222 : zzc) {
                    zzc222.zzmuj = zzeep.zzmut;
                    zzc222.retryCount = zzc222.retryCount + 1;
                    com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd.zzl(zzedk.zza(zzbsy, zzc222.zzmks), zzc222.zzmup);
                }
                this.zzmqr.zza(zzbsy.zzbwg(), com_google_android_gms_internal_zzekd.getValue(true), zzbzt, new zzedv(this, zzbsy, zzc, this));
            }
        } else if (com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.hasChildren()) {
            com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzedu(this));
        }
    }

    private final void zza(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo, int i) {
        List list = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        List arrayList = new ArrayList();
        if (list != null) {
            DatabaseError zzpg;
            int i2;
            List arrayList2 = new ArrayList();
            if (i == -9) {
                zzpg = DatabaseError.zzpg("overriddenBySet");
            } else {
                zzelt.zzb(i == -25, "Unknown transaction abort reason: " + i);
                zzpg = DatabaseError.zzgp(-25);
            }
            int i3 = 0;
            int i4 = -1;
            while (i3 < list.size()) {
                zzeeo com_google_android_gms_internal_zzeeo = (zzeeo) list.get(i3);
                if (com_google_android_gms_internal_zzeeo.zzmuj != zzeep.zzmuv) {
                    if (com_google_android_gms_internal_zzeeo.zzmuj == zzeep.zzmut) {
                        com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuv;
                        com_google_android_gms_internal_zzeeo.zzmum = zzpg;
                        i2 = i3;
                        i3++;
                        i4 = i2;
                    } else {
                        zze(new zzegf(this, com_google_android_gms_internal_zzeeo.zzmui, zzeik.zzam(com_google_android_gms_internal_zzeeo.zzmks)));
                        if (i == -9) {
                            arrayList.addAll(this.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, this.zzmsr));
                        } else {
                            zzelt.zzb(i == -25, "Unknown transaction abort reason: " + i);
                        }
                        arrayList2.add(new zzeee(this, com_google_android_gms_internal_zzeeo, zzpg));
                    }
                }
                i2 = i4;
                i3++;
                i4 = i2;
            }
            if (i4 == -1) {
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.setValue(null);
            } else {
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.setValue(list.subList(0, i4 + 1));
            }
            zzau(arrayList);
            ArrayList arrayList3 = (ArrayList) arrayList2;
            int size = arrayList3.size();
            i2 = 0;
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                zzm((Runnable) obj);
            }
        }
    }

    private final void zza(zzejg com_google_android_gms_internal_zzejg, Object obj) {
        if (com_google_android_gms_internal_zzejg.equals(zzedb.zzmrz)) {
            this.zzmsr.zzby(((Long) obj).longValue());
        }
        zzedk com_google_android_gms_internal_zzedk = new zzedk(zzedb.zzmry, com_google_android_gms_internal_zzejg);
        try {
            zzekd zza = zzekg.zza(obj, zzeju.zzcaf());
            this.zzmss.zzg(com_google_android_gms_internal_zzedk, zza);
            zzau(this.zzmtd.zzi(com_google_android_gms_internal_zzedk, zza));
        } catch (Throwable e) {
            this.zzmsy.zzd("Failed to parse info update", e);
        }
    }

    private final void zza(String str, zzedk com_google_android_gms_internal_zzedk, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk.toString();
            String databaseError2 = databaseError.toString();
            com_google_android_gms_internal_zzejc.zze(new StringBuilder(((String.valueOf(str).length() + 13) + String.valueOf(com_google_android_gms_internal_zzedk2).length()) + String.valueOf(databaseError2).length()).append(str).append(" at ").append(com_google_android_gms_internal_zzedk2).append(" failed: ").append(databaseError2).toString(), null);
        }
    }

    private final void zza(List<zzeeo> list, zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        List list2 = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        if (list2 != null) {
            list.addAll(list2);
        }
        com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzeeb(this, list));
    }

    private final void zzau(List<? extends zzeib> list) {
        if (!list.isEmpty()) {
            this.zzmsw.zzaw(list);
        }
    }

    private final zzedk zzb(zzedk com_google_android_gms_internal_zzedk, int i) {
        zzedk zzbsy = zzo(com_google_android_gms_internal_zzedk).zzbsy();
        if (this.zzmsz.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(zzbsy);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), null, new Object[0]);
        }
        zzehs zzak = this.zzmsu.zzak(com_google_android_gms_internal_zzedk);
        zzak.zza(new zzeec(this, i), false);
        zza(zzak, i);
        zzak.zza(new zzeed(this, i), false, false);
        return zzbsy;
    }

    private final void zzb(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        List list = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (((zzeeo) list.get(i)).zzmuj == zzeep.zzmuu) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            if (list.size() > 0) {
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.setValue(list);
            } else {
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.setValue(null);
            }
        }
        com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzedx(this));
    }

    private static DatabaseError zzbe(String str, String str2) {
        return str != null ? DatabaseError.zzbc(str, str2) : null;
    }

    private final void zzbwl() {
        this.zzmqr = this.zzmsx.zza(new zzebk(this.zzmkj.host, this.zzmkj.zzjrg, this.zzmkj.secure), this);
        this.zzmsx.zzmsd.zza(new zzeea(this));
        this.zzmqr.initialize();
        zzegy zzpw = this.zzmsx.zzpw(this.zzmkj.host);
        this.zzmss = new zzefa();
        this.zzmst = new zzefb();
        this.zzmsu = new zzehs();
        this.zzmtd = new zzefh(this.zzmsx, new zzegx(), new zzeef(this));
        this.zzmte = new zzefh(this.zzmsx, zzpw, new zzeeh(this));
        List<zzegd> zzbtb = zzpw.zzbtb();
        Map zza = zzeex.zza(this.zzmsr);
        long j = Long.MIN_VALUE;
        for (zzegd com_google_android_gms_internal_zzegd : zzbtb) {
            zzece com_google_android_gms_internal_zzeej = new zzeej(this, com_google_android_gms_internal_zzegd);
            if (j >= com_google_android_gms_internal_zzegd.zzbwy()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long zzbwy = com_google_android_gms_internal_zzegd.zzbwy();
            this.zzmtc = com_google_android_gms_internal_zzegd.zzbwy() + 1;
            if (com_google_android_gms_internal_zzegd.zzbxb()) {
                if (this.zzmsy.zzbzl()) {
                    this.zzmsy.zzb("Restoring overwrite with id " + com_google_android_gms_internal_zzegd.zzbwy(), null, new Object[0]);
                }
                this.zzmqr.zza(com_google_android_gms_internal_zzegd.zzbsy().zzbwg(), com_google_android_gms_internal_zzegd.zzbwz().getValue(true), com_google_android_gms_internal_zzeej);
                this.zzmte.zza(com_google_android_gms_internal_zzegd.zzbsy(), com_google_android_gms_internal_zzegd.zzbwz(), zzeex.zza(com_google_android_gms_internal_zzegd.zzbwz(), zza), com_google_android_gms_internal_zzegd.zzbwy(), true, false);
                j = zzbwy;
            } else {
                if (this.zzmsy.zzbzl()) {
                    this.zzmsy.zzb("Restoring merge with id " + com_google_android_gms_internal_zzegd.zzbwy(), null, new Object[0]);
                }
                this.zzmqr.zza(com_google_android_gms_internal_zzegd.zzbsy().zzbwg(), com_google_android_gms_internal_zzegd.zzbxa().zzcn(true), com_google_android_gms_internal_zzeej);
                this.zzmte.zza(com_google_android_gms_internal_zzegd.zzbsy(), com_google_android_gms_internal_zzegd.zzbxa(), zzeex.zza(com_google_android_gms_internal_zzegd.zzbxa(), zza), com_google_android_gms_internal_zzegd.zzbwy(), false);
                j = zzbwy;
            }
        }
        zza(zzedb.zzmsa, Boolean.valueOf(false));
        zza(zzedb.zzmsb, Boolean.valueOf(false));
    }

    private final long zzbwp() {
        long j = this.zzmtc;
        this.zzmtc = 1 + j;
        return j;
    }

    private final void zzbwq() {
        zzehs com_google_android_gms_internal_zzehs = this.zzmsu;
        zzb(com_google_android_gms_internal_zzehs);
        zza(com_google_android_gms_internal_zzehs);
    }

    private final List<zzeeo> zzc(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        List arrayList = new ArrayList();
        zza(arrayList, (zzehs) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo);
        Collections.sort(arrayList);
        return arrayList;
    }

    private final zzedk zzn(zzedk com_google_android_gms_internal_zzedk) {
        zzehs zzo = zzo(com_google_android_gms_internal_zzedk);
        zzedk zzbsy = zzo.zzbsy();
        List<zzeeo> zzc = zzc(zzo);
        if (!zzc.isEmpty()) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (zzeeo zzb : zzc) {
                arrayList2.add(Long.valueOf(zzb.zzmun));
            }
            for (zzeeo com_google_android_gms_internal_zzeeo : zzc) {
                Object obj;
                DatabaseError zzj;
                zzedk.zza(zzbsy, com_google_android_gms_internal_zzeeo.zzmks);
                ArrayList arrayList3 = new ArrayList();
                if (com_google_android_gms_internal_zzeeo.zzmuj == zzeep.zzmuw) {
                    obj = 1;
                    zzj = com_google_android_gms_internal_zzeeo.zzmum;
                    if (zzj.getCode() != -25) {
                        arrayList3.addAll(this.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, this.zzmsr));
                    }
                } else if (com_google_android_gms_internal_zzeeo.zzmuj != zzeep.zzmus) {
                    zzj = null;
                    obj = null;
                } else if (com_google_android_gms_internal_zzeeo.retryCount >= 25) {
                    obj = 1;
                    zzj = DatabaseError.zzpg("maxretries");
                    arrayList3.addAll(this.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, this.zzmsr));
                } else {
                    Result doTransaction;
                    zzekd zza = zza(com_google_android_gms_internal_zzeeo.zzmks, arrayList2);
                    com_google_android_gms_internal_zzeeo.zzmuo = zza;
                    try {
                        doTransaction = com_google_android_gms_internal_zzeeo.zzmuh.doTransaction(zzh.zza(zza));
                        zzj = null;
                    } catch (Throwable th) {
                        DatabaseError fromException = DatabaseError.fromException(th);
                        doTransaction = Transaction.abort();
                        zzj = fromException;
                    }
                    if (doTransaction.isSuccess()) {
                        Long valueOf = Long.valueOf(com_google_android_gms_internal_zzeeo.zzmun);
                        Map zza2 = zzeex.zza(this.zzmsr);
                        zzekd zzbsv = doTransaction.zzbsv();
                        zzekd zza3 = zzeex.zza(zzbsv, zza2);
                        com_google_android_gms_internal_zzeeo.zzmup = zzbsv;
                        com_google_android_gms_internal_zzeeo.zzmuq = zza3;
                        com_google_android_gms_internal_zzeeo.zzmun = zzbwp();
                        arrayList2.remove(valueOf);
                        arrayList3.addAll(this.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmks, zzbsv, zza3, com_google_android_gms_internal_zzeeo.zzmun, com_google_android_gms_internal_zzeeo.zzmul, false));
                        arrayList3.addAll(this.zzmte.zza(valueOf.longValue(), true, false, this.zzmsr));
                        zzj = null;
                        obj = null;
                    } else {
                        obj = 1;
                        arrayList3.addAll(this.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, this.zzmsr));
                    }
                }
                zzau(arrayList3);
                if (obj != null) {
                    com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                    DataSnapshot zza4 = zzh.zza(zzh.zza(this, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo));
                    zzo(new zzedy(this, com_google_android_gms_internal_zzeeo));
                    arrayList.add(new zzedz(this, com_google_android_gms_internal_zzeeo, zzj, zza4));
                }
            }
            zzb(this.zzmsu);
            for (int i = 0; i < arrayList.size(); i++) {
                zzm((Runnable) arrayList.get(i));
            }
            zzbwq();
        }
        return zzbsy;
    }

    private final zzehs<List<zzeeo>> zzo(zzedk com_google_android_gms_internal_zzedk) {
        zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo = this.zzmsu;
        while (!com_google_android_gms_internal_zzedk.isEmpty() && com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue() == null) {
            com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo = com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zzak(new zzedk(com_google_android_gms_internal_zzedk.zzbwh()));
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
        }
        return com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo;
    }

    public final FirebaseDatabase getDatabase() {
        return this.zzmtf;
    }

    final void interrupt() {
        this.zzmqr.interrupt("repo_interrupt");
    }

    public final void onDisconnect() {
        zza(zzedb.zzmsb, Boolean.valueOf(false));
        Map zza = zzeex.zza(this.zzmsr);
        zzefb com_google_android_gms_internal_zzefb = this.zzmst;
        zzefb com_google_android_gms_internal_zzefb2 = new zzefb();
        com_google_android_gms_internal_zzefb.zza(new zzedk(""), new zzeey(com_google_android_gms_internal_zzefb2, zza));
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzefb2.zza(zzedk.zzbwe(), new zzedr(this, arrayList));
        this.zzmst = new zzefb();
        zzau(arrayList);
    }

    public final void purgeOutstandingWrites() {
        if (this.zzmsy.zzbzl()) {
            this.zzmsy.zzb("Purging writes", null, new Object[0]);
        }
        zzau(this.zzmte.zzbwv());
        zzb(zzedk.zzbwe(), -25);
        this.zzmqr.purgeOutstandingWrites();
    }

    final void resume() {
        this.zzmqr.resume("repo_interrupt");
    }

    public final String toString() {
        return this.zzmkj.toString();
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, CompletionListener completionListener, Map<String, Object> map) {
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 8).append("update: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmta;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(map);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("update: ").append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString(), null, new Object[0]);
        }
        if (com_google_android_gms_internal_zzecy.isEmpty()) {
            if (this.zzmsy.zzbzl()) {
                this.zzmsy.zzb("update called with no changes. No-op", null, new Object[0]);
            }
            zza(completionListener, null, com_google_android_gms_internal_zzedk);
            return;
        }
        zzecy zza = zzeex.zza(com_google_android_gms_internal_zzecy, zzeex.zza(this.zzmsr));
        long zzbwp = zzbwp();
        zzau(this.zzmte.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy, zza, zzbwp, true));
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), (Map) map, new zzeem(this, com_google_android_gms_internal_zzedk, zzbwp, completionListener));
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        while (it.hasNext()) {
            zzn(zzb(com_google_android_gms_internal_zzedk.zzh((zzedk) ((Entry) it.next()).getKey()), -9));
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmta;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzekd);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(valueOf).length() + 6) + String.valueOf(valueOf2).length()).append("set: ").append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString(), null, new Object[0]);
        }
        zzekd zza = zzeex.zza(com_google_android_gms_internal_zzekd, zzeex.zza(this.zzmsr));
        long zzbwp = zzbwp();
        zzau(this.zzmte.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, zza, zzbwp, true, true));
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), com_google_android_gms_internal_zzekd.getValue(true), new zzeel(this, com_google_android_gms_internal_zzedk, zzbwp, completionListener));
        zzn(zzb(com_google_android_gms_internal_zzedk, -9));
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, CompletionListener completionListener) {
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), new zzedq(this, com_google_android_gms_internal_zzedk, completionListener));
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, Handler handler, boolean z) {
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmsx.zzmnr && !this.zzmtg) {
            this.zzmtg = true;
            this.zzmsz.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference zza = zzh.zza(this, com_google_android_gms_internal_zzedk);
        ValueEventListener com_google_android_gms_internal_zzeds = new zzeds(this);
        zzf(new zzegf(this, com_google_android_gms_internal_zzeds, zza.zzbsz()));
        int i = zzeep.zzmur;
        long j = this.zzmth;
        this.zzmth = 1 + j;
        zzeeo com_google_android_gms_internal_zzeeo = new zzeeo(com_google_android_gms_internal_zzedk, handler, com_google_android_gms_internal_zzeds, i, z, j);
        zzekd zza2 = zza(com_google_android_gms_internal_zzedk, new ArrayList());
        com_google_android_gms_internal_zzeeo.zzmuo = zza2;
        DatabaseError databaseError;
        Result result;
        try {
            Result doTransaction = handler.doTransaction(zzh.zza(zza2));
            if (doTransaction == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            Result result2 = doTransaction;
            databaseError = null;
            result = result2;
            if (result.isSuccess()) {
                com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmus;
                zzehs zzak = this.zzmsu.zzak(com_google_android_gms_internal_zzedk);
                List list = (List) zzak.getValue();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(com_google_android_gms_internal_zzeeo);
                zzak.setValue(list);
                Map zza3 = zzeex.zza(this.zzmsr);
                zzekd zzbsv = result.zzbsv();
                zzekd zza4 = zzeex.zza(zzbsv, zza3);
                com_google_android_gms_internal_zzeeo.zzmup = zzbsv;
                com_google_android_gms_internal_zzeeo.zzmuq = zza4;
                com_google_android_gms_internal_zzeeo.zzmun = zzbwp();
                zzau(this.zzmte.zza(com_google_android_gms_internal_zzedk, zzbsv, zza4, com_google_android_gms_internal_zzeeo.zzmun, z, false));
                zzbwq();
                return;
            }
            com_google_android_gms_internal_zzeeo.zzmup = null;
            com_google_android_gms_internal_zzeeo.zzmuq = null;
            zzm(new zzedt(this, handler, databaseError, zzh.zza(zza, zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo))));
        } catch (Throwable th) {
            DatabaseError fromException = DatabaseError.fromException(th);
            databaseError = fromException;
            result = Transaction.abort();
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, Map<zzedk, zzekd> map, CompletionListener completionListener, Map<String, Object> map2) {
        this.zzmqr.zzb(com_google_android_gms_internal_zzedk.zzbwg(), (Map) map2, new zzedp(this, com_google_android_gms_internal_zzedk, map, completionListener));
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, boolean z) {
        this.zzmte.zza(com_google_android_gms_internal_zzeik, z);
    }

    final void zza(CompletionListener completionListener, DatabaseError databaseError, zzedk com_google_android_gms_internal_zzedk) {
        if (completionListener != null) {
            zzejg zzbwk = com_google_android_gms_internal_zzedk.zzbwk();
            DatabaseReference zza = (zzbwk == null || !zzbwk.zzbzr()) ? zzh.zza(this, com_google_android_gms_internal_zzedk) : zzh.zza(this, com_google_android_gms_internal_zzedk.zzbwj());
            zzm(new zzeek(this, completionListener, databaseError, zza));
        }
    }

    public final void zza(List<String> list, Object obj, boolean z, Long l) {
        List zza;
        zzedk com_google_android_gms_internal_zzedk = new zzedk((List) list);
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(obj);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(valueOf).length() + 15) + String.valueOf(valueOf2).length()).append("onDataUpdate: ").append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString(), null, new Object[0]);
        }
        this.zzmtb++;
        if (l != null) {
            try {
                zzega com_google_android_gms_internal_zzega = new zzega(l.longValue());
                if (z) {
                    Map hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new zzedk((String) entry.getKey()), zzekg.zza(entry.getValue(), zzeju.zzcaf()));
                    }
                    zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, hashMap, com_google_android_gms_internal_zzega);
                } else {
                    zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, zzekg.zza(obj, zzeju.zzcaf()), com_google_android_gms_internal_zzega);
                }
            } catch (Throwable e) {
                this.zzmsy.zzd("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            Map hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new zzedk((String) entry2.getKey()), zzekg.zza(entry2.getValue(), zzeju.zzcaf()));
            }
            zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, hashMap2);
        } else {
            zza = this.zzmte.zzi(com_google_android_gms_internal_zzedk, zzekg.zza(obj, zzeju.zzcaf()));
        }
        if (zza.size() > 0) {
            zzn(com_google_android_gms_internal_zzedk);
        }
        zzau(zza);
    }

    public final void zza(List<String> list, List<zzecd> list2, Long l) {
        zzedk com_google_android_gms_internal_zzedk = new zzedk((List) list);
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(list2);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append("onRangeMergeUpdate: ").append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString(), null, new Object[0]);
        }
        this.zzmtb++;
        List arrayList = new ArrayList(list2.size());
        for (zzecd com_google_android_gms_internal_zzekk : list2) {
            arrayList.add(new zzekk(com_google_android_gms_internal_zzekk));
        }
        List zza = l != null ? this.zzmte.zza(com_google_android_gms_internal_zzedk, arrayList, new zzega(l.longValue())) : this.zzmte.zzb(com_google_android_gms_internal_zzedk, arrayList);
        if (zza.size() > 0) {
            zzn(com_google_android_gms_internal_zzedk);
        }
        zzau(zza);
    }

    public final void zzai(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            zza(zzejg.zzpz((String) entry.getKey()), entry.getValue());
        }
    }

    public final void zzb(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        this.zzmqr.zzb(com_google_android_gms_internal_zzedk.zzbwg(), com_google_android_gms_internal_zzekd.getValue(true), new zzeen(this, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, completionListener));
    }

    public final void zzbuk() {
        zza(zzedb.zzmsb, Boolean.valueOf(true));
    }

    public final zzeeq zzbwm() {
        return this.zzmkj;
    }

    public final long zzbwn() {
        return this.zzmsr.millis();
    }

    final boolean zzbwo() {
        return (this.zzmtd.isEmpty() && this.zzmte.isEmpty()) ? false : true;
    }

    public final void zzcl(boolean z) {
        zza(zzedb.zzmsa, Boolean.valueOf(z));
    }

    public final void zze(zzedh com_google_android_gms_internal_zzedh) {
        zzau(zzedb.zzmry.equals(com_google_android_gms_internal_zzedh.zzbvp().zzbsy().zzbwh()) ? this.zzmtd.zzh(com_google_android_gms_internal_zzedh) : this.zzmte.zzh(com_google_android_gms_internal_zzedh));
    }

    public final void zzf(zzedh com_google_android_gms_internal_zzedh) {
        zzejg zzbwh = com_google_android_gms_internal_zzedh.zzbvp().zzbsy().zzbwh();
        List zzg = (zzbwh == null || !zzbwh.equals(zzedb.zzmry)) ? this.zzmte.zzg(com_google_android_gms_internal_zzedh) : this.zzmtd.zzg(com_google_android_gms_internal_zzedh);
        zzau(zzg);
    }

    public final void zzm(Runnable runnable) {
        this.zzmsx.zzbvw();
        this.zzmsx.zzmsc.zzm(runnable);
    }

    public final void zzo(Runnable runnable) {
        this.zzmsx.zzbvw();
        this.zzmsx.zzmse.zzo(runnable);
    }
}
