package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzo;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final zzb zzitu;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private zzo<zza> zzisu;
        private final ViewGroup zzita;
        private final Context zzitb;
        private final List<OnStreetViewPanoramaReadyCallback> zzitm = new ArrayList();
        private final StreetViewPanoramaOptions zzitx;

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzita = viewGroup;
            this.zzitb = context;
            this.zzitx = streetViewPanoramaOptions;
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzapw() != null) {
                ((zza) zzapw()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.zzitm.add(onStreetViewPanoramaReadyCallback);
            }
        }

        protected final void zza(zzo<zza> com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_StreetViewPanoramaView_zza) {
            this.zzisu = com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_StreetViewPanoramaView_zza;
            if (this.zzisu != null && zzapw() == null) {
                try {
                    MapsInitializer.initialize(this.zzitb);
                    this.zzisu.zza(new zza(this.zzita, zzbz.zzdt(this.zzitb).zza(zzn.zzz(this.zzitb), this.zzitx)));
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
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final ViewGroup zzisx;
        private final IStreetViewPanoramaViewDelegate zzitv;
        private View zzitw;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzitv = (IStreetViewPanoramaViewDelegate) zzbq.checkNotNull(iStreetViewPanoramaViewDelegate);
            this.zzisx = (ViewGroup) zzbq.checkNotNull(viewGroup);
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.zzitv.getStreetViewPanoramaAsync(new zzaj(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zzitv.onCreate(bundle2);
                zzby.zzd(bundle2, bundle);
                this.zzitw = (View) zzn.zzx(this.zzitv.getView());
                this.zzisx.removeAllViews();
                this.zzisx.addView(this.zzitw);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onDestroy() {
            try {
                this.zzitv.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onLowMemory() {
            try {
                this.zzitv.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.zzitv.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.zzitv.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zzitv.onSaveInstanceState(bundle2);
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

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.zzitu = new zzb(this, context, streetViewPanoramaOptions);
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzbq.zzge("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzitu.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            this.zzitu.onCreate(bundle);
            if (this.zzitu.zzapw() == null) {
                com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
            }
            StrictMode.setThreadPolicy(threadPolicy);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void onDestroy() {
        this.zzitu.onDestroy();
    }

    public final void onLowMemory() {
        this.zzitu.onLowMemory();
    }

    public final void onPause() {
        this.zzitu.onPause();
    }

    public final void onResume() {
        this.zzitu.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzitu.onSaveInstanceState(bundle);
    }
}
