package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbfl;

public abstract class zza {
    final zzb zzfxf;
    private int zzfxg = 0;
    protected int zzfxh = 0;
    private boolean zzfxi = false;
    private boolean zzfxj = true;
    private boolean zzfxk = false;
    private boolean zzfxl = true;

    public zza(Uri uri, int i) {
        this.zzfxf = new zzb(uri);
        this.zzfxh = i;
    }

    final void zza(Context context, Bitmap bitmap, boolean z) {
        zzc.zzv(bitmap);
        zza(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    final void zza(Context context, zzbfl com_google_android_gms_internal_zzbfl) {
        if (this.zzfxl) {
            zza(null, false, true, false);
        }
    }

    final void zza(Context context, zzbfl com_google_android_gms_internal_zzbfl, boolean z) {
        Drawable drawable = null;
        if (this.zzfxh != 0) {
            drawable = context.getResources().getDrawable(this.zzfxh);
        }
        zza(drawable, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected final boolean zzc(boolean z, boolean z2) {
        return (!this.zzfxj || z2 || z) ? false : true;
    }
}
