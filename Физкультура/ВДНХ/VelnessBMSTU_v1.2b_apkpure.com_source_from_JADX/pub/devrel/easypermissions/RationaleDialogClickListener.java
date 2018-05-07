package pub.devrel.easypermissions;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import java.util.Arrays;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

class RationaleDialogClickListener implements OnClickListener {
    private PermissionCallbacks mCallbacks;
    private RationaleDialogConfig mConfig;
    private Object mHost;

    RationaleDialogClickListener(RationaleDialogFragmentCompat compatDialogFragment, RationaleDialogConfig config, PermissionCallbacks callbacks) {
        Object parentFragment;
        if (compatDialogFragment.getParentFragment() != null) {
            parentFragment = compatDialogFragment.getParentFragment();
        } else {
            parentFragment = compatDialogFragment.getActivity();
        }
        this.mHost = parentFragment;
        this.mConfig = config;
        this.mCallbacks = callbacks;
    }

    @RequiresApi(api = 11)
    RationaleDialogClickListener(RationaleDialogFragment dialogFragment, RationaleDialogConfig config, PermissionCallbacks callbacks) {
        if (VERSION.SDK_INT >= 17) {
            Object parentFragment;
            if (dialogFragment.getParentFragment() != null) {
                parentFragment = dialogFragment.getParentFragment();
            } else {
                parentFragment = dialogFragment.getActivity();
            }
            this.mHost = parentFragment;
        } else {
            this.mHost = dialogFragment.getActivity();
        }
        this.mConfig = config;
        this.mCallbacks = callbacks;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (which != -1) {
            notifyPermissionDenied();
        } else if (this.mHost instanceof Fragment) {
            ((Fragment) this.mHost).requestPermissions(this.mConfig.permissions, this.mConfig.requestCode);
        } else {
            ActivityCompat.requestPermissions((FragmentActivity) this.mHost, this.mConfig.permissions, this.mConfig.requestCode);
        }
    }

    private void notifyPermissionDenied() {
        if (this.mCallbacks != null) {
            this.mCallbacks.onPermissionsDenied(this.mConfig.requestCode, Arrays.asList(this.mConfig.permissions));
        }
    }
}
