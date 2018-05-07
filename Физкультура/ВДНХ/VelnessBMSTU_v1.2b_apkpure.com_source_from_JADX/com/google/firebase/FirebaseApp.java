package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final Object sLock = new Object();
    static final Map<String, FirebaseApp> zzifg = new ArrayMap();
    private static final List<String> zzman = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzmao = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzmap = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zzmaq = Arrays.asList(new String[0]);
    private static final Set<String> zzmar = Collections.emptySet();
    private final Context mApplicationContext;
    private final String mName;
    private final FirebaseOptions zzmas;
    private final AtomicBoolean zzmat = new AtomicBoolean(false);
    private final AtomicBoolean zzmau = new AtomicBoolean();
    private final List<IdTokenListener> zzmav = new CopyOnWriteArrayList();
    private final List<zza> zzmaw = new CopyOnWriteArrayList();
    private final List<Object> zzmax = new CopyOnWriteArrayList();
    private InternalTokenProvider zzmay;
    private zzb zzmaz;

    @KeepForSdk
    public interface IdTokenListener {
        void zzb(@NonNull com.google.firebase.internal.zzc com_google_firebase_internal_zzc);
    }

    public interface zza {
        void zzbf(boolean z);
    }

    public interface zzb {
        void zzgj(int i);
    }

    @TargetApi(24)
    static class zzc extends BroadcastReceiver {
        private static AtomicReference<zzc> zzmba = new AtomicReference();
        private final Context mApplicationContext;

        private zzc(Context context) {
            this.mApplicationContext = context;
        }

        private static void zzer(Context context) {
            if (zzmba.get() == null) {
                BroadcastReceiver com_google_firebase_FirebaseApp_zzc = new zzc(context);
                if (zzmba.compareAndSet(null, com_google_firebase_FirebaseApp_zzc)) {
                    context.registerReceiver(com_google_firebase_FirebaseApp_zzc, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.sLock) {
                for (FirebaseApp zza : FirebaseApp.zzifg.values()) {
                    zza.zzbqr();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.mApplicationContext = (Context) zzbq.checkNotNull(context);
        this.mName = zzbq.zzgm(str);
        this.zzmas = (FirebaseOptions) zzbq.checkNotNull(firebaseOptions);
        this.zzmaz = new com.google.firebase.internal.zza();
    }

    public static List<FirebaseApp> getApps(Context context) {
        List<FirebaseApp> arrayList;
        com.google.firebase.internal.zzb.zzew(context);
        synchronized (sLock) {
            arrayList = new ArrayList(zzifg.values());
            com.google.firebase.internal.zzb.zzcjr();
            Set<String> zzcjs = com.google.firebase.internal.zzb.zzcjs();
            zzcjs.removeAll(zzifg.keySet());
            for (String str : zzcjs) {
                com.google.firebase.internal.zzb.zzrq(str);
                arrayList.add(initializeApp(context, null, str));
            }
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzifg.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                String zzamo = zzs.zzamo();
                throw new IllegalStateException(new StringBuilder(String.valueOf(zzamo).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(zzamo).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzifg.get(str.trim());
            if (firebaseApp != null) {
            } else {
                String str2;
                Iterable zzbqq = zzbqq();
                if (zzbqq.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(TextUtils.join(", ", zzbqq));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(Context context) {
        FirebaseApp instance;
        synchronized (sLock) {
            if (zzifg.containsKey(DEFAULT_APP_NAME)) {
                instance = getInstance();
            } else {
                FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
                if (fromResource == null) {
                    instance = null;
                } else {
                    instance = initializeApp(context, fromResource);
                }
            }
        }
        return instance;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        com.google.firebase.internal.zzb.zzew(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.zza((Application) context.getApplicationContext());
            zzk.zzahb().zza(new zza());
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            zzbq.zza(!zzifg.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
            zzbq.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            zzifg.put(trim, firebaseApp);
        }
        com.google.firebase.internal.zzb.zzg(firebaseApp);
        firebaseApp.zza(FirebaseApp.class, firebaseApp, zzman);
        if (firebaseApp.zzbqo()) {
            firebaseApp.zza(FirebaseApp.class, firebaseApp, zzmao);
            firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), zzmap);
        }
        return firebaseApp;
    }

    private final <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.mApplicationContext);
        if (isDeviceProtectedStorage) {
            zzc.zzer(this.mApplicationContext);
        }
        for (String valueOf2 : iterable) {
            if (isDeviceProtectedStorage) {
                try {
                    if (!zzmaq.contains(valueOf2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (zzmar.contains(valueOf2)) {
                        throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str = "FirebaseApp";
                    String str2 = "Failed to initialize ";
                    valueOf2 = String.valueOf(valueOf2);
                    Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
                }
            }
            Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static void zzbf(boolean z) {
        synchronized (sLock) {
            ArrayList arrayList = new ArrayList(zzifg.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.zzmat.get()) {
                    firebaseApp.zzcd(z);
                }
            }
        }
    }

    private final void zzbqn() {
        zzbq.zza(!this.zzmau.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzbqq() {
        Collection arraySet = new ArraySet();
        synchronized (sLock) {
            for (FirebaseApp name : zzifg.values()) {
                arraySet.add(name.getName());
            }
            if (com.google.firebase.internal.zzb.zzcjr() != null) {
                arraySet.addAll(com.google.firebase.internal.zzb.zzcjs());
            }
        }
        List<String> arrayList = new ArrayList(arraySet);
        Collections.sort(arrayList);
        return arrayList;
    }

    private final void zzbqr() {
        zza(FirebaseApp.class, this, zzman);
        if (zzbqo()) {
            zza(FirebaseApp.class, this, zzmao);
            zza(Context.class, this.mApplicationContext, zzmap);
        }
    }

    private final void zzcd(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zza zzbf : this.zzmaw) {
            zzbf.zzbf(z);
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof FirebaseApp) ? false : this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzbqn();
        return this.mApplicationContext;
    }

    @NonNull
    public String getName() {
        zzbqn();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzbqn();
        return this.zzmas;
    }

    @KeepForSdk
    public Task<GetTokenResult> getToken(boolean z) {
        zzbqn();
        return this.zzmay == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.zzmay.zzce(z);
    }

    @Nullable
    public final String getUid() throws FirebaseApiNotAvailableException {
        zzbqn();
        if (this.zzmay != null) {
            return this.zzmay.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        zzbqn();
        if (this.zzmat.compareAndSet(!z, z)) {
            boolean zzahc = zzk.zzahb().zzahc();
            if (z && zzahc) {
                zzcd(true);
            } else if (!z && zzahc) {
                zzcd(false);
            }
        }
    }

    public String toString() {
        return zzbg.zzx(this).zzg("name", this.mName).zzg("options", this.zzmas).toString();
    }

    public final void zza(@NonNull IdTokenListener idTokenListener) {
        zzbqn();
        zzbq.checkNotNull(idTokenListener);
        this.zzmav.add(idTokenListener);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final void zza(zza com_google_firebase_FirebaseApp_zza) {
        zzbqn();
        if (this.zzmat.get() && zzk.zzahb().zzahc()) {
            com_google_firebase_FirebaseApp_zza.zzbf(true);
        }
        this.zzmaw.add(com_google_firebase_FirebaseApp_zza);
    }

    public final void zza(@NonNull zzb com_google_firebase_FirebaseApp_zzb) {
        this.zzmaz = (zzb) zzbq.checkNotNull(com_google_firebase_FirebaseApp_zzb);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final void zza(@NonNull InternalTokenProvider internalTokenProvider) {
        this.zzmay = (InternalTokenProvider) zzbq.checkNotNull(internalTokenProvider);
    }

    @UiThread
    public final void zza(@NonNull com.google.firebase.internal.zzc com_google_firebase_internal_zzc) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (IdTokenListener zzb : this.zzmav) {
            zzb.zzb(com_google_firebase_internal_zzc);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public final void zzb(@NonNull IdTokenListener idTokenListener) {
        zzbqn();
        zzbq.checkNotNull(idTokenListener);
        this.zzmav.remove(idTokenListener);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final boolean zzbqo() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public final String zzbqp() {
        String zzm = com.google.android.gms.common.util.zzb.zzm(getName().getBytes());
        String zzm2 = com.google.android.gms.common.util.zzb.zzm(getOptions().getApplicationId().getBytes());
        return new StringBuilder((String.valueOf(zzm).length() + 1) + String.valueOf(zzm2).length()).append(zzm).append("+").append(zzm2).toString();
    }
}
