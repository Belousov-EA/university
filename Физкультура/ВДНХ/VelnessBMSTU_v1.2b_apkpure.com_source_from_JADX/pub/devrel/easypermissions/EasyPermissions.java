package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EasyPermissions {
    private static final String DIALOG_TAG = "RationaleDialogFragmentCompat";
    private static final String TAG = "EasyPermissions";

    public interface PermissionCallbacks extends OnRequestPermissionsResultCallback {
        void onPermissionsDenied(int i, List<String> list);

        void onPermissionsGranted(int i, List<String> list);
    }

    public static boolean hasPermissions(@NonNull Context context, @NonNull String... perms) {
        if (VERSION.SDK_INT < 23) {
            Log.w(TAG, "hasPermissions: API version < M, returning true by default");
            return true;
        }
        for (String perm : perms) {
            boolean hasPerm;
            if (ContextCompat.checkSelfPermission(context, perm) == 0) {
                hasPerm = true;
            } else {
                hasPerm = false;
            }
            if (!hasPerm) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String rationale, int requestCode, @NonNull String... perms) {
        requestPermissions(activity, rationale, 17039370, 17039360, requestCode, perms);
    }

    @SuppressLint({"NewApi"})
    public static void requestPermissions(@NonNull Activity activity, @NonNull String rationale, @StringRes int positiveButton, @StringRes int negativeButton, int requestCode, @NonNull String... perms) {
        if (hasPermissions(activity, perms)) {
            notifyAlreadyHasPermissions(activity, requestCode, perms);
        } else if (shouldShowRationale(activity, perms)) {
            showRationaleDialogFragment(activity.getFragmentManager(), rationale, positiveButton, negativeButton, requestCode, perms);
        } else {
            ActivityCompat.requestPermissions(activity, perms, requestCode);
        }
    }

    public static void requestPermissions(@NonNull Fragment fragment, @NonNull String rationale, int requestCode, @NonNull String... perms) {
        requestPermissions(fragment, rationale, 17039370, 17039360, requestCode, perms);
    }

    @SuppressLint({"NewApi"})
    public static void requestPermissions(@NonNull Fragment fragment, @NonNull String rationale, @StringRes int positiveButton, @StringRes int negativeButton, int requestCode, @NonNull String... perms) {
        if (hasPermissions(fragment.getContext(), perms)) {
            notifyAlreadyHasPermissions(fragment, requestCode, perms);
        } else if (shouldShowRationale(fragment, perms)) {
            RationaleDialogFragmentCompat.newInstance(positiveButton, negativeButton, rationale, requestCode, perms).show(fragment.getChildFragmentManager(), DIALOG_TAG);
        } else {
            fragment.requestPermissions(perms, requestCode);
        }
    }

    @RequiresApi(api = 11)
    public static void requestPermissions(@NonNull android.app.Fragment fragment, @NonNull String rationale, int requestCode, @NonNull String... perms) {
        requestPermissions(fragment, rationale, 17039370, 17039360, requestCode, perms);
    }

    @SuppressLint({"NewApi"})
    @RequiresApi(api = 11)
    public static void requestPermissions(@NonNull android.app.Fragment fragment, @NonNull String rationale, @StringRes int positiveButton, @StringRes int negativeButton, int requestCode, @NonNull String... perms) {
        if (hasPermissions(fragment.getActivity(), perms)) {
            notifyAlreadyHasPermissions(fragment, requestCode, perms);
        } else if (shouldShowRationale(fragment, perms)) {
            showRationaleDialogFragment(fragment.getChildFragmentManager(), rationale, positiveButton, negativeButton, requestCode, perms);
        } else {
            fragment.requestPermissions(perms, requestCode);
        }
    }

    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, @NonNull Object... receivers) {
        List<String> granted = new ArrayList();
        List<String> denied = new ArrayList();
        for (int i = 0; i < permissions.length; i++) {
            String perm = permissions[i];
            if (grantResults[i] == 0) {
                granted.add(perm);
            } else {
                denied.add(perm);
            }
        }
        for (Object object : receivers) {
            if (!granted.isEmpty() && (object instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) object).onPermissionsGranted(requestCode, granted);
            }
            if (!denied.isEmpty() && (object instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) object).onPermissionsDenied(requestCode, denied);
            }
            if (!granted.isEmpty() && denied.isEmpty()) {
                runAnnotatedMethods(object, requestCode);
            }
        }
    }

    public static boolean somePermissionPermanentlyDenied(@NonNull Activity activity, @NonNull List<String> deniedPermissions) {
        for (String deniedPermission : deniedPermissions) {
            if (permissionPermanentlyDenied(activity, deniedPermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean somePermissionPermanentlyDenied(@NonNull Fragment fragment, @NonNull List<String> deniedPermissions) {
        for (String deniedPermission : deniedPermissions) {
            if (permissionPermanentlyDenied(fragment, deniedPermission)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean somePermissionPermanentlyDenied(@NonNull android.app.Fragment fragment, @NonNull List<String> deniedPermissions) {
        for (String deniedPermission : deniedPermissions) {
            if (permissionPermanentlyDenied(fragment, deniedPermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean permissionPermanentlyDenied(@NonNull Activity activity, @NonNull String deniedPermission) {
        return !shouldShowRequestPermissionRationale(activity, deniedPermission);
    }

    public static boolean permissionPermanentlyDenied(@NonNull Fragment fragment, @NonNull String deniedPermission) {
        return !shouldShowRequestPermissionRationale(fragment, deniedPermission);
    }

    @RequiresApi(api = 23)
    public static boolean permissionPermanentlyDenied(@NonNull android.app.Fragment fragment, @NonNull String deniedPermission) {
        return !shouldShowRequestPermissionRationale(fragment, deniedPermission);
    }

    private static void notifyAlreadyHasPermissions(Object object, int requestCode, @NonNull String[] perms) {
        int[] grantResults = new int[perms.length];
        for (int i = 0; i < perms.length; i++) {
            grantResults[i] = 0;
        }
        onRequestPermissionsResult(requestCode, perms, grantResults, object);
    }

    private static boolean shouldShowRationale(@NonNull Object object, @NonNull String[] perms) {
        boolean shouldShowRationale = false;
        for (String perm : perms) {
            if (shouldShowRationale || shouldShowRequestPermissionRationale(object, perm)) {
                shouldShowRationale = true;
            } else {
                shouldShowRationale = false;
            }
        }
        return shouldShowRationale;
    }

    private static boolean shouldShowRequestPermissionRationale(@NonNull Object object, @NonNull String perm) {
        if (object instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        }
        if (object instanceof Fragment) {
            return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        }
        if (!(object instanceof android.app.Fragment)) {
            throw new IllegalArgumentException("Object was neither an Activity nor a Fragment.");
        } else if (VERSION.SDK_INT >= 23) {
            return ((android.app.Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
        }
    }

    @RequiresApi(api = 11)
    private static void showRationaleDialogFragment(@NonNull FragmentManager fragmentManager, @NonNull String rationale, @StringRes int positiveButton, @StringRes int negativeButton, int requestCode, @NonNull String... perms) {
        RationaleDialogFragment.newInstance(positiveButton, negativeButton, rationale, requestCode, perms).show(fragmentManager, DIALOG_TAG);
    }

    private static void runAnnotatedMethods(@NonNull Object object, int requestCode) {
        Class clazz = object.getClass();
        if (isUsingAndroidAnnotations(object)) {
            clazz = clazz.getSuperclass();
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterPermissionGranted.class) && ((AfterPermissionGranted) method.getAnnotation(AfterPermissionGranted.class)).value() == requestCode) {
                if (method.getParameterTypes().length > 0) {
                    throw new RuntimeException("Cannot execute method " + method.getName() + " because it is non-void method and/or has input parameters.");
                }
                try {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    method.invoke(object, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.e(TAG, "runDefaultMethod:IllegalAccessException", e);
                } catch (InvocationTargetException e2) {
                    Log.e(TAG, "runDefaultMethod:InvocationTargetException", e2);
                }
            }
        }
    }

    private static boolean isUsingAndroidAnnotations(@NonNull Object object) {
        boolean z = false;
        if (object.getClass().getSimpleName().endsWith("_")) {
            try {
                z = Class.forName("org.androidannotations.api.view.HasViews").isInstance(object);
            } catch (ClassNotFoundException e) {
            }
        }
        return z;
    }
}
