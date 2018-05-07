package ru.mgvk.velness.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.util.HashMap;
import ru.mgvk.velness.C0427R.id;
import ru.mgvk.velness.DBWorker;
import ru.mgvk.velness.DBWorker.CONSTS;
import ru.mgvk.velness.DBWorker.UserLoadingResult;
import ru.mgvk.velness.User;
import ru.mgvk.wellness.R;

public class ProfileFragment extends Fragment implements OnClickListener, UserLoadingResult {
    private Button editBtn;
    boolean editMode = false;
    private EditText email;
    private EditText fof_type;
    private EditText group;
    private boolean loaded = false;
    private EditText name;
    private EditText phone;
    private EditText teacher;
    private EditText username;

    public static ProfileFragment newInstance() {
        ProfileFragment meetingFragment = new ProfileFragment();
        DBWorker.setUserLoadingResult(meetingFragment);
        return meetingFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(rootView);
        return rootView;
    }

    void initViews(View rootView) {
        for (Field field : getClass().getDeclaredFields()) {
            if (field.getType() == EditText.class) {
                try {
                    field.set(this, rootView.findViewById(id.class.getField(field.getName()).getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.editBtn = (Button) rootView.findViewById(R.id.btn_profile_edit);
        this.editBtn.setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        if (!this.loaded) {
            loadData();
        }
    }

    void loadData() {
        try {
            this.name.setText(User.getFullName());
            this.group.setText(User.getGroup());
            this.teacher.setText(User.getTeacher());
            this.fof_type.setText(User.getFOFType());
            this.phone.setText(User.getPhone());
            this.email.setText(User.getEmail());
            this.username.setText(User.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean checkForEmpty() {
        try {
            if (this.name.getText().length() == 0 || this.group.getText().length() == 0 || this.teacher.getText().length() == 0 || this.fof_type.getText().length() == 0 || this.phone.getText().length() == 0 || this.email.getText().length() == 0 || this.username.getText().length() == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void onClick(View view) {
        toggleMode();
    }

    private void toggleMode() {
        if (!this.editMode) {
            this.editBtn.setText("Сохранить");
            enableViews();
            this.editMode = true;
        } else if (checkForEmpty()) {
            try {
                User.setFullName(String.valueOf(this.name.getText()));
                User.setGroup(String.valueOf(this.group.getText()));
                User.setTeacher(String.valueOf(this.teacher.getText()));
                User.setFOFType(String.valueOf(this.fof_type.getText()));
                User.setPhone(String.valueOf(this.phone.getText()));
                User.setEmail(String.valueOf(this.email.getText()));
                User.setUsername(String.valueOf(this.username.getText()));
                User.save();
                saveToDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.editBtn.setText("Редактировать профиль");
            disableViews();
            this.editMode = false;
        } else {
            Toast.makeText(getContext(), "Поля не могут быть пустыми!", 0).show();
        }
    }

    private void saveToDB() {
        HashMap<String, String> m = new HashMap();
        m.put(CONSTS.FULL_NAME, this.name.getText().toString());
        m.put(CONSTS.GROUP, this.group.getText().toString());
        m.put(CONSTS.TEACHER, this.teacher.getText().toString());
        m.put(CONSTS.FOF_TYPE, this.fof_type.getText().toString());
        m.put("phone", this.phone.getText().toString());
        m.put("email", this.email.getText().toString());
        m.put(CONSTS.USERNAME, this.username.getText().toString());
        DBWorker.saveUser(m);
    }

    private void enableViews() {
        this.name.setEnabled(true);
        this.group.setEnabled(true);
        this.teacher.setEnabled(true);
        this.fof_type.setEnabled(true);
        this.phone.setEnabled(true);
        this.email.setEnabled(true);
        this.username.setEnabled(true);
        int c = Color.parseColor("#689c5146");
        this.name.setBackgroundColor(c);
        this.group.setBackgroundColor(c);
        this.teacher.setBackgroundColor(c);
        this.fof_type.setBackgroundColor(c);
        this.phone.setBackgroundColor(c);
        this.email.setBackgroundColor(c);
        this.username.setBackgroundColor(c);
    }

    private void disableViews() {
        this.name.setEnabled(false);
        this.group.setEnabled(false);
        this.teacher.setEnabled(false);
        this.fof_type.setEnabled(false);
        this.phone.setEnabled(false);
        this.email.setEnabled(false);
        this.username.setEnabled(false);
        this.name.setBackgroundColor(0);
        this.group.setBackgroundColor(0);
        this.teacher.setBackgroundColor(0);
        this.fof_type.setBackgroundColor(0);
        this.phone.setBackgroundColor(0);
        this.email.setBackgroundColor(0);
        this.username.setBackgroundColor(0);
    }

    public void OnFinishLoading() {
        loadData();
        this.loaded = true;
    }

    public void onError() {
        Toast.makeText(getContext(), "При загрузке данных произошла ошибка!", 0).show();
    }

    public boolean onBackPressed() {
        if (!this.editMode) {
            return false;
        }
        toggleMode();
        return this.editMode;
    }
}
