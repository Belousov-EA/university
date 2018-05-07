package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatDialogFragment;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

@RequiresApi(17)
public class RationaleDialogFragmentCompat extends AppCompatDialogFragment {
    private PermissionCallbacks mPermissionCallbacks;

    static RationaleDialogFragmentCompat newInstance(@StringRes int positiveButton, @StringRes int negativeButton, @NonNull String rationaleMsg, int requestCode, @NonNull String[] permissions) {
        RationaleDialogFragmentCompat dialogFragment = new RationaleDialogFragmentCompat();
        dialogFragment.setArguments(new RationaleDialogConfig(positiveButton, negativeButton, rationaleMsg, requestCode, permissions).toBundle());
        return dialogFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() != null && (getParentFragment() instanceof PermissionCallbacks)) {
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
        return config.createDialog(getContext(), new RationaleDialogClickListener(this, config, this.mPermissionCallbacks));
    }
}
