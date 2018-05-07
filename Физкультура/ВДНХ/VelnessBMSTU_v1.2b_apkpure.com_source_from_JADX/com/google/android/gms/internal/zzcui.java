package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;

public abstract class zzcui<T> {
    private static Context zzair = null;
    private static boolean zzcek = false;
    private static final Object zzjwy = new Object();
    private static Boolean zzjwz = null;
    private final zzcup zzjxa;
    final String zzjxb;
    private final String zzjxc;
    private final T zzjxd;
    private T zzjxe;

    private zzcui(zzcup com_google_android_gms_internal_zzcup, String str, T t) {
        this.zzjxe = null;
        if (com_google_android_gms_internal_zzcup.zzjxi == null && com_google_android_gms_internal_zzcup.zzjxj == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (com_google_android_gms_internal_zzcup.zzjxi == null || com_google_android_gms_internal_zzcup.zzjxj == null) {
            this.zzjxa = com_google_android_gms_internal_zzcup;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzcup.zzjxk);
            String valueOf2 = String.valueOf(str);
            this.zzjxc = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            valueOf = String.valueOf(com_google_android_gms_internal_zzcup.zzjxl);
            valueOf2 = String.valueOf(str);
            this.zzjxb = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            this.zzjxd = t;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    private static zzcui<String> zza(zzcup com_google_android_gms_internal_zzcup, String str, String str2) {
        return new zzcun(com_google_android_gms_internal_zzcup, str, str2);
    }

    private static <V> V zza(zzcuo<V> com_google_android_gms_internal_zzcuo_V) {
        V zzbct;
        long clearCallingIdentity;
        try {
            zzbct = com_google_android_gms_internal_zzcuo_V.zzbct();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            zzbct = com_google_android_gms_internal_zzcuo_V.zzbct();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return zzbct;
    }

    @TargetApi(24)
    private final T zzbcp() {
        if (!zzg("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            if (this.zzjxa.zzjxj != null) {
                String str = (String) zza(new zzcuj(this, zzctv.zza(zzair.getContentResolver(), this.zzjxa.zzjxj)));
                if (str != null) {
                    return zzkt(str);
                }
            } else if (this.zzjxa.zzjxi != null) {
                if (VERSION.SDK_INT >= 24 && !zzair.isDeviceProtectedStorage() && !((UserManager) zzair.getSystemService(UserManager.class)).isUserUnlocked()) {
                    return null;
                }
                SharedPreferences sharedPreferences = zzair.getSharedPreferences(this.zzjxa.zzjxi, 0);
                if (sharedPreferences.contains(this.zzjxb)) {
                    return zzb(sharedPreferences);
                }
            }
        }
        return null;
    }

    private final T zzbcq() {
        if (!this.zzjxa.zzjxm && zzbcr()) {
            String str = (String) zza(new zzcuk(this));
            if (str != null) {
                return zzkt(str);
            }
        }
        return null;
    }

    private static boolean zzbcr() {
        boolean z = false;
        if (zzjwz == null) {
            if (zzair == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(zzair, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzjwz = Boolean.valueOf(z);
        }
        return zzjwz.booleanValue();
    }

    public static void zzdz(Context context) {
        if (zzair == null) {
            synchronized (zzjwy) {
                if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (zzair != context) {
                    zzjwz = null;
                }
                zzair = context;
            }
            zzcek = false;
        }
    }

    static boolean zzg(String str, boolean z) {
        return zzbcr() ? ((Boolean) zza(new zzcul(str, false))).booleanValue() : false;
    }

    public final T get() {
        if (zzair == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        T zzbcq;
        if (this.zzjxa.zzjxn) {
            zzbcq = zzbcq();
            if (zzbcq != null) {
                return zzbcq;
            }
            zzbcq = zzbcp();
            if (zzbcq != null) {
                return zzbcq;
            }
        }
        zzbcq = zzbcp();
        if (zzbcq != null) {
            return zzbcq;
        }
        zzbcq = zzbcq();
        if (zzbcq != null) {
            return zzbcq;
        }
        return this.zzjxd;
    }

    public abstract T zzb(SharedPreferences sharedPreferences);

    final /* synthetic */ String zzbcs() {
        return zzdmf.zza(zzair.getContentResolver(), this.zzjxc, null);
    }

    public abstract T zzkt(String str);
}
