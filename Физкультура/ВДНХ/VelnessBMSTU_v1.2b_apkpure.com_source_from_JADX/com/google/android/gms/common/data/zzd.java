package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder.zza;
import com.google.android.gms.internal.zzbfq;

public class zzd<T extends zzbfq> extends AbstractDataBuffer<T> {
    private static final String[] zzfvz = new String[]{"data"};
    private final Creator<T> zzfwa;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zzfwa = creator;
    }

    public static <T extends zzbfq> void zza(zza com_google_android_gms_common_data_DataHolder_zza, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        com_google_android_gms_common_data_DataHolder_zza.zza(contentValues);
        obtain.recycle();
    }

    public static zza zzajy() {
        return DataHolder.zzb(zzfvz);
    }

    public /* synthetic */ Object get(int i) {
        return zzby(i);
    }

    public T zzby(int i) {
        byte[] zzg = this.zzfqt.zzg("data", i, this.zzfqt.zzbz(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        zzbfq com_google_android_gms_internal_zzbfq = (zzbfq) this.zzfwa.createFromParcel(obtain);
        obtain.recycle();
        return com_google_android_gms_internal_zzbfq;
    }
}
