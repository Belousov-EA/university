package com.google.firebase.auth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzdym;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser implements UserInfo {
    @NonNull
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzbre()).zzd(this);
    }

    @Nullable
    public abstract String getDisplayName();

    @Nullable
    public abstract String getEmail();

    @NonNull
    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzbre()).zza(this, z);
    }

    @Nullable
    public abstract FirebaseUserMetadata getMetadata();

    @Nullable
    public abstract String getPhoneNumber();

    @Nullable
    public abstract Uri getPhotoUrl();

    @NonNull
    public abstract List<? extends UserInfo> getProviderData();

    @NonNull
    public abstract String getProviderId();

    @Nullable
    public abstract List<String> getProviders();

    @Deprecated
    @NonNull
    public Task<GetTokenResult> getToken(boolean z) {
        return getIdToken(z);
    }

    @NonNull
    public abstract String getUid();

    public abstract boolean isAnonymous();

    @NonNull
    public Task<AuthResult> linkWithCredential(@NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzbre()).zzc(this, authCredential);
    }

    public Task<Void> reauthenticate(@NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzbre()).zza(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(@NonNull AuthCredential authCredential) {
        zzbq.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzbre()).zzb(this, authCredential);
    }

    @NonNull
    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zzbre()).zzc(this);
    }

    @NonNull
    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzbre()).zza(this, false).continueWithTask(new zzn(this));
    }

    @NonNull
    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzbre()).zza(this, false).continueWithTask(new zzo(this, actionCodeSettings));
    }

    public Task<AuthResult> unlink(@NonNull String str) {
        zzbq.zzgm(str);
        return FirebaseAuth.getInstance(zzbre()).zza(this, str);
    }

    @NonNull
    public Task<Void> updateEmail(@NonNull String str) {
        zzbq.zzgm(str);
        return FirebaseAuth.getInstance(zzbre()).zzb(this, str);
    }

    @NonNull
    public Task<Void> updatePassword(@NonNull String str) {
        zzbq.zzgm(str);
        return FirebaseAuth.getInstance(zzbre()).zzc(this, str);
    }

    public Task<Void> updatePhoneNumber(@NonNull PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzbre()).zza(this, phoneAuthCredential);
    }

    @NonNull
    public Task<Void> updateProfile(@NonNull UserProfileChangeRequest userProfileChangeRequest) {
        zzbq.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zzbre()).zza(this, userProfileChangeRequest);
    }

    public abstract void zza(@NonNull zzdym com_google_android_gms_internal_zzdym);

    @NonNull
    public abstract FirebaseUser zzaq(@NonNull List<? extends UserInfo> list);

    @NonNull
    public abstract FirebaseApp zzbre();

    @NonNull
    public abstract zzdym zzbrf();

    @NonNull
    public abstract String zzbrg();

    @NonNull
    public abstract String zzbrh();

    public abstract FirebaseUser zzcf(boolean z);
}
