package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzfp;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@KeepForSdkWithMembers
public class AdvertisingIdClient {
    private final Context mContext;
    @Nullable
    private com.google.android.gms.common.zza zzamu;
    @Nullable
    private zzfo zzamv;
    private boolean zzamw;
    private Object zzamx;
    @Nullable
    private zza zzamy;
    private boolean zzamz;
    private long zzana;

    public static final class Info {
        private final String zzang;
        private final boolean zzanh;

        public Info(String str, boolean z) {
            this.zzang = str;
            this.zzanh = z;
        }

        public final String getId() {
            return this.zzang;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanh;
        }

        public final String toString() {
            String str = this.zzang;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzanh).toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzanc;
        private long zzand;
        CountDownLatch zzane = new CountDownLatch(1);
        boolean zzanf = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzanc = new WeakReference(advertisingIdClient);
            this.zzand = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzanc.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzanf = true;
            }
        }

        public final void run() {
            try {
                if (!this.zzane.await(this.zzand, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzamx = new Object();
        zzbq.checkNotNull(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        } else {
            this.mContext = context;
        }
        this.zzamw = false;
        this.zzana = j;
        this.zzamz = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb com_google_android_gms_ads_identifier_zzb = new zzb(context);
        boolean z = com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = com_google_android_gms_ads_identifier_zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = com_google_android_gms_ads_identifier_zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z, com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb com_google_android_gms_ads_identifier_zzb = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, com_google_android_gms_ads_identifier_zzb.getBoolean("gads:ad_id_app_context:enabled", false), com_google_android_gms_ads_identifier_zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            boolean isAdIdFakeForDebugLogging = advertisingIdClient.getIsAdIdFakeForDebugLogging();
            return isAdIdFakeForDebugLogging;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private final void start(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamw) {
                finish();
            }
            this.zzamu = zzc(this.mContext, this.zzamz);
            this.zzamv = zza(this.mContext, this.zzamu);
            this.zzamw = true;
            if (z) {
                zzbo();
            }
        }
    }

    private static zzfo zza(Context context, com.google.android.gms.common.zza com_google_android_gms_common_zza) throws IOException {
        try {
            return zzfp.zzc(com_google_android_gms_common_zza.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        return true;
    }

    private final void zzbo() {
        synchronized (this.zzamx) {
            if (this.zzamy != null) {
                this.zzamy.zzane.countDown();
                try {
                    this.zzamy.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzana > 0) {
                this.zzamy = new zza(this, this.zzana);
            }
        }
    }

    private static com.google.android.gms.common.zza zzc(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzf.zzafy().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                    Object com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
                    Intent intent = new Intent(str);
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (com.google.android.gms.common.stats.zza.zzamc().zza(context, intent, com_google_android_gms_common_zza, 1)) {
                            return com_google_android_gms_common_zza;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzbq.zzgn(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzamu;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzamw;	 Catch:{ Throwable -> 0x002c }
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        com.google.android.gms.common.stats.zza.zzamc();	 Catch:{ Throwable -> 0x002c }
        r0 = r3.mContext;	 Catch:{ Throwable -> 0x002c }
        r1 = r3.zzamu;	 Catch:{ Throwable -> 0x002c }
        r0.unbindService(r1);	 Catch:{ Throwable -> 0x002c }
    L_0x001e:
        r0 = 0;
        r3.zzamw = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r3.zzamv = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r3.zzamu = r0;	 Catch:{ all -> 0x0029 }
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        goto L_0x000f;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0029 }
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.zzanf) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.checkNotNull(this.zzamu);
            zzbq.checkNotNull(this.zzamv);
            info = new Info(this.zzamv.getId(), this.zzamv.zzb(true));
        }
        zzbo();
        return info;
    }

    public boolean getIsAdIdFakeForDebugLogging() throws IOException {
        boolean zzbp;
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamw) {
                synchronized (this.zzamx) {
                    if (this.zzamy == null || !this.zzamy.zzanf) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.checkNotNull(this.zzamu);
            zzbq.checkNotNull(this.zzamv);
            zzbp = this.zzamv.zzbp();
        }
        zzbo();
        return zzbp;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        start(true);
    }
}
