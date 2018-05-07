package com.google.firebase.auth.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzh extends FirebaseUser {
    private boolean zzmgk;
    private zzdym zzmhh;
    private zzf zzmhi;
    private String zzmhj;
    private String zzmhk = "com.google.firebase.auth.internal.DefaultFirebaseUser";
    private List<zzf> zzmhl;
    private List<String> zzmhm;
    private Map<String, zzf> zzmhn;
    private String zzmho = "2";
    private boolean zzmhp;
    private FirebaseUserMetadata zzmhq;

    public zzh(@NonNull FirebaseApp firebaseApp, @NonNull List<? extends UserInfo> list) {
        zzbq.checkNotNull(firebaseApp);
        this.zzmhj = firebaseApp.getName();
        zzaq(list);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzmhi.getDisplayName();
    }

    @Nullable
    public String getEmail() {
        return this.zzmhi.getEmail();
    }

    public FirebaseUserMetadata getMetadata() {
        return this.zzmhq;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzmhi.getPhoneNumber();
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzmhi.getPhotoUrl();
    }

    @NonNull
    public List<? extends UserInfo> getProviderData() {
        return this.zzmhl;
    }

    @NonNull
    public String getProviderId() {
        return this.zzmhi.getProviderId();
    }

    @Nullable
    public final List<String> getProviders() {
        return this.zzmhm;
    }

    @NonNull
    public String getUid() {
        return this.zzmhi.getUid();
    }

    public boolean isAnonymous() {
        return this.zzmhp;
    }

    public boolean isEmailVerified() {
        return this.zzmhi.isEmailVerified();
    }

    public final boolean isNewUser() {
        return this.zzmgk;
    }

    public final void zza(@NonNull zzdym com_google_android_gms_internal_zzdym) {
        this.zzmhh = (zzdym) zzbq.checkNotNull(com_google_android_gms_internal_zzdym);
    }

    public final void zza(FirebaseUserMetadata firebaseUserMetadata) {
        this.zzmhq = firebaseUserMetadata;
    }

    @NonNull
    public final FirebaseUser zzaq(@NonNull List<? extends UserInfo> list) {
        zzbq.checkNotNull(list);
        this.zzmhl = new ArrayList(list.size());
        this.zzmhm = new ArrayList(list.size());
        this.zzmhn = new ArrayMap();
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzmhi = (zzf) userInfo;
            } else {
                this.zzmhm.add(userInfo.getProviderId());
            }
            this.zzmhl.add((zzf) userInfo);
            this.zzmhn.put(userInfo.getProviderId(), (zzf) userInfo);
        }
        if (this.zzmhi == null) {
            this.zzmhi = (zzf) this.zzmhl.get(0);
        }
        return this;
    }

    @NonNull
    public final FirebaseApp zzbre() {
        return FirebaseApp.getInstance(this.zzmhj);
    }

    @NonNull
    public final zzdym zzbrf() {
        return this.zzmhh;
    }

    @NonNull
    public final String zzbrg() {
        return this.zzmhh.zzabg();
    }

    @NonNull
    public final String zzbrh() {
        return zzbrf().getAccessToken();
    }

    public final List<zzf> zzbsc() {
        return this.zzmhl;
    }

    public final /* synthetic */ FirebaseUser zzcf(boolean z) {
        this.zzmhp = z;
        return this;
    }

    public final void zzci(boolean z) {
        this.zzmgk = z;
    }

    public final zzh zzpc(@NonNull String str) {
        this.zzmho = str;
        return this;
    }
}
