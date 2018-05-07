package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgg;
import com.google.android.gms.internal.zzdvu;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzr {
    private Context mContext;
    private SharedPreferences zzbhh = this.mContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzmhz}), 0);
    private zzbgg zzehz = new zzbgg("StorageHelpers", new String[0]);
    private String zzmhz;

    public zzr(@NonNull Context context, @NonNull String str) {
        zzbq.checkNotNull(context);
        this.zzmhz = zzbq.zzgm(str);
        this.mContext = context.getApplicationContext();
    }

    private final zzh zzaa(@NonNull JSONObject jSONObject) {
        Throwable e;
        try {
            Object string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = "2";
            String string3 = jSONObject.getString("version");
            String str2 = string3 != null ? string3 : str;
            JSONArray jSONArray = jSONObject.getJSONArray("userInfos");
            int length = jSONArray.length();
            List arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzf.zzpb(jSONArray.getString(i)));
            }
            FirebaseUser com_google_firebase_auth_internal_zzh = new zzh(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                com_google_firebase_auth_internal_zzh.zza(zzdym.zzpa(string));
            }
            ((zzh) com_google_firebase_auth_internal_zzh.zzcf(z)).zzpc(str2);
            return com_google_firebase_auth_internal_zzh;
        } catch (JSONException e2) {
            e = e2;
            this.zzehz.zze(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e3) {
            e = e3;
            this.zzehz.zze(e);
            return null;
        } catch (IllegalArgumentException e4) {
            e = e4;
            this.zzehz.zze(e);
            return null;
        } catch (zzdvu e5) {
            e = e5;
            this.zzehz.zze(e);
            return null;
        }
    }

    @Nullable
    private final String zzh(@NonNull FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzh.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzh com_google_firebase_auth_internal_zzh = (zzh) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", com_google_firebase_auth_internal_zzh.zzbrg());
            jSONObject.put("applicationName", com_google_firebase_auth_internal_zzh.zzbre().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (com_google_firebase_auth_internal_zzh.zzbsc() != null) {
                JSONArray jSONArray = new JSONArray();
                List zzbsc = com_google_firebase_auth_internal_zzh.zzbsc();
                for (int i = 0; i < zzbsc.size(); i++) {
                    jSONArray.put(((zzf) zzbsc.get(i)).zzabg());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", com_google_firebase_auth_internal_zzh.isAnonymous());
            jSONObject.put("version", "2");
            return jSONObject.toString();
        } catch (Throwable e) {
            this.zzehz.zza("Failed to turn object into JSON", e, new Object[0]);
            throw new zzdvu(e);
        }
    }

    public final void clear(String str) {
        this.zzbhh.edit().remove(str).apply();
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzdym com_google_android_gms_internal_zzdym) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_android_gms_internal_zzdym);
        this.zzbhh.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), com_google_android_gms_internal_zzdym.zzabg()).apply();
    }

    @Nullable
    public final FirebaseUser zzbsh() {
        FirebaseUser firebaseUser = null;
        Object string = this.zzbhh.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("type")) {
                    if ("com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                        firebaseUser = zzaa(jSONObject);
                    }
                }
            } catch (Exception e) {
            }
        }
        return firebaseUser;
    }

    public final void zzf(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        Object zzh = zzh(firebaseUser);
        if (!TextUtils.isEmpty(zzh)) {
            this.zzbhh.edit().putString("com.google.firebase.auth.FIREBASE_USER", zzh).apply();
        }
    }

    public final zzdym zzg(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        String string = this.zzbhh.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), null);
        return string != null ? zzdym.zzpa(string) : null;
    }
}
