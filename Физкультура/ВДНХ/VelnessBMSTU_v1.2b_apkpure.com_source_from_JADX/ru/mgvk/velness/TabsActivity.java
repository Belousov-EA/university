package ru.mgvk.velness;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import ru.mgvk.velness.UI.Tab;
import ru.mgvk.velness.UI.UI;
import ru.mgvk.velness.fragments.EventsFragment;
import ru.mgvk.velness.fragments.MeetingFragment;
import ru.mgvk.velness.fragments.ProfileFragment;
import ru.mgvk.wellness.R;

public class TabsActivity extends AppCompatActivity implements OnTabSelectedListener {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ProfileFragment profileFragment;

    class C04301 implements OnClickListener {
        C04301() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            System.exit(0);
        }
    }

    class C04312 implements OnClickListener {
        C04312() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            System.exit(0);
        }
    }

    class C04323 implements OnClickListener {
        C04323() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                TabsActivity.this.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("market://details?id=ru.mgvk.wellness")).addFlags(1207959552));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C04334 implements OnCancelListener {
        C04334() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            TabsActivity.this.finish();
        }
    }

    class C04345 implements OnClickListener {
        C04345() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TabsActivity.this.finish();
        }
    }

    class C04356 implements OnClickListener {
        C04356() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TabsActivity.this.showErrorDialog();
        }
    }

    class C04367 implements OnClickListener {
        C04367() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TabsActivity.this.requestPermission();
        }
    }

    class C04378 implements OnClickListener {
        C04378() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TabsActivity.this.requestPermission();
        }
    }

    class C04389 implements OnClickListener {
        C04389() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TabsActivity.this.requestPermission();
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MeetingFragment.newInstance();
                case 1:
                    return EventsFragment.newInstance();
                case 2:
                    return TabsActivity.this.profileFragment = ProfileFragment.newInstance();
                default:
                    return new Fragment();
            }
        }

        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Отметиться";
                case 1:
                    return "Мероприятия";
                case 2:
                    return "Профиль";
                default:
                    return null;
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_tabs);
        initViews();
    }

    private void showUpdateErrorDialog() {
        new Builder(this).setTitle("Ошибка!").setMessage("Невозможно проверить версию приложения").setPositiveButton("Выход", new C04301()).setCancelable(false).create().show();
    }

    private void showNeedUpdateDialog() {
        new Builder(this).setTitle("Внимание!").setMessage("Данная версия приложения больше не поддерживается, пожалуйста, обновите приложение!").setPositiveButton("Обновить", new C04323()).setNegativeButton("Выход", new C04312()).setCancelable(false).create().show();
    }

    protected void onStop() {
        super.onStop();
        User.save();
    }

    protected void onResume() {
        super.onResume();
        User.init(getApplicationContext());
    }

    private void initViews() {
        UI.init(this);
        this.mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        this.mViewPager = (ViewPager) findViewById(R.id.container);
        this.mViewPager.setAdapter(this.mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(this.mViewPager);
        tabLayout.getTabAt(0).setCustomView(new Tab(this, 0));
        tabLayout.getTabAt(1).setCustomView(new Tab(this, 1));
        tabLayout.getTabAt(2).setCustomView(new Tab(this, 2));
        tabLayout.addOnTabSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        ((Tab) tab.getCustomView()).setSelected(true);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        ((Tab) tab.getCustomView()).setSelected(false);
    }

    public void onTabReselected(TabLayout.Tab tab) {
        ((Tab) tab.getCustomView()).setSelected(true);
    }

    protected void onStart() {
        super.onStart();
        if (DBWorker.isUpdateError()) {
            showUpdateErrorDialog();
        } else if (DBWorker.isNeedUpdate()) {
            showNeedUpdateDialog();
        }
        if (VERSION.SDK_INT < 21) {
            openUnsupportedDialog();
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.GET_ACCOUNTS") == -1) {
            showRequestDialog();
        }
    }

    private void openUnsupportedDialog() {
        new Builder(this).setTitle("Ошибка!").setMessage("К сожалению, ваша операционная система не поддерживает Bluetooth LE. Для корректной работы приложения необходимо иметь Android 5.0+").setPositiveButton("ok", new C04345()).setOnCancelListener(new C04334()).create().show();
    }

    private void showRequestDialog() {
        new Builder(this).setTitle("Внимание!").setMessage("Для корректной работы приложения необходимо дать разрешение на опредление точного местоположения и чтение данных аккаунта.").setPositiveButton("Запросить разрешения", new C04367()).setNegativeButton("Отмена", new C04356()).setCancelable(false).create().show();
    }

    private void requestPermission() {
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.GET_ACCOUNTS"}, 1001);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == -1) {
            showErrorDialog();
        }
        if (grantResults.length > 1 && grantResults[1] == -1) {
            showSecondErrorDialog();
        }
    }

    private void showSecondErrorDialog() {
        new Builder(this).setTitle("Внимание!").setMessage("Недостаточно разрешений для корректной работы авторизации! Приложение будет работать некорректно!").setPositiveButton("Ok", null).setNegativeButton("Запросить повторно", new C04378()).create().show();
    }

    private void showErrorDialog() {
        new Builder(this).setTitle("Внимание!").setMessage("Недостаточно разрешений для корректной работы с bluetooth модулем! Приложение будет работать некорректно!").setPositiveButton("Ok", null).setNegativeButton("Запросить повторно", new C04389()).create().show();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode != 4 || this.profileFragment == null) {
            return super.onKeyUp(keyCode, event);
        }
        return this.profileFragment.onBackPressed() && super.onKeyUp(keyCode, event);
    }

    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
