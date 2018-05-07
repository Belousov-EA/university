package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zza;
import com.google.android.gms.common.zzp;
import com.google.android.gms.internal.zzbgg;
import java.io.IOException;
import java.util.List;

public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    @SuppressLint({"InlinedApi"})
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @SuppressLint({"InlinedApi"})
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    private static String[] zzeca = new String[]{"com.google", "com.google.work", "cn.google"};
    private static final ComponentName zzecb = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final zzbgg zzecc = new zzbgg("Auth", "GoogleAuthUtil");

    zzd() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        zzbp(context);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        zza(context, zzecb, new zzf(str, bundle));
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        zzbq.zzh(str, "accountName must be provided");
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        zzbp(context);
        return (List) zza(context, zzecb, new zzg(str, i));
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        zzbq.zzh(str, "accountName must be provided");
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        zzbp(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzc(account);
        return zzb(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) throws GoogleAuthException, IOException {
        zzbq.checkNotNull(context);
        zzc(account);
        zzbp(context);
        return (Bundle) zza(context, zzecb, new zzh(account));
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        zzbq.checkNotNull(context);
        zzbp(context);
        return (Boolean) zza(context, zzecb, new zzi(context.getApplicationInfo().packageName));
    }

    private static <T> T zza(Context context, ComponentName componentName, zzj<T> com_google_android_gms_auth_zzj_T) throws IOException, GoogleAuthException {
        Throwable e;
        ServiceConnection com_google_android_gms_common_zza = new zza();
        zzag zzco = zzag.zzco(context);
        if (zzco.zza(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil")) {
            try {
                T zzac = com_google_android_gms_auth_zzj_T.zzac(com_google_android_gms_common_zza.zzafw());
                zzco.zzb(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                return zzac;
            } catch (RemoteException e2) {
                e = e2;
                try {
                    zzecc.zze("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                } catch (Throwable th) {
                    zzco.zzb(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                }
            } catch (InterruptedException e3) {
                e = e3;
                zzecc.zze("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        }
        throw new IOException("Could not bind to service.");
    }

    public static TokenData zzb(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzbq.zzgn("Calling this from your main thread can lead to deadlock");
        zzbq.zzh(str, "Scope cannot be empty or null.");
        zzc(account);
        zzbp(context);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzecb, new zze(account, str, bundle2));
    }

    private static void zzbp(Context context) throws GoogleAuthException {
        try {
            zzp.zzbp(context.getApplicationContext());
        } catch (UserRecoverableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    private static void zzc(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        } else {
            String[] strArr = zzeca;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!strArr[i].equals(account.type)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
    }

    private static <T> T zzp(T t) throws IOException {
        if (t != null) {
            return t;
        }
        zzecc.zzf("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
