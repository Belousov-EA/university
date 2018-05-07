package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.zzv;

public final class GooglePlayServicesUtil extends zzp {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzp.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zzp.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return zzp.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zzp.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzp.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zzp.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, i, i2, onCancelListener);
        }
        GoogleApiAvailability.getInstance();
        Dialog zza = GoogleApiAvailability.zza((Context) activity, i, zzv.zza(fragment, zzf.zza(activity, i, "d"), i2), onCancelListener);
        if (zza == null) {
            return false;
        }
        GoogleApiAvailability.zza(activity, zza, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (!zzp.zze(context, i)) {
            if (!(i == 9 ? zzp.zzv(context, "com.android.vending") : false)) {
                instance.showErrorNotification(context, i);
                return;
            }
        }
        instance.zzcc(context);
    }
}
