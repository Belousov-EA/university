package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v7.widget.helper.ItemTouchHelper;

public final class zzbff extends Drawable implements Callback {
    private int mAlpha;
    private int mFrom;
    private long zzdvq;
    private boolean zzfxj;
    private int zzfxo;
    private int zzfxp;
    private int zzfxq;
    private int zzfxr;
    private boolean zzfxs;
    private zzbfj zzfxt;
    private Drawable zzfxu;
    private Drawable zzfxv;
    private boolean zzfxw;
    private boolean zzfxx;
    private boolean zzfxy;
    private int zzfxz;

    public zzbff(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zzbfh.zzfya;
        }
        this.zzfxu = drawable;
        drawable.setCallback(this);
        zzbfj com_google_android_gms_internal_zzbfj = this.zzfxt;
        com_google_android_gms_internal_zzbfj.zzfyc |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zzbfh.zzfya;
        }
        this.zzfxv = drawable2;
        drawable2.setCallback(this);
        com_google_android_gms_internal_zzbfj = this.zzfxt;
        com_google_android_gms_internal_zzbfj.zzfyc |= drawable2.getChangingConfigurations();
    }

    zzbff(zzbfj com_google_android_gms_internal_zzbfj) {
        this.zzfxo = 0;
        this.zzfxq = 255;
        this.mAlpha = 0;
        this.zzfxj = true;
        this.zzfxt = new zzbfj(com_google_android_gms_internal_zzbfj);
    }

    private final boolean canConstantState() {
        if (!this.zzfxw) {
            boolean z = (this.zzfxu.getConstantState() == null || this.zzfxv.getConstantState() == null) ? false : true;
            this.zzfxx = z;
            this.zzfxw = true;
        }
        return this.zzfxx;
    }

    public final void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.zzfxo) {
            case 1:
                this.zzdvq = SystemClock.uptimeMillis();
                this.zzfxo = 2;
                break;
            case 2:
                if (this.zzdvq >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzdvq)) / ((float) this.zzfxr);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzfxo = 0;
                    }
                    this.mAlpha = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) this.zzfxp)) + 0.0f);
                    break;
                }
                break;
        }
        i2 = i;
        i = this.mAlpha;
        boolean z = this.zzfxj;
        Drawable drawable = this.zzfxu;
        Drawable drawable2 = this.zzfxv;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzfxq) {
                drawable2.setAlpha(this.zzfxq);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzfxq - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzfxq);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzfxq);
        }
        invalidateSelf();
    }

    public final int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.zzfxt.mChangingConfigurations) | this.zzfxt.zzfyc;
    }

    public final ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzfxt.mChangingConfigurations = getChangingConfigurations();
        return this.zzfxt;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zzfxu.getIntrinsicHeight(), this.zzfxv.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zzfxu.getIntrinsicWidth(), this.zzfxv.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zzfxy) {
            this.zzfxz = Drawable.resolveOpacity(this.zzfxu.getOpacity(), this.zzfxv.getOpacity());
            this.zzfxy = true;
        }
        return this.zzfxz;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (!this.zzfxs && super.mutate() == this) {
            if (canConstantState()) {
                this.zzfxu.mutate();
                this.zzfxv.mutate();
                this.zzfxs = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected final void onBoundsChange(Rect rect) {
        this.zzfxu.setBounds(rect);
        this.zzfxv.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.mAlpha == this.zzfxq) {
            this.mAlpha = i;
        }
        this.zzfxq = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzfxu.setColorFilter(colorFilter);
        this.zzfxv.setColorFilter(colorFilter);
    }

    public final void startTransition(int i) {
        this.mFrom = 0;
        this.zzfxp = this.zzfxq;
        this.mAlpha = 0;
        this.zzfxr = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.zzfxo = 1;
        invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zzake() {
        return this.zzfxv;
    }
}
