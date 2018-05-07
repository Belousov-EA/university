package com.google.android.gms.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzal implements zzb {
    private final Map<String, zzam> zzbx;
    private long zzby;
    private final File zzbz;
    private final int zzca;

    public zzal(File file) {
        this(file, 5242880);
    }

    private zzal(File file, int i) {
        this.zzbx = new LinkedHashMap(16, 0.75f, true);
        this.zzby = 0;
        this.zzbz = file;
        this.zzca = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzae.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        zzam com_google_android_gms_internal_zzam = (zzam) this.zzbx.remove(str);
        if (com_google_android_gms_internal_zzam != null) {
            this.zzby -= com_google_android_gms_internal_zzam.zzcb;
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static String zza(zzan com_google_android_gms_internal_zzan) throws IOException {
        return new String(zza(com_google_android_gms_internal_zzan, zzc(com_google_android_gms_internal_zzan)), "UTF-8");
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzam com_google_android_gms_internal_zzam) {
        if (this.zzbx.containsKey(str)) {
            zzam com_google_android_gms_internal_zzam2 = (zzam) this.zzbx.get(str);
            this.zzby = (com_google_android_gms_internal_zzam.zzcb - com_google_android_gms_internal_zzam2.zzcb) + this.zzby;
        } else {
            this.zzby += com_google_android_gms_internal_zzam.zzcb;
        }
        this.zzbx.put(str, com_google_android_gms_internal_zzam);
    }

    private static byte[] zza(zzan com_google_android_gms_internal_zzan, long j) throws IOException {
        long zzn = com_google_android_gms_internal_zzan.zzn();
        if (j < 0 || j > zzn || ((long) ((int) j)) != j) {
            throw new IOException("streamToBytes length=" + j + ", maxLength=" + zzn);
        }
        byte[] bArr = new byte[((int) j)];
        new DataInputStream(com_google_android_gms_internal_zzan).readFully(bArr);
        return bArr;
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (((zza(inputStream) | 0) | (zza(inputStream) << 8)) | (zza(inputStream) << 16)) | (zza(inputStream) << 24);
    }

    static List<zzl> zzb(zzan com_google_android_gms_internal_zzan) throws IOException {
        int zzb = zzb((InputStream) com_google_android_gms_internal_zzan);
        List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyList.add(new zzl(zza(com_google_android_gms_internal_zzan).intern(), zza(com_google_android_gms_internal_zzan).intern()));
        }
        return emptyList;
    }

    static long zzc(InputStream inputStream) throws IOException {
        return (((((((0 | (((long) zza(inputStream)) & 255)) | ((((long) zza(inputStream)) & 255) << 8)) | ((((long) zza(inputStream)) & 255) << 16)) | ((((long) zza(inputStream)) & 255) << 24)) | ((((long) zza(inputStream)) & 255) << 32)) | ((((long) zza(inputStream)) & 255) << 40)) | ((((long) zza(inputStream)) & 255) << 48)) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbz, zzd(str));
    }

    public final synchronized void initialize() {
        if (this.zzbz.exists()) {
            File[] listFiles = this.zzbz.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    zzan com_google_android_gms_internal_zzan;
                    try {
                        long length = file.length();
                        com_google_android_gms_internal_zzan = new zzan(new BufferedInputStream(zza(file)), length);
                        zzam zzc = zzam.zzc(com_google_android_gms_internal_zzan);
                        zzc.zzcb = length;
                        zza(zzc.key, zzc);
                        com_google_android_gms_internal_zzan.close();
                    } catch (IOException e) {
                        file.delete();
                    } catch (Throwable th) {
                        com_google_android_gms_internal_zzan.close();
                    }
                }
            }
        } else if (!this.zzbz.mkdirs()) {
            zzae.zzc("Unable to create cache dir %s", this.zzbz.getAbsolutePath());
        }
    }

    public final synchronized zzc zza(String str) {
        zzc com_google_android_gms_internal_zzc;
        zzam com_google_android_gms_internal_zzam = (zzam) this.zzbx.get(str);
        if (com_google_android_gms_internal_zzam == null) {
            com_google_android_gms_internal_zzc = null;
        } else {
            File zze = zze(str);
            zzan com_google_android_gms_internal_zzan;
            try {
                com_google_android_gms_internal_zzan = new zzan(new BufferedInputStream(zza(zze)), zze.length());
                if (TextUtils.equals(str, zzam.zzc(com_google_android_gms_internal_zzan).key)) {
                    byte[] zza = zza(com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzan.zzn());
                    zzc com_google_android_gms_internal_zzc2 = new zzc();
                    com_google_android_gms_internal_zzc2.data = zza;
                    com_google_android_gms_internal_zzc2.zza = com_google_android_gms_internal_zzam.zza;
                    com_google_android_gms_internal_zzc2.zzb = com_google_android_gms_internal_zzam.zzb;
                    com_google_android_gms_internal_zzc2.zzc = com_google_android_gms_internal_zzam.zzc;
                    com_google_android_gms_internal_zzc2.zzd = com_google_android_gms_internal_zzam.zzd;
                    com_google_android_gms_internal_zzc2.zze = com_google_android_gms_internal_zzam.zze;
                    com_google_android_gms_internal_zzc2.zzf = zzao.zza(com_google_android_gms_internal_zzam.zzg);
                    com_google_android_gms_internal_zzc2.zzg = Collections.unmodifiableList(com_google_android_gms_internal_zzam.zzg);
                    com_google_android_gms_internal_zzan.close();
                    com_google_android_gms_internal_zzc = com_google_android_gms_internal_zzc2;
                } else {
                    zzae.zzb("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzam.zzc(com_google_android_gms_internal_zzan).key);
                    removeEntry(str);
                    com_google_android_gms_internal_zzan.close();
                    com_google_android_gms_internal_zzc = null;
                }
            } catch (IOException e) {
                zzae.zzb("%s: %s", zze.getAbsolutePath(), e.toString());
                remove(str);
                com_google_android_gms_internal_zzc = null;
            } catch (Throwable th) {
                com_google_android_gms_internal_zzan.close();
            }
        }
        return com_google_android_gms_internal_zzc;
    }

    public final synchronized void zza(String str, zzc com_google_android_gms_internal_zzc) {
        int i = 0;
        synchronized (this) {
            int length = com_google_android_gms_internal_zzc.data.length;
            if (this.zzby + ((long) length) >= ((long) this.zzca)) {
                int i2;
                if (zzae.DEBUG) {
                    zzae.zza("Pruning old cache entries.", new Object[0]);
                }
                long j = this.zzby;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.zzbx.entrySet().iterator();
                while (it.hasNext()) {
                    zzam com_google_android_gms_internal_zzam = (zzam) ((Entry) it.next()).getValue();
                    if (zze(com_google_android_gms_internal_zzam.key).delete()) {
                        this.zzby -= com_google_android_gms_internal_zzam.zzcb;
                    } else {
                        zzae.zzb("Could not delete cache entry for key=%s, filename=%s", com_google_android_gms_internal_zzam.key, zzd(com_google_android_gms_internal_zzam.key));
                    }
                    it.remove();
                    i2 = i + 1;
                    if (((float) (this.zzby + ((long) length))) < ((float) this.zzca) * 0.9f) {
                        break;
                    }
                    i = i2;
                }
                i2 = i;
                if (zzae.DEBUG) {
                    zzae.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzby - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File zze = zze(str);
            try {
                OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zze));
                zzam com_google_android_gms_internal_zzam2 = new zzam(str, com_google_android_gms_internal_zzc);
                if (com_google_android_gms_internal_zzam2.zza(bufferedOutputStream)) {
                    bufferedOutputStream.write(com_google_android_gms_internal_zzc.data);
                    bufferedOutputStream.close();
                    zza(str, com_google_android_gms_internal_zzam2);
                } else {
                    bufferedOutputStream.close();
                    zzae.zzb("Failed to write header for %s", zze.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException e) {
                if (!zze.delete()) {
                    zzae.zzb("Could not clean up file %s", zze.getAbsolutePath());
                }
            }
        }
    }
}
