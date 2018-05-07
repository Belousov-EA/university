package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzo;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class MapFragment extends Fragment {
    private final zzb zzisr = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final Fragment zzgwm;
        private zzo<zza> zzisu;
        private final List<OnMapReadyCallback> zzisv = new ArrayList();

        zzb(Fragment fragment) {
            this.zzgwm = fragment;
        }

        private final void setActivity(Activity activity) {
            this.mActivity = activity;
            zzawb();
        }

        private final void zzawb() {
            if (this.mActivity != null && this.zzisu != null && zzapw() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    IMapFragmentDelegate zzaa = zzbz.zzdt(this.mActivity).zzaa(zzn.zzz(this.mActivity));
                    if (zzaa != null) {
                        this.zzisu.zza(new zza(this.zzgwm, zzaa));
                        for (OnMapReadyCallback mapAsync : this.zzisv) {
                            ((zza) zzapw()).getMapAsync(mapAsync);
                        }
                        this.zzisv.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzapw() != null) {
                ((zza) zzapw()).getMapAsync(onMapReadyCallback);
            } else {
                this.zzisv.add(onMapReadyCallback);
            }
        }

        protected final void zza(zzo<zza> com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_MapFragment_zza) {
            this.zzisu = com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_MapFragment_zza;
            zzawb();
        }
    }

    static class zza implements MapLifecycleDelegate {
        private final Fragment zzgwm;
        private final IMapFragmentDelegate zziss;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zziss = (IMapFragmentDelegate) zzbq.checkNotNull(iMapFragmentDelegate);
            this.zzgwm = (Fragment) zzbq.checkNotNull(fragment);
        }

        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zziss.getMapAsync(new zzab(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                Bundle arguments = this.zzgwm.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    zzby.zza(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.zziss.onCreate(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                IObjectWrapper onCreateView = this.zziss.onCreateView(zzn.zzz(layoutInflater), zzn.zzz(viewGroup), bundle2);
                zzby.zzd(bundle2, bundle);
                return (View) zzn.zzx(onCreateView);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroy() {
            try {
                this.zziss.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            try {
                this.zziss.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onEnterAmbient(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zziss.onEnterAmbient(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onExitAmbient() {
            try {
                this.zziss.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                zzby.zzd(bundle2, bundle3);
                this.zziss.onInflate(zzn.zzz(activity), googleMapOptions, bundle3);
                zzby.zzd(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onLowMemory() {
            try {
                this.zziss.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.zziss.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.zziss.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zziss.onSaveInstanceState(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
            try {
                this.zziss.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStop() {
            try {
                this.zziss.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzbq.zzge("getMapAsync must be called on the main thread.");
        this.zzisr.getMapAsync(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzisr.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzisr.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.zzisr.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzisr.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzisr.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzbq.zzge("onEnterAmbient must be called on the main thread.");
        com.google.android.gms.dynamic.zza com_google_android_gms_dynamic_zza = this.zzisr;
        if (com_google_android_gms_dynamic_zza.zzapw() != null) {
            ((zza) com_google_android_gms_dynamic_zza.zzapw()).onEnterAmbient(bundle);
        }
    }

    public final void onExitAmbient() {
        zzbq.zzge("onExitAmbient must be called on the main thread.");
        com.google.android.gms.dynamic.zza com_google_android_gms_dynamic_zza = this.zzisr;
        if (com_google_android_gms_dynamic_zza.zzapw() != null) {
            ((zza) com_google_android_gms_dynamic_zza.zzapw()).onExitAmbient();
        }
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.zzisr.setActivity(activity);
            Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", createFromAttributes);
            this.zzisr.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.zzisr.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzisr.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzisr.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzisr.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.zzisr.onStart();
    }

    public void onStop() {
        this.zzisr.onStop();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
