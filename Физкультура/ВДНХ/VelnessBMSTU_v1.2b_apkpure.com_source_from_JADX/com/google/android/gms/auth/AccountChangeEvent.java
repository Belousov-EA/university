package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class AccountChangeEvent extends zzbfm {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    private int mVersion;
    private long zzebu;
    private String zzebv;
    private int zzebw;
    private int zzebx;
    private String zzeby;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzebu = j;
        this.zzebv = (String) zzbq.checkNotNull(str);
        this.zzebw = i2;
        this.zzebx = i3;
        this.zzeby = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzebu = j;
        this.zzebv = (String) zzbq.checkNotNull(str);
        this.zzebw = i;
        this.zzebx = i2;
        this.zzeby = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzebu == accountChangeEvent.zzebu && zzbg.equal(this.zzebv, accountChangeEvent.zzebv) && this.zzebw == accountChangeEvent.zzebw && this.zzebx == accountChangeEvent.zzebx && zzbg.equal(this.zzeby, accountChangeEvent.zzeby);
    }

    public String getAccountName() {
        return this.zzebv;
    }

    public String getChangeData() {
        return this.zzeby;
    }

    public int getChangeType() {
        return this.zzebw;
    }

    public int getEventIndex() {
        return this.zzebx;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersion), Long.valueOf(this.zzebu), this.zzebv, Integer.valueOf(this.zzebw), Integer.valueOf(this.zzebx), this.zzeby});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzebw) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        String str2 = this.zzebv;
        String str3 = this.zzeby;
        return new StringBuilder(((String.valueOf(str2).length() + 91) + String.valueOf(str).length()) + String.valueOf(str3).length()).append("AccountChangeEvent {accountName = ").append(str2).append(", changeType = ").append(str).append(", changeData = ").append(str3).append(", eventIndex = ").append(this.zzebx).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.mVersion);
        zzbfp.zza(parcel, 2, this.zzebu);
        zzbfp.zza(parcel, 3, this.zzebv, false);
        zzbfp.zzc(parcel, 4, this.zzebw);
        zzbfp.zzc(parcel, 5, this.zzebx);
        zzbfp.zza(parcel, 6, this.zzeby, false);
        zzbfp.zzai(parcel, zze);
    }
}
