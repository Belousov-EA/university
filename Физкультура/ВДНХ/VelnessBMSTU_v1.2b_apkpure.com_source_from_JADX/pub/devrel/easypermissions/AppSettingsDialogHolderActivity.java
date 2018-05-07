package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.app.AppCompatActivity;

@RestrictTo({Scope.LIBRARY_GROUP})
public class AppSettingsDialogHolderActivity extends AppCompatActivity implements OnClickListener {
    public static Intent createShowDialogIntent(Context context, AppSettingsDialog dialog) {
        return new Intent(context, AppSettingsDialogHolderActivity.class).putExtra("extra_app_settings", dialog);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSettingsDialog dialog = (AppSettingsDialog) getIntent().getParcelableExtra("extra_app_settings");
        dialog.setContext(this);
        dialog.setActivityOrFragment(this);
        dialog.setNegativeListener(this);
        dialog.showDialog();
    }

    public void onClick(DialogInterface dialog, int which) {
        setResult(0);
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setResult(resultCode, data);
        finish();
    }
}
