package com.google.android.gms.internal;

import com.google.common.net.HttpHeaders;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzecf {
    private static long zzmpu = 0;
    private final ScheduledExecutorService zzmlf;
    private final zzejc zzmlr;
    private zzecj zzmpv;
    private boolean zzmpw = false;
    private boolean zzmpx = false;
    private long zzmpy = 0;
    private zzecs zzmpz;
    private zzeci zzmqa;
    private ScheduledFuture<?> zzmqb;
    private ScheduledFuture<?> zzmqc;
    private final zzebi zzmqd;

    public zzecf(zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, String str, zzeci com_google_android_gms_internal_zzeci, String str2) {
        this.zzmqd = com_google_android_gms_internal_zzebi;
        this.zzmlf = com_google_android_gms_internal_zzebi.zzbud();
        this.zzmqa = com_google_android_gms_internal_zzeci;
        long j = zzmpu;
        zzmpu = 1 + j;
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "WebSocket", "ws_" + j);
        if (str == null) {
            str = com_google_android_gms_internal_zzebk.getHost();
        }
        boolean isSecure = com_google_android_gms_internal_zzebk.isSecure();
        String namespace = com_google_android_gms_internal_zzebk.getNamespace();
        String str3 = isSecure ? "wss" : "ws";
        String str4 = "v";
        String str5 = "5";
        str3 = new StringBuilder(((((String.valueOf(str3).length() + 13) + String.valueOf(str).length()) + String.valueOf(namespace).length()) + String.valueOf(str4).length()) + String.valueOf(str5).length()).append(str3).append("://").append(str).append("/.ws?ns=").append(namespace).append("&").append(str4).append("=").append(str5).toString();
        if (str2 != null) {
            str3 = String.valueOf(str3);
            namespace = "&ls=";
            str3 = new StringBuilder((String.valueOf(str3).length() + String.valueOf(namespace).length()) + String.valueOf(str2).length()).append(str3).append(namespace).append(str2).toString();
        }
        URI create = URI.create(str3);
        Map hashMap = new HashMap();
        hashMap.put(HttpHeaders.USER_AGENT, this.zzmqd.zzbuf());
        this.zzmpv = new zzeck(this, new zzeku(this.zzmqd, create, null, hashMap));
    }

    private final void shutdown() {
        this.zzmpx = true;
        this.zzmqa.zzck(this.zzmpw);
    }

    private final void zzbvd() {
        if (!this.zzmpx) {
            if (this.zzmqb != null) {
                this.zzmqb.cancel(false);
                if (this.zzmlr.zzbzl()) {
                    this.zzmlr.zzb("Reset keepAlive. Remaining: " + this.zzmqb.getDelay(TimeUnit.MILLISECONDS), null, new Object[0]);
                }
            } else if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Reset keepAlive", null, new Object[0]);
            }
            this.zzmqb = this.zzmlf.schedule(new zzech(this), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private final void zzbve() {
        if (!this.zzmpx) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("closing itself", null, new Object[0]);
            }
            shutdown();
        }
        this.zzmpv = null;
        if (this.zzmqb != null) {
            this.zzmqb.cancel(false);
        }
    }

    private final void zzbvf() {
        if (!this.zzmpw && !this.zzmpx) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("timed out on connect", null, new Object[0]);
            }
            this.zzmpv.close();
        }
    }

    private final void zzgq(int i) {
        this.zzmpy = (long) i;
        this.zzmpz = new zzecs();
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("HandleNewFrameCount: " + this.zzmpy, null, new Object[0]);
        }
    }

    private final void zzpp(String str) {
        Throwable th;
        zzejc com_google_android_gms_internal_zzejc;
        String str2;
        String valueOf;
        this.zzmpz.zzpt(str);
        this.zzmpy--;
        if (this.zzmpy == 0) {
            try {
                this.zzmpz.zzbvl();
                Map zzqb = zzelh.zzqb(this.zzmpz.toString());
                this.zzmpz = null;
                if (this.zzmlr.zzbzl()) {
                    zzejc com_google_android_gms_internal_zzejc2 = this.zzmlr;
                    String valueOf2 = String.valueOf(zzqb);
                    com_google_android_gms_internal_zzejc2.zzb(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf2).toString(), null, new Object[0]);
                }
                this.zzmqa.zzag(zzqb);
            } catch (Throwable e) {
                th = e;
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str2 = "Error parsing frame: ";
                valueOf = String.valueOf(this.zzmpz.toString());
                com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                close();
                shutdown();
            } catch (Throwable e2) {
                th = e2;
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str2 = "Error parsing frame (cast error): ";
                valueOf = String.valueOf(this.zzmpz.toString());
                com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                close();
                shutdown();
            }
        }
    }

    private final String zzpq(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    zzgq(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        zzgq(1);
        return str;
    }

    private final void zzpr(String str) {
        if (!this.zzmpx) {
            zzbvd();
            if ((this.zzmpz != null ? 1 : null) != null) {
                zzpp(str);
                return;
            }
            String zzpq = zzpq(str);
            if (zzpq != null) {
                zzpp(zzpq);
            }
        }
    }

    public final void close() {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("websocket is being closed", null, new Object[0]);
        }
        this.zzmpx = true;
        this.zzmpv.close();
        if (this.zzmqc != null) {
            this.zzmqc.cancel(true);
        }
        if (this.zzmqb != null) {
            this.zzmqb.cancel(true);
        }
    }

    public final void open() {
        this.zzmpv.connect();
        this.zzmqc = this.zzmlf.schedule(new zzecg(this), 30000, TimeUnit.MILLISECONDS);
    }

    public final void send(Map<String, Object> map) {
        String str;
        zzbvd();
        try {
            String[] strArr;
            int i;
            String zzbt = zzelh.zzbt(map);
            if (zzbt.length() <= 16384) {
                strArr = new String[]{zzbt};
            } else {
                ArrayList arrayList = new ArrayList();
                for (i = 0; i < zzbt.length(); i += 16384) {
                    arrayList.add(zzbt.substring(i, Math.min(i + 16384, zzbt.length())));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (strArr.length > 1) {
                this.zzmpv.zzps(strArr.length);
            }
            for (String str2 : strArr) {
                this.zzmpv.zzps(str2);
            }
        } catch (Throwable e) {
            Throwable th = e;
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            str2 = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            shutdown();
        }
    }
}
