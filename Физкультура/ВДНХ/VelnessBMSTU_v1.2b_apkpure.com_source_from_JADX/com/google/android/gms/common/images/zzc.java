package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbff;
import com.google.android.gms.internal.zzbfk;
import java.lang.ref.WeakReference;

public final class zzc extends zza {
    private WeakReference<ImageView> zzfxm;

    public zzc(ImageView imageView, int i) {
        super(null, i);
        com.google.android.gms.common.internal.zzc.zzv(imageView);
        this.zzfxm = new WeakReference(imageView);
    }

    public zzc(ImageView imageView, Uri uri) {
        super(uri, 0);
        com.google.android.gms.common.internal.zzc.zzv(imageView);
        this.zzfxm = new WeakReference(imageView);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ImageView imageView = (ImageView) this.zzfxm.get();
        ImageView imageView2 = (ImageView) ((zzc) obj).zzfxm.get();
        return (imageView2 == null || imageView == null || !zzbg.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    protected final void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
        Uri uri = null;
        ImageView imageView = (ImageView) this.zzfxm.get();
        if (imageView != null) {
            Drawable drawable2;
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zzbfk)) {
                int zzakg = zzbfk.zzakg();
                if (this.zzfxh != 0 && zzakg == this.zzfxh) {
                    return;
                }
            }
            boolean zzc = zzc(z, z2);
            if (zzc) {
                drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zzbff) {
                    drawable2 = ((zzbff) drawable2).zzake();
                }
                drawable2 = new zzbff(drawable2, drawable);
            } else {
                drawable2 = drawable;
            }
            imageView.setImageDrawable(drawable2);
            if (imageView instanceof zzbfk) {
                if (z3) {
                    uri = this.zzfxf.uri;
                }
                zzbfk.zzn(uri);
                zzbfk.zzcd(obj != null ? this.zzfxh : 0);
            }
            if (zzc) {
                ((zzbff) drawable2).startTransition(Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
        }
    }
}
