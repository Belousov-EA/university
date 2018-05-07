package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzi;
import com.google.firebase.auth.internal.zzo;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzdwc extends zzdvv<zzdxt> {
    zzdwc(@NonNull Context context, @NonNull zzdxt com_google_android_gms_internal_zzdxt) {
        super(context, zzdxr.zzmfc, com_google_android_gms_internal_zzdxt, new zzb(), DynamiteModule.zzac(context, "com.google.android.gms.firebase_auth"), DynamiteModule.zzab(context, "com.google.firebase.auth"), Collections.EMPTY_MAP);
    }

    private static <ResultT, CallbackT> zzdwn<ResultT, CallbackT> zza(zzdxx<ResultT, CallbackT> com_google_android_gms_internal_zzdxx_ResultT__CallbackT, String str) {
        return new zzdwn(com_google_android_gms_internal_zzdxx_ResultT__CallbackT, str);
    }

    @NonNull
    private static zzh zza(@NonNull FirebaseApp firebaseApp, @NonNull zzdyk com_google_android_gms_internal_zzdyk) {
        return zza(firebaseApp, com_google_android_gms_internal_zzdyk, false);
    }

    @NonNull
    private static zzh zza(@NonNull FirebaseApp firebaseApp, @NonNull zzdyk com_google_android_gms_internal_zzdyk, boolean z) {
        zzbq.checkNotNull(firebaseApp);
        zzbq.checkNotNull(com_google_android_gms_internal_zzdyk);
        List arrayList = new ArrayList();
        arrayList.add(new zzf(com_google_android_gms_internal_zzdyk, FirebaseAuthProvider.PROVIDER_ID));
        List zzbrt = com_google_android_gms_internal_zzdyk.zzbrt();
        if (!(zzbrt == null || zzbrt.isEmpty())) {
            for (int i = 0; i < zzbrt.size(); i++) {
                arrayList.add(new zzf((zzdyo) zzbrt.get(i)));
            }
        }
        FirebaseUser com_google_firebase_auth_internal_zzh = new zzh(firebaseApp, arrayList);
        com_google_firebase_auth_internal_zzh.zzcf(z);
        com_google_firebase_auth_internal_zzh.zza(new zzi(com_google_android_gms_internal_zzdyk.getLastSignInTimestamp(), com_google_android_gms_internal_zzdyk.getCreationTimestamp()));
        com_google_firebase_auth_internal_zzh.zzci(com_google_android_gms_internal_zzdyk.isNewUser());
        return com_google_firebase_auth_internal_zzh;
    }

    @NonNull
    public final Task<Void> setFirebaseUIVersion(@NonNull String str) {
        return zzb(zza(new zzdww(str), "setFirebaseUIVersion"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull ActionCodeSettings actionCodeSettings, @NonNull String str) {
        return zzb(zza(new zzdwu(str, actionCodeSettings).zzc(firebaseApp), "sendEmailVerification"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdwy(authCredential).zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "signInWithCredential"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdwo(authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithCredential"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdxg(phoneAuthCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "updatePhoneNumber"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdxh(userProfileChangeRequest).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "updateProfile"));
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zza(zza(new zzdwt().zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reload"));
    }

    public final Task<GetTokenResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zza(zza(new zzdwj(str).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "getAccessToken"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdwq(str, str2).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithEmailPassword"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdxb(phoneAuthCredential).zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "signInWithPhoneNumber"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdwx().zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "signInAnonymously"));
    }

    public final Task<ProviderQueryResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zza(zza(new zzdwi(str).zzc(firebaseApp), "fetchProvidersForEmail"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzgl(1);
        return zzb(zza(new zzdwv(str, actionCodeSettings).zzc(firebaseApp), "sendPasswordResetEmail"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdwz(str).zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "signInWithCustomToken"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2) {
        return zzb(zza(new zzdwf(str, str2).zzc(firebaseApp), "confirmPasswordReset"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdwg(str, str2).zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "createUserWithEmailAndPassword"));
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull zzo com_google_firebase_auth_internal_zzo) {
        return zzb(zza(new zzdwh().zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzo).zza((zzp) com_google_firebase_auth_internal_zzo), "delete"));
    }

    public final void zza(@NonNull FirebaseApp firebaseApp, @NonNull zzdyu com_google_android_gms_internal_zzdyu, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor) {
        zzb(zza(new zzdxj(com_google_android_gms_internal_zzdyu).zzc(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor), "verifyPhoneNumber"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdwp(authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithCredentialWithData"));
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdws(phoneAuthCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithPhoneCredential"));
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdxe(str).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "updateEmail"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdwr(str, str2).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithEmailPasswordWithData"));
    }

    public final Task<ActionCodeResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzdwe(str).zzc(firebaseApp), "checkActionCode"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zza com_google_firebase_auth_internal_zza) {
        return zzb(zza(new zzdxa(str, str2).zzc(firebaseApp).zzbc(com_google_firebase_auth_internal_zza), "signInWithEmailAndPassword"));
    }

    public final Task<AuthResult> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdwp(authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "reauthenticateWithPhoneCredentialWithData"));
    }

    public final Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        return zzb(zza(new zzdxf(str).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "updatePassword"));
    }

    public final Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzdwd(str).zzc(firebaseApp), "applyActionCode"));
    }

    public final Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        zzbq.checkNotNull(firebaseApp);
        zzbq.checkNotNull(authCredential);
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_firebase_auth_internal_zzv);
        List providers = firebaseUser.getProviders();
        if (providers != null && providers.contains(authCredential.getProvider())) {
            return Tasks.forException(zzdxm.zzao(new Status(17015)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            return zzb(zza(new zzdwk((EmailAuthCredential) authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "linkEmailAuthCredential"));
        }
        if (authCredential instanceof PhoneAuthCredential) {
            return zzb(zza(new zzdwm((PhoneAuthCredential) authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "linkPhoneAuthCredential"));
        }
        zzbq.checkNotNull(firebaseApp);
        zzbq.checkNotNull(authCredential);
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_firebase_auth_internal_zzv);
        return zzb(zza(new zzdwl(authCredential).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "linkFederatedCredential"));
    }

    public final Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzv com_google_firebase_auth_internal_zzv) {
        zzbq.checkNotNull(firebaseApp);
        zzbq.zzgm(str);
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_firebase_auth_internal_zzv);
        List providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzdxm.zzao(new Status(17016, str)));
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case 1216985755:
                if (str.equals(EmailAuthProvider.PROVIDER_ID)) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return zzb(zza(new zzdxc().zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "unlinkEmailCredential"));
            default:
                return zzb(zza(new zzdxd(str).zzc(firebaseApp).zze(firebaseUser).zzbc(com_google_firebase_auth_internal_zzv).zza((zzp) com_google_firebase_auth_internal_zzv), "unlinkFederatedCredential"));
        }
    }

    public final Task<String> zzd(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzdxi(str).zzc(firebaseApp), "verifyPasswordResetCode"));
    }
}
