package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v4.app.Fragment;
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

public class SupportStreetViewPanoramaFragment extends Fragment {
    private final zzb zzitz = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final Fragment zzgwp;
        private zzo<zza> zzisu;
        private final List<OnStreetViewPanoramaReadyCallback> zzitm = new ArrayList();

        zzb(Fragment fragment) {
            this.zzgwp = fragment;
        }

        private final void setActivity(Activity activity) {
            this.mActivity = activity;
            zzawb();
        }

        private final void zzawb() {
            if (this.mActivity != null && this.zzisu != null && zzapw() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    this.zzisu.zza(new zza(this.zzgwp, zzbz.zzdt(this.mActivity).zzab(zzn.zzz(this.mActivity))));
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

        protected final void zza(zzo<zza> com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_SupportStreetViewPanoramaFragment_zza) {
            this.zzisu = com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_SupportStreetViewPanoramaFragment_zza;
            zzawb();
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final Fragment zzgwp;
        private final IStreetViewPanoramaFragmentDelegate zzitk;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzitk = (IStreetViewPanoramaFragmentDelegate) zzbq.checkNotNull(iStreetViewPanoramaFragmentDelegate);
            this.zzgwp = (Fragment) zzbq.checkNotNull(fragment);
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.zzitk.getStreetViewPanoramaAsync(new zzal(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                Bundle arguments = this.zzgwp.getArguments();
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

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzbq.zzge("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzitz.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzitz.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzitz.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzitz.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.zzitz.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzitz.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.zzitz.setActivity(activity);
            this.zzitz.onInflate(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.zzitz.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzitz.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzitz.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzitz.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
