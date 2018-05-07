package ru.mgvk.velness.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Builder;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.mgvk.velness.DBWorker;
import ru.mgvk.velness.User;

public class SpreadSheets extends Activity {
    private static final String BUTTON_TEXT = "Call Google Sheets API";
    private static final String[] SCOPES = new String[]{SheetsScopes.SPREADSHEETS};
    private Button mCallApiButton;
    GoogleAccountCredential mCredential;
    private TextView mOutputText;
    ProgressDialog mProgress;

    class C04451 implements OnClickListener {
        C04451() {
        }

        public void onClick(View v) {
            SpreadSheets.this.mCallApiButton.setEnabled(false);
            SpreadSheets.this.mOutputText.setText("");
            new MakeRequestTask(SpreadSheets.this.mCredential).execute(new Void[0]);
            SpreadSheets.this.mCallApiButton.setEnabled(true);
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
            try {
                return getDataFromApi();
            } catch (Exception e) {
                this.mLastError = e;
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        private List<String> getDataFromApi() throws IOException {
            List<List<Object>> row = new ArrayList();
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
            row.add(line);
            this.mService.spreadsheets().values().append("1oA1IsRaLssbCxe6fFvP72W4fjfjfmyStnqncQrPtq3k", "A1:A1", new ValueRange().setValues(row)).setValueInputOption("RAW").execute();
            return new ArrayList();
        }

        protected void onPreExecute() {
            SpreadSheets.this.mOutputText.setText("");
            SpreadSheets.this.mProgress.show();
        }

        protected void onPostExecute(List<String> output) {
            SpreadSheets.this.mProgress.hide();
            if (output == null || output.size() == 0) {
                SpreadSheets.this.mOutputText.setText("No results returned.");
                return;
            }
            output.add(0, "Data retrieved using the Google Sheets API:");
            SpreadSheets.this.mOutputText.setText(TextUtils.join("\n", output));
        }

        protected void onCancelled() {
            Toast.makeText(SpreadSheets.this, "Plak:(", 0).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout activityLayout = new LinearLayout(this);
        activityLayout.setLayoutParams(new LayoutParams(-1, -1));
        activityLayout.setOrientation(1);
        activityLayout.setPadding(16, 16, 16, 16);
        ViewGroup.LayoutParams tlp = new ViewGroup.LayoutParams(-2, -2);
        this.mCallApiButton = new Button(this);
        this.mCallApiButton.setText(BUTTON_TEXT);
        this.mCallApiButton.setOnClickListener(new C04451());
        activityLayout.addView(this.mCallApiButton);
        this.mOutputText = new TextView(this);
        this.mOutputText.setLayoutParams(tlp);
        this.mOutputText.setPadding(16, 16, 16, 16);
        this.mOutputText.setVerticalScrollBarEnabled(true);
        this.mOutputText.setMovementMethod(new ScrollingMovementMethod());
        this.mOutputText.setText("Click the 'Call Google Sheets API' button to test the API.");
        activityLayout.addView(this.mOutputText);
        this.mProgress = new ProgressDialog(this);
        this.mProgress.setMessage("Calling Google Sheets API ...");
        setContentView(activityLayout);
        this.mCredential = GoogleAccountCredential.usingOAuth2(getApplicationContext(), Arrays.asList(SCOPES)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(DBWorker.getGoogleAccountName());
    }
}
