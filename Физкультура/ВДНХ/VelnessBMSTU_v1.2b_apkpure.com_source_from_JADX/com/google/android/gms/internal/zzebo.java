package com.google.android.gms.internal;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzebo implements zzebd, zzebm {
    private static long zzmnd = 0;
    private final ScheduledExecutorService zzmlf;
    private final zzejc zzmlr;
    private final zzebk zzmne;
    private final zzebg zzmnp;
    private final zzebn zzmnv;
    private String zzmnw;
    private HashSet<String> zzmnx = new HashSet();
    private boolean zzmny = true;
    private long zzmnz;
    private zzebc zzmoa;
    private zzeby zzmob = zzeby.Disconnected;
    private long zzmoc = 0;
    private long zzmod = 0;
    private Map<Long, zzebx> zzmoe;
    private List<zzeca> zzmof;
    private Map<Long, zzecc> zzmog;
    private Map<zzebz, zzecb> zzmoh;
    private String zzmoi;
    private boolean zzmoj;
    private final zzebi zzmok;
    private final zzecp zzmol;
    private String zzmom;
    private long zzmon = 0;
    private int zzmoo = 0;
    private ScheduledFuture<?> zzmop = null;
    private long zzmoq;
    private boolean zzmor;

    public zzebo(zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, zzebn com_google_android_gms_internal_zzebn) {
        this.zzmnv = com_google_android_gms_internal_zzebn;
        this.zzmok = com_google_android_gms_internal_zzebi;
        this.zzmlf = com_google_android_gms_internal_zzebi.zzbud();
        this.zzmnp = com_google_android_gms_internal_zzebi.zzbuc();
        this.zzmne = com_google_android_gms_internal_zzebk;
        this.zzmoh = new HashMap();
        this.zzmoe = new HashMap();
        this.zzmog = new HashMap();
        this.zzmof = new ArrayList();
        this.zzmol = new zzecr(this.zzmlf, com_google_android_gms_internal_zzebi.zzbub(), "ConnectionRetryHelper").zzbs(1000).zzi(1.3d).zzbt(30000).zzj(0.7d).zzbvk();
        long j = zzmnd;
        zzmnd = 1 + j;
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "PersistentConnection", "pc_" + j);
        this.zzmom = null;
        zzbur();
    }

    private final boolean isIdle() {
        return this.zzmoh.isEmpty() && this.zzmoe.isEmpty() && !this.zzmor && this.zzmog.isEmpty();
    }

    private final zzecb zza(zzebz com_google_android_gms_internal_zzebz) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzebz);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 15).append("removing query ").append(valueOf).toString(), null, new Object[0]);
        }
        if (this.zzmoh.containsKey(com_google_android_gms_internal_zzebz)) {
            zzecb com_google_android_gms_internal_zzecb = (zzecb) this.zzmoh.get(com_google_android_gms_internal_zzebz);
            this.zzmoh.remove(com_google_android_gms_internal_zzebz);
            zzbur();
            return com_google_android_gms_internal_zzecb;
        } else if (!this.zzmlr.zzbzl()) {
            return null;
        } else {
            com_google_android_gms_internal_zzejc = this.zzmlr;
            valueOf = String.valueOf(com_google_android_gms_internal_zzebz);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 64).append("Trying to remove listener for QuerySpec ").append(valueOf).append(" but no listener exists.").toString(), null, new Object[0]);
            return null;
        }
    }

    private final void zza(zzecb com_google_android_gms_internal_zzecb) {
        Map hashMap = new HashMap();
        hashMap.put("p", zzebj.zzas(com_google_android_gms_internal_zzecb.zzbuu().zzmph));
        Long zzbuv = com_google_android_gms_internal_zzecb.zzbuv();
        if (zzbuv != null) {
            hashMap.put("q", com_google_android_gms_internal_zzecb.zzmpm.zzmpi);
            hashMap.put("t", zzbuv);
        }
        zzebl zzbuw = com_google_android_gms_internal_zzecb.zzbuw();
        hashMap.put("h", zzbuw.zzbuh());
        if (zzbuw.zzbui()) {
            zzebb zzbuj = zzbuw.zzbuj();
            List arrayList = new ArrayList();
            for (List zzas : zzbuj.zzbtz()) {
                arrayList.add(zzebj.zzas(zzas));
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("hs", zzbuj.zzbua());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        zza("q", hashMap, new zzebu(this, com_google_android_gms_internal_zzecb));
    }

    private final void zza(String str, List<String> list, Object obj, zzece com_google_android_gms_internal_zzece) {
        Map hashMap = new HashMap();
        hashMap.put("p", zzebj.zzas(list));
        hashMap.put("d", obj);
        zza(str, hashMap, new zzebr(this, com_google_android_gms_internal_zzece));
    }

    private final void zza(String str, List<String> list, Object obj, String str2, zzece com_google_android_gms_internal_zzece) {
        Map hashMap = new HashMap();
        hashMap.put("p", zzebj.zzas(list));
        hashMap.put("d", obj);
        if (str2 != null) {
            hashMap.put("h", str2);
        }
        long j = this.zzmoc;
        this.zzmoc = 1 + j;
        this.zzmog.put(Long.valueOf(j), new zzecc(str, hashMap, com_google_android_gms_internal_zzece));
        if (zzbum()) {
            zzbp(j);
        }
        this.zzmoq = System.currentTimeMillis();
        zzbur();
    }

    private final void zza(String str, Map<String, Object> map, zzebx com_google_android_gms_internal_zzebx) {
        zza(str, false, (Map) map, com_google_android_gms_internal_zzebx);
    }

    private final void zza(String str, boolean z, Map<String, Object> map, zzebx com_google_android_gms_internal_zzebx) {
        long j = this.zzmod;
        this.zzmod = 1 + j;
        Map hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(j));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.zzmoa.zza(hashMap, z);
        this.zzmoe.put(Long.valueOf(j), com_google_android_gms_internal_zzebx);
    }

    private final void zza(List<String> list, zzebz com_google_android_gms_internal_zzebz) {
        if (list.contains("no_index")) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzebz.zzmpi.get("i"));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 14).append("\".indexOn\": \"").append(valueOf).append("\"").toString();
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String zzas = zzebj.zzas(com_google_android_gms_internal_zzebz.zzmph);
            com_google_android_gms_internal_zzejc.zze(new StringBuilder((String.valueOf(valueOf).length() + 175) + String.valueOf(zzas).length()).append("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '").append(valueOf).append("' at ").append(zzas).append(" to your security and Firebase Database rules for better performance").toString(), null);
        }
    }

    private final void zzat(List<String> list) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String valueOf = String.valueOf(list);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 29).append("removing all listens at path ").append(valueOf).toString(), null, new Object[0]);
        }
        List arrayList = new ArrayList();
        for (Entry entry : this.zzmoh.entrySet()) {
            zzebz com_google_android_gms_internal_zzebz = (zzebz) entry.getKey();
            zzecb com_google_android_gms_internal_zzecb = (zzecb) entry.getValue();
            if (com_google_android_gms_internal_zzebz.zzmph.equals(list)) {
                arrayList.add(com_google_android_gms_internal_zzecb);
            }
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            this.zzmoh.remove(((zzecb) obj).zzbuu());
        }
        zzbur();
        ArrayList arrayList3 = (ArrayList) arrayList;
        i = arrayList3.size();
        int i2 = 0;
        while (i2 < i) {
            Object obj2 = arrayList3.get(i2);
            i2++;
            ((zzecb) obj2).zzmpl.zzbd("permission_denied", null);
        }
    }

    private final void zzbp(long j) {
        zzecc com_google_android_gms_internal_zzecc = (zzecc) this.zzmog.get(Long.valueOf(j));
        zzece zzbut = com_google_android_gms_internal_zzecc.zzbut();
        String action = com_google_android_gms_internal_zzecc.getAction();
        com_google_android_gms_internal_zzecc.zzbuy();
        zza(action, com_google_android_gms_internal_zzecc.zzbux(), new zzebt(this, action, j, com_google_android_gms_internal_zzecc, zzbut));
    }

    private final boolean zzbul() {
        return this.zzmob == zzeby.Authenticating || this.zzmob == zzeby.Connected;
    }

    private final boolean zzbum() {
        return this.zzmob == zzeby.Connected;
    }

    private final boolean zzbun() {
        return this.zzmnx.size() == 0;
    }

    private final void zzbuo() {
        if (zzbun()) {
            zzebj.zzc(this.zzmob == zzeby.Disconnected, "Not in disconnected state: %s", this.zzmob);
            boolean z = this.zzmoj;
            this.zzmlr.zzb("Scheduling connection attempt", null, new Object[0]);
            this.zzmoj = false;
            this.zzmol.zzn(new zzebp(this, z));
        }
    }

    private final void zzbup() {
        List arrayList = new ArrayList();
        Iterator it = this.zzmog.entrySet().iterator();
        while (it.hasNext()) {
            zzecc com_google_android_gms_internal_zzecc = (zzecc) ((Entry) it.next()).getValue();
            if (com_google_android_gms_internal_zzecc.zzbux().containsKey("h") && com_google_android_gms_internal_zzecc.zzbuz()) {
                arrayList.add(com_google_android_gms_internal_zzecc);
                it.remove();
            }
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzecc) obj).zzbut().zzbd("disconnected", null);
        }
    }

    private final void zzbuq() {
        int i = 0;
        zzebj.zzc(this.zzmob == zzeby.Connected, "Should be connected if we're restoring state, but we are: %s", this.zzmob);
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Restoring outstanding listens", null, new Object[0]);
        }
        for (zzecb com_google_android_gms_internal_zzecb : this.zzmoh.values()) {
            if (this.zzmlr.zzbzl()) {
                zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
                String valueOf = String.valueOf(com_google_android_gms_internal_zzecb.zzbuu());
                com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Restoring listen ").append(valueOf).toString(), null, new Object[0]);
            }
            zza(com_google_android_gms_internal_zzecb);
        }
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Restoring writes.", null, new Object[0]);
        }
        List arrayList = new ArrayList(this.zzmog.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzbp(((Long) obj).longValue());
        }
        for (zzeca com_google_android_gms_internal_zzeca : this.zzmof) {
            zza(com_google_android_gms_internal_zzeca.getAction(), com_google_android_gms_internal_zzeca.getPath(), com_google_android_gms_internal_zzeca.getData(), com_google_android_gms_internal_zzeca.zzbut());
        }
        this.zzmof.clear();
    }

    private final void zzbur() {
        if (isIdle()) {
            if (this.zzmop != null) {
                this.zzmop.cancel(false);
            }
            this.zzmop = this.zzmlf.schedule(new zzebw(this), 60000, TimeUnit.MILLISECONDS);
        } else if (isInterrupted("connection_idle")) {
            zzebj.zzc(!isIdle(), "", new Object[0]);
            resume("connection_idle");
        }
    }

    private final boolean zzbus() {
        return isIdle() && System.currentTimeMillis() > this.zzmoq + 60000;
    }

    private final void zzcm(boolean z) {
        zzebj.zzc(zzbul(), "Must be connected to send auth, but was: %s", this.zzmob);
        zzebj.zzc(this.zzmoi != null, "Auth token must be set to authenticate!", new Object[0]);
        zzebx com_google_android_gms_internal_zzebs = new zzebs(this, z);
        Map hashMap = new HashMap();
        zzelg zzqa = zzelg.zzqa(this.zzmoi);
        if (zzqa != null) {
            hashMap.put("cred", zzqa.getToken());
            if (zzqa.zzcbf() != null) {
                hashMap.put("authvar", zzqa.zzcbf());
            }
            zza("gauth", true, hashMap, com_google_android_gms_internal_zzebs);
            return;
        }
        hashMap.put("cred", this.zzmoi);
        zza("auth", true, hashMap, com_google_android_gms_internal_zzebs);
    }

    public final void initialize() {
        zzbuo();
    }

    public final void interrupt(String str) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String str2 = "Connection interrupted for: ";
            String valueOf = String.valueOf(str);
            com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), null, new Object[0]);
        }
        this.zzmnx.add(str);
        if (this.zzmoa != null) {
            this.zzmoa.close();
            this.zzmoa = null;
        } else {
            this.zzmol.cancel();
            this.zzmob = zzeby.Disconnected;
        }
        this.zzmol.zzbvi();
    }

    public final boolean isInterrupted(String str) {
        return this.zzmnx.contains(str);
    }

    public final void purgeOutstandingWrites() {
        for (zzecc com_google_android_gms_internal_zzecc : this.zzmog.values()) {
            if (com_google_android_gms_internal_zzecc.zzmpk != null) {
                com_google_android_gms_internal_zzecc.zzmpk.zzbd("write_canceled", null);
            }
        }
        for (zzeca com_google_android_gms_internal_zzeca : this.zzmof) {
            if (com_google_android_gms_internal_zzeca.zzmpk != null) {
                com_google_android_gms_internal_zzeca.zzmpk.zzbd("write_canceled", null);
            }
        }
        this.zzmog.clear();
        this.zzmof.clear();
        if (!zzbul()) {
            this.zzmor = false;
        }
        zzbur();
    }

    public final void refreshAuthToken() {
        this.zzmlr.zzb("Auth token refresh requested", null, new Object[0]);
        interrupt("token_refresh");
        resume("token_refresh");
    }

    public final void resume(String str) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String str2 = "Connection no longer interrupted for: ";
            String valueOf = String.valueOf(str);
            com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), null, new Object[0]);
        }
        this.zzmnx.remove(str);
        if (zzbun() && this.zzmob == zzeby.Disconnected) {
            zzbuo();
        }
    }

    public final void shutdown() {
        interrupt("shutdown");
    }

    public final void zza(List<String> list, zzece com_google_android_gms_internal_zzece) {
        if (zzbum()) {
            zza("oc", (List) list, null, com_google_android_gms_internal_zzece);
        } else {
            this.zzmof.add(new zzeca("oc", list, null, com_google_android_gms_internal_zzece));
        }
        zzbur();
    }

    public final void zza(List<String> list, Object obj, zzece com_google_android_gms_internal_zzece) {
        zza("p", (List) list, obj, null, com_google_android_gms_internal_zzece);
    }

    public final void zza(List<String> list, Object obj, String str, zzece com_google_android_gms_internal_zzece) {
        zza("p", (List) list, obj, str, com_google_android_gms_internal_zzece);
    }

    public final void zza(List<String> list, Map<String, Object> map) {
        zzebz com_google_android_gms_internal_zzebz = new zzebz(list, map);
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzebz);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 15).append("unlistening on ").append(valueOf).toString(), null, new Object[0]);
        }
        zzecb zza = zza(com_google_android_gms_internal_zzebz);
        if (zza != null && zzbul()) {
            Map hashMap = new HashMap();
            hashMap.put("p", zzebj.zzas(zza.zzmpm.zzmph));
            Long zzbuv = zza.zzbuv();
            if (zzbuv != null) {
                hashMap.put("q", zza.zzbuu().zzmpi);
                hashMap.put("t", zzbuv);
            }
            zza("n", hashMap, null);
        }
        zzbur();
    }

    public final void zza(List<String> list, Map<String, Object> map, zzebl com_google_android_gms_internal_zzebl, Long l, zzece com_google_android_gms_internal_zzece) {
        zzebz com_google_android_gms_internal_zzebz = new zzebz(list, map);
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzebz);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 13).append("Listening on ").append(valueOf).toString(), null, new Object[0]);
        }
        zzebj.zzc(!this.zzmoh.containsKey(com_google_android_gms_internal_zzebz), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.zzmlr.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmlr;
            valueOf = String.valueOf(com_google_android_gms_internal_zzebz);
            com_google_android_gms_internal_zzejc.zzb(new StringBuilder(String.valueOf(valueOf).length() + 21).append("Adding listen query: ").append(valueOf).toString(), null, new Object[0]);
        }
        zzecb com_google_android_gms_internal_zzecb = new zzecb(com_google_android_gms_internal_zzece, com_google_android_gms_internal_zzebz, l, com_google_android_gms_internal_zzebl);
        this.zzmoh.put(com_google_android_gms_internal_zzebz, com_google_android_gms_internal_zzecb);
        if (zzbul()) {
            zza(com_google_android_gms_internal_zzecb);
        }
        zzbur();
    }

    public final void zza(List<String> list, Map<String, Object> map, zzece com_google_android_gms_internal_zzece) {
        zza("m", (List) list, (Object) map, null, com_google_android_gms_internal_zzece);
    }

    public final void zzah(Map<String, Object> map) {
        if (map.containsKey("r")) {
            zzebx com_google_android_gms_internal_zzebx = (zzebx) this.zzmoe.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (com_google_android_gms_internal_zzebx != null) {
                com_google_android_gms_internal_zzebx.zzaj((Map) map.get("b"));
            }
        } else if (!map.containsKey("error")) {
            String str;
            if (map.containsKey("a")) {
                String valueOf;
                String str2 = (String) map.get("a");
                Map map2 = (Map) map.get("b");
                if (this.zzmlr.zzbzl()) {
                    zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
                    valueOf = String.valueOf(map2);
                    com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(str2).length() + 22) + String.valueOf(valueOf).length()).append("handleServerMessage: ").append(str2).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).toString(), null, new Object[0]);
                }
                Object obj;
                zzejc com_google_android_gms_internal_zzejc2;
                String str3;
                if (str2.equals("d") || str2.equals("m")) {
                    boolean equals = str2.equals("m");
                    str2 = (String) map2.get("p");
                    obj = map2.get("d");
                    Long zzbq = zzebj.zzbq(map2.get("t"));
                    if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                        this.zzmnv.zza(zzebj.zzpm(str2), obj, equals, zzbq);
                    } else if (this.zzmlr.zzbzl()) {
                        com_google_android_gms_internal_zzejc2 = this.zzmlr;
                        str3 = "ignoring empty merge for path ";
                        str2 = String.valueOf(str2);
                        com_google_android_gms_internal_zzejc2.zzb(str2.length() != 0 ? str3.concat(str2) : new String(str3), null, new Object[0]);
                    }
                } else if (str2.equals("rm")) {
                    str2 = (String) map2.get("p");
                    List zzpm = zzebj.zzpm(str2);
                    obj = map2.get("d");
                    Long zzbq2 = zzebj.zzbq(map2.get("t"));
                    List<Map> list = (List) obj;
                    List arrayList = new ArrayList();
                    for (Map map22 : list) {
                        str3 = (String) map22.get("s");
                        valueOf = (String) map22.get("e");
                        arrayList.add(new zzecd(str3 != null ? zzebj.zzpm(str3) : null, valueOf != null ? zzebj.zzpm(valueOf) : null, map22.get("m")));
                    }
                    if (!arrayList.isEmpty()) {
                        this.zzmnv.zza(zzpm, arrayList, zzbq2);
                    } else if (this.zzmlr.zzbzl()) {
                        com_google_android_gms_internal_zzejc2 = this.zzmlr;
                        str3 = "Ignoring empty range merge for path ";
                        str2 = String.valueOf(str2);
                        com_google_android_gms_internal_zzejc2.zzb(str2.length() != 0 ? str3.concat(str2) : new String(str3), null, new Object[0]);
                    }
                } else if (str2.equals("c")) {
                    zzat(zzebj.zzpm((String) map22.get("p")));
                } else if (str2.equals("ac")) {
                    str2 = (String) map22.get("s");
                    str = (String) map22.get("d");
                    this.zzmlr.zzb(new StringBuilder((String.valueOf(str2).length() + 23) + String.valueOf(str).length()).append("Auth token revoked: ").append(str2).append(" (").append(str).append(")").toString(), null, new Object[0]);
                    this.zzmoi = null;
                    this.zzmoj = true;
                    this.zzmnv.zzcl(false);
                    this.zzmoa.close();
                } else if (str2.equals("sd")) {
                    this.zzmlr.info((String) map22.get("msg"));
                } else if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc2 = this.zzmlr;
                    str3 = "Unrecognized action from server: ";
                    str2 = String.valueOf(str2);
                    com_google_android_gms_internal_zzejc2.zzb(str2.length() != 0 ? str3.concat(str2) : new String(str3), null, new Object[0]);
                }
            } else if (this.zzmlr.zzbzl()) {
                zzejc com_google_android_gms_internal_zzejc3 = this.zzmlr;
                str = String.valueOf(map);
                com_google_android_gms_internal_zzejc3.zzb(new StringBuilder(String.valueOf(str).length() + 26).append("Ignoring unknown message: ").append(str).toString(), null, new Object[0]);
            }
        }
    }

    public final void zzb(zzebe com_google_android_gms_internal_zzebe) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String str = "Got on disconnect due to ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzebe.name());
            com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
        }
        this.zzmob = zzeby.Disconnected;
        this.zzmoa = null;
        this.zzmor = false;
        this.zzmoe.clear();
        zzbup();
        if (zzbun()) {
            boolean z = this.zzmnz > 0 ? System.currentTimeMillis() - this.zzmnz > 30000 : false;
            if (com_google_android_gms_internal_zzebe == zzebe.SERVER_RESET || r0) {
                this.zzmol.zzbvi();
            }
            zzbuo();
        }
        this.zzmnz = 0;
        this.zzmnv.onDisconnect();
    }

    public final void zzb(List<String> list, Object obj, zzece com_google_android_gms_internal_zzece) {
        this.zzmor = true;
        if (zzbum()) {
            zza("o", (List) list, obj, com_google_android_gms_internal_zzece);
        } else {
            this.zzmof.add(new zzeca("o", list, obj, com_google_android_gms_internal_zzece));
        }
        zzbur();
    }

    public final void zzb(List<String> list, Map<String, Object> map, zzece com_google_android_gms_internal_zzece) {
        this.zzmor = true;
        if (zzbum()) {
            zza("om", (List) list, (Object) map, com_google_android_gms_internal_zzece);
        } else {
            this.zzmof.add(new zzeca("om", list, map, com_google_android_gms_internal_zzece));
        }
        zzbur();
    }

    public final void zzc(long j, String str) {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("onReady", null, new Object[0]);
        }
        this.zzmnz = System.currentTimeMillis();
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("handling timestamp", null, new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.zzmnv.zzai(hashMap);
        if (this.zzmny) {
            Map hashMap2 = new HashMap();
            if (this.zzmok.isPersistenceEnabled()) {
                hashMap2.put("persistence.android.enabled", Integer.valueOf(1));
            }
            String str2 = "sdk.android.";
            String valueOf = String.valueOf(this.zzmok.zzbue().replace('.', '-'));
            hashMap2.put(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), Integer.valueOf(1));
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Sending first connection stats", null, new Object[0]);
            }
            if (!hashMap2.isEmpty()) {
                hashMap = new HashMap();
                hashMap.put("c", hashMap2);
                zza("s", hashMap, new zzebv(this));
            } else if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Not sending stats because stats are empty", null, new Object[0]);
            }
        }
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("calling restore state", null, new Object[0]);
        }
        zzebj.zzc(this.zzmob == zzeby.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.zzmob);
        if (this.zzmoi == null) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Not restoring auth because token is null.", null, new Object[0]);
            }
            this.zzmob = zzeby.Connected;
            zzbuq();
        } else {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Restoring auth.", null, new Object[0]);
            }
            this.zzmob = zzeby.Authenticating;
            zzcm(true);
        }
        this.zzmny = false;
        this.zzmom = str;
        this.zzmnv.zzbuk();
    }

    public final void zzpj(String str) {
        this.zzmnw = str;
    }

    public final void zzpk(String str) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String str2 = "Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ";
            String valueOf = String.valueOf(str);
            com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), null, new Object[0]);
        }
        interrupt("server_kill");
    }

    public final void zzpn(String str) {
        this.zzmlr.zzb("Auth token refreshed.", null, new Object[0]);
        this.zzmoi = str;
        if (!zzbul()) {
            return;
        }
        if (str != null) {
            zzcm(false);
            return;
        }
        zzebj.zzc(zzbul(), "Must be connected to send unauth.", new Object[0]);
        zzebj.zzc(this.zzmoi == null, "Auth token must not be set.", new Object[0]);
        zza("unauth", Collections.emptyMap(), null);
    }

    public final void zzpo(String str) {
        zzebj.zzc(this.zzmob == zzeby.GettingToken, "Trying to open network connection while in the wrong state: %s", this.zzmob);
        if (str == null) {
            this.zzmnv.zzcl(false);
        }
        this.zzmoi = str;
        this.zzmob = zzeby.Connecting;
        this.zzmoa = new zzebc(this.zzmok, this.zzmne, this.zzmnw, this, this.zzmom);
        this.zzmoa.open();
    }
}
