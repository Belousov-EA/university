package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

public class AppSettingsDialog implements Parcelable, OnClickListener {
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final Creator<AppSettingsDialog> CREATOR = new C04241();
    public static final int DEFAULT_SETTINGS_REQ_CODE = 16061;
    static final String EXTRA_APP_SETTINGS = "extra_app_settings";
    private Object mActivityOrFragment;
    private Context mContext;
    private final String mNegativeButtonText;
    private OnClickListener mNegativeListener;
    private final String mPositiveButtonText;
    private final String mRationale;
    private final int mRequestCode;
    private final String mTitle;

    static class C04241 implements Creator<AppSettingsDialog> {
        C04241() {
        }

        public AppSettingsDialog createFromParcel(Parcel in) {
            return new AppSettingsDialog(in);
        }

        public AppSettingsDialog[] newArray(int size) {
            return new AppSettingsDialog[size];
        }
    }

    public static class Builder {
        private Object mActivityOrFragment;
        private Context mContext;
        private String mNegativeButton;
        private OnClickListener mNegativeListener;
        private String mPositiveButton;
        private String mRationale;
        private int mRequestCode = -1;
        private String mTitle;

        @Deprecated
        public Builder(@NonNull Activity activity, @NonNull String rationale) {
            this.mActivityOrFragment = activity;
            this.mContext = activity;
            this.mRationale = rationale;
        }

        @Deprecated
        public Builder(@NonNull Fragment fragment, @NonNull String rationale) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getContext();
            this.mRationale = rationale;
        }

        @RequiresApi(api = 11)
        @Deprecated
        public Builder(@NonNull android.app.Fragment fragment, @NonNull String rationale) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getActivity();
            this.mRationale = rationale;
        }

        public Builder(@NonNull Activity activity) {
            this.mActivityOrFragment = activity;
            this.mContext = activity;
        }

        public Builder(@NonNull Fragment fragment) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getContext();
        }

        @RequiresApi(api = 11)
        public Builder(@NonNull android.app.Fragment fragment) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getActivity();
        }

        public Builder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            this.mTitle = this.mContext.getString(title);
            return this;
        }

        public Builder setRationale(String rationale) {
            this.mRationale = rationale;
            return this;
        }

        public Builder setRationale(@StringRes int rationale) {
            this.mRationale = this.mContext.getString(rationale);
            return this;
        }

        public Builder setPositiveButton(String positiveButton) {
            this.mPositiveButton = positiveButton;
            return this;
        }

        public Builder setPositiveButton(@StringRes int positiveButton) {
            this.mPositiveButton = this.mContext.getString(positiveButton);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(String negativeButton, OnClickListener negativeListener) {
            this.mNegativeButton = negativeButton;
            this.mNegativeListener = negativeListener;
            return this;
        }

        public Builder setNegativeButton(String negativeButton) {
            this.mNegativeButton = negativeButton;
            return this;
        }

        public Builder setNegativeButton(@StringRes int negativeButton) {
            this.mNegativeButton = this.mContext.getString(negativeButton);
            return this;
        }

        public Builder setRequestCode(int requestCode) {
            this.mRequestCode = requestCode;
            return this;
        }

        public AppSettingsDialog build() {
            this.mRationale = TextUtils.isEmpty(this.mRationale) ? this.mContext.getString(C0425R.string.rationale_ask_again) : this.mRationale;
            this.mTitle = TextUtils.isEmpty(this.mTitle) ? this.mContext.getString(C0425R.string.title_settings_dialog) : this.mTitle;
            this.mPositiveButton = TextUtils.isEmpty(this.mPositiveButton) ? this.mContext.getString(17039370) : this.mPositiveButton;
            this.mNegativeButton = TextUtils.isEmpty(this.mNegativeButton) ? this.mContext.getString(17039360) : this.mNegativeButton;
            this.mRequestCode = this.mRequestCode > 0 ? this.mRequestCode : AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE;
            return new AppSettingsDialog(this.mActivityOrFragment, this.mContext, this.mRationale, this.mTitle, this.mPositiveButton, this.mNegativeButton, this.mNegativeListener, this.mRequestCode);
        }
    }

    private AppSettingsDialog(Parcel in) {
        this.mRationale = in.readString();
        this.mTitle = in.readString();
        this.mPositiveButtonText = in.readString();
        this.mNegativeButtonText = in.readString();
        this.mRequestCode = in.readInt();
    }

    private AppSettingsDialog(@NonNull Object activityOrFragment, @NonNull Context context, @Nullable String rationale, @Nullable String title, @Nullable String positiveButtonText, @Nullable String negativeButtonText, @Nullable OnClickListener negativeListener, int requestCode) {
        this.mActivityOrFragment = activityOrFragment;
        this.mContext = context;
        this.mRationale = rationale;
        this.mTitle = title;
        this.mPositiveButtonText = positiveButtonText;
        this.mNegativeButtonText = negativeButtonText;
        this.mNegativeListener = negativeListener;
        this.mRequestCode = requestCode;
    }

    void setActivityOrFragment(Object activityOrFragment) {
        this.mActivityOrFragment = activityOrFragment;
    }

    void setContext(Context context) {
        this.mContext = context;
    }

    void setNegativeListener(OnClickListener negativeListener) {
        this.mNegativeListener = negativeListener;
    }

    @RequiresApi(api = 11)
    private void startForResult(Intent intent) {
        if (this.mActivityOrFragment instanceof Activity) {
            ((Activity) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        } else if (this.mActivityOrFragment instanceof Fragment) {
            ((Fragment) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        } else if (this.mActivityOrFragment instanceof android.app.Fragment) {
            ((android.app.Fragment) this.mActivityOrFragment).startActivityForResult(intent, this.mRequestCode);
        }
    }

    public void show() {
        if (this.mNegativeListener == null) {
            startForResult(AppSettingsDialogHolderActivity.createShowDialogIntent(this.mContext, this));
        } else {
            showDialog();
        }
    }

    void showDialog() {
        new android.support.v7.app.AlertDialog.Builder(this.mContext).setCancelable(false).setTitle(this.mTitle).setMessage(this.mRationale).setPositiveButton(this.mPositiveButtonText, (OnClickListener) this).setNegativeButton(this.mNegativeButtonText, this.mNegativeListener).create().show();
    }

    public void onClick(DialogInterface dialog, int which) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        startForResult(intent);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(this.mRationale);
        dest.writeString(this.mTitle);
        dest.writeString(this.mPositiveButtonText);
        dest.writeString(this.mNegativeButtonText);
        dest.writeInt(this.mRequestCode);
    }
}
