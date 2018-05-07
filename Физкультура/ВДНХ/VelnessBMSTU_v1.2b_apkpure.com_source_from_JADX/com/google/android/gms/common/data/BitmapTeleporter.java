package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends zzbfm implements ReflectedParcelable {
    public static final Creator<BitmapTeleporter> CREATOR = new zza();
    private ParcelFileDescriptor zzcpy;
    private int zzeck;
    private int zzeie;
    private Bitmap zzfvr;
    private boolean zzfvs;
    private File zzfvt;

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.zzeck = i;
        this.zzcpy = parcelFileDescriptor;
        this.zzeie = i2;
        this.zzfvr = null;
        this.zzfvs = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.zzeck = 1;
        this.zzcpy = null;
        this.zzeie = 0;
        this.zzfvr = bitmap;
        this.zzfvs = true;
    }

    private static void zza(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    private final FileOutputStream zzajx() {
        if (this.zzfvt == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.zzfvt);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.zzcpy = ParcelFileDescriptor.open(createTempFile, 268435456);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    public final void release() {
        if (!this.zzfvs) {
            try {
                this.zzcpy.close();
            } catch (Throwable e) {
                Log.w("BitmapTeleporter", "Could not close PFD", e);
            }
        }
    }

    public final void setTempDir(File file) {
        if (file == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.zzfvt = file;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzcpy == null) {
            Bitmap bitmap = this.zzfvr;
            Buffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            Closeable dataOutputStream = new DataOutputStream(new BufferedOutputStream(zzajx()));
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
            } catch (Throwable e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                zza(dataOutputStream);
            }
        }
        int i2 = i | 1;
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.zzcpy, i2, false);
        zzbfp.zzc(parcel, 3, this.zzeie);
        zzbfp.zzai(parcel, zze);
        this.zzcpy = null;
    }

    public final Bitmap zzajw() {
        if (!this.zzfvs) {
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zzcpy));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Config valueOf = Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                zza(dataInputStream);
                Buffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.zzfvr = createBitmap;
                this.zzfvs = true;
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zza(dataInputStream);
            }
        }
        return this.zzfvr;
    }
}
