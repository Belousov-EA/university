package ru.mgvk.velness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.HashMap;
import ru.mgvk.velness.DBWorker.CONSTS;
import ru.mgvk.wellness.R;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editFullName;
    private EditText editGroup;
    private EditText editPhone;
    private EditText editTeacher;
    private EditText editUserName;
    private String fofData = "";
    private int fofSpinnerPosition;
    private Button regButton;
    private Spinner spinner;
    private String[] spinnerData = new String[]{"АФК", "ФВ", "АФК отработка", "Студент МГЛУ"};

    class C04281 implements OnClickListener {
        C04281() {
        }

        public void onClick(View view) {
            if (RegistrationActivity.this.editGroup.getText().toString().equals("") || RegistrationActivity.this.editTeacher.getText().toString().equals("") || RegistrationActivity.this.fofData.equals("") || RegistrationActivity.this.editPhone.getText().toString().equals("")) {
                Toast.makeText(RegistrationActivity.this, "Необходимо заполнить все поля", 0).show();
                return;
            }
            HashMap<String, String> data = new HashMap();
            data.put(CONSTS.FOF_TYPE, RegistrationActivity.this.spinner.getSelectedItem().toString());
            data.put(CONSTS.FULL_NAME, RegistrationActivity.this.editFullName.getText().toString());
            data.put(CONSTS.GROUP, RegistrationActivity.this.editGroup.getText().toString());
            data.put(CONSTS.TEACHER, RegistrationActivity.this.editTeacher.getText().toString());
            data.put("phone", RegistrationActivity.this.editPhone.getText().toString());
            data.put(CONSTS.PROFILE_IMG_URL, RegistrationActivity.this.editPhone.getText().toString());
            data.put(CONSTS.USERNAME, RegistrationActivity.this.editUserName.getText().toString());
            if (DBWorker.saveUser(data)) {
                RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this, TabsActivity.class));
                RegistrationActivity.this.finish();
                return;
            }
            Toast.makeText(RegistrationActivity.this, "Произошла ошибка!", 0).show();
        }
    }

    class C04292 implements OnItemSelectedListener {
        C04292() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            RegistrationActivity.this.fofData = RegistrationActivity.this.spinnerData[position];
            RegistrationActivity.this.fofSpinnerPosition = position;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_registration);
        ActionBar b = getSupportActionBar();
        if (b != null) {
            b.setTitle((CharSequence) "Регистрация");
        }
        this.regButton = (Button) findViewById(R.id.regBtn);
        this.editFullName = (EditText) findViewById(R.id.loginEdit);
        this.editGroup = (EditText) findViewById(R.id.groupEdit);
        this.editTeacher = (EditText) findViewById(R.id.prepodEdit);
        this.editPhone = (EditText) findViewById(R.id.telEdit);
        this.editUserName = (EditText) findViewById(R.id.usernameEdit);
        this.regButton.setOnClickListener(new C04281());
        ArrayAdapter<String> adapter = new ArrayAdapter(this, 17367048, this.spinnerData);
        adapter.setDropDownViewResource(17367049);
        this.spinner = (Spinner) findViewById(R.id.spinner2);
        this.spinner.setAdapter(adapter);
        this.spinner.setPrompt("ФОФ");
        this.spinner.setOnItemSelectedListener(new C04292());
    }
}
