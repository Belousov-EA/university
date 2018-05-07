package ru.mgvk.velness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.google.android.gms.common.SignInButton;
import ru.mgvk.wellness.R;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "LoginActivity";
    private Animation appearAnimation;
    private SignInButton googleButton;
    TextView label;
    private boolean updateChecked = false;
    UserSearch userSearch = new C08431();

    class C04262 implements OnClickListener {
        C04262() {
        }

        public void onClick(View view) {
            DBWorker.signIn(LoginActivity.this);
        }
    }

    class C08431 implements UserSearch {
        C08431() {
        }

        public void onUserFound() {
            Intent profileIntent = new Intent(LoginActivity.this, TabsActivity.class);
            LoginActivity.this.finish();
            LoginActivity.this.startActivity(profileIntent);
        }

        public void onUserNotFound() {
            Intent regIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
            LoginActivity.this.finish();
            LoginActivity.this.startActivity(regIntent);
        }

        public void onNeedLogin() {
            LoginActivity.this.googleButton.setVisibility(0);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        this.label = (TextView) findViewById(R.id.label);
        this.appearAnimation = AnimationUtils.loadAnimation(this, R.anim.appear);
    }

    public void onStart() {
        super.onStart();
        this.label.startAnimation(this.appearAnimation);
        DBWorker.init(this);
        User.init(getApplicationContext());
        DBWorker.authorizeUser(this.userSearch);
        this.googleButton = (SignInButton) findViewById(R.id.googleBtn);
        this.googleButton.setOnClickListener(new C04262());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(this.TAG, "onActivityResult: " + data.getPackage());
        DBWorker.onActivityResult(this, requestCode, data);
    }
}
