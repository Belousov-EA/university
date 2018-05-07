package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class zzd extends zza {
    private WeakReference<OnImageLoadedListener> zzfxn;

    public zzd(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        zzc.zzv(onImageLoadedListener);
        this.zzfxn = new WeakReference(onImageLoadedListener);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzd com_google_android_gms_common_images_zzd = (zzd) obj;
        OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzfxn.get();
        OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zzd.zzfxn.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && zzbg.equal(onImageLoadedListener2, onImageLoadedListener) && zzbg.equal(com_google_android_gms_common_images_zzd.zzfxf, this.zzfxf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzfxf});
    }

    protected final void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
        if (!z2) {
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzfxn.get();
            if (onImageLoadedListener != null) {
                onImageLoadedListener.onImageLoaded(this.zzfxf.uri, drawable, z3);
            }
        }
    }
}
