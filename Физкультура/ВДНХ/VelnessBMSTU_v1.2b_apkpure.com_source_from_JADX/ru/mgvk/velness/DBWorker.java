package ru.mgvk.velness;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import ru.mgvk.velness.UI.Event.EventData;
import ru.mgvk.wellness.R;

public class DBWorker {
    private static final String DBURL = "https://velnes-mr-test.firebaseio.com/";
    private static final int RC_SIGN_IN = 2;
    private static final String TAG = "DBWorker";
    private static String accountName;
    private static AuthStateListener authStateListener;
    static boolean authorized = false;
    private static DatabaseReference bleRef;
    private static DatabaseReference constantsRef;
    private static Context context;
    private static EventLoadingResult eventLoadingResult;
    private static ArrayList<EventData> events;
    private static DatabaseReference eventsRef;
    private static FirebaseAuth mAuth;
    private static GoogleSignInClient mGoogleSignInClient;
    private static NeedAppUpdateChecker needAppUpdateChecker;
    private static boolean needUpdate = false;
    private static boolean updateCheckError = false;
    private static boolean updateChecked = false;
    private static UserLoadingResult userLoadingResult;
    private static UserSearch userSearch;
    private static DatabaseReference usersRef;
    private static ArrayList<String> uuids;
    private static UUIDsLoadingResult uuidsLoadingResult;

    public static class CONSTS {
        public static final String EMAIL = "email";
        public static final String FOF_TYPE = "FOFType";
        public static final String FULL_NAME = "fullName";
        public static final String GROUP = "group";
        public static final String PHONE = "phone";
        public static final String PROFILE_IMG_URL = "profileImageURL";
        public static final String TEACHER = "teacher";
        public static final String UID = "uid";
        public static final String USERNAME = "username";
        public static String[] all = new String[]{FOF_TYPE, "email", FULL_NAME, GROUP, "phone", PROFILE_IMG_URL, TEACHER, UID, USERNAME};
    }

    public interface EventLoadingResult {
        void OnFinishLoading(ArrayList<EventData> arrayList);

        void onError();
    }

    interface NeedAppUpdateChecker {
        void onError();

        void onResult(boolean z);
    }

    public interface UUIDsLoadingResult {
        void OnFinishLoading(ArrayList<String> arrayList);

        void onError();
    }

    public interface UserLoadingResult {
        void OnFinishLoading();

        void onError();
    }

    interface UserSearch {
        void onNeedLogin();

        void onUserFound();

        void onUserNotFound();
    }

    static class C08371 implements AuthStateListener {
        C08371() {
        }

        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            Log.d(DBWorker.TAG, "onAuthStateChanged: " + firebaseAuth.getCurrentUser());
            if (firebaseAuth.getCurrentUser() != null) {
                DBWorker.checkUser(firebaseAuth.getCurrentUser().getEmail());
            } else {
                DBWorker.userSearch.onNeedLogin();
            }
        }
    }

    static class C08393 implements ValueEventListener {
        C08393() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            try {
                boolean z;
                if (((Integer) dataSnapshot.child("Android").child("currentVersionCode").getValue(Integer.class)).intValue() > DBWorker.context.getPackageManager().getPackageInfo(DBWorker.context.getPackageName(), 0).versionCode) {
                    z = true;
                } else {
                    z = false;
                }
                DBWorker.needUpdate = z;
                if (DBWorker.needAppUpdateChecker != null) {
                    DBWorker.needAppUpdateChecker.onResult(DBWorker.needUpdate);
                }
            } catch (Exception e) {
                e.printStackTrace();
                DBWorker.updateCheckError = true;
                if (DBWorker.needAppUpdateChecker != null) {
                    DBWorker.needAppUpdateChecker.onError();
                }
            }
            DBWorker.updateChecked = true;
        }

        public void onCancelled(DatabaseError databaseError) {
            DBWorker.updateCheckError = true;
            if (DBWorker.needAppUpdateChecker != null) {
                DBWorker.needAppUpdateChecker.onError();
            }
            DBWorker.updateChecked = true;
        }
    }

    static class C08415 implements ValueEventListener {
        C08415() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            if (DBWorker.eventLoadingResult != null) {
                String[] keys = new String[]{"eventDate", "eventLatitude", "eventLongitude", "eventName", "eventPlace", "eventTime"};
                int i = 0;
                for (DataSnapshot event : dataSnapshot.getChildren()) {
                    int i2 = i + 1;
                    EventData eventData = new EventData(i);
                    for (String key : keys) {
                        try {
                            eventData.getClass().getMethod("set" + key.substring(5), new Class[]{String.class}).invoke(eventData, new Object[]{event.child(keys[r8]).getValue().toString()});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        DBWorker.events.add(eventData);
                        i = i2;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        DBWorker.eventLoadingResult.onError();
                    }
                }
                DBWorker.eventLoadingResult.OnFinishLoading(DBWorker.events);
            }
        }

        public void onCancelled(DatabaseError databaseError) {
            if (DBWorker.eventLoadingResult != null) {
                DBWorker.eventLoadingResult.onError();
            }
        }
    }

    static class C08426 implements ValueEventListener {
        C08426() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            if (DBWorker.uuidsLoadingResult != null) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    DBWorker.uuids.add(DBWorker.unDash((String) dataSnapshot1.child("UUID").getValue(String.class)));
                }
                DBWorker.uuidsLoadingResult.OnFinishLoading(DBWorker.uuids);
            }
        }

        public void onCancelled(DatabaseError databaseError) {
            if (DBWorker.uuidsLoadingResult != null) {
                DBWorker.uuidsLoadingResult.onError();
            }
        }
    }

    public static void init(Activity context) {
        context = context;
        FirebaseApp.initializeApp(context);
        usersRef = FirebaseDatabase.getInstance(DBURL).getReference("users");
        eventsRef = FirebaseDatabase.getInstance(DBURL).getReference("events");
        bleRef = FirebaseDatabase.getInstance(DBURL).getReference("ble");
        constantsRef = FirebaseDatabase.getInstance(DBURL).getReference("constants");
        mGoogleSignInClient = GoogleSignIn.getClient(context, new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(context.getString(R.string.default_web_client_id)).requestEmail().build());
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(new C08371());
        loadSavedAccountName(context);
    }

    private static void loadSavedAccountName(Activity activity) {
        accountName = activity.getSharedPreferences("Account", 0).getString("AccountName", "");
    }

    public static void authorizeUser(UserSearch uSearch) {
        userSearch = uSearch;
    }

    public static void onActivityResult(Activity activity, int requestCode, Intent data) {
        if (requestCode == 2) {
            try {
                GoogleSignInAccount account = (GoogleSignInAccount) GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class);
                saveAccountName(activity, account.getAccount());
                Log.d(TAG, "onActivityResult: " + account.getEmail());
                firebaseAuthWithGoogle(account, activity);
            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(activity, "Аутентификация не удалась, повторите позже или обратитесь в службу поддержки", 0).show();
            }
        }
    }

    private static void saveAccountName(Activity activity, Account account) {
        activity.getSharedPreferences("Account", 0).edit().putString("AccountName", account.name).apply();
    }

    private static void firebaseAuthWithGoogle(GoogleSignInAccount account, final Activity activity) {
        mAuth.signInWithCredential(GoogleAuthProvider.getCredential(account.getIdToken(), null)).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(DBWorker.TAG, "onComplete: DBWorker" + task.isSuccessful());
                if (task.isSuccessful()) {
                    Log.d("TAG", "signInWithCredential:success");
                    DBWorker.mAuth.getCurrentUser();
                    return;
                }
                Log.w("TAG", "signInWithCredential:failure", task.getException());
                Toast.makeText(activity, "Authentication failed.", 0).show();
            }
        });
    }

    static void checkAppUpdates() {
        constantsRef.addValueEventListener(new C08393());
    }

    public static boolean isNeedUpdate() {
        return needUpdate;
    }

    static void checkUser(final String uid) {
        usersRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (DBWorker.userSearch != null && !DBWorker.authorized) {
                    try {
                        DataSnapshot user = dataSnapshot.child(DBWorker.undotUID(uid));
                        if (((String) user.child(CONSTS.UID).getValue(String.class)).equals(DBWorker.undotUID(uid))) {
                            DBWorker.userSearch.onUserFound();
                            DBWorker.authorized = true;
                            DBWorker.loadUserData(user);
                            return;
                        }
                        DBWorker.userSearch.onUserNotFound();
                    } catch (Exception e) {
                        e.printStackTrace();
                        DBWorker.userSearch.onUserNotFound();
                    }
                }
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.toException().printStackTrace();
            }
        });
        checkAppUpdates();
    }

    private static void loadUserData(DataSnapshot dataSnapshot) {
        try {
            User.load();
            User.setFOFType((String) dataSnapshot.child(CONSTS.FOF_TYPE).getValue(String.class));
            User.setEmail((String) dataSnapshot.child("email").getValue(String.class));
            User.setFullName((String) dataSnapshot.child(CONSTS.FULL_NAME).getValue(String.class));
            User.setGroup((String) dataSnapshot.child(CONSTS.GROUP).getValue(String.class));
            User.setProfileImgURL((String) dataSnapshot.child(CONSTS.PROFILE_IMG_URL).getValue(String.class));
            User.setTeacher((String) dataSnapshot.child(CONSTS.TEACHER).getValue(String.class));
            User.setUsername((String) dataSnapshot.child(CONSTS.USERNAME).getValue(String.class));
            User.setPhone((String) dataSnapshot.child("phone").getValue(String.class));
            User.save();
            if (userLoadingResult != null) {
                userLoadingResult.OnFinishLoading();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (userLoadingResult != null) {
                userLoadingResult.onError();
            }
        }
    }

    private static void loadEvents() {
        events = new ArrayList();
        eventsRef.addValueEventListener(new C08415());
    }

    private static String undotUID(String uid) {
        return uid.replace(".", "");
    }

    public static boolean saveUser(HashMap<String, String> data) {
        try {
            String uid = mAuth.getCurrentUser().getEmail();
            data.put("email", uid);
            data.put(CONSTS.UID, undotUID(uid));
            DatabaseReference userTable = usersRef.child(undotUID(uid));
            String[] fields = CONSTS.all;
            for (int i = 0; i < fields.length; i++) {
                userTable.child(fields[i]).setValue(data.get(fields[i]));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void requestEvents(EventLoadingResult eventLoadingResult) {
        eventLoadingResult = eventLoadingResult;
        loadEvents();
    }

    public static ArrayList<EventData> getEvents() {
        if (events == null) {
            return new ArrayList();
        }
        return events;
    }

    public static void requestUUIDs(UUIDsLoadingResult result) {
        uuidsLoadingResult = result;
        loadUUIDs();
    }

    private static void loadUUIDs() {
        uuids = new ArrayList();
        bleRef.addValueEventListener(new C08426());
    }

    private static String unDash(String uuid) {
        return uuid.replace("-", "");
    }

    public static String getGoogleAccountName() {
        return accountName;
    }

    static void signIn(Activity activity) {
        activity.startActivityForResult(mGoogleSignInClient.getSignInIntent(), 2);
    }

    public static void setUserLoadingResult(UserLoadingResult userLoadingResult) {
        userLoadingResult = userLoadingResult;
    }

    public static void setNeedAppUpdateChecker(NeedAppUpdateChecker needAppUpdateChecker) {
        needAppUpdateChecker = needAppUpdateChecker;
    }

    public static void requestAppUpdateCheck() {
        checkAppUpdates();
    }

    public static boolean isUpdateError() {
        return updateCheckError;
    }

    void onDestroy() {
    }
}
