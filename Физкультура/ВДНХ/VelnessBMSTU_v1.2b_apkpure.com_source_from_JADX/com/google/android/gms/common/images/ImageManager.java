package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzbfl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzfwr = new Object();
    private static HashSet<Uri> zzfws = new HashSet();
    private static ImageManager zzfwt;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzfwu = Executors.newFixedThreadPool(4);
    private final zza zzfwv = null;
    private final zzbfl zzfww = new zzbfl();
    private final Map<zza, ImageReceiver> zzfwx = new HashMap();
    private final Map<Uri, ImageReceiver> zzfwy = new HashMap();
    private final Map<Uri, Long> zzfwz = new HashMap();

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzfxa = new ArrayList();
        private /* synthetic */ ImageManager zzfxb;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzfxb = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            this.zzfxb.zzfwu.execute(new zzb(this.zzfxb, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zzakd() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzfxb.mContext.sendBroadcast(intent);
        }

        public final void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzc.zzge("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzfxa.add(com_google_android_gms_common_images_zza);
        }

        public final void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzc.zzge("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzfxa.remove(com_google_android_gms_common_images_zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private /* synthetic */ ImageManager zzfxb;
        private final ParcelFileDescriptor zzfxc;

        public zzb(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzfxb = imageManager;
            this.mUri = uri;
            this.zzfxc = parcelFileDescriptor;
        }

        public final void run() {
            String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                String valueOf = String.valueOf(Thread.currentThread());
                String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
                Log.e("Asserts", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("checkNotMainThread: current thread ").append(valueOf).append(" IS the main thread ").append(valueOf2).append("!").toString());
                throw new IllegalStateException(str);
            }
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzfxc != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzfxc.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf3 = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf3).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf3).toString(), e);
                    z = true;
                }
                try {
                    this.zzfxc.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzfxb.mHandler.post(new zzd(this.zzfxb, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf4 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf4).length() + 32).append("Latch interrupted while posting ").append(valueOf4).toString());
            }
        }
    }

    final class zzc implements Runnable {
        private /* synthetic */ ImageManager zzfxb;
        private final zza zzfxd;

        public zzc(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.zzfxb = imageManager;
            this.zzfxd = com_google_android_gms_common_images_zza;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzge("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzfxb.zzfwx.get(this.zzfxd);
            if (imageReceiver != null) {
                this.zzfxb.zzfwx.remove(this.zzfxd);
                imageReceiver.zzc(this.zzfxd);
            }
            zzb com_google_android_gms_common_images_zzb = this.zzfxd.zzfxf;
            if (com_google_android_gms_common_images_zzb.uri == null) {
                this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww, true);
                return;
            }
            Bitmap zza = this.zzfxb.zza(com_google_android_gms_common_images_zzb);
            if (zza != null) {
                this.zzfxd.zza(this.zzfxb.mContext, zza, true);
                return;
            }
            Long l = (Long) this.zzfxb.zzfwz.get(com_google_android_gms_common_images_zzb.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww, true);
                    return;
                }
                this.zzfxb.zzfwz.remove(com_google_android_gms_common_images_zzb.uri);
            }
            this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww);
            imageReceiver = (ImageReceiver) this.zzfxb.zzfwy.get(com_google_android_gms_common_images_zzb.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzfxb, com_google_android_gms_common_images_zzb.uri);
                this.zzfxb.zzfwy.put(com_google_android_gms_common_images_zzb.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzfxd);
            if (!(this.zzfxd instanceof zzd)) {
                this.zzfxb.zzfwx.put(this.zzfxd, imageReceiver);
            }
            synchronized (ImageManager.zzfwr) {
                if (!ImageManager.zzfws.contains(com_google_android_gms_common_images_zzb.uri)) {
                    ImageManager.zzfws.add(com_google_android_gms_common_images_zzb.uri);
                    imageReceiver.zzakd();
                }
            }
        }
    }

    final class zzd implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzapd;
        private /* synthetic */ ImageManager zzfxb;
        private boolean zzfxe;

        public zzd(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzfxb = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzfxe = z;
            this.zzapd = countDownLatch;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzge("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzfxb.zzfwv != null) {
                if (this.zzfxe) {
                    this.zzfxb.zzfwv.evictAll();
                    System.gc();
                    this.zzfxe = false;
                    this.zzfxb.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzfxb.zzfwv.put(new zzb(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzfxb.zzfwy.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzfxa;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                    if (z) {
                        com_google_android_gms_common_images_zza.zza(this.zzfxb.mContext, this.mBitmap, false);
                    } else {
                        this.zzfxb.zzfwz.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        com_google_android_gms_common_images_zza.zza(this.zzfxb.mContext, this.zzfxb.zzfww, false);
                    }
                    if (!(com_google_android_gms_common_images_zza instanceof zzd)) {
                        this.zzfxb.zzfwx.remove(com_google_android_gms_common_images_zza);
                    }
                }
            }
            this.zzapd.countDown();
            synchronized (ImageManager.zzfwr) {
                ImageManager.zzfws.remove(this.mUri);
            }
        }
    }

    static final class zza extends LruCache<zzb, Bitmap> {
        protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (zzb) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public static ImageManager create(Context context) {
        if (zzfwt == null) {
            zzfwt = new ImageManager(context, false);
        }
        return zzfwt;
    }

    private final Bitmap zza(zzb com_google_android_gms_common_images_zzb) {
        return this.zzfwv == null ? null : (Bitmap) this.zzfwv.get(com_google_android_gms_common_images_zzb);
    }

    private final void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzc.zzge("ImageManager.loadImage() must be called in the main thread");
        new zzc(this, com_google_android_gms_common_images_zza).run();
    }

    public final void loadImage(ImageView imageView, int i) {
        zza(new zzc(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zza(new zzc(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zza com_google_android_gms_common_images_zzc = new zzc(imageView, uri);
        com_google_android_gms_common_images_zzc.zzfxh = i;
        zza(com_google_android_gms_common_images_zzc);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zzd(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza com_google_android_gms_common_images_zzd = new zzd(onImageLoadedListener, uri);
        com_google_android_gms_common_images_zzd.zzfxh = i;
        zza(com_google_android_gms_common_images_zzd);
    }
}
