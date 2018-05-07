package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
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
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class StreetViewPanoramaFragment extends Fragment {
    private final zzb zzitj = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final Fragment zzgwm;
        private zzo<zza> zzisu;
        private final List<OnStreetViewPanoramaReadyCallback> zzitm = new ArrayList();

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
                    this.zzisu.zza(new zza(this.zzgwm, zzbz.zzdt(this.mActivity).zzab(zzn.zzz(this.mActivity))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzitm) {
                        ((zza) zzapw()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.zzitm.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzapw() != null) {
                ((zza) zzapw()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.zzitm.add(onStreetViewPanoramaReadyCallback);
            }
        }

        protected final void zza(zzo<zza> com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_StreetViewPanoramaFragment_zza) {
            this.zzisu = com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_StreetViewPanoramaFragment_zza;
            zzawb();
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final Fragment zzgwm;
        private final IStreetViewPanoramaFragmentDelegate zzitk;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzitk = (IStreetViewPanoramaFragmentDelegate) zzbq.checkNotNull(iStreetViewPanoramaFragmentDelegate);
            this.zzgwm = (Fragment) zzbq.checkNotNull(fragment);
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.zzitk.getStreetViewPanoramaAsync(new zzah(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                Bundle arguments = this.zzgwm.getArguments();
                if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                    zzby.zza(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
                }
                this.zzitk.onCreate(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                IObjectWrapper onCreateView = this.zzitk.onCreateView(zzn.zzz(layoutInflater), zzn.zzz(viewGroup), bundle2);
                zzby.zzd(bundle2, bundle);
                return (View) zzn.zzx(onCreateView);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroy() {
            try {
                this.zzitk.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            try {
                this.zzitk.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                Bundle bundle3 = new Bundle();
                zzby.zzd(bundle2, bundle3);
                this.zzitk.onInflate(zzn.zzz(activity), null, bundle3);
                zzby.zzd(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onLowMemory() {
            try {
                this.zzitk.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.zzitk.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.zzitk.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zzitk.onSaveInstanceState(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
        }

        public final void onStop() {
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzbq.zzge("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzitj.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzitj.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzitj.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzitj.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.zzitj.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzitj.onDestroyView();
        super.onDestroyView();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.zzitj.setActivity(activity);
            this.zzitj.onInflate(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.zzitj.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzitj.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzitj.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzitj.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
