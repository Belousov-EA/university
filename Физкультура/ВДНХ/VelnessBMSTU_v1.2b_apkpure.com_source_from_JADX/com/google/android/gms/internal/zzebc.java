package com.google.android.gms.internal;

import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

final class zzebc implements zzeci {
    private static long zzmnd = 0;
    private final zzejc zzmlr;
    private zzebk zzmne;
    private zzecf zzmnf;
    private zzebd zzmng;
    private int zzmnh = zzebf.zzmnl;

    public zzebc(zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, String str, zzebd com_google_android_gms_internal_zzebd, String str2) {
        long j = zzmnd;
        zzmnd = 1 + j;
        this.zzmne = com_google_android_gms_internal_zzebk;
        this.zzmng = com_google_android_gms_internal_zzebd;
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), HttpHeaders.CONNECTION, "conn_" + j);
        this.zzmnf = new zzecf(com_google_android_gms_internal_zzebi, com_google_android_gms_internal_zzebk, str, this, str2);
    }

    private final void zza(zzebe com_google_android_gms_internal_zzebe) {
        if (this.zzmnh != zzebf.zzmnn) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("closing realtime connection", null, new Object[0]);
            }
            this.zzmnh = zzebf.zzmnn;
            if (this.zzmnf != null) {
                this.zzmnf.close();
                this.zzmnf = null;
            }
            this.zzmng.zzb(com_google_android_gms_internal_zzebe);
        }
    }

    public final void close() {
        zza(zzebe.OTHER);
    }

    public final void open() {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Opening a connection", null, new Object[0]);
        }
        this.zzmnf.open();
    }

    public final void zza(Map<String, Object> map, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        if (this.zzmnh != zzebf.zzmnm) {
            this.zzmlr.zzb("Tried to send on an unconnected connection", null, new Object[0]);
            return;
        }
        if (z) {
            this.zzmlr.zzb("Sending data (contents hidden)", null, new Object[0]);
        } else {
            this.zzmlr.zzb("Sending data: %s", null, hashMap);
        }
        this.zzmnf.send(hashMap);
    }

    public final void zzag(Map<String, Object> map) {
        zzejc com_google_android_gms_internal_zzejc;
        String str;
        String str2;
        try {
            str2 = (String) map.get("t");
            if (str2 == null) {
                if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    str = "Failed to parse server message: missing message type:";
                    str2 = String.valueOf(map.toString());
                    com_google_android_gms_internal_zzejc.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
                }
                zza(zzebe.OTHER);
            } else if (str2.equals("d")) {
                r0 = (Map) map.get("d");
                if (this.zzmlr.zzbzl()) {
                    r2 = this.zzmlr;
                    r3 = "received data message: ";
                    r1 = String.valueOf(r0.toString());
                    r2.zzb(r1.length() != 0 ? r3.concat(r1) : new String(r3), null, new Object[0]);
                }
                this.zzmng.zzah(r0);
            } else if (str2.equals("c")) {
                r0 = (Map) map.get("d");
                if (this.zzmlr.zzbzl()) {
                    r2 = this.zzmlr;
                    r3 = "Got control message: ";
                    r1 = String.valueOf(r0.toString());
                    r2.zzb(r1.length() != 0 ? r3.concat(r1) : new String(r3), null, new Object[0]);
                }
                try {
                    r1 = (String) r0.get("t");
                    if (r1 == null) {
                        if (this.zzmlr.zzbzl()) {
                            com_google_android_gms_internal_zzejc = this.zzmlr;
                            str = "Got invalid control message: ";
                            str2 = String.valueOf(r0.toString());
                            com_google_android_gms_internal_zzejc.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
                        }
                        zza(zzebe.OTHER);
                    } else if (r1.equals("s")) {
                        str2 = (String) r0.get("d");
                        if (this.zzmlr.zzbzl()) {
                            this.zzmlr.zzb("Connection shutdown command received. Shutting down...", null, new Object[0]);
                        }
                        this.zzmng.zzpk(str2);
                        zza(zzebe.OTHER);
                    } else if (r1.equals("r")) {
                        str2 = (String) r0.get("d");
                        if (this.zzmlr.zzbzl()) {
                            com_google_android_gms_internal_zzejc = this.zzmlr;
                            str = this.zzmne.getHost();
                            com_google_android_gms_internal_zzejc.zzb(new StringBuilder((String.valueOf(str).length() + 62) + String.valueOf(str2).length()).append("Got a reset; killing connection to ").append(str).append("; Updating internalHost to ").append(str2).toString(), null, new Object[0]);
                        }
                        this.zzmng.zzpj(str2);
                        zza(zzebe.SERVER_RESET);
                    } else if (r1.equals("h")) {
                        r0 = (Map) r0.get("d");
                        long longValue = ((Long) r0.get("ts")).longValue();
                        this.zzmng.zzpj((String) r0.get("h"));
                        str2 = (String) r0.get("s");
                        if (this.zzmnh == zzebf.zzmnl) {
                            if (this.zzmlr.zzbzl()) {
                                this.zzmlr.zzb("realtime connection established", null, new Object[0]);
                            }
                            this.zzmnh = zzebf.zzmnm;
                            this.zzmng.zzc(longValue, str2);
                        }
                    } else if (this.zzmlr.zzbzl()) {
                        r2 = this.zzmlr;
                        r3 = "Ignoring unknown control message: ";
                        str2 = String.valueOf(r1);
                        r2.zzb(str2.length() != 0 ? r3.concat(str2) : new String(r3), null, new Object[0]);
                    }
                } catch (ClassCastException e) {
                    if (this.zzmlr.zzbzl()) {
                        com_google_android_gms_internal_zzejc = this.zzmlr;
                        str = "Failed to parse control message: ";
                        str2 = String.valueOf(e.toString());
                        com_google_android_gms_internal_zzejc.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
                    }
                    zza(zzebe.OTHER);
                }
            } else if (this.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str = "Ignoring unknown server message type: ";
                str2 = String.valueOf(str2);
                com_google_android_gms_internal_zzejc.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
            }
        } catch (ClassCastException e2) {
            if (this.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str = "Failed to parse server message: ";
                str2 = String.valueOf(e2.toString());
                com_google_android_gms_internal_zzejc.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
            }
            zza(zzebe.OTHER);
        }
    }

    public final void zzck(boolean z) {
        this.zzmnf = null;
        if (z || this.zzmnh != zzebf.zzmnl) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Realtime connection lost", null, new Object[0]);
            }
        } else if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Realtime connection failed", null, new Object[0]);
        }
        zza(zzebe.OTHER);
    }
}
