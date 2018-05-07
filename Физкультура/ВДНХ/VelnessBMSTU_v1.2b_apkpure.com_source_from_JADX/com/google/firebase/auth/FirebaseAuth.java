package com.google.firebase.auth;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.internal.zzdwc;
import com.google.android.gms.internal.zzdxm;
import com.google.android.gms.internal.zzdxr;
import com.google.android.gms.internal.zzdxu;
import com.google.android.gms.internal.zzdxv;
import com.google.android.gms.internal.zzdym;
import com.google.android.gms.internal.zzdyu;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.internal.zze;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzs;
import com.google.firebase.auth.internal.zzu;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.zzc;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalTokenProvider {
    private static Map<String, FirebaseAuth> zzifg = new ArrayMap();
    private static FirebaseAuth zzmdg;
    private List<IdTokenListener> zzmav;
    private FirebaseApp zzmcx;
    private List<AuthStateListener> zzmcy;
    private zzdwc zzmcz;
    private FirebaseUser zzmda;
    private final Object zzmdb;
    private String zzmdc;
    private zzr zzmdd;
    private zzs zzmde;
    private zzu zzmdf;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    class zza implements com.google.firebase.auth.internal.zza {
        private /* synthetic */ FirebaseAuth zzmdi;

        zza(FirebaseAuth firebaseAuth) {
            this.zzmdi = firebaseAuth;
        }

        public final void zza(@NonNull zzdym com_google_android_gms_internal_zzdym, @NonNull FirebaseUser firebaseUser) {
            zzbq.checkNotNull(com_google_android_gms_internal_zzdym);
            zzbq.checkNotNull(firebaseUser);
            firebaseUser.zza(com_google_android_gms_internal_zzdym);
            this.zzmdi.zza(firebaseUser, com_google_android_gms_internal_zzdym, true);
        }
    }

    class zzb extends zza implements com.google.firebase.auth.internal.zza, zzp {
        private /* synthetic */ FirebaseAuth zzmdi;

        zzb(FirebaseAuth firebaseAuth) {
            this.zzmdi = firebaseAuth;
            super(firebaseAuth);
        }

        public final void onError(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
                this.zzmdi.signOut();
            }
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzdxr.zza(firebaseApp.getApplicationContext(), new zzdxu(firebaseApp.getOptions().getApiKey()).zzbrq()), new zzr(firebaseApp.getApplicationContext(), firebaseApp.zzbqp()));
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzdwc com_google_android_gms_internal_zzdwc, zzr com_google_firebase_auth_internal_zzr) {
        this.zzmdb = new Object();
        this.zzmcx = (FirebaseApp) zzbq.checkNotNull(firebaseApp);
        this.zzmcz = (zzdwc) zzbq.checkNotNull(com_google_android_gms_internal_zzdwc);
        this.zzmdd = (zzr) zzbq.checkNotNull(com_google_firebase_auth_internal_zzr);
        this.zzmav = new CopyOnWriteArrayList();
        this.zzmcy = new CopyOnWriteArrayList();
        this.zzmdf = zzu.zzbsj();
        this.zzmda = this.zzmdd.zzbsh();
        if (this.zzmda != null) {
            zzdym zzg = this.zzmdd.zzg(this.zzmda);
            if (zzg != null) {
                zza(this.zzmda, zzg, false);
            }
        }
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return zzb(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return zzb(firebaseApp);
    }

    private final void zza(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 45).append("Notifying id token listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.zzmdf.execute(new zzj(this, new zzc(firebaseUser != null ? firebaseUser.zzbrh() : null)));
    }

    private final synchronized void zza(zzs com_google_firebase_auth_internal_zzs) {
        this.zzmde = com_google_firebase_auth_internal_zzs;
        this.zzmcx.zza((com.google.firebase.FirebaseApp.zzb) com_google_firebase_auth_internal_zzs);
    }

    private static synchronized FirebaseAuth zzb(@NonNull FirebaseApp firebaseApp) {
        FirebaseAuth firebaseAuth;
        synchronized (FirebaseAuth.class) {
            firebaseAuth = (FirebaseAuth) zzifg.get(firebaseApp.zzbqp());
            if (firebaseAuth == null) {
                firebaseAuth = new zzg(firebaseApp);
                firebaseApp.zza((InternalTokenProvider) firebaseAuth);
                if (zzmdg == null) {
                    zzmdg = firebaseAuth;
                }
                zzifg.put(firebaseApp.zzbqp(), firebaseAuth);
            }
        }
        return firebaseAuth;
    }

    private final void zzb(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 47).append("Notifying auth state listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzmdf.execute(new zzk(this));
    }

    private final synchronized zzs zzbrc() {
        if (this.zzmde == null) {
            zza(new zzs(this.zzmcx));
        }
        return this.zzmde;
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzmcy.add(authStateListener);
        this.zzmdf.execute(new zzi(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzmav.add(idTokenListener);
        this.zzmdf.execute(new zzh(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zzc(this.zzmcx, str);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zzb(this.zzmcx, str);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        return this.zzmcz.zza(this.zzmcx, str, str2);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        return this.zzmcz.zza(this.zzmcx, str, str2, new zza(this));
    }

    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zza(this.zzmcx, str);
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzmda;
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzmdb) {
            str = this.zzmdc;
        }
        return str;
    }

    @Nullable
    public final String getUid() {
        return this.zzmda == null ? null : this.zzmda.getUid();
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzmcy.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzmav.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        zzbq.zzgm(str);
        return sendPasswordResetEmail(str, null);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        zzbq.zzgm(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.newBuilder().build();
        }
        if (this.zzmdc != null) {
            actionCodeSettings.zzou(this.zzmdc);
        }
        actionCodeSettings.zzgl(1);
        return this.zzmcz.zza(this.zzmcx, str, actionCodeSettings);
    }

    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zzmcz.setFirebaseUIVersion(str);
    }

    public void setLanguageCode(@NonNull String str) {
        zzbq.zzgm(str);
        synchronized (this.zzmdb) {
            this.zzmdc = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        if (this.zzmda == null || !this.zzmda.isAnonymous()) {
            return this.zzmcz.zza(this.zzmcx, new zza(this));
        }
        zzh com_google_firebase_auth_internal_zzh = (zzh) this.zzmda;
        com_google_firebase_auth_internal_zzh.zzci(false);
        return Tasks.forResult(new zze(com_google_firebase_auth_internal_zzh));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            return this.zzmcz.zzb(this.zzmcx, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zza(this));
        } else if (!(authCredential instanceof PhoneAuthCredential)) {
            return this.zzmcz.zza(this.zzmcx, authCredential, new zza(this));
        } else {
            return this.zzmcz.zza(this.zzmcx, (PhoneAuthCredential) authCredential, new zza(this));
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zza(this.zzmcx, str, new zza(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        return this.zzmcz.zzb(this.zzmcx, str, str2, new zza(this));
    }

    public void signOut() {
        zzbrb();
        if (this.zzmde != null) {
            this.zzmde.cancel();
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzmdb) {
            this.zzmdc = zzdxv.zzbrr();
        }
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zzd(this.zzmcx, str);
    }

    @NonNull
    public final Task<Void> zza(@NonNull ActionCodeSettings actionCodeSettings, @NonNull String str) {
        zzbq.zzgm(str);
        if (this.zzmdc != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.newBuilder().build();
            }
            actionCodeSettings.zzou(this.zzmdc);
        }
        return this.zzmcz.zza(this.zzmcx, actionCodeSettings, str);
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return authCredential instanceof PhoneAuthCredential ? this.zzmcz.zzb(this.zzmcx, firebaseUser, (PhoneAuthCredential) authCredential, new zzb(this)) : this.zzmcz.zza(this.zzmcx, firebaseUser, authCredential, new zzb(this));
        } else {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            return this.zzmcz.zza(this.zzmcx, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zzb(this));
        }
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(phoneAuthCredential);
        return this.zzmcz.zza(this.zzmcx, firebaseUser, phoneAuthCredential, new zzb(this));
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(userProfileChangeRequest);
        return this.zzmcz.zza(this.zzmcx, firebaseUser, userProfileChangeRequest, new zzb(this));
    }

    @NonNull
    public final Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzbq.zzgm(str);
        zzbq.checkNotNull(firebaseUser);
        return this.zzmcz.zzd(this.zzmcx, firebaseUser, str, new zzb(this));
    }

    @NonNull
    public final Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzdxm.zzao(new Status(17495)));
        }
        zzdym zzbrf = this.zzmda.zzbrf();
        return (!zzbrf.isValid() || z) ? this.zzmcz.zza(this.zzmcx, firebaseUser, zzbrf.zzbru(), new zzl(this)) : Tasks.forResult(new GetTokenResult(zzbrf.getAccessToken()));
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzdym com_google_android_gms_internal_zzdym, boolean z) {
        Object obj;
        Object obj2 = 1;
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_android_gms_internal_zzdym);
        if (this.zzmda == null) {
            obj = 1;
        } else {
            obj = !this.zzmda.zzbrf().getAccessToken().equals(com_google_android_gms_internal_zzdym.getAccessToken()) ? 1 : null;
            boolean equals = this.zzmda.getUid().equals(firebaseUser.getUid());
            if (equals && obj == null) {
                obj = null;
            } else {
                int i = 1;
            }
            if (equals) {
                obj2 = null;
            }
        }
        zzbq.checkNotNull(firebaseUser);
        if (this.zzmda == null) {
            this.zzmda = firebaseUser;
        } else {
            this.zzmda.zzcf(firebaseUser.isAnonymous());
            this.zzmda.zzaq(firebaseUser.getProviderData());
        }
        if (z) {
            this.zzmdd.zzf(this.zzmda);
        }
        if (obj != null) {
            if (this.zzmda != null) {
                this.zzmda.zza(com_google_android_gms_internal_zzdym);
            }
            zza(this.zzmda);
        }
        if (obj2 != null) {
            zzb(this.zzmda);
        }
        if (z) {
            this.zzmdd.zza(firebaseUser, com_google_android_gms_internal_zzdym);
        }
        zzbrc().zzc(this.zzmda.zzbrf());
    }

    @NonNull
    public final void zza(@NonNull String str, long j, TimeUnit timeUnit, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor, boolean z) {
        String str2 = null;
        Context applicationContext = this.zzmcx.getApplicationContext();
        zzbq.checkNotNull(applicationContext);
        zzbq.zzgm(str);
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        Object simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        if (TextUtils.isEmpty(simCountryIso)) {
            Locale locale = Locale.getDefault();
            simCountryIso = locale != null ? locale.getCountry() : null;
        }
        String toUpperCase = TextUtils.isEmpty(simCountryIso) ? "US" : simCountryIso.toUpperCase(Locale.US);
        String stripSeparators = PhoneNumberUtils.stripSeparators(str);
        if (zzq.zzamn()) {
            str2 = PhoneNumberUtils.formatNumberToE164(stripSeparators, toUpperCase);
            if (TextUtils.isEmpty(str2)) {
                str2 = stripSeparators;
            }
        } else if (!"US".equals(toUpperCase)) {
            str2 = stripSeparators;
        } else if (stripSeparators != null) {
            int length = stripSeparators.length();
            if (!stripSeparators.startsWith("+")) {
                if (length == 11 && stripSeparators.startsWith("1")) {
                    str2 = "+".concat(stripSeparators);
                } else if (length == 10) {
                    str2 = "+1".concat(stripSeparators);
                }
            }
            str2 = stripSeparators;
        }
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zzmcz.zza(this.zzmcx, new zzdyu(str2, convert, z, this.zzmdc), onVerificationStateChangedCallbacks, activity, executor);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return authCredential instanceof PhoneAuthCredential ? this.zzmcz.zzc(this.zzmcx, firebaseUser, authCredential, new zzb(this)) : this.zzmcz.zzb(this.zzmcx, firebaseUser, authCredential, new zzb(this));
        } else {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            return this.zzmcz.zzb(this.zzmcx, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zzb(this));
        }
    }

    @NonNull
    public final Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.zzgm(str);
        return this.zzmcz.zzb(this.zzmcx, firebaseUser, str, new zzb(this));
    }

    public final void zzbrb() {
        if (this.zzmda != null) {
            zzr com_google_firebase_auth_internal_zzr = this.zzmdd;
            zzbq.checkNotNull(this.zzmda);
            com_google_firebase_auth_internal_zzr.clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{r1.getUid()}));
            this.zzmda = null;
        }
        this.zzmdd.clear("com.google.firebase.auth.FIREBASE_USER");
        zza(null);
        zzb(null);
    }

    @NonNull
    public final Task<Void> zzc(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        return this.zzmcz.zza(this.zzmcx, firebaseUser, new zzb(this));
    }

    @NonNull
    public final Task<AuthResult> zzc(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(authCredential);
        zzbq.checkNotNull(firebaseUser);
        return this.zzmcz.zzd(this.zzmcx, firebaseUser, authCredential, new zzb(this));
    }

    @NonNull
    public final Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.zzgm(str);
        return this.zzmcz.zzc(this.zzmcx, firebaseUser, str, new zzb(this));
    }

    @NonNull
    public final Task<GetTokenResult> zzce(boolean z) {
        return zza(this.zzmda, z);
    }

    @NonNull
    public final Task<Void> zzd(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        return this.zzmcz.zza(firebaseUser, new zzm(this, firebaseUser));
    }

    @NonNull
    public final Task<Void> zzov(@NonNull String str) {
        zzbq.zzgm(str);
        return this.zzmcz.zza(this.zzmcx, null, str);
    }
}
