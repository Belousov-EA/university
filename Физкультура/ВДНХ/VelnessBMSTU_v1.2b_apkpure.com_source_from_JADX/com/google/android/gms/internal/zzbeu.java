package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class zzbeu implements zzbeb {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final zzcup zzfkh = new zzcup(zzcue.zzks("com.google.android.gms.clearcut.public")).zzku("gms:playlog:service:sampling_").zzkv("LogSampling__");
    private static Map<String, zzcui<String>> zzfki = null;
    private static Boolean zzfkj = null;
    private static Long zzfkk = null;
    private final Context zzair;

    public zzbeu(Context context) {
        this.zzair = context;
        if (zzfki == null) {
            zzfki = new HashMap();
        }
        if (this.zzair != null) {
            zzcui.zzdz(this.zzair);
        }
    }

    private static boolean zzcb(Context context) {
        if (zzfkj == null) {
            zzfkj = Boolean.valueOf(zzbhf.zzdb(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzfkj.booleanValue();
    }

    private static zzbev zzfw(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str3 = "Failed to parse the rule: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return new zzbev(str2, parseLong, parseLong2);
            }
            Log.e("LogSamplerImpl", "negative values not supported: " + parseLong + "/" + parseLong2);
            return null;
        } catch (Throwable e) {
            Throwable th = e;
            str3 = "LogSamplerImpl";
            String str4 = "parseLong() failed while parsing: ";
            valueOf = String.valueOf(str);
            Log.e(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
            return null;
        }
    }

    public final boolean zzg(String str, int i) {
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        String str2;
        if (this.zzair == null || !zzcb(this.zzair)) {
            str2 = null;
        } else {
            zzcui com_google_android_gms_internal_zzcui = (zzcui) zzfki.get(str);
            if (com_google_android_gms_internal_zzcui == null) {
                com_google_android_gms_internal_zzcui = zzfkh.zzaw(str, null);
                zzfki.put(str, com_google_android_gms_internal_zzcui);
            }
            str2 = (String) com_google_android_gms_internal_zzcui.get();
        }
        zzbev zzfw = zzfw(str2);
        if (zzfw == null) {
            return true;
        }
        long j;
        long j2;
        long j3;
        String str3 = zzfw.zzfkl;
        Context context = this.zzair;
        if (zzfkk == null) {
            if (context == null) {
                j = 0;
                if (str3 != null || str3.isEmpty()) {
                    j = zzbep.zzj(ByteBuffer.allocate(8).putLong(j).array());
                } else {
                    byte[] bytes = str3.getBytes(UTF_8);
                    ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
                    allocate.put(bytes);
                    allocate.putLong(j);
                    j = zzbep.zzj(allocate.array());
                }
                j2 = zzfw.zzfkm;
                j3 = zzfw.zzfkn;
                if (j2 >= 0 || j3 < 0) {
                    throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
                }
                if (j3 > 0) {
                    if ((j >= 0 ? j % j3 : (((j & Long.MAX_VALUE) % j3) + ((Long.MAX_VALUE % j3) + 1)) % j3) < j2) {
                        return true;
                    }
                }
                return false;
            } else if (zzcb(context)) {
                zzfkk = Long.valueOf(zzdmf.getLong(context.getContentResolver(), "android_id", 0));
            } else {
                zzfkk = Long.valueOf(0);
            }
        }
        j = zzfkk.longValue();
        if (str3 != null) {
        }
        j = zzbep.zzj(ByteBuffer.allocate(8).putLong(j).array());
        j2 = zzfw.zzfkm;
        j3 = zzfw.zzfkn;
        if (j2 >= 0) {
        }
        throw new IllegalArgumentException("negative values not supported: " + j2 + "/" + j3);
    }
}
