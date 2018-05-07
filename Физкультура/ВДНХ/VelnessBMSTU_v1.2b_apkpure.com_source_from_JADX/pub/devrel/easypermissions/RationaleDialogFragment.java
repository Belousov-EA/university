package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

@RequiresApi(11)
public class RationaleDialogFragment extends DialogFragment {
    private PermissionCallbacks mPermissionCallbacks;

    static RationaleDialogFragment newInstance(@StringRes int positiveButton, @StringRes int negativeButton, @NonNull String rationaleMsg, int requestCode, @NonNull String[] permissions) {
        RationaleDialogFragment dialogFragment = new RationaleDialogFragment();
        dialogFragment.setArguments(new RationaleDialogConfig(positiveButton, negativeButton, rationaleMsg, requestCode, permissions).toBundle());
        return dialogFragment;
    }

    @SuppressLint({"NewApi"})
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((VERSION.SDK_INT >= 17) && getParentFragment() != null && (getParentFragment() instanceof PermissionCallbacks)) {
            this.mPermissionCallbacks = (PermissionCallbacks) getParentFragment();
        } else if (context instanceof PermissionCallbacks) {
            this.mPermissionCallbacks = (PermissionCallbacks) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mPermissionCallbacks = null;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        RationaleDialogConfig config = new RationaleDialogConfig(getArguments());
        return config.createDialog(getActivity(), new RationaleDialogClickListener(this, config, this.mPermissionCallbacks));
    }
}
