package ru.mgvk.velness.fragments;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Builder;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import ru.mgvk.velness.DBWorker;
import ru.mgvk.velness.DBWorker.UUIDsLoadingResult;
import ru.mgvk.velness.User;
import ru.mgvk.velness.util.BLEScannerService;
import ru.mgvk.velness.util.BLEScannerService.LocalBinder;
import ru.mgvk.velness.util.BLEScannerService.OnBeaconEventListener;
import ru.mgvk.wellness.R;

public class MeetingFragment extends Fragment implements ServiceConnection, OnBeaconEventListener {
    private static String APP_VERSION = "";
    private static final String[] SCOPES = new String[]{SheetsScopes.SPREADSHEETS};
    private static final String TAG = MeetingFragment.class.getSimpleName();
    private String DEVICE_ID = "";
    private String OS_VERSION = "";
    TextView btn;
    EditText f26e;
    String finishPressure = "";
    boolean isHere = false;
    private GoogleAccountCredential mCredential;
    private BLEScannerService mService;
    String startPressure = "";
    private ArrayList<String> uuids;

    class C04412 implements OnClickListener {
        C04412() {
        }

        public void onClick(View view) {
            if (MeetingFragment.this.btn.isActivated()) {
                MeetingFragment.this.openPressureDialog();
                if (MeetingFragment.this.isHere) {
                    MeetingFragment.this.btn.setText(MeetingFragment.this.getString(R.string.appear));
                } else {
                    MeetingFragment.this.btn.setText(MeetingFragment.this.getString(R.string.disappear));
                }
                MeetingFragment.this.isHere = !MeetingFragment.this.isHere;
                MeetingFragment.this.btn.setSelected(MeetingFragment.this.isHere);
                MeetingFragment.this.saveState();
                return;
            }
            MeetingFragment.this.openErrorDialog();
        }
    }

    class C04423 implements DialogInterface.OnClickListener {
        C04423() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (MeetingFragment.this.isHere) {
                MeetingFragment.this.startPressure = MeetingFragment.this.f26e.getText().toString();
                User.setTimeArrival(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date()));
                User.setPressureArrival(MeetingFragment.this.startPressure);
                User.save();
                return;
            }
            MeetingFragment.this.finishPressure = MeetingFragment.this.f26e.getText().toString();
            User.setPressureLeave(MeetingFragment.this.finishPressure);
            User.setTimeLeave(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date()));
            new MakeRequestTask(MeetingFragment.this.mCredential).execute(new Void[0]);
        }
    }

    private class MakeRequestTask extends AsyncTask<Void, Void, List<String>> {
        private Exception mLastError = null;
        private Sheets mService = null;

        MakeRequestTask(GoogleAccountCredential credential) {
            HttpTransport transport = AndroidHttp.newCompatibleTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            Log.d("TASK", "MakeRequestTask: " + credential.getSelectedAccountName());
            this.mService = new Builder(transport, jsonFactory, credential).setApplicationName("Google Sheets API Android Quickstart").build();
        }

        protected List<String> doInBackground(Void... params) {
            List<String> list = null;
            try {
                list = saveToTable();
            } catch (UserRecoverableAuthIOException e) {
                MeetingFragment.this.startActivityForResult(e.getIntent(), 123);
                this.mLastError = e;
                cancel(true);
                e.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return list;
        }

        private List<String> saveToTable() throws IOException {
            List<List<Object>> record = new ArrayList();
            List<Object> line = new ArrayList();
            line.add(User.getFullName());
            line.add(User.getEmail());
            line.add(User.getUsername());
            line.add(User.getGroup());
            line.add(User.getTeacher());
            line.add(User.getFOFType());
            line.add(User.getPhone());
            line.add(User.getTimeArrival());
            line.add(User.getTimeLeave());
            line.add(User.getPressureArrival());
            line.add(User.getPressureLeave());
            line.add("Android");
            line.add(MeetingFragment.this.OS_VERSION);
            line.add(MeetingFragment.APP_VERSION);
            line.add(MeetingFragment.this.DEVICE_ID);
            record.add(line);
            this.mService.spreadsheets().values().append("1oA1IsRaLssbCxe6fFvP72W4fjfjfmyStnqncQrPtq3k", "A1:A1", new ValueRange().setValues(record)).setValueInputOption("RAW").execute();
            return new ArrayList();
        }

        protected void onPostExecute(List<String> list) {
            MeetingFragment.this.openOkDialog();
        }

        protected void onCancelled() {
            MeetingFragment.this.openStrangeErrorDialog();
        }
    }

    class C08451 implements UUIDsLoadingResult {
        C08451() {
        }

        public void OnFinishLoading(ArrayList<String> uuids) {
            MeetingFragment.this.uuids = uuids;
            if (MeetingFragment.this.mService != null) {
                MeetingFragment.this.mService.addUUIDs(uuids);
            }
        }

        public void onError() {
            MeetingFragment.this.openErrorDialog();
        }
    }

    public static MeetingFragment newInstance() {
        return new MeetingFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meeting, container, false);
        this.btn = (TextView) rootView.findViewById(R.id.btn);
        if (getSavedState()) {
            this.isHere = true;
            this.btn.setSelected(true);
            this.btn.setText(getText(R.string.disappear));
        }
        return rootView;
    }

    public void onStart() {
        super.onStart();
        this.OS_VERSION = VERSION.RELEASE;
        try {
            APP_VERSION = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
            this.DEVICE_ID = Secure.getString(getContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mCredential = GoogleAccountCredential.usingOAuth2(getContext().getApplicationContext(), Arrays.asList(SCOPES)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(DBWorker.getGoogleAccountName());
        DBWorker.requestUUIDs(new C08451());
        this.btn.setOnClickListener(new C04412());
    }

    private void saveState() {
        getActivity().getSharedPreferences("Main", 0).edit().putBoolean("State", this.isHere).apply();
    }

    private boolean getSavedState() {
        return getActivity().getSharedPreferences("Main", 0).getBoolean("State", false);
    }

    private void openErrorDialog() {
        new AlertDialog.Builder(getContext()).setTitle("Что-то пошло не так :(").setMessage("Проверьте, включен ли BLUETOOTH.").setCancelable(true).setPositiveButton("Ok", null).create().show();
    }

    private void openPressureDialog() {
        this.f26e = new EditText(getContext());
        this.f26e.setText("");
        this.f26e.setInputType(4);
        this.f26e.setLayoutParams(new LayoutParams(-2, -2));
        new AlertDialog.Builder(getContext()).setTitle("Ваше артериальное давление").setView(this.f26e).setPositiveButton("Ok", new C04423()).setCancelable(false).create().show();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "Connected to scanner service");
        this.mService = ((LocalBinder) service).getService();
        this.mService.setBeaconEventListener(this);
        if (this.uuids != null) {
            this.mService.addUUIDs(this.uuids);
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "Disconnected from scanner service");
        this.mService = null;
    }

    public void onBeaconFound() {
        this.btn.setActivated(true);
        this.btn.setBackgroundResource(R.drawable.btn_appear_disappear);
    }

    public void onError() {
        this.btn.setActivated(false);
        this.btn.setBackgroundResource(R.drawable.btn_appear_disappear);
    }

    public void onStop() {
        super.onStop();
        getActivity().unbindService(this);
    }

    public void onResume() {
        super.onResume();
        User.load();
        getActivity().bindService(new Intent(getContext(), BLEScannerService.class), this, 1);
    }

    private void openOkDialog() {
        final AlertDialog a = new AlertDialog.Builder(getContext()).setMessage("Успех!").setCancelable(true).setPositiveButton("OK:)", null).create();
        a.show();
        new Timer().schedule(new TimerTask() {
            public void run() {
                a.dismiss();
            }
        }, 1500);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            new MakeRequestTask(this.mCredential).execute(new Void[0]);
        }
    }

    private void openStrangeErrorDialog() {
        new AlertDialog.Builder(getContext()).setTitle("Упс!...").setMessage("Кажется, произошла странная ошибка... Пожалуйста, напишите об этомразработчикам!:)").setPositiveButton("Закрыть", null).create().show();
    }
}
